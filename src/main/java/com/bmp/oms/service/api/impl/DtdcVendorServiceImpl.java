package com.bmp.oms.service.api.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.StatusMasterDao;
import com.bmp.dao.VendorApiDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.jaxbean.DtdcTrackingResponseBean;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;
import com.bmp.oms.service.api.vendorPickupLocation.VendorPickupLocationApiService;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
@Qualifier("dtdcVendorServiceImpl")
public class DtdcVendorServiceImpl implements VendorService, VendorPickupLocationApiService{

	@Autowired
	@Qualifier("vendorApiDaoImpl")
	private  VendorApiDao vendorApiDao;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Override
	public VendorStatusBean statusMapping(Object mappedVendorBean, SaleOrder saleOrder,
			VendorStatusMappingBean vendorStatusMappingBean) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		VendorStatusBean vendorStatusBean = new VendorStatusBean() ;
		DtdcTrackingResponseBean dtdcTrackingResponseBean = (DtdcTrackingResponseBean) mappedVendorBean;
		
		try{
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s()); 
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
			
			/*get vendor statuses in map*/
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
			
			if(dtdcTrackingResponseBean != null && dtdcTrackingResponseBean.getStatusFlag() != null && dtdcTrackingResponseBean.getStatusFlag()
                    && dtdcTrackingResponseBean.getTrackDetails() != null && !dtdcTrackingResponseBean.getTrackDetails().isEmpty()){
                List<DtdcTrackingResponseBean.TrackDetails> historyList = dtdcTrackingResponseBean.getTrackDetails();
                //Collections.reverse(historyList);
                for(DtdcTrackingResponseBean.TrackDetails eventHistory : historyList){
                	
                	
                	StringBuffer sb = new StringBuffer();
                    sb.append(eventHistory.getStrActionDate().substring(4,8)).append("/");
                    sb.append(eventHistory.getStrActionDate().substring(2,4)).append("/");
                    sb.append(eventHistory.getStrActionDate().substring(0,2)).append(" ");
                    sb.append(eventHistory.getStrActionTime().substring(0,2)).append(":");
                    sb.append(eventHistory.getStrActionTime().substring(2,4)).append(":00");
    				String eventCode = eventHistory.getStrCode();
    				
    				if(saleOrder.getKey_s().endsWith("RTO")) {
    					eventCode = eventCode.replace("RTO","");
    				}
    				String vendorNdrCode = null;
    				if(eventHistory.getsTrRemarks()!=null && eventCode.equals("NONDLV")) {
    					vendorNdrCode = eventHistory.getsTrRemarks().split("\\|")[0];
    					eventCode = eventCode+vendorNdrCode;
    				}
    				
    				String status= eventHistory.getStrAction();
    				String promisedDeliveryDate = dtdcTrackingResponseBean.getTrackHeader().getStrExpectedDeliveryDate();
    				
    				String activity = null;
    				String statusValue = null;
    				String rtoKey = null;
    				if(statusMap.containsKey(eventCode)){
    					statusValue = statusMap.get(eventCode);
    				}else{
    					continue;
    				}	
    				if(statusValue.contains("_")) {
    					activity = statusValue.split("_")[0];
    					rtoKey = statusValue.split("_")[1];
    				} else {
    					activity = statusValue;
    				}
    				Date vendordate = CommonUtility.convertStringYYYYMMDDHHSSToDate(sb.toString());
    				
    				VendorPacketsHistory history = new VendorPacketsHistory();
    				StatusMaster statusMaster = statusMasterDao.getObjectById(activity, StatusMaster.class);
    				history.setActivity(statusMaster.getStatusName());
    				if(activity.equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
    					history.setRtoReason(rtoKey);
    					vendorStatusBean.setDrsReason(rtoKey);
    				}
    				if(!saleOrder.getKey_s().endsWith("RTO") && saleOrder.getCurrentStatus().getKey_s().equals(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null)) && 
    						dtdcTrackingResponseBean.getTrackHeader().getStrStatus().equals("RTO Delivered"))
    					 {
    					activity=messageSource.getMessage(GlobalConstant.CONFIRM_RTO, null, null);
    					history.setRtoAwbNumber(saleOrder.getCourierAWBNumber_s());
    					//isRto = true;
    				}
    				history.setStatusId(activity);
    				history.setUpdateDate(vendordate);
    				history.setLocation(eventHistory.getStrOrigin());
    				
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
    							if(CommonUtility.convertStringYYYYMMDDHHSSToDate(pHistory.getDate()).compareTo(vendordate) != 0)
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
		if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
			
			String headerParams[] = vendorApiBean.getHeader_param().split(",");
			for (int i = 0; i < headerParams.length; i++) {
				String key = headerParams[i].split("=")[0];
				String value = headerParams[i].split("=")[1];
				header.put(key, value);
			}
			
		}
       
		
		Map<String, Object> request = new HashMap<>();
		request.put("trkType","cnno");
		request.put("strcnno",saleOrder.getCourierAWBNumber_s());
		request.put("addtnlDtl","Y");
		
        
        HttpRequestBeanNew requestBean = new HttpRequestBeanNew();
        requestBean.setRequestURL(vendorApiBean.getUrl_s());
        requestBean.setRequestMethod(vendorApiBean.getMethod_s());
        requestBean.setHeaderParams(header);
        requestBean.setRequestParams(request);
        return requestBean;
	}
	
	@Override
	public ResponseBean vendorPickupRequestCreate(SaleOrderPickupRequest saleOrderPickupRequest,
			VendorApiBean vendorApiBean) throws Exception {
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		//vendorBean=vendorApiBean;
		ResponseBean responseBean= new ResponseBean();
		try{
		httpRequestBeanNew.setRequestURL(vendorApiBean.getUrl_s());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
			if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
				String headerParams[] = vendorApiBean.getHeader_param().split(",");
				for (int i = 0; i < headerParams.length; i++) {
					String key = headerParams[i].split("=")[0];
					String value = headerParams[i].split("=")[1];
					header.add(key, value);
				}
			}
			Map<String, Object> requestParams = new HashMap<>();
			requestParams.put("pickup_type","BUSINESS");
			requestParams.put("customer_code",vendorApiBean.getCarrierId());
			
			requestParams.put("load_type",vendorApiBean.getExtra1());
			requestParams.put("total_items", saleOrderPickupRequest.getActualPackageCount());
	        requestParams.put("total_weight",0.0);
	        Map<String, String> picAddress = new HashMap<>();
	        picAddress.put("pincode",saleOrderPickupRequest.getClientWarehouse().getPincode());
	        picAddress.put("name",saleOrderPickupRequest.getClientWarehouse().getWarehouseName_s());
	        picAddress.put("phone",saleOrderPickupRequest.getClientWarehouse().getMobileNumber());
	        picAddress.put("address_line_1",saleOrderPickupRequest.getClientWarehouse().getAddress());
	        picAddress.put("address_line_2","");
	        picAddress.put("city",saleOrderPickupRequest.getClientWarehouse().getCity());
	        picAddress.put("state",saleOrderPickupRequest.getClientWarehouse().getState());
	        picAddress.put("country",saleOrderPickupRequest.getClientWarehouse().getCountry());
	        Map<String, String> pickupSlot = new HashMap<>();
	        String datenadTime = saleOrderPickupRequest.getPickupDateTime();
			String[] splitStr = datenadTime.split("\\s+");
	        pickupSlot.put("start",splitStr[1]);
	        pickupSlot.put("end","19:00");
            pickupSlot.put("date",splitStr[0]);
            
            requestParams.put("pickup_slot",pickupSlot);
            requestParams.put("pickup_address",picAddress);
			httpRequestBeanNew.setRequestBody(requestParams);
			ResponseBean apiResponseBean =  new HttpUtilittyNew().PostApiCall(httpRequestBeanNew,header);
			//mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	       // Map<String, Object> responseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
	        if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
                mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                Map<String, Object> pickupResponseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
                if (pickupResponseMap.containsKey("success") && (Boolean) pickupResponseMap.get("success") == false){
                    responseBean.setMessage(pickupResponseMap.get("error").toString());
                    responseBean.setStatus(ResponseStatus.FAIL);
                    return responseBean;
                }else {
                	Map<String, Object> responseMap = (Map<String, Object>) pickupResponseMap.get("data");
                	responseBean.setStatus(ResponseStatus.SUCCESS);
                    String partnerId = responseMap.get("pickupId").toString();
                    saleOrderPickupRequest.setCourierPickupId(partnerId);
                    responseBean.setResponse(saleOrderPickupRequest);
                    return responseBean;
                }
            }
			}catch (Exception e){
	            e.printStackTrace();
	        }
			responseBean.setMessage("API response fail");
			responseBean.setStatus(ResponseStatus.FAIL); 
			return responseBean;
	}
	
	@Override
	public ResponseBean vendorWarehouseCreate(ClientWarehouse clientWarehouse, VendorApiBean vendorApiBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean vendorWarehouseUpdate(ClientWarehouse clientWarehouse, VendorApiBean vendorApiBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseBean vendorPickupRequestCancel(SaleOrderPickupRequest saleOrderPickupRequest,
			VendorApiBean vendorApiBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
