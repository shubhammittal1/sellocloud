package com.bmp.oms.service.api.alert.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.AlertStatus;
import com.bmp.constant.AlertType;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LogTypes;
import com.bmp.constant.RequestMethod;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.AlertErrorLogsDao;
import com.bmp.dao.AlertSuccessLogsDao;
import com.bmp.dao.BranchDao;
import com.bmp.dao.ClientDao;
import com.bmp.dao.DrsDao;
import com.bmp.dao.ManifestDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.SaleOrderExtraDao;
import com.bmp.dao.SettingsDao;
import com.bmp.dao.SmsMailMasterDao;
import com.bmp.dao.UserDao;
import com.bmp.dao.VendorErrorLogsDao;
import com.bmp.dao.VendorSuccessLogsDao;
import com.bmp.model.app.client.Client;
import com.bmp.model.app.config.Settings;
import com.bmp.model.app.drs.Drs;
import com.bmp.model.app.facility.User;
import com.bmp.model.app.saleorder.AlertErrorLogs;
import com.bmp.model.app.saleorder.AlertSuccessLogs;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderExtra;
import com.bmp.model.app.utility.AlertMaster;
import com.bmp.model.app.utility.SmsMailMaster;
import com.bmp.model.base.MongoBaseBean;
import com.bmp.oms.service.api.alert.AlertApiHelper;
import com.bmp.oms.service.systemCalling.SendManualSmsService;
import com.bmp.sms.util.HTTPConnectionUtility;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpResponseBean;
import com.bmp.utility.logger.AsyncLogger;

@Service
@Qualifier("smsApiHelperImpl")
public class SmsApiHelperImpl implements AlertApiHelper {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;

	@Autowired
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Autowired
	@Qualifier("branchDaoImpl")
	private BranchDao branchDao;
	
	@Autowired
	@Qualifier("manifestDaoImpl")
	private ManifestDao manifestDao;
	
	@Autowired
	@Qualifier("HTTPConnectionUtility")
	private HTTPConnectionUtility httpConnectionUtility;
	
	@Autowired
	@Qualifier("vendorSuccessLogsDaoImpl")
	private VendorSuccessLogsDao vendorSuccessLogsDao;
	
	@Autowired
	@Qualifier("vendorErrorLogsDaoImpl")
	private VendorErrorLogsDao vendorErrorLogsDao;
	
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired
	@Qualifier("clientDaoImpl")
	private ClientDao clientDao;
	
	@Autowired	
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired	
	@Qualifier("settingsDaoImpl")
	private SettingsDao settingsDao;
	
	@Autowired
	@Qualifier("alertSuccessLogsDaoImpl")
	private AlertSuccessLogsDao alertSuccessLogsDao;
	
	@Autowired
	@Qualifier("smsMailMasterDaoImpl")
	private SmsMailMasterDao smsMailMasterDao;
	
	@Autowired
	@Qualifier("saleOrderExtraDaoImpl")
	private SaleOrderExtraDao saleOrderExtraDao;
	
	
	@Autowired
	@Qualifier("sendManualSmsServiceImpl")
	private SendManualSmsService sendManualSmsService;
	
	
	@Autowired
	@Qualifier("alertErrorLogsDaoImpl")
	private AlertErrorLogsDao alertErrorLogsDao;
	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;
	
	@Autowired
	@Qualifier("drsDaoImpl")
	private DrsDao drsDao;
	
	private String USER_NAME;
	private String PASSWORD;
    private String SENDER_ID;
    private String API_URL;

