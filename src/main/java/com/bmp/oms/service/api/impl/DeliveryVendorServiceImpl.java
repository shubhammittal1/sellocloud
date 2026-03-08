package com.bmp.oms.service.api.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LogTypes;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.StatusMasterDao;
import com.bmp.dao.VendorErrorLogsDao;
import com.bmp.dao.VendorSuccessLogsDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.api.VendorErrorLogs;
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.VendorSuccessLogs;
import com.bmp.model.app.api.jaxbean.DeliveryResponseBean;
import com.bmp.model.app.api.jaxbean.DeliveryResponseBean.ShipmentData.Shipment.Scans;
import com.bmp.model.app.api.jaxbean.DeliveryResponseBean.ShipmentData.Shipment.Scans.ScanDetail;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;
import com.bmp.oms.service.api.vendorPickupLocation.VendorPickupLocationApiService;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
@Qualifier("deliveryVendorServiceImpl")
public class DeliveryVendorServiceImpl implements VendorService, VendorPickupLocationApiService {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	@Qualifier("vendorSuccessLogsDaoImpl")
	private VendorSuccessLogsDao vendorSuccessLogsDao;
	
	@Autowired
	@Qualifier("vendorErrorLogsDaoImpl")
	private VendorErrorLogsDao vendorErrorLogsDao;

