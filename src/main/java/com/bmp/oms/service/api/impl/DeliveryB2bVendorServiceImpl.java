package com.bmp.oms.service.api.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LogTypes;
import com.bmp.constant.ResponseStatus;
import com.bmp.constant.WebhookType;
import com.bmp.dao.CourierDao;
import com.bmp.dao.PrintLabelWebhookDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.StatusMasterDao;
import com.bmp.dao.TrackingWebhookDao;
import com.bmp.dao.VendorApiDao;
import com.bmp.dao.VendorErrorLogsDao;
import com.bmp.dao.VendorSuccessLogsDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.api.VendorErrorLogs;
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.VendorSuccessLogs;
import com.bmp.model.app.api.jaxbean.DtdcTrackingResponseBean;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.courier.Courier;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.app.webhook.PrintLabelWebhook;
import com.bmp.model.app.webhook.TrackingWebhook;
import com.bmp.oms.service.api.VendorPrintLavelService;
import com.bmp.oms.service.api.VendorService;
import com.bmp.oms.service.api.vendorPickupLocation.VendorPickupLocationApiService;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
@Qualifier("deliveryB2bVendorServiceImpl")
public class DeliveryB2bVendorServiceImpl implements VendorService, VendorPrintLavelService, VendorPickupLocationApiService{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	@Autowired
	@Qualifier("vendorSuccessLogsDaoImpl")
	private VendorSuccessLogsDao vendorSuccessLogsDao;
	
	@Autowired
	@Qualifier("vendorErrorLogsDaoImpl")
	private VendorErrorLogsDao vendorErrorLogsDao;
	
	@Autowired
	@Qualifier("vendorApiDaoImpl")
	private VendorApiDao vendorApiDao;
	
	@Autowired
	@Qualifier("courierDaoImpl")
	private CourierDao courierDao;
	
	@Autowired	
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired
	@Qualifier("trackingWebhookDaoImpl")
	private TrackingWebhookDao trackingWebhookDao;
	
	private ObjectMapper mapper = new ObjectMapper();
	Gson gson = new Gson();
	
	@Autowired
	@Qualifier("printLabelWebhookDaoImpl")
	private PrintLabelWebhookDao printLabelWebhookDao;

	@Override
	public ResponseBean vendorWarehouseCreate(ClientWarehouse clientWarehouse, VendorApiBean vendorApiBean)
			throws Exception {
		ResponseBean responseBean= new ResponseBean();
		try{	
		Date currentDate = new Date();
		Courier courier = courierDao.getObjectById(vendorApiBean.getVendorname_s(),Courier.class);
		if(courier.getToken()==null || courier.getToken()=="NA"|| courier.getTokenExpiredDate()==null || courier.getTokenExpiredDate().before(currentDate)) {
			getToken(vendorApiBean);
		}
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		httpRequestBeanNew.setRequestURL(vendorApiBean.getUrl_s());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization",courier.getToken());
			if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
				String headerParams[] = vendorApiBean.getHeader_param().split(",");
				for (int i = 0; i < headerParams.length; i++) {
					String key = headerParams[i].split("=")[0];
					String value = headerParams[i].split("=")[1];
					header.add(key, value);
				}
			}
		
		//for extra parameters if requestType_s is RequestData
		
		Map<String, Object> requestParams = new HashMap<>();
		
		requestParams.put("pin_code",clientWarehouse.getPincode());
		requestParams.put("city", clientWarehouse.getCity());
		requestParams.put("country", clientWarehouse.getCountry());
		
		Map<String, String> addressDetails = new HashMap<>();
		addressDetails.put("address", clientWarehouse.getAddress());
		addressDetails.put("contact_person", clientWarehouse.getContactPersonName());
		addressDetails.put("phone_number", clientWarehouse.getMobileNumber());
		requestParams.put("address_details",addressDetails);
		
		requestParams.put("name",clientWarehouse.getWarehouseName_s());
		
		Map<String, String> retAddress = new HashMap<>();
		retAddress.put("pin", clientWarehouse.getPincode());
		retAddress.put("address", clientWarehouse.getAddress());
		requestParams.put("ret_address",retAddress);
		
		httpRequestBeanNew.setRequestBody(requestParams);
		ResponseBean apiResponseBean =  new HttpUtilittyNew().PostApiCall(httpRequestBeanNew,header);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Map<String, Object> responseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
		if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
            if (responseMap.containsKey("success") && (Boolean) responseMap.get("success") == false){
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
		responseBean.setMessage("API response fail:bad request");
		responseBean.setStatus(ResponseStatus.FAIL); 
		return responseBean;
	}

	@Override
	public ResponseBean vendorWarehouseUpdate(ClientWarehouse clientWarehouse, VendorApiBean vendorApiBean)
			throws Exception {
		ResponseBean responseBean= new ResponseBean();
		try{	
		Date currentDate = new Date();
		Courier courier = courierDao.getObjectById(vendorApiBean.getVendorname_s(),Courier.class);
		if(courier.getToken()==null || courier.getToken()=="NA"|| courier.getTokenExpiredDate()==null || courier.getTokenExpiredDate().before(currentDate)) {
			getToken(vendorApiBean);
		}
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		httpRequestBeanNew.setRequestURL(vendorApiBean.getUrl_s());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization",courier.getToken());
			if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
				String headerParams[] = vendorApiBean.getHeader_param().split(",");
				for (int i = 0; i < headerParams.length; i++) {
					String key = headerParams[i].split("=")[0];
					String value = headerParams[i].split("=")[1];
					header.add(key, value);
				}
			}
		
		//for extra parameters if requestType_s is RequestData
		
		Map<String, Object> requestParams = new HashMap<>();
		requestParams.put("cl_warehouse_name",clientWarehouse.getWarehouseName_s());
		Map<String, Object> updateDict = new HashMap<>();
		
		updateDict.put("city", clientWarehouse.getCity());
		updateDict.put("state", clientWarehouse.getState());
		updateDict.put("country", clientWarehouse.getCountry());
		
		requestParams.put("pin_code",clientWarehouse.getPincode());
		Map<String, String> addressDetails = new HashMap<>();
		addressDetails.put("address", clientWarehouse.getAddress());
		addressDetails.put("contact_person", clientWarehouse.getContactPersonName());
		addressDetails.put("phone_number", clientWarehouse.getMobileNumber());
		addressDetails.put("email", clientWarehouse.getEmail());
		addressDetails.put("company", clientWarehouse.getWarehouseName_s());
		Map<String, String> retAddress = new HashMap<>();
		retAddress.put("pin", clientWarehouse.getReturnPincode());
		retAddress.put("address", clientWarehouse.getReturnAddress());
		
		updateDict.put("address_details",addressDetails);
		updateDict.put("ret_address",retAddress);
		requestParams.put("update_dict", updateDict);
		
		httpRequestBeanNew.setRequestBody(requestParams);
		ResponseBean apiResponseBean =  new HttpUtilittyNew().PostApiCall(httpRequestBeanNew,header);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Map<String, Object> responseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
		if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
            if (responseMap.containsKey("success") && (Boolean) responseMap.get("success") == false){
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
	public VendorStatusBean statusMapping(Object mappedVendorBean, SaleOrder saleOrder,
			VendorStatusMappingBean vendorStatusMappingBean) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		VendorStatusBean vendorStatusBean = new VendorStatusBean() ;
		
		Query query = new Query();
        query.addCriteria(Criteria.where("courierAwb").is(saleOrder.getCourierAWBNumber_s())
        		.and("webhookType").is(WebhookType.DELHIVERY));
         List<TrackingWebhook> trackingWebhookList= trackingWebhookDao.getObjectByQuery(query, TrackingWebhook.class);
         Map<String, TrackingWebhook> scanMap = new LinkedHashMap<String, TrackingWebhook>();
		try{
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s()); 
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
			
			/*get vendor statuses in map*/
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
			if(trackingWebhookList == null || trackingWebhookList.isEmpty()){
                System.out.println("Status not found.");
                return null;
            }
			if(trackingWebhookList != null){
                for(TrackingWebhook  trackingWebhook : trackingWebhookList){
                	int k =0;
                	Map<String, Object> trackMap = mapper.readValue(trackingWebhook.getPayload(), HashMap.class);
                	String status = trackMap.get("statusType")+"_"+trackMap.get("status");
                	
                	//String status = trackMap.get("status").toString();
                	status = status.replaceAll("\\s","").toUpperCase();
                    String vendorLocation = trackMap.get("location").toString();
    				String eventCode =status;
    				Object waybillNo =  trackMap.get("waybillNo");
    				if(waybillNo==null) {
    					continue;
    				}
    				if(waybillNo.toString()!=null && !waybillNo.toString().equals(saleOrder.getCourierMasterAWBNumber())) {
    					continue;
    				}
    				
    				Date  vendordate = dateFormat.parse(trackMap.get("timestamp").toString());
    				String activity = null;
    				String statusValue = null;
    				String rtoKey = null;
    				if(statusMap.containsKey(eventCode)){
    					statusValue = statusMap.get(eventCode);
    				}else if(statusMap.containsKey((trackMap.get("statusType")+"_"+trackMap.get("shipment_remark")).replaceAll("\\s","").toUpperCase())) {
    					eventCode = (trackMap.get("statusType")+"_"+trackMap.get("shipment_remark")).replaceAll("\\s","").toUpperCase();
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
    				VendorPacketsHistory history = new VendorPacketsHistory();
    				StatusMaster statusMaster = statusMasterDao.getObjectById(activity, StatusMaster.class);
    				history.setActivity(statusMaster.getStatusName());
    				if(activity.equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
    					history.setRtoReason(rtoKey);
    					vendorStatusBean.setDrsReason(rtoKey);
    				}
    				history.setStatusId(activity);
    				history.setUpdateDate(vendordate);
    				history.setLocation(vendorLocation);
    				
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
	
	private boolean historyConsume (Map<String, Object> currentTrackMap, Map<String, Object> previousTrackMap) throws Exception {
    	boolean flag = true;
    	String shipment_remark = (String) currentTrackMap.get("shipment_remark");
        String status_type = (String) currentTrackMap.get("status_type");
        String statusName = (String) currentTrackMap.get("status");
        String location = (String) currentTrackMap.get("location");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date currentScanDate = dateFormat.parse(currentTrackMap.get("timestamp").toString().substring(0, currentTrackMap.get("timestamp").toString().indexOf('.')));
        
        if(shipment_remark.equals((String) previousTrackMap.get("shipment_remark")) 
        		&& status_type.equals((String) previousTrackMap.get("status_type"))
        		&& statusName.equals((String) previousTrackMap.get("status"))
        		&& location.equals((String) previousTrackMap.get("location"))) {
        	
        	flag = false;
        	
        }
    	return flag;
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
    public ResponseBean VendorCreatePrintLabel(SaleOrder saleOrder,VendorApiBean vendorApiBean, HttpServletResponse response) {
		ResponseBean responseBean= new ResponseBean();
		try{
			Date currentDate = new Date();
			Courier courier = courierDao.getObjectById(vendorApiBean.getVendorname_s(),Courier.class);
			if(courier.getToken()==null || courier.getToken()=="NA"|| courier.getTokenExpiredDate()==null || courier.getTokenExpiredDate().before(currentDate)) {
				getToken(vendorApiBean);
			}
			HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
			httpRequestBeanNew.setRequestURL(vendorApiBean.getUrl_s()+"/"+vendorApiBean.getExtra2()+"/"+saleOrder.getCourierAWBNumber_s());
			httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
			HttpHeaders header = new HttpHeaders();
			//Map<String,String> header = new HashMap<>();
			header.add("Authorization",courier.getToken());
				if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
					String headerParams[] = vendorApiBean.getHeader_param().split(",");
					for (int i = 0; i < headerParams.length; i++) {
						String key = headerParams[i].split("=")[0];
						String value = headerParams[i].split("=")[1];
						header.add(key, value);
					}
				}
            /*JSONObject payload = new JSONObject();
            payload.put("lrns",Arrays.asList("281317362"));
            payload.put("size","md");
            JSONObject calBack = new JSONObject();
            String serviceUrl = messageSource.getMessage(GlobalConstant.SERVICE_URL, null, null);
            String URI = "https://cloud.sellocloud.com/ERP/webhooks/labelCallBack";
            calBack.put("uri",URI);
            calBack.put("method","POST");

            JSONObject cbheader = new JSONObject();
            cbheader.put(GlobalConstant.SALE_ORDER_WEBHOOK_SOURCE_KEY, "KJyu623trweyrt76trwet6wt3w");
            cbheader.put(GlobalConstant.SALE_ORDER_WEBHOOK_SOURCE, "DELHIVERY");
            calBack.put("headers",cbheader);*/

            //payload.put("callback",calBack);
            //httpRequestBeanNew.setHeaderParams(header);
            //Map<String, StringBuffer> requestResponse = new HttpUtilittyNew().call(httpRequestBeanNew);
            //StringBuffer strResponse = requestResponse.get("response");
    		//JsonObject json = (JsonObject)new JsonParser().parse(response.toString());
    		
            //ResponseBean apiResponseBean =  new HttpUtilittyNew().call(httpRequestBeanNew);
			
            ResponseBean apiResponseBean =  new HttpUtilittyNew().GetApiCall(httpRequestBeanNew,header);
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            Map<String, Object> labelResponseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
            //JSONObject jsonResponse = new JSONObject(apiResponseBean.getResponse());
            List<String>baseCodeList = new ArrayList<>();
            if(labelResponseMap.containsKey("success")){
                if((Boolean)labelResponseMap.get("success")==true){
                	List<String> urlList = (List<String>) labelResponseMap.get("data");
                	HttpRequestBeanNew labelRequestBean = new HttpRequestBeanNew();
            		labelRequestBean.setRequestMethod("GET");
                	if(urlList!=null && urlList.size()>=0) {
                		for(String url :urlList) {
                			labelRequestBean.setRequestURL(url);
                			ResponseBean labelResponse =  new HttpUtilittyNew().GetApiCall(labelRequestBean,header);
                			Map<String, Object> labelurlResponseMap = mapper.readValue(labelResponse.getResponse().toString(), HashMap.class);
                			//JSONObject jsonLabelResponse = new JSONObject(labelResponse.getResponse().toString());
                			
                			if(labelurlResponseMap.containsKey("data")) {
                				String data =labelurlResponseMap.get("data").toString();
                				String dataArray[] = data.split(",");
                				String baseCode = dataArray[1].split(",")[0];
                				baseCodeList.add(baseCode);
                			}
                		}
                		
                	}
                    /*String requestId = jsonResponse.getString("request_id");
                    long t= System.currentTimeMillis();
                    long end = t+30000;
                    String labelUrl = null;
                    while(System.currentTimeMillis() < end) {
                    	Query query = new Query();
                        query.addCriteria(Criteria.where("awbNumber").is(requestId));
                        PrintLabelWebhook labelWebhook = printLabelWebhookDao.getObjectById(requestId, PrintLabelWebhook.class);
                    	
                        if(labelWebhook != null ){
                            JSONObject obj = new JSONObject(labelWebhook.getPayload());
                            if(obj.has("data")){
                                labelUrl = obj.getJSONObject("data").getString("presigned_url");
                                printLabelWebhookDao.remove(labelWebhook.getKey_s(), PrintLabelWebhook.class);
                                break;
                            }
                        }else {
                            Thread.sleep(2000);
                        }

                    }*/
                    if(baseCodeList == null || baseCodeList.isEmpty()){
                    	responseBean.setMessage("Label not get from partner side.");
                		responseBean.setStatus(ResponseStatus.FAIL); 
                        return responseBean;
                    }
                    responseBean.setStatus(ResponseStatus.SUCCESS);
                    responseBean.setResponse(baseCodeList);
                    return responseBean;
                }else{
                     Map<String,Object>errorMap = (Map<String, Object>) labelResponseMap.get("error");
                    int ststusCode = (int) errorMap.get("code");
                    if(ststusCode == 400 || ststusCode==401){
                        //Courier courier = courierRepository.findById(apiConfig.getEntityId()).get();
                        //courier.setApiToken(null);
                        //courierRepository.update(courier);

                        responseBean.setMessage(errorMap.get("message").toString());
                		responseBean.setStatus(ResponseStatus.FAIL); 
                		return responseBean;
                        //return ResponseBean.builder().status(ResponseStatus.FAIL).response("Please try again.").build();
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
		responseBean.setMessage("API response fail");
		responseBean.setStatus(ResponseStatus.FAIL); 
		return responseBean;
    }
	
	
	public  VendorApiBean getToken (VendorApiBean vendorApiBean) throws Exception {
		 ObjectMapper mapper = new ObjectMapper();
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		httpRequestBeanNew.setRequestURL(vendorApiBean.getTokenUrl());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
		Map<String, Object> requestParams = new HashMap<>();
		requestParams.put("username", vendorApiBean.getCarrierId());
		requestParams.put("password", vendorApiBean.getExtra1());
        httpRequestBeanNew.setRequestBody(requestParams);
		ResponseBean apiResponseBean =  new HttpUtilittyNew().PostApiCall(httpRequestBeanNew,header);
		//ResponseBean apiResponseBean =  new HttpUtilittyNew().httpFormCall(httpRequestBeanNew.getRequestURL(),properties,null);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Map<String, Object> responseMap = null;
		try {
			responseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
         if (responseMap.containsKey("data") && responseMap.get("data") != null || !responseMap.get("data").equals("") ){
        	 Calendar calendar = Calendar.getInstance();
             // Set the date you want to modify
             calendar.setTime(new Date());
             // Add time (for example, adding 1 hour)
             calendar.add(Calendar.HOUR,23);
             // Get the modified date
             Date modifiedDate = calendar.getTime();
        	 Map<String, String> tokenMAp = (Map<String, String>) responseMap.get("data");
        	 vendorApiBean.setTokenExpiredDate(modifiedDate);
        	 vendorApiBean.setGeneratedToken(tokenMAp.get("jwt"));
        	 Courier courier = courierDao.getObjectById(vendorApiBean.getVendorname_s(),Courier.class);
        	 courier.setToken("Bearer "+tokenMAp.get("jwt"));
        	 courier.setTokenExpiredDate(modifiedDate);
        	 courierDao.updateObject(courier);
        	 vendorApiDao.updateObject(vendorApiBean);
        	 
        	 return vendorApiBean;
         	
         }
         
     }
		return null;
	}

	@Override
	public ResponseBean vendorPickupRequestCreate(SaleOrderPickupRequest saleOrderPickupRequest, VendorApiBean vendorApiBean) throws Exception {
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		Date currentDate = new Date();
		Courier courier = courierDao.getObjectById(vendorApiBean.getVendorname_s(),Courier.class);
		if(courier.getToken()==null || courier.getToken()=="NA"|| courier.getTokenExpiredDate()==null || courier.getTokenExpiredDate().before(currentDate)) {
			getToken(vendorApiBean);
		}
		//vendorBean=vendorApiBean;
		ResponseBean responseBean= new ResponseBean();
		Map<String, Object> requestParams = new HashMap<>();
		try{
		httpRequestBeanNew.setRequestURL(vendorApiBean.getUrl_s());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization",courier.getToken());
			if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
				String headerParams[] = vendorApiBean.getHeader_param().split(",");
				for (int i = 0; i < headerParams.length; i++) {
					String key = headerParams[i].split("=")[0];
					String value = headerParams[i].split("=")[1];
					header.add(key, value);
				}
			}
			
			requestParams.put("client_warehouse",saleOrderPickupRequest.getClientWarehouse().getWarehouseName_s());
			
			String datenadTime = saleOrderPickupRequest.getPickupDateTime();
			String[] splitStr = datenadTime.split("\\s+");
			
			requestParams.put("pickup_date",splitStr[0].replace("/", "-"));
			requestParams.put("start_time",splitStr[1]);
			requestParams.put("expected_package_count",saleOrderPickupRequest.getExpectedPackageCount());
			httpRequestBeanNew.setRequestBody(requestParams);
			ResponseBean apiResponseBean =  new HttpUtilittyNew().PostApiCall(httpRequestBeanNew,header);
	        if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
                mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                Map<String, Object> pickupResponseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
                if (pickupResponseMap.containsKey("success") && (Boolean) pickupResponseMap.get("success") == false){
                    responseBean.setMessage(pickupResponseMap.get("error").toString());
                    responseBean.setStatus(ResponseStatus.FAIL);
                    
                    /* add vendor error log */
        			VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
        			vendorErrorLogs.setAwbNumber(saleOrderPickupRequest.getKey_s());
        			vendorErrorLogs.setLogTypes(LogTypes.PICKUP_REQUEST);
        			vendorErrorLogs.setSubLogType(vendorApiBean.getVendorname_s());
        			vendorErrorLogs.setErrorMsg(pickupResponseMap.get("error").toString());
        			vendorErrorLogs.setRequestDetails(requestParams+"");
        			vendorErrorLogs.setErrorMsgDetails(pickupResponseMap+"");
        			vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
                    
                    
                    return responseBean;
                }else {
                	Map<String, Object> responseMap = (Map<String, Object>) pickupResponseMap.get("data");
                	responseBean.setStatus(ResponseStatus.SUCCESS);
                    int partnerId = (int)responseMap.get("pickup_id");
                    saleOrderPickupRequest.setCourierPickupId(String.valueOf(partnerId));
                    String pickupDate = responseMap.get("pickup_date").toString();
                    String pickupTime = responseMap.get("pickup_time").toString();
                    String dateTime = pickupDate.replace("-", "/")+" "+pickupTime;
                    saleOrderPickupRequest.setPickupDateTime(dateTime);
                    DateFormat formatter = new SimpleDateFormat(GlobalConstant.DATE_FORMATE);
                    Date date = null;
                    try {
    					if (saleOrderPickupRequest.getPickupDateTime() != null && !"".equals(saleOrderPickupRequest.getPickupDateTime())) {
    						date = formatter.parse(dateTime);
    					} else {
    						date = new Date();
    						saleOrderPickupRequest.setPickupDateTime(formatter.format(date));
    					}
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
                    saleOrderPickupRequest.setPickupDateTimeLong_l(date.getTime());
                    responseBean.setResponse(saleOrderPickupRequest);
                    
                    VendorSuccessLogs vendorSuccessLogs = new VendorSuccessLogs();
    				vendorSuccessLogs.setAwbNumber(saleOrderPickupRequest.getKey_s());
    				vendorSuccessLogs.setLogTypes(LogTypes.PICKUP_REQUEST);
    				vendorSuccessLogs.setSubLogType(vendorApiBean.getVendorname_s());
    				//vendorSuccessLogs.setSuccessMsg(data.get("message").toString());
    				vendorSuccessLogs.setRequestDetails(requestParams!=null?""+requestParams:"something went wrong");
    				vendorSuccessLogs.setResponseDetails(""+responseMap);
    				vendorSuccessLogsDao.saveObject(vendorSuccessLogs, VendorSuccessLogs.class);
                    
                    return responseBean;
                }
            }
			}catch (Exception e){
	            e.printStackTrace();
	        }
			responseBean.setMessage("API response fail");
			responseBean.setStatus(ResponseStatus.FAIL); 
			/* add vendor error log */
			VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
			vendorErrorLogs.setAwbNumber(saleOrderPickupRequest.getKey_s());
			vendorErrorLogs.setLogTypes(LogTypes.CANCEL_PICKUP_REQUEST);
			vendorErrorLogs.setSubLogType(vendorApiBean.getVendorname_s());
			vendorErrorLogs.setErrorMsg("API response fail");
			vendorErrorLogs.setRequestDetails(requestParams+"");
			vendorErrorLogs.setErrorMsgDetails("Unauthorised");
			vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
			
			return responseBean;
		
	}

	@Override
	public ResponseBean vendorPickupRequestCancel(SaleOrderPickupRequest saleOrderPickupRequest,
			VendorApiBean vendorApiBean) throws Exception {
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		Date currentDate = new Date();
		Courier courier = courierDao.getObjectById(vendorApiBean.getVendorname_s(),Courier.class);
		if(courier.getToken()==null || courier.getToken()=="NA"|| courier.getTokenExpiredDate()==null || courier.getTokenExpiredDate().before(currentDate)) {
			getToken(vendorApiBean);
		}
		//vendorBean=vendorApiBean;
		ResponseBean responseBean= new ResponseBean();
		try{
		httpRequestBeanNew.setRequestURL(vendorApiBean.getUrl_s()+"/"+saleOrderPickupRequest.getCourierPickupId());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization",courier.getToken());
			if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
				String headerParams[] = vendorApiBean.getHeader_param().split(",");
				for (int i = 0; i < headerParams.length; i++) {
					String key = headerParams[i].split("=")[0];
					String value = headerParams[i].split("=")[1];
					header.add(key, value);
				}
			}
			ResponseBean apiResponseBean =  new HttpUtilittyNew().PostApiCall(httpRequestBeanNew,header);
			//mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	       // Map<String, Object> responseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
	        if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
                mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
                Map<String, Object> pickupResponseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
                if (pickupResponseMap.containsKey("success") && (Boolean) pickupResponseMap.get("success") == false){
                    responseBean.setMessage(pickupResponseMap.get("error").toString());
                    responseBean.setStatus(ResponseStatus.FAIL);
                    
                    /* add vendor error log */
        			VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
        			vendorErrorLogs.setAwbNumber(saleOrderPickupRequest.getKey_s());
        			vendorErrorLogs.setLogTypes(LogTypes.CANCEL_PICKUP_REQUEST);
        			vendorErrorLogs.setSubLogType(vendorApiBean.getVendorname_s());
        			vendorErrorLogs.setErrorMsg(pickupResponseMap.get("error").toString());
        			vendorErrorLogs.setRequestDetails(vendorApiBean.getUrl_s()+"/"+saleOrderPickupRequest.getCourierPickupId());
        			vendorErrorLogs.setErrorMsgDetails(pickupResponseMap+"");
        			vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
                    return responseBean;
                }else {
                	responseBean.setStatus(ResponseStatus.SUCCESS);
                   
                	 VendorSuccessLogs vendorSuccessLogs = new VendorSuccessLogs();
     				vendorSuccessLogs.setAwbNumber(saleOrderPickupRequest.getKey_s());
     				vendorSuccessLogs.setLogTypes(LogTypes.CANCEL_PICKUP_REQUEST);
     				vendorSuccessLogs.setSubLogType(vendorApiBean.getVendorname_s());
     				//vendorSuccessLogs.setSuccessMsg(data.get("message").toString());
     				vendorSuccessLogs.setRequestDetails(vendorApiBean.getUrl_s()+"/"+saleOrderPickupRequest.getCourierPickupId());
     				vendorSuccessLogs.setResponseDetails(apiResponseBean.getStatus()+"");
     				vendorSuccessLogsDao.saveObject(vendorSuccessLogs, VendorSuccessLogs.class);
                	
                    return responseBean;
                }
            }
			}catch (Exception e){
	            e.printStackTrace();
	        }
			responseBean.setMessage("API response fail");
			responseBean.setStatus(ResponseStatus.FAIL); 
			/* add vendor error log */
			VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
			vendorErrorLogs.setAwbNumber(saleOrderPickupRequest.getKey_s());
			vendorErrorLogs.setLogTypes(LogTypes.CANCEL_PICKUP_REQUEST);
			vendorErrorLogs.setSubLogType(vendorApiBean.getVendorname_s());
			vendorErrorLogs.setErrorMsg("API response fail");
			vendorErrorLogs.setRequestDetails(vendorApiBean.getUrl_s()+"/"+saleOrderPickupRequest.getCourierPickupId());
			vendorErrorLogs.setErrorMsgDetails("Unauthorised");
			vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
			
			return responseBean;
	}
	
	

}
