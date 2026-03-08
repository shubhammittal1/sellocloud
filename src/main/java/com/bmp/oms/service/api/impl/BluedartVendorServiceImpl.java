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
import com.bmp.dao.SaleOrderExtraDao;
import com.bmp.dao.StatusMasterDao;
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.jaxbean.BluedartResponseBean;
import com.bmp.model.app.api.jaxbean.BluedartResponseBean.Shipment.Scans.ScanDetail;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderExtra;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;
import com.bmp.utility.CommonUtility;

@Service
@Qualifier("bluedartVendorServiceImpl")
public class BluedartVendorServiceImpl implements VendorService{

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Autowired
	@Qualifier("saleOrderExtraDaoImpl")
	private SaleOrderExtraDao saleOrderExtraDao;
	
	@Override
	public VendorStatusBean statusMapping(Object mappedVendorBean, SaleOrder saleOrder,VendorStatusMappingBean vendorStatusMappingBean) {
		VendorStatusBean vendorStatusBean = new VendorStatusBean();
		
		try {
			BluedartResponseBean bluedartResponseBean =  (BluedartResponseBean) mappedVendorBean;
			if(bluedartResponseBean == null) {
				return null;
			}
			
			//Save 3pl EDD
			BluedartResponseBean.Shipment shipment = bluedartResponseBean.getShipment().get(0);
			if(shipment != null && shipment.getExpectedDeliveryDate() != null && !"".equals(shipment.getExpectedDeliveryDate().trim())) {
				SaleOrderExtra saleOrderExtra = saleOrderExtraDao.getObjectById(saleOrder.getKey_s(), SaleOrderExtra.class);
				if(saleOrderExtra != null && saleOrderExtra.getThreeplEDD() == null) {
					SimpleDateFormat formater = new SimpleDateFormat("dd MMMM yyyy");
					Date edd = formater.parse(shipment.getExpectedDeliveryDate().trim());
					saleOrderExtra.setThreeplEDD(edd != null ? edd.getTime() : null);
					saleOrderExtraDao.updateObject(saleOrderExtra);
				}
			}
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s());
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
			
			/* get vendor statuses in map */
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
			
			//List<ScanDetail> scanDetails = bluedartResponseBean.getShipment().getScans().getScanDetail();
			List<ScanDetail> scanDetails = new ArrayList<ScanDetail>();
			if(bluedartResponseBean.getShipment() != null && bluedartResponseBean.getShipment().size() > 0) {
				if(bluedartResponseBean.getShipment().size() >1) {
					Collections.reverse(bluedartResponseBean.getShipment());
				}
				for(BluedartResponseBean.Shipment shpment : bluedartResponseBean.getShipment()) {
					if(shpment != null && shpment.getScans() != null && shpment.getScans().getScanDetail() != null && !shpment.getScans().getScanDetail().isEmpty()) {
						scanDetails.addAll(shpment.getScans().getScanDetail());
					}
				}
			}
			
			Collections.reverse(scanDetails);
			for(ScanDetail scanDetail :  scanDetails) {

				//String scanstatus = scanDetail.getScan().trim().replaceAll("\\s+", "").replaceAll("\\.", "");
				String scanstatus = scanDetail.getScanCode()+"##"+scanDetail.getScanGroupType()+"##"+scanDetail.getScanType().replaceAll("\\s", "");
				String activity = null;
				String statusValue = null;
				String rtoKey = null;
				if (statusMap.containsKey(scanstatus)) {
					statusValue = statusMap.get(scanstatus);
				} else {
					continue;
				}
				if(statusValue.contains("_")) {
					activity = statusValue.split("_")[0];
					rtoKey = statusValue.split("_")[1];
				} else {
					activity = statusValue.split("_")[0];
				}

				// if matching status not found, continue;
				DateFormat dateFormat = new SimpleDateFormat(GlobalConstant.DATE_FORMATE);
				SimpleDateFormat source = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
				Date vendordate;
				try {
					vendordate = dateFormat.parse(dateFormat.format(source.parse(scanDetail.getScanDate().trim() + " " + scanDetail.getScanTime().trim())));
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
				history.setLocation(scanDetail.getScannedLocation());
				
				/*if (GlobalConstant.DELIVERED.equalsIgnoreCase(consignmentTrackS.getINTRANSIT_STATUS())) {
					history.setLocation(scanDetail.getScannedLocation());
				} else {
					history.setLocation(scanDetail.getScannedLocation());
				}*/

				PacketsHistory packetsHistory = CommonUtility.getPacketHistoryLastStatus(saleOrder);
				if (packetsHistory != null) {
					String bmpDate = packetsHistory.getDate();
					Date bmpStatusUpdateDate = null;
					try {
						if (bmpDate.length() < 11) {
							//adjustment because some packet-history not in above format  "yyyy/MM/dd"
							bmpStatusUpdateDate = new SimpleDateFormat(GlobalConstant.REPORT_DATE_FORMATE).parse(bmpDate);
						} else {
							bmpStatusUpdateDate = dateFormat.parse(bmpDate);
						}
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					}

					if (bmpStatusUpdateDate.compareTo(vendordate) < 0) {
						List<VendorPacketsHistory> histories = vendorStatusBean.getPacketsHistory();
						if (histories == null) {
							histories = new ArrayList<VendorPacketsHistory>();
							histories.add(history);
							vendorStatusBean.setPacketsHistory(histories);
						} else {
							vendorStatusBean.getPacketsHistory().add(history);
						}
					} else if(bmpStatusUpdateDate.compareTo(vendordate) == 0 ){
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
				} else {
					List<VendorPacketsHistory> histories = new ArrayList<VendorPacketsHistory>();
					histories.add(history);
					vendorStatusBean.setPacketsHistory(histories);
				}

			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vendorStatusBean;
	}

}
