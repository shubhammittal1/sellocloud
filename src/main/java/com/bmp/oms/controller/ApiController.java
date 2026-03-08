package com.bmp.oms.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import com.bmp.oms.service.api.VendorApiService;
import com.bmp.oms.service.api.GovtApiService;
import com.bmp.oms.service.api.marketplace.MarketplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bmp.bean.ApiResponseBean;
import com.bmp.bean.ApiResponseC2CBean;
import com.bmp.bean.c2c.BookingRequestBean;
import com.bmp.bean.c2c.C2cBookingMailBean;
import com.bmp.bean.c2c.C2cPricingRequestBean;
import com.bmp.bean.c2c.ProductBean;
import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.drs.AppKmUpdateBean;
import com.bmp.bean.gateway.GatewayResponseBean;
import com.bmp.bean.saleorder.BflResponseBean;
import com.bmp.bean.saleorder.PrintLabel;
import com.bmp.bean.saleorder.RdspResponseBean;
import com.bmp.bean.trackStatus.TrackCurrentStatusBean;
import com.bmp.bean.user.PasswordActiveBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.bmpwims.SkuInventoryService;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.SettingsDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.model.app.api.VendorOrderReadyToPush;
import com.bmp.model.app.api.WarehousePendingPush;
import com.bmp.model.app.config.Settings;
import com.bmp.model.app.report.ReportQueue;
import com.bmp.model.app.saleorder.BfilDeliveryModelUpdate;
import com.bmp.model.app.saleorder.BfilOrder;
import com.bmp.model.app.saleorder.BfilOrderCancel;
import com.bmp.model.app.saleorder.RDSP;
import com.bmp.model.app.saleorder.BfilRdspProductMemberHandover;
import com.bmp.model.app.saleorder.BfilRdspProductReceived;
import com.bmp.model.app.saleorder.BfilReturnToVendor;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;
import com.bmp.model.c2c.Enquiry;
import com.bmp.model.c2c.WebUser;
import com.bmp.model.c2c.WebUserAddressList;
import com.bmp.oms.service.DbBackupService;
import com.bmp.oms.service.api.impl.RalOrderPushServiceImpl;
import com.bmp.oms.service.api.marketplace.AmazonService;
import com.bmp.oms.service.api.vendorOrder.VendorOrderPushApiService;
import com.bmp.oms.service.api.vendorOrder.VendorSuccessLogsApiService;
import com.bmp.oms.service.api.vendorOrder.WarehousePendingPushService;
import com.bmp.oms.service.c2c.C2cPricingService;
import com.bmp.oms.service.c2c.C2cReportService;
import com.bmp.oms.service.c2c.EnquiryService;
import com.bmp.oms.service.c2c.PacketService;
import com.bmp.oms.service.c2c.StandardParcelService;
import com.bmp.oms.service.c2c.WebUserService;
import com.bmp.oms.service.client.ClientDashboardService;
import com.bmp.oms.service.client.ClientSKUWeigthLookerService;
import com.bmp.oms.service.drs.BranchCashClosingService;
import com.bmp.oms.service.facility.AlertErrorLogsService;
import com.bmp.oms.service.facility.AlertMasterService;
import com.bmp.oms.service.facility.SmsMailMasterService;
import com.bmp.oms.service.facility.UserService;
import com.bmp.oms.service.manifest.ManifestService;
import com.bmp.oms.service.masters.CountryService;
import com.bmp.oms.service.masters.ServiceablePincodeService;
import com.bmp.oms.service.saleorder.BfilOrderService;
import com.bmp.oms.service.saleorder.BmpApiService;
import com.bmp.oms.service.saleorder.InscanService;
import com.bmp.oms.service.saleorder.PrintLabelService;
import com.bmp.oms.service.saleorder.RalInvoiceDetailsService;
import com.bmp.oms.service.saleorder.RdspService;
import com.bmp.oms.service.saleorder.ReportMasterService;
import com.bmp.oms.service.saleorder.ReportService;
import com.bmp.oms.service.saleorder.SaleOrderExtraService;
import com.bmp.oms.service.saleorder.SaleOrderPickupRequestService;
import com.bmp.oms.service.saleorder.SaleOrderService;
import com.bmp.oms.service.status.StatusMasterService;
import com.bmp.oms.service.statuspush.api.PushStatusToVendorService;
import com.bmp.oms.service.systemCalling.CallManifestService;
import com.bmp.oms.service.systemCalling.SendManualSmsService;
import com.bmp.utility.logger.AsyncLogger;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("vendorApiServiceImpl")
	private VendorApiService vendorApiService;

	@Autowired
	@Qualifier("govtApiServiceImpl")
	private GovtApiService govtApiService;

    @Autowired
    @Qualifier("amazonMarketplaceServiceImpl")
    private AmazonService amazonService;

	@Autowired
	@Qualifier("inscanServiceImpl")
	private InscanService inscanService;
	
	@Autowired
	@Qualifier("smsMailMasterServiceImpl")
	private SmsMailMasterService smsMailMasterService;
	
	@Autowired
	@Qualifier("reportServiceImpl")
	private ReportService reportService;
	
	@Autowired
	@Qualifier("reportMasterServiceImpl")
	private ReportMasterService reportMasterService;
	
	@Autowired
	@Qualifier("alertMasterServiceImpl")
	private AlertMasterService alertMasterService;
	
	@Autowired
	@Qualifier("saleOrderPickupRequestServiceImpl")
	private SaleOrderPickupRequestService saleOrderPickupRequestService;
	
	@Autowired
	@Qualifier("bmpApiServiceImpl")
	private BmpApiService bmpApiService;
	
	@Autowired
	@Qualifier("clientDashboardServiceImpl")
	private ClientDashboardService clientDashboardService;
	
	@Autowired
	@Qualifier("vendorOrderPushApiServiceImpl")
	private VendorOrderPushApiService vendorOrderPushApiService;
	
	@Autowired
	@Qualifier("vendorSuccessLogsApiServiceImpl")
	private VendorSuccessLogsApiService vendorSuccessLogsApiService;
	
	@Autowired
	@Qualifier("pushStatusToVendorServiceImpl")
	PushStatusToVendorService pushStatusToVendorService;
	
	@Autowired
	@Qualifier("clientSKUWeigthLookerServiceImpl")
	ClientSKUWeigthLookerService clientSKUWeigthLookerService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	UserService userService;
	
	@Autowired
	@Qualifier("serviceablePincodeServiceImpl")
	private ServiceablePincodeService serviceablePincodeService;
	
	@Autowired
	@Qualifier("webUserServiceImpl")
	private WebUserService webUserService;
	
	@Autowired
	@Qualifier("c2cPricingServiceImpl")
	private C2cPricingService c2cPricingService;
	
	@Autowired
	@Qualifier("packetServiceImpl")
	private PacketService  packetService;
	
	@Autowired
	@Qualifier("countryServiceImpl")
	private CountryService countryService;
	
	@Autowired
	@Qualifier("c2cReportServiceImpl")
	private C2cReportService c2cReportService;
	
	@Autowired
	@Qualifier("statusMasterServiceImpl")
	private StatusMasterService statusMasterService;

	@Autowired
	@Qualifier("standardParcelServiceImpl")
	private StandardParcelService standardParcelService;
	
	@Autowired
	@Qualifier("printLabelServiceImpl")
	private PrintLabelService printLabelService;
	
	@Autowired
	@Qualifier("enquiryServiceImpl")
	private EnquiryService enquiryService;
	
	@Autowired
	@Qualifier("callManifestServiceImpl")
	private CallManifestService callManifestService;
	
	@Autowired
	@Qualifier("settingsDaoImpl")
	private SettingsDao settingsDao;
	
	@Autowired
	@Qualifier("sendManualSmsServiceImpl")
	private SendManualSmsService sendManualSmsService;
	
	@Autowired
	@Qualifier("saleOrderServiceImpl")
	private SaleOrderService saleOrderService;
	
	@Autowired
	@Qualifier("ralOrderPushServiceImpl")
	private RalOrderPushServiceImpl ralOrderPushServiceImpl;
	
	@Autowired
	@Qualifier("dbBackupService")
	private DbBackupService dbBackupService;
	
	@Autowired
	@Qualifier("bfilOrderServiceImpl")
	private BfilOrderService bfilOrderService;
	
	@Autowired
	@Qualifier("saleOrderExtraServiceImpl")
	private SaleOrderExtraService saleOrderExtraService;
	
	@Autowired
	@Qualifier("rdspServiceImpl")
	private RdspService rdspService;
	
	@Autowired
	@Qualifier("alertErrorLogsServiceImpl")
	private AlertErrorLogsService alertErrorLogsService;

	@Autowired
	@Qualifier("manifestServiceImpl")
	private ManifestService manifestService;

	@Autowired
	@Qualifier("skuInventoryImpl")
	private SkuInventoryService skuInventory;
	
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired
	@Qualifier("branchCashClosingServiceImpl")
	private BranchCashClosingService branchCashClosingService;
	
	@Autowired
	@Qualifier("ralInvoiceDetailsServiceImpl")
	private RalInvoiceDetailsService ralInvoiceDetailsService;
	
	@Autowired
	@Qualifier("warehousePendingPushServiceImpl")
	private WarehousePendingPushService warehousePendingPushService;
	
	@Autowired
	@Qualifier("marketplaceServiceImpl")
	private MarketplaceService marketplaceService;


	@RequestMapping(value = "/getStatusUpdateApi", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getStatusUpdateApi(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.getVendorApiCall(null, null,null);
	}
	@RequestMapping(value = "/getStatusUpdateApiByCourierAwb", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getStatusUpdateApiByCourierAwb(@QueryParam(value = "courierAwb") String courierAwb, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.getVendorApiCall(null, null,courierAwb);
	}
	
	@RequestMapping(value = "/getStatusUpdateApi/{cycle}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getStatusUpdateApi(@PathVariable("cycle") String cycle, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.getVendorApiCall(cycle, null,null);
	}
	
	@RequestMapping(value = "/getStatusUpdateApi/{cycle}/{logisticId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getStatusUpdateApi(@PathVariable("cycle") String cycle, @PathVariable("logisticId") String logisticId, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.getVendorApiCall(cycle, logisticId,null);
	}
	
	@RequestMapping(value = "/vendorPushOrderApi", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean vendorPushOrderApi(@RequestParam(value="logisticId", required = false) String logisticId,
			@RequestParam(value="airWayBill", required = false) String airWayBill,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		//return vendorOrderPushApiService.pushVendorOrders(logisticId);
		return vendorOrderPushApiService.pushVendorOrders(logisticId, airWayBill);
	}
	
	@RequestMapping(value = "/getAllVendorOrderReadyToPush", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllVendorOrderReadyToPush(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorOrderPushApiService.getAllVendorOrderReadyToPush(datatableRequestBean);
	}
	
	@RequestMapping(value = "/addVendorOrderReadyToPush", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createBag(@RequestBody VendorOrderReadyToPush vendorOrderReadyToPush, HttpServletRequest request, HttpServletResponse response) {
		return vendorOrderPushApiService.addVendorOrderReadyToPush(vendorOrderReadyToPush);
    }
	
	@RequestMapping(value = "/pushStatusApiHistory", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean pushStatusApiHistory(HttpServletRequest request, HttpServletResponse response) {
		return bmpApiService.pushStatusApiHistory();
	}
	
	@RequestMapping("/pushStatusApiHistoryReconcile")
	public ModelAndView pushStatusApiHistoryReconcile() {
		ModelAndView mv = new ModelAndView("/pushStatusApiHistoryReconcile");
		mv.addObject("applicationContext", applicationContext);
		return mv;
	}
	
	@RequestMapping("/twoTreadOrderPunch")
	public ModelAndView twoTreadOrderPunch() {
		ModelAndView mv = new ModelAndView("/twoTreadOrderPunch");
		mv.addObject("applicationContext", applicationContext);
		return mv;
	}
	
	@RequestMapping("/twoTreadPushStatusApiHistory")
	public ModelAndView twoTreadPushStatusApiHistory() {
		ModelAndView mv = new ModelAndView("/twoTreadPushStatusApiHistory");
		mv.addObject("applicationContext", applicationContext);
		return mv;
	}
	
	@RequestMapping("/shipWayApi")
	public ModelAndView shipWayApi() {
		ModelAndView mv = new ModelAndView("/shipWayApi");
		mv.addObject("applicationContext", applicationContext);
		return mv;
	}
	
	@RequestMapping("/activatePassword")
	public ModelAndView activatePassword(@RequestParam(value = "key") String key) {
		ModelAndView mv = new ModelAndView("myAccount/activatePassword");
		mv.addObject("user", key);
		return mv;
	}
	
	@RequestMapping(value = "/update_sale_order_all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getUpdateSaleOrderAll(HttpServletRequest request, HttpServletResponse response) {
		return inscanService.getUpdateSaleOrderAll(null);
	}
	
	@RequestMapping(value = "/createExcelReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean createExcelReports(HttpServletRequest request, HttpServletResponse response) {
		return reportService.createAutoExcelReports(null);
	}
	
	@RequestMapping(value = "/createExcelReports/{type}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean createExcelReports(@PathVariable("type") String type, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return reportService.createAutoExcelReports(type);
	}
	
	@RequestMapping(value = "/deleteExcelReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteExcelReports(HttpServletRequest request, HttpServletResponse response) {
		return reportService.deleteExcelReports();
	}
	
	@RequestMapping(value = "/createPendingReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean createPendingReports(HttpServletRequest request, HttpServletResponse response) {
		return reportService.createPendingReports();
	}
	
	/*@RequestMapping("/executeCode")
	public ModelAndView executeCode() {
		ModelAndView mv = new ModelAndView("/test");
		mv.addObject("applicationContext", applicationContext);
		return mv;
	}*/
	
	@RequestMapping(value = "/generatePickupRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean generatePickupRequest(@RequestBody SaleOrderPickupRequest saleOrderPickupRequest, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderPickupRequestService.pushApiSaleOrderPickupRequest(saleOrderPickupRequest);
	}
	
	@RequestMapping(value = "/tranfrerClientData", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean tranfrerClientData(HttpServletRequest request, HttpServletResponse response) {
		return clientDashboardService.tranfrerClientData();
    }
	
	@RequestMapping(value = "/transferCourierData", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean transferCourierData(HttpServletRequest request, HttpServletResponse response) {
		return clientDashboardService.transferCourierData();
    }
	
	/*@RequestMapping("/addToVendorsOrderReadyToPushApi")
	public ModelAndView addToVendorsOrderReadyToPushApi() {
		ModelAndView mv = new ModelAndView("/addToVendorsOrderReadyToPushApi");
		mv.addObject("applicationContext", applicationContext);
		return mv;
	}*/
	@RequestMapping(value = "/createAlertTemplates", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean createAlertTemplates(HttpServletRequest request, HttpServletResponse response) {
		return alertMasterService.createAlertTemplates();
    }
	
	@RequestMapping(value = "/executeSystemReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean executeSystemReports(HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.createAutoReports(null);
	}
	
	@RequestMapping(value = "/executeSystemReports/{type}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean executeSystemReports(@PathVariable("type") String type, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return reportMasterService.createAutoReports(type);
	}
	
	@RequestMapping(value = "/scheduleDailyReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean scheduleDailyReports(HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.scheduleDailyReports();
	}
	
	@RequestMapping(value = "/deleteOldReportQueue", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteOldReportQueue(HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.deleteOldReportQueue();
	}
	
	@RequestMapping(value = "/pushStatusApi", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean pushStatusApi(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return pushStatusToVendorService.pushStatusApi(null, null);
	}
	
	@RequestMapping(value = "/pushStatusApiClient", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean pushStatusApiClient(@RequestParam(value = "client") String client, HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return pushStatusToVendorService.pushStatusApi(client, null);
	}
	
	@RequestMapping(value = "/pushStatusApiPost", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean pushStatusApiPost(@RequestBody List<String> awb, @RequestParam(value = "client") String client, HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return pushStatusToVendorService.pushStatusApi(client, awb);
	}
	
	@RequestMapping(value = "/reconcilePushStatusApi", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean reconcilePushStatusApi(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return pushStatusToVendorService.reconcilePushStatusApi();
	}
	
	@RequestMapping(value = "/CreateClientSKUWeigthLooker", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean createClientSKUWeigthLooker(@RequestParam(value = "date") String date, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return clientSKUWeigthLookerService.createClientSKUWeigthLooker(date);
	}
	
	@RequestMapping(value = "/UpdateClientSKUWeigthLooker", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updateClientSKUWeigthLooker(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return clientSKUWeigthLookerService.updateClientSKUWeigthLooker();
	}
	
	@RequestMapping(value = "/UserPasswordExpired", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean userPasswordExpired(HttpServletRequest request, HttpServletResponse response) {
		return userService.userPasswordExpired();
    }
	
	@RequestMapping(value = "/checkUserPasswordAvailable", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean checkUserPasswordAvailable (@RequestBody PasswordActiveBean passwordActiveBean,HttpServletRequest request, HttpServletResponse response) {
		return userService.checkUserPasswordAvailable(passwordActiveBean);
    }
	
	@RequestMapping(value = "/activatePasswordByUserId", method = RequestMethod.POST)
	@ResponseBody
    ResponseBean activatePasswordByUserId (@RequestBody PasswordActiveBean passwordActiveBean,HttpServletRequest request, HttpServletResponse response) {
		return userService.activatePasswordByUserId(passwordActiveBean);
    }

	@RequestMapping(value = "/getAllBranchCityList", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadSourceCitys(HttpServletRequest request, HttpServletResponse response) {
		return serviceablePincodeService.loadServiceableSourceCitys();
    }
	
	@RequestMapping(value = "/getSourcePincodeByCity/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getSourceCityByPincode (@PathVariable("key") String key) {
		return serviceablePincodeService.getPincodeByCity(key);
    }
	
	@RequestMapping(value = "/getAllCityList", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadDestinationCity(HttpServletRequest request, HttpServletResponse response) {
		return serviceablePincodeService.loadDestinationCitys();
    }
	
	@RequestMapping(value = "/getDestinationPincodeByCity/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getDestinationCityByPincode (@PathVariable("key") String key) {
		return serviceablePincodeService.getDestinationPincodeByCity(key);
    }
	
	@RequestMapping(value = "/getDestinationCity/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getDestinationCity (@PathVariable("key") String key) {
		return serviceablePincodeService.getDestinationCity(key);
    }
	
	
     /*-------------------c2c url----------------------------------*/
	
	@RequestMapping(value = "/new_user_registration", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createWebUser(@RequestBody WebUser webUser, HttpServletRequest request, HttpServletResponse response) {
		return webUserService.createWebUser(webUser);
    }
	
	/*-------------------c2c APP registration start hear----------------------------------*/
	@RequestMapping(value = "/c2cRegistrationByApp", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean c2cRegistrationByApp(@RequestBody WebUser webUser, HttpServletRequest request, HttpServletResponse response) {
		return webUserService.c2cRegistrationByApp(webUser);
    }
	
	@RequestMapping(value = "/validateRegistrationOtp", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean validateRegistrationOtp(@RequestParam(value = "mobile") String mobile,@RequestParam(value = "otp") String otp, 
    		HttpServletRequest request, HttpServletResponse response) {
		return webUserService.validateRegistrationOtp(mobile,otp);
    }
	
	@RequestMapping(value = "/c2cLoginWithOtp", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loginWithOtpByApp(@RequestParam(value = "mobile") String mobile,HttpServletRequest request, HttpServletResponse response) {
		return webUserService.loginWithOtpByApp(mobile);
    }
	
	/*-------------------c2c APP registration end hear----------------------------------*/
	
	@RequestMapping(value = "/checkUserKeyAvailables/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkWebUserAvilable (@PathVariable("key") String key) {
		return webUserService.checkWebUserAvilable(key);
    }
	
	@RequestMapping(value = "/checkUserKeyAvailable", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkWebUserAvilableKey (@RequestParam(value = "key") String key) {
		return webUserService.checkWebUserAvilable(key);
    }
		
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean login(@RequestBody WebUser user, HttpServletRequest request, HttpServletResponse response) {
		String deviceId = request.getHeaderNames()!=null ? request.getHeader("Device-ID") : "";
		user.setDeviceId(deviceId);
		ResponseBean responseBean = webUserService.login(user);
		return responseBean;
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			request.getSession().invalidate();
		} catch (Exception e) {
			
		}
		
		String redirectUrl = request.getScheme() + "://" + request.getServerName()+"/ERP/online_booking_parcel";
		return new ModelAndView("redirect:"+redirectUrl);
	}
	
	@RequestMapping(value="/parcelDetails", method= RequestMethod.POST)
	public ModelAndView serviceDetail(@ModelAttribute("bookingRequestBean") BookingRequestBean data,HttpServletRequest request) {
		return new ModelAndView("c2c/order/serviceDetail","data",data);
	}
	
	@RequestMapping(value = "/get_Services", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getAllServices (@RequestBody ProductBean productBean, HttpServletRequest request, HttpServletResponse response) {
		return webUserService.getAllServices(productBean);
    }
	
	@RequestMapping(value = "/createPacket", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPacket (@RequestBody BookingRequestBean bookingRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return packetService.createPacket(bookingRequestBean);
    }
	
	@RequestMapping(value = "/getRateEstimateC2C", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getRateEstimateC2C (@RequestBody ProductBean productBean, HttpServletRequest request, HttpServletResponse response) {
		return c2cPricingService.getRateEstimateC2C(productBean);
    }
	
	@RequestMapping("/pay")
	public ModelAndView pay(HttpServletRequest request) {
		String bookingId = request.getParameter("bookingId");
		ModelAndView  modelAndView = new ModelAndView("c2c/account/ebs/pay");
		ResponseBean responseBean = packetService.getPacketDetailsForEBSGateway(bookingId);
		 if (responseBean != null && responseBean.getResponse() != null) {
			 modelAndView.addObject("gatewayDeatilsMap", responseBean.getResponse());
		 }
		return modelAndView;
	}
	
	@RequestMapping(value = "/createC2cPaymentOrder", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean createC2cPaymentOrder (@RequestParam(value = "packetId") String packetId, HttpServletRequest request, HttpServletResponse response) {
		return packetService.createC2cPaymentOrder(packetId);
    }
	
	@RequestMapping(value = "/valiadateRazorpayPaymentResponse", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean valiadateRazorpayPaymentResponse (@RequestBody Map<String, String> map, @RequestParam(value = "packetId") String packetId,HttpServletRequest request, HttpServletResponse response) {
		return packetService.valiadateRazorpayPaymentResponse(map, packetId);
    }
	
	@RequestMapping(value = "/razorpaySuccessResponse", method = RequestMethod.POST)
    public ModelAndView razorpaySuccessResponse ( HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView model = new ModelAndView("c2c/account/ebs/success");
		String awb = request.getParameter("awb");
		ResponseBean responseBean = packetService.getSaleOrder(awb);
		if(ResponseStatus.SUCCESS.equals(responseBean.getStatus())) {
			model.addObject("data", responseBean);
			model.addObject("message", responseBean.getMessage()!=null ? responseBean.getMessage()+"" : null);	
		}else {
			model = null;
		}
		return model;
    }
	
	@RequestMapping(value="/response", method=RequestMethod.POST)
	public ModelAndView response(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		ModelAndView model = new ModelAndView("c2c/account/ebs/success");
		String dR = request.getParameter("DR");
		ResponseBean responseBean = packetService.getBookingResponse(dR);
		if (responseBean != null && responseBean.getResponse() != null && responseBean.getStatus().equals(ResponseStatus.SUCCESS)) {
			model.addObject("data", responseBean);
			model.addObject("message", responseBean.getMessage()!=null ? responseBean.getMessage()+"" : null);
        	return model;
        }else if(responseBean!=null && responseBean.getStatus().equals(ResponseStatus.SUCCESS)){
        	model.addObject("message", responseBean.getMessage()!=null ? responseBean.getMessage()+"" : null);
        	return model;
        }else{
        	model =  new ModelAndView("c2c/account/ebs/failure");
        	model.addObject("message", responseBean.getMessage()!=null ? responseBean.getMessage()+"" : null);
		    return model;
		}
	}
	
	@RequestMapping(value = "/updatePassword/{newPassword}", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean updateUserPassword(@PathVariable("newPassword") String newPassword, HttpServletRequest request, HttpServletResponse response) {
		return webUserService.updateUserPassword(newPassword);
    }
	
	@RequestMapping(value = "/updateUserDetails", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean updateUserDetails(@RequestBody WebUser webUser, HttpServletRequest request, HttpServletResponse response) {
		return webUserService.updateUserDetails(webUser);
    }
	
	@RequestMapping(value = "/getUserDetails", method = RequestMethod.POST) //t
	@ResponseBody
    public ResponseBean getUserDetails(HttpServletRequest request, HttpServletResponse response) {
		return webUserService.getUserDetails();
    }
	
	@RequestMapping(value = "/getPincodeByCountryStateCity/{key}", method = RequestMethod.GET)//t
	@ResponseBody
    public ResponseBean getCountryStateCityByPincode(@PathVariable("key") String pincode, HttpServletRequest request, HttpServletResponse response) {
		return countryService.getCountryStateCityByPincode(pincode);
    }
	
	@RequestMapping(value = "/addUserAddress", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean addUserAddress(@RequestBody WebUserAddressList webUserAddressList, HttpServletRequest request, HttpServletResponse response) {
		return webUserService.addUserAddress(webUserAddressList);
    }
	
	@RequestMapping(value = "/editUserAddress", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean editUserAddress(@RequestBody WebUserAddressList webUserAddressList, HttpServletRequest request, HttpServletResponse response) {
		return webUserService.editUserAddress(webUserAddressList);
    }
	
	@RequestMapping(value = "/getSystemReport", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean prepareSystemReport(@RequestBody ReportQueue reportBean, HttpServletRequest request, HttpServletResponse response) {
		return c2cReportService.getSystemReport(reportBean);
    }
	
	@RequestMapping(value = "/getPendingPaymentOrder", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean getPendingPaymentOrder(HttpServletRequest request, HttpServletResponse response) {
		return c2cReportService.getPendingPaymentOrder();
    }
	
	@RequestMapping(value = "/getPendingPaymentOrderNew", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean getPendingPaymentOrderNew(HttpServletRequest request, HttpServletResponse response) {
		return c2cReportService.getPendingPaymentOrderNew();
    }
	
	@RequestMapping(value = "/getPickupPendingOrder", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean getPickupPendingOrder(HttpServletRequest request, HttpServletResponse response) {
		return c2cReportService.getPickupPendingOrder();
    }
	
	@RequestMapping(value = "/getCancelOrders", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean getCancelOrders(HttpServletRequest request, HttpServletResponse response) {
		return c2cReportService.getCancelOrders();
    }
	
	@RequestMapping(value = "/getIntransitOrders", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean getIntransitOrders(HttpServletRequest request, HttpServletResponse response) {
		return c2cReportService.getIntransitOrders();
    }
	
	@RequestMapping(value = "/getDeliveredOrders", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean getDeliveredOrders(HttpServletRequest request, HttpServletResponse response) {
		return c2cReportService.getDeliveredOrders();
    }
	
	@RequestMapping(value = "/getReturnedOrders", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean getReturnedOrders(HttpServletRequest request, HttpServletResponse response) {
		return c2cReportService.getReturnedOrders();
    }
	
	@RequestMapping(value = "/getPackets", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getPackets(@RequestParam(value="packetIds") String packetIds,HttpServletRequest request, HttpServletResponse response) {
		return packetService.getPackets(packetIds);
    }
	
	@RequestMapping(value = "/order_print_pdf", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getPickupPendingDocket(@RequestParam(value="awbNumbers") String awbNumbers,HttpServletRequest request, HttpServletResponse response) {
		return packetService.getPrintLeableC2C(awbNumbers, request);
    }
	
	@RequestMapping(value = "/getAllPaymentPending", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean threeplPickupRequest(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return packetService.getAllPaymentPending(datatableRequestBean);
	}
	
	@RequestMapping(value = "/trackingShipmentsC2C", method = RequestMethod.POST)
	@ResponseBody 
	public ApiResponseBean getShipmentDetailsC2C(@RequestBody TrackCurrentStatusBean trStatusBean, HttpServletRequest request, HttpServletResponse response){
		  try {
			Settings settings = settingsDao.getObjectById("bmpRemoteAddr", Settings.class);
			List<String> remoteList = Arrays.asList(settings.getContextValue_s().split(","));
			System.out.println("Remote Address : " +  request.getRemoteAddr());
			if(!remoteList.contains(request.getRemoteAddr()) && !remoteList.contains("ALL")) {
				return null;
			}
		  }catch (Exception e) {e.printStackTrace();}
		  
		return bmpApiService.trackCurrentStatusForC2CNew(trStatusBean.getClientId(), trStatusBean.getSearchBy(), trStatusBean.getAwbNumber());
	}
	
	@RequestMapping(value = "/trackingShipmentDetailsC2C", method = RequestMethod.GET)
	@ResponseBody 
	public ApiResponseC2CBean getAllStatusC2C(@RequestParam("awbNumber") String awbNumber, HttpServletRequest request, HttpServletResponse response){
		try {
			Settings settings = settingsDao.getObjectById("bmpRemoteAddr", Settings.class);
			List<String> remoteList = Arrays.asList(settings.getContextValue_s().split(","));
			System.out.println("Remote Address : " +  request.getRemoteAddr());
			if(!remoteList.contains(request.getRemoteAddr()) && !remoteList.contains("ALL")) {
				return null;
			}
		  }catch (Exception e) {e.printStackTrace();}
		
		return bmpApiService.getAllStatusShipmentForC2C(awbNumber);
	}
	
	@RequestMapping(value = "/getStandardParcels", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getStandardParcels (HttpServletRequest request, HttpServletResponse response) {
		return standardParcelService.getStandardParcels ();
    }
	@RequestMapping(value = "/getPrice", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getPickupPendingDocket(@RequestParam(value="packetId") String packetId, @RequestParam(value="pricingId") String pricingId, HttpServletRequest request, HttpServletResponse response) {
		return packetService.getPrice(packetId, pricingId);
    }
	
	@RequestMapping(value = "/getStandardParcelByKey", method = RequestMethod.GET)
   	@ResponseBody
   	public ResponseBean getStandardParcelByKey(@RequestParam(value="parcelKey") String parcelKey, HttpServletRequest request, HttpServletResponse response) {
	return standardParcelService.getStandardParcelByKey(parcelKey);
    }
	
	@RequestMapping(value = "/updateOrderCancel", method = RequestMethod.GET)
   	@ResponseBody
   	public ResponseBean updateOrderCancel(HttpServletRequest request, HttpServletResponse response) {
	return packetService.updateOrderCancel();
    }
	
	@RequestMapping(value = "/addEnquiry", method = RequestMethod.POST)//t
	@ResponseBody
    public ResponseBean addEnquiry(@RequestBody Enquiry enquiry, HttpServletRequest request, HttpServletResponse response) {
		return enquiryService.addEnquiry(enquiry);
    }
	
	@RequestMapping(value = "/c2c/response", method = RequestMethod.POST)
   	@ResponseBody
   	public ResponseBean gatewayResponse(@RequestBody C2cPricingRequestBean trStatusBean,HttpServletRequest request, HttpServletResponse response) {
		String dR = trStatusBean.getdR();
		return packetService.getBookingResponse(dR);
		
    }
	
	@RequestMapping(value = "/getPincodeBySourceCity/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getPincodeBySourceCity(@PathVariable("key") String pincode, HttpServletRequest request, HttpServletResponse response) {
		return serviceablePincodeService.getPincodeBySourceCity(pincode);
    }
	
	@RequestMapping(value = "/getPincodeByDestinationCity/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getPincodeByDestinationCity(@PathVariable("key") String pincode, HttpServletRequest request, HttpServletResponse response) {
		return serviceablePincodeService.getPincodeByDestinationCity(pincode);
    }
	
	@RequestMapping(value = "/getPincodeByDestinationCityNew", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getPincodeByDestinationCityNew(@RequestParam(value="sourcePincode") String sourcePincode,@RequestParam(value="destinationPincode")  String destinationPincode,HttpServletRequest request, HttpServletResponse response) {
		return serviceablePincodeService.getPincodeByDestinationCityNew(sourcePincode,destinationPincode);
    }
	
	@RequestMapping(value = "/deleteUserAddress/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteUserAddress(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return webUserService.deleteUserAddress(key);
    }
	
	@RequestMapping(value = "/order_print", method = RequestMethod.POST)
	public ModelAndView getPrintLabel(@ModelAttribute PrintLabel printLabel,
			HttpServletRequest request, HttpServletResponse response) {
		printLabelService.printLabel(printLabel, request, response);
		return null;
	}
	
	@RequestMapping(value = "/c2cApp/response", method = RequestMethod.POST)
   	@ResponseBody
   	public ResponseBean gatewayResponse(@RequestBody GatewayResponseBean gatewayResponseBean,HttpServletRequest request, HttpServletResponse response) {
		
		return packetService.getC2CResponse(gatewayResponseBean);
		
    }
	
	@RequestMapping(value = "/sendBookingMail", method = RequestMethod.POST)
   	@ResponseBody
   	public ResponseBean sendMail(@RequestBody C2cBookingMailBean c2cBookingMailBean,HttpServletRequest request, HttpServletResponse response) {
		return packetService.bookingMail(c2cBookingMailBean);
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
   	@ResponseBody
   	public ResponseBean c2cForgotMail(@RequestBody C2cBookingMailBean c2cBookingMailBean,HttpServletRequest request, HttpServletResponse response) {
		return webUserService.c2cForgotMail(c2cBookingMailBean);
	}
	
	@RequestMapping(value = "/getAllClientLogo", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getAllClientLogo(HttpServletRequest request, HttpServletResponse response) {
		return webUserService.getAllClientLogo();
    }
	
	@RequestMapping(value = "/sendPendingAlerts", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean sendPendingAlerts(HttpServletRequest request, HttpServletResponse response) {
		return smsMailMasterService.sendPendingAlerts();
    }
	
	@RequestMapping(value = "/pushStatusApiByDocket", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean pushStatusApiByDocket(@RequestBody PrintLabel trackingApiBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return pushStatusToVendorService.pushStatusApiByDocket(trackingApiBean);
	}
	
	@RequestMapping(value = "/autoAdminReport", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean autoAdminReport(HttpServletRequest request, HttpServletResponse response) {
		return reportService.autoAdminReport();
    }
	
	@RequestMapping(value = "/autoSchedulePickupRequest", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean autoSchedulePickupRequest(HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.autoSchedulePickupRequest();
    }
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	@ResponseBody
    public String greeting(@RequestParam(value="CallSid") String callSid, @RequestParam(value="From") String from, @RequestParam(value="To") String to
    		,HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Content-Type", "text/plain");
		return callManifestService.greeting(callSid, from, to, response);
    }
	
	@RequestMapping(value = "/passthru", method = RequestMethod.GET)
	@ResponseBody
    public String passthru(@RequestParam(value="CallSid",required = false) String callSid,  @RequestParam(value="From", required = false) String from,@RequestParam(value="To", required = false) String to,
    		@RequestParam(value="digits", required = false) String digits, HttpServletRequest request, HttpServletResponse response) {
		digits = digits.replaceAll("\"","");
		return callManifestService.passthru(callSid, from, to, digits, response);
    }
	
	@RequestMapping(value = "/OutgoingCall", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean OutgoingCall(@RequestParam(value="From") String from,@RequestParam(value="To") String to,
    		@RequestParam(value="awb", required = false) String awb, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.OutgoingCall(from, to,request.getHeader("User-ID"), awb, null);
    }

	@RequestMapping(value = "/CustomerWhitelist", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean customerWhitelist(@RequestParam(value="Number", required = false) String number,HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.customerWhitelist(number, null);
    }
	
	@RequestMapping(value = "/callManifestCron", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean callManifestCron(HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.callManifestCron();
    }
	
	@RequestMapping(value = "/getAllPendingRecordingFromExtole", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getAllPendingRecordingFromExtole(HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.getAllPendingRecordingFromExtole();
    }
	
	@RequestMapping(value = "/OrderDetail", method = RequestMethod.GET)
	public ModelAndView orderDetail(@RequestParam(value = "order") String awb, HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("bmpTracking/orderDetail", "data", bmpApiService.orderDetail(awb));
	}
	
	@RequestMapping(value = "/OrderConfirm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean orderConfirm(@RequestParam(value = "order") String awb, HttpServletRequest request, HttpServletResponse response) {
		return bmpApiService.orderConfirm(awb);
	}
	
	@RequestMapping(value = "/OrderCancel", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean orderCancel(@RequestParam(value = "order") String awb, HttpServletRequest request, HttpServletResponse response) {
		return bmpApiService.orderCancel(awb);
	}
	
	@RequestMapping(value = "/sendSmsAtOutgoingCallDispute", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean sendSmsAtOutgoingCallDispute(HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.sendSmsAtOutgoingCallDispute();
    }
	
	@RequestMapping(value = "/sendSmsAtIvrCallDispute", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean sendSmsAtIvrCallDispute(HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.sendSmsAtIvrCallDispute();
    }
	
	@RequestMapping(value = "/callManifestClosedCroneJob", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean callManifestClosedCroneJob(HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.callManifestClosedCroneJob();
    }
	
	@RequestMapping(value = "/sendManualSmsCron", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean sendManualSmsCron( HttpServletRequest request, HttpServletResponse response) {
		return sendManualSmsService.sendManualSmsCron();
    }
	
	@RequestMapping(value = "/RBLSmsCron", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean RBLSmsCron( HttpServletRequest request, HttpServletResponse response) {
		return sendManualSmsService.RblSmsCron();
    }
	
	@RequestMapping(value = "/storeAllContactNumber", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean storeAllContactNumber(HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.storeAllContactNumber();
    }
	
	@RequestMapping(value = "/autoResolved3plErrorPackets", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean autoResolved3plErrorPackets(HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.autoResolved3plErrorPackets();
    }
	
	@RequestMapping(value = "/executeReportScheduler", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean executeReportScheduler(HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.executeReportScheduler();
	}

	/*@RequestMapping(value = "/ralOrderPush", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean ralOrderPush(@RequestParam(value = "backDate",required = false) String backDate, HttpServletRequest request, HttpServletResponse response) {
		int backDateCount =0;
		if(backDate != null && !"".equals(backDate.trim())) {
			try {
				backDateCount = Integer.valueOf(backDate);
			}catch(Exception e) {e.printStackTrace();}
		}
		return ralOrderPushServiceImpl.ralOrderPuch(backDateCount);
    }*/
	
	@RequestMapping(value = "/ApolloDelayDeliverySms", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean ApolloDelayDeliverySms( HttpServletRequest request, HttpServletResponse response) {
		return sendManualSmsService.ApolloDelayDeliverySms();
    }
	
	@RequestMapping(value = "/pendingAlertsCron", method = RequestMethod.GET)
	@ResponseBody
    public Object pendingAlertsCron( HttpServletRequest request, HttpServletResponse response) {
		return smsMailMasterService.pendingAlertsCron();
    }
	
	@RequestMapping(value = "/executePendingInvoiceStatus", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean executePendingInvoiceStatus( HttpServletRequest request, HttpServletResponse response) {
		return ralOrderPushServiceImpl.executePendingInvoiceStatus();
    }
	
	@RequestMapping(value = "/getBfilOrders", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBfilOrders( HttpServletRequest request, HttpServletResponse response) {
		return ralOrderPushServiceImpl.getBfilOrders();
    }
	
	@RequestMapping(value = "/getBfilTelecallUpdates", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBfilTelecallUpdates( HttpServletRequest request, HttpServletResponse response) {
		return ralOrderPushServiceImpl.getBfilTelecallUpdates();
    }
	
	@RequestMapping(value = "/getBfilCancelOrders", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBfilCancelOrders( HttpServletRequest request, HttpServletResponse response) {
		return ralOrderPushServiceImpl.getBfilCancelOrders();
    }
	
	@RequestMapping(value = "/createMasterBackup", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean ceateDbBackup( HttpServletRequest request, HttpServletResponse response) {
		return dbBackupService.ceateDbBackup();
    }
	
	@RequestMapping(value = "/createSaleOrderBackup", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean createSaleOrderBackup( HttpServletRequest request, HttpServletResponse response) {
		return dbBackupService.backupSaleOrder();
    }
	
	@RequestMapping(value = "/updateAppKm", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateAppKm(@RequestBody AppKmUpdateBean appKmUpdateBean , HttpServletRequest request, HttpServletResponse response) {
		return userService.updateAppKm(appKmUpdateBean);
    }
	
	@RequestMapping(value = "/getAppVersion", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getAppVersion (HttpServletRequest request, HttpServletResponse response) {
		return userService.getAppVersion();
    }
	
	
	@RequestMapping(value = "/orderCreate", method = RequestMethod.POST)
	@ResponseBody
    public List<BflResponseBean> orderCreate(@RequestBody List<BfilOrder> bfilOrderList , HttpServletRequest request, HttpServletResponse response) {
		String authorization = request.getHeaderNames()!=null ? request.getHeader("Authorization") : null;
		return bfilOrderService.createBfilOrder(bfilOrderList, authorization);
    }
	
	@RequestMapping(value = "/cancelUpdate", method = RequestMethod.POST)
	@ResponseBody
    public List<BflResponseBean> cancelUpdate(@RequestBody List<BfilOrderCancel> bfilCancelOrderList , HttpServletRequest request, HttpServletResponse response) {
		String authorization = request.getHeaderNames()!=null ? request.getHeader("Authorization") : null;
		return bfilOrderService.cancelBfilOrder(bfilCancelOrderList,authorization);
    }
	
	@RequestMapping(value = "/pushBfilOrderInRalSystem", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean pushBfilOrderInRalSystem( HttpServletRequest request, HttpServletResponse response) {
		return bfilOrderService.pushBfilOrderInRalSystem();
    }
	
	@RequestMapping(value = "/convertBfilOrderInSaleOrder", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean convertBfilOrderInSaleOrder( HttpServletRequest request, HttpServletResponse response) {
		return bfilOrderService.convertBfilOrderInSaleOrder();
    }
	
	
	@RequestMapping(value = "/downloadBfilErrorOrder", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean downloadBfilErrorOrder( HttpServletRequest request, HttpServletResponse response) {
		return bfilOrderService.downloadBfilErrorOrder(response);
    }
	
	@RequestMapping(value = "/autoPick3plPickupRequest", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean autoPick3plPickupRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.autoPick3plPickupRequest();
	}
	
	@RequestMapping(value = "/GetContactNumber", method = RequestMethod.GET)
	@ResponseBody
    public String getContactNumber(@RequestParam(value="CallSid") String callSid, @RequestParam(value="From", required = false) String from, 
    		@RequestParam(value="To", required = false) String to, @RequestParam(value="Direction", required = false) String direction,
    		@RequestParam(value="digits",required = false) String digits
    		,HttpServletRequest request, HttpServletResponse response) {
		
		digits = digits != null ? digits.replaceAll("\"","") : null;
		Map<String, String> requestParamMap  = new HashMap<String, String>();
		requestParamMap.put("Pin", digits);
		requestParamMap.put("From", from);
		requestParamMap.put("To", to);
		requestParamMap.put("CallSid", callSid);
		requestParamMap.put("Direction", direction);
		response.setHeader("Content-Type", "text/plain");
		String number = saleOrderExtraService.getContactNumber(requestParamMap);
		logger.info(String.class, "GetContactNumber Api Call "+number+"-->Request Map = "+requestParamMap);
		return number;
    }
	
	@RequestMapping(value = "/ValidatePin", method = RequestMethod.GET)
	@ResponseBody
    public int validatePin(@RequestParam(value="CallSid") String callSid, @RequestParam(value="From", required = false) String from, 
    		@RequestParam(value="To", required = false) String to, @RequestParam(value="Direction", required = false) String direction,
    		@RequestParam(value="digits") String digits
    		,HttpServletRequest request, HttpServletResponse response) {
		
		digits = digits.replaceAll("\"","");
		Map<String, String> requestParamMap  = new HashMap<String, String>();
		requestParamMap.put("Pin", digits);
		requestParamMap.put("From", from);
		requestParamMap.put("To", to);
		requestParamMap.put("CallSid", callSid);
		requestParamMap.put("Direction", direction);
		
		String responseCode = saleOrderExtraService.validatePin(requestParamMap);
		response.setStatus(Integer.valueOf(responseCode));
		
		logger.info(String.class, "ValidatePin Api Call "+responseCode+"-->Request Map = "+requestParamMap);
		return Integer.valueOf(responseCode);
    }
	

	@RequestMapping(value = "/createRdsp", method = RequestMethod.POST)
	@ResponseBody
    public List<RdspResponseBean> createRdsp(@RequestBody List<RDSP> rdspList , HttpServletRequest request, HttpServletResponse response) {
		String authorization = request.getHeaderNames()!=null ? request.getHeader("Authorization") : null;
		return rdspService.createRdsp(rdspList, authorization);
    }

	@RequestMapping(value = "/rdspProductReceived", method = RequestMethod.POST)
	@ResponseBody
    public List<BflResponseBean> rdspProductReceived(@RequestBody List<BfilRdspProductReceived> bfilRdspProductReceivedList, HttpServletRequest request, HttpServletResponse response) {
		String authorization = request.getHeaderNames() != null ? request.getHeader("Authorization") : null;
		return bfilOrderService.rdspProductReceived(bfilRdspProductReceivedList, authorization);
    }
	
	@RequestMapping(value = "/rdspProductHandoverToMember", method = RequestMethod.POST)
	@ResponseBody
    public List<BflResponseBean> rdspProductHandoverToMember(@RequestBody List<BfilRdspProductMemberHandover> bfilRdspProductMemberHandoverList, HttpServletRequest request, HttpServletResponse response) {
		String authorization = request.getHeaderNames() != null ? request.getHeader("Authorization") : null;
		return bfilOrderService.rdspProductHandoverToMember(bfilRdspProductMemberHandoverList, authorization);
    }
	
	
	@RequestMapping(value = "/rdspDeliveryModelUpdate", method = RequestMethod.POST)
	@ResponseBody
    public List<BflResponseBean> rdspDeliveryModelUpdate(@RequestBody List<BfilDeliveryModelUpdate> bfilDeliveryModelUpdateList, HttpServletRequest request, HttpServletResponse response) {
		String authorization = request.getHeaderNames() != null ? request.getHeader("Authorization") : null;
		return bfilOrderService.rdspDeliveryModelUpdate(bfilDeliveryModelUpdateList, authorization);
    }
	
	
	@RequestMapping(value = "/rdspReturnToVendor", method = RequestMethod.POST)
	@ResponseBody
    public List<BflResponseBean> rdspReturnToVendor(@RequestBody List<BfilReturnToVendor> bfilReturnToVendorList, HttpServletRequest request, HttpServletResponse response) {
		String authorization = request.getHeaderNames() != null ? request.getHeader("Authorization") : null;
		return bfilOrderService.rdspBfilReturnToVendor(bfilReturnToVendorList, authorization);
    }
	
	@RequestMapping(value = "/pushRdspMasterToRal", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean pushRdspMasterToRal(HttpServletRequest request, HttpServletResponse response) {
		return rdspService.pushRdspMasterToRal();
    }

	@RequestMapping(value = "/deactivateKycIncompleteUser", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean DeactivateKycIncompleteUser(HttpServletRequest request, HttpServletResponse response) {
		return userService.deactivateKycIncompleteUser();
    }
	
	@RequestMapping(value = "/forgotPasswordForFE", method = RequestMethod.POST)
   	@ResponseBody
   	public ResponseBean forgotPasswordForFE(@RequestParam(value = "loginId") String loginId, HttpServletRequest request, HttpServletResponse response) {
		return userService.forgotPasswordForFE(loginId);
	}
	
	@RequestMapping(value = "/awbPreeAlertCourierSeries", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean awbPreeAlertCourierSeries(HttpServletRequest request, HttpServletResponse response) {
		return manifestService.awbPreeAlertCourierSeries();
    }
	
	@RequestMapping(value = "/getAllInvoiceCancel", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getAllInvoiceCancel(HttpServletRequest request, HttpServletResponse response) {
		return ralOrderPushServiceImpl.getAllInvoiceCancel();
    }
	
	@RequestMapping(value = "/getReInvoiceGenerateInRalSystem", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean checkReInvoiceGenerateInRalSystem(HttpServletRequest request, HttpServletResponse response) {
		return ralOrderPushServiceImpl.getReInvoiceGenerateInRalSystem();
    }
	
	@RequestMapping(value = "/deleteOldLogs", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteOldLogs(HttpServletRequest request, HttpServletResponse response) {
		return alertErrorLogsService.deleteOldLogs();
	}
	
	@RequestMapping(value = "/KycRejectedAlertSms", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean KycRejectedAlertSms(HttpServletRequest request, HttpServletResponse response) {
		return userService.KycRejectedAlertSms();
    }
	
	@RequestMapping(value = "/updateSkuInventory", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updateSkuInventory(HttpServletRequest request, HttpServletResponse response) {
		return skuInventory.updateSkuInventory();
	}
	
	@RequestMapping(value = "/playRecording/{key}", method = RequestMethod.GET)
	@ResponseBody
	public String playRecording(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) { 
		response.setContentType("text/html");
        return saleOrderService.playRecording(key).getMessage();
		
	}
	
	@RequestMapping(value = "/sendBranchCodClosingDepositPendingAlert", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean sendBranchCodClosingDepositPendingAlert (HttpServletRequest request, HttpServletResponse response) {
		return branchCashClosingService.getBranchCodClosingDepositPendingAlert();
	}
	
	@RequestMapping(value = "/sendPreAlertPendingForDrs", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean sendPreAlertPendingForDrs (HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.sendPreAlertPendingForDrs();
	}
	
	@RequestMapping(value = "/sendPreAlertPendingForCODReceive", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean sendPreAlertPendingForCODReceive (HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.sendPreAlertPendingForCODReceive();
	}
	
	@RequestMapping(value = "/ralInvoiceProcessApi", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean ralInvoiceProcessApi (HttpServletRequest request, HttpServletResponse response) {
		return ralInvoiceDetailsService.ralInvoiceProcessApi();
	}
	
	@RequestMapping(value = "/dashBoardQueryCrone", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean dashBoardQueryCrone (HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.dashBoardQueryCrone();
	}
	@RequestMapping(value = "/rtoDeclaredApiCall", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean rtoDeclaredApiCall(@RequestParam(value = "awbNumber", required = false) String awbNumber,@RequestParam(value = "cycle", required = false) String cycle, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.rtoDeclaredApiCall(awbNumber,cycle, null);
	}
	@RequestMapping(value = "/PrintLabelApiCall", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean PrintLabelApiCall(@RequestParam(value = "awbNumber", required = false) String awbNumber,@RequestParam(value = "logisticId", required = false) String logisticId, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.vendorPrintLabelRequest(awbNumber,logisticId);
	}
	
	@RequestMapping(value = "/addWarehousePendingPushReadyToPush", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addWarehousePendingPushReadyToPush(@RequestBody WarehousePendingPush warehousePendingPush, HttpServletRequest request, HttpServletResponse response) {
		return warehousePendingPushService.addWarehousePendingPushReadyToPush(warehousePendingPush);
    }
	@RequestMapping(value = "/updateWarehousePendingPushReadyToPush", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateWarehousePendingPushReadyToPush(@RequestBody WarehousePendingPush warehousePendingPush, HttpServletRequest request, HttpServletResponse response) {
		return warehousePendingPushService.updateWarehousePendingPushReadyToPush(warehousePendingPush);
    }
	@RequestMapping(value = "/getAllWarehouseReadyToPush", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllWarehouseReadyToPush(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return warehousePendingPushService.getAllWarehouseReadyToPush(datatableRequestBean);
	}
	@RequestMapping(value = "/deleteWarehousePendingPush", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean deleteWarehousePendingPush(@RequestBody String warehouseId, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return warehousePendingPushService.deleteWarehousePendingPush(warehouseId);
	}
	
	@RequestMapping(value = "/pushWarehouseApiCall", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean pushWarehouse(@RequestParam(value = "logisticId", required = false) String logisticId,@RequestParam(value = "warehouseId", required = false) String warehouseId, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return warehousePendingPushService.pushWarehouse(logisticId,warehouseId);
	}
	
	@RequestMapping(value = "/getAllWarehouseSuccessLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllWarehouseSuccessLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return warehousePendingPushService.getAllWarehouseSuccessLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllWarehouseErrorLogs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllWarehouseErrorLogs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return warehousePendingPushService.getAllWarehouseErrorLogs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/fetchMarketPlaceOrder", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean fetchMarketPlaceOrder(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "range", required = false) Integer range, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return marketplaceService.fetchMarketPlaceOrder(key, range);
	}
	@RequestMapping(value = "/fetchMarketPlaceCatalog", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean fetchMarketPlaceCatalogue(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "range", required = false) Integer range, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return marketplaceService.fetchMarketPlaceCatalogue(key, range);
	}
	@RequestMapping(value = "/eligibleShippingServices", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean eligibleShippingServices( HttpServletRequest request,HttpServletResponse response) throws Exception {
		return amazonService.eligibleShippingServices();
	}

	@RequestMapping(value = "/fetchWayBillSeries", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean fetchWayBillSeries(@RequestParam(value = "count") Integer count, HttpServletRequest request, HttpServletResponse response) {
		return vendorApiService.vendorWayBillSeriesRequest(count);
	}

	@RequestMapping(value = "/vendorB2cNdrRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean vendorB2cNdrRequest(@RequestParam(value = "awbNumber", required = true) String awbNumber, @RequestParam(value = "ndrReason", required = false) String ndrReason, HttpServletRequest request, HttpServletResponse response) {
		try {
			return vendorApiService.vendorB2cNdrRequest(awbNumber, ndrReason);
		} catch (Exception e) {
			logger.error("Error in vendorB2cNdrRequest: ".getClass(), e.getMessage());
			ResponseBean responseBean = new ResponseBean();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("Exception occurred: " + e.getMessage());
			return responseBean;
		}
	}

	@RequestMapping(value = "/vendorB2cNdrRequestBody", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean vendorB2cNdrRequestBody(@RequestBody Map<String, String> requestMap, HttpServletRequest request, HttpServletResponse response) {
		try {
			String awbNumber = requestMap.get("awbNumber");
			String ndrReason = requestMap.get("ndrReason");

			if (awbNumber == null || awbNumber.isEmpty()) {
				ResponseBean responseBean = new ResponseBean();
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("awbNumber is required");
				return responseBean;
			}

			return vendorApiService.vendorB2cNdrRequest(awbNumber, ndrReason);
		} catch (Exception e) {
			logger.error("Error in vendorB2cNdrRequestBody: ".getClass(), e.getMessage());
			ResponseBean responseBean = new ResponseBean();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("Exception occurred: " + e.getMessage());
			return responseBean;
		}
	}


	@RequestMapping(value = "/vendorB2cNdrBatchRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean vendorB2cNdrBatchRequest(@RequestBody Map<String, Object> requestMap, HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		try {
			@SuppressWarnings("unchecked")
			List<String> awbNumbers = (List<String>) requestMap.get("awbNumbers");
			String ndrReason = (String) requestMap.get("ndrReason");

			if (awbNumbers == null || awbNumbers.isEmpty()) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("awbNumbers list is required");
				return responseBean;
			}

			Map<String, Object> batchResults = new HashMap<>();
			int successCount = 0;
			int failureCount = 0;

			for (String awbNumber : awbNumbers) {
				try {
					ResponseBean individualResponse = vendorApiService.vendorB2cNdrRequest(awbNumber, ndrReason);

					if (ResponseStatus.SUCCESS.equals(individualResponse.getStatus())) {
						batchResults.put(awbNumber, "SUCCESS");
						successCount++;
					} else {
						batchResults.put(awbNumber, "FAILED: " + individualResponse.getMessage());
						failureCount++;
					}
				} catch (Exception e) {
					batchResults.put(awbNumber, "ERROR: " + e.getMessage());
					failureCount++;
					logger.error(("Error processing NDR for AWB: " + awbNumber).getClass(), e.getMessage());
				}
			}

			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setMessage("Batch processing completed. Success: " + successCount + ", Failed: " + failureCount);

			Map<String, Object> responseData = new HashMap<>();
			responseData.put("totalRequests", awbNumbers.size());
			responseData.put("successCount", successCount);
			responseData.put("failureCount", failureCount);
			responseData.put("results", batchResults);

			responseBean.setResponse(responseData);

		} catch (Exception e) {
			logger.error("Error in vendorB2cNdrBatchRequest: ".getClass(), e.getMessage());
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("Exception occurred: " + e.getMessage());
		}
		return responseBean;
	}


	@RequestMapping(value = "/govt/ewaybill/get", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getGovtEwaybill(@RequestParam String awbNumber, @RequestParam(required = false) String courierKey) {
		ResponseBean responseBean = new ResponseBean();
		try {
			logger.info(this.getClass(),"Fetching eWaybill for AWB: " + awbNumber);
			responseBean = govtApiService.getEwaybill(awbNumber, courierKey);
		} catch (Exception e) {
			logger.error(this.getClass(),("Exception in getGovtEwaybill for AWB: " + awbNumber + " "+ e));
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("Error fetching eWaybill: " + e.getMessage());
		}
		return responseBean;
	}
}
