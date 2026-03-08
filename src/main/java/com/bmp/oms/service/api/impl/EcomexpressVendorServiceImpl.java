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
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.jaxbean.EcomexpressTrackingResponseBean;
import com.bmp.model.app.saleorder.CourierWeightBean;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;

@Service
@Qualifier("ecomexpressVendorServiceImplNew")
public class EcomexpressVendorServiceImpl implements VendorService{
	SimpleDateFormat formater = new SimpleDateFormat("dd MMM yyyy HH:mm");
	DateFormat bmpDateFormater = new SimpleDateFormat(GlobalConstant.DATE_FORMATE); //"yyyy/MM/dd HH:mm:ss"
	private static final String UPDATED_ON = "updated_on";
	private static final String STATUS = "status";
	private static final String REASON_CODE = "reason_code";
	private static final String REASON_CODE_NUMBER = "reason_code_number";
	private static final String SCAN_STATUS = "scan_status";
	private static final String LOCATION = "location";
	private static final String LOCATION_CITY = "location_city";
	private static final String LOCATION_TYPE = "location_type";
	private static final String CITY_NAME = "city_name";
	private static final String EMPLOYEE = "Employee";
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	public VendorStatusBean statusMapping(Object mappedVendorBean, SaleOrder saleOrder,
			VendorStatusMappingBean vendorStatusMappingBean) {
		
		EcomexpressTrackingResponseBean bean = (EcomexpressTrackingResponseBean) mappedVendorBean;
		if(bean == null || bean.getEcomexpressObjects() == null 
				|| bean.getEcomexpressObjects().getObject() == null
				/*|| bean.getEcomexpressObjects().getObject().getField() == null*/){
			return null;
		}
		Map<String,String>resultMap = getData(bean);
		
		VendorStatusBean vendorStatusBean = new VendorStatusBean();
		vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
		vendorStatusBean.setVendorname(saleOrder.getCourierKey_s());
		Double courierWeight = getWeight(bean);
		if(courierWeight != null && courierWeight > 0) {
			CourierWeightBean courierWeightBean = new CourierWeightBean();
			courierWeightBean.setDate(new Date());
			courierWeightBean.setWeight(courierWeight*1000);
			courierWeightBean.setLenght(1.0);
			courierWeightBean.setWidth(2.0);
			courierWeightBean.setHeight(3.0);
			vendorStatusBean.setCourierWeightBean(courierWeightBean);
		}
		
		Map<String,String> statusMapping = vendorStatusMappingBean.getStatusMap();
		PacketsHistory lastPk = getPacketHistoryLastStatus(saleOrder);
		Date laskPkDate =  getBmpDate(lastPk.getDate());
		
		List<VendorPacketsHistory> packetsHistory = new ArrayList<VendorPacketsHistory>();
		
		boolean isRto = false;
		
		List<Map<String,String>> scans = getScan(bean);
		Collections.reverse(scans);
		for(Map<String,String> map : scans){
			try{

				String reasonCodeNumber = map.get(REASON_CODE_NUMBER);
				String reasonCode = map.get(REASON_CODE);
				String status = map.get(STATUS);
				String locationCity = map.get(LOCATION_CITY);
				String locationType = map.get(LOCATION_TYPE);
				
				String key = reasonCodeNumber;
				if(!statusMapping.containsKey(key)){
					key = status;
				}
				
				if(!statusMapping.containsKey(key)){
					continue;
				}
				
				String statusString = statusMapping.get(key);
				String statusCode = null;
				String ndrCode = null;
				if(statusString.contains("_")){
					String s [] = statusString.split("_");
					statusCode = s[0];
					ndrCode = s[1];
				}else{
					statusCode = statusString;
				}
				
				
				Date date = getDate(map.get(UPDATED_ON));
				if(date == null || laskPkDate.compareTo(date) > 0){
					continue;
				}
				
				if(laskPkDate.compareTo(date) == 0){
					
				}
				VendorPacketsHistory history = new VendorPacketsHistory();
				history.setLocation(locationCity +" ("+locationType+" )");
				StatusMaster statusMaster = statusMasterDao.getObjectById(statusCode, StatusMaster.class);
				history.setActivity(statusMaster.getStatusName());
				history.setUpdateDate(date);
				history.setActivity(statusCode);
				history.setStatusId(statusCode);
				if(statusCode.equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
					history.setRtoReason(ndrCode);
					vendorStatusBean.setDrsReason(ndrCode);
				}
				if(statusCode.equals(messageSource.getMessage(GlobalConstant.CONFIRM_RTO, null, null))) {
					history.setRtoAwbNumber(resultMap.get("ref_awb"));
					isRto = true;
				}
				if(statusCode.equals(messageSource.getMessage(GlobalConstant.DELIVERED, null, null))
						|| statusCode.equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
					history.setRtoReason(ndrCode);
					Map<String, String> datamap = getDataMap(bean);
					if(datamap.containsKey("lat") && datamap.get("lat") != null) {
						history.setLat(datamap.get("lat"));
					}
					if(datamap.containsKey("long") && datamap.get("long") != null) {
						history.setLng(datamap.get("long"));
					}
				}
				
				if (laskPkDate.compareTo(date) < 0) {
					List<VendorPacketsHistory> histories = vendorStatusBean.getPacketsHistory();
					if (histories == null) {
						histories = new ArrayList<VendorPacketsHistory>();
						histories.add(history);
						vendorStatusBean.setPacketsHistory(histories);
					} else {
						vendorStatusBean.getPacketsHistory().add(history);
					}
				}else if (laskPkDate.compareTo(date)  == 0){
					if(lastPk.getToStatusKey().equals(statusCode)){
						continue;
					}
				}
				
				packetsHistory.add(history);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(!isRto && packetsHistory.size() > 0) {
			//int index = -1;
			List<Integer> indexs = new ArrayList<>();
			
			//Integer indexs[] = new 
			for(int i=0; i<packetsHistory.size(); i++) {
				
				VendorPacketsHistory vpk = packetsHistory.get(i);
				if(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null).equals(vpk.getStatusId())) {
					indexs.add(i);
				}
			}
			if(!indexs.isEmpty()) {
				List<VendorPacketsHistory> actualHistory = new ArrayList<VendorPacketsHistory>();
				for(int i=0; i<packetsHistory.size(); i++) {
					if(!indexs.contains(i)) {
						actualHistory.add(packetsHistory.get(i));
					}
				}
				packetsHistory = actualHistory;
			}
		}
		vendorStatusBean.setPacketsHistory(packetsHistory);
		return vendorStatusBean;
	}
	
	
	private List<Map<String,String>> getScan(EcomexpressTrackingResponseBean bean){
		List<Map<String,String>> list = new ArrayList();
		for(EcomexpressTrackingResponseBean.Field field: bean.getEcomexpressObjects().getObject().getField()){
			if("scans".equals(field.getName())){
				for(EcomexpressTrackingResponseBean.EcomObject sacnObject : field.getObject()){
					Map<String,String> map = new HashMap<String, String>();
					for(EcomexpressTrackingResponseBean.Field scanField : sacnObject.getField()){
						if(UPDATED_ON.equals(scanField.getName())){
							map.put(UPDATED_ON, scanField.getContent());
						}else if(STATUS.equals(scanField.getName())){
							map.put(STATUS, scanField.getContent());
						}else if(REASON_CODE.equals(scanField.getName())){
							map.put(REASON_CODE, scanField.getContent());
						}else if(REASON_CODE_NUMBER.equals(scanField.getName())){
							map.put(REASON_CODE_NUMBER, scanField.getContent());
						}else if(SCAN_STATUS.equals(scanField.getName())){
							map.put(SCAN_STATUS, scanField.getContent());
						}else if(LOCATION.equals(scanField.getName())){
							map.put(LOCATION, scanField.getContent());
						}else if(LOCATION_CITY.equals(scanField.getName())){
							map.put(LOCATION_CITY, scanField.getContent());
						}else if(LOCATION_TYPE.equals(scanField.getName())){
							map.put(LOCATION_TYPE, scanField.getContent());
						}else if(CITY_NAME.equals(scanField.getName())){
							map.put(CITY_NAME, scanField.getContent());
						}else if(EMPLOYEE.equals(scanField.getName())){
							map.put(EMPLOYEE, scanField.getContent());
						}
					}
					list.add(map);
				}
			}
		}
		return list; 
	}
	
	private Double getWeight(EcomexpressTrackingResponseBean bean){
		List<Map<String,String>> list = new ArrayList();
		for(EcomexpressTrackingResponseBean.Field field: bean.getEcomexpressObjects().getObject().getField()){
			if("actual_weight".equals(field.getName())){
				try {
					return Double.valueOf(field.getContent());
				}catch (Exception e) {
					return null;
				}
			}
		}
		return null; 
	}
	private Map getData(EcomexpressTrackingResponseBean bean){
		Map<String,String> map = new HashMap<>();
		for(EcomexpressTrackingResponseBean.Field field: bean.getEcomexpressObjects().getObject().getField()){
			if(field!= null){
				try {
					map.put(field.getName(), field.getContent());
					
				}catch (Exception e) {
					
				}
			}
		}
		return map; 
	}
	
	private Map<String,String> getDataMap(EcomexpressTrackingResponseBean bean){
		Map<String,String> map = new HashMap<>();
		for(EcomexpressTrackingResponseBean.Field field: bean.getEcomexpressObjects().getObject().getField()){
			if("lat".equals(field.getName())){
				try {
					map.put("lat", field.getContent());
				}catch (Exception e) {}
			}
			if("long".equals(field.getName())){
				try {
					map.put("long", field.getContent());
				}catch (Exception e) {}
			}
			if("receiver".equals(field.getName())){
				try {
					map.put("receiver", field.getContent());
				}catch (Exception e) {}
			}
			if("actual_weight".equals(field.getName())){
				try {
					map.put("actual_weight", field.getContent());
				}catch (Exception e) {}
			}
		}
		return map; 
	}
	
	private Date getDate (String dateStr){
		try{
			dateStr = dateStr.replace(",", "");
			return formater.parse(dateStr);
		}catch (Exception e) {
			return null;
		}
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
	
	private  Date getBmpDate(String str){
		Date bmpLastStatusUpdateDate = null;
		try{
			bmpLastStatusUpdateDate= bmpDateFormater.parse(str);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bmpLastStatusUpdateDate;
	}

}