    @Override
	public HttpRequestBeanNew getAlertRequestBean(AlertMaster alertMaster, MongoBaseBean baseBean) throws Exception {
    	
    	Class class1 = baseBean.getClass();
    	Field[] fields = class1.getDeclaredFields();
    	Map<String, Object> fieldValMap = new HashMap<>();
    	Map<String, Map<String, Object>> innerValMap = new HashMap<>();
    	for(Field field : fields) {
    		field.setAccessible(true);
    		if (field.getType().getName().contains("java.lang") || field.getType().isPrimitive()) {    			
    			fieldValMap.put(field.getName(), field.get(baseBean));
    			if (baseBean instanceof SaleOrder) {
	    			if (field.getName().equals("clientKey_s")) {
	    				fieldValMap.put(field.getName(), clientDao.getObjectById((String)field.get(baseBean), Client.class).getDisplayName());
					}
    			}
    		} else {
    			Map<String, Object> temp = new HashMap<>();
    			if (field.getType().getName().contains("java.util")) {
    				boolean isMap = Map.class.isAssignableFrom(field.getType());
    				if (isMap) {
    					Map map = (Map)field.get(baseBean);
    					if (map != null) {
    						Object lastMapValue = null;
    						for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
    							lastMapValue = map.get(iterator.next());
    						}
    						if (lastMapValue != null) {
    							Field[] innerFieldsMap = lastMapValue.getClass().getDeclaredFields();
    			    			for (Field innerField1 : innerFieldsMap) {
    			    				innerField1.setAccessible(true);
    			    				temp.put(innerField1.getName(), innerField1.get(lastMapValue));
    			    				if (baseBean instanceof SaleOrder) {
    			    					if (innerField1.getName().equals("rtoReason")) {
    			    						String rtoReason = innerField1.get(lastMapValue)!=null ?(String)innerField1.get(lastMapValue):null;
    			    						if(rtoReason!=null && rtoReason.length()>0){
    			    							temp.put(innerField1.getName(),settingsDao.getObjectById((String)innerField1.get(lastMapValue), Settings.class).getDescription());
    			    						}
    			    					}
    			    				}
    			    			}
        					}
    					}
    				}
    				
    			} else {
	    			Field[] innerFields2 = field.getType().getDeclaredFields();
	    			for (Field innerField2 : innerFields2) {
	    				innerField2.setAccessible(true);
	    				temp.put(innerField2.getName(), innerField2.get(field.get(baseBean)));
	    			}
    			}
    			innerValMap.put(field.getName(), temp);
    		}
    	}
    	
    	String message = alertMaster.getTemplateDetails();
    	// Change bmpcontact from setting details
    	String bmpcontact = messageSource.getMessage(GlobalConstant.BMP_SMS_CONTACT_DETAILS, null, null).trim();
    	Settings settings = settingsDao.getObjectById(bmpcontact, Settings.class);
    	if(settings != null && message.contains(settings.getContextCode_s())) {
    		message = message.replaceAll(settings.getContextCode_s(), settings.getContextValue_s());
    	}
    	
    	if(message.contains("#dialerPin")) {
    		if (baseBean instanceof SaleOrder) {
    			SaleOrder saleOrder = (SaleOrder) baseBean;
    			if(saleOrder.getDrsList() != null && !saleOrder.getDrsList().isEmpty()) {
    				Drs drs = drsDao.getObjectById(saleOrder.getDrsList().get(saleOrder.getDrsList().size()-1), Arrays.asList("_id,deliveryBoyKey_s".split(",")), Drs.class);
    				if(drs != null && drs.getDeliveryBoyKey_s() != null) {
    					User user = userDao.getObjectById(drs.getDeliveryBoyKey_s(), Arrays.asList("_id,diallerPin".split(",")), User.class);
    		    		if(user != null ) {
    		    			message = message.replaceAll("#dialerPin", user.getDiallerPin() != null ? user.getDiallerPin() : "");
    		    		}
    				}
    			}
    		}
    	}
    	if(message.contains("#urlShortcut")) {
    		settings =settingsDao.getObjectById(messageSource.getMessage(GlobalConstant.BMP_URL_SHORTCUT, null, null).trim(), Settings.class);
    		if(settings != null && settings.getContextValue_s() != null) {
        		message = message.replaceAll("#urlShortcut", settings.getContextValue_s());
        	}
    	}
    	if(message.contains("#pinVertualNumber")) {
    		settings =settingsDao.getObjectById(messageSource.getMessage(GlobalConstant.EXOTEL_PIN_CALLING_PHONE, null, null).trim(), Settings.class);
    		if(settings != null && settings.getContextValue_s() != null) {
        		message = message.replaceAll("#pinVertualNumber", settings.getContextValue_s());
        	}
    	}
    	if(message.contains("#bmpSupportEmail")) {
    		settings =settingsDao.getObjectById(messageSource.getMessage(GlobalConstant.BMP_SUPPORT_EMAIL, null, null).trim(), Settings.class);
    		if(settings != null && settings.getContextValue_s() != null) {
        		message = message.replaceAll("#urlShortcut", settings.getContextValue_s());
        	}
    	}
    	
		String fieldsArray [] = alertMaster.getParams().split(",");
		for (String string : fieldsArray) {
			string = string.replaceAll("\\s","");
			if (string.contains(".")) {
				message = message.replaceAll("#"+string, ""+innerValMap.get(string.split("\\.")[0]).get(string.split("\\.")[1]));
			} else if(string.contains("SaleOrderExtra")) {
				if (baseBean instanceof SaleOrder) {
					SaleOrder saleOrder = (SaleOrder) baseBean;
					message = getSaleOrderExtraFieldValue(alertMaster, saleOrder, message);
    			}
			}else {
				message = message.replaceAll("#"+string, ""+fieldValMap.get(string));
			}
		}
		
		HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
		httpRequestBeanNew.setRequestURL(messageSource.getMessage(GlobalConstant.SMS_API_URL, null, null));
		httpRequestBeanNew.setRequestMethod(RequestMethod.GET.toString());
		
		USER_NAME = messageSource.getMessage(GlobalConstant.SMS_USERNAME, null, null);
		PASSWORD = messageSource.getMessage(GlobalConstant.SMS_PASSWORD, null, null);
		SENDER_ID = messageSource.getMessage(GlobalConstant.SMS_SENDER_ID, null, null);
		API_URL = messageSource.getMessage(GlobalConstant.SMS_API_URL, null, null);
		
		Map<String, Object> requestParams = new HashMap<String, Object>();
		requestParams.put("username", USER_NAME);
		requestParams.put("password", PASSWORD);
		requestParams.put("from", SENDER_ID);
		if(baseBean instanceof SaleOrder) {
			SaleOrder saleOrder = (SaleOrder) baseBean;
			if(messageSource.getMessage(GlobalConstant.APOLLO_CLIENT_KEY, null, null).equals(saleOrder.getClientKey_s())) {
				requestParams.put("from", messageSource.getMessage(GlobalConstant.APOLLO_SMS_SENDER_ID, null, null));
			}
		}
		requestParams.put("to", ((String)FieldUtils.readField(baseBean, alertMaster.getTo(), true)).replaceAll("\\s",""));
		requestParams.put("text",message);
		
		//realTime sms send check 
		if(!alertMaster.isRealTimeAlert()) {
			SmsMailMaster smsMailMaster =  new SmsMailMaster();
			smsMailMaster.setKey_s(String.valueOf(new Date().getTime()));
			if(baseBean instanceof SaleOrder) {
				smsMailMaster.setAwb(baseBean.getKey_s());
			}
			smsMailMaster.setAlertMasterId(alertMaster.getKey_s());
			smsMailMaster.setAlertStatus_s(AlertStatus.PENDING);
			smsMailMaster.setAlertType_s(AlertType.SMS);
			smsMailMaster.setTo(requestParams.get("to").toString());
			smsMailMaster.setFrom(requestParams.get("from").toString());
			smsMailMaster.setMessage(requestParams.get("text").toString());
			sendManualSmsService.storeSmsTemp(smsMailMaster, baseBean);
			return null;
		}
		
