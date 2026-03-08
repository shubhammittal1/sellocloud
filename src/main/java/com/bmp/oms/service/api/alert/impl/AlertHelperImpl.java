package com.bmp.oms.service.api.alert.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

//import com.basho.riak.client.core.RiakNode.State;
import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.AlertStatus;
import com.bmp.constant.AlertType;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LogTypes;
import com.bmp.constant.MessageConstant;
import com.bmp.constant.RequestMethod;
import com.bmp.constant.ResponseStatus;
import com.bmp.constant.SubAlertType;
import com.bmp.dao.AlertErrorLogsDao;
import com.bmp.dao.AlertMasterDao;
import com.bmp.dao.AlertSuccessLogsDao;
import com.bmp.dao.BranchDao;
import com.bmp.dao.ClientDao;
import com.bmp.dao.ClientNewDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.SaleOrderExtraDao;
import com.bmp.dao.SettingsDao;
import com.bmp.dao.SmsMailMasterDao;
import com.bmp.dao.StateDao;
import com.bmp.dao.VendorErrorLogsDao;
import com.bmp.dao.VendorSuccessLogsDao;
import com.bmp.mail.executor.service.VelocityEngineHelper;
import com.bmp.mail.model.CommonMailDTO;
import com.bmp.mail.server.MailServer;
import com.bmp.model.app.api.VendorErrorLogs;
import com.bmp.model.app.api.VendorSuccessLogs;
import com.bmp.model.app.client.Client;
import com.bmp.model.app.client.ClientNew;
import com.bmp.model.app.client.ClientProductSkuRate;
import com.bmp.model.app.config.Settings;
import com.bmp.model.app.facility.Branch;
import com.bmp.model.app.masters.State;
import com.bmp.model.app.saleorder.AlertErrorLogs;
import com.bmp.model.app.saleorder.AlertSuccessLogs;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderExtra;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.app.utility.AlertBean;
import com.bmp.model.app.utility.AlertMaster;
import com.bmp.model.app.utility.SmsMailMaster;
import com.bmp.model.base.MongoBaseBean;
import com.bmp.oms.service.api.alert.AlertApiHelper;
import com.bmp.oms.service.api.alert.AlertHelper;
import com.bmp.oms.service.client.ClientProductSkuRateService;
import com.bmp.oms.service.facility.AlertMasterService;
import com.bmp.oms.service.systemCalling.SendManualSmsService;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.thread.RequestAwareRunnable;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpResponseBean;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.bmp.utility.logger.AsyncLogger;

@Service
@Qualifier("alertHelperImpl")
public class AlertHelperImpl implements AlertHelper {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;

	@Autowired
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Autowired 
	private ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("vendorSuccessLogsDaoImpl")
	private VendorSuccessLogsDao vendorSuccessLogsDao;
	
	@Autowired
	@Qualifier("vendorErrorLogsDaoImpl")
	private VendorErrorLogsDao vendorErrorLogsDao;

	@Autowired
	@Qualifier("clientNewDaoImpl")
	private ClientNewDao clientNewDao;
	
	@Autowired
	@Qualifier("alertMasterDaoImpl")
	private AlertMasterDao alertMasterDao;
	
	@Autowired
	@Qualifier("velocityEngineHelper")
	private VelocityEngineHelper velocityEngineHelper;
	
	@Autowired
	@Qualifier("smsApiHelperImpl")
	private AlertApiHelper alertApiHelper;
	
	@Autowired
	@Qualifier("mailServer")
	private MailServer mailServer;
	
	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired
	@Qualifier("smsMailMasterDaoImpl")
	private SmsMailMasterDao smsMailMasterDao;
	
	@Autowired
	@Qualifier("alertSuccessLogsDaoImpl")
	private AlertSuccessLogsDao alertSuccessLogsDao;
	
	@Autowired
	@Qualifier("alertErrorLogsDaoImpl")
	private AlertErrorLogsDao alertErrorLogsDao;
	
	@Autowired
	@Qualifier("alertMasterServiceImpl")
	private AlertMasterService alertMasterService;
	
	@Autowired
	@Qualifier("sendManualSmsServiceImpl")
	private SendManualSmsService sendManualSmsService;
	
	@Autowired
	@Qualifier("settingsDaoImpl")
	private SettingsDao settingsDao;
	
	@Autowired
	@Qualifier("branchDaoImpl")
	private BranchDao branchDao;
	
	@Autowired
	@Qualifier("saleOrderExtraDaoImpl")
	private SaleOrderExtraDao saleOrderExtraDao;
	
	@Autowired
	@Qualifier("stateDaoImpl")
	private StateDao stateDao;
	
	@Autowired
	@Qualifier("clientProductSkuRateServiceImpl")
	private ClientProductSkuRateService clientProductSkuRateService;

	@Override
	public Boolean sendAlert(String statusFlowKey, StatusMaster fromStatus, StatusMaster toStatus, MongoBaseBean baseBean)
			throws InterruptedException, ExecutionException {
		
		try {
			String toStatusKey = toStatus.getKey_s();
			if (baseBean instanceof SaleOrder) {
				SaleOrder saleOrder = (SaleOrder) baseBean;
				ClientNew client = saleOrder!=null ? clientNewDao.getObjectById(saleOrder.getClientKey_s(), ClientNew.class):null;
				Boolean alertAllow = true;
				/*Boolean alertAllow = false;
				if(client.getProductServiceMap() != null && client.getProductServiceMap().get(saleOrder.getProductType()) != null){
					alertAllow = client.getProductServiceMap().get(saleOrder.getProductType()).getAlertAllow();
				} else {
					alertAllow = client.getAlertAllow();
				}*/
				if(alertAllow==null 
						|| alertAllow==false 
						|| (saleOrder.getHandOver_b()!=null && saleOrder.getHandOver_b()==true)
						|| saleOrder.getKey_s().endsWith("RTO") 
						|| saleOrder.getKey_s().endsWith("U")){
					return true;
				}
				
				PacketsHistory packetsHistory = CommonUtility.getPacketHistoryLastStatus(saleOrder);
				if (messageSource.getMessage(GlobalConstant.ALERT_KEYS, null, null).contains(toStatusKey)) {
					String reasonkey = packetsHistory.getRtoReason()!=null? packetsHistory.getRtoReason():"";
					if(!reasonkey.equals("")){
						toStatusKey = toStatusKey +"_"+reasonkey ;
					}
				}
			}
			Boolean flag = alertSender(toStatusKey, baseBean);
            return flag;
			} catch (Exception e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	@Override
    public  Boolean alertSender(String toStatusKey, MongoBaseBean baseBean) {
		
		List<AlertMaster> alertMasterList = alertKeyFinder(toStatusKey);
		
		// special case if pin based calling then send OFD sms template of Pin
		/*try {
			String ofdKey = messageSource.getMessage(GlobalConstant.OUT_FOR_DELIVERY, null, null).trim();
			Settings settings = settingsDao.getObjectById(messageSource.getMessage(GlobalConstant.EXOTEL_PIN_CALLING_ACTIVE, null, null).trim(), Settings.class);
			if(ofdKey.equals(toStatusKey) && settings != null && ("Yes".equalsIgnoreCase(settings.getContextValue_s()) || "True".equalsIgnoreCase(settings.getContextValue_s()))) {
				AlertMaster alertMaster = alertMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.PIN_BASED_OFD_SMS_TEMPLATE, null, null).trim(), AlertMaster.class);
				if(alertMaster != null) {
					alertMasterList = new ArrayList<AlertMaster>();
					alertMasterList.add(alertMaster);
				}
			}
		}catch(Exception e) {e.printStackTrace();}*/
				
		//for client sms templates
		if(baseBean instanceof SaleOrder) {
			SaleOrder saleOrder = (SaleOrder) baseBean;
			List<AlertMaster> tempList = alertMasterService.getClientAlertMaster(saleOrder);
			if(tempList != null && !tempList.isEmpty()) {
				AlertMaster alertMaster = tempList.get(0);
				if(alertMasterService.isAlreadySmsSend(saleOrder, alertMaster.getKey_s())) {
					alertMasterList = null;
				}else {
					alertMasterList = tempList;
				}
			}
		}
		
		final List<AlertMaster> alertMasterFinalList = alertMasterList;
		final MongoBaseBean base = baseBean;
		if(alertMasterFinalList!=null && alertMasterFinalList.size()>0){
			Thread t = new Thread(new RequestAwareRunnable() {
				@Override
				protected void onRun() {

					for (AlertMaster alertMaster : alertMasterFinalList) {
						try {
							if(alertMaster.getAlertType().name().equals("SMS") && alertMaster.getExpired_b()==false){
								sendSMSAlert(alertMaster, base);
							}
							if(alertMaster.getAlertType().name().equals("MAIL") && alertMaster.getExpired_b()==false){
								//TODO EMAIL from here
								sendEmailAlert(alertMaster, base);
								
							}
						} catch(InterruptedException e){
							e.printStackTrace();
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			});
			t.start();
			return true;
		}
		return false;
	}

	public boolean postResponseHandler(Map<String, StringBuffer> requestResponse, HttpResponseBean httpResponseBean,
			SaleOrder saleOrder, AlertMaster alertMaster) {
		try {
			/* If Success remove from order ready to push bucket Add success log */
			if (httpResponseBean.getStatus().equals(ResponseStatus.SUCCESS)) {
				
				/* add vendor success log */
				VendorSuccessLogs vendorSuccessLogs = new VendorSuccessLogs();
				vendorSuccessLogs.setAwbNumber(saleOrder.getAwbNumber());
				vendorSuccessLogs.setLogTypes(alertMaster.getAlertType().name().toString().equals("SMS")?LogTypes.SMS:LogTypes.MAIL);
				vendorSuccessLogs.setSubLogType(alertMaster.getSubAlertType().name());
				vendorSuccessLogs.setSuccessMsg(httpResponseBean.getStatusLine()!=null?httpResponseBean.getStatusLine():"Status :"+httpResponseBean.getStatus().toString());
				vendorSuccessLogs.setRequestDetails(requestResponse.get("request")!=null?requestResponse.get("request").toString():"something went wrong");
				vendorSuccessLogs.setResponseDetails(httpResponseBean.getStatusMessage());
				vendorSuccessLogsDao.saveObject(vendorSuccessLogs, VendorSuccessLogs.class);
			} else {
				/* add vendor error log */
				VendorErrorLogs vendorErrorLogs = new VendorErrorLogs();
				vendorErrorLogs.setAwbNumber(saleOrder.getAwbNumber());
				vendorErrorLogs.setLogTypes(alertMaster.getAlertType().name().toString().equals("SMS")?LogTypes.SMS:LogTypes.MAIL);
				vendorErrorLogs.setSubLogType(alertMaster.getSubAlertType().name());
				vendorErrorLogs.setErrorMsg(httpResponseBean.getStatusLine());
				vendorErrorLogs.setRequestDetails(requestResponse.get("request")!=null?requestResponse.get("request").toString():"something went wrong");
				vendorErrorLogs.setErrorMsgDetails(httpResponseBean.getStatusMessage());
				vendorErrorLogsDao.saveObject(vendorErrorLogs, VendorErrorLogs.class);
			}
			System.out.println("Response ==> "+httpResponseBean.getStatusMessage());
			System.out.println("==================================Response ENDS=================");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void sendSMSAlert (AlertMaster alertMaster, MongoBaseBean baseBean) throws InterruptedException, Exception {

		Map<String,StringBuffer> requestResponse = null;
			AlertApiHelper alertApiHelper = applicationContext.getBean(alertMaster.getImplClass(), AlertApiHelper.class);
			try {
			if (alertApiHelper != null) {

				/* Prepare request */
				HttpRequestBeanNew httpRequestBean = alertApiHelper.getAlertRequestBean(alertMaster, baseBean);
				if(httpRequestBean != null) {
					/* Call Http client and get Response */
					requestResponse = new HttpUtilittyNew().call(httpRequestBean);

					//Prepare Order punch response bean 
					HttpResponseBean httpResponseBean = alertApiHelper.parseAlertResponseBean(requestResponse);
					httpResponseBean.setHttpRequestBeanNew(httpRequestBean);
					
					//Post Response Handler 
					alertApiHelper.postResponseHandler (requestResponse, httpResponseBean, baseBean.getKey_s(), alertMaster);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendEmailAlert(AlertMaster alertMaster, MongoBaseBean baseBean) throws InterruptedException {
		try {
			CommonMailDTO  commonMailDTO = new CommonMailDTO();
			if(baseBean instanceof SaleOrder) {
				SaleOrder order = (SaleOrder) baseBean;
				commonMailDTO.setMailTo(order.getConsigneeEmailId().split(","));
				List<Object> data = new ArrayList<>();
				Map<String,String> map = new HashMap<>();
				map.put("name", order.getConsigneeName());
				data.add(map);
				commonMailDTO.setData(data);
			}
			commonMailDTO.setAlertMaster(alertMaster);
			commonMailDTO.setMailcc(alertMaster.getCcEmailIds().split(","));
			commonMailDTO.setMailFrom(alertMaster.getFromEmailId());
			commonMailDTO.setSubject(alertMaster.getSubject());
			String mailBody = velocityEngineHelper.getEmailBody(commonMailDTO);
			commonMailDTO.setMailBody(mailBody);
			commonMailDTO.setRealtimeAlert(true);
			
			if(commonMailDTO.getMailTo() != null && commonMailDTO.getMailTo().length > 0) {
				//mailServer.sendMail(commonMailDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<AlertMaster> alertKeyFinder(String key) {
		
		List<AlertMaster> alertMasterList = new ArrayList<AlertMaster>();
		for (AlertType alertType : AlertType.values()) {
			for (SubAlertType subAlertType : SubAlertType.values()) {
				try {
					AlertMaster alertMaster = alertMasterDao.getObjectById(alertType.toString()+"_"+subAlertType.toString()+"_"+key, AlertMaster.class);
					if(alertMaster!=null){
						alertMasterList.add(alertMaster);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return alertMasterList;
	}

	@Override
	public ResponseBean sendManualAlert(AlertBean alertBean) {
		ResponseBean responseBean = new ResponseBean();
		
		String awbNos[] = alertBean.getAwbNos().split(",");
		try {
			AlertMaster alertMaster = alertMasterDao.getObjectById(alertBean.getAlertTemplate(), AlertMaster.class);
			if (alertMaster != null) {
				for (int i = 0; i < awbNos.length; i++) {
					try {
						SaleOrder saleOrder = saleOrderDao.getObjectById(awbNos[i].trim(), SaleOrder.class);
						if(saleOrder!=null){
							String alertKeyStatusAndReason[] = alertMaster.getKey_s().split("_");
							PacketsHistory packetsHistory = CommonUtility.getPacketHistoryLastStatus(saleOrder);
							Map<String, PacketsHistory> packetHistories = new LinkedHashMap<String, PacketsHistory>();
							if(alertKeyStatusAndReason.length>3){
								if (packetsHistory!=null) {
									String lastKey = new ArrayList<>(saleOrder.getPacketsHistory().keySet()).get(saleOrder.getPacketsHistory().size() - 1);
									packetsHistory.setRtoReason(alertKeyStatusAndReason[3]);
									packetHistories.put(lastKey+"_"+alertKeyStatusAndReason[3], packetsHistory);
									saleOrder.setPacketsHistory(packetHistories);
								}else{
									packetsHistory = new PacketsHistory();
									packetsHistory.setRtoReason(alertKeyStatusAndReason[3]);
									packetHistories.put(saleOrder.getCurrentStatus().getKey_s()+"_"+alertKeyStatusAndReason[3], packetsHistory);
									saleOrder.setPacketsHistory(packetHistories);
								}
								alertSender(alertKeyStatusAndReason[2]+"_"+alertKeyStatusAndReason[3], saleOrder);
							}else{
								alertSender(alertKeyStatusAndReason[2], saleOrder);
							}
						}
					} catch (Exception e) {
						responseBean.setStatus(ResponseStatus.FAIL); 
						responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
						e.printStackTrace();
						return responseBean;
					}
				}
			}
		} catch (Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL); 
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
			e.printStackTrace();
			return responseBean;
		}
		responseBean.setStatus(ResponseStatus.SUCCESS); 
		responseBean.setMessage("Alert Send Successfully.");
		return responseBean;
	}

	@Override
	public void sendSMSAlert(SmsMailMaster smsMailMaster) {
		Map<String,StringBuffer> requestResponse = null;
		try {
		if (smsMailMaster != null) {
			/* Prepare request */
			HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
			httpRequestBeanNew.setRequestURL(messageSource.getMessage(GlobalConstant.SMS_API_URL, null, null));
			httpRequestBeanNew.setRequestMethod(RequestMethod.GET.toString());
			
			Map<String, Object> requestParams = new HashMap<String, Object>();
			/*requestParams.put("username", messageSource.getMessage(GlobalConstant.SMS_USERNAME, null, null));
			requestParams.put("password", messageSource.getMessage(GlobalConstant.SMS_PASSWORD, null, null));
			requestParams.put("from", messageSource.getMessage(GlobalConstant.SMS_SENDER_ID, null, null));
			requestParams.put("to", smsMailMaster.getTo());
			requestParams.put("text",smsMailMaster.getMessage()); */
			
			requestParams.put("mobile", messageSource.getMessage(GlobalConstant.SMS_USERNAME, null, null));
			requestParams.put("pass", messageSource.getMessage(GlobalConstant.SMS_PASSWORD, null, null));
			requestParams.put("senderid", messageSource.getMessage(GlobalConstant.SMS_SENDER_ID, null, null));
			requestParams.put("to", smsMailMaster.getTo());
			requestParams.put("msg",smsMailMaster.getMessage());
			
			/*if(smsMailMaster.getAwb() != null && !"".equals(smsMailMaster.getAwb().trim())) {
				SaleOrder saleOrder = saleOrderDao.getObjectById(smsMailMaster.getAwb(),Arrays.asList("_id,clientKey_s".split(",")), SaleOrder.class);
				if(saleOrder != null && messageSource.getMessage(GlobalConstant.APOLLO_CLIENT_KEY, null, null).equals(saleOrder.getClientKey_s())) {
					requestParams.put("from", messageSource.getMessage(GlobalConstant.APOLLO_SMS_SENDER_ID, null, null));
				}
			}*/
			
			httpRequestBeanNew.setRequestParams(requestParams);
			
			/* Call Http client and get Response */
			requestResponse = new HttpUtilittyNew().call(httpRequestBeanNew);
			//Prepare Order punch response bean 
			HttpResponseBean httpResponseBean = alertApiHelper.parseAlertResponseBean(requestResponse);
			
			AlertMaster alertMaster = alertMasterDao.getObjectById(smsMailMaster.getAlertMasterId(), AlertMaster.class);
			saveSmsLogs(requestResponse, httpResponseBean, alertMaster, smsMailMaster);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}
	
	@Override
	public void sendEmailAlert(SmsMailMaster smsMailMaster) {
		try {
			
			CommonMailDTO  commonMailDTO = new CommonMailDTO();
			commonMailDTO.setAlertMaster(alertMasterDao.getObjectById(smsMailMaster.getAlertMasterId(), AlertMaster.class));
			commonMailDTO.setMailTo(smsMailMaster.getTo() != null  ? smsMailMaster.getTo().split(",") : null);
			commonMailDTO.setMailcc(smsMailMaster.getCc() != null ? smsMailMaster.getCc().split(",") : null);
			commonMailDTO.setMailFrom(smsMailMaster.getFrom());
			commonMailDTO.setSubject(smsMailMaster.getSubjectLine());
			commonMailDTO.setMailBody(smsMailMaster.getMessage());
			commonMailDTO.setRealtimeAlert(true);
			
			mailServer.sendMail(commonMailDTO);
			
			smsMailMaster.setAlertStatus_s(AlertStatus.SEND);
			smsMailMasterDao.updateObject(smsMailMaster);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResponseBean sendSMS(String smsTemplate, String to, String awb) {
		ResponseBean responseBean = new ResponseBean();
		Map<String,StringBuffer> requestResponse = null;
		try {
			if (smsTemplate != null && !"".equals(smsTemplate.trim()) && to != null && !"".equals(to.trim())) {
				/* Prepare request */
				HttpRequestBeanNew httpRequestBeanNew = new HttpRequestBeanNew();
				httpRequestBeanNew.setRequestURL(messageSource.getMessage(GlobalConstant.SMS_API_URL, null, null));
				httpRequestBeanNew.setRequestMethod(RequestMethod.GET.toString());
				
				Map<String, Object> requestParams = new HashMap<String, Object>();
				requestParams.put("username", messageSource.getMessage(GlobalConstant.SMS_USERNAME, null, null));
				requestParams.put("password", messageSource.getMessage(GlobalConstant.SMS_PASSWORD, null, null));
				requestParams.put("from", messageSource.getMessage(GlobalConstant.SMS_SENDER_ID, null, null));
				requestParams.put("to", to);
				requestParams.put("text",smsTemplate);
				
				httpRequestBeanNew.setRequestParams(requestParams);
				
				/* Call Http client and get Response */
				requestResponse = new HttpUtilittyNew().call(httpRequestBeanNew);
				//Prepare Order punch response bean 
				HttpResponseBean httpResponseBean = alertApiHelper.parseAlertResponseBean(requestResponse);
				
				if(ResponseStatus.SUCCESS.equals(httpResponseBean.getStatus())) {
					AlertSuccessLogs alertSuccessLogs = new AlertSuccessLogs();
					alertSuccessLogs.setAwbNumber(awb);
					alertSuccessLogs.setAwbNumber_s(awb);
					alertSuccessLogs.setLogTypes(LogTypes.SMS);
					//alertSuccessLogs.setSubLogType(alertMaster.getSubAlertType().name());
					alertSuccessLogs.setSuccessMsg(httpResponseBean.getStatusLine()!=null?httpResponseBean.getStatusLine():"Status :"+httpResponseBean.getStatus().toString());
					alertSuccessLogs.setRequestDetails(requestResponse.get("request")!=null?requestResponse.get("request").toString():"something went wrong");
					alertSuccessLogs.setResponseDetails(httpResponseBean.getStatusMessage());
					alertSuccessLogs.setText(smsTemplate);
					alertSuccessLogsDao.saveObject(alertSuccessLogs, AlertSuccessLogs.class);
					responseBean.setStatus(ResponseStatus.SUCCESS);
					responseBean.setResponse(httpResponseBean.getStatusLine()!=null?httpResponseBean.getStatusLine():"Status :"+httpResponseBean.getStatus().toString());
				}else {
					AlertErrorLogs alertErrorLogs = new AlertErrorLogs();
					alertErrorLogs.setAwbNumber(awb);
					alertErrorLogs.setAwbNumber_s(awb);
					alertErrorLogs.setLogTypes(LogTypes.SMS);
					//alertErrorLogs.setSubLogType(AlertStatus.);
					alertErrorLogs.setErrorMsg(httpResponseBean.getStatusLine());
					alertErrorLogs.setRequestDetails(requestResponse.get("request")!=null?requestResponse.get("request").toString():"something went wrong");
					alertErrorLogs.setErrorMsgDetails(httpResponseBean.getStatusMessage());
					alertErrorLogsDao.saveObject(alertErrorLogs, AlertErrorLogs.class);
					responseBean.setStatus(ResponseStatus.FAIL);
					responseBean.setMessage(httpResponseBean.getStatusMessage());
				}
				//alertApiHelper.postResponseHandler (requestResponse, httpResponseBean, smsMailMaster.getAlertMasterId(), alertMaster);
				
				//smsMailMaster.setAlertStatus_s(AlertStatus.SEND);
				//smsMailMasterDao.updateObject(smsMailMaster);
			}
			return responseBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	private boolean saveSmsLogs(Map<String, StringBuffer> requestResponse, HttpResponseBean httpResponseBean, AlertMaster alertMaster,SmsMailMaster smsMailMaster) {

		Map<String, String> outputMap = new HashMap<String, String>();
		try {
			/* If Success remove from order ready to push bucket Add success log */
			if (httpResponseBean.getStatus().equals(ResponseStatus.SUCCESS)) {
				//
				/* add vendor success log */
				AlertSuccessLogs alertSuccessLogs = new AlertSuccessLogs();
				alertSuccessLogs.setAwbNumber(smsMailMaster.getAwb());
				alertSuccessLogs.setAwbNumber_s(smsMailMaster.getAwb());
				alertSuccessLogs.setLogTypes((alertMaster != null && alertMaster.getAlertType() != null && alertMaster.getAlertType().toString().equals("SMS")) ? LogTypes.SMS : LogTypes.MAIL);
				alertSuccessLogs.setSubLogType((alertMaster != null && alertMaster.getSubAlertType() != null) ? alertMaster.getSubAlertType().name() : null);
				alertSuccessLogs.setSuccessMsg(httpResponseBean.getStatusLine()!=null?httpResponseBean.getStatusLine():"Status :"+httpResponseBean.getStatus().toString());
				alertSuccessLogs.setRequestDetails(requestResponse.get("request")!=null?requestResponse.get("request").toString():"something went wrong");
				alertSuccessLogs.setResponseDetails(httpResponseBean.getStatusMessage());
				
				alertSuccessLogs.setText(smsMailMaster.getMessage());
				alertSuccessLogs.setStatus(smsMailMaster.getStatusKey());
				alertSuccessLogs.setNdr(smsMailMaster.getNdrKey());
				alertSuccessLogs.setAlertId(smsMailMaster.getAlertMasterId());
				alertSuccessLogs.setSendManualSmsId(alertMaster != null ? alertMaster.getExtra() : null);
				alertSuccessLogsDao.saveObject(alertSuccessLogs, AlertSuccessLogs.class);
				smsMailMasterDao.remove(smsMailMaster.getKey_s(), SmsMailMaster.class);
			} else {
				/* add vendor error log */
				AlertErrorLogs alertErrorLogs = new AlertErrorLogs();
				alertErrorLogs.setAwbNumber(smsMailMaster.getAwb());
				alertErrorLogs.setAwbNumber_s(smsMailMaster.getAwb());
				alertErrorLogs.setLogTypes((alertMaster != null && alertMaster.getAlertType() != null && alertMaster.getAlertType().toString().equals("SMS")) ? LogTypes.SMS : LogTypes.MAIL);
				alertErrorLogs.setSubLogType((alertMaster != null && alertMaster.getSubAlertType() != null) ? alertMaster.getSubAlertType().name() : null);
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
			outputMap.put(requestResponse.get("awb") != null ? requestResponse.get("awb").toString() : null, "ERROR "+e.getMessage());
			
			/* add vendor error log */
			AlertErrorLogs alertErrorLogs = new AlertErrorLogs();
			alertErrorLogs.setAwbNumber(smsMailMaster.getAwb());
			alertErrorLogs.setAwbNumber_s(smsMailMaster.getAwb());
			alertErrorLogs.setLogTypes((alertMaster != null && alertMaster.getAlertType() != null && alertMaster.getAlertType().toString().equals("SMS"))?LogTypes.SMS:LogTypes.MAIL);
			alertErrorLogs.setSubLogType((alertMaster != null && alertMaster.getSubAlertType() != null) ? alertMaster.getSubAlertType().toString() : null);
			alertErrorLogs.setErrorMsg(smsMailMaster.getAwb());
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

	@Override
	public boolean sendClientSmsTemplate(final SaleOrder saleOrder) {
		try {
			String CLIENTS_SMS_TEMPLATES = messageSource.getMessage(GlobalConstant.CLIENTS_SMS_TEMPLATES, null, null).trim();
			Settings settings = settingsDao.getObjectById(CLIENTS_SMS_TEMPLATES, Settings.class);
			if(settings == null || settings.getContextValue_s() == null) {
				return false;
			}
			List<String> clietList = Arrays.asList(settings.getContextValue_s().split(","));
			if(!clietList.contains(saleOrder.getClientKey_s())) {
				return false; 
			}
			
			final List<AlertMaster> tempList = alertMasterService.getClientAlertMaster(saleOrder);
			if(tempList == null || tempList.isEmpty()) {
				return false;
			}
			
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					sendManualSmsService.sendClientSmsTemplate(tempList.get(0),saleOrder);
				}
			};
			Thread thread = new Thread(runnable);
			thread.start();
			//thread.sleep(400);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResponseBean getProformaInvoice(String awbNumbers, String productSkus) throws Exception {
		ResponseBean responseBean = new ResponseBean();
		String invoiceBody = null;
		try {
			for(String awbNumber: awbNumbers.split(",")){
				SaleOrder saleOrder = saleOrderDao.getObjectById(awbNumber, SaleOrder.class);
				if(saleOrder != null){
					Branch branch = branchDao.getObjectById(saleOrder.getCurrentBranch_s(), Branch.class);
					String branchState = null;
					String branchAddress = null;
					if(branch != null){
						branchState = branch.getState();
						branchAddress = branch.getAddress();
					}
					
					String invoiceDate = CommonUtility.convertCurrentDateToDDMMYYYY(new Date());
					State state = stateDao.getObjectById(branchState, State.class);
					
					ClientProductSkuRate skuRate = clientProductSkuRateService.getClientProductSkuRate(saleOrder.getClientKey_s(), saleOrder.getProductName());
					Double discount = skuRate.getProductDiscount() != null ? skuRate.getProductDiscount() : 0.0;
					Double basicRate = skuRate.getBasicRate();
					Double taxableValue = skuRate.getBasicRate()+discount;
					Double productMRP = skuRate.getProductMRP();
					String hsnCode = skuRate.getHsnCode();
					Double cGSTRate = 0d;
					Double sGSTRate = 0d;
					Double iGSTRate = 0d;
					Double cGSTAmt = 0d;
					Double sGSTAmt = 0d;
					Double iGSTAmt = 0d;
					Double totalAmount = 0d;
					if(branch.getState().trim().equalsIgnoreCase(saleOrder.getConsigneeState().trim())){
						cGSTRate = Double.valueOf(skuRate.getCgstRate());
						sGSTRate = Double.valueOf(skuRate.getSgstRate());
						cGSTAmt = CommonUtility.formatTo2DecimalPlaces(((basicRate*cGSTRate)/100));
						sGSTAmt = CommonUtility.formatTo2DecimalPlaces(((basicRate*sGSTRate)/100));
						totalAmount = CommonUtility.formatTo2DecimalPlaces(taxableValue + cGSTAmt + sGSTAmt);
					} else {
						iGSTRate = Double.valueOf(skuRate.getIgstRate());
						iGSTAmt = CommonUtility.formatTo2DecimalPlaces(((basicRate*iGSTRate)/100));
						totalAmount = CommonUtility.formatTo2DecimalPlaces(taxableValue + iGSTAmt);
					}
					Double netInvoiceValue = (double) Math.round(totalAmount);
					
					/*SaleOrderExtra saleOrderExtra = saleOrderExtraDao.getObjectById(saleOrder.getKey_s(), SaleOrderExtra.class);
					Double discount = null;
					Double taxableValue = null;
					if(saleOrderExtra != null){
						discount = saleOrderExtra.getDiscount();
					}
					Double basicRate = Double.valueOf(saleOrder.getTaxableValue());
					if(basicRate != null && discount != null){
						taxableValue = basicRate + discount;	
					}
					
					Double cGSTRate = 0d;
					Double sGSTRate = 0d;
					Double iGSTRate = 0d;
					Double cGSTAmt = 0d;
					Double sGSTAmt = 0d;
					Double iGSTAmt = 0d;
					Double totalAmount = 0d;
					if(branch.getState().trim().equalsIgnoreCase(saleOrder.getConsigneeState().trim())){
						cGSTRate = Double.valueOf(saleOrder.getcGSTAmount());
						sGSTRate = Double.valueOf(saleOrder.getsGSTAmount());
						cGSTAmt = CommonUtility.formatTo2DecimalPlaces(((basicRate*cGSTRate)/100));
						sGSTAmt = CommonUtility.formatTo2DecimalPlaces(((basicRate*sGSTRate)/100));
						totalAmount = CommonUtility.formatTo2DecimalPlaces(taxableValue + cGSTAmt + sGSTAmt);
					} else {
						iGSTRate = Double.valueOf(saleOrder.getiGSTAmount());
						iGSTAmt = CommonUtility.formatTo2DecimalPlaces(((basicRate*iGSTRate)/100));
						totalAmount = CommonUtility.formatTo2DecimalPlaces(taxableValue + iGSTAmt);
					}
					
					Double netInvoiceValue = (double) Math.round(totalAmount);*/
					
					CommonMailDTO  commonMailDTO = new CommonMailDTO();
					List<Object> data = new ArrayList<>();
					Map<String,Object> map = new HashMap<>();
					map.put("awbNumber", saleOrder.getAwbNumber());
					map.put("name", saleOrder.getConsigneeName());
					map.put("fromAddress", branchAddress);
					map.put("toAddress", saleOrder.getConsigneeAddress());
					map.put("branchState", state.getStateName_s());
					map.put("stateCode", state.getStateCode_s());
					map.put("invoiceNumber", saleOrder.getProformaInvoiceNumber());
					map.put("invoiceDate", invoiceDate);
					map.put("loanProposalId", saleOrder.getClientManifest());
					map.put("productName", saleOrder.getProductName());
					map.put("gstNo", branch.getGstNo());
					map.put("productSku", saleOrder.getProductSKU());
					map.put("hsnCode", hsnCode);
					map.put("mrp", productMRP);
					map.put("discount", discount);
					map.put("basicRate", basicRate);
					map.put("basicValue", basicRate);
					map.put("taxableValue", taxableValue);
					map.put("cGSTRate", cGSTRate);
					map.put("sGSTRate", sGSTRate);
					map.put("iGSTRate", iGSTRate);
					map.put("cGSTAmt", cGSTAmt);
					map.put("sGSTAmt", sGSTAmt);
					map.put("iGSTAmt", iGSTAmt);
					map.put("totalAmount", totalAmount);
					map.put("netInvoiceValue", netInvoiceValue);
					
					data.add(map);
					commonMailDTO.setData(data);
					
					if(invoiceBody == null){
						invoiceBody = velocityEngineHelper.getProformaInvoiceBody(commonMailDTO);
					}else{
						invoiceBody = invoiceBody + velocityEngineHelper.getProformaInvoiceBody(commonMailDTO);
					}
				}
			}
			
			responseBean.setResponse(invoiceBody);
			responseBean.setStatus(ResponseStatus.Success);
			responseBean.setMessage("Success");
			return responseBean;
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setResponse("Fail");
			return responseBean;
		}
	}
	
}