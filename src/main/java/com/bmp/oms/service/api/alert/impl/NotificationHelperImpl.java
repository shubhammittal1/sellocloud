package com.bmp.oms.service.api.alert.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

import com.bmp.oms.service.api.VendorApiService;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LogTypes;
import com.bmp.constant.NotificationTypes;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.AlertMasterDao;
import com.bmp.dao.ClientDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.drs.Drs;
import com.bmp.model.app.saleorder.PickupSheet;
import com.bmp.model.app.utility.NotificationBean;
import com.bmp.model.base.MongoBaseBean;
import com.bmp.oms.service.app.notication.AppNotificationService;
import com.bmp.oms.service.app.notication.NotificationHelper;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.thread.RequestAwareRunnable;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpResponseBean;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.bmp.utility.logger.AsyncLogger;

@Service
@Qualifier("notificationHelperImpl")
public class NotificationHelperImpl implements NotificationHelper {
	
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
	@Qualifier("clientDaoImpl")
	private ClientDao clientDao;
	
	@Autowired
	@Qualifier("alertMasterDaoImpl")
	private AlertMasterDao alertMasterDao;
	
	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired
	@Qualifier("vendorApiServiceImpl")
	private VendorApiService vendorApiService;
	
	@Override
	public boolean sendNotifications(MongoBaseBean baseBean,NotificationBean notificationBean) throws InterruptedException, Exception {
		final MongoBaseBean base = baseBean;
		final NotificationBean notiBean = (NotificationBean) SerializationUtils.clone(notificationBean);
		if(base!=null || notificationBean!=null){
			Thread t = new Thread(new RequestAwareRunnable() {
				@Override
				protected void onRun() {
					try {
						ResponseBean responseBean = sendNotification(base, notiBean);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			});
			t.start();
			return true;
		}
		return false;
	}


	@Override
	public ResponseBean sendNotification(MongoBaseBean baseBean, NotificationBean notifiBean) throws InterruptedException, Exception {
		ResponseBean responseBean = new ResponseBean();
		Map<String,StringBuffer> requestResponse = null;
		Map<String, VendorApiBean> vendorApiBeanMap = null;
		try {
			vendorApiBeanMap = vendorApiService.getVendorApiBean(LogTypes.APP_NOTIFICATION);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AppNotificationService appNotificationService = null;
		VendorApiBean vendorApiBean = vendorApiBeanMap.get(messageSource.getMessage(GlobalConstant.NOTIFICATION, null, null));
		NotificationBean notificationBean = null;
		if(vendorApiBeanMap !=null){
			if (vendorApiBean != null) {
				try {
					appNotificationService = applicationContext.getBean(vendorApiBean.getImplclass_s(), AppNotificationService.class);
					if (appNotificationService != null) {
						try {
							notificationBean = prepareBean(baseBean, notifiBean);
							if (notificationBean!=null) {
								try {
									/* Prepare request */
									HttpRequestBeanNew httpRequestBean = appNotificationService.getAppNotificationRequestBean(vendorApiBean, notificationBean);

									/* Call Http client and get Response */
									requestResponse = new HttpUtilittyNew().call(httpRequestBean);

									//Prepare Order punch response bean 
									HttpResponseBean httpResponseBean = appNotificationService.parseAppNotifcationResponseBean(requestResponse);
									try {
										System.out.println("Response ==> "+httpResponseBean.getStatusMessage());
										System.out.println("==================================Response ENDS=================");
									} catch (Exception e) {
										e.printStackTrace();
										responseBean.setStatus(ResponseStatus.FAIL);
										return responseBean;
									}
								} catch (Exception e) {
									e.printStackTrace();
									responseBean.setStatus(ResponseStatus.FAIL);
									return responseBean;
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							responseBean.setStatus(ResponseStatus.FAIL);
							return responseBean;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					responseBean.setStatus(ResponseStatus.FAIL);
					return responseBean;
				}
			}
		}
		responseBean.setStatus(ResponseStatus.SUCCESS);
		return responseBean;
	}

	private NotificationBean prepareBean(MongoBaseBean baseBean,  NotificationBean notifiBean) {
		NotificationBean notificationBean = new NotificationBean();
		Object object = baseBean;
		MongoBaseBean mongoBaseBean = (MongoBaseBean) object;
		if (notifiBean==null && mongoBaseBean instanceof Drs){
			Drs drs = (Drs)mongoBaseBean;
			notificationBean.setId(drs.getKey_s());
			notificationBean.setNotificationId(drs.getKey_s());
			notificationBean.setMessage1("DRS Sheet No. "+drs.getKey_s()+" Having "+drs.getPacketList_ss().size() +" Shipments for Delivery");
		    notificationBean.setMessage2("");
		    notificationBean.setMessage3("");
		    notificationBean.setMessage4("");
		    notificationBean.setMessage5("");
		    notificationBean.setTitle(messageSource.getMessage(GlobalConstant.DRS_NOTIFICATION_TITLE, null, null));
		    notificationBean.setAction(NotificationTypes.new_drs.toString());
		    notificationBean.setDelhiveryBoyKey(drs.getDeliveryBoyKey_s());
		    notificationBean.setTimeStamp(DateFormat.getDateInstance().format(new Date(System.currentTimeMillis())));
		    notificationBean.setTopic("notification_"+drs.getDeliveryBoyKey_s());
		    notificationBean.setPhoto("");
		    return notificationBean;
		}else if(notifiBean==null && mongoBaseBean instanceof PickupSheet){
			PickupSheet pickupSheet = (PickupSheet)mongoBaseBean;
			notificationBean.setId(pickupSheet.getKey_s());
			notificationBean.setNotificationId(pickupSheet.getKey_s());
			notificationBean.setMessage1("Pickup Sheet No. "+pickupSheet.getKey_s()+" Having "+pickupSheet.getPickupRequestKeys_ss().size() +" Shipments for Pickup");
		    notificationBean.setMessage2("");
		    notificationBean.setMessage3("");
		    notificationBean.setMessage4("");
		    notificationBean.setMessage5("");
		    notificationBean.setTitle(messageSource.getMessage(GlobalConstant.PICKUP_NOTIFICATION_TITLE, null, null));
		    notificationBean.setAction(NotificationTypes.new_pickup.toString());
		    notificationBean.setTopic("notification_"+pickupSheet.getPickerKey_s());
		    notificationBean.setDelhiveryBoyKey(pickupSheet.getPickerKey_s());
		    notificationBean.setTimeStamp(DateFormat.getDateInstance().format(new Date(System.currentTimeMillis())));
		    notificationBean.setPhoto("");
		    return notificationBean;
		}else if(notifiBean!=null && baseBean==null){
			
			notificationBean.setId("");
			notificationBean.setNotificationId("");
			notificationBean.setMessage1(notifiBean.getMessage1());
		    notificationBean.setMessage2("");
		    notificationBean.setMessage3("");
		    notificationBean.setMessage4("");
		    notificationBean.setMessage5("");
		    notificationBean.setTitle(notifiBean.getTitle());
		    notificationBean.setAction(NotificationTypes.custom.toString());
		    notificationBean.setTopic("notification_"+notifiBean.getDelhiveryBoyKey());
		    notificationBean.setDelhiveryBoyKey(notifiBean.getDelhiveryBoyKey());
		    notificationBean.setTimeStamp(DateFormat.getDateInstance().format(new Date(System.currentTimeMillis())));
		    notificationBean.setPhoto("");
		    return notificationBean;
		}
		return null;
	}


	@Override
	public ResponseBean sendManualNotification(NotificationBean notificationBean) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(ResponseStatus.SUCCESS);
		try {
			if(notificationBean==null || notificationBean.getDeliveryBoys()==null || notificationBean.getDeliveryBoys().size()<1){
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Something went wrong");
			}
            
			for (Map.Entry<String, String> entry : notificationBean.getDeliveryBoys().entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				notificationBean.setDelhiveryBoyKey(entry.getKey());
				try {
					sendNotifications(null, notificationBean);
				}  catch (InterruptedException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("Something went wrong");
			return responseBean;
		}
		return responseBean;
	}
}
