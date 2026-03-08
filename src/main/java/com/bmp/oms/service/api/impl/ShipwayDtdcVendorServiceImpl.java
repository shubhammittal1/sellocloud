package com.bmp.oms.service.api.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.bmp.model.app.api.jaxbean.ShipWayResponseBean;
import com.bmp.model.app.api.jaxbean.ShipWayResponseBean.Response.Scan;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;

@Service
@Qualifier("shipwayDtdcVendorServiceImpl")
public class ShipwayDtdcVendorServiceImpl implements VendorService {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Override
	public VendorStatusBean statusMapping(Object obj, SaleOrder saleOrder, VendorStatusMappingBean vendorStatusMappingBean) {

		ShipWayResponseBean shipWayBean = (ShipWayResponseBean) obj;
		VendorStatusBean vendorStatusBean = new VendorStatusBean();
		DateFormat dateFormat = new SimpleDateFormat(GlobalConstant.DATE_FORMATE);

		if (shipWayBean == null || shipWayBean.getStatus() == null || shipWayBean.getResponse() == null || shipWayBean.getResponse().getAwbno() == null 
				|| shipWayBean.getResponse().getScan() == null || shipWayBean.getResponse().getScan().size() < 0) {
			return null;
		}
		
		try {
			List<String> statusList = new ArrayList<String>();
			statusList.add("5");	//Delivery Attempted - Address not found
			statusList.add("10");	//Undeliver : Customer Not Available
			statusList.add("37");	//Consignee Shifted
			statusList.add("118");	//Damaged in transit
			statusList.add("27");	//Delivery Attempted - Door/Office Closed
			statusList.add("17");	//Delivery Attempted - Incorrect Address
			statusList.add("26");	//Packet - out of delivery area
			statusList.add("23");	//Consignee refused to accept shipment
			statusList.add("128");	//Packet on hold
			statusList.add("115");	//Out for delivery
			statusList.add("133");	//Packet mis-route
			statusList.add("134");	//Delivery Delayed - Contact Customer Service
			
			if(saleOrder.getCurrentStatus().getKey_s().equalsIgnoreCase(messageSource.getMessage(GlobalConstant.COD_AWAITED_BRANCH_END, null, null))){
				return null;
			}
			
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s());
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());

			String lastStatus = null;
			PacketsHistory lastHistory = getPacketHistoryLastStatus(saleOrder);
			if(saleOrder.getCurrentStatus().getKey_s().equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
				lastStatus = lastHistory!=null?lastHistory.getRtoReason():null;
			} else {
				lastStatus = lastHistory!=null?saleOrder.getCurrentStatus().getKey_s():null;
			}
			
			List<Scan> list = shipWayBean.getResponse().getScan();
			Collections.reverse(list);
			for (Scan scan : list) {
				
				if(scan == null || "".equals(scan.getStatus_detail()) /*|| "".equals(scan.getLocation())*/ || "".equals(scan.getTime())){
					continue;
				}
				
				String scanstatus = (scan.getStatus_detail().trim().replaceAll("\\s+", ""));
				Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
				String activity = null;
				String statusValue = null;
				String rtoKey = null;
				if("Itemdelivered[To:BMPeGroup]".equals(scanstatus)) {
					activity = messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null);
				} else if("Itemdelivered".equals(scanstatus) && saleOrder.getPaymentType_s().equalsIgnoreCase("pp")){
					activity = messageSource.getMessage(GlobalConstant.DELIVERED, null, null);
				}  else {
					scanstatus = scanstatus.replaceAll("[^a-zA-Z0-9]", "");
					for(Map.Entry<String, String> entry : statusMap.entrySet()) {
						if (scanstatus.contains(entry.getKey())) {
							statusValue = entry.getValue();
							break;
						}
					}
				}
				if(statusValue==null)
					continue;
				
				if(statusValue.contains("_")) {
					activity = statusValue.split("_")[0];
					rtoKey = statusValue.split("_")[1];
				} else {
					activity = statusValue.split("_")[0];
				}
				if(activity==null)
					continue;
				
				SimpleDateFormat source = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date vendordate;
				try {
					vendordate = dateFormat.parse(dateFormat.format(source.parse(scan.getTime())));
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
				history.setLocation(scan.getLocation()!=null?scan.getLocation().trim().toUpperCase():null);
				
				PacketsHistory packetsHistory = getPacketHistoryLastStatus(saleOrder);
				if (packetsHistory != null) {
					String bmpDateString = packetsHistory.getDate();
					Date bmpLastStatusUpdateDate = null;
					try {
						if (bmpDateString.length() < 11) {
							bmpLastStatusUpdateDate = new SimpleDateFormat("yyyy/MM/dd").parse(bmpDateString);
						} else {
							bmpLastStatusUpdateDate = dateFormat.parse(bmpDateString);
						}
						//bmpLastStatusUpdateDate = new SimpleDateFormat("yyyy/MM/dd").parse(bmpDateString);//only for india post as not getting time in response
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					}
					if((bmpLastStatusUpdateDate.compareTo(vendordate) > 0) || (bmpLastStatusUpdateDate.compareTo(vendordate) == 0 && activity.equalsIgnoreCase(saleOrder.getCurrentStatus().getKey_s()))) {
						continue;
					}
					if(lastStatus!=null && statusList.contains(lastStatus)){
						if(!scanstatus.contains("Itemdelivered")) {
							activity = messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null);
							history.setStatusId(activity);
							statusMaster = statusMasterDao.getObjectById(activity, StatusMaster.class);
							history.setActivity(statusMaster.getStatusName());
						}
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
						lastStatus = activity;
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
						lastStatus = activity;
					}
				} else {
					List<VendorPacketsHistory> histories = new ArrayList<VendorPacketsHistory>();
					histories.add(history);
					vendorStatusBean.setPacketsHistory(histories);
				}
				if(scanstatus.contains("Itemdelivered") || activity.equals(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null))) {
					break;
				}
			}

			if (vendorStatusBean.getPacketsHistory() != null)
				Collections.sort(vendorStatusBean.getPacketsHistory());
			else
				return null;

		} catch (Exception e) {
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