	@Override
	public VendorStatusBean statusMapping(Object obj, SaleOrder saleOrder,VendorStatusMappingBean vendorStatusMappingBean) {
		
		DeliveryResponseBean responseBean =  (DeliveryResponseBean)obj;
		VendorStatusBean vendorStatusBean = new VendorStatusBean() ;
		DateFormat dateFormat = new SimpleDateFormat(GlobalConstant.DATE_FORMATE); //"yyyy/MM/dd HH:mm:ss"
		
		if(responseBean == null || responseBean.getError()!=null || responseBean.getShipmentData()==null ||responseBean.getShipmentData().length==0 
				|| responseBean.getShipmentData()[0].getShipment()==null || responseBean.getShipmentData()[0].getShipment().getScans()==null
				|| responseBean.getShipmentData()[0].getShipment().getScans().length == 0 || responseBean.getShipmentData()[0].getShipment().getScans()[0]==null
				|| responseBean.getShipmentData()[0].getShipment().getScans()[0].getScanDetail()==null ){
			return null;
		}	
		
		try{
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s()); 
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
			
			//boolean isRto = false;
			/*get vendor statuses in map*/
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
			
			for(Scans scans : responseBean.getShipmentData()[0].getShipment().getScans()){
				ScanDetail scanDetail = scans.getScanDetail();
				//String scanstatus = (scanDetail.getScanType()+scanDetail.getStatusCode()).trim().replaceAll("\\s+","");
				String scanstatus=null;
				if(scanDetail.getScanType().equals("RT"))
					scanstatus=(scanDetail.getScanType()).trim().replaceAll("\\s+","");
				else
					scanstatus=(scanDetail.getScanType()+scanDetail.getStatusCode()).trim().replaceAll("\\s+","");
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
				Date vendordate;
				try{
					if(scanDetail.getScanDateTime().length()>20){
					//	vendordate=dateFormat.parse(dateFormat.format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS").parse(scanDetail.getScanDateTime())));
						vendordate = dateFormat.parse(dateFormat.format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(scanDetail.getScanDateTime().substring(0, scanDetail.getScanDateTime().indexOf('.')))));
					}else{
						vendordate = dateFormat.parse(dateFormat.format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(scanDetail.getScanDateTime())));
					}

				}catch(Exception e){
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
				
				if(scanDetail.getGeoLocation()!=null) {
					history.setLat(scanDetail.getGeoLocation().getLat().toString());
					history.setLng(scanDetail.getGeoLocation().getLang().toString());
				}
				
				if(!saleOrder.getKey_s().endsWith("RTO") && saleOrder.getCurrentStatus().getKey_s().equals(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null)) && 
						activity.equals(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null)) && responseBean.getShipmentData()[0].getShipment().getStatus().getStatus().equals("RTO")
						&& responseBean.getShipmentData()[0].getShipment().getStatus().getStatusType().equals("DL")) {
					
					activity=messageSource.getMessage(GlobalConstant.CONFIRM_RTO, null, null);
					history.setRtoAwbNumber(saleOrder.getCourierAWBNumber_s());
					//isRto = true;
				}
				if(saleOrder.getKey_s().endsWith("RTO") && activity.equals(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null))) {
					activity=messageSource.getMessage(GlobalConstant.PACKET_IN_TRANSIT, null, null);
				}
				if(!saleOrder.getKey_s().endsWith("RTO") && saleOrder.getCurrentStatus().getKey_s().equals(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null))
						&& scanDetail.getScanType().equals("LT") && responseBean.getShipmentData()[0].getShipment().getStatus().getStatus().equals("LOST") &&
						responseBean.getShipmentData()[0].getShipment().getStatus().getStatusType().equals("LT")) {
					activity = messageSource.getMessage(GlobalConstant.LOST_IN_TRANSIT, null, null);
					
				}
				history.setStatusId(activity);
				history.setUpdateDate(vendordate);
				history.setLocation(scanDetail.getScannedLocation().trim().toUpperCase());
				
				PacketsHistory packetsHistory = getPacketHistoryLastStatus(saleOrder);
				if(packetsHistory!=null){
					String bmpDateString= packetsHistory.getDate();
					Date bmpLastStatusUpdateDate = null;
					try{
						if(bmpDateString.length()<11){
							bmpLastStatusUpdateDate= new SimpleDateFormat(GlobalConstant.REPORT_DATE_FORMATE).parse(bmpDateString);//adjustment because some packet-history not in above format "yyyy/MM/dd"
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
					//VendorPacketsHistory.add(history);
				}else{
					List<VendorPacketsHistory> histories= new ArrayList<VendorPacketsHistory>();
					histories.add(history);
					vendorStatusBean.setPacketsHistory(histories);
				}
			}
			
			
			/*if(!isRto && vendorStatusBean.getPacketsHistory().size() > 0) {
				List<VendorPacketsHistory> updatedVendorPacketsHistory = new ArrayList<VendorPacketsHistory>();
				
				List<Integer> indexs = new ArrayList<>();
				
				
				for(int i=0; i<vendorStatusBean.getPacketsHistory().size(); i++) {
					
					VendorPacketsHistory vpk = vendorStatusBean.getPacketsHistory().get(i);
					if(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null).equals(vpk.getStatusId())) {
						indexs.add(i);
					}
				}
				if(!indexs.isEmpty()) {
					List<VendorPacketsHistory> actualHistory = new ArrayList<VendorPacketsHistory>();
					for(int i=0; i<vendorStatusBean.getPacketsHistory().size(); i++) {
						if(!indexs.contains(i)) {
							actualHistory.add(vendorStatusBean.getPacketsHistory().get(i));
						}
					}
					updatedVendorPacketsHistory=actualHistory;
				}
				vendorStatusBean.setPacketsHistory(updatedVendorPacketsHistory);
			}*/
			
			if(vendorStatusBean.getPacketsHistory() != null)
				Collections.sort(vendorStatusBean.getPacketsHistory());
			else
				return null;
			
			
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

	@Override
	public ResponseBean vendorWarehouseCreate(ClientWarehouse clientWarehouse,VendorApiBean vendorApiBean) throws Exception {
		ResponseBean responseBean= new ResponseBean();
		try{
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		
		httpRequestBeanNew.setRequestURL(vendorApiBean.getUrl_s());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
		//for headers
		if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
			Map<String, String> requestHeaders = new LinkedHashMap<String, String>();
			String headerParams[] = vendorApiBean.getHeader_param().split(",");
			for (int i = 0; i < headerParams.length; i++) {
				String key = headerParams[i].split("=")[0];
				String value = headerParams[i].split("=")[1];
				requestHeaders.put(key, value);
				header.add(key, value);
			}
			httpRequestBeanNew.setHeaderParams(requestHeaders);
		}
		
		//for extra parameters if requestType_s is RequestData
		String extraParamFileds = "";
		if(vendorApiBean.getRequestType_s()!=null && vendorApiBean.getRequestType_s().equals("RequestData")){
			extraParamFileds = vendorApiBean.getParams().get(0).split("#~#")[1];
			Map<String, Object> extraParamMap = new HashMap<>();
			extraParamMap.put("extraParams", extraParamFileds);
			httpRequestBeanNew.setExtraParams(extraParamMap);
		}
		Map<String, Object> requestParams = new HashMap<>();
			
		requestParams.put("name",clientWarehouse.getKey_s());
		requestParams.put("email",clientWarehouse.getEmail());
		requestParams.put("phone",clientWarehouse.getMobileNumber());
		requestParams.put("address",clientWarehouse.getAddress());
		requestParams.put("city",clientWarehouse.getCity());
		requestParams.put("country",clientWarehouse.getCountry());
		requestParams.put("pin",clientWarehouse.getPincode());
		requestParams.put("registered_name",clientWarehouse.getWarehouseName_s());
		requestParams.put("return_address",clientWarehouse.getAddress());
		requestParams.put("return_pin",clientWarehouse.getPincode());
		requestParams.put("return_city",clientWarehouse.getCity());
		requestParams.put("return_state",clientWarehouse.getState());
		requestParams.put("return_country",clientWarehouse.getCountry());
		
		httpRequestBeanNew.setRequestBody(requestParams);
		ResponseBean apiResponseBean =  new HttpUtilittyNew().PostApiCall(httpRequestBeanNew,header);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Map<String, Object> responseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
		if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
            if (responseMap.containsKey("success") && (Boolean) responseMap.get("success") == false){
            	responseBean.setMessage(responseMap.get("error").toString());
            	responseBean.setStatus(ResponseStatus.FAIL); 
            	responseBean.setResponse(responseMap);
            	/* add vendor error log */
				VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
				vendorErrorLogs.setAwbNumber(clientWarehouse.getKey_s());
				vendorErrorLogs.setLogTypes(LogTypes.WAREHOUSE_PUSH);
				vendorErrorLogs.setSubLogType(vendorApiBean.getVendorname_s());
				vendorErrorLogs.setErrorMsg(responseMap.get("error").toString());
				vendorErrorLogs.setRequestDetails(requestParams+"");
				vendorErrorLogs.setErrorMsgDetails(responseMap+"");
				vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
            	
    			return responseBean;
            }else {
            	Map<String, Object> data = (Map<String, Object>) responseMap.get("data");
            	responseBean.setMessage(data.get("message").toString());
            	responseBean.setStatus(ResponseStatus.SUCCESS); 
            	responseBean.setResponse(responseMap);
            	
            	/* add vendor success log */
				VendorSuccessLogs vendorSuccessLogs = new VendorSuccessLogs();
				vendorSuccessLogs.setAwbNumber(clientWarehouse.getKey_s());
				vendorSuccessLogs.setLogTypes(LogTypes.WAREHOUSE_PUSH);
				vendorSuccessLogs.setSubLogType(vendorApiBean.getVendorname_s());
				vendorSuccessLogs.setSuccessMsg(data.get("message").toString());
				vendorSuccessLogs.setRequestDetails(requestParams!=null?""+requestParams:"something went wrong");
				vendorSuccessLogs.setResponseDetails(""+responseMap);
				vendorSuccessLogsDao.saveObject(vendorSuccessLogs, VendorSuccessLogs.class);
				
                return responseBean;
            }
            
        }else {
        	responseBean.setMessage(responseMap.get("error").toString());
        	responseBean.setStatus(ResponseStatus.FAIL); 
        	responseBean.setResponse(responseMap);
        	
        	/* add vendor error log */
			VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
			vendorErrorLogs.setAwbNumber(clientWarehouse.getKey_s());
			vendorErrorLogs.setLogTypes(LogTypes.WAREHOUSE_PUSH);
			vendorErrorLogs.setSubLogType(vendorApiBean.getVendorname_s());
			vendorErrorLogs.setErrorMsg(responseMap.get("error").toString());
			vendorErrorLogs.setRequestDetails(requestParams+"");
			vendorErrorLogs.setErrorMsgDetails(responseMap+"");
			vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
			
			return responseBean;
        	
        }
		}catch (Exception e){
            e.printStackTrace();
        }
		responseBean.setMessage("API response fail");
		responseBean.setStatus(ResponseStatus.FAIL); 
		return responseBean;
	}

	@Override
	public ResponseBean vendorWarehouseUpdate(ClientWarehouse clientWarehouse, VendorApiBean vendorApiBean)throws Exception {
		ResponseBean responseBean= new ResponseBean();
		try{
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		
		httpRequestBeanNew.setRequestURL(vendorApiBean.getUrl_s());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
		//for headers
		if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
			Map<String, String> requestHeaders = new LinkedHashMap<String, String>();
			String headerParams[] = vendorApiBean.getHeader_param().split(",");
			for (int i = 0; i < headerParams.length; i++) {
				String key = headerParams[i].split("=")[0];
				String value = headerParams[i].split("=")[1];
				requestHeaders.put(key, value);
				header.add(key, value);
			}
			httpRequestBeanNew.setHeaderParams(requestHeaders);
		}
		
		//for extra parameters if requestType_s is RequestData
		String extraParamFileds = "";
		if(vendorApiBean.getRequestType_s()!=null && vendorApiBean.getRequestType_s().equals("RequestData")){
			extraParamFileds = vendorApiBean.getParams().get(0).split("#~#")[1];
			Map<String, Object> extraParamMap = new HashMap<>();
			extraParamMap.put("extraParams", extraParamFileds);
			httpRequestBeanNew.setExtraParams(extraParamMap);
		}
		Map<String, Object> requestParams = new HashMap<>();
			
		requestParams.put("name",clientWarehouse.getKey_s());
		requestParams.put("email",clientWarehouse.getEmail());
		requestParams.put("phone",clientWarehouse.getMobileNumber());
		requestParams.put("address",clientWarehouse.getAddress());
		requestParams.put("city",clientWarehouse.getCity());
		requestParams.put("country",clientWarehouse.getCountry());
		requestParams.put("pin",clientWarehouse.getPincode());
		requestParams.put("registered_name",clientWarehouse.getWarehouseName_s());
		requestParams.put("return_address",clientWarehouse.getAddress());
		requestParams.put("return_pin",clientWarehouse.getPincode());
		requestParams.put("return_city",clientWarehouse.getCity());
		requestParams.put("return_state",clientWarehouse.getState());
		requestParams.put("return_country",clientWarehouse.getCountry());
		
		httpRequestBeanNew.setRequestBody(requestParams);
		ResponseBean apiResponseBean =  new HttpUtilittyNew().PostApiCall(httpRequestBeanNew,header);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Map<String, Object> responseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
		if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
            if (responseMap.containsKey("success") && (Boolean) responseMap.get("success") == false){
            	responseBean.setMessage(responseMap.get("error").toString());
            	responseBean.setStatus(ResponseStatus.FAIL); 
            	responseBean.setResponse(responseMap);
            	/* add vendor error log */
    			VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
    			vendorErrorLogs.setAwbNumber(clientWarehouse.getKey_s());
    			vendorErrorLogs.setLogTypes(LogTypes.WAREHOUSE_UPDATE);
    			vendorErrorLogs.setSubLogType(vendorApiBean.getVendorname_s());
    			vendorErrorLogs.setErrorMsg(responseMap.get("error").toString());
    			vendorErrorLogs.setRequestDetails(requestParams+"");
    			vendorErrorLogs.setErrorMsgDetails(responseMap+"");
    			vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
            	
    			return responseBean;
            }else {
            	Map<String, Object> data = (Map<String, Object>) responseMap.get("data");
            	responseBean.setMessage(data.get("message").toString());
            	responseBean.setStatus(ResponseStatus.SUCCESS); 
            	responseBean.setResponse(responseMap);
            	
            	/* add vendor success log */
				VendorSuccessLogs vendorSuccessLogs = new VendorSuccessLogs();
				vendorSuccessLogs.setAwbNumber(clientWarehouse.getKey_s());
				vendorSuccessLogs.setLogTypes(LogTypes.WAREHOUSE_UPDATE);
				vendorSuccessLogs.setSubLogType(vendorApiBean.getVendorname_s());
				vendorSuccessLogs.setSuccessMsg(data.get("message").toString());
				vendorSuccessLogs.setRequestDetails(requestParams!=null?""+requestParams:"something went wrong");
				vendorSuccessLogs.setResponseDetails(""+responseMap);
				vendorSuccessLogsDao.saveObject(vendorSuccessLogs, VendorSuccessLogs.class);
				
                return responseBean;
            }
            
        }else {
        	responseBean.setMessage(responseMap.get("error").toString());
        	responseBean.setStatus(ResponseStatus.FAIL); 
        	responseBean.setResponse(responseMap);
        	
        	/* add vendor error log */
			VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
			vendorErrorLogs.setAwbNumber(clientWarehouse.getKey_s());
			vendorErrorLogs.setLogTypes(LogTypes.WAREHOUSE_UPDATE);
			vendorErrorLogs.setSubLogType(vendorApiBean.getVendorname_s());
			vendorErrorLogs.setErrorMsg(responseMap.get("error").toString());
			vendorErrorLogs.setRequestDetails(requestParams+"");
			vendorErrorLogs.setErrorMsgDetails(responseMap+"");
			vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
			
			return responseBean;
        	
        }
		
		}catch (Exception e){
            e.printStackTrace();
        }
		responseBean.setMessage("API response fail:bad request");
		responseBean.setStatus(ResponseStatus.FAIL); 
		return responseBean;
	}

	@Override
	public ResponseBean vendorPickupRequestCreate(SaleOrderPickupRequest saleOrderPickupRequest,
			VendorApiBean vendorApiBean) throws Exception {
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
