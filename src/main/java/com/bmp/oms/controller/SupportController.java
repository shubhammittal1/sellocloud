package com.bmp.oms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.saleorder.CleanUpBean;
import com.bmp.bean.saleorder.UpdatePacketHistory;
import com.bmp.constant.CachebleGroups;
import com.bmp.constant.ResponseStatus;
import com.bmp.model.app.api.VendorErrorLogs;
import com.bmp.model.app.api.VendorSuccessLogs;
import com.bmp.model.app.client.ClientAccountLog;
import com.bmp.model.app.client.GatewayLog;
import com.bmp.model.app.saleorder.AlertErrorLogs;
import com.bmp.model.app.saleorder.AlertSuccessLogs;
import com.bmp.model.app.saleorder.OrderPushErrorLogs;
import com.bmp.model.app.saleorder.OrderPushSuccessLogs;
import com.bmp.model.app.saleorder.PacketsHistory;
import com.bmp.model.app.saleorder.StatusPushErrorLogs;
import com.bmp.model.app.saleorder.StatusPushSuccessLogs;
import com.bmp.oms.service.api.vendorOrder.VendorErrorLogsApiService;
import com.bmp.oms.service.api.vendorOrder.VendorOrderPushApiService;
import com.bmp.oms.service.api.vendorOrder.VendorSuccessLogsApiService;
import com.bmp.oms.service.c2c.impl.WebUserAccountLogServiceImpl;
import com.bmp.oms.service.changeStatus.ChangeStatus;
import com.bmp.oms.service.client.ClientAccountLogService;
import com.bmp.oms.service.client.ClientAccountService;
import com.bmp.oms.service.console.CachebleGroupService;
import com.bmp.oms.service.drs.DrsService;
import com.bmp.oms.service.facility.AlertErrorLogsService;
import com.bmp.oms.service.facility.AlertSuccessLogsService;
import com.bmp.oms.service.facility.UserService;
import com.bmp.oms.service.gateway.GatewayLogService;
import com.bmp.oms.service.masters.AWBSeriesService;
import com.bmp.oms.service.saleorder.OrderPushErrorLogsService;
import com.bmp.oms.service.saleorder.OrderPushSuccessLogsService;
import com.bmp.oms.service.saleorder.SaleOrderExtraService;
import com.bmp.oms.service.saleorder.SaleOrderPickupRequestService;
import com.bmp.oms.service.saleorder.SaleOrderService;
import com.bmp.oms.service.status.StatusPushErrorLogsService;
import com.bmp.oms.service.status.StatusPushSuccessLogsService;

@Controller
@RequestMapping("/support")
public class SupportController {

	@Autowired
	@Qualifier("saleOrderServiceImpl")
	private SaleOrderService saleOrderService;
	
	@Autowired
	@Qualifier("cachebleGroupServiceImpl")
	private CachebleGroupService cachebleGroupService;
	
	@Autowired
	@Qualifier("vendorSuccessLogsApiServiceImpl")
	private VendorSuccessLogsApiService vendorSuccessLogsApiService;
	
	@Autowired
	@Qualifier("vendorErrorLogsApiServiceImpl")
	private VendorErrorLogsApiService vendorErrorLogsApiService;
	
	@Autowired
	@Qualifier("orderPushSuccessLogsServiceImpl")
	private OrderPushSuccessLogsService orderPushSuccessLogsService;
	
	@Autowired
	@Qualifier("orderPushErrorLogsServiceImpl")
	private OrderPushErrorLogsService orderPushErrorLogsService;
	
	@Autowired
	@Qualifier("statusPushErrorLogsServiceImpl")
	private StatusPushErrorLogsService statusPushErrorLogsService;
	
	@Autowired
	@Qualifier("statusPushSuccessLogsServiceImpl")
	private StatusPushSuccessLogsService statusPushSuccessLogsService;
	
	@Autowired
	@Qualifier("alertErrorLogsServiceImpl")
	private AlertErrorLogsService alertErrorLogsService;
	
	@Autowired
	@Qualifier("alertSuccessLogsServiceImpl")
	private AlertSuccessLogsService alertSuccessLogsService;
	
	@Autowired
	@Qualifier("clientAccountLogServiceImpl")
	private ClientAccountLogService clientAccountLogService;
	
	@Autowired
	@Qualifier("clientAccountServiceImpl")
	private ClientAccountService clientAccountService;
	
	@Autowired
	@Qualifier("awbSeriesServiceImp")
	private AWBSeriesService awbSeriesService;
	
	@Autowired
	@Qualifier("gatewayLogServiceImpl")
	private GatewayLogService gatewayLogService;
	
