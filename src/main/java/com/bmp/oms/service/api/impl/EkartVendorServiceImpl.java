package com.bmp.oms.service.api.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.bmp.constant.GlobalConstant;
import com.bmp.dao.StatusMasterDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.jaxbean.EcartTrackingResponseBean;
import com.bmp.model.app.api.jaxbean.DeliveryResponseBean.ShipmentData.Shipment.Scans;
import com.bmp.model.app.api.jaxbean.DeliveryResponseBean.ShipmentData.Shipment.Scans.ScanDetail;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;
import com.bmp.oms.service.api.vendorOrder.impl.EkartApiHelperImpl;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
@Qualifier("ekartVendorServiceImpl")
public class EkartVendorServiceImpl implements VendorService{

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Override
	public VendorStatusBean statusMapping(Object mappedVendorBean, SaleOrder saleOrder,
			VendorStatusMappingBean vendorStatusMappingBean) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		DateFormat pHistoryDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		VendorStatusBean vendorStatusBean = new VendorStatusBean() ;
		EcartTrackingResponseBean ecartTrackingResponseBean = (EcartTrackingResponseBean) mappedVendorBean;
		
		try{
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s()); 
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
			
			/*get vendor statuses in map*/
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
			
			if(ecartTrackingResponseBean != null && ecartTrackingResponseBean.getHistory() != null && ecartTrackingResponseBean.getHistory().size()>0){
                List<EcartTrackingResponseBean.History> historyList = ecartTrackingResponseBean.getHistory();
                Collections.reverse(historyList);
                for(EcartTrackingResponseBean.History scanDetail : historyList){
                	
                	String scanstatus= scanDetail.getStatus();
    				String activity = null;
    				String statusValue = null;
    				String rtoKey = null;
    				if(statusMap.containsKey(scanstatus)){
    					statusValue = statusMap.get(scanstatus);
    				}else{
    					continue;
    				}				
    				if(statusValue.contains("##")) {
    					activity = statusValue.split("##")[0];
    					rtoKey = statusValue.split("##")[1];
    				} else {
    					activity = statusValue;
    				}
    				VendorPacketsHistory history = new VendorPacketsHistory();
    				Date vendordate = dateFormat.parse(scanDetail.getEvent_date());
    				StatusMaster statusMaster = statusMasterDao.getObjectById(activity, StatusMaster.class);
    				history.setActivity(statusMaster.getStatusName());
    				if((scanstatus.contains("rto") || scanstatus.contains("RTO")) && ecartTrackingResponseBean.getRto() != null && ecartTrackingResponseBean.getRto()) {
    					if(!saleOrder.getKey_s().endsWith("RTO") && scanstatus.equals("rto_in_transit")) {
    						activity = messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null);
    					}else if(!saleOrder.getKey_s().endsWith("RTO") && (scanstatus.equals("rto_dispatched_to_seller") || scanstatus.equals("rto_completed"))) {
    						activity = messageSource.getMessage(GlobalConstant.CONFIRM_RTO, null, null);
    						history.setRtoAwbNumber(saleOrder.getCourierAWBNumber_s());
    					}
    				}
    				
    				if(activity.equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
    					history.setRtoReason(rtoKey);
    					vendorStatusBean.setDrsReason(rtoKey);
    				}
    				history.setStatusId(activity);
    				history.setUpdateDate(vendordate);
    				history.setLocation(scanDetail.getCity());
    				
    				PacketsHistory packetsHistory = getPacketHistoryLastStatus(saleOrder);
    				if(packetsHistory!=null){
    					String bmpDateString= packetsHistory.getDate();
    					Date bmpLastStatusUpdateDate = null;
    					try{
    						if(bmpDateString.length()<11){
    							bmpLastStatusUpdateDate= new SimpleDateFormat(GlobalConstant.REPORT_DATE_FORMATE).parse(bmpDateString);//adjustment because some packet-history not in above format "yyyy/MM/dd"
    						}else{
    							bmpLastStatusUpdateDate = CommonUtility.convertStringYYYYMMDDHHSSToDate(bmpDateString);
    							//bmpLastStatusUpdateDate= dateFormat.parse(bmpDateString);
    						}	
    					}catch(Exception e){
    						e.printStackTrace();
    						continue;
    					}
    					
    					if (bmpLastStatusUpdateDate.compareTo(vendordate) < 0) {
    						List<VendorPacketsHistory> histories = vendorStatusBean.getPacketsHistory();
    						if (histories == null) {
    							histories = new ArrayList<VendorPacketsHistory>();
    							histories.add(history);
    							vendorStatusBean.setPacketsHistory(histories);
    						} else {
    							vendorStatusBean.getPacketsHistory().add(history);
    						}
    					} else if(bmpLastStatusUpdateDate.compareTo(vendordate) == 0 ){
    						//&& !activity.equalsIgnoreCase(saleOrder.getPacketsHistory().get(saleOrder.getPacketsHistory().size() - 1).getActivity()))
    						boolean flag = false;
    						final Set<Entry<String, PacketsHistory>> mapValues = saleOrder.getPacketsHistory().entrySet();
    						final Entry<String, PacketsHistory>[] pHistoryList = new Entry[mapValues.size()];
    						mapValues.toArray(pHistoryList);
    						for(int i=pHistoryList.length-1; i>=0 ; i--) {
    							PacketsHistory pHistory = pHistoryList[i].getValue();
    							if(pHistoryDateFormat.parse(pHistory.getDate()).compareTo(vendordate) != 0)
    								break;
    							if((pHistory.getToStatusKey()!=null && activity.equals(pHistory.getToStatusKey())) || (pHistory.getToStatus()!=null && activity.equals(pHistory.getToStatus().getKey_s()))) {
    								flag = true;
    								break;
    							}
    						}
    						if(flag)
    							continue;
    						else {
    							List<VendorPacketsHistory> histories = vendorStatusBean.getPacketsHistory();
    							if (histories == null) {
    								histories = new ArrayList<VendorPacketsHistory>();
    								histories.add(history);
    								vendorStatusBean.setPacketsHistory(histories);
    							} else {
    								vendorStatusBean.getPacketsHistory().add(history);
    							}
    						}
    					}
    				}else{
    					List<VendorPacketsHistory> histories= new ArrayList<VendorPacketsHistory>();
    					histories.add(history);
    					vendorStatusBean.setPacketsHistory(histories);
    				}
                }
			}
			
			return vendorStatusBean;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static PacketsHistory getPacketHistoryLastStatus(SaleOrder saleOrder) {

		Map<String, PacketsHistory> packMap = saleOrder.getPacketsHistory();
		if (packMap != null && packMap.size() > 0) {

			final Set<Entry<String, PacketsHistory>> mapValues = packMap.entrySet();
			final Entry<String, PacketsHistory>[] test = new Entry[mapValues.size()];
			mapValues.toArray(test);
			PacketsHistory history = test[mapValues.size() - 1].getValue();
			return history;
		}
		
		return null;
	}
	
	public static HttpRequestBeanNew getTrackingRequest (VendorApiBean vendorApiBean, SaleOrder saleOrder) {
		Map<String,String> header = new HashMap<>();
        for(String hdr : vendorApiBean.getHeader_param().split(",")) {
        	String s[] = hdr.split("=#=");
        	header.put(s[0], s[1]);
        }
        String token = EkartApiHelperImpl.getToken(vendorApiBean);
        header.put("Authorization",token);
        
        Map<String, Object> request = new HashMap<>();
        request.put("request_id", "string");
        List<String> list =  new ArrayList<>();
        list.add(saleOrder.getCourierAWBNumber_s());
        request.put("tracking_ids", list);
        
        HttpRequestBeanNew requestBean = new HttpRequestBeanNew();
        requestBean.setRequestURL(vendorApiBean.getUrl_s());
        requestBean.setRequestMethod(vendorApiBean.getMethod_s());
        requestBean.setHeaderParams(header);
        requestBean.setRequestParams(request);
        return requestBean;
	}

}
