package com.bmp.oms.service.api.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.jaxbean.ArrayOfConsignmentTrackDetailS;
import com.bmp.model.app.api.jaxbean.ArrayOfConsignmentTrackDetailS.ConsignmentTrackDetailS.Detail.ConsignmentTrackS;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;


@Service
@Qualifier("gojavasVendorServiceImpl")
public class GojavasVendorServiceImpl implements VendorService {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Override
	public VendorStatusBean statusMapping(Object obj, SaleOrder saleOrder,VendorStatusMappingBean vendorStatusMappingBean) {
		
		ArrayOfConsignmentTrackDetailS actS = (ArrayOfConsignmentTrackDetailS)obj;
		VendorStatusBean vendorStatusBean = new VendorStatusBean() ;
		
		if(actS == null || actS.getConsignmentTrackDetailS() == null || actS.getConsignmentTrackDetailS().getHeaderDetail() == null
				|| actS.getConsignmentTrackDetailS().getDetail() == null){
			return null;
		}
		
		try{
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s()); 
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
		
			/*get vendor statuses in map*/
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
			
			ArrayOfConsignmentTrackDetailS.ConsignmentTrackDetailS detailS = actS.getConsignmentTrackDetailS();
			List<ConsignmentTrackS> goJavaPacketHistory = detailS.getDetail().getConsignmentTrackS();
				
			DateFormat dateFormat = new SimpleDateFormat(GlobalConstant.DATE_FORMATE);
			
			for (ConsignmentTrackS consignmentTrackS : goJavaPacketHistory) {
				String activity =null;
				String statusValue = null;
				String rtoKey = null;
				if("UDL".equals(consignmentTrackS.getCurrent_status_Code()) && consignmentTrackS.getCurrent_Status()!=null){
					consignmentTrackS.setCurrent_status_Code(consignmentTrackS.getCurrent_status_Code()+consignmentTrackS.getCurrent_Status());
				}
				
				if(statusMap.containsKey(consignmentTrackS.getCurrent_status_Code().trim().replaceAll("\\s+",""))){
					statusValue = statusMap.get(consignmentTrackS.getCurrent_status_Code().trim().replaceAll("\\s+",""));
				}else{
					continue;
				}
				if(statusValue.contains("_")) {
					activity = statusValue.split("_")[0];
					rtoKey = statusValue.split("_")[1];
				} else {
					activity = statusValue.split("_")[0];
				}
				//if matching status not found, continue;	
				VendorPacketsHistory history=new VendorPacketsHistory();
				StatusMaster statusMaster = statusMasterDao.getObjectById(activity, StatusMaster.class);
				history.setActivity(statusMaster.getStatusName());
				if(activity.equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
					history.setRtoReason(rtoKey);
					vendorStatusBean.setDrsReason(rtoKey);
				}
				history.setStatusId(activity);
				history.setUpdateDate(consignmentTrackS.getCurrent_Status_Date_Time());
				history.setLocation(consignmentTrackS.getCurrent_Location_Name());
				System.out.println("consignmentTrackS.getCurrent_Status_Date_Time() "+consignmentTrackS.getCurrent_Status_Date_Time());
				if(saleOrder.getPacketsHistory()!=null){
					String bmpDateString= saleOrder.getPacketsHistory().get(saleOrder.getPacketsHistory().size()-1).getDate();
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
					
					Date vendordate = dateFormat.parse(dateFormat.format(consignmentTrackS.getCurrent_Status_Date_Time()));
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
			}
				
			if(vendorStatusBean.getPacketsHistory() != null)
				Collections.sort(vendorStatusBean.getPacketsHistory());
			else
				return null;
			
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
		return vendorStatusBean;
	}
}