	@Autowired
	@Qualifier("webUserAccountLogServiceImpl")
	private WebUserAccountLogServiceImpl webUserAccountLogService;
	
	@Autowired
	@Qualifier("drsServiceImpl")
	private DrsService drsService;
	
    @Autowired
	@Qualifier("changeStatusImpl")
	private ChangeStatus changeStatus;
	
	@Autowired
	@Qualifier("saleOrderExtraServiceImpl")
	private SaleOrderExtraService saleOrderExtraService;
	
	@Autowired
	@Qualifier("saleOrderPickupRequestService")
	private SaleOrderPickupRequestService saleOrderPickupRequestService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("vendorOrderPushApiServiceImpl")
	private VendorOrderPushApiService vendorOrderPushApiService;
	
	@RequestMapping(value = "/getEditPacketHistory", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getEditPacketHistory(@RequestParam(value = "key") String awb,
			@RequestBody Map<String, PacketsHistory> packetHistory, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getEditPacketHistory(awb, packetHistory);
	}

	@RequestMapping(value = "/getPacketHistory", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getPacketHistory(@RequestParam(value = "key") String awb, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getPacketHistory(awb);
	}

	@RequestMapping(value = "/getDeclaredFields", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getDeclaredFields(@RequestParam(value = "key") String classType, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getDeclaredFields(classType);
	}

	@RequestMapping(value = "/refreshIndex", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean refreshIndex(@RequestBody CleanUpBean cleanUpBean, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.refreshIndex(cleanUpBean.getClassType(), cleanUpBean.getKeys());
	}

	@RequestMapping(value = "/updateSaleOrderBagManifestDrsFields", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateSaleOrderBagManifestDrsFields(@RequestBody CleanUpBean cleanUpBean,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.updateSaleOrderBagManifestDrsFields(cleanUpBean.getClassType(),
				cleanUpBean.getFieldName(), cleanUpBean.getValue(), cleanUpBean.getKeys());
	}

	@RequestMapping(value = "/deleteSaleOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean deleteSaleOrder(@RequestBody CleanUpBean cleanUpBean, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.deleteSaleOrder(cleanUpBean.getClassType(), cleanUpBean.getKeys(),request.getRemoteAddr());
	}

	@RequestMapping(value = "/rollBackDeletedSaleOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean rollBackDeletedSaleOrder(@RequestBody CleanUpBean cleanUpBean, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.rollBackDeletedSaleOrder(cleanUpBean.getClassType(), cleanUpBean.getKeys());
	}
	
	@RequestMapping(value = "/evictAllCacheble", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean evictAllCacheble(HttpServletRequest request, HttpServletResponse response) {
		return cachebleGroupService.evictAllCacheble();
	}
	
	@RequestMapping(value = "/evictCachebleGroup", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean evictCachebleGroup(@RequestParam(required=true, value="cachebleGroup") CachebleGroups cachebleGroup, HttpServletRequest request, HttpServletResponse response) {
		return cachebleGroupService.evictCachebleGroup(cachebleGroup);
	}
	
	@RequestMapping(value = "/getCachebleGorups", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getCachebleGorups(HttpServletRequest request, HttpServletResponse response) {
		return cachebleGroupService.getCachebleGorups();
	}
	
	@RequestMapping(value = "/deleteHistoryRow/{id}/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteHistoryRow(@PathVariable("key") String key,@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.deleteHistoryRow(key,id);
    }
	
	@RequestMapping(value = "/updatePacketHistoryByRow", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPage(@RequestBody UpdatePacketHistory packet, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.updatePacketHistoryByKeyRow(packet);
    }
	
	@RequestMapping(value = "/loadLogTypes", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadLogTypes( HttpServletRequest request, HttpServletResponse response) {
		return vendorSuccessLogsApiService.loadLogTypes();
    }
	
	@RequestMapping(value = "/getAllVendorSuccessLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllVendorSuccessLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorSuccessLogsApiService.getAllVendorSuccessLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addVendorSuccessLog", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addVendorSuccessLog(@RequestBody VendorSuccessLogs vendorSuccessLogs, HttpServletRequest request, HttpServletResponse response) {
		return vendorSuccessLogsApiService.addVendorSuccessLogs(vendorSuccessLogs);
    }
	
	@RequestMapping(value = "/deleteVendorSuccessLogs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteVendorSuccessLogs(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return vendorSuccessLogsApiService.deleteVendorSuccessLogs(key);
    }
	
	@RequestMapping(value = "/getAllVendorErrorLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllVendorErrorLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorErrorLogsApiService.getAllVendorErrorLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addVendorErrorLog", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addVendorErrorLog(@RequestBody VendorErrorLogs vendorErrorLogs, HttpServletRequest request, HttpServletResponse response) {
		return vendorErrorLogsApiService.addVendorErrorLogs(vendorErrorLogs);
    }
	
	@RequestMapping(value = "/deleteVendorErrorLogs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteVendorErrorLogs(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return vendorErrorLogsApiService.deleteVendorErrorLogs(key);
    }
	
	@RequestMapping(value = "changeDestinationPincode", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean changeDestinationPincode(@RequestParam(value="awb") String awb,@RequestParam(value="pincode") String pincode, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.changePincode(awb, pincode);
    }
	
	@RequestMapping(value = "payModeChange", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean payModeChange(@RequestParam(value="awb") String awb,@RequestParam(value="payMode") String payMode,@RequestParam(value="collectibleamount") Double collectibleamount, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.payModeChange(awb, payMode,collectibleamount);
    }
	
	@RequestMapping(value = "/verifyPaymentRecivedManual", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean verifyPaymentRecivedManual(@RequestBody List<String> awbNumbers, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.verifyPaymentRecivedManual(awbNumbers);
    }
	
	@RequestMapping(value = "/closeRemitanceManual", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean closeRemitanceManual(@RequestBody List<String> awbNumbers, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.closeRemitanceManual(awbNumbers);
    }
	
	@RequestMapping(value = "/getAllOrderPushSuccessLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllOrderPushSuccessLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return orderPushSuccessLogsService.getAllOrderPushSuccessLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addOrderPushSuccessLog", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addOrderPushSuccessLog(@RequestBody OrderPushSuccessLogs orderPushSuccessLogs, HttpServletRequest request, HttpServletResponse response) {
		return orderPushSuccessLogsService.addOrderPushSuccessLogs(orderPushSuccessLogs);
    }
	
	@RequestMapping(value = "/deleteOrderPushSuccessLogs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteOrderPushSuccessLogs(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return orderPushSuccessLogsService.deleteOrderPushSuccessLogs(key);
		
	}
	
	@RequestMapping(value = "/getAllOrderPushErrorLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllOrderPushErrorLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return orderPushErrorLogsService.getAllOrderPushErrorLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addOrderPushErrorLog", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addVendorSuccessLog(@RequestBody OrderPushErrorLogs orderPushErrorLogs, HttpServletRequest request, HttpServletResponse response) {
		return orderPushErrorLogsService.addOrderPushErrorLogs(orderPushErrorLogs);
    }
	
	@RequestMapping(value = "/deleteOrderPushErrorLogs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteOrderPushErrorLogs(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return orderPushErrorLogsService.deleteOrderPushErrorLogs(key);
		
	}
	
	@RequestMapping(value = "/getAllStatusPushSuccessLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllStatusPushSuccessLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return statusPushSuccessLogsService.getAllStatusPushSuccessLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addStatusPushSuccessLogs", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addStatusPushSuccessLogs(@RequestBody StatusPushSuccessLogs statusPushSuccessLogs, HttpServletRequest request, HttpServletResponse response) {
		return statusPushSuccessLogsService.addStatusPushSuccessLogs(statusPushSuccessLogs);
    }
	
	@RequestMapping(value = "/deleteStatusPushSuccessLogs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteStatusPushSuccessLogs(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return statusPushSuccessLogsService.deleteStatusPushSuccessLogs(key);
		
	}
	
	@RequestMapping(value = "/getAllStatusPushErrorLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllStatusPushErrorLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return statusPushErrorLogsService.getAllStatusPushErrorLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addStatusPushErrorLogs", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addStatusPushErrorLogs(@RequestBody StatusPushErrorLogs statusPushErrorLogs, HttpServletRequest request, HttpServletResponse response) {
		return statusPushErrorLogsService.addStatusPushErrorLogs(statusPushErrorLogs);
    }
	
	@RequestMapping(value = "/deleteStatusPushErrorLogs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteStatusPushErrorLogs(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return statusPushErrorLogsService.deleteStatusPushErrorLogs(key);
		
	}
	
	@RequestMapping(value = "/getAllAlertSuccessLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllAlertSuccessLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return alertSuccessLogsService.getAllAlertSuccessLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addAlertSuccessLogs", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addAlertSuccessLogs(@RequestBody AlertSuccessLogs alertSuccessLogs, HttpServletRequest request, HttpServletResponse response) {
		return alertSuccessLogsService.addAlertSuccessLogs(alertSuccessLogs);
    }
	
	@RequestMapping(value = "/deleteAlertSuccessLogs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteAlertSuccessLogs(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return alertSuccessLogsService.deleteAlertSuccessLogs(key);
		
	}
	
	@RequestMapping(value = "/getAllAlertErrorLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllAlertErrorLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return alertErrorLogsService.getAllAlertErrorLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addAlertErrorLogs", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addAlertErrorLogs(@RequestBody AlertErrorLogs alertErrorLogs, HttpServletRequest request, HttpServletResponse response) {
		return alertErrorLogsService.addAlertErrorLogs(alertErrorLogs);
    }
	
	@RequestMapping(value = "/deleteAlertErrorLogs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteAlertErrorLogs(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return alertErrorLogsService.deleteAlertErrorLogs(key);
		
	}
    
	@RequestMapping(value = "/getAllClientAccountLog", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllClientAccountLog(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return clientAccountLogService.getAllClientAccountLog(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getClientAccountLog", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getClientAccountLog(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return clientAccountLogService.getClientAccountLog(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getClientAccountOrderLog", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getClientAccountOrderLog(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return clientAccountLogService.getClientAccountOrderLog(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addClientAccountLog/{awb}", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addClientAccountLog(@PathVariable("awb") String key,@RequestBody ClientAccountLog vendorSuccessLogs, HttpServletRequest request, HttpServletResponse response) {
		return clientAccountLogService.addClientAccountLog(key,vendorSuccessLogs);
    }
	
	@RequestMapping(value = "/deleteClientAccountLog/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientAccountLog(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientAccountLogService.deleteClientAccountLog(key);
    }
	
	@RequestMapping(value = "/loadPaymentSubType", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadPaymentSubType( HttpServletRequest request, HttpServletResponse response) {
		return clientAccountLogService.loadPaymentSubType();
    }
	
	@RequestMapping(value = "/loadPaymentMethod", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean LoadPaymentSubType( HttpServletRequest request, HttpServletResponse response) {
		return clientAccountLogService.loadPaymentMethod();
    }
	
	@RequestMapping(value = "/getAllGatewayLog", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllGatewayLog(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return gatewayLogService.getAllGatewayLog(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addGatewayLog", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addGatewayLog(@RequestBody GatewayLog gatewayLog, HttpServletRequest request, HttpServletResponse response) {
		return gatewayLogService.addGatewayLog(gatewayLog);
    }
	
	@RequestMapping(value = "/deleteGatewayLog/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteGatewayLog(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return gatewayLogService.deleteGatewayLog(key);
    }
	
	@RequestMapping(value = "/getAllClientAccount", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllClientAccount(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return clientAccountService.getAllClientAccount(datatableRequestBean);
	}
	
	@RequestMapping(value = "/updateHandOver", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean updateHandOver(@RequestParam(value="awb")String awb, @RequestParam(value="type")Boolean type,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderService.updateHandOver(awb,type);
	}
	
	@RequestMapping(value = "/addClientAwbSeries", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean addClientAwbSeries(@RequestBody Map<String,Object> seriesMap,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return awbSeriesService.addClientAwbSeriesByUi(seriesMap);
	}
	
	@RequestMapping(value = "/getAllWebUserAccountLog", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllWebUserAccountLog(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return webUserAccountLogService.getAllWebUserAccountLog(datatableRequestBean);
	}
	
	@RequestMapping(value = "/deleteWebUserAccountLog/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteWebUserAccountLog(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return webUserAccountLogService.deleteWebUserAccountLog(key);
    }
	
	@RequestMapping(value = "/updateDrsFeName", method = RequestMethod.POST)
	  @ResponseBody
	public  ResponseBean updateDrsFeName(@RequestParam(value="DRS_ID")String DRS_ID, @RequestParam(value="FE_ID")String FE_ID,@RequestParam(value="Type")String Type ,HttpServletRequest request,HttpServletResponse response) throws Exception {
	return drsService.updateDrsFeName(DRS_ID,FE_ID,Type);
	}

	@RequestMapping(value = "/getFeListByDrs", method = RequestMethod.POST)
	  @ResponseBody
	public  ResponseBean getFeListByDrs(@RequestParam(value="DRS_ID")String DRS_ID,@RequestParam(value="Type")String Type, HttpServletRequest request,HttpServletResponse response) throws Exception {
	return drsService.getFeListByDrs(DRS_ID,Type);
	}
	
	@RequestMapping(value = "/updateRescheduleDate", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean updateRescheduleDate(@RequestBody Map<String,String> map, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderExtraService.updateRescheduleDate(map.get("awb"), map.get("date"));
	}
	
	@RequestMapping(value = "/updateRejectedShipment", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean updateRejectedShipment(@RequestParam(value="awb")String awbNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderExtraService.updateRejectedShipment(awbNumber);
	}
	
	@RequestMapping(value = "/reloadStatusFlow", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean reloadStatusFlow(String key, HttpServletRequest request, HttpServletResponse response) {
		changeStatus.setStatusFlowMap();
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(ResponseStatus.SUCCESS);
		return responseBean;
    }
	
	@RequestMapping(value = "/deleteLastStatus", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteLastStatus(@RequestParam(value="awb")String awb, @RequestParam(value="statusId")String statusId, HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean  = saleOrderService.deleteLastStatus(awb,statusId);
		return responseBean;
    }
	
	@RequestMapping(value = "/closedPickupRequest", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteLastStatus(@RequestParam(value="key")String key, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.closedPickupRequest(key);
    }
	
	@RequestMapping(value = "/downloadShipmentPod", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean downloadShipmentPod(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderExtraService.downloadShipmentPod(datatableRequestBean);
	}
	
	@RequestMapping(value = "/deletePushShipment", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean deletePushShipment(@RequestBody String awbNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorOrderPushApiService.deletePushShipment(awbNumber);
	}
	
	@RequestMapping(value = "/paymentStatusCheck", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean paymentStatusCheck(@RequestParam(value="paymentId")String paymentId,@RequestParam(value="amount")String amount, HttpServletRequest request, HttpServletResponse response) {
		return gatewayLogService.crossVerifyPaymentforEBSGateway(paymentId, new Double(amount));
    }
	
	@RequestMapping(value = "/getAllDataFetchErrorLogs", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllDataFetchErrorLogs(@RequestBody  DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return orderPushErrorLogsService.getAllDataFetchErrorLogs(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllPODMismatchErrorLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllPODMismatchErrorLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return statusPushErrorLogsService.getAllPODMismatchErrorLogs(datatableRequestBean);
	}
	
	/*@RequestMapping(value = "/updatePodMismatchLogs", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updatePodMismatchLogs(@RequestBody SaleOrderExtra saleOrderExtra, HttpServletRequest request, HttpServletResponse response) {
		return statusPushErrorLogsService.updatePodMismatchLogs(saleOrderExtra);
    }*/

	/*@RequestMapping(value = "/updatePodMismatchLogs", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updatePodMismatchLogs(@RequestBody SaleOrderExtra saleOrderExtra, MultipartHttpServletRequest request, HttpServletResponse response) {
		
		return statusPushErrorLogsService.updatePodMismatchLogs(saleOrderExtra);
    }*/
	
	@RequestMapping(value = "/updatePodMismatchLogs", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updatePodMismatchLogs(MultipartHttpServletRequest request, HttpServletResponse response) {
		List<MultipartFile> fileList = request.getFiles("fileList");
		String podType = request.getParameter("podType");
		String podNumber = request.getParameter("podNumber");
		String awbNumber = request.getParameter("awbNumber");
		String logId = request.getParameter("logId");
		return statusPushErrorLogsService.updatePodMismatchLogs(fileList,podType, podNumber, awbNumber, logId);
    }
	
	
	
	@RequestMapping(value = "/flushDeviceId/{userId}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean flushDeviceId(@PathVariable("userId") String userId, HttpServletRequest request, HttpServletResponse response) {
		return userService.flushDeviceId(userId);
    }
	
	@RequestMapping(value = "/getAllSearchedOrders", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllSearchedOrders(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllSearchedOrders(datatableRequestBean);
	}
	
	@RequestMapping(value = "/updateOrderPOD", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateOrderPOD(MultipartHttpServletRequest request, HttpServletResponse response) {
		List<MultipartFile> fileList = request.getFiles("fileList");
		List<MultipartFile> fileListSignature = request.getFiles("fileListSignature");
		String podType = request.getParameter("podType");
		String podNumber = request.getParameter("podNumber");
		String awbNumber = request.getParameter("awbNumber");
		String receiverRelation = request.getParameter("receiverRelation");
		String deliveredPresonName = request.getParameter("deliveredPresonName");
		String deliveredPresonMobileNo = request.getParameter("deliveredPresonMobileNo");
		String deliveryOtp = request.getParameter("deliveryOtp");
		return statusPushErrorLogsService.updateOrderPOD(fileList,fileListSignature, podType, podNumber, awbNumber,receiverRelation,deliveredPresonName, deliveredPresonMobileNo, deliveryOtp);
    }
	
}
