package com.bmp.oms.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bmp.bean.BulkUploadBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.MessageConstant;
import com.bmp.constant.OrderTransactionType;
import com.bmp.constant.ResponseStatus;
import com.bmp.model.app.config.Settings;
import com.bmp.model.app.facility.User;
import com.bmp.oms.service.client.ClientAccountService;
import com.bmp.oms.service.facility.SettingsService;
import com.bmp.oms.service.saleorder.SaleOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RequestMapping("/nav")
@Controller
public class NavigationController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("saleOrderServiceImpl")
	private  SaleOrderService saleOrderService;
	
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired
	@Qualifier("clientAccountServiceImpl")
	private ClientAccountService clientAccountService;
	
	@Autowired
	@Qualifier("settingsService")
	private SettingsService settingsService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("login");
		String source = (String) session.getAttribute("source");
		String shop = (String) session.getAttribute("shop");
		
		modelAndView.addObject("source", source != null ? source : "");
		modelAndView.addObject("shop", shop != null ? shop : "");
		
		return modelAndView;
	}
	@RequestMapping("/facility/onBoarding")
	public ModelAndView onBoarding() {
		return new ModelAndView("/facility/onBoarding");
	}
	@RequestMapping("/facility/forgetPassword")
	public ModelAndView forgetPassword() {
		return new ModelAndView("/facility/forgetPassword");
	}
	/*
	 * @RequestMapping("/facility/otp") public ModelAndView otp() { return new
	 * ModelAndView("/facility/otp"); }
	 */
	
	@RequestMapping("/facility/otp")
	public ModelAndView otp() {
		return new ModelAndView("/facility/otp");
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
			e.printStackTrace();
		}
		
		String redirectUrl = request.getScheme() + "://" + request.getServerName();
		return new ModelAndView("redirect:"+redirectUrl);
	}
	
	@RequestMapping(value = "/keepSignIn", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createStatusMaster(HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean ();
		responseBean.setStatus(ResponseStatus.SUCCESS);
		return responseBean;
    }
  
	@RequestMapping("/accessPage")
	public ModelAndView accessPage() {
		return new ModelAndView("accessPage");
	}
	
	
	@RequestMapping("/home")
	public ModelAndView home() {
		User user = sessionUserBean.getUser();
		return new ModelAndView("home","data",user);
	}

	@RequestMapping("/pageAction")
	public ModelAndView pageAction() {
		return new ModelAndView("facility/pageAction");
	}

	@RequestMapping("/page")
	public ModelAndView page() {
		return new ModelAndView("facility/page");
	}

	@RequestMapping("/branch")
	public ModelAndView branch() {
		return new ModelAndView("facility/branch");
	}

	@RequestMapping("/validation")
	public ModelAndView validation() {
		return new ModelAndView("bulk/validation");
	}

	@RequestMapping("/role")
	public ModelAndView role() {
		return new ModelAndView("facility/role");
	}

	@RequestMapping("/bulkValidation")
	public ModelAndView bulkValidation() {
		return new ModelAndView("bulk/bulkValidation");
	}

	@RequestMapping("/bulkHeader")
	public ModelAndView bulkHeader() {
		return new ModelAndView("bulk/bulkHeader");
	}

	@RequestMapping("/bulkMaster")
	public ModelAndView bulkMaster() {
		return new ModelAndView("bulk/bulkMaster");
	}

	@RequestMapping("/user")
	public ModelAndView user() {
		return new ModelAndView("facility/user");
	}

	@RequestMapping("setup/status/statusMaster")
	public ModelAndView statusMaster() {
		return new ModelAndView("setup/status/statusMaster");
	}

	@RequestMapping("setup/status/statusTransition")
	public ModelAndView statusTransition() {
		return new ModelAndView("setup/status/statusTransition");
	}

	@RequestMapping("setup/status/statusFlow")
	public ModelAndView statusFlow() {
		return new ModelAndView("setup/status/statusFlow");
	}

	@RequestMapping("/setting")
	public ModelAndView setting() {
		return new ModelAndView("facility/setting");
	}

	@RequestMapping("setup/client/client")
	public ModelAndView client() {
		return new ModelAndView("setup/client/client");
	}

	@RequestMapping("setup/client/clientRateList")
	public ModelAndView clientRateList() {
		return new ModelAndView("setup/client/clientRateList");
	}

	@RequestMapping("setup/courier/courier")
	public ModelAndView courier() {
		return new ModelAndView("setup/courier/courier");
	}

	@RequestMapping("setup/courier/courierRateList")
	public ModelAndView courierRateList() {
		return new ModelAndView("setup/courier/courierRateList");
	}

	@RequestMapping("/setup/masters/ratezone")
	public ModelAndView rateZone() {
		return new ModelAndView("setup/masters/ratezone");
	}

	@RequestMapping("/setup/masters/pincodegroup")
	public ModelAndView pincodeGroup() {
		return new ModelAndView("setup/masters/pincodegroup");
	}
	
	@RequestMapping("/setup/masters/producttype")
	public ModelAndView productType() {
		return new ModelAndView("setup/masters/producttype");
	}
	
	@RequestMapping("/setup/masters/pincodegroupzonematrix")
	public ModelAndView pincodeGroupZoneMatrix() {
		return new ModelAndView("setup/masters/pincodegroupzonematrix");
	}
	@RequestMapping("/setup/masters/awbseries")
	public ModelAndView awbSeries() {
		return new ModelAndView("setup/masters/awbSeries");
	}
	
	@RequestMapping("setup/coloader/coloader")	
	public ModelAndView coloader() {
		return new ModelAndView("setup/coloader/coloader");	
	}
	
	@RequestMapping("/setup/client/pincodeGroupCourierPriority")
	public ModelAndView pincodeGroupCourierPriority() {
		return new ModelAndView("setup/client/pincodeGroupCourierPriority");
	}
	
	
	@RequestMapping("setup/coloader/coloaderRateList")
	public ModelAndView coloaderRateList() {
		return new ModelAndView("setup/coloader/coloaderRateList");
	}

	@RequestMapping("bulkUpload")	
	public ModelAndView bulkUpload() {
		ModelAndView mv = new ModelAndView("bulk/bulkUpload");
		mv.addObject("bulkUploadBean",new BulkUploadBean());
		return mv;
	}
	
	@RequestMapping("/setup/masters/serviceablepincode")
	public ModelAndView serviceablePincode() {
		return new ModelAndView("setup/masters/serviceablepincode");
	}
	
	@RequestMapping("/setup/client/clientWarehouse")
	public ModelAndView clientWarehouse() {
		return new ModelAndView("setup/client/clientWarehouse");
	}
	
	@RequestMapping("/setup/saleOrder/generatePickUpRequest")
	public ModelAndView saleOrderPickupRequest() {
		return new ModelAndView("/saleOrder/generatePickUpRequest");
	}

	@RequestMapping("/saleOrder/intransitPickupRequest")
	public ModelAndView intransitPickupRequest() {
		return new ModelAndView("/saleOrder/intransitPickupRequest");
	}
	@RequestMapping("/saleOrder/cancelPickupRequest")
	public ModelAndView cancelPickupRequest() {
		return new ModelAndView("/saleOrder/cancelPickupRequest");
	}

	@RequestMapping("/branchRoute")
	public ModelAndView branchRoute() {
		return new ModelAndView("facility/branchroute");
	}
	
	@RequestMapping("/setup/saleOrder/pickupSheet")
	public ModelAndView pickupSheet() {
		return new ModelAndView("saleOrder/pickupSheet");
	}
	

	@RequestMapping("/courierServices/stagingSaleOrder")
	public ModelAndView stagingSaleOrder() {
		return new ModelAndView("courierServices/stagingSaleOrder");
	}
	
	@RequestMapping("/courierServices/stagingSaleOrderBulkUpload")
	public ModelAndView stagingSaleOrderBulkUpload() {
		return new ModelAndView("courierServices/stagingSaleOrderBulkUpload");
	}

	@RequestMapping("/setup/saleOrder/uploadlbh")
	public ModelAndView uploadLbh() {
		return new ModelAndView("saleOrder/uploadlbh");
	}
	
	@RequestMapping("/setup/saleOrder/3plAssignCourierToSaleOrder")
	public ModelAndView AssignCourierToSaleOrder() {
		return new ModelAndView("saleOrder/3plassigncouriertosaleorder");
	}

	@RequestMapping("/setup/saleOrder/printLabel")
	public ModelAndView printLabel(Model model) {
		User user = sessionUserBean.getUser();
		return new ModelAndView("saleOrder/printlabel","data",user);
	}

	@RequestMapping("/tracking")
	public ModelAndView trackingByAwb() {
		return new ModelAndView("bmpTracking/tracking");
	}
	
	@RequestMapping("/drs/createDrsPage")
	public ModelAndView createDrsPage() {
		return new ModelAndView("drs/createDrs");
	}
	
	@RequestMapping("/drs/intransitDrs")
	public ModelAndView intransitDrs() {
		String deliveredKey = messageSource.getMessage(GlobalConstant.DELIVERED, null, null).trim();
		String upDeliveredKey = messageSource.getMessage(GlobalConstant.UNDELIVERD_RETURN, null, null).trim();
		String rescheduleKey = messageSource.getMessage(GlobalConstant.DRS_RESCHEDULE_DATE, null, null).trim();
		Map<String,String> map  = new HashMap<String,String>();
		map.put("delivered", deliveredKey);
		map.put("unDelivered", upDeliveredKey);
		map.put("rescheduleKey", rescheduleKey);
		return new ModelAndView("drs/intransitDrs","data",map);
	}
	
	@RequestMapping("/drs/pendingForPodDrs")
	public ModelAndView pendingForPodDrs() {
		String rescheduleKey = messageSource.getMessage(GlobalConstant.DRS_RESCHEDULE_DATE, null, null).trim();
		Map<String,String> map  = new HashMap<String,String>();
		map.put("rescheduleKey", rescheduleKey);
		return new ModelAndView("drs/pendingForPodDrs","data",map);
	}
	
	@RequestMapping("/drs/closeDrsView")
	public ModelAndView closeDrsView() {
		String rescheduleKey = messageSource.getMessage(GlobalConstant.DRS_RESCHEDULE_DATE, null, null).trim();
		Map<String,String> map  = new HashMap<String,String>();
		map.put("rescheduleKey", rescheduleKey);
		return new ModelAndView("drs/closeDrsView","data",map);
	}
	
	@RequestMapping("/drs/shipmentReadyForDrs")
	public ModelAndView shipmentReadyForDrs() {
		return new ModelAndView("drs/shipmentReadyForDrs");
	}
	
	@RequestMapping("/courierServices/packetInscan")
	public ModelAndView packetInscan() {
		String selfLogisticKey = messageSource.getMessage(GlobalConstant.SELF_LOGISTIC_KEY, null, null).trim();
		return new ModelAndView("courierServices/packetInscan","data",selfLogisticKey);
	}
	
	@RequestMapping("/setup/bag/readyForBagging")
	public ModelAndView readyForBagging() {
		return new ModelAndView("bag/readyForBagging");
	}
	
	@RequestMapping("/bag/createBag")
	public ModelAndView createBag() {
		return new ModelAndView("bag/createBag");
	}
	
	@RequestMapping("/bag/readyForDebag")
	public ModelAndView readyForDeBag() {
		return new ModelAndView("bag/readyForDebag");
	}
	
	@RequestMapping("/manifest/inComingManifest")
	public ModelAndView inComingManifest() {
		return new ModelAndView("manifest/inComingManifestList");
	}
	
	@RequestMapping("/manifest/inScanManifest")
	public ModelAndView inscanManifest() {
		return new ModelAndView("manifest/inScanManifest");
	}
	
	@RequestMapping("/threePl/handoverTo3pl")
	public ModelAndView handoverTo3pl() {
		return new ModelAndView("threePl/handoverTo3pl");
	}
	
	@RequestMapping("/manifest/createManifest")
	public ModelAndView createManifest() {
		return new ModelAndView("manifest/createManifest");
	}
	
	@RequestMapping("/manifest/intransitManifest")
	public ModelAndView intransitManifest() {
		return new ModelAndView("manifest/intransitManifest");
	}
	@RequestMapping("/threePl/threePlDocketList")
	public ModelAndView threePlDocketList() {
		return new ModelAndView("threePl/threePlDocketList");
	}
    
	@RequestMapping("/bag/missingBag")
	public ModelAndView missingBag() {
		return new ModelAndView("bag/missingBag");
	}
	
	@RequestMapping("/saleOrder/missingPacket")
	public ModelAndView missingPacket() {
		return new ModelAndView("saleOrder/missingPacket");
	}
	
	@RequestMapping("/bag/debag")
	public ModelAndView debag() {
		String selfLogintic = messageSource.getMessage(GlobalConstant.SELF_LOGISTIC_KEY, null, null);
		return new ModelAndView("bag/debag","data",selfLogintic.trim());
	}
	
	@RequestMapping("bag/debagReport")
	public ModelAndView debagReport() {
		return new ModelAndView("bag/debagReport");
	}
	
	@RequestMapping("manifest/missingManifest")
	public ModelAndView missingManifest() {
		return new ModelAndView("manifest/missingManifest");
	}
	
	@RequestMapping("/bag/pendingBagForManifest")
	public ModelAndView pendingBagForManifest() {
		return new ModelAndView("bag/pendingBagForManifest");
	}
	
	@RequestMapping("/courierServices/packetSoftDataNotReceivedReport")
	public ModelAndView packetSoftDataNotRecivedReport() {
		return new ModelAndView("courierServices/packetSoftDataNotReceivedReport");
	}

	@RequestMapping("/threePl/pendingFor3PLHandoverReport")
	public ModelAndView pendingFor3PLHandoverReport() {
		return new ModelAndView("saleOrder/pendingFor3PLHandoverReport");
	}
	
	@RequestMapping("/threePl/threePlAwbNumberNotAssigneReport")
	public ModelAndView threePlAwbNumberNotAssigneReport() {
		return new ModelAndView("saleOrder/threePlAwbNumberNotAssigneReport");
	}

	@RequestMapping("/saleOrder/closePickupSheetReport")
	public ModelAndView closePickupSheetReport() {
		String pickupCloseKey = messageSource.getMessage(GlobalConstant.PICKUP_REQUEST_CLOSE, null, null);
		String pickupOpenKey = messageSource.getMessage(GlobalConstant.PICKUP_REQUEST_OPEN, null, null);
		Map<String, String> map  = new HashMap<String, String>();
		map.put("pick", pickupCloseKey.trim());
		map.put("notPick", pickupOpenKey.trim());
		return new ModelAndView("saleOrder/closePickupSheetReport","data",map);
	}
	

	@RequestMapping("/bag/closeBagReport")
	public ModelAndView closeBagReport() {
		return new ModelAndView("bag/closeBagReport");
	}
	
	@RequestMapping("/manifest/closeManifestReport")
	public ModelAndView closeManifestReport() {
		return new ModelAndView("manifest/closeManifestReport");
	}
	
	@RequestMapping("/courierServices/closePacketReport")
	public ModelAndView closePacketReport() {
		return new ModelAndView("courierServices/closePacketReport");
	}
	
	@RequestMapping("/setup/saleOrder/rtoPackets")
	public ModelAndView rtoPackets() {
		return new ModelAndView("/saleOrder/rtoPackets");
	}
	
	@RequestMapping("/saleOrder/intransitPickupSheet")
	public ModelAndView intransitPickupSheet() {
		String pickupCloseKey = messageSource.getMessage(GlobalConstant.PICKUP_REQUEST_CLOSE, null, null);
		String pickupOpenKey = messageSource.getMessage(GlobalConstant.PICKUP_REQUEST_OPEN, null, null);
		Map<String, String> map  = new HashMap<String, String>();
		map.put("pick", pickupCloseKey.trim());
		map.put("notPick", pickupOpenKey.trim());
		return new ModelAndView("saleOrder/intransitPickupSheet","data",map);
	}
	
	@RequestMapping("/saleOrder/readyForInternalTransfer")
	public ModelAndView readyForInternalTransfer() {
		return new ModelAndView("saleOrder/readyForInternalTransfer");
	}
	
	@RequestMapping("/drs/branchCodCashClosing")
	public ModelAndView branchCodCashClosing () {
		return new ModelAndView("drs/branchCodCashClosing");
	}
	
	@RequestMapping("/drs/branchCodBankDepositDetails")
	public ModelAndView banckDepositDetails() {
		return new ModelAndView("drs/branchCodBankDepositDetails");
	}
	
	@RequestMapping("/drs/branchCodOpenTransaction")
	public ModelAndView branchCodOpenTransaction() {
		return new ModelAndView("drs/branchCodOpenTransaction");
	}
	
	@RequestMapping("/drs/branchCodCloseTransaction")
	public ModelAndView branchCodCloseTransaction() {
		return new ModelAndView("drs/branchCodCloseTransaction");
	}
	
	@RequestMapping("/courierServices/readyForInscan")
	public ModelAndView readyForInscan() {
		return new ModelAndView("courierServices/readyForInscan");
	}
	
	@RequestMapping("/report/report")
	public ModelAndView saleOrderReport() {
		return new ModelAndView("report/report");
	}
	
	@RequestMapping("/alertMaster")
	public ModelAndView alertMaster() {
		return new ModelAndView("facility/alertMaster");
	}
	
	@RequestMapping("/profile")
	public ModelAndView profile() {
		
		return new ModelAndView("myAccount/profile");
	}
	
	@RequestMapping("/changePassword")
	public ModelAndView changePassword() {
		return new ModelAndView("myAccount/changePassword");
	}
	
	@RequestMapping("/trackStatus")
	public ModelAndView trackStatus() {
		return new ModelAndView("saleOrder/trackStatus");
	}
	
	@RequestMapping("support/support")
	public ModelAndView support() {
		return new ModelAndView("support/support");
	}
	
	@RequestMapping("/saleOrder/remittance")
	public ModelAndView getRemittance() {
		return new ModelAndView("saleOrder/remittance");
	}
	
	@RequestMapping("/saleOrder/initiateRTO")
	public ModelAndView saleorderPackets() {
		return new ModelAndView("saleOrder/initiateRTO");
	}
	
	@RequestMapping("/support/updatePacketHistory")
	public ModelAndView editAwbToPacketDetail() {
		return new ModelAndView("support/updatePacketHistory");
	}

	@RequestMapping("/saleOrder/remittanceBankDeposit")
	public ModelAndView getRemittanceBankDeposit() {
		return new ModelAndView("saleOrder/remittanceBankDeposit");
	}
	
	@RequestMapping("/saleOrder/remittanceClose")
	public ModelAndView getRemittanceClose() {
		return new ModelAndView("saleOrder/remittanceClose");
	}
	
	@RequestMapping("/saleOrder/remittanceDispute")
	public ModelAndView getRemittenceDispute() {
		return new ModelAndView("saleOrder/remittanceDispute");
	}

	@RequestMapping("/saleOrder/pending3PLRemittance")
	public ModelAndView pending3PLRemittance() {
		return new ModelAndView("saleOrder/pending3PLRemittance");
	}
	
	@RequestMapping("/saleOrder/upload3PLRemmittance")
	public ModelAndView upload3PLRemmittance() {
		return new ModelAndView("saleOrder/upload3PLRemmittance");
	}
	
	@RequestMapping("/saleOrder/redirectOrder")
	public ModelAndView redirectOrder() {
		return new ModelAndView("saleOrder/redirectOrder");
	}
	
	@RequestMapping("/threePl/update3PlStatus")
	public ModelAndView update3PlStatus() {
		return new ModelAndView("threePl/update3PlStatus");
	}
	
	@RequestMapping("/drs/searchPOD")
	public ModelAndView searchPOD() {
		return new ModelAndView("drs/searchPod");
	}
	
	@RequestMapping("/setup/client/clientTracking")
	public ModelAndView clientTracking() {
		return new ModelAndView("dashboard/clientTracking");
	}
	@RequestMapping("/setup/client/clientTrackingNew")
	public ModelAndView clientTrackingNew() {
		return new ModelAndView("dashboard/clientTrackingWithPartner");
	}
	
	@RequestMapping("/staticsReport")
	public ModelAndView staticsReport() {
		return new ModelAndView("threePl/staticsReport");
	}
	
	@RequestMapping("setup/courier/courierPriority")
	public ModelAndView courierPriority() {
		return new ModelAndView("setup/courier/courierPriority");
	}
	
	@RequestMapping("/getAllCloseSaleOrderPickupRequest")
	public ModelAndView getAllCloseSaleOrderPickupRequest() {
		return new ModelAndView("saleOrder/closeSaleOrderPickupRequest");
	}
	
	@RequestMapping("/clientProductCourierPriority")
	public ModelAndView getClientProductCourierPriority() {
		return new ModelAndView("setup/client/clientProductCourierPriority");
	}
	
	@RequestMapping("/courierPriorityTemplate")
	public ModelAndView getAllCourierPriorityTemplate() {
		return new ModelAndView("setup/courier/CourierPriorityTemplate");
	}

	@RequestMapping("/saleOrder/orderCancelRequest")
	public ModelAndView orderCancelRequest() {
		return new ModelAndView("saleOrder/orderCancelRequest");
	}
	
	@RequestMapping("/saleOrder/pendingRtoReceivedReport")
	public ModelAndView pendingRtoReceivedReport() {
		return new ModelAndView("saleOrder/pendingRtoReceivedReport");
	}
	
	@RequestMapping("/saleOrder/scanRtoReceivedPacket")
	public ModelAndView scanRtoReceivedPacket() {
		//return new ModelAndView("saleOrder/oldScanRtoReceivedPacket");
		return new ModelAndView("saleOrder/scanRtoReceivedPacket");
	}
	
	@RequestMapping("/drs/pendingShipmentForCODReceive")
	public ModelAndView pendingShipmentForCODReceive() {
		return new ModelAndView("drs/pendingShipmentForCODReceive");
	}
	
	@RequestMapping("/drs/pendingShipmentForCODDeposit")
	public ModelAndView pendingShipmentForCODDeposit() {
		return new ModelAndView("drs/pendingShipmentForCODDeposit");
	}
	
	@RequestMapping("/drs/pendingShipmentForCODVerify")
	public ModelAndView pendingShipmentForCODVerify() {
		return new ModelAndView("drs/pendingShipmentForCODVerify");
	}
	
	@RequestMapping("/drs/shipmentForCODVerified")
	public ModelAndView shipmentForCODVerified() {
		return new ModelAndView("drs/shipmentForCODVerified");
	}
	
	@RequestMapping("/report/lastThreeStatusReport")
	public ModelAndView lastThreeStatusReport() {
		return new ModelAndView("report/lastThreeStatusReport");
	}
	
	@RequestMapping("/setup/masters/branchStockRecon")
	public ModelAndView branchStockRecon() {
		return new ModelAndView("setup/masters/branchStockRecon");
	}
	
	@RequestMapping("/report/branchStockReconCloseReport")
	public ModelAndView branchStockReconCloseReport() {
		return new ModelAndView("report/branchStockReconCloseReport");
	}
	
	@RequestMapping("/setup/masters/qcMaster")
	public ModelAndView qcMaster() {
		return new ModelAndView("/setup/masters/qcMaster");
	}
	
	@RequestMapping("/setup/masters/qcCheckList")
	public ModelAndView qcCheckList() {
		return new ModelAndView("/setup/masters/qcCheckList");
	}

	@RequestMapping("/cacheble")
	public ModelAndView cacheble() {
		return new ModelAndView("/support/cacheble");
	}
	
	@RequestMapping("/saleOrder/pendingForInternalTransferRto")
	public ModelAndView pendingForInternalTransfer() {
		return new ModelAndView("saleOrder/pendingForInternalTransferRto");
	}
	
	@RequestMapping("/error/{msg}")
	public ModelAndView error(@PathVariable("msg") String msg) {
		String errorMsg = msg;
		return new ModelAndView("error","data",errorMsg);
	}
	
	@RequestMapping("/setup/saleOrder/pendingRtoConfirmPackets")
	public ModelAndView pendingRtoConfirmPackets() {
		return new ModelAndView("/saleOrder/penddingRtoCofirmPacketsReport");
	}
	
	@RequestMapping("/setup/saleOrder/uploadPickupRequest")
	public ModelAndView uploadPickupRequest() {
		return new ModelAndView("saleOrder/uploadPickupRequest");
	}
	
	@RequestMapping("/support/supportInscan")
	public ModelAndView supportInscan() {
		return new ModelAndView("support/bulkInscan");
	}
	
	@RequestMapping("/report/pendingShipmentWeight")
	public ModelAndView pendingShipmentWeight() {
		return new ModelAndView("report/pendingShipmentWeight");
	}
	
	@RequestMapping("/saleOrder/deletedSaleOrderReport")
	public ModelAndView deletedSaleOrderReport() {
		return new ModelAndView("saleOrder/deletedSaleOrderReport");
	}
	
	@RequestMapping("/courier/serviceabilityCheck")
	public ModelAndView serviceabilityCheck() {
		return new ModelAndView("courierServices/serviceabilityCheck");
	}
	@RequestMapping("/courier/clientServiceabilityCheck")
	public ModelAndView clientServiceabilityCheck() {
		return new ModelAndView("courierServices/clientServiceabilityCheck");
	}
	
	@RequestMapping("/saleOrder/manifestHandoverReport")
	public ModelAndView manifestHandoverReport() {
		return new ModelAndView("saleOrder/manifestHandoverReport");
	}
	
	@RequestMapping("/support/reattemptBookingCanselPickup")
	public ModelAndView reattemptBookingCanselPickup() {
		return new ModelAndView("support/reattemptBookingCanselPickup");
	}
	
	@RequestMapping("/support/vendorOrderReadyToPush")
	public ModelAndView vendorOrderReadyToPush() {
		return new ModelAndView("support/vendorOrderReadyToPush");
	}
	
	@RequestMapping("/saleOrder/pickupSheetPod")
	public ModelAndView pickupSheetPod() {
		String pickupCloseKey = messageSource.getMessage(GlobalConstant.PICKUP_REQUEST_CLOSE, null, null);
		String pickupOpenKey = messageSource.getMessage(GlobalConstant.PICKUP_REQUEST_OPEN, null, null);
		Map<String, String> map  = new HashMap<String, String>();
		map.put("pick", pickupCloseKey.trim());
		map.put("notPick", pickupOpenKey.trim());
		return new ModelAndView("saleOrder/pickupSheetPod","data",map);
	}
	
	@RequestMapping("/support/vendorSuccessLogs")
	public ModelAndView vendorSuccessLogs() {
		return new ModelAndView("support/vendorSuccessLogs");
	}
	
	@RequestMapping("/support/vendorErrorLogs")
	public ModelAndView vendorErrorLogs() {
		return new ModelAndView("support/vendorErrorLogs");
	}
	
	@RequestMapping("/support/changeDestinationPincode")
	public ModelAndView changeDestinationPincode() {
		return new ModelAndView("support/changeDestinationPincode");
	}
	
	@RequestMapping("/setup/api/apiConfig")
	public ModelAndView apiConfig() {
		return new ModelAndView("setup/api/apiConfig");
	}
	
	@RequestMapping("/setup/api/apiStatusMapping")
	public ModelAndView apiStatusMapping() {
		return new ModelAndView("setup/api/apiStatusMapping");
	}
	
	@RequestMapping("/support/payModeChange")
	public ModelAndView payModeChange() {
		return new ModelAndView("support/payModeChange");
	}
	
	@RequestMapping("/report/reportMaster")
	public ModelAndView reportMaster() {
		return new ModelAndView("report/reportMaster");
	}
	@RequestMapping("/support/changeDestinationAddress")
	public ModelAndView changeDestinationAddress() {
		return new ModelAndView("support/changeDestinationAddress");
	}
	
	@RequestMapping("/saleOrder/packetOnHold")
	public ModelAndView packetOnHold() {
		return new ModelAndView("saleOrder/packetOnHold");
	}
	
	@RequestMapping("/setup/client/clientCategoryMapping")
	public ModelAndView clientCategoryMapping() {
		return new ModelAndView("setup/client/clientCategoryMapping");
	}
	
	@RequestMapping("/report/sysReports")
	public ModelAndView sysReports() {
		return new ModelAndView("report/sysReports");
	}
	
	@RequestMapping("/support/test")
	public ModelAndView test() {
		return new ModelAndView("support/test");
	}
	
	@RequestMapping("/saleOrder/reconnectRequest")
	public ModelAndView reconnect() {
		return new ModelAndView("saleOrder/reconnectRequest");
	}
	
	@RequestMapping("/saleOrder/unClaimed")
	public ModelAndView unClaimed() {
		return new ModelAndView("saleOrder/unClaimed");
	}
	
	@RequestMapping("/support/orderPushErrorLogs")
	public ModelAndView orderPushErrorLogs() {
		return new ModelAndView("support/orderPushErrorLogs");
	}
	
	@RequestMapping("/support/orderPushSuccessLogs")
	public ModelAndView orderPushSuccessLogs() {
		return new ModelAndView("support/orderPushSuccessLogs");
	}
	
	@RequestMapping("/support/alertErrorLogs")
	public ModelAndView alertErrorLogs() {
		return new ModelAndView("support/alertErrorLogs");
	}
	
	@RequestMapping("/support/alertSuccessLogs")
	public ModelAndView alertSuccessLogs() {
		return new ModelAndView("support/alertSuccessLogs");
	}
	
	@RequestMapping("/support/statusPushErrorLogs")
	public ModelAndView statusPushErrorLogs() {
		return new ModelAndView("support/statusPushErrorLogs");
	}
	
	@RequestMapping("/support/statusPushSuccessLogs")
	public ModelAndView statusPushSuccessLogs() {
		return new ModelAndView("support/statusPushSuccessLogs");
	}
	
	@RequestMapping("/alertSender")
	public ModelAndView alertSender() {
		return new ModelAndView("facility/alertSender");
	}
	
	@RequestMapping("/report/bagGeneratedShipmentReport")
	public ModelAndView bagGeneRatedShipment() {
		return new ModelAndView("report/bagGeneratedShipmentReport");
	}
	
	@RequestMapping("/report/manifestGeneratedShipmentReport")
	public ModelAndView manifestGeneratedShipmentReport() {
		return new ModelAndView("report/manifestGeneratedShipmentReport");
	}
	
	@RequestMapping("/report/drsGeneratedShipmentReport")
	public ModelAndView drsGeneratedShipmentReport() {
		return new ModelAndView("report/drsGeneratedShipmentReport");
	}
	
	@RequestMapping("/report/threePlManifestGeneratedShipmentReport")
	public ModelAndView threePlManifestGeneratedShipmentReport() {
		return new ModelAndView("report/threePlManifestGeneratedShipmentReport");
	}
	
	@RequestMapping("/report/missingPacketReport")
	public ModelAndView missingPacketReport() {
		return new ModelAndView("report/missingPacketReport");
	}
	
	@RequestMapping("/report/rtoDeclaredShipmentReport")
	public ModelAndView rtoDeclaredShipmentReport() {
		return new ModelAndView("report/rtoDeclaredShipmentReport");
	}
	
	@RequestMapping("/saleOrder/ctocorder")
	public ModelAndView c2cOrder() {
		return new ModelAndView("saleOrder/c2cOrder");
	}
	
	@RequestMapping("setup/client/rateListTemplate")
	public ModelAndView rateListTemplate() {
		return new ModelAndView("setup/client/rateListTemplate");
	}
	
	@RequestMapping("setup/client/clientCourierRateListTemplate")
	public ModelAndView clientCourierRateListTemplate() {
		return new ModelAndView("setup/client/clientCourierRateListTemplate");
	}
	
	@RequestMapping("setup/client/clientFinance")
	public ModelAndView clientFinance() {
		String staticContentPath = messageSource.getMessage(MessageConstant.STATIC_CONTENT_PATH, null, null);
		String filePath = staticContentPath + "/doc/client/";
		return new ModelAndView("setup/client/clientFinance","filePath",filePath);
	}
	
	@RequestMapping("/courierServices/clientSKUWeigthLookerBulkUpload")
	public ModelAndView clientSKUWeigthLookerBulkUpload() {
		return new ModelAndView("courierServices/clientSKUWeigthLookerBulkUpload");
	}
	
	@RequestMapping("setup/client/clientBilling")
	public ModelAndView clientBilling() {
		return new ModelAndView("setup/client/clientBilling");
	}
	
	@RequestMapping("setup/client/clientBillingNew")
	public ModelAndView clientBillingNew() {
		return new ModelAndView("setup/client/clientBillingNew");
	}
	
	@RequestMapping("setup/client/clientBillBankDeposit")
	public ModelAndView billingBankDeposit() {
		return new ModelAndView("setup/client/clientBillBankDeposit");
	}
	
	@RequestMapping("setup/client/billingClosed")
	public ModelAndView billingClosed() {
		return new ModelAndView("setup/client/billingClosed");
	}
	
	@RequestMapping("setup/client/billingDispute")
	public ModelAndView billingDispute() {
		return new ModelAndView("setup/client/billingDispute");
	}
	
	@RequestMapping("setup/client/clientBillApproved")
	public ModelAndView clientBillApproved() {
		return new ModelAndView("setup/client/clientBillApproved");
	}
	
	@RequestMapping("setup/reasonEngine")
	public ModelAndView reasonEngine() {
		return new ModelAndView("facility/reasonEngine");
	}
	
	@RequestMapping("/manualNotification")
	public ModelAndView manualNotification() {
		return new ModelAndView("facility/manualNotification");
	}
	
	@RequestMapping("/support/clientAccountLog")
	public ModelAndView clientAccountLog() {
		return new ModelAndView("support/clientAccountLog");
	}
	@RequestMapping("/support/gatewayLog")
	public ModelAndView gatewayLog() {
		return new ModelAndView("support/gatewayLog");
	}
	
	@RequestMapping("/clientAccount")
	public ModelAndView clientAccount(HttpServletRequest request) {
		Map<String, String> map = OrderTransactionType.getKeyVal();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return new ModelAndView("setup/client/clientAccount", "data", jsonString);	
	}
	
	@RequestMapping("/pay")
	public ModelAndView pay(HttpServletRequest request) {
		return new ModelAndView("wallet/ebs/pay");
	}
	
	@RequestMapping("/report/rtoReceivingErrorsReport")
	public ModelAndView rtoReceivingErrorsReport() {
		return new ModelAndView("report/rtoReceivingErrorsReport");
	}
	
	@RequestMapping("/saleOrder/threePlRtoReceived")
	public ModelAndView threePlRtoReceived() {
		return new ModelAndView("saleOrder/threePlRtoReceived");
	}
	
	@RequestMapping("/saleOrder/partnerPendency")
	public ModelAndView getPartnerPendency() {
		User user = sessionUserBean.getUser();
		boolean filterAlloude = false;
		if(user != null){
			if(user.getAdmin() != null && user.getAdmin()){
				filterAlloude  = true;
			}
			if(user.getRolesMap().containsKey(GlobalConstant.PARTENER_PENDENCY_FILTER_ROLE)){
				filterAlloude  = true;
			}
		}
		
		return new ModelAndView("saleOrder/partnerPendency", "data", filterAlloude);
	}
	
	@RequestMapping("/incentive/incentive")
	public ModelAndView incentive() {
		return new ModelAndView("/incentive/incentive");
	}
	
	@RequestMapping("/incentive/approvedIncentive")
	public ModelAndView approvedIncentive() {
		return new ModelAndView("/incentive/approvedIncentive");
	}
	
	@RequestMapping("/report/closeIncentiveReport")
	public ModelAndView closeIncentiveReport() {
		return new ModelAndView("report/closeIncentiveReport");
	}
	
	@RequestMapping("incentive/incentiveSettings")
	public ModelAndView incentiveSettings() {
		return new ModelAndView("incentive/incentiveSettings");
	}
	
	@RequestMapping("/saleOrder/rtoReceivedErrorPackets")
	public ModelAndView rtoReceivedErrorPackets() {
		return new ModelAndView("saleOrder/rtoReceivedErrorPackets");
	}
	@RequestMapping("/registerComplaint")
	public ModelAndView registerComplaint() {
		return new ModelAndView("setup/client/registerComplaint");
	}
	@RequestMapping("/saleOrder/pickSheetGeneratedShipment")
	public ModelAndView pickSheetGeneratedShipment() {
		return new ModelAndView("saleOrder/pickSheetGeneratedShipment");
	}
	
	@RequestMapping("/saleOrder/rtoRejectedShipment")
	public ModelAndView rtoRejectedShipments() {
		return new ModelAndView("saleOrder/rtoRejectedShipment");
	}
	@RequestMapping("/saleOrder/3plPickupRequest")
	public ModelAndView threeplPickupRequest() {
		return new ModelAndView("saleOrder/3plPickupRequest");
	}
	
	@RequestMapping("/c2cPricing")
	public ModelAndView c2cPricing() {
		return new ModelAndView("facility/c2cPricing");
	}
	
	@RequestMapping("/threePl/3PLManifestPOD")
	public ModelAndView threePlManifestPod() {
		return new ModelAndView("threePl/3PLManifestPOD");
	}
	
	@RequestMapping("/contactUsEnquiry")
	public ModelAndView contactUsEnquiry() {
		return new ModelAndView("facility/contactUsEnquiry");
	}
	
	@RequestMapping("/newContactUsEnquiry")
	public ModelAndView newContactUsEnquiry() {
		return new ModelAndView("facility/newContactUsEnquiry");
	}
	
	@RequestMapping("/support/webUserAccountLog")
	public ModelAndView webUserAccountLog() {
		return new ModelAndView("support/c2c/webUserAccountLog");
	}
	
	@RequestMapping("/smsMailMaster")
	public ModelAndView smsMailMaster() {
		return new ModelAndView("facility/smsMailMaster");
	}
	
	@RequestMapping("/drs/reAttemptShipmentReadyForDrs")
	public ModelAndView reAttemptShipmentReadyForDrs() {
		return new ModelAndView("drs/reAttemptShipmentReadyForDrs");
	}
	
	@RequestMapping("support/updateDetailsInBulk")
	public ModelAndView updateDetailsInBulk() {
		return new ModelAndView("support/updateDetailsInBulk");
	}
	
	@RequestMapping("setup/client/updateBill")
	public ModelAndView updateBill() {
		return new ModelAndView("setup/client/updateBill");
	}
	
	@RequestMapping("support/updateDeliveredPersonDetails")
	public ModelAndView updateDeliveredPersonDetails() {
		return new ModelAndView("support/updateDeliveredPersonDetails");
	}
	
	@RequestMapping("support/reconnectBulk")
	public ModelAndView reconnectBulk() {
		return new ModelAndView("support/reconnectBulk");
	}
	
	@RequestMapping("support/updateCourierAwb")
	public ModelAndView updateCourierAwb() {
		return new ModelAndView("support/updateCourierAwb");
	}
	
	@RequestMapping("support/redirectBulk")
	public ModelAndView redirectBulk() {
		return new ModelAndView("support/redirectBulk");
	}
	
	@RequestMapping("systemCalling/campaign")
	public ModelAndView campaign() {
		return new ModelAndView("systemCalling/campaign");
	}
	
	@RequestMapping("systemCalling/callManifest")
	public ModelAndView callManifest() {
		return new ModelAndView("systemCalling/callManifest");
	}
	
	@RequestMapping("systemCalling/createIvrNumber")
	public ModelAndView createIvrNumber() {
		return new ModelAndView("systemCalling/createIvrNumber");
	}
	
	@RequestMapping("systemCalling/publishedCallManifest")
	public ModelAndView publishedCallManifest() {
		return new ModelAndView("systemCalling/publishedCallManifest");
	}
	
	@RequestMapping("systemCalling/closedCallManifest")
	public ModelAndView closedCallManifest() {
		return new ModelAndView("systemCalling/closedCallManifest");
	}
	
	@RequestMapping("systemCalling/outgoingCallLogs")
	public ModelAndView outgoingCallLogs() {
		return new ModelAndView("systemCalling/outgoingCallLogs");
	}
	
	@RequestMapping("saleOrder/downloadShipmentPOD")
	public ModelAndView downloadShipmentPOD() {
		return new ModelAndView("saleOrder/downloadShipmentPOD");
	}
	
	@RequestMapping("setup/client/clientServiceablePincode")
	public ModelAndView clientServiceablePincode() {
		return new ModelAndView("setup/client/clientServiceablePincode");
	}
	
	@RequestMapping("systemCalling/greetingSmsTemplate")
	public ModelAndView greetingSmsTemplate() {
		return new ModelAndView("systemCalling/greetingSmsTemplate");
	}
	
	@RequestMapping("/setup/masters/changeSeriesProductType")
	public ModelAndView changeSeriesProductType() {
		return new ModelAndView("setup/masters/changeSeriesProductType");
	}
	
	@RequestMapping("saleOrder/packetOnHoldReport")
	public ModelAndView getAllPacketOnHoldReport() {
		return new ModelAndView("saleOrder/packetOnHoldReport");
	}
	
	@RequestMapping("saleOrder/codAwaitedBranchEndReport")
	public ModelAndView getAllCodAwaitedBranchEnd() {
		return new ModelAndView("saleOrder/codAwaitedBranchEndReport");
	}
	
	@RequestMapping("systemCalling/numberMetaData")
	public ModelAndView numberMetaData() {
		return new ModelAndView("systemCalling/numberMetaData");
	}
	
	@RequestMapping("/setup/client/clientCode")
	public ModelAndView clientCode() {
		return new ModelAndView("setup/client/clientCode");
	}
	
	@RequestMapping("setup/courier/serviceLevel")
	public ModelAndView serviceLevel() {
		return new ModelAndView("setup/courier/serviceLevel");
	}
	
	@RequestMapping("saleOrder/rtoReceivedTerminalShipment")
	public ModelAndView getAllRtoReceivedTerminalShipment() {
		return new ModelAndView("saleOrder/rtoReceivedTerminalShipment");
	}
	
	@RequestMapping("systemCalling/sendManualSms")
	public ModelAndView sendManualSms() {
		return new ModelAndView("systemCalling/sendManualSms");
	}
	
	@RequestMapping("/courierServices/orderConverterBulkUpload")
	public ModelAndView orderConverterBulkUpload() {
		return new ModelAndView("courierServices/orderConverterBulkUpload");
	}
	
	@RequestMapping("/saleOrder/verifyOrderQC")
	public ModelAndView verifyOrderQC() {
		return new ModelAndView("saleOrder/verifyOrderQC");
	}
	
	@RequestMapping("/saleOrder/clientQcOrders")
	public ModelAndView clientQcOrders() {
		return new ModelAndView("saleOrder/clientQcOrders");
	}
	
	@RequestMapping("/drs/awaitingClientInstruction")
	public ModelAndView awaitingClientInstruction() {
		return new ModelAndView("drs/awaitingClientInstruction");
	}
	
	@RequestMapping("/saleOrder/downloadPodBulk")
	public ModelAndView downloadPodBulk() {
		return new ModelAndView("saleOrder/downloadPodBulk");
	}
	
	@RequestMapping("/report/reportScheduler")
	public ModelAndView reportScheduler() {
		return new ModelAndView("report/reportScheduler");
	}
	
	@RequestMapping("/saleOrder/orderVerification")
	public ModelAndView orderVerification() {
		return new ModelAndView("saleOrder/orderVerification");
	}

	@RequestMapping("/saleOrder/userVerification")
	public ModelAndView userVerification() {
		return new ModelAndView("saleOrder/userVerification");
	}

	@RequestMapping("support/dataFetchErrorLogs")
	public ModelAndView dataFetchErrorLogs() {
		return new ModelAndView("support/dataFetchErrorLogs");
	}
	
	@RequestMapping("/drs/orderVerifyPendingForScanning")
	public ModelAndView orderVerifyPendingForScanning() {
		return new ModelAndView("/drs/orderVerifyPendingForScanning");
	}

	@RequestMapping("/saleOrder/podMismatchLogs")
	public ModelAndView podMismatchLogs() {
		return new ModelAndView("saleOrder/podMismatchLogs");
	}
	
	@RequestMapping("/saleOrder/openTeleCallingManifest")
	public ModelAndView openTeleCallingManifest() {
		return new ModelAndView("saleOrder/openTeleCallingManifest");
	}
	
	@RequestMapping("/saleOrder/publishedTeleCallingManifest")
	public ModelAndView publishedTeleCallingManifest() {
		return new ModelAndView("saleOrder/publishedTeleCallingManifest");
	}
	
	@RequestMapping("/saleOrder/closedTeleCallingManifest")
	public ModelAndView closedTeleCallingManifest() {
		return new ModelAndView("saleOrder/closedTeleCallingManifest");
	}
	
	@RequestMapping("/saleOrder/prepareCalling")
	public ModelAndView callVerification() {
		return new ModelAndView("saleOrder/prepareCalling");
	}

	@RequestMapping(value = "/saleOrder/uploadOrderPOD" , method = RequestMethod.GET)
	public ModelAndView uploadOrderPOD(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("/saleOrder/uploadOrderPOD");
		modelAndView.addObject("awbNumber", request.getParameter("awbNumber"));
		return  modelAndView;
	}
	
	@RequestMapping("/convertor")
	public ModelAndView convertor() {
		return new ModelAndView("convertor/convertor");
	}

	@RequestMapping("/convertorUpload")
	public ModelAndView convertorUpload() {
		return new ModelAndView("convertor/convertorUpload");
	}
	
	@RequestMapping("/saleOrder/orderSkuScan")
	public ModelAndView orderSkuScan() {
		return new ModelAndView("saleOrder/orderSkuScan");
	}
	
	@RequestMapping("/setup/client/clientProductSkuRate")
	public ModelAndView clientProductSkuRate() {
		return new ModelAndView("setup/client/clientProductSkuRate");
	}
	
	@RequestMapping("/feKyc")
	public ModelAndView feKyc() {
		return new ModelAndView("facility/feKyc");
	}
	
	@RequestMapping("/saleOrder/markPendingStatusPushed")
	public ModelAndView markPendingStatusPushed() {
		return new ModelAndView("/saleOrder/markPendingStatusPushed");
	}
	
	@RequestMapping("/drs/RalInvoiceDetails")
	public ModelAndView RalInvoiceDetails() {
		return new ModelAndView("drs/RalInvoiceDetails");
	}
	
	@RequestMapping("/manualRechargeClientAccount")
	public ModelAndView manualRechargeClientAccount() {
		return new ModelAndView("setup/client/manualRechargeClientAccount");
	}
	
	@RequestMapping("setup/client/client-new")
	public ModelAndView clientNew() {
		return new ModelAndView("setup/client/clientNew");
	}
	
	@RequestMapping("setup/courier/courierConfiguration")
	public ModelAndView courierConfiguration() {
		return new ModelAndView("setup/courier/courierConfiguration");
	}
	
	@RequestMapping("/threePl/clientHandoverTo3pl")
	public ModelAndView clientHandoverTo3pl() {
		return new ModelAndView("threePl/clientHandoverTo3pl");
	}
	
	@RequestMapping("/saleOrder/rateCalculator")
	public ModelAndView rateCalculator() {
		return new ModelAndView("saleOrder/rateCalculator");
	}
	
	@RequestMapping("/setup/masters/rateZoneNew")
	public ModelAndView ratezoneNew() {
		return new ModelAndView("setup/masters/rateZoneNew");
	}
	
	@RequestMapping("/setup/masters/rateZoneMatrix")
	public ModelAndView ratezoneMatrix() {
		return new ModelAndView("setup/masters/rateZoneMatrix");
	}
	
	@RequestMapping("/setup/masters/rateZoneType")
	public ModelAndView ratezoneType() {
		return new ModelAndView("setup/masters/rateZoneType");
	}
	
	@RequestMapping("/complain/agentAssigentComplainTable")
	public ModelAndView agentAssigentComplainTable() {
		return new ModelAndView("complain/agentAssigentComplainTable");
	}
	
	@RequestMapping("/complain/complainTable")
	public ModelAndView complainTable() {
		return new ModelAndView("complain/complainTable");
	}
	
	@RequestMapping("/complain/agentComplainTable")
	public ModelAndView agentComplainTable() {
		return new ModelAndView("complain/agentTable");
	}
	
	@RequestMapping("/support/clientSupport")
	public ModelAndView clientSupport() {
		return new ModelAndView("support/clientSupport");
	}
	
	@RequestMapping("/saleOrder/orderStatusDetails")
	public ModelAndView awbNumberTracking() {
		List<Settings> settings = settingsService.getSettingByType(GlobalConstant.CLIENT_ORDER_STATUS_TYPE);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(settings);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		settings = sortSettings(settings);
		Map<String,Object> map = new HashMap<>();
		map.put("settingList", settings);
		map.put("jsonObj", jsonString);
		return new ModelAndView("saleOrder/orderStatusDetails", "data",map );
	}
	
	private List<Settings> sortSettings (List<Settings> list){
		for(Settings settings : list) {
			try {
				settings.setExtra2(settings.getExtra2().trim());
				Integer integer = Integer.valueOf(settings.getExtra2());
			}catch (Exception e) {
				settings.setExtra2("0");
			}
		}
		Settings st[] = list.toArray(new Settings[list.size()]);
		for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
            	Settings temp = null;;
                if (Integer.valueOf(st[j].getExtra2()) < Integer.valueOf(st[i].getExtra2())) {
                    temp = st[i];
                    st[i] = st[j];
                    st[j] = temp;
                }
            }
        }
		return Arrays.asList(st);
	}
	
	
	@RequestMapping("/setup/client/billingOtherCharges")
	public ModelAndView billingOtherCharges() {
		return new ModelAndView("setup/client/billingOtherCharges");
	}
	
	@RequestMapping("/clientCourierPriority")
	public ModelAndView clientCourierPriority(HttpServletRequest request) {
		return new ModelAndView("setup/client/clientCourierPriority");	
	}
	
	@RequestMapping("setup/courier/rateCard") 
	public ModelAndView rateCard() {
	  return new ModelAndView("setup/courier/rateCard");
	}
	
	@RequestMapping("/support/apiDocSetup")
	public ModelAndView apiDocSetup() {
		return new ModelAndView("support/apiDocSetup");
	}

	@RequestMapping("setup/masters/authFieldMaster")
	public ModelAndView authFieldMaster() {
		return new ModelAndView("setup/masters/authFieldMaster");
	}
	
	@RequestMapping("setup/courier/courierAuthConfig")
	public ModelAndView courierAuthConfig() {
		return new ModelAndView("setup/courier/courierAuthConfig");
	}
	
	@RequestMapping("channel/addChannel")
	public ModelAndView channelMaster() {
		return new ModelAndView("channel/addChannel");
	}
	
	@RequestMapping("channel/channelAuthConfig")
	public ModelAndView channelAuthConfig() {
		return new ModelAndView("channel/channelAuthConfig");
	}
	
	@RequestMapping("/setup/wms/catalogue")
	public ModelAndView catalogue() {
		return new ModelAndView("setup/wms/catalogue");
	}
	
	@RequestMapping("/setup/wms/category")
	public ModelAndView category() {
		return new ModelAndView("setup/wms/category");
	}
	
	@RequestMapping("/setup/wms/stockTransferNote")
	public ModelAndView stockTransferNote() {
		return new ModelAndView("/setup/wms/stockTransferNote");
	}
	
	@RequestMapping("/setup/wms/stnApprove")
	public ModelAndView stnApprove() {
		return new ModelAndView("/setup/wms/stnApprove");
	}
	
	@RequestMapping("/setup/wms/closedStn")
	public ModelAndView closedStn() {
		return new ModelAndView("/setup/wms/closedStn");
	}

	@RequestMapping("/support/warehouseSuccessLog")
	public ModelAndView warehouseSuccessLog() {
		return new ModelAndView("support/warehouseSuccessLog");
	}

	@RequestMapping("/support/warehouseErrorLog")
	public ModelAndView warehouseErrorLog() {
		return new ModelAndView("support/warehouseErrorLog");
	}
	
	@RequestMapping("/channel/clientChannel")
	public ModelAndView clientChannel() {
		return new ModelAndView("channel/clientChannel");
	}

	@RequestMapping("/setup/courier/clientCourier")
	public ModelAndView clientCourier() {
		return new ModelAndView("setup/courier/clientCourier");
	}
	
	@RequestMapping("/support/warehousePendingPush")
	public ModelAndView warehousePendingPush() {
		return new ModelAndView("support/warehousePendingPush");
	}

	@RequestMapping("/setup/wms/supplier")
	public ModelAndView supplier() {
		return new ModelAndView("/setup/wms/supplier");
	}

	@RequestMapping("/channel/purchaseOrder")
	public ModelAndView purchaseorder() {
		return new ModelAndView("/channel/purchaseOrder");
	}

	@RequestMapping("/channel/keyGenerationHub")
	public ModelAndView keyGenerationHub() {
		return new ModelAndView("/channel/keyGenerationHub");
	}

	@RequestMapping("/channel/order")
	public ModelAndView order() {
		return new ModelAndView("/channel/order");
	}
	@RequestMapping("/channel/rtoOrder")
	public ModelAndView rtoOrder() {
		return new ModelAndView("/channel/rtoOrder");
		/*
		 * String conditionalQcCode =
		 * messageSource.getMessage(GlobalConstant.PACKAGE_CONDITIONAL_QC_CODE, null,
		 * null).trim(); return new
		 * ModelAndView("/channel/rtoOrder","data",conditionalQcCode);
		 */
	}
	
	@RequestMapping("/saleOrder/orderFulfillment")
	public ModelAndView marketplaceOrderFulfillment() {
		return new ModelAndView("/saleOrder/marketplaceOrderFulfillment");
	}
	@RequestMapping("/{shop}/success")
	public ModelAndView orderSuccess(@PathVariable(value = "shop") String shop) {
		return new ModelAndView("/channel/shopSuccess","shop",shop);
	}

	@RequestMapping("/{shop}/fail")
	public ModelAndView orderError(@PathVariable(value = "shop") String shop) {
		return new ModelAndView("/channel/shopError","shop",shop);
	}

	@RequestMapping("/setup/wms/skuInventory")
	public ModelAndView skuInventory() {
		return new ModelAndView("setup/wms/skuInventory");
	}

	@RequestMapping("/warehouse/warehouseLocation")
	public ModelAndView warehouseLocation(){return new ModelAndView("/warehouse/warehouseLocation");}

	@RequestMapping("/warehouse/putAway")
	public ModelAndView putAway(){return new ModelAndView("/warehouse/putAway");}

	@RequestMapping ("/setup/wms/orderCart")
	public ModelAndView orderCart(){return new ModelAndView("setup/wms/orderCart");}

	@RequestMapping("/warehouse/warehouseHistory")
	public ModelAndView warehouseHistory() {
		return new ModelAndView("/warehouse/warehouseHistory");
	}

	@RequestMapping("/warehouse/warehouseReconcilation")
	public ModelAndView warehouseReconcilation() {
		return new ModelAndView("/warehouse/warehouseReconcilation");
	}

	@RequestMapping("/channel/packageMaster")
	public ModelAndView packageMaster() { return new ModelAndView("/channel/packageMaster");}

    @RequestMapping("/api/amazonCatalog")
    public ModelAndView amazonCatalog() { return new ModelAndView("/api/amazonCatalog");}
    
    @RequestMapping("/support/trackingWebhook")
	public ModelAndView trackingWebhook() {
		return new ModelAndView("support/trackingWebhook");
	}
    
    @RequestMapping("/setup/wms/marketPlaceSkuMapping")
	public ModelAndView marketPlaceSkuMapping() {
		return new ModelAndView("setup/wms/marketPlaceSkuMapping");
	}
    @RequestMapping("/setup/wms/wmsPendingPush")
	public ModelAndView wmsPendingPush() {
		return new ModelAndView("setup/wms/wmsPendingPush");
	}

}
