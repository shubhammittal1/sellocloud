package com.bmp.oms.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bmp.bean.Test;
import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.AlertStatus;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LogTypes;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.OutgoingCallLogsDao;
import com.bmp.dao.PushPacketStatusHistoryDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.SaleOrderExtraDao;
import com.bmp.dao.SmsMailMasterDao;
import com.bmp.dao.StatusPushErrorLogsDao;
import com.bmp.dao.StatusPushSuccessLogsDao;
import com.bmp.dao.VendorApiDao;
import com.bmp.mail.model.CommonMailDTO;
import com.bmp.mail.server.MailServer;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.saleorder.BFILPacketsHistory;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.PushPacketStatusHistory;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderExtra;
import com.bmp.model.app.saleorder.StatusPushErrorLogs;
import com.bmp.model.app.saleorder.StatusPushSuccessLogs;
import com.bmp.model.app.systemCalling.OutgoingCallLogs;
import com.bmp.model.app.utility.SmsMailMaster;
import com.bmp.oms.service.TestService;
import com.bmp.oms.service.api.statusPush.PushStatusApiHelper;
import com.bmp.oms.service.api.statusPush.impl.BFILPushStatusApiHelperImpl;
import com.bmp.oms.service.impl.TestServiceImpl;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpResponseBean;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.bmp.utility.logger.AsyncLogger;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("statusPushSuccessLogsDaoImpl")
	private StatusPushSuccessLogsDao statusPushSuccessLogsDao;
	
	@Autowired
	@Qualifier("testServiceImpl")
	private TestService testService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("mailServer")
	private MailServer mailServer;
	
	@Autowired
	@Qualifier("pushPacketStatusHistoryDaoImpl")
	private PushPacketStatusHistoryDao pushPacketStatusHistoryDao;
	
	@Autowired
	@Qualifier("statusPushErrorLogsDaoImpl")
	private StatusPushErrorLogsDao statusPushErrorLogsDao;
	
	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired
	@Qualifier("saleOrderExtraDaoImpl")
	private SaleOrderExtraDao saleOrderExtraDao;
	
	@Autowired
	@Qualifier("vendorApiDaoImpl")
	private VendorApiDao vendorApiDao;
	
	@Autowired
	@Qualifier("outgoingCallLogsDaoImpl")
	private OutgoingCallLogsDao outgoingCallLogsDao;
	
	@Autowired
	@Qualifier("bfilPushStatusApiHelperImpl")
	private PushStatusApiHelper bfilPushStatusApiHelper;
	
	@Autowired
	@Qualifier("smsMailMasterDaoImpl")
	private SmsMailMasterDao smsMailMasterDao;
	
	@RequestMapping(value = "/getAllTest", method = RequestMethod.GET)
	@ResponseBody
    public List<Test> getAllStates() {
		List<Test> resultList = null;
		try {
			resultList = testService.getAllTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return resultList;
    }
	
	@RequestMapping(value = "/facility/deletePacketStatusSpacel", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deletePacketStatusSpacel(HttpServletRequest request, HttpServletResponse response) {
		
        return testService.deletePacketStatusSpacel(null, null);
    }
	
	
	@RequestMapping(value = "/token/getAllTestToken", method = RequestMethod.GET)
	@ResponseBody
    public List<Test> getAllStatesToken() {
		List<Test> resultList = null;
		try {
			resultList = testService.getAllTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return resultList;
    }
	
	@RequestMapping(value = "/getAllTestMVC", method = RequestMethod.GET)
    public ModelAndView getAllStates1() {
		ModelAndView modelAndView = new ModelAndView("test/test");
		List<Test> resultList = null;
		try {
			resultList = testService.getAllTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("test", resultList);
        return modelAndView;
    }
	
	@RequestMapping(value = "/getPageActions", method = RequestMethod.GET)
	@ResponseBody
    public List<Test> getPageActions () {
		List<Test> resultList = null;
		try {
			resultList = testService.getAllTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return resultList;
    }
	
	 @RequestMapping(value = "/oldscanRtoReceivedPacket/{rtoAwbNumber}", method = RequestMethod.GET)
		@ResponseBody
		public ResponseBean scanRtoReceivedPacket(@PathVariable("rtoAwbNumber") String rtoAwbNumber,@RequestParam(value = "key") String currentBranch,
				HttpServletRequest request, HttpServletResponse response) {
			return testService.scanRtoReceivedPacket(rtoAwbNumber,currentBranch);
		}
	
	@RequestMapping(value = "/facility/updateSeries", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean updateSeries () {
        return testService.updateSeries();
    }
	
	@RequestMapping(value = "/facility/updateReconnectClient", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean updateReconnectClient () {
        return testService.updateReconnectClient();
    }
	
	
	
	
	@RequestMapping(value = "/mailDemo", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean mailDemo () {
		
		CommonMailDTO mailDTO = new CommonMailDTO();
		String to[] = {"awanendra.singh@bookmypacket.com"};
		mailDTO.setMailTo(to);
		//mailDTO.setMailcc(mailcc);
		//mailDTO.setMailFrom("babban.prasad@bookmypacket.com");
		mailDTO.setSubject("Test");
		mailDTO.setMailBody(" Hi Awanendra,"
				+ "It is testing mail service");
		boolean response = mailServer.sendMail(mailDTO);
        return null;
    }
	
	@RequestMapping(value = "/aggregationDemo", method = RequestMethod.GET)
	@ResponseBody
    public String aggregationDemo () {
     
		/*MatchOperation matchStage = Aggregation.match(new Criteria("clientKey_s").is("Test"));
		ProjectionOperation projectStage = Aggregation.project("foo", "bar.baz");
		GroupOperation go = new GroupOperation(Fields.fields("_id,".split(",")));
		Aggregation agg = newAggregation(
				Criteria.where("_id").lt(10),
				group("hosting").count().as("total"),
				project("total").and("hosting").previousOperation(),
				sort(Sort.Direction.DESC, "total")
					
			);
		
		GroupOperation sumTotalCityPop = group("state", "city").sum("pop").as("cityPop");
		         
		Aggregation aggregation 
		  = Aggregation.newAggregation(matchStage, projectStage);
		 
		AggregationResults<SaleOrder> output = saleOrderDao.getMongoTemplate().aggregate(aggregation, "saleOrder", SaleOrder.class);
		*/
		return "";
    }
	
	@RequestMapping("/demoJsp")
	public ModelAndView shipWayApi() {
		ModelAndView mv = new ModelAndView("/demoJsp");
		return mv;
	}
	
	@RequestMapping(value = "/api/markPushedRalEhartAwb",method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean markPushedRalEhartAwb(HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		List<String> ehartAwb = new ArrayList<String>();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("pendingPushStatus_b").is(true).and("clientKey_s").is("RAL"));
			List<String> awbNos = pushPacketStatusHistoryDao.getObjectsIdList(query, PushPacketStatusHistory.class);
			for(String awb : awbNos) {
				if(awb.startsWith("EH")) {
					ehartAwb.add(awb);
				}
			}
			if(!ehartAwb.isEmpty()) {
				Update update = new Update();
				update.set("pendingPushStatus_b", false);
				
				Query query1 = new Query();
				query1.addCriteria(Criteria.where("_id").in(ehartAwb));
				pushPacketStatusHistoryDao.updateMultiple(query1, update, PushPacketStatusHistory.class);
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(ehartAwb);
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setResponse(ehartAwb);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/api/resolvedDuplicateSerialnumber",method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean resolvedDuplicateSerialnumber(HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("pendingPushStatus_b").is(true).and("clientKey_s").is("RAL"));
			List<String> awbNos = pushPacketStatusHistoryDao.getObjectsIdList(query, PushPacketStatusHistory.class);
			for(String awb : awbNos) {
				try {
					PushPacketStatusHistory packetStatusHistory = pushPacketStatusHistoryDao.getObjectById(awb, PushPacketStatusHistory.class);
					
					//Case-1
					//Resolved Duplicate Serialnumber found please verify.
					if(packetStatusHistory != null && packetStatusHistory.getErrorLogsKey() != null) {
						StatusPushErrorLogs statusPushErrorLogs = statusPushErrorLogsDao.getObjectById(packetStatusHistory.getErrorLogsKey(), StatusPushErrorLogs.class);
						if(statusPushErrorLogs != null && statusPushErrorLogs.getErrorMsg() != null
								&& (statusPushErrorLogs.getErrorMsg().contains("Duplicate Serialnumber found please verify")
								 || statusPushErrorLogs.getErrorMsg().contains("Same SerialNumber is already exists"))) {
							//
							for(Entry<String, BFILPacketsHistory> entry : packetStatusHistory.getBfilPacketsHistory().entrySet()) {
								try {
									BFILPacketsHistory bfilPacketsHistory = entry.getValue();
									
									SaleOrder saleOrder = saleOrderDao.getObjectById(packetStatusHistory.getKey_s(), SaleOrder.class);
									if("RAL".equals(saleOrder.getSaleOrderNumber_s())) {
										continue;
									}
									
									if(saleOrder.getCurrentStatus().getKey_s().equals("123")) {
										if(entry.getKey().contains("122_123") && !bfilPacketsHistory.isStatusPushed()) {
											bfilPacketsHistory.setSerialNumber(saleOrder.getClientManifest());
										}
										if(entry.getKey().contains("122_123") && !bfilPacketsHistory.isStatusPushed()
												&& (bfilPacketsHistory.getReasonsforNondelivery() == null || "".equals(bfilPacketsHistory.getReasonsforNondelivery().trim()))) {
											bfilPacketsHistory.setReasonsforNondelivery("Address not traceable");
											//Address not traceable
										}
										if(!entry.getKey().contains("122_123") && bfilPacketsHistory != null && !bfilPacketsHistory.isStatusPushed()
												&& bfilPacketsHistory.getSerialNumber() != null 
												&& !"".equals(bfilPacketsHistory.getSerialNumber().trim())) {
											bfilPacketsHistory.setSerialNumber(saleOrder.getClientManifest());
										}
									}else {
										if(bfilPacketsHistory != null && !bfilPacketsHistory.isStatusPushed()
												&& bfilPacketsHistory.getSerialNumber() != null 
												&& !"".equals(bfilPacketsHistory.getSerialNumber().trim())) {
											/*if(!bfilPacketsHistory.getSerialNumber().contains("......")) {
												bfilPacketsHistory.setSerialNumber(bfilPacketsHistory.getSerialNumber()+".");
											}*/
										}
									}
								}catch(Exception e) {
									e.printStackTrace();
								}
							}
							pushPacketStatusHistoryDao.updateObject(packetStatusHistory);
						}
					}
					
					// Case-2
					// Resolved Post invoice cases.
					SaleOrder saleOrder = saleOrderDao.getObjectById(packetStatusHistory.getKey_s(), SaleOrder.class);
					logger.info(PushPacketStatusHistory.class, "Resolved Duplicate SerialNumber -->"+packetStatusHistory.getKey_s());
					if(packetStatusHistory != null && saleOrder != null && saleOrder.getCurrentStatus().getKey_s().equals("116")) {
						Map<String, BFILPacketsHistory> bfilPacketHistory = packetStatusHistory.getBfilPacketsHistory();
						if(bfilPacketHistory != null && !bfilPacketHistory.isEmpty()) {
							BFILPacketsHistory invoice = bfilPacketHistory.get("INVOICE");
							BFILPacketsHistory invoiceUpdate = bfilPacketHistory.get("INVOICE_UPDATE");
							if(invoice != null && !invoice.isStatusPushed()
									&& invoiceUpdate != null && !invoiceUpdate.isStatusPushed() ) {
								invoice.setVendorId(invoiceUpdate.getVendorId());
								invoice.setStatus("Invoice");
								invoice.setTeleCallStatus(invoiceUpdate.getTeleCallStatus());
								invoice.setMemberInterest(invoiceUpdate.getMemberInterest());
								invoice.setDisPatchDate(invoiceUpdate.getDisPatchDate());
								invoice.setInvoiceDate(invoiceUpdate.getInvoiceDate());
								invoice.setInvoiceNumber(invoiceUpdate.getInvoiceNumber());
								invoice.setSerialNumber(invoiceUpdate.getSerialNumber());
								invoice.setCourierName(invoiceUpdate.getCourierName());
								invoice.setExpectedDateOfDelivery(invoiceUpdate.getExpectedDateOfDelivery());
								invoice.setStatusPushed(invoiceUpdate.isStatusPushed());
								invoice.setRalStatusPushed(invoiceUpdate.isRalStatusPushed());
							}else {
								continue;
							}
							//update invoiceUpdate history false
							invoiceUpdate.setStatusPushed(true);
							
							//Change Invoice date, delivery date expected delivery date.
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
							Date invoiceDate = formatter.parse(invoice.getInvoiceDate());
							
							for(Entry<String, BFILPacketsHistory> entry : bfilPacketHistory.entrySet()) {
								try {
									BFILPacketsHistory bfilPk = entry.getValue();
									if(bfilPk != null && !bfilPk.isStatusPushed() && "Out for delivery".equals(bfilPk.getStatus())) {
										Date dispatchDate = formatter.parse(bfilPk.getDisPatchDate());
										if(invoiceDate.compareTo(dispatchDate) > 0) {
											bfilPk.setDisPatchDate(invoice.getInvoiceDate());
										}
										Date pkInvoiceDate = formatter.parse(bfilPk.getInvoiceDate());
										if(invoiceDate.compareTo(pkInvoiceDate) > 0) {
											bfilPk.setInvoiceDate(invoice.getInvoiceDate());
										}
										Date expectedDeliveryDate = formatter.parse(bfilPk.getExpectedDateOfDelivery());
										if(invoiceDate.compareTo(expectedDeliveryDate) > 0) {
											bfilPk.setExpectedDateOfDelivery(invoice.getInvoiceDate());
										}
									}else if(bfilPk != null && !bfilPk.isStatusPushed() && "Delivery".equals(bfilPk.getStatus()) 
											&& bfilPk.getDeliveryStatus().contains("Not Delivered")) {
										Date dispatchDate = formatter.parse(bfilPk.getDisPatchDate());
										if(invoiceDate.compareTo(dispatchDate) > 0) {
											bfilPk.setDisPatchDate(invoice.getInvoiceDate());
										}
										Date pkInvoiceDate = formatter.parse(bfilPk.getInvoiceDate());
										if(invoiceDate.compareTo(pkInvoiceDate) > 0) {
											bfilPk.setInvoiceDate(invoice.getInvoiceDate());
										}
										Date expectedDeliveryDate = formatter.parse(bfilPk.getExpectedDateOfDelivery());
										if(invoiceDate.compareTo(expectedDeliveryDate) > 0) {
											bfilPk.setExpectedDateOfDelivery(invoice.getInvoiceDate());
										}
									}else if(bfilPk != null && !bfilPk.isStatusPushed() && "Delivery".equals(bfilPk.getStatus()) 
											&& "Delivered".equals(bfilPk.getDeliveryStatus())) {
										Date dispatchDate = formatter.parse(bfilPk.getDisPatchDate());
										if(invoiceDate.compareTo(dispatchDate) > 0) {
											bfilPk.setDisPatchDate(invoice.getInvoiceDate());
										}
										Date pkInvoiceDate = formatter.parse(bfilPk.getInvoiceDate());
										if(invoiceDate.compareTo(pkInvoiceDate) > 0) {
											bfilPk.setInvoiceDate(invoice.getInvoiceDate());
										}
										Date expectedDeliveryDate = formatter.parse(bfilPk.getExpectedDateOfDelivery());
										if(invoiceDate.compareTo(expectedDeliveryDate) > 0) {
											bfilPk.setExpectedDateOfDelivery(invoice.getInvoiceDate());
										}
										Date deliveryDate = formatter.parse(bfilPk.getDeliveryDate());
										if(invoiceDate.compareTo(deliveryDate) > 0) {
											bfilPk.setDeliveryDate(invoice.getInvoiceDate());
										}
									}
								
								}catch(Exception e) {
									e.printStackTrace();
								}
							}
							
							pushPacketStatusHistoryDao.updateObject(packetStatusHistory);
						}
					}
				
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			//Case-4
			// Check pod Not pushed.
			query = new Query();
			query.addCriteria(Criteria.where("pendingPushStatus_b").is(false)
					.and("clientKey_s").is("RAL")
					.and("podPushed").is(false)
					.and("createdDate_l").gte(new Long("1577817000000")));
			awbNos = pushPacketStatusHistoryDao.getObjectsIdList(query, PushPacketStatusHistory.class);
			for(String awb : awbNos) {
				SaleOrder saleOrder = saleOrderDao.getObjectById(awb, SaleOrder.class);
				if(saleOrder != null && saleOrder.getCurrentStatus().getKey_s().equals("116")) {
					PushPacketStatusHistory packetStatusHistory = pushPacketStatusHistoryDao.getObjectById(awb, PushPacketStatusHistory.class);
					packetStatusHistory.setPendingPushStatus_b(true);
					pushPacketStatusHistoryDao.updateObject(packetStatusHistory);
				}
			}
			
			logger.info(PushPacketStatusHistory.class, "Resolved Duplicate SerialNumber ----> Compleated");
			responseBean.setStatus(ResponseStatus.SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.FAIL);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/api/reslovedRalDuplicateSerialNumber",method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean reslovedRalDuplicateSerialNumber(@RequestParam("key") String key,HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		try {
			Map<String,Object> result = new HashMap<String, Object>();
			VendorApiBean vendorApiBean = vendorApiDao.getObjectById("BFIL_STATUS_PUSH", VendorApiBean.class);
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Calendar calendar = Calendar.getInstance();
			
			BFILPushStatusApiHelperImpl bfilStatusApiHelper = new BFILPushStatusApiHelperImpl();
			PushStatusApiHelper pushStatusApiHelper = null;
			try {
				if(vendorApiBean.getImplclass_s().equals("bfilPushStatusApiHelperImpl")) {
					pushStatusApiHelper = bfilPushStatusApiHelper;
				} else {
					pushStatusApiHelper = applicationContext.getBean(vendorApiBean.getImplclass_s(), PushStatusApiHelper.class);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for(String awb : key.split(",")) {
				try {

					SaleOrder saleOrder = saleOrderDao.getObjectById(awb.trim(), SaleOrder.class);
					PushPacketStatusHistory pushPacketStatusHistory = pushPacketStatusHistoryDao.getObjectById(awb.trim(),PushPacketStatusHistory.class);
					if(pushPacketStatusHistory != null && pushPacketStatusHistory.getBfilPacketsHistory() != null && !pushPacketStatusHistory.getBfilPacketsHistory().isEmpty()) {
						BFILPacketsHistory bfilPacketsHistory = null; 
						if(!pushPacketStatusHistory.getBfilPacketsHistory().containsKey("INVOICE")) {
							continue;
						}
						if(pushPacketStatusHistory.getBfilPacketsHistory().containsKey("INVOICE_UPDATE")) {
							bfilPacketsHistory = pushPacketStatusHistory.getBfilPacketsHistory().get("INVOICE_UPDATE");
							if(!bfilPacketsHistory.isStatusPushed()) {
								continue;
							}
						}
						
						BFILPacketsHistory lastPendingToPush = null;
						for(BFILPacketsHistory bflPK: pushPacketStatusHistory.getBfilPacketsHistory().values()) {
							if(bflPK != null && !bflPK.isStatusPushed()) {
								lastPendingToPush = bflPK; 
								break;
							}
						}
						
						BFILPacketsHistory bfilPacketsHistory2 = new BFILPacketsHistory();
						bfilPacketsHistory2.setTeleCallStatus(GlobalConstant.SUCCESSFUL);
						bfilPacketsHistory2.setMemberInterest("Yes");
						
						Date invoiceDate = null;
						if(lastPendingToPush != null && lastPendingToPush.getInvoiceDate() != null && !"".equals(lastPendingToPush.getInvoiceNumber().trim())) {
							invoiceDate = CommonUtility.convertDDMMYYYYToDate(lastPendingToPush.getInvoiceDate());
						}
						if(invoiceDate == null) {
							PacketsHistory lastPK = CommonUtility.getPacketHistoryLastStatus(saleOrder);
							invoiceDate = CommonUtility.convertStringYYYYMMDDHHSSToDate(lastPK.getDate());
						}
						calendar.setTime(invoiceDate);
						bfilPacketsHistory2.setInvoiceDate(dateFormat.format(invoiceDate));
						bfilPacketsHistory2.setDisPatchDate(dateFormat.format(invoiceDate));
						
						calendar.add(Calendar.DAY_OF_MONTH, 7);
						String expectedDate = dateFormat.format(calendar.getTime());
						
						
						bfilPacketsHistory2.setExpectedDateOfDelivery(expectedDate);
						bfilPacketsHistory2.setInvoiceNumber(saleOrder.getSaleOrderNumber_s());
						bfilPacketsHistory2.setCourierName("bookMyPacket");
						bfilPacketsHistory2.setSerialNumber(saleOrder.getClientManifest());
						bfilPacketsHistory2.setVendorId(messageSource.getMessage(GlobalConstant.VENDOR_CODE, null,null));
						bfilPacketsHistory2.setStatus(GlobalConstant.INVOICE_UPDATE);
						
						SaleOrderExtra orderExtra = saleOrderExtraDao.getObjectById(saleOrder.getKey_s(), SaleOrderExtra.class);
						
						HttpRequestBeanNew httpRequestBean = bfilStatusApiHelper.getStatusPushApiRequestBean(vendorApiBean, bfilPacketsHistory2, saleOrder, orderExtra);
						Map<String, StringBuffer> requestResponse = new HttpUtilittyNew().call(httpRequestBean);
						//parseStatusPushApiResponseBean
						HttpResponseBean httpResponseBean = bfilStatusApiHelper.parseStatusPushApiResponseBean(requestResponse,vendorApiBean, bfilPacketsHistory2, saleOrder);
						postResponseHandlerRAL(requestResponse, httpResponseBean, pushPacketStatusHistory);
						
						result.put(awb, httpResponseBean.getStatus() +":"+httpResponseBean.getStatusMessage());
						
					}
				
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	private boolean postResponseHandlerRAL(Map<String, StringBuffer> requestResponse, HttpResponseBean httpResponseBean, PushPacketStatusHistory pushPacketStatusHistory) {
		boolean flag = false;
		try {
			//If Success remove from order ready to push bucket Add success log 
			String clientKey = "BFIL_IMEI_FLUSH";
			if (httpResponseBean.getStatus().equals(ResponseStatus.SUCCESS)) {
				// add vendor success log 
				StatusPushSuccessLogs statusPushSuccessLogs = new StatusPushSuccessLogs();
				statusPushSuccessLogs.setAwbNumber(pushPacketStatusHistory.getKey_s());
				statusPushSuccessLogs.setAwbNumber_s(pushPacketStatusHistory.getKey_s());
				statusPushSuccessLogs.setLogTypes(LogTypes.STATUS_PUSH);
				statusPushSuccessLogs.setSubLogType(clientKey);
				statusPushSuccessLogs
						.setSuccessMsg(httpResponseBean.getStatusLine() != null ? httpResponseBean.getStatusLine()
								: "Status :" + httpResponseBean.getStatus().toString());
				statusPushSuccessLogs.setResponseDetails(
						requestResponse.get("response") != null ? "" + requestResponse.get("response")
								: "something went wrong");
				statusPushSuccessLogs
						.setRequestDetails(requestResponse.get("request") != null ? "" + requestResponse.get("request")
								: "something went wrong");

				statusPushSuccessLogsDao.saveObject(statusPushSuccessLogs, StatusPushSuccessLogs.class);
				flag = true;

			} else {
				// add vendor error log 
				StatusPushErrorLogs statusPushErrorLogs = new StatusPushErrorLogs();
				statusPushErrorLogs.setAwbNumber(pushPacketStatusHistory.getKey_s());
				statusPushErrorLogs.setAwbNumber_s(pushPacketStatusHistory.getKey_s());
				statusPushErrorLogs.setLogTypes(LogTypes.STATUS_PUSH);
				statusPushErrorLogs.setSubLogType(clientKey);
				statusPushErrorLogs.setErrorMsg(httpResponseBean.getStatusLine());
				statusPushErrorLogs
						.setRequestDetails(requestResponse.get("request") != null ? "" + requestResponse.get("request")
								: "something went wrong");
				statusPushErrorLogs.setResponseDetails(
						requestResponse.get("response") != null ? "" + requestResponse.get("response")
								: "something went wrong");
				statusPushErrorLogs.setErrorMsgDetails("" + httpResponseBean.getStatusMessage());
				statusPushErrorLogsDao.saveObject(statusPushErrorLogs, StatusPushErrorLogs.class);
				flag = false;
			}
			System.out.println("Response ==> " + httpResponseBean.getStatusMessage());
			System.out.println("==================================Response ENDS=================");
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	
	@RequestMapping(value = "/api/ReStoreCourierUnUsedSeries/{courierKey}/{dateValue}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean reStoreCourierUnUsedSeries(@PathVariable("courierKey") String courierKey,@PathVariable("dateValue") Integer dateValue,
			HttpServletRequest request, HttpServletResponse response) {
		return testService.reStoreCourierUnUsedSeries(courierKey, dateValue);
	}
	
	@RequestMapping(value = "/api/updateOutooingCallLog",method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updateOutooingCallLog() {
		ResponseBean responseBean = new ResponseBean();
		try {
			List<String> keys = outgoingCallLogsDao.getKeys(new Query(), OutgoingCallLogs.class);
			logger.info(OutgoingCallLogs.class, "---> Total Keys="+keys.size());
			int cout = 1;
			for(String id : keys) {
				OutgoingCallLogs callLogs = outgoingCallLogsDao.getObjectById(id, OutgoingCallLogs.class);
				if(callLogs != null && callLogs.getAwbNumber() != null && !"".equals(callLogs.getAwbNumber().trim())) {
					SaleOrder saleOrder = saleOrderDao.getObjectById(callLogs.getAwbNumber(), SaleOrder.class);
					if(saleOrder != null) {
						callLogs.setClientKey(saleOrder.getClientKey_s());
						outgoingCallLogsDao.updateObject(callLogs);
						logger.info(OutgoingCallLogs.class, "----> Object updation count --> "+cout+"/"+keys.size());
						cout++;
					}
				}
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setMessage(e.getMessage());
		}
		return responseBean;
	}
	
	
	@RequestMapping(value = "/api/updateSaleOrderDetails/{filePath}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updateSaleOrderDetails(@PathVariable("filePath") String filePath) {
		ResponseBean responseBean = new ResponseBean();
		try {
			List<String> list = TestServiceImpl.readFile("/home/rajan/"+filePath+".txt");
			int counter =0;
			for(String str : list) {
				String strArr[] = str.split("###");
				SaleOrder saleOrder = saleOrderDao.getObjectById(strArr[0], SaleOrder.class);
				Long longDate = CommonUtility.convertYYYYMMDDHHMMSSToLongDate(strArr[1]);
				if(saleOrder != null && longDate != null) {
					String date = CommonUtility.convertLongDateToYYYYMMDDHHMMSS(longDate);
					saleOrder.setSaleOrderDate(date);
					saleOrder.setCreatedDate_l(longDate);
					saleOrder.setModifiedDate_l(longDate);
					
					PacketsHistory lastPK = CommonUtility.getPacketHistoryLastStatus(saleOrder);
					if(lastPK != null) {
						lastPK.setCreatedDate(longDate);
						lastPK.setDate(date);
					}
					saleOrderDao.updateObject(saleOrder);
					
					SaleOrderExtra orderExtra = saleOrderExtraDao.getObjectById(saleOrder.getKey_s(), SaleOrderExtra.class);
					if(orderExtra != null) {
						orderExtra.setCreatedDate_l(longDate);
						orderExtra.setModifiedDate_l(longDate);
					}
					System.out.println("Progress ---> "+counter+++"/"+list.size());
				}
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setMessage(e.getMessage());
		}
		return responseBean;
	}
	
	
	@RequestMapping(value = "/api/updatePendingAlert",method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updatePendingAlert() {
		ResponseBean responseBean = new ResponseBean();
		try {
			List<String> list = TestServiceImpl.readFile("/home/rajan/patch/pendingsms.txt");
			int counter =0;
			for(String str : list) {
				SmsMailMaster smsMailMaster =  smsMailMasterDao.getObjectById(str, SmsMailMaster.class);
				smsMailMaster.setAlertStatus_s(AlertStatus.SEND);
				smsMailMasterDao.remove(smsMailMaster.getKey_s(), SmsMailMaster.class);
				System.out.println("Progress ---> "+counter+++"/"+list.size());
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setMessage(e.getMessage());
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/api/updateAllOpenPacketStatusAsRtoDelivered", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updateAllOpenPacketStatusAsRtoDelivered(@RequestParam(value = "awbNumber", required = false) String awbNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return testService.updateAllOpenPacketStatusAsRtoDelivered(awbNumber);
	}
	
	@RequestMapping(value = "/api/updatePushPacketStatusHistory", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updatePushPacketStatusHistory(@RequestParam(value = "awbNumber", required = false) String awbNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return testService.updatePushPacketStatusHistory(awbNumber);
	}
	
	@RequestMapping(value = "/api/testApi",method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean testApi() {
		return testService.testApi();
	}
	
	@RequestMapping(value = "/api/updateRtoDate", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean updateRtoDate () {
        return testService.updateRtoDate();
    }

    @RequestMapping(value = "/api/testWooCommApi",method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean testWooCommApi() throws Exception {
        return testService.testWooCommApi();
    }
    @RequestMapping(value = "/api/testWooCommApi/raiseRefund",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean testWooCommApiRaiseRefund(@RequestParam Map<String,Object> payload) throws Exception {

        String refundReason = payload.get("refund_reason").toString();
        Double refundAmount = (Double) payload.get("refund_amount");
        List<Map<String, Object>> lineItems = (List<Map<String, Object>>) payload.get("list_items");
        return testService.testWooCommApi();
    }
	
}