		httpRequestBeanNew.setRequestParams(requestParams);
		return httpRequestBeanNew;
	}
    
    private String getSaleOrderExtraFieldValue(AlertMaster alertMaster, SaleOrder saleOrder, String message) {
    	try {
    		if(saleOrder == null) {
    			return message;
    		}
    		
    		SaleOrderExtra orderExtra = saleOrderExtraDao.getObjectById(saleOrder.getKey_s(), SaleOrderExtra.class);
    		if(orderExtra == null) {
    			return message;
    		}
    		
        	Class class1 = orderExtra.getClass();
        	Field[] fields = class1.getDeclaredFields();
        	Map<String, Object> fieldValMap = new HashMap<>();
        	for(Field field : fields) {
        		field.setAccessible(true);
        		if (field.getType().getName().contains("java.lang") || field.getType().isPrimitive()) {    			
        			fieldValMap.put(field.getName(), field.get(orderExtra));
        		}
        	}
        	
        	String fieldsArray [] = alertMaster.getParams().split(",");
    		for (String string : fieldsArray) {
    			if(!string.contains("SaleOrderExtra")) {
    				continue;
    			}
    			String [] arr  = string.split(java.util.regex.Pattern.quote("$"));
    			String val = "";
    			if(arr.length == 2) {
    				String fieldValue = ""+fieldValMap.get(arr[1]);
    				val = fieldValue != null ? fieldValue : "";
    			}
    			message = message.replaceAll(java.util.regex.Pattern.quote("#"+string), val);
    		}
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return message;
    }
	
	@Override
	public HttpResponseBean parseAlertResponseBean(Map<String, StringBuffer> requestResponse) {
		
		HttpResponseBean httpResponseBean = new HttpResponseBean ();
		
		try {
			StringBuffer response = requestResponse.get("response");

			if(response != null && response.toString().contains("Sent")) {
				httpResponseBean.setStatus(ResponseStatus.SUCCESS);
				httpResponseBean.setStatusLine("Success");
				httpResponseBean.setStatusMessage(response.toString());
			} else {
				httpResponseBean.setStatus(ResponseStatus.FAIL);
				httpResponseBean.setStatusLine("Failure");
				httpResponseBean.setStatusMessage(response.toString());
			}
		} catch (Exception e) {
			httpResponseBean.setStatus(ResponseStatus.FAIL);
			httpResponseBean.setStatusLine(""+e.getMessage());
			httpResponseBean.setStatusMessage(e.getStackTrace().toString());
		}
		return httpResponseBean;
	}

	@Override
	public Boolean postResponseHandler(Map<String, StringBuffer> requestResponse, HttpResponseBean httpResponseBean,
			String awb, AlertMaster alertMaster) {
		Map<String, String> outputMap = new HashMap<String, String>();
		try {
			/* If Success remove from order ready to push bucket Add success log */
			if (httpResponseBean.getStatus().equals(ResponseStatus.SUCCESS)) {
				
				/* add vendor success log */
				AlertSuccessLogs alertSuccessLogs = new AlertSuccessLogs();
				alertSuccessLogs.setAwbNumber(awb);
				alertSuccessLogs.setAwbNumber_s(awb);
				alertSuccessLogs.setLogTypes(alertMaster.getAlertType().name().toString().equals("SMS")?LogTypes.SMS:LogTypes.MAIL);
				alertSuccessLogs.setSubLogType(alertMaster.getSubAlertType().name());
				alertSuccessLogs.setSuccessMsg(httpResponseBean.getStatusLine()!=null?httpResponseBean.getStatusLine():"Status :"+httpResponseBean.getStatus().toString());
				alertSuccessLogs.setRequestDetails(requestResponse.get("request")!=null?requestResponse.get("request").toString():"something went wrong");
				alertSuccessLogs.setResponseDetails(httpResponseBean.getStatusMessage());
				Map<String, Object> map = httpResponseBean.getHttpRequestBeanNew().getRequestParams();
				
				alertSuccessLogs.setText(map.get("text") != null ? map.get("text").toString() : null);
				String fields = "_id,currentStatus._id,packetsHistory";
				SaleOrder order = saleOrderDao.getObjectById(awb, Arrays.asList(fields.split(",")), SaleOrder.class);
				PacketsHistory history = CommonUtility.getPacketHistoryLastStatus(order);
				alertSuccessLogs.setStatus(order != null ? order.getCurrentStatus().getKey_s() : null);
				alertSuccessLogs.setNdr((history != null && history.getRtoReason() != null && !"".equals(history.getRtoReason().trim())) ? history.getRtoReason() : null);
				alertSuccessLogs.setAlertId(alertMaster.getKey_s());
				alertSuccessLogs.setSendManualSmsId(alertMaster.getExtra());
				alertSuccessLogsDao.saveObject(alertSuccessLogs, AlertSuccessLogs.class);
			} else {
				/* add vendor error log */
				AlertErrorLogs alertErrorLogs = new AlertErrorLogs();
				alertErrorLogs.setAwbNumber(awb);
				alertErrorLogs.setAwbNumber_s(awb);
				alertErrorLogs.setLogTypes(alertMaster.getAlertType().name().toString().equals("SMS")?LogTypes.SMS:LogTypes.MAIL);
				alertErrorLogs.setSubLogType(alertMaster.getSubAlertType().name());
				alertErrorLogs.setErrorMsg(httpResponseBean.getStatusLine());
				alertErrorLogs.setRequestDetails(requestResponse.get("request")!=null?requestResponse.get("request").toString():"something went wrong");
				alertErrorLogs.setErrorMsgDetails(httpResponseBean.getStatusMessage());
				alertErrorLogsDao.saveObject(alertErrorLogs, AlertErrorLogs.class);
			}
			System.out.println("Response ==> "+httpResponseBean.getStatusMessage());
			System.out.println("==================================Response ENDS=================");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			outputMap.put(awb, "ERROR "+e.getMessage());
			
			/* add vendor error log */
			AlertErrorLogs alertErrorLogs = new AlertErrorLogs();
			alertErrorLogs.setAwbNumber(awb);
			alertErrorLogs.setAwbNumber_s(awb);
			alertErrorLogs.setLogTypes(alertMaster.getAlertType().name().toString().equals("SMS")?LogTypes.SMS:LogTypes.MAIL);
			alertErrorLogs.setSubLogType(alertMaster.getSubAlertType().name());
			alertErrorLogs.setErrorMsg(awb);
			alertErrorLogs.setRequestDetails(requestResponse.get("request")!=null?requestResponse.get("request").toString():"something went wrong");
			alertErrorLogs.setErrorMsgDetails("ERROR :"+e.getMessage());
			
			try {
				alertErrorLogsDao.saveObject(alertErrorLogs, AlertErrorLogs.class);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	private String replaceSpecialCharacteres(String str){
		//1) ; 2) \ 3) & 4) " 5) %
		str = str.replaceAll("[^a-zA-Z0-9\\/#()\\s\t&.]+", ",");
		str = str.replaceAll("[\\&]+",",AND,");
		str = str.replaceAll("[\\n]+",",");
		str = str.replaceAll("[\\,,]+",",");
		return str;
	}
}