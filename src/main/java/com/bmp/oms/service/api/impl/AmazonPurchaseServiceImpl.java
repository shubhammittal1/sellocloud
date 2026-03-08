package com.bmp.oms.service.api.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LogTypes;
import com.bmp.constant.PaymentMethod;
import com.bmp.constant.PaymentType;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.StatusMasterDao;
import com.bmp.dao.VendorApiDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.api.VendorErrorLogs;
import com.bmp.model.app.api.VendorPacketsHistory;
import com.bmp.model.app.api.VendorStatusBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.VendorSuccessLogs;
import com.bmp.model.app.api.jaxbean.AmazonTrackingResponseBean;
import com.bmp.model.app.api.jaxbean.EcartTrackingResponseBean;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.api.VendorService;
import com.bmp.oms.service.api.vendorOrder.impl.EkartApiHelperImpl;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
@Qualifier("amazonPurchaseServiceImpl")
public class AmazonPurchaseServiceImpl implements VendorService{
	
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
		DateFormat pHistoryDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		VendorStatusBean vendorStatusBean = new VendorStatusBean() ;
		AmazonTrackingResponseBean amazonTrackingResponseBean = (AmazonTrackingResponseBean) mappedVendorBean;
		
		try{
			vendorStatusBean.setVendorname(saleOrder.getCourierKey_s()); 
			vendorStatusBean.setCourierawbnumber(saleOrder.getCourierAWBNumber_s());
			
			/*get vendor statuses in map*/
			Map<String, String> statusMap = vendorStatusMappingBean.getStatusMap();
			
			if(amazonTrackingResponseBean != null && amazonTrackingResponseBean.getPayload() != null && amazonTrackingResponseBean.getPayload().getEventHistory()!=null
					&& amazonTrackingResponseBean.getPayload().getEventHistory().size()>0){
                List<AmazonTrackingResponseBean.EventHistory> historyList = amazonTrackingResponseBean.getPayload().getEventHistory();
                //Collections.reverse(historyList);
                for(AmazonTrackingResponseBean.EventHistory eventHistory : historyList){
                	
                	String eventTime= eventHistory.getEventTime();
    				String eventCode = eventHistory.getEventCode();
    				String shipmentType = eventHistory.getShipmentType();
    				
    				if(eventHistory.getLocation()!=null) {
    					String stateOrRegion = eventHistory.getLocation().getStateOrRegion();
        				String countryCode = eventHistory.getLocation().getCountryCode();
        				String city = eventHistory.getLocation().getCity();
        				String postalCode = eventHistory.getLocation().getPostalCode();
    				}
    				
    				
    				String status= amazonTrackingResponseBean.getPayload().getSummary().getStatus();
    				String promisedDeliveryDate = amazonTrackingResponseBean.getPayload().getPromisedDeliveryDate();
    				
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
    				Date vendordate = dateFormat.parse(eventTime);
    				
    				VendorPacketsHistory history = new VendorPacketsHistory();
    				StatusMaster statusMaster = statusMasterDao.getObjectById(activity, StatusMaster.class);
    				history.setActivity(statusMaster.getStatusName());
    				if(activity.equals(messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null))) {
    					history.setRtoReason(rtoKey);
    					vendorStatusBean.setDrsReason(rtoKey);
    				}
					/*
					 * if(!saleOrder.getKey_s().endsWith("RTO") && shipmentType.equals("RETURNS")){
					 * activity=messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED,
					 * null, null); }
					 */
    				if(!saleOrder.getKey_s().endsWith("RTO") && saleOrder.getCurrentStatus().getKey_s().equals(messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null)) && 
    						activity.equals(messageSource.getMessage(GlobalConstant.DELIVERED, null, null)) && amazonTrackingResponseBean.getPayload().getSummary().getStatus().equals(messageSource.getMessage(GlobalConstant.DELIVERED, null, null)))
    					 {
    					activity=messageSource.getMessage(GlobalConstant.CONFIRM_RTO, null, null);
    					history.setRtoAwbNumber(saleOrder.getCourierAWBNumber_s());
    					//isRto = true;
    				}
    				
    				history.setStatusId(activity);
    				history.setUpdateDate(vendordate);
    				history.setLocation(eventHistory.getLocation()!=null?eventHistory.getLocation().getCity():"");
    				
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
		if (vendorApiBean.getHeader_param() != null && !"".equals(vendorApiBean.getHeader_param().trim())) {
			
			String headerParams[] = vendorApiBean.getHeader_param().split(",");
			for (int i = 0; i < headerParams.length; i++) {
				String key = headerParams[i].split("=")[0];
				String value = headerParams[i].split("=")[1];
				header.put(key, value);
			}
			
		}
        Date currentDate = new Date();
		if(vendorApiBean.getGeneratedToken()==null || vendorApiBean.getTokenExpiredDate().before(currentDate)) {
			try {
				String token =  getToken(vendorApiBean);
				vendorApiBean.setGeneratedToken(token);
				Calendar calendar = Calendar.getInstance();
	              // Set the date you want to modify
	              calendar.setTime(new Date());
	              // Add time (for example, adding 50 MINUTE)
	              calendar.add(Calendar.MINUTE, 50);
	              // Get the modified date
	              Date modifiedDate = calendar.getTime();
	          	Calendar cal = Calendar.getInstance();
	          	vendorApiBean.setTokenExpiredDate(modifiedDate);
	          	vendorApiBean.setTokenExpired(false);
	          	header.put("x-amz-access-token",token);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			header.put("x-amz-access-token",vendorApiBean.getGeneratedToken());
		}
		
		Map<String, Object> request = new HashMap<>();
        request.put("carrierId", saleOrder.getCarrierId());
        // List<String> list =  new ArrayList<>();
        //list.add(saleOrder.getCourierAWBNumber_s());
        request.put("trackingId",saleOrder.getCourierAWBNumber_s() );
        
        HttpRequestBeanNew requestBean = new HttpRequestBeanNew();
        requestBean.setRequestURL(vendorApiBean.getUrl_s());
        requestBean.setRequestMethod(vendorApiBean.getMethod_s());
        requestBean.setHeaderParams(header);
        requestBean.setRequestParams(request);
        return requestBean;
	}
	public static String getToken (VendorApiBean vendorApiBean) throws Exception {
		 ObjectMapper mapper = new ObjectMapper();
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		httpRequestBeanNew.setRequestURL(vendorApiBean.getTokenUrl());
		httpRequestBeanNew.setRequestMethod(vendorApiBean.getMethod_s());
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/x-www-form-urlencoded");
      MultiValueMap<String, String> properties= new LinkedMultiValueMap<String, String>();
		
		if (vendorApiBean.getParams() != null && !"".equals(vendorApiBean.getParams())) {
			for (int i = 0; i < vendorApiBean.getParams().size(); i++) {
				String key = vendorApiBean.getParams().get(i).split("=")[0];
				String value = vendorApiBean.getParams().get(i).split("=")[1];
				properties.add(key, value);
			}
			
		}
      System.out.println(properties);
		ResponseBean apiResponseBean =  new HttpUtilittyNew().httpFormCall(httpRequestBeanNew.getRequestURL(),properties,null);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
      Map<String, Object> responseMap = null;
		try {
			responseMap = mapper.readValue(apiResponseBean.getResponse().toString(), HashMap.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (ResponseStatus.SUCCESS.equals(apiResponseBean.getStatus())){
          if (responseMap.containsKey("access_token") && responseMap.get("access_token") != null || !responseMap.get("access_token").equals("") ){
          	
          	String token = responseMap.get("access_token").toString();
          	return token;
          }
          
      }
		return null;
	}

}
