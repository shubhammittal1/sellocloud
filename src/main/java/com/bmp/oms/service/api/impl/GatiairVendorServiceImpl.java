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
import com.bmp.model.app.api.jaxbean.GatiresponseNew;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;

@Service
@Qualifier("gatiairVendorServiceImpl")
public class GatiairVendorServiceImpl implements VendorService {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Override
	public VendorStatusBean statusMapping(Object obj, SaleOrder saleOrder, VendorStatusMappingBean vendorStatusMappingBean) {

		GatiresponseNew responseBean = (GatiresponseNew) obj;
		VendorStatusBean vendorStatusBean = new VendorStatusBean();

		if (responseBean == null || responseBean.getDktinfo() == null || "failed".equals(responseBean.getDktinfo().getResult()) || responseBean.getDktinfo().getTRANSIT_DTLS() == null
				|| responseBean.getDktinfo().getTRANSIT_DTLS().getROW().size() < 1) {
			return null;
		}
		
		try {
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s());
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());

			/* get vendor statuses in map */
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();

			GatiresponseNew.dktinfo.TRANSIT_DTLS dtls = responseBean.getDktinfo().getTRANSIT_DTLS();
			List<GatiresponseNew.dktinfo.TRANSIT_DTLS.ROW> gatiPacketHistory = dtls.getROW();

			DateFormat dateFormat = new SimpleDateFormat(GlobalConstant.DATE_FORMATE);

			for (GatiresponseNew.dktinfo.TRANSIT_DTLS.ROW consignmentTrackS : gatiPacketHistory) {

				// Out For Delivery cases handle
				if (("".equals(consignmentTrackS.getINTRANSIT_STATUS().trim()) || consignmentTrackS.getINTRANSIT_STATUS() == null) && (responseBean.getDktinfo().getDOCKET_STATUS() != null 
						&& !"".equals(responseBean.getDktinfo().getDOCKET_STATUS()) && "Out For Delivery".equalsIgnoreCase(responseBean.getDktinfo().getDOCKET_STATUS().trim()))) {
					
					consignmentTrackS.setINTRANSIT_STATUS("Out For Delivery");
				}

				String scanstatus = consignmentTrackS.getINTRANSIT_STATUS().trim().replaceAll("\\s+", "").replaceAll("\\.", "");
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
				SimpleDateFormat source = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
				Date vendordate;
				try {
					vendordate = dateFormat.parse(dateFormat.format(source.parse(consignmentTrackS.getINTRANSIT_DATE() + " " + consignmentTrackS.getINTRANSIT_TIME())));
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
				if (GlobalConstant.DELIVERED.equalsIgnoreCase(consignmentTrackS.getINTRANSIT_STATUS())) {
					history.setLocation(responseBean.getDktinfo().getDELIVERY_STATION());
				} else {
					history.setLocation(consignmentTrackS.getINTRANSIT_LOCATION());
				}

				PacketsHistory packetsHistory = getPacketHistoryLastStatus(saleOrder);
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

			if (vendorStatusBean.getPacketsHistory() != null)
				Collections.sort(vendorStatusBean.getPacketsHistory());
			else
				return null;

		} catch (Exception exception) {
			exception.printStackTrace();
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