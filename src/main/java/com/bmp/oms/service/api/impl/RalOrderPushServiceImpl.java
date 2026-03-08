package com.bmp.oms.service.api.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.saleorder.BfilOrderBean;
import com.bmp.bean.saleorder.BfilOrderCancelBean;
import com.bmp.bean.saleorder.BfilTelecallUpdateBean;
import com.bmp.bean.saleorder.InvoiceCancel;
import com.bmp.bean.saleorder.InvoiceStatusBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.PaymentType;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.BranchDao;
import com.bmp.dao.ClientDao;
import com.bmp.dao.DataFetchErrorLogsDao;
import com.bmp.dao.PushPacketStatusHistoryDao;
import com.bmp.dao.RdspDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.SaleOrderExtraDao;
import com.bmp.dao.ServiceablePincodeDao;
import com.bmp.dao.SettingsDao;
import com.bmp.dao.StatusMasterDao;
import com.bmp.dao.VendorApiDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.client.Client;
import com.bmp.model.app.config.Settings;
import com.bmp.model.app.facility.Branch;
import com.bmp.model.app.masters.ServiceablePincode;
import com.bmp.model.app.saleorder.DataFetchErrorLogs;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.PushPacketStatusHistory;
import com.bmp.model.app.saleorder.RDSP;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderExtra;
import com.bmp.model.app.saleorder.StagingSaleOrder;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.oms.service.masters.BranchStockReconService;
import com.bmp.oms.service.saleorder.SaleOrderService;
import com.bmp.oms.service.saleorder.StagingSaleOrderService;
import com.bmp.oms.service.statuspush.api.PushStatusToVendorService;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBean;
import com.bmp.utility.apiUtility.HttpUtilitty;
import com.bmp.utility.logger.AsyncLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

@Service
@Qualifier("ralOrderPushServiceImpl")
public class RalOrderPushServiceImpl {
	
	boolean ralReuploadData = false; 
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;
	
	@Autowired
	@Qualifier("vendorApiDaoImpl")
	private VendorApiDao vendorApiDao;
	
	@Autowired
	@Qualifier("stagingSaleOrderServiceImpl")
	private StagingSaleOrderService stagingSaleOrderService;
	
	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired
	@Qualifier("saleOrderExtraDaoImpl")
	private SaleOrderExtraDao saleOrderExtraDao;
	
	@Autowired
	@Qualifier("saleOrderServiceImpl")
	private SaleOrderService saleOrderService;
	
	@Autowired	
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;
	
	@Autowired
	@Qualifier("pushStatusToVendorServiceImpl")
	PushStatusToVendorService pushStatusToVendorService;
	
	@Autowired
	@Qualifier("ServiceablePincodeDaoImpl")
	private ServiceablePincodeDao serviceablePincodeDao;
	
	@Autowired
	@Qualifier("branchDaoImpl")
	private BranchDao branchDao;
	
	@Autowired
	@Qualifier("clientDaoImpl")
	private ClientDao clientDao;
	
	@Autowired
	@Qualifier("dataFetchErrorLogsDaoImpl")
	private DataFetchErrorLogsDao dataFetchErrorLogsDao;
	
	@Autowired
	@Qualifier("settingsDaoImpl")
	private SettingsDao settingsDao;
	
	@Autowired
	@Qualifier("rdspDaoImpl")
	private RdspDao rdspDao;
	
	@Autowired
	@Qualifier("branchStockReconImpl")
	private BranchStockReconService branchStockReconService;
	
	@Autowired
	@Qualifier("pushPacketStatusHistoryDaoImpl")
	private PushPacketStatusHistoryDao pushPacketStatusHistoryDao;
	
	/*public ResponseBean ralOrderPuch(int backDate) {
		ResponseBean responseBean = new ResponseBean();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.RAL_ORDER_PUSH_VENDOR_API_BEAN_KEY, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -backDate);
			String date = dateFormat.format(calendar.getTime());
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			Map<String,Object> requestParam = new HashMap<String,Object>();
			for(String param : vendorApiBean.getHeader_param().split(",")) {
				String paramArr[] = param.split("=");
				requestProperty.put(paramArr[0], paramArr[1]);
			}
			
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s()+"/"+date);
			httpRequestBean.setRequestProperty(requestProperty);
			httpRequestBean.setParams(requestParam);
			
			StringBuffer buffer = new HttpUtilitty().doPOST(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			if(apiResponse == null || apiResponse.getStatus().equals(ResponseStatus.FAIL)) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(apiResponse.getMessage());
				return responseBean;
			}
			
			Map<String, String> errorDataPush = new HashMap<String, String>();
			Map<String, String> successDataPush = new HashMap<String, String>();
			Map<String, String> dublicateData = new HashMap<String, String>();
			List<RalOrderBean> list = parseJsonArray(buffer.toString(), gson);
			if(list != null && !list.isEmpty()) {
				for(RalOrderBean ralOrderBean : list) {
					if(ralOrderBean == null) {
						continue;
					}
					StagingSaleOrder stagingSaleOrder = convertRalOrderBeanToStagingSaleOrder(ralOrderBean);
					
					Query query = new Query();
					query.addCriteria(Criteria.where("saleOrderNumber_s").is(stagingSaleOrder.getSaleOrderNumber_s()).and("clientKey_s").is(stagingSaleOrder.getClientKey_s()));
					List<String> keyList = saleOrderDao.getKeys(query, SaleOrder.class);
					if(keyList != null && !keyList.isEmpty()) {
						dublicateData.put(stagingSaleOrder.getSaleOrderNumber_s(), "Data Already Uploaded : BMP-AWB="+keyList.get(0));
						continue;
					}
					
					if(stagingSaleOrder.getManifestNumber() == null || "".equals(stagingSaleOrder.getManifestNumber().trim())) {
						ResponseBean error = new ResponseBean();
						error.setStatus(ResponseStatus.FAIL);
						error.setMessage("Fail to data push : LoanCode field is null");
						errorDataPush.put(stagingSaleOrder.getSaleOrderNumber_s(), error.getMessage());
						pushLogsInRalSystem(error, null, stagingSaleOrder.getSaleOrderNumber_s());
					}
					
					if(ralOrderBean.getSksVendorId() == null || "".equals(ralOrderBean.getSksVendorId().trim())) {
						ResponseBean error = new ResponseBean();
						error.setStatus(ResponseStatus.FAIL);
						error.setMessage("Fail to data push : SksVendorId field is null");
						errorDataPush.put(stagingSaleOrder.getSaleOrderNumber_s(), error.getMessage());
						pushLogsInRalSystem(error, null, stagingSaleOrder.getSaleOrderNumber_s());
					}
					
					if(ralOrderBean.getInvoiceStatus() == null || "".equals(ralOrderBean.getInvoiceStatus().trim())) {
						ResponseBean error = new ResponseBean();
						error.setStatus(ResponseStatus.FAIL);
						error.setMessage("Fail to data push : InvoiceStatus field is null");
						errorDataPush.put(stagingSaleOrder.getSaleOrderNumber_s(), error.getMessage());
						pushLogsInRalSystem(error, null, stagingSaleOrder.getSaleOrderNumber_s());
					}
						
					
					ResponseBean responseBean2 = stagingSaleOrderService.createStagingSaleOrderNew(stagingSaleOrder);
					if(responseBean2 == null || responseBean2.getStatus().equals(ResponseStatus.FAIL)) {
						System.out.println("Error in creating order : "+responseBean2.getMessage());
						errorDataPush.put(stagingSaleOrder.getSaleOrderNumber_s(), responseBean2.getMessage());
						pushLogsInRalSystem(responseBean2, null, stagingSaleOrder.getSaleOrderNumber_s());
					}else {
						SaleOrder order = (SaleOrder) responseBean2.getResponse();
						order.setClientVendorCode(ralOrderBean.getSksVendorId().trim());
						
						Date orderDate = CommonUtility.getDateFromString(ralOrderBean.getOrderDate());
						if(orderDate != null) {
							order.setClientOrderDate(CommonUtility.convertLongDateToYYYYMMDDHHMMSS(orderDate.getTime()));
						}
						
						try {
							StatusMaster statusMaster = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.INVOICE_PENDING, null, null), StatusMaster.class);
							if(order.getInvoiceStatus()!= null && order.getInvoiceStatus().equals("INVOICED")){
								order.setInvoiceDate(CommonUtility.convertDateTimeToMMDDYYYY(order.getSaleOrderDate()));
							}else{
								order.setInvoiceStatus(statusMaster.getStatusName());
							}
							statusMaster = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.ORDER_VERIFY_PENDING, null, null), StatusMaster.class);
							order.setTelecallingStatus(statusMaster.getStatusName());
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						saleOrderDao.updateObject(order);
						successDataPush.put(stagingSaleOrder.getSaleOrderNumber_s(), order.getKey_s());
						
						pushLogsInRalSystem(responseBean2, order.getAwbNumber(), order.getSaleOrderNumber_s());
					}
				}
				responseBean.setStatus(ResponseStatus.SUCCESS);
			}else {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Data not found in RAL system.");
				System.out.println(responseBean.getMessage());
			}
			Map<String,Object> mapObj = new HashMap<String,Object>();
			mapObj.put("errorDataPush", errorDataPush);
			mapObj.put("successDataPush", successDataPush);
			mapObj.put("dublicateData", dublicateData);
			responseBean.setResponse(mapObj);
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("");
		}
		return responseBean;
	}
	
	private List<RalOrderBean> parseJsonArray(String buffer, Gson gson){
		List<RalOrderBean> ralOrderList = new ArrayList<RalOrderBean>();
		try {
			JSONArray jsonArray = new JSONObject(buffer).optJSONArray("response");
			for(int i =0; i<jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				ralOrderList.add(gson.fromJson(jsonObject.toString(), RalOrderBean.class));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ralOrderList;
	}
	
	private StagingSaleOrder convertRalOrderBeanToStagingSaleOrder(RalOrderBean ralOrderBean) {
		
		StagingSaleOrder saleOrder = new StagingSaleOrder();
		
		saleOrder.setClientKey_s("RAL");
		saleOrder.setSenderName(ralOrderBean.getVndorName());
		saleOrder.setSenderMobileNumber_s(getContactNumber(ralOrderBean.getPickupMobileNumber()));
		saleOrder.setSenderAltNumber(getContactNumber(ralOrderBean.getPickupAlternateNumber()));
		saleOrder.setSenderAddress(ralOrderBean.getPickupAddress());
		saleOrder.setSenderPincode_s(ralOrderBean.getPickupPincode());
		
		saleOrder.setReturnName(ralOrderBean.getVndorName());
		saleOrder.setReturnMobileNumber(getContactNumber(ralOrderBean.getPickupMobileNumber()));
		saleOrder.setReturnAlternateNumber(getContactNumber(ralOrderBean.getPickupAlternateNumber()));
		saleOrder.setReturnAddress(ralOrderBean.getPickupAddress());
		//saleOrder.setReturnLandmark((String)map.get("senderLandmark"));
		saleOrder.setReturnPincode(ralOrderBean.getPickupPincode());
		
		saleOrder.setConsigneeName(ralOrderBean.getConsigneeName());
		saleOrder.setConsigneeMobileNumber_s(getContactNumber(ralOrderBean.getConsigneeMobileNumber()));
		saleOrder.setConsigneeAlternateNumber(getContactNumber(ralOrderBean.getConsigneeAlternateNumber()));
		saleOrder.setConsigneeEmailId(ralOrderBean.getConsignee_Emailid());
		saleOrder.setConsigneeLandmark(ralOrderBean.getConsigneeLandmark());
		saleOrder.setConsigneeAddress(ralOrderBean.getConsigneeAddress());
		saleOrder.setConsigneePincode_s(ralOrderBean.getConsigneePincode());
		
		if(PaymentType.COD.toString().equalsIgnoreCase(ralOrderBean.getPaymentMode())){
			saleOrder.setPaymentType_s(PaymentType.COD.toString());
		} else if(PaymentType.PREPAID.toString().equalsIgnoreCase(ralOrderBean.getPaymentMode()) || PaymentType.PP.toString().equalsIgnoreCase(ralOrderBean.getPaymentMode())) {
			saleOrder.setPaymentType_s(PaymentType.PREPAID.toString());
		}
		if("Standard".equalsIgnoreCase(ralOrderBean.getProduct_Type())) {
			saleOrder.setProductType (ralOrderBean.getProduct_Type().toLowerCase());
		}else {
			saleOrder.setProductType (ralOrderBean.getProduct_Type());
		}
		
		Date orderDate = CommonUtility.getDateFromString(ralOrderBean.getOrderDate());
		if(orderDate != null) {
			saleOrder.setClientOrderDate(CommonUtility.convertLongDateToYYYYMMDDHHMMSS(orderDate.getTime()));
		}
		
		saleOrder.setSaleOrderNumber_s(ralOrderBean.getOrderNumber());
		saleOrder.setManifestNumber((ralOrderBean.getLoanCode() != null && !"".equals(ralOrderBean.getLoanCode().trim())) ? ralOrderBean.getLoanCode() : null);
		saleOrder.setProductSKU(ralOrderBean.getProduct_Code());
		saleOrder.setProductName(ralOrderBean.getProduct_Name());
		saleOrder.setPerishable((ralOrderBean.getDgGood() == null || ralOrderBean.getDgGood() == false) ? "No" : "Yes");
		saleOrder.setFlammable((ralOrderBean.getDgGood() == null || ralOrderBean.getDgGood() == false) ? "No" : "Yes");
		saleOrder.setQuantity(ralOrderBean.getQuantity());
		saleOrder.setLength(ralOrderBean.getLength());
		saleOrder.setWidth(ralOrderBean.getWidth());
		saleOrder.setHeight(ralOrderBean.getHeight());
		saleOrder.setWeight(ralOrderBean.getWeight());
		saleOrder.setCollectableAmount(ralOrderBean.getCollective_Amt());
		saleOrder.setProductPrice(ralOrderBean.getProduct_Price());
		saleOrder.setiGSTAmount(String.valueOf(ralOrderBean.getIgst_Value()));
		saleOrder.setsGSTAmount(String.valueOf(ralOrderBean.getSgst_Value()));
		saleOrder.setcGSTAmount(String.valueOf(ralOrderBean.getDgGood()));
		
		
		return saleOrder;
	}
	
	private String getContactNumber(String number) {
		if(number == null || "".equals(number.trim())) {
			return null;
		}
		if(number.length() < 10) {
			return null;
		}
		if(number.length() > 10) {
			return number.substring(number.length()-10, number.length());
		}
		return number;
	}*/
	
	public ResponseBean pushLogsInRalSystem(ResponseBean bean, String bmpAwb, String saleOrderNumber) {
		ResponseBean responseBean = new ResponseBean();
		try {
			Map<String,Object> requestParam = new HashMap<String,Object>();
			requestParam.put("awbNumber", bmpAwb);
			requestParam.put("orderNumber", saleOrderNumber);
			if(bean.getStatus().equals(ResponseStatus.SUCCESS)) {
				requestParam.put("status", ResponseStatus.SUCCESS.toString());
				requestParam.put("message", ResponseStatus.SUCCESS.toString());
			}else {
				requestParam.put("status", ResponseStatus.FAIL.toString());
				requestParam.put("message", bean.getMessage());
			}
			
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.RAL_ORDER_PUSH_VENDOR_API_LOGS_BEAN_KEY, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s());
			httpRequestBean.setRequestProperty(requestProperty);
			httpRequestBean.setParams(requestParam);
			
			StringBuffer buffer = new HttpUtilitty().doPOST(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			if(apiResponse != null && apiResponse.getStatus().equals(ResponseStatus.SUCCESS)) {
				System.out.println("Success : Logs Pushed In RAL System.");
				return apiResponse;
			}else{
				System.out.println("Error In Pushing Logs : "+apiResponse.getMessage());
				return apiResponse;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public Map<String,InvoiceStatusBean> getInvoiceStatus(List<String> saleOrderList, Map<String, String> awbLoanproposalMap) {
		ResponseBean responseBean = new ResponseBean();
		Map<String,InvoiceStatusBean> invoiceMap = new HashMap<String,InvoiceStatusBean>();
		try {
			logger.info(String.class, "AWB="+saleOrderList);
			Map<String,Object> requestParam = new HashMap<String,Object>();
			requestParam.put("orderList", saleOrderList);
			//requestParam.put("orderList", Arrays.asList("0f0119000021,0f0119000069,0g0119000054,060119000046".split(",")));
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.RAL_INVOICE_STATUS_GET_VENDOR_API_KEY, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return null;
			}
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s());
			httpRequestBean.setRequestProperty(requestProperty);
			httpRequestBean.setParams(requestParam);
			
			StringBuffer buffer = new HttpUtilitty().doPOST(httpRequestBean);
			
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			if(apiResponse == null || apiResponse.getStatus().equals(ResponseStatus.SUCCESS)) {
				invoiceMap = (Map<String, InvoiceStatusBean>) apiResponse.getResponse();
				int count =0;
				for(Map.Entry<String, InvoiceStatusBean> invoice : invoiceMap.entrySet()){
					try {
						ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
						logger.info(String.class, "Invoice count = "+invoiceMap.size()+"/"+count++ +"  Invoice json -----> "+mapper.writeValueAsString(invoice.getValue()));
						InvoiceStatusBean invoiceStatusBean = mapper.convertValue(invoice.getValue(), InvoiceStatusBean.class);
						
						if(invoice.getValue() != null){
							if(invoiceStatusBean.getInvoiceStatus().equals("INVOICED") || invoiceStatusBean.getInvoiceStatus().equals("INVOICE CANCELLED")){
								SaleOrder saleOrder = null;
								try {
									saleOrder = saleOrderDao.getObjectById(awbLoanproposalMap.get(invoiceStatusBean.getLoanCode().trim()), SaleOrder.class);
								}catch(Exception e) {}
								
								if(saleOrder == null){
									logger.info(String.class, "SaleOrder not found against to "+invoiceStatusBean.getLoanCode().trim());
									continue;
								}
								//SaleOrder saleOrder = orderList.get(orderList.size()-1);
								saleOrder.setSaleOrderNumber_s((invoiceStatusBean.getSaleOrderNumber() != null && !"".equals(invoiceStatusBean.getSaleOrderNumber().trim())) ? invoiceStatusBean.getSaleOrderNumber() : saleOrder.getSaleOrderNumber_s());
								saleOrder.setClientVendorCode((invoiceStatusBean.getSksVendorId() != null && !"".equals(invoiceStatusBean.getSksVendorId().trim())) ? invoiceStatusBean.getSksVendorId() : saleOrder.getClientVendorCode());
								saleOrder.setProductSKU(invoiceStatusBean.getImeNumber());
								
								boolean invoiceUpdate = false;
								if(invoiceStatusBean.getInvoiceStatus().equals("INVOICED")){
									StatusMaster statusInvoice = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.INVOICE_GENERATED, null, null), StatusMaster.class);
									if(!statusInvoice.getStatusName().equals(saleOrder.getInvoiceStatus())){
										invoiceUpdate = true;
									}
									saleOrder.setInvoiceStatus(statusInvoice.getStatusName());
									saleOrder.setInvoiceDate(CommonUtility.convertCurrentDateToDDMMYYYY(invoiceStatusBean.getInvoiceDate()));
								} else {
									StatusMaster statusCancel = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.INVOICE_CANCELLED, null, null), StatusMaster.class);
									saleOrder.setInvoiceStatus(statusCancel.getStatusName());
									//TODO Invoice cancel process
									if(saleOrder.getScannedDate() != null && !"".equals(saleOrder.getScannedDate())){
										String toStatusKey = messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null);
										Settings rtoReason = settingsDao.getObjectById("rto1", Settings.class);
										responseBean = saleOrderService.updateCurrentStatusAndPacketHistory(saleOrder, toStatusKey, rtoReason.getContextCode_s(), null);
										if (responseBean.getStatus().equals(ResponseStatus.FAIL)) {
											return (Map<String, InvoiceStatusBean>) responseBean;
										}
									}else{
										String toStatusKey = messageSource.getMessage(GlobalConstant.INITIATE_BOOKING_CANCEL, null, null);
										//TODO Add cancel reason
										String cancelReason = messageSource.getMessage(GlobalConstant.BOOKING_MAX_CALL_ATTEPTED, null, null);
										saleOrder.setCancelReason(cancelReason);
										responseBean = saleOrderService.updateCurrentStatusAndPacketHistory(saleOrder, toStatusKey, cancelReason, null);
										if (responseBean.getStatus().equals(ResponseStatus.FAIL)) {
											return (Map<String, InvoiceStatusBean>) responseBean;
										}
									}
								}
								saleOrderDao.updateObject(saleOrder);
								if(invoiceUpdate){
									pushStatusToVendorService.bfilPushStatusHistory(saleOrder, GlobalConstant.INVOICE_UPDATE_STATUS);
								}
							}
						}else {
							logger.info(String.class, "InvoiceStatusBean  Not mapped.");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}else{
				System.out.println("Error In Getting InvoiceStatus : "+apiResponse.getMessage());
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return invoiceMap;
	}

	public ResponseBean executePendingInvoiceStatus() {
		ResponseBean responseBean = new ResponseBean();
		String terminalStatus = messageSource.getMessage(GlobalConstant.PACKET_TERMINAL_STATUS, null, null);
		Query query = new Query();
		List<Object> list = new ArrayList<>();
		StatusMaster statusMaster;
		try {
			statusMaster = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.INVOICE_PENDING, null, null), StatusMaster.class);
			list.add(statusMaster.getStatusName());
			list.add("PENDING INVOICE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		query.fields().include("_id").include("awbNumber").include("clientManifest").include("saleOrderNumber_s");
		
		List<String> terminalStatusList = new ArrayList<>(Arrays.asList(terminalStatus.split(",")));
		terminalStatusList.remove("116");
		query.addCriteria(Criteria.where("invoiceStatus").in(list)
				.and("expired_b").is(false)
				.and("clientKey_s").is("RAL")
				.and("_id").not().regex("RTO")
				//.and("currentStatus._id").not().in(Arrays.asList(terminalStatus.split(",")))
				.and("currentStatus._id").not().in(Arrays.asList(terminalStatusList))
				);
		List<SaleOrder> saleOrder = saleOrderDao.getObjectByQuery(query, SaleOrder.class);
		//List<String> loanIds = new ArrayList<>();
		Map<String,String> awbLoanproposalMap = new HashMap<String,String>();
		for(int i=0 ; i<saleOrder.size(); i++){
			SaleOrder order = saleOrder.get(i);
			if(order != null && order.getClientManifest() != null && !"".equals(order.getClientManifest().trim())
					&& !"no".equalsIgnoreCase(order.getClientManifest().trim())) {
				//loanIds.add(order.getClientManifest());
				awbLoanproposalMap.put(order.getClientManifest(), order.getKey_s());
			}
		}
		
		//loanIds.add("5111591000095246");
		//awbLoanproposalMap.put("5111591000095246", "TES87972290");
		//List<List<String>> orderSmallerLists = Lists.partition(loanIds, 100);
		List<List<String>> orderSmallerLists = Lists.partition(new ArrayList<>(awbLoanproposalMap.keySet()), 200);
		Map<String,InvoiceStatusBean> invoiceStatusMap = new HashMap<String,InvoiceStatusBean>();
		for(List<String> ls : orderSmallerLists) {
			Map<String,InvoiceStatusBean> invoiceStatus = getInvoiceStatus(ls, awbLoanproposalMap);
			if(invoiceStatus != null) {
				invoiceStatusMap.putAll(invoiceStatus);
			}
		}
		if(invoiceStatusMap == null || invoiceStatusMap.isEmpty()) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("Something Went Wrong");
			return responseBean;
		}
		else{
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setMessage("Invoice Status Updated");
			return responseBean;
		}
	}
	
	public ResponseBean getBfilTelecallUpdates() {
		ResponseBean responseBean = new ResponseBean();
		Map<String,BfilTelecallUpdateBean> teleMap = new HashMap<String,BfilTelecallUpdateBean>();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.BFIL_TELECALL, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s());
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			httpRequestBean.setRequestProperty(requestProperty);
			
			httpRequestBean.setParams(new HashMap<String,Object>());
			
			StringBuffer buffer = new HttpUtilitty().doPOST(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			if(apiResponse == null || apiResponse.getStatus().equals(ResponseStatus.FAIL)) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(apiResponse != null ? apiResponse.getMessage() :"Tomcat is not running at RAL api server.");
				return responseBean;
			}
			List<BfilTelecallUpdateBean> responseList = new ArrayList<BfilTelecallUpdateBean>();
			JSONArray jsonArray = new JSONObject(buffer.toString()).optJSONArray("response");
			for(int i =0; i<jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				responseList.add(gson.fromJson(jsonObject.toString(), BfilTelecallUpdateBean.class));
			}
			/*teleMap = (Map<String, BfilTelecallUpdateBean>) apiResponse.getResponse();
			for(Map.Entry<String, BfilTelecallUpdateBean> tele : teleMap.entrySet()){*/
			for(BfilTelecallUpdateBean tele : responseList){
				try {
						//ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
						BfilTelecallUpdateBean bfilTelecallUpdateBean = tele;	// mapper.convertValue(tele.getValue(), BfilTelecallUpdateBean.class);
						String cancelInitiateKey = messageSource.getMessage(GlobalConstant.INITIATE_BOOKING_CANCEL, null, null);
						String reattemptKey = messageSource.getMessage(GlobalConstant.CLIENT_REQUEST_PICKUP_REATTEMPT, null, null);
						String dataReceivedKey = messageSource.getMessage(GlobalConstant.CLIENT_REQUEST_PICKUP_REATTEMPT, null, null);
						
						StatusMaster teleVerify = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.ORDER_VERIFIED, null, null), StatusMaster.class);
						StatusMaster invoiceCancel = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.INVOICE_CANCELLED, null, null), StatusMaster.class);
						
						/*List<String> list = new ArrayList<>();
						list.add(cancelInitiateKey);
						list.add(reattemptKey);
						list.add(dataReceivedKey);*/
						
						Query query = new Query();
						query.addCriteria(Criteria.where("clientManifest").is(bfilTelecallUpdateBean.getLoanProposalID()).and("expired_b").is(false));
						List<SaleOrder> orderList = saleOrderDao.getObjectByQuery(query, SaleOrder.class);
						
						if(orderList == null || orderList.isEmpty()){
							continue;
						}
						SaleOrder saleOrder = orderList.get(orderList.size()-1);

						if(bfilTelecallUpdateBean.getAlternateMobileNumber() != null){
							String biflVertualNo = messageSource.getMessage(GlobalConstant.BFIL_VIRTUAL_PHONE_NUMBER, null, null).trim();
							saleOrder.setConsigneeMobileNumber(biflVertualNo+","+bfilTelecallUpdateBean.getAlternateMobileNumber()+"#");
							saleOrder.setContactUpdate(true);
							saleOrder.setTeleStatusPush(false);
							if(!saleOrder.getTelecallingStatus().equals(teleVerify.getStatusName()) && !saleOrder.getInvoiceStatus().equals(invoiceCancel.getStatusName()) && 
							saleOrder.getCurrentStatus().getKey_s().equals(dataReceivedKey) || saleOrder.getCurrentStatus().getKey_s().equals(reattemptKey) || saleOrder.getCurrentStatus().getKey_s().equals(cancelInitiateKey)){
								saleOrder.setTelecallingCount(0);
							}
							if(saleOrder.getCurrentStatus().getKey_s().equals(cancelInitiateKey)){
								responseBean = saleOrderService.updateCurrentStatusAndPacketHistory(saleOrder, reattemptKey);
							}
							saleOrderDao.updateObject(saleOrder);
							
							//TODO call bfilTelecallLogsUpdates(String loanProposalID) method after updating contact number.
							bfilTelecallLogsUpdates(bfilTelecallUpdateBean.getLoanProposalID());
							
						} 
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean; 
	}
	
	public ResponseBean bfilTelecallLogsUpdates(String loanProposalID) {
		ResponseBean responseBean = new ResponseBean();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.BFIL_TELECALL_SUCCESS_UPDATE, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s()+"/"+loanProposalID);
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			httpRequestBean.setRequestProperty(requestProperty);
			
			httpRequestBean.setParams(new HashMap<String,Object>());
			
			StringBuffer buffer = new HttpUtilitty().doGET(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			logger.info(ResponseBean.class, "BFIL Telecall Flag Update Logs       Status="+apiResponse.getStatus()+"      Message="+apiResponse.getMessage());
			if(apiResponse == null || apiResponse.getStatus().equals(ResponseStatus.FAIL)) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(apiResponse != null ? apiResponse.getMessage() :"Tomcat is not running at RAL api server.");
				return responseBean;
			}
			responseBean = apiResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	public ResponseBean getBfilCancelOrders() {
		ResponseBean responseBean = new ResponseBean();
		Map<String,BfilOrderCancelBean> orderCancelMap = new HashMap<String,BfilOrderCancelBean>();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.BFIL_CANCEL_ORDER, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s());
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			httpRequestBean.setRequestProperty(requestProperty);
			
			httpRequestBean.setParams(new HashMap<String,Object>());
			
			StringBuffer buffer = new HttpUtilitty().doPOST(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			if(apiResponse == null || apiResponse.getStatus().equals(ResponseStatus.FAIL)) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(apiResponse != null ? apiResponse.getMessage() :"Tomcat is not running at RAL api server.");
				return responseBean;
			}
			List<BfilOrderCancelBean> responseList = new ArrayList<BfilOrderCancelBean>();
			JSONArray jsonArray = new JSONObject(buffer.toString()).optJSONArray("response");
			for(int i =0; i<jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				responseList.add(gson.fromJson(jsonObject.toString(), BfilOrderCancelBean.class));
			}
			/*orderCancelMap = (Map<String, BfilOrderCancelBean>) apiResponse.getResponse();
			for(Map.Entry<String, BfilOrderCancelBean> orderCancel : orderCancelMap.entrySet()){*/
			for(BfilOrderCancelBean orderCancel : responseList){
				try {
						//ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
						BfilOrderCancelBean bfilOrderCancelBean = orderCancel;	// mapper.convertValue(orderCancel.getValue(), BfilOrderCancelBean.class);
						StatusMaster invoiceCancel = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.INVOICE_CANCELLED, null, null), StatusMaster.class);
						
						Query query = new Query();
						query.addCriteria(Criteria.where("clientManifest").is(bfilOrderCancelBean.getLoanProposalID()).and("expired_b").is(false));
						List<SaleOrder> orderList = saleOrderDao.getObjectByQuery(query, SaleOrder.class);
						
						if(orderList == null || orderList.isEmpty()){
							continue;
						}
						SaleOrder saleOrder = orderList.get(orderList.size()-1);

						if(bfilOrderCancelBean.getCancelStatus() != null && bfilOrderCancelBean.getCancelStatus().equalsIgnoreCase("Order Cancelled")){	//INVOICE CANCELLED
							saleOrder.setInvoiceStatus(invoiceCancel.getStatusName());
							if(saleOrder.getScannedDate() != null && !"".equals(saleOrder.getScannedDate())){
								String toStatusKey = messageSource.getMessage(GlobalConstant.RETURN_TO_ORIGIN_INITIATED, null, null);
								Settings rtoReason = settingsDao.getObjectById("rto1", Settings.class);
								responseBean = saleOrderService.updateCurrentStatusAndPacketHistory(saleOrder, toStatusKey, rtoReason.getContextCode_s(), null);
								if (responseBean.getStatus().equals(ResponseStatus.FAIL)) {
									return responseBean;
								}
							}else{
								String toStatusKey = messageSource.getMessage(GlobalConstant.INITIATE_BOOKING_CANCEL, null, null);
								//Add Cancel Reason
								String cancelReason = messageSource.getMessage(GlobalConstant.BOOKING_MAX_CALL_ATTEPTED, null, null);
								saleOrder.setCancelReason(cancelReason);
								responseBean = saleOrderService.updateCurrentStatusAndPacketHistory(saleOrder, toStatusKey, cancelReason, null);
								if (responseBean.getStatus().equals(ResponseStatus.FAIL)) {
									return responseBean;
								}
							}
							//saleOrderDao.updateObject(saleOrder);
							
							//TODO call bfilCancelOrdersLogsUpdate(String loanProposalID) method after cancel order.
							bfilCancelOrdersLogsUpdate(bfilOrderCancelBean.getLoanProposalID());
						}
						
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean; 
	}
	
	public ResponseBean bfilCancelOrdersLogsUpdate(String loanProposalID) {
		ResponseBean responseBean = new ResponseBean();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.BFIL_CANCEL_ORDER_SUCCESS_UPDATE, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s()+"/"+loanProposalID);
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			httpRequestBean.setRequestProperty(requestProperty);
			
			httpRequestBean.setParams(new HashMap<String,Object>());
			
			StringBuffer buffer = new HttpUtilitty().doGET(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			logger.info(ResponseBean.class, "BFIL CancelOrders Flag Update Logs      Status="+apiResponse.getStatus()+"      Message="+apiResponse.getMessage());
			if(apiResponse == null || apiResponse.getStatus().equals(ResponseStatus.FAIL)) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(apiResponse != null ? apiResponse.getMessage() :"Tomcat is not running at RAL api server.");
				return responseBean;
			}
			responseBean = apiResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	public ResponseBean getBfilOrders() {
		ResponseBean responseBean = new ResponseBean();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.BFIL_ORDER_FETCH, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s());
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			httpRequestBean.setRequestProperty(requestProperty);
			
			httpRequestBean.setParams(new HashMap<String,Object>());
			
			StringBuffer buffer = new HttpUtilitty().doPOST(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			if(apiResponse == null || apiResponse.getStatus().equals(ResponseStatus.FAIL)) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(apiResponse != null ? apiResponse.getMessage() :"Tomcat is not running at RAL api server.");
				return responseBean;
			}
			List<BfilOrderBean> responseList = new ArrayList<BfilOrderBean>();
			JSONArray jsonArray = new JSONObject(buffer.toString()).optJSONArray("response");
			for(int i =0; i<jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				responseList.add(gson.fromJson(jsonObject.toString(), BfilOrderBean.class));
			}
			
			if(responseList.isEmpty()) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in converting json to object");
				return responseBean;
			}
			
			Map<String, String> errorDataPush = new HashMap<String, String>();
			Map<String, String> successDataPush = new HashMap<String, String>();
			Map<String, String> dublicateData = new HashMap<String, String>();
			
			Client client = clientDao.getEntityByLocationKey("RAL");
			int count = 0;
			for(BfilOrderBean bfilOrderBean : responseList) {
				logger.info(BfilOrderBean.class, "BIFL Data Push Progress ---> "+ count++ +"/"+responseList.size());
				if(bfilOrderBean == null) {
					continue;
				}
				try {
					Query query = new Query();
					query.addCriteria(Criteria.where("clientManifest").is(bfilOrderBean.getLoanProposalID().trim()).and("clientKey_s").is("RAL"));
					List<String> keyList = saleOrderDao.getKeys(query, SaleOrder.class);
					if(keyList != null && !keyList.isEmpty()) {
						logger.info(SaleOrder.class, "BFIL LoanProposalId dublicate--->AWB="+keyList.toString());
						dublicateData.put(bfilOrderBean.getLoanProposalID(), keyList.toString());
						continue;
					}
					
					if(bfilOrderBean.getLoanProposalID() == null || "".equals(bfilOrderBean.getLoanProposalID().trim())) {
						ResponseBean error = new ResponseBean();
						error.setStatus(ResponseStatus.FAIL);
						error.setMessage("Fail to data push : LoanCode field is null");
						errorDataPush.put(bfilOrderBean.getLoanProposalID(), error.getMessage());
						saveBfilDataFetchErrorLogs(bfilOrderBean, responseBean);
						pushLogsInRalSystem(error, null, bfilOrderBean.getLoanProposalID());
					}
					
					ResponseBean responseBean2 = punchOrderInBMP(bfilOrderBean, client);
					if(responseBean2.getStatus().equals(ResponseStatus.SUCCESS)) {
						SaleOrder order = (SaleOrder) responseBean2.getResponse();
						successDataPush.put(bfilOrderBean.getLoanProposalID(), order.getKey_s());
						pushLogsInRalSystem(responseBean2, order.getAwbNumber(), bfilOrderBean.getLoanProposalID());
						saveBfilDataFetchErrorLogs(bfilOrderBean, responseBean2);
						bfilOrdersLogsUpdate(bfilOrderBean.getLoanProposalID());
					}else {
						errorDataPush.put(bfilOrderBean.getLoanProposalID(), responseBean2.getMessage());
						saveBfilDataFetchErrorLogs(bfilOrderBean, responseBean2);
						pushLogsInRalSystem(responseBean2, null, bfilOrderBean.getLoanProposalID());
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					errorDataPush.put(bfilOrderBean.getLoanProposalID(), e.getMessage());
					ResponseBean errorResponse = new ResponseBean();
					errorResponse.setStatus(ResponseStatus.FAIL);
					errorResponse.setMessage(e.getMessage());
					saveBfilDataFetchErrorLogs(bfilOrderBean, errorResponse);
				}
			}
			Map<String,Object> mapObj = new HashMap<String,Object>();
			mapObj.put("errorDataPush", errorDataPush);
			mapObj.put("successDataPush", successDataPush);
			mapObj.put("dublicateData", dublicateData);
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(mapObj);
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(e.getMessage());
		}
		return responseBean; 
	}
	
	public ResponseBean punchOrderInBMP(BfilOrderBean bfilOrderBean, Client client) {
		ResponseBean responseBean = new ResponseBean();
		try {
			
			//if deliverytype is RDSP then change consignee datails
			if(bfilOrderBean.getDeliveryType() != null && bfilOrderBean.getDeliveryType().equalsIgnoreCase("RDSP")){
				if(bfilOrderBean.getRdspID() != null && !"".equals(bfilOrderBean.getRdspID().trim())){
					RDSP rdsp = rdspDao.getObjectById(bfilOrderBean.getRdspID(), RDSP.class);
					if(rdsp != null){
						//TODO add consignee pincode
						//String merchantAddress = rdsp.getMerchantAddress().trim();
						//String pincode = merchantAddress.substring(merchantAddress.length()-6);
						bfilOrderBean.setPincode(rdsp.getPincode());
						bfilOrderBean.setClientName(rdsp.getMerchantName());
						bfilOrderBean.setMobileNumber(rdsp.getMerchantMobile());
						bfilOrderBean.setAddressLine1(rdsp.getMerchantAddress());
						bfilOrderBean.setAddressLine2(null);
						//bfilOrderBean.setCenterLatLong(rdsp.getMerchantLatLong());
						bfilOrderBean.setText2(rdsp.getMerchantLatLong());
					}else{
						responseBean.setStatus(ResponseStatus.FAIL);
						responseBean.setMessage("RdspMaster With RdspId "+bfilOrderBean.getRdspID() +" Is Not Present : Please add.");
						return responseBean;
					}
				}else{
					responseBean.setStatus(ResponseStatus.FAIL);
					responseBean.setMessage("RdspId Cannot Be Blank For LoanProposalId "+bfilOrderBean.getLoanProposalID() +" : Please check.");
					return responseBean;
				}
			}
			
			StagingSaleOrder stagingSaleOrder = convertBfilOrderToBmpOrder(bfilOrderBean, client);
			if(stagingSaleOrder == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error : Order converter fail form BFIL to BMP");
				return responseBean;
			}
			
			if(stagingSaleOrder.getManifestNumber() == null || "".equals(stagingSaleOrder.getManifestNumber().trim())) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Fail to data push : LoanCode field is null");
				return responseBean;
			}
			
			responseBean = stagingSaleOrderService.createStagingSaleOrderNew(stagingSaleOrder);
			if(responseBean.getStatus().equals(ResponseStatus.FAIL)) {
				System.out.println("Error in creating order : "+responseBean.getMessage());
				return responseBean;
			}
			
			SaleOrder order = (SaleOrder) responseBean.getResponse();
			order.setClientVendorCode(bfilOrderBean.getVendorId());
			try {
				StatusMaster statusMaster = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.INVOICE_PENDING, null, null), StatusMaster.class);
				order.setInvoiceStatus(statusMaster.getStatusName());
				statusMaster = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.ORDER_VERIFY_PENDING, null, null), StatusMaster.class);
				//if deliveryModel is new then mark telecalingStatus as Order Verified
				StatusMaster orderVerify = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.ORDER_VERIFIED, null, null), StatusMaster.class);
				if(bfilOrderBean.getDeliveryModel() != null && bfilOrderBean.getDeliveryModel().equalsIgnoreCase("NEW")){
					order.setTelecallingStatus(orderVerify.getStatusName());
				}else{
					order.setTelecallingStatus(statusMaster.getStatusName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			saleOrderDao.updateObject(order);
			//Save Extra fields
			SaleOrderExtra orderExtra = saleOrderExtraDao.getObjectById(order.getKey_s(), SaleOrderExtra.class);
			if(orderExtra != null) {
				orderExtra.setBmName(bfilOrderBean.getBMName());
				orderExtra.setBmNumber(bfilOrderBean.getBMNumber());
				orderExtra.setSmName(bfilOrderBean.getSMName());
				orderExtra.setSmNumber(bfilOrderBean.getSMNumber());
				orderExtra.setClientUniqueID(bfilOrderBean.getClientUniqueID());
				saleOrderExtraDao.updateObject(orderExtra);
			}
			
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(order);
		}catch(Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return responseBean;
	}
	
	public ResponseBean bfilOrdersLogsUpdate(String loanProposalID) {
		ResponseBean responseBean = new ResponseBean();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.BFIL_ORDER_FETCH_SUCCESS_UPDATE, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s()+"/"+loanProposalID);
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			httpRequestBean.setRequestProperty(requestProperty);
			
			httpRequestBean.setParams(new HashMap<String,Object>());
			
			StringBuffer buffer = new HttpUtilitty().doGET(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			logger.info(ResponseBean.class, "BFIL Order Flag Update Logs       Status="+apiResponse.getStatus()+"      Message="+apiResponse.getMessage());
			if(apiResponse == null || apiResponse.getStatus().equals(ResponseStatus.FAIL)) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(apiResponse != null ? apiResponse.getMessage() :"Tomcat is not running at RAL api server.");
				return responseBean;
			}
			responseBean = apiResponse;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	public StagingSaleOrder convertBfilOrderToBmpOrder(BfilOrderBean bfilOrderBean, Client client) {
		StagingSaleOrder saleOrder = new StagingSaleOrder();
		try {
			String fields = "_id,branch._id,branch.branchCode";
			ServiceablePincode serviceablePincode = serviceablePincodeDao.getObjectById(bfilOrderBean.getPincode().trim(), Arrays.asList(fields.split(",")), ServiceablePincode.class);
			String sourceBranchKey = (serviceablePincode != null && serviceablePincode.getBranch() != null && serviceablePincode.getBranch().getKey_s() != null) ? serviceablePincode.getBranch().getKey_s() : "NA";
			
			fields = "_id,pincode,branchCode,address";
			Branch branch = branchDao.getObjectById(sourceBranchKey, Arrays.asList(fields.split(",")), Branch.class);
			
			saleOrder.setClientKey_s("RAL");
			saleOrder.setSenderName("RAL");
			saleOrder.setSenderMobileNumber_s(client.getMobile());
			saleOrder.setSenderAltNumber(client.getMobile());
			saleOrder.setSenderAddress(branch != null ? branch.getAddress() : "B-7/2 Okhla Industrial Area Phase -2  New Delhi");
			saleOrder.setSenderPincode_s(branch != null ? branch.getPincode() : "250001");
			
			saleOrder.setReturnName("RAL");
			saleOrder.setReturnMobileNumber(client.getMobile());
			saleOrder.setReturnAlternateNumber(client.getMobile());
			saleOrder.setReturnAddress(branch != null ? branch.getAddress() : "B-7/2 Okhla Industrial Area Phase -2  New Delhi");
			saleOrder.setReturnPincode(branch != null ? branch.getPincode() : "250001");
			
			String consigneName = bfilOrderBean.getClientName();
			if(bfilOrderBean.getSpouseName() != null && !"".equals(bfilOrderBean.getSpouseName().trim())) {
				consigneName = consigneName +  " (Care Of "+bfilOrderBean.getSpouseName()+")";
			}
			String biflVertualNo = messageSource.getMessage(GlobalConstant.BFIL_VIRTUAL_PHONE_NUMBER, null, null).trim();
			saleOrder.setConsigneeName(consigneName);
			if(bfilOrderBean.getMobileNumber() != null && !"".equals(bfilOrderBean.getMobileNumber().trim())) {
				if(bfilOrderBean.getMobileNumber().length() < 10) {
					saleOrder.setConsigneeMobileNumber_s(biflVertualNo+","+bfilOrderBean.getMobileNumber()+"#");
				} else {
					saleOrder.setConsigneeMobileNumber_s(bfilOrderBean.getMobileNumber());
				}
			}
			/*if(bfilOrderBean.getMemberAlternateMobileNumber() != null && !"".equals(bfilOrderBean.getMemberAlternateMobileNumber().trim())) {
				saleOrder.setConsigneeAlternateNumber(biflVertualNo+","+bfilOrderBean.getMemberAlternateMobileNumber()+"#");
			}*/
			saleOrder.setConsigneeAlternateNumber(bfilOrderBean.getText2());
			saleOrder.setConsigneeEmailId("abc@gmail.com");
			saleOrder.setConsigneeLandmark(bfilOrderBean.getLandmark()+",("+bfilOrderBean.getText1()+")");
			String consigneAddress = bfilOrderBean.getAddressLine1();
			if(bfilOrderBean.getAddressLine2() != null) {
				consigneAddress = consigneAddress+ ", "+bfilOrderBean.getAddressLine2();
			}
			saleOrder.setConsigneeAddress(consigneAddress);
			saleOrder.setConsigneePincode_s(bfilOrderBean.getPincode());
			
			saleOrder.setPaymentType_s(PaymentType.PREPAID.toString());
			saleOrder.setProductType ("standard");
			saleOrder.setSaleOrderNumber_s("RAL");
			saleOrder.setManifestNumber(bfilOrderBean.getLoanProposalID());
			saleOrder.setProductSKU(bfilOrderBean.getProductID());      //discuss
			saleOrder.setProductName(bfilOrderBean.getModel());
			saleOrder.setPerishable("No");
			saleOrder.setFlammable("No");
			saleOrder.setQuantity(1);
			saleOrder.setLength(1.00);
			saleOrder.setWidth(2.00);
			saleOrder.setHeight(3.00);
			saleOrder.setWeight(500.00);
			saleOrder.setCollectableAmount(0.0);
			//String latLong = (bfilOrderBean.getText2()!= null && !"".equals(bfilOrderBean.getText2().trim()))  ? bfilOrderBean.getText2().replaceAll(",", "/") : null;
			//saleOrder.setDestLatLong(latLong);
			if(bfilOrderBean.getMemberOfferPrice() != null && !"".equals(bfilOrderBean.getMemberOfferPrice().trim())) {
				try {
					saleOrder.setProductPrice(Double.valueOf(bfilOrderBean.getMemberOfferPrice().trim()));
				}catch(Exception e) {
					e.printStackTrace();
					//saleOrder.setProductPrice(0.0);
				}
			}
			//saleOrder.setiGSTAmount(String.valueOf(ralOrderBean.getIgst_Value()));
			//saleOrder.setsGSTAmount(String.valueOf(ralOrderBean.getSgst_Value()));
			//saleOrder.setcGSTAmount(String.valueOf(ralOrderBean.getDgGood()));
			return saleOrder;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return saleOrder;
	}
	
	public void saveBfilDataFetchErrorLogs(BfilOrderBean bfilOrderBean , ResponseBean responseBean) {
		try {
			DataFetchErrorLogs dataFetchErrorLogs = new DataFetchErrorLogs();
			dataFetchErrorLogs.setClient("RAL");
			dataFetchErrorLogs.setDate(CommonUtility.convertCurrentDateToYYYYMMDDHHMMSS());
			dataFetchErrorLogs.setKey_s((bfilOrderBean.getLoanProposalID() != null && !"".equals(bfilOrderBean.getLoanProposalID().trim())) ? bfilOrderBean.getLoanProposalID() : String.valueOf(new Date().getTime()));
			dataFetchErrorLogs.setLoanProposalID(bfilOrderBean.getLoanProposalID());
			dataFetchErrorLogs.setOrderNumber("RAL");
			dataFetchErrorLogs.setStatus(responseBean.getStatus().name());
			dataFetchErrorLogs.setMessage(responseBean.getMessage());
			ObjectMapper objectMapper = new ObjectMapper();
			dataFetchErrorLogs.setRequest(objectMapper.writeValueAsString(bfilOrderBean));
			if(responseBean.getStatus().equals(ResponseStatus.SUCCESS)) {
				dataFetchErrorLogsDao.remove(bfilOrderBean.getLoanProposalID(), DataFetchErrorLogs.class);
			}else {
				
				DataFetchErrorLogs fetchErrorLogs = dataFetchErrorLogsDao.getObjectById(bfilOrderBean.getLoanProposalID(), DataFetchErrorLogs.class);
				if(fetchErrorLogs == null) {
					dataFetchErrorLogsDao.saveObject(dataFetchErrorLogs, DataFetchErrorLogs.class);
				}else {
					fetchErrorLogs.setMessage(responseBean.getMessage());
					dataFetchErrorLogsDao.updateObject(fetchErrorLogs);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResponseBean getAllInvoiceCancel() {
		ResponseBean responseBean = new ResponseBean();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.RAL_INVOICE_CANCEL_GET_API, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s());
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			httpRequestBean.setRequestProperty(requestProperty);
			
			httpRequestBean.setParams(new HashMap<String,Object>());
			
			StringBuffer buffer = new HttpUtilitty().doGET(httpRequestBean);
			Gson gson = new Gson();
			ResponseBean apiResponse = gson.fromJson(new String(buffer), ResponseBean.class);
			if(apiResponse != null && apiResponse.getStatus().equals(ResponseStatus.SUCCESS)) {
				List<InvoiceCancel> invoiceCancelList = new ArrayList<InvoiceCancel>();
				JSONArray jsonArray = new JSONObject(buffer.toString()).optJSONArray("response");
				for(int i =0; i<jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					invoiceCancelList.add(gson.fromJson(jsonObject.toString(), InvoiceCancel.class));
				}
				if(invoiceCancelList != null && !invoiceCancelList.isEmpty()) {
					List<String> loanCodeList = new ArrayList<String>();
					for(InvoiceCancel invoiceCancel : invoiceCancelList) {
						if(invoiceCancel != null && invoiceCancel.getLoanproposalid() != null) {
							loanCodeList.add(invoiceCancel.getLoanproposalid());
						}
					}
					List<List<String>> orderSmallerLists = Lists.partition(loanCodeList, 100);
					List<SaleOrder> ordersList = new ArrayList<SaleOrder>();
					for(List<String> list : orderSmallerLists) {
						try {
							Query query = new Query();
							query.addCriteria(Criteria.where("clientKey_s").is(GlobalConstant.RAL_CLIENT_KEY)
									.and("clientManifest").in(list));
							ordersList.addAll(saleOrderDao.getObjectByQuery(query, SaleOrder.class));
						}catch(Exception e) {e.printStackTrace();}
					}
					
					// Update Invoice cancel
					String packetOnHold = messageSource.getMessage(GlobalConstant.PACKET_ON_HOLD, null, null).trim();
					String reinvoiceNdr = messageSource.getMessage(GlobalConstant.PENDING_FOR_RE_INVOICE_NDR, null, null).trim();
					List<String> terminalStatus = new ArrayList<String>(Arrays.asList(messageSource.getMessage(GlobalConstant.PACKET_TERMINAL_STATUS, null, null).trim().split(",")));
					List<String> packetInHandStatus = new ArrayList<String>(Arrays.asList(messageSource.getMessage(GlobalConstant.PACKET_IN_HAND_STATUS, null, null).trim().split(",")));
					for(SaleOrder saleOrder : ordersList) {
						try {
							// Update cancel invoice fetch success status in RAL system
							ResponseBean ralApiResponse = updateCancelInvoiceFetchSuccessInRalSystem(saleOrder.getClientManifest());
							if(ralApiResponse.getStatus().equals(ResponseStatus.FAIL)) {
								continue;
							}
							
							SaleOrderExtra saleOrderExtra = saleOrderExtraDao.getObjectById(saleOrder.getKey_s(), SaleOrderExtra.class);
							if(saleOrderExtra != null) {
								saleOrderExtra.setInvoiceCancel(true);
								saleOrderExtra.setInvoiceCancelDate(new Date().getTime());
								saleOrderExtraDao.updateObject(saleOrderExtra);
							}
							if(!terminalStatus.contains(saleOrder.getCurrentStatus().getKey_s())) {
								if(packetInHandStatus.contains(saleOrder.getCurrentStatus().getKey_s())) {
									saleOrderService.packetOnHold(saleOrder.getKey_s(), reinvoiceNdr);
								}else {
									saleOrder.setPendingStatusToUpload(packetOnHold+"#"+reinvoiceNdr);
									saleOrderDao.updateObject(saleOrder);
								}
							}
						}catch(Exception e) {e.printStackTrace();}
					}
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	private ResponseBean updateCancelInvoiceFetchSuccessInRalSystem(String loanCode) {
		ResponseBean responseBean = new ResponseBean();
		try {
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.UPDATE_CANCEL_INVOICE_IN_RAL, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return responseBean;
			}
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s()+"/"+loanCode+"/true");
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			httpRequestBean.setRequestProperty(requestProperty);
			
			httpRequestBean.setParams(new HashMap<String,Object>());
			
			StringBuffer buffer = new HttpUtilitty().doGET(httpRequestBean);
			Gson gson = new Gson();
			responseBean = gson.fromJson(new String(buffer), ResponseBean.class);
		}catch(Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return responseBean;
	}
	
	public ResponseBean getReInvoiceGenerateInRalSystem() {
		ResponseBean responseBean = new ResponseBean();
		try {
			List<String> terminalStatus = new ArrayList<String>(Arrays.asList(messageSource.getMessage(GlobalConstant.PACKET_TERMINAL_STATUS, null, null).trim().split(",")));
			Query query = new Query();
			query.addCriteria(Criteria.where("invoiceCancel").is(true).and("clientKey_s").is(GlobalConstant.RAL_CLIENT_KEY));
			List<String> keyList = saleOrderExtraDao.getKeys(query, SaleOrderExtra.class);
			if(keyList != null && !keyList.isEmpty()) {
				List<SaleOrder> saleOrderList = new ArrayList<SaleOrder>();
				for(List<String> list : Lists.partition(keyList, 100)) {
					saleOrderList.addAll(saleOrderDao.getObjectListByIds(list, SaleOrder.class));
				}
				List<String> loanCodeList = new ArrayList<String>();
				Map<String, SaleOrder> orderLoanMap = new HashMap<String, SaleOrder>();
				for(SaleOrder saleOrder : saleOrderList) {
					if(!terminalStatus.contains(saleOrder.getCurrentStatus().getKey_s())) {
						loanCodeList.add(saleOrder.getClientManifest());
						orderLoanMap.put(saleOrder.getClientManifest(), saleOrder);
					}
				}
				
				ResponseBean invoiceResponseBean = getInvoiceData(loanCodeList);
				if(invoiceResponseBean != null && invoiceResponseBean.getStatus().equals(ResponseStatus.SUCCESS)) {
					Map<String, InvoiceStatusBean> invoiceMap = (Map<String, InvoiceStatusBean>) invoiceResponseBean.getResponse();
					ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
					for(Entry<String, InvoiceStatusBean> entry : invoiceMap.entrySet()) {
						SaleOrder saleOrder = orderLoanMap.get(entry.getKey());
						if(saleOrder != null) {
							SaleOrderExtra saleOrderExtra = saleOrderExtraDao.getObjectById(saleOrder.getKey_s(), SaleOrderExtra.class);
							if(terminalStatus.contains(saleOrder.getCurrentStatus().getKey_s())) {
								//saleOrderExtra.setInvoiceCancel(false);
								//saleOrderExtraDao.updateObject(saleOrderExtra);
							}else {
								InvoiceStatusBean invoiceStatusBean = mapper.convertValue(entry.getValue(), InvoiceStatusBean.class);
								//InvoiceStatusBean  invoiceStatusBean = entry.getValue();
								if(invoiceStatusBean != null && !saleOrder.getSaleOrderNumber_s().contains(invoiceStatusBean.getSaleOrderNumber())) {
									saleOrder.setSaleOrderNumber_s(invoiceStatusBean.getSaleOrderNumber());
									saleOrder.setInvoiceDate(CommonUtility.convertCurrentDateToDDMMYYYY(invoiceStatusBean.getInvoiceDate()));
									saleOrder.setProductSKU(invoiceStatusBean.getImeNumber());
									StatusMaster statusInvoice = statusMasterDao.getObjectById(messageSource.getMessage(GlobalConstant.INVOICE_GENERATED, null, null), StatusMaster.class);
									saleOrder.setInvoiceStatus(statusInvoice.getStatusName());
									
									String packetOnHold = messageSource.getMessage(GlobalConstant.PACKET_ON_HOLD, null, null).trim();
									if(saleOrder.getCurrentStatus().getKey_s().equals(packetOnHold)) {
										saleOrderService.packetUnHold(saleOrder.getKey_s());
									}else {
										saleOrder.setPendingStatusToUpload(null);
										saleOrderDao.updateObject(saleOrder);
									}
									saleOrderExtra.setInvoiceCancel(false);
									saleOrderExtraDao.updateObject(saleOrderExtra);
									//Add invoice status in push history bucket
									PushPacketStatusHistory pushPacketStatusHistory = pushPacketStatusHistoryDao.getObjectById(saleOrder.getKey_s(),PushPacketStatusHistory.class);
									if(pushPacketStatusHistory != null && pushPacketStatusHistory.getBfilPacketsHistory() != null && !pushPacketStatusHistory.getBfilPacketsHistory().containsKey("INVOICE")) {
										pushStatusToVendorService.bfilPushStatusHistory(saleOrder, GlobalConstant.INVOICE_UPDATE_STATUS);
									}
								}
							}
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	private ResponseBean getInvoiceData(List<String> loadCodeList) {
		ResponseBean responseBean = new ResponseBean();
		try {
			Map<String,Object> requestParam = new HashMap<String,Object>();
			requestParam.put("orderList", loadCodeList);
			//requestParam.put("orderList", Arrays.asList("0f0119000021,0f0119000069,0g0119000054,060119000046".split(",")));
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.RAL_INVOICE_STATUS_GET_VENDOR_API_KEY, null, null).trim(), VendorApiBean.class);
			if(vendorApiBean == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Error in getting VendorApiBean : Please contact support team.");
				return null;
			}
			
			Map<String,String> requestProperty = new HashMap<String,String>();
			requestProperty.put("Content-Type", "application/json");
			HttpRequestBean httpRequestBean = new HttpRequestBean();
			httpRequestBean.setRequestMethod(vendorApiBean.getMethod_s());
			httpRequestBean.setUrl(vendorApiBean.getUrl_s());
			httpRequestBean.setRequestProperty(requestProperty);
			httpRequestBean.setParams(requestParam);
			
			StringBuffer buffer = new HttpUtilitty().doPOST(httpRequestBean);
			
			Gson gson = new Gson();
			responseBean = gson.fromJson(new String(buffer), ResponseBean.class);
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(e.getMessage());
		}
		return responseBean;
	}
	
	
}
