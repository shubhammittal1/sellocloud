package com.bmp.oms.service.api.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.bmp.constant.GlobalConstant;
import com.bmp.dao.StatusMasterDao;
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.jaxbean.SecuraexTrackingResponseBean;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;

@Service
@Qualifier("securaexVendorServiceImpl")
public class SecuraexVendorServiceImpl implements VendorService{

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Override
	public VendorStatusBean statusMapping(Object obj, SaleOrder saleOrder,VendorStatusMappingBean vendorStatusMappingBean) {
		
		SecuraexTrackingResponseBean securaexTrackingResponseBean =  (SecuraexTrackingResponseBean) obj;
		VendorStatusBean vendorStatusBean = new VendorStatusBean() ;
		DateFormat dateFormat = new SimpleDateFormat(GlobalConstant.DATE_FORMATE);
		
		if(securaexTrackingResponseBean == null || securaexTrackingResponseBean.getData() == null 
			|| securaexTrackingResponseBean.getData().getHistory() == null || securaexTrackingResponseBean.getData().getHistory().length == 0){
			return null;
		}	
		
		try{
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s()); 
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
			
			/*get vendor statuses in map*/
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
			List<SecuraexTrackingResponseBean.Data.History> vendorHistoryList = new ArrayList<>(Arrays.asList(securaexTrackingResponseBean.getData().getHistory()));
			Collections.reverse(vendorHistoryList);
			for(SecuraexTrackingResponseBean.Data.History vendorHistory : vendorHistoryList){
				
				if(vendorHistory.getStatus() == null) {
					continue;
				}
				
				String scanstatus = "";
				scanstatus = (vendorHistory.getStatus()).replaceAll("\\s+","").replaceAll("\\.+","").toUpperCase();
				if(scanstatus.equalsIgnoreCase("Undelivered")) {
					String ndr = vendorHistory.getRemarks().replaceAll("\\s+","").replaceAll("\\.+","").toUpperCase();
					if(ndr.contains("CUSTOMERASKINGFORFUTUREDELIVERY")) {
						scanstatus = scanstatus+"##CUSTOMERASKINGFORFUTUREDELIVERY";
					}else {
						scanstatus = scanstatus+"##"+ndr;
					}
				}
				
				String activity = null;
				String statusValue = null;
				String rtoKey = null;
				if(statusMap.containsKey(scanstatus)){
					statusValue = statusMap.get(scanstatus);
				}else{
					continue;
				}		
				if(statusValue.contains("_")) {
					activity = statusValue.split("_")[0];
					rtoKey = statusValue.split("_")[1];
				} else {
					activity = statusValue.split("_")[0];
				}
				if(activity==null)
					continue;
				
				SimpleDateFormat source = new SimpleDateFormat("yyyy-MM-dd hh:mm aaa");
				Date vendordate;
				try {
					vendordate = dateFormat.parse(dateFormat.format(source.parse(vendorHistory.getDate())));
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				
				VendorPacketsHistory history = new VendorPacketsHistory();
				StatusMaster statusMaster = statusMasterDao.getObjectById(activity, StatusMaster.class);
				history.setActivity(statusMaster.getStatusName());
				if(activity.equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
					history.setRtoReason(rtoKey);
					vendorStatusBean.setDrsReason(rtoKey);
				}
				history.setStatusId(activity);
				history.setUpdateDate(vendordate);
				history.setLocation(vendorHistory.getLocation() != null  ? vendorHistory.getLocation() : null);
				
				PacketsHistory packetsHistory = getPacketHistoryLastStatus(saleOrder);
				if(packetsHistory!=null){
					String bmpDateString= packetsHistory.getDate();
					Date bmpLastStatusUpdateDate = null;
					try{
						if(bmpDateString.length()<11){
							bmpLastStatusUpdateDate= new SimpleDateFormat("yyyy/MM/dd").parse(bmpDateString);////adjustment because some packet-history not in above format
						}else{
							bmpLastStatusUpdateDate= dateFormat.parse(bmpDateString);
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
							if(dateFormat.parse(pHistory.getDate()).compareTo(vendordate) != 0)
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
				////
			}
			
			/*if(vendorStatusBean.getPacketsHistory() != null)
				Collections.sort(vendorStatusBean.getPacketsHistory());
			else
				return null;*/
			
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return vendorStatusBean;
	}
	
	// get saleOrder Last Status
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
}
