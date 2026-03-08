package com.bmp.oms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.oms.service.api.VendorApiService;
import com.bmp.oms.service.api.marketplace.MarketplaceService;
import com.bmp.oms.service.api.vendorOrder.WayBillCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bmp.bean.QCCheckBean;
import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.courier.ThreeplRtoReceivingBean;
import com.bmp.bean.drs.AppRequestBean;
import com.bmp.bean.drs.UploadPodBean;
import com.bmp.bean.pickup.ThreeplPickupRequestBean;
import com.bmp.bean.saleorder.CleanUpBean;
import com.bmp.bean.saleorder.ClosePickupSheetBean;
import com.bmp.bean.saleorder.ConsineDetailBean;
import com.bmp.bean.saleorder.PacketInscan;
import com.bmp.bean.saleorder.PrintLabel;
import com.bmp.bean.saleorder.RemittanceBean;
import com.bmp.bean.saleorder.SaleOrderApiBean;
import com.bmp.bean.saleorder.SearchBean;
import com.bmp.bean.saleorder.TeleCallingBean;
import com.bmp.constant.DrsReportType;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.MessageConstant;
import com.bmp.constant.QCStatus;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.SaleOrderDao;
import com.bmp.model.app.api.jaxbean.FulfillRequestBean;
import com.bmp.model.app.client.ClientNew;
import com.bmp.model.app.masters.QCMaster;
import com.bmp.model.app.saleorder.OrderSkuScan;
import com.bmp.model.app.saleorder.PickupSheet;
import com.bmp.model.app.saleorder.RalInvoiceDetails;
import com.bmp.model.app.saleorder.Receiving3plRto;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;
import com.bmp.model.app.saleorder.StagingSaleOrder;
import com.bmp.model.app.saleorder.TeleCallingManifest;
import com.bmp.oms.service.client.ClientService;
import com.bmp.oms.service.client.ClientWarehouseService;
import com.bmp.oms.service.drs.DrsService;
import com.bmp.oms.service.masters.ProductTypeService;
import com.bmp.oms.service.saleorder.DeletedSaleOrdersService;
import com.bmp.oms.service.saleorder.InscanService;
import com.bmp.oms.service.saleorder.MarketPlaceOrderService;
import com.bmp.oms.service.saleorder.PickupSheetService;
import com.bmp.oms.service.saleorder.PrintLabelService;
import com.bmp.oms.service.saleorder.RalInvoiceDetailsService;
import com.bmp.oms.service.saleorder.RemittanceService;
import com.bmp.oms.service.saleorder.SaleOrderExtraService;
import com.bmp.oms.service.saleorder.SaleOrderPickupRequestService;
import com.bmp.oms.service.saleorder.SaleOrderService;
import com.bmp.oms.service.saleorder.StagingSaleOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/saleorder")
public class SaleOrderController {

	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("saleOrderPickupRequestServiceImpl")
	private SaleOrderPickupRequestService saleOrderPickupRequestService;

	@Autowired
	@Qualifier("saleOrderServiceImpl")
	private SaleOrderService saleOrderService;

	@Autowired
	@Qualifier("pickupSheetServiceImpl")
	private PickupSheetService pickupSheetService;

	@Autowired
	@Qualifier("stagingSaleOrderServiceImpl")
	private StagingSaleOrderService stagingSaleOrderService;

	@Autowired
	@Qualifier("productTypeServiceImpl")
	private ProductTypeService productTypeService;

	@Autowired
	@Qualifier("inscanServiceImpl")
	private InscanService inscanService;

	@Autowired
	@Qualifier("clientWarehouseServiceImpl")
	private ClientWarehouseService clientWarehouseService;

	@Autowired
	@Qualifier("printLabelServiceImpl")
	private PrintLabelService printLabelService;

	@Autowired
	@Qualifier("remittanceServiceImpl")
	private RemittanceService remittanceService;

	@Autowired
	@Qualifier("saleOrderExtraServiceImpl")
	private SaleOrderExtraService saleOrderExtraService;

	@Autowired
	@Qualifier("deletedSaleOrdersServiceImpl")
	private DeletedSaleOrdersService deletedSaleOrdersService;

	@Autowired
	@Qualifier("drsServiceImpl")
	private DrsService drsService;
	
	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired
	@Qualifier("ralInvoiceDetailsServiceImpl")
	private RalInvoiceDetailsService ralInvoiceDetailsService;
	
	@Autowired
	@Qualifier("marketPlaceOrderServiceImpl")
	private MarketPlaceOrderService marketPlaceOrderService;
	
	@Autowired
	@Qualifier("vendorApiServiceImpl")
	private VendorApiService vendorApiService;

    @Autowired
    @Qualifier("marketplaceServiceImpl")
    private MarketplaceService marketplaceService;

	@Autowired
	@Qualifier("delhiveryB2bApiHelperServiceImpl")
	private WayBillCopyService delhiveryB2bApiHelperService;

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;

	@RequestMapping(value = "/getAllSaleOrderPickupRequestList", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllSaleOrderPickupRequestList(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.getAllSaleOrderPickupRequestList(datatableRequestBean);
	}

	@RequestMapping(value = "/getAllIntransitPickupRequestList", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllIntransitPickupRequestList(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.getAllIntransitPickupRequestList(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllCancelSaleOrderPickupRequest", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllCancelSaleOrderPickupRequest(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.getAllCancelSaleOrderPickupRequest(datatableRequestBean);
	}

	@RequestMapping(value = "/checkClientWarehouseKeyAvailable/{warehouseName_s}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkClientWarehouseKeyAvailable(@PathVariable("warehouseName_s") String key) {
		return saleOrderPickupRequestService.checkSaleOrderPickupRequestKeyAvailable(key);
	}

	@RequestMapping(value = "/updateSaleOrderPickupRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateSaleOrderPickupRequest(@RequestBody SaleOrderPickupRequest saleOrderPickupRequest,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.updateSaleOrderPickupRequest(saleOrderPickupRequest);
	}

	@RequestMapping(value = "/getSaleOrderPickupRequestQC", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getSaleOrderPickupRequestQC(@RequestBody SaleOrderPickupRequest saleOrderPickupRequest,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.getSaleOrderPickupRequestQC(saleOrderPickupRequest);
	}

	@RequestMapping(value = "/verifySaleOrderPickupRequestQC", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean verifySaleOrderPickupRequestQC(@RequestBody List<QCCheckBean> qclist, HttpServletRequest request,HttpServletResponse response) {
		return saleOrderPickupRequestService.verifySaleOrderPickupRequestQC(qclist);
	}

	@RequestMapping(value = "/updateSaleOrderPickupRequestQC", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateSaleOrderPickupRequestQC(MultipartHttpServletRequest request, HttpServletResponse response) {
		Map<String, List<MultipartFile>> file = new HashMap<>();
		try {
			String beanData = request.getParameter("beanData");
			ObjectMapper mapper = new ObjectMapper();
			QCCheckBean bean = mapper.readValue(beanData, QCCheckBean.class);
			if (bean != null && bean.getQclist() != null
					&& bean.getQclist().size() > 1) {
				for (QCMaster master : bean.getQclist()) {
					/*if (master.getQcMandatory() != null 
							&& (master.getQcMandatory().equalsIgnoreCase("true") || master.getQcMandatory().equalsIgnoreCase("yes"))) {
						file.put(master.getKey_s(), request.getFiles(master.getKey_s()));
					}*/
					if (master.getImageRequired() != null && master.getImageRequired() ) {
						file.put(master.getKey_s(), request.getFiles(master.getKey_s()));
					}
					if (master.getPrimaryImageRequired() != null && master.getPrimaryImageRequired() ) {
						file.put("pri_"+master.getKey_s(), request.getFiles("pri_"+master.getKey_s()));
					}
				}
			}
			return saleOrderPickupRequestService.updateSaleOrderPickupRequestQC(bean, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/downloadShipmentQcPod")
	@ResponseBody
	public void downloadShipmentQcPod(@RequestParam(value = "key") String key,HttpServletResponse response) throws Exception {
		saleOrderPickupRequestService.downloadShipmentQcPod(key, response);
	}

	/*
	 * @RequestMapping(value = "/updateSaleOrderPickupRequestQC", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody public ResponseBean
	 * updateSaleOrderPickupRequestQC(@RequestParam("beanData") String beanData,
	 * MultipartHttpServletRequest request, HttpServletResponse response) {
	 * Map<String,MultipartFile> file = new HashMap<String,MultipartFile>(); try
	 * { //String beanData = request.getParameter("beanData"); ObjectMapper
	 * mapper = new ObjectMapper(); QCCheckBean bean =
	 * mapper.readValue(beanData, QCCheckBean.class); if(bean!=null &&
	 * bean.getQclist()!=null && bean.getQclist().size()>0) { for(QCMaster
	 * master : bean.getQclist()) { file.put(master.getKey_s(),
	 * request.getFile(master.getKey_s())); } } return
	 * saleOrderPickupRequestService.updateSaleOrderPickupRequestQC(bean, file);
	 * } catch (Exception e) { e.printStackTrace(); } return null; }
	 */

	@RequestMapping(value = "/deleteSaleOrderPickupRequest/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteSaleOrderPickupRequest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.deleteSaleOrderPickupRequest(key);
	}

	@RequestMapping(value = "/generatePickupRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean generatePickupRequest(@RequestBody SaleOrderPickupRequest saleOrderPickupRequest,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.createSaleOrderPickupRequest(saleOrderPickupRequest);
	}

	@RequestMapping(value = "/uploadLbh", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean uploadLbh(@RequestBody SaleOrder saleOrder,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.lbhUpload(saleOrder);
	}

	/*
	 * @RequestMapping(value = "/threePlAssignCourierToSaleOrder", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody public ResponseBean threePlAssignCourierToSaleOrder(
	 * 
	 * @RequestBody SaleOrder saleOrder, HttpServletRequest request,
	 * HttpServletResponse response) { return
	 * saleOrderService.threePlAssignCourierToSaleOrder(saleOrder); }
	 */

	@RequestMapping(value = "/checkSaleOrderKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkSaleOrderKeyAvailable(@PathVariable("key") String key) {
		return saleOrderService.checkSaleOrderKeyAvailable(key);
	}

	@RequestMapping(value = "/getAllPickupSheetList", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllPickupSheetList(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return pickupSheetService.getAllPickupSheets(datatableRequestBean);
	}

	@RequestMapping(value = "/generatePickupSheet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean generatePickupSheet(@RequestBody PickupSheet pickupSheet, HttpServletRequest request,HttpServletResponse response) {
		return pickupSheetService.createPickupSheet(pickupSheet);
	}

	@RequestMapping(value = "/updatePickupSheet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updatePickupSheet(@RequestBody PickupSheet pickupSheet,HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	@RequestMapping(value = "/getNewPickupRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getNewPickupRequest(@RequestBody PickupSheet pickupSheet, HttpServletRequest request,HttpServletResponse response) {
		return saleOrderPickupRequestService.getNewPickupRequest(pickupSheet);
	}

	@RequestMapping(value = "/getIntransitPickupSheetByBranch/{branchKey}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getIntransitPickupSheetByBranch(@PathVariable("branchKey") String branchKey,HttpServletRequest request, HttpServletResponse response) {
		return pickupSheetService.getIntransitPickupSheetByBranch(branchKey);
	}

	@RequestMapping(value = "/updateAndClosePickupSheet/{pickUpId}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateAndClosePickupSheet(
			@PathVariable("pickUpId") String pickUpId,
			@RequestBody List<ClosePickupSheetBean> closePickupSheetBean,
			@RequestParam(value = "buttonName") String buttonName,
			HttpServletRequest request, HttpServletResponse response) {
		return pickupSheetService.updateAndClosePickupSheet(closePickupSheetBean, pickUpId, buttonName);
	}

	@RequestMapping(value = "/getSingleIntransitPickupSheet/{pickupSheetKey}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getIntransitPickupSheet(@PathVariable("pickupSheetKey") String pickupSheetKey,HttpServletRequest request, HttpServletResponse response) {
		return pickupSheetService.getIntransitPickupSheet(pickupSheetKey);
	}

	@RequestMapping(value = "/getPrintLabel", method = RequestMethod.POST)
	public ModelAndView getPrintLabel(@ModelAttribute PrintLabel printLabel,HttpServletRequest request, HttpServletResponse response) {
		printLabelService.printLabel(printLabel, request, response);
		return null;
	}

	@RequestMapping(value = "/getLrLabel", method = RequestMethod.POST)
	public ModelAndView getLrLabel(@RequestParam("awbNumber") String awbNumber, HttpServletRequest request, HttpServletResponse response) {
		try {
			byte[] pdfData = delhiveryB2bApiHelperService.downloadLrLabel(awbNumber);
			if (pdfData == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename="+ awbNumber+"_label.pdf");
			response.getOutputStream().write(pdfData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/trackingDetail")
	public ModelAndView awbNumberTracking(@RequestParam(value = "key") String key) {
		return new ModelAndView("bmpTracking/trackingDetail", "data",saleOrderService.getAwbNumberSingleTracking(key));
	}

	@RequestMapping("/trackByAwbCommanSearch")
	public ModelAndView awbNumberTracking1(@RequestParam(value = "key") String key) {
		return new ModelAndView("bmpTracking/AwbTrackingResult", "key", key);
	}

	/*@RequestMapping(value = "/tracking/{commaSepAWBs}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean searchSaleOrderdeDetail(
			@PathVariable("commaSepAWBs") String key,
			@PathVariable("id") String id, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.searchSaleOrderdeDetail(key, id);
	}*/
	//--tracking 
	
	@RequestMapping(value = "/tracking", method = RequestMethod.POST)
	public @ResponseBody ResponseBean searchSaleOrderdeDetail(@RequestBody PrintLabel trackingApiBean,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		    String key = trackingApiBean.getAwbNumber();
		    String id = trackingApiBean.getAwbType();
		return saleOrderService.searchSaleOrderdeDetail(key, id);
	}

	@RequestMapping(value = "/getAllStagingSaleOrder", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllStagingSaleOrder(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return stagingSaleOrderService.getAllStagingSaleOrder(datatableRequestBean);
	}

	@RequestMapping(value = "/createStagingSaleOrder", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createStagingSaleOrder(@RequestBody StagingSaleOrder stagingSaleOrder,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return stagingSaleOrderService.createStagingSaleOrder(stagingSaleOrder);
	}

	@RequestMapping(value = "/updateStagingSaleOrder", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateStagingSaleOrder(@RequestBody StagingSaleOrder stagingSaleOrder,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return stagingSaleOrderService.updateStagingSaleOrder(stagingSaleOrder);
	}

	@RequestMapping(value = "/deleteStagingSaleOrder/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteStagingSaleOrder(@PathVariable("key") String key,HttpServletRequest request, HttpServletResponse response) {
		return stagingSaleOrderService.deleteStagingSaleOrder(key);
	}

	@RequestMapping(value = "/checkStagingSaleOrderKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkStagingSaleOrderKeyAvailable(@PathVariable("key") String key) {
		return stagingSaleOrderService.checkStagingSaleOrderKeyAvailable(key);
	}

	@RequestMapping(value = "/readyForInscan", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean readyForInscan(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return stagingSaleOrderService.readyForInscan(datatableRequestBean);
	}

	@RequestMapping(value = "/loadClients", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean loadClients(HttpServletRequest request,HttpServletResponse response) {
		return clientService.loadClients();
	}

	@RequestMapping(value = "/loadClientWarehouse/{clientKey}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean loadClientWarehouse(@PathVariable("clientKey") String clientKey) {
		return clientWarehouseService.loadClientWarehouse(clientKey);
	}

	@RequestMapping(value = "/loadProductTypes", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean loadProductTypes(HttpServletRequest request,HttpServletResponse response) {
		return productTypeService.loadProductTypes();
	}

	@RequestMapping(value = "/getSaleOrderAvailableForDrs/{awbNumber}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean loadProductTypes(@PathVariable("awbNumber") String awbNumber,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getSaleOrderAvailableForDrs(awbNumber);
	}

	@RequestMapping(value = "/getAllShipmentReadyForDrs", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllShipmentReadyForDrs(
			@RequestBody DatatableRequestBean datatableRequestBean,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return saleOrderService.getAllShipmentReadyForDrs(datatableRequestBean);
	}

	@RequestMapping(value = "/scanPacket", method = RequestMethod.POST)
	public @ResponseBody ResponseBean scanPacket(
			@RequestBody PacketInscan packetInscan, HttpServletRequest request,
			HttpServletResponse response) {
		return inscanService.scanPacket(packetInscan, false);
	}

	@RequestMapping(value = "/getPacketInOutCountAtBranch", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getPacketInOutCountAtBranch(HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getPacketInOutCountAtBranch();
	}
	
	@RequestMapping(value = "/getDashboardDataRow2", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getDashboardDataRow2(HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getDashboardDataRow2();
	}
	
	@RequestMapping(value = "/getDashboardDataRow4", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getDashboardDataRow4(HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getDashboardDataRow4();
	}
	
	@RequestMapping(value = "/getDashboardDataRow5", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getDashboardDataRow5(HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getDashboardDataRow5();
	}

	@RequestMapping(value = "/getAllReadyForBagging", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllReadyForBagging(
			@RequestBody DatatableRequestBean datatableRequestBean,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return saleOrderService.getAllReadyForBagging(datatableRequestBean);
	}

	@RequestMapping(value = "/pendingFor3PLHandoverReport", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllShipmentReadyFor3PL(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.pendingFor3PLHandoverReport(datatableRequestBean);
	}
	
	@RequestMapping(value = "/pickSheetGeneratedShipment", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean pickSheetGeneratedShipment(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.pickSheetGeneratedShipment(datatableRequestBean);
	}

	@RequestMapping(value = "/loadPickSheets", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean loadPickSheets(HttpServletRequest request,HttpServletResponse response) {
		return pickupSheetService.loadPickSheets();
	}

	@RequestMapping(value = "/loadPickRequest/{pickSheet}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean loadPickRequest(@PathVariable("pickSheet") String pickSheet) {
		return pickupSheetService.loadPickRequest(pickSheet);
	}

	@RequestMapping(value = "/getScanAwbNo/{awbNumber}/{branchKey}/{destinationBranchKey}/{checked}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getScanAwbNo(
			@PathVariable("awbNumber") String awbNumber,
			@PathVariable("branchKey") String branchKey,
			@PathVariable("destinationBranchKey") String destinationBranchKey,
			@PathVariable("checked") Boolean isRto, HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getScanAwbNo(awbNumber, branchKey,
				destinationBranchKey, isRto);
	}

	@RequestMapping(value = "/scanPktsForDebag/{awbNumber}/{bagKey}/{isPacketScan}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean scanPktsForDebag(
			@PathVariable("awbNumber") String awbNumber,
			@PathVariable("bagKey") String bagKey,
			@PathVariable("isPacketScan") Boolean isPacketScan,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.scanPktsForDebag(awbNumber, bagKey,
				isPacketScan);
	}

	@RequestMapping(value = "/getPickupRequest/{pickupSheetKey}/{pickupRequestKey}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getPickupRequest(
			@PathVariable("pickupSheetKey") String pickupSheetKey,
			@PathVariable("pickupRequestKey") String pickupRequestKey,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.getPickupRequest(pickupSheetKey,
				pickupRequestKey);
	}

	@RequestMapping(value = "/threePlAwbNumberNotAssigneReport", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean threePlAwbNumberNotAssigneReport(
			@RequestBody DatatableRequestBean datatableRequestBean,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return saleOrderService
				.threePlAwbNumberNotAssigneReport(datatableRequestBean);
	}

	@RequestMapping(value = "/closePickupSheetReport", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean closePickupSheetReport(
			@RequestBody DatatableRequestBean datatableRequestBean,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return pickupSheetService.closePickupSheetReport(datatableRequestBean);
	}


	@RequestMapping(value = "/getAllpendingStatus", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllpendingStatus(
			@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllpendingStatus(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllRtoPackets", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllRtoPackets(
			@RequestBody DatatableRequestBean datatableRequestBean,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllRtoPackets(datatableRequestBean);
	}

	@RequestMapping(value = "/getAllOrderCancelRequest", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllOrderCancelRequest(
			@RequestBody DatatableRequestBean datatableRequestBean,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllOrderCancelRequest(datatableRequestBean);
	}

	@RequestMapping(value = "/rtoPacketsConfirm/{keys}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean rtoPacketsConfirm(@PathVariable("keys") String keys,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.rtoPacketsConfirm(keys);
	}

	@RequestMapping(value = "/orderCanceled", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean orderCanceled(
			@RequestParam(value = "awbNumber", required = true) String awbNumber,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.orderCanceled(awbNumber);
	}

	@RequestMapping(value = "/returnToDelivery/{keys}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean returnToDelivery(@PathVariable("keys") String keys,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.returnToDelivery(keys);
	}

	@RequestMapping(value = "/pickupReattempt", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean pickupReattempt(
			@RequestParam(value = "awbNumber", required = true) String awbNumber,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.pickupReattempt(awbNumber);
	}

	@RequestMapping(value = "/readyForInternalTrasnfer", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getReadyForInternalTrasnferPackets(
			@RequestBody DatatableRequestBean datatableRequestBean,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService
				.getReadyForInternalTrasnferPackets(datatableRequestBean);
	}

	@RequestMapping(value = "/pendingForInternalTrasnferRto", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getReadyForInternalTrasnferRtoPackets(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getPendingForInternalTrasnferRtoPackets(datatableRequestBean);
	}

	@RequestMapping(value = "/getPacketSoftDataNotReceivedReport", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getPacketSoftDataNotReceivedReport(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getPacketSoftDataNotReceivedReport(datatableRequestBean);
	}

	@RequestMapping(value = "/getClosePacketReport", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getClosePacketReport(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getClosePacketReport(datatableRequestBean);
	}

	@RequestMapping(value = "/markIntransitPickupSheet/{pickSheet}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean markIntransitPickupSheet(@PathVariable("pickSheet") String pickSheet) {
		// TODO
		return pickupSheetService.markIntransitPickupSheet(pickSheet);
	}

	@RequestMapping(value = "/getAllMissingPacket", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllMissingPacket(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.getAllMissingPacket(datatableRequestBean);
	}

	@RequestMapping(value = "/getAllPickupSheetIntransit", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllPickupSheetIntransit(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return pickupSheetService.getAllPickupSheetIntransit(datatableRequestBean);
	}

	@RequestMapping(value = "/deletePickupSheet/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deletePageAction(@PathVariable("key") String key,HttpServletRequest request, HttpServletResponse response) {
		return pickupSheetService.deletePickupSheet(key);
	}

	@RequestMapping(value = "/lostOrDamageConfirm/{key}/{isLost}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean lostOrDamageConfirm(@PathVariable("key") String key,@PathVariable("isLost") Boolean isLost, HttpServletRequest request,HttpServletResponse response) {
		return saleOrderService.lostOrDamageConfirm(key, isLost);
	}

	@RequestMapping(value = "/createRemittance", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean createRemittance(@RequestBody RemittanceBean remittanceBean,HttpServletRequest request, HttpServletResponse response) {
		return remittanceService.createRemittance(remittanceBean);
	}
	

	@RequestMapping(value = "/getDeclaredFields", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getDeclaredFields(@RequestParam(value = "key") String classType,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getDeclaredFields(classType);
	}

	@RequestMapping(value = "/refreshIndex", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean refreshIndex(@RequestBody CleanUpBean cleanUpBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.refreshIndex(cleanUpBean.getClassType(),cleanUpBean.getKeys());
	}

	@RequestMapping(value = "/updateSaleOrderBagManifestDrsFields", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateSaleOrderBagManifestDrsFields(@RequestBody CleanUpBean cleanUpBean, HttpServletRequest request,HttpServletResponse response) {
		return saleOrderService.updateSaleOrderBagManifestDrsFields(cleanUpBean.getClassType(), cleanUpBean.getFieldName(),cleanUpBean.getValue(), cleanUpBean.getKeys());
	}

	@RequestMapping(value = "/deleteSaleOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean deleteSaleOrder(@RequestBody CleanUpBean cleanUpBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.deleteSaleOrder(cleanUpBean.getClassType(),cleanUpBean.getKeys(), request.getRemoteAddr());
	}

	@RequestMapping(value = "/rollBackDeletedSaleOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean rollBackDeletedSaleOrder(@RequestBody CleanUpBean cleanUpBean, HttpServletRequest request,HttpServletResponse response) {
		return saleOrderService.rollBackDeletedSaleOrder(cleanUpBean.getClassType(), cleanUpBean.getKeys());
	}

	@RequestMapping(value = "/validRemittance", method = RequestMethod.POST)
	public @ResponseBody ResponseBean validateRemittance(MultipartHttpServletRequest request, HttpServletResponse response)throws Exception {
		MultipartFile file = request.getFile("file");
		String beanData = request.getParameter("beanData");
		ObjectMapper mapper = new ObjectMapper();
		RemittanceBean remittanceBean = mapper.readValue(beanData,RemittanceBean.class);
		return remittanceService.validateRemittance(remittanceBean, file);
	}

	@RequestMapping(value = "/saleorderPacket", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getSalorderPacketByAWB(@RequestParam(value = "keys") String keys,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getSalorderPacketByAWB(keys);
	}

	@RequestMapping(value = "/finalizeRemittance", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean finalizeRemittance(@RequestBody RemittanceBean remittanceBean,HttpServletRequest request, HttpServletResponse response) {
		return remittanceService.finalizeRemittance(remittanceBean);
	}
	
	@RequestMapping(value = "/rechargeByCodRemittanceAmount/{keys}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean rechargeByCodRemittanceAmount(@PathVariable("keys") String keys,HttpServletRequest request, HttpServletResponse response) {
		return remittanceService.rechargeByCodRemittanceAmount(keys);
	}

	@RequestMapping(value = "/initiateRTO", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean initiateRTO(@RequestParam(value = "awb") String awbNumber,@RequestParam(value = "rtoKey") String rtoKey,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.initiateRTO(awbNumber, rtoKey);
	}

	@RequestMapping(value = "/requestForOrderCancel", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean requestForOrderCancel(@RequestParam(value = "awb") String awbNumber, @RequestParam(value = "cancelKey") String cancelKey, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.requestForOrderCancel(awbNumber, cancelKey);
	}

	@RequestMapping(value = "/getAllPending3PLRemittance", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllPending3PLRemittance(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.getAllPending3PLRemittance(datatableRequestBean);
	}

	@RequestMapping(value = "/getAllFinalizedRemitance", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllFinalizedRemitance(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return remittanceService.getAllFinalizedRemitance(datatableRequestBean);
	}

	@RequestMapping(value = "/getAllCodPendingRemittance", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllCodPendingRemittance(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return remittanceService.getAllCodPendingRemittance(datatableRequestBean);
	}

	@RequestMapping(value = "/getAllRemittances", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getAllRemittances(HttpServletRequest request,HttpServletResponse response) {
		return remittanceService.getAllRemittances();
	}
	
	@RequestMapping(value = "/getRemittanceBankDeposits", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getRemittanceBankDeposits(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return remittanceService.getRemittanceBankDeposits(datatableRequestBean);
	}

	@RequestMapping(value = "/saveRemittanceDepositSlip", method = RequestMethod.POST)
	public @ResponseBody ResponseBean saveRemittanceDepositSlip(MultipartHttpServletRequest request, HttpServletResponse response)throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		MultipartFile file = request.getFile("depositSlip");

		param.put("depositSlip", file);
		param.put("remittanceKey", request.getParameter("remittanceKey"));
		param.put("depositDate", request.getParameter("depositDate"));
		param.put("bankName", request.getParameter("bankName"));
		param.put("accountNo", request.getParameter("accountNo"));
		param.put("transactionNo", request.getParameter("transactionNo"));
		param.put("depositedAmt", request.getParameter("depositedAmt"));

		return remittanceService.saveRemittanceDepositSlip(param);
	}

	@RequestMapping("/downloadDepositSlip")
	@ResponseBody
	public void downloadDepositSlip(@RequestParam(value = "depositSlipName", required = true) String depositSlipName,HttpServletResponse response) throws Exception {
		remittanceService.downloadDepositSlip(depositSlipName, response);
	}

	@RequestMapping(value = "/getAllRemittanceClose", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllRemittanceClose(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return remittanceService.getAllRemittanceClose(datatableRequestBean);
	}

	@RequestMapping(value = "/getAllRemittanceDispute", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllRemittanceDispute(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return remittanceService.getAllRemittanceDispute(datatableRequestBean);
	}

	@RequestMapping(value = "/remittanceMarkAsDispute/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean remittanceMarkAsDispute(@PathVariable("key") String key, HttpServletRequest request,HttpServletResponse response) {
		return remittanceService.remittanceMarkAsDispute(key);
	}

	@RequestMapping(value = "/getRemitanceValue/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getRemitanceValue(@PathVariable("key") String key,HttpServletRequest request, HttpServletResponse response) {
		return remittanceService.getRemitanceValue(key);
	}

	@RequestMapping(value = "/updatePaymentModeAndColectedAmtInSaleOrder/{remKey}/{key}/{pMode}/{clAmt}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updatePaymentModeAndColectedAmtInSaleOrder(
			@PathVariable("remKey") String remKey,
			@PathVariable("key") String key,
			@PathVariable("pMode") String pMode,
			@PathVariable("clAmt") String clAmt, HttpServletRequest request,
			HttpServletResponse response) {
		return remittanceService.updatePaymentModeAndColectedAmtInSaleOrder(
				remKey, key, pMode, clAmt);
	}

	@RequestMapping(value = "/resolveDispute/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean resolveDispute(@PathVariable("key") String key,HttpServletRequest request, HttpServletResponse response) {
		return remittanceService.resolveDispute(key);
	}

	@RequestMapping(value = "/getAllShipmentForRedirect", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllShipmentForRedirect(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllShipmentForRedirect(datatableRequestBean);
	}

	@RequestMapping(value = "/redirectOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean redirectOrder(@RequestBody ConsineDetailBean consineDetailBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.redirectOrder(consineDetailBean);
	}

	@RequestMapping(value = "/getOpenDrsShipmentByUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getOpenDrsShipmentByUser(@RequestBody AppRequestBean appRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.getOpenDrsShipmentByUser(appRequestBean.getUserId(), appRequestBean.getType());
	}

	@RequestMapping(value = "/getPickupSheet/{key}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getPickupSheet(@PathVariable("key") String userId,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return pickupSheetService.getPickupSheet(userId);
	}

	@RequestMapping(value = "/updatePickupRequestSheet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updatePickupRequestSheet(@RequestBody PacketInscan packetInscan, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderPickupRequestService.updatePickupRequestSheet(packetInscan);
	}

	@RequestMapping(value = "/update_sale_order_all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getUpdateSaleOrderAll(@RequestParam(value = "key") String key,HttpServletRequest request, HttpServletResponse response) {
		return inscanService.getUpdateSaleOrderAll(key);
	}

	@RequestMapping(value = "/checkConsignePincodeServicable", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkConsignePincodeServicable(@RequestParam(value = "pincode") String pincode,@RequestParam(value = "awb") String awb,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.checkConsignePincodeServicable(pincode, awb);
	}

	@RequestMapping(value = "/getAllCloseSaleOrderPickupRequest", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllCloseSaleOrderPickupRequest(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.getAllCloseSaleOrderPickupRequest(datatableRequestBean);
	}

	@RequestMapping(value = "/checkOrderUploadedCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkOrderUploadedCount(@RequestParam(value = "isFirstCall") boolean isFirstCall,HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.ORDER_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.ORDER_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.ORDER_UPLOAD_COUNT_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.ORDER_UPLOAD_COUNT_CURRENT_COUNT));
			map.put(GlobalConstant.ORDER_UPLOAD_COUNT_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.ORDER_UPLOAD_COUNT_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/checkClientSKUUploadedCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkClientSKUUploadedCount(@RequestParam(value = "isFirstCall") boolean isFirstCall, HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(GlobalConstant.CLIENT_SKU_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(GlobalConstant.CLIENT_SKU_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.CLIENT_SKU_UPLOAD_COUNT_CURRENT_COUNT,""+ request.getSession().getAttribute(GlobalConstant.CLIENT_SKU_UPLOAD_COUNT_CURRENT_COUNT));
			map.put(GlobalConstant.CLIENT_SKU_UPLOAD_COUNT_TOTAL_COUNT,""+ request.getSession().getAttribute(GlobalConstant.CLIENT_SKU_UPLOAD_COUNT_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}

	@RequestMapping(value = "/pendingRtoReceivedReport", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean pendingRtoReceivedReport(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.pendingRtoReceivedReport(datatableRequestBean);
	}

	@RequestMapping(value = "/scanRtoReceivedPacket", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean scanRtoReceivedPacket(@RequestBody Receiving3plRto receiving3plrto,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.scanRtoReceivedPacket(receiving3plrto,false);
	}

	@RequestMapping(value = "/getAllPendingRtoConfirmPackets", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllRtoConfirmPackets(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllPendingRtoConfirmPackets(datatableRequestBean);
	}

	@RequestMapping(value = "/pendingShipmentWeight", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean pendingShipmentWeight(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderExtraService.pendingShipmentWeight(datatableRequestBean);
	}

	@RequestMapping(value = "/deletedSaleOrderReport", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean deletedSaleOrderReport(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return deletedSaleOrdersService.getAllDeletedSaleOrder(datatableRequestBean);
	}

	@RequestMapping(value = "/threePlAssignCourierToSaleOrder/{isForceFull}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean threePlAssignCourierToSaleOrder(
			@PathVariable("isForceFull") String isForceFull,
			@RequestBody SaleOrder saleOrder, HttpServletRequest request,
			HttpServletResponse response) {
		// return saleOrderService.threePlAssignCourierToSaleOrder(saleOrder);
		return saleOrderService.threePlAssignCourierToSaleOrder(saleOrder,
				isForceFull);
	}

	@RequestMapping(value = "/pendingPickupSheetPod", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean pendingPickupSheetPod(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return pickupSheetService.pendingPickupSheetPod(datatableRequestBean);
	}

	@RequestMapping(value = "/uploadPickupSheetPod", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean uploadDrsScannedFile(MultipartHttpServletRequest request, HttpServletResponse response) {
		UploadPodBean uploadItem = new UploadPodBean();
		uploadItem.setFileList(request.getFiles("fileList"));
		uploadItem.setKey(request.getParameter("key"));
		return pickupSheetService.uploadPickupPOD(uploadItem);
	}

	@RequestMapping("/downloadPickupSheetPod")
	@ResponseBody
	public void downloadPickupSheetPod(@RequestParam(value = "key") String pickSheetNo,HttpServletResponse response) throws Exception {
		String path = messageSource.getMessage(MessageConstant.PICKUP_PATH,null, null);
		drsService.downloadPodDrsDoc(pickSheetNo, path, response);
	}

	@RequestMapping(value = "/uploadPickupRequestPOD", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean uploadPickupRequestPOD(MultipartHttpServletRequest request, HttpServletResponse response) {
		return pickupSheetService.uploadPickupRequestPOD(request.getFile("file"), request.getParameter("key"));
	}

	@RequestMapping(value = "/getPendingPodCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getPendingPodCount(HttpServletRequest request,HttpServletResponse response) {
		return saleOrderService.getPendingPodCount();
	}

	@RequestMapping("/downloadPickupPod")
	@ResponseBody
	public void downloadPickupPod(@RequestParam(value = "key") String awbNUmber,HttpServletResponse response) throws Exception {
		pickupSheetService.downloadPickupPod(awbNUmber, response);
	}

	@RequestMapping(value = "/reattemptBookingCanselPickup", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean reattemptBookingCanselPickup(@RequestParam(value = "key") String key,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.reattemptBookingCanselPickup(key);
	}

	@RequestMapping(value = "/getAwbNumber", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAwbNumber(@RequestParam(value = "key") String key,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.getAwbNumber(key);
	}

	@RequestMapping(value = "/changeDestinationDetails", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean changeDestinationDetails(@RequestBody ConsineDetailBean consineDetailBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.changeDestinationDetails(consineDetailBean);
	}

	@RequestMapping(value = "/packetOnHold", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean packetOnHold(@RequestParam(value = "awb") String awbNumber,@RequestParam(value = "packetReasonKey") String packetReasonKey,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.packetOnHold(awbNumber, packetReasonKey);
	}

	@RequestMapping(value = "/getAllPacketOnHold", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllPacketOnHold(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllPacketOnHold(datatableRequestBean);
	}

	@RequestMapping(value = "/packetUnHold/{keys}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean packetUnHold(@PathVariable("keys") String keys,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.packetUnHold(keys);
	}
	
	@RequestMapping(value = "/loadClientsByUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean loadClientsByUser(HttpServletRequest request,HttpServletResponse response) {
		return clientService.loadClientsByUser();
	}

	/*@RequestMapping(value = "/getPrintLabel1", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getPrintLabel1(@RequestBody PrintLabel printLabel,HttpServletRequest request, HttpServletResponse response) {
		//ResponseBean responseBean = printLabelService.printLabel(printLabel, request, response);
		ResponseBean responseBean = new ResponseBean();
		String fileName = messageSource.getMessage(MessageConstant.SALEORDERPRINT_PATH, null, null).trim()+"/test.pdf";
		List<SaleOrder> resultList = null;
		try{
			resultList = saleOrderDao.getEntityByLocationKey(Arrays.asList(printLabel.getAwbNumber().split(",")), SaleOrder.class);
		}catch(Exception e){}
		printLabelService.createPDF(fileName, resultList, request);
		responseBean = printLabelService.convertPDFToByteArrayOutputStreamNew(fileName);
		ByteArrayOutputStream baos = (ByteArrayOutputStream) responseBean.getResponse();
		
		responseBean.setResponse(baos.toByteArray());
		return responseBean;
	}*/
	
	@RequestMapping(value = "/scanAwbNoForReconnect/{awb}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean scanAwbNoForReconnect(@PathVariable("awb") String awb,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.scanAwbNoForReconnect(awb);
	}
	
	@RequestMapping(value = "/createReconnectRequest", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createReconnectRequest(@RequestBody SaleOrder saleOrder,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.createReconnectRequest(saleOrder);
    }
	
	@RequestMapping(value = "/getAllNewReconnectRequest", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllNewReconnectRequest(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllNewReconnectRequest(datatableRequestBean);
	}
	
	@RequestMapping(value = "/drsExcelPeport/{type}", method = RequestMethod.GET)
	public void drsExcelPeport(@PathVariable("type") DrsReportType drsReportType,HttpServletRequest request, HttpServletResponse response) {
		saleOrderService.drsExcelPeport(drsReportType, response);
	}
	
	@RequestMapping(value = "/pending3PLRemittance", method = RequestMethod.GET)
	public void pending3PLRemittance(HttpServletRequest request, HttpServletResponse response) {
		saleOrderService.pending3PLRemittance(request, response);
	}
	
	@RequestMapping(value = "/getReadyForDRSCounts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getReadyForDRSCounts(HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getReadyForDRSCounts();
	}
	
	@RequestMapping(value = "/getElligibleForUnclaimedSalorderPacketByAWB", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getElligibleForUnclaimedSalorderPacketByAWB(@RequestBody SearchBean searchBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getElligibleForUnclaimedSalorderPacketByAWB(searchBean.getAwbNumbers());
	}
	
	@RequestMapping(value = "/requestForUnclaim", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean requestForUnclaim(@RequestBody SearchBean searchBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.requestForUnclaim(searchBean.getAwbNumbers());
	}
	
	@RequestMapping(value = "/getAllBagGeneratedShipment", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllBagGeneratedShipment(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllBagGeneratedShipment(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllThreePlManifestGeneratedShipment", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllThreePlManifestGeneretedShipment(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllThreePlManifestGeneratedShipment(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllManifestGeneratedShipment", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllManifestGeneratedShipment(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllManifestGeneratedShipment(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllDrsGeneratedShipment", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllDrsGeneratedShipment(
			@RequestBody DatatableRequestBean datatableRequestBean,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllDrsGeneratedShipment(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllRtoDeclaredShipment", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllRtoDeclaredShipment(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllRtoDeclaredShipment(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllCTOCOrder", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllCTOCOrder(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllCTOCOrder(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllrtoReceivingErrors", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllrtoReceivingErrors(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllrtoReceivingErrors(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getDashboardDataRow6", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getDashboardDataRow6(HttpServletRequest request,HttpServletResponse response) {
		return saleOrderService.getDashboardDataRow6();
	}
	
	@RequestMapping(value = "/deleteScanRecord/{key}/{awb}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteScanRecord(@PathVariable("key") String key,@PathVariable("awb") String awb,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.deleteScanRecord(key,awb);
    }
	
	@RequestMapping(value = "/lock3PlRtoReceived/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean lock3PlRtoReceived(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.lock3PlRtoReceived(key);
    }
	
	@RequestMapping(value = "/partnerPendancy", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getPartnerPendancy(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return saleOrderService.getPartnerPendancy(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getRtoReceivedErrorPackets", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getRtoReceivedErrorPackets(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getRtoReceivedErrorPackets(datatableRequestBean);
	}
	
	@RequestMapping(value = "/markOutFromError/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean markOutFromError(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.markOutFromError(key);
    }
	
	@RequestMapping(value = "/scanReceivedShipmentForRto/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean scanReceivedShipmentForRto(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.scanReceivedShipmentForRto(key);
    }
	
	@RequestMapping(value = "/createBookingRequest", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createBookingRequest(@RequestBody SaleOrderApiBean saleOrder,HttpServletRequest request, HttpServletResponse response) {
		return null;
    }
	
	@RequestMapping(value = "/rtoRejectedShipments", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean rtoRejectedShipments(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.rtoRejectedShipments(datatableRequestBean);
	}
	
	@RequestMapping(value = "/rtoPacketsReceivedResolve/{keys}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean rtoPacketsReceivedResolve(@PathVariable("keys") String keys,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.rtoPacketsReceivedResolve(keys);
	}
	
	@RequestMapping(value = "/markLostRtoRejectedShipment/{keys}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean markLostRtoRejectedShipment(@PathVariable("keys") String keys,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.markLostRtoRejectedShipment(keys);
	}
	
	@RequestMapping(value = "/threeplRtoReceivingCloseFunction", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean threeplRtoReceivingCloseFunction(@RequestBody List<ThreeplRtoReceivingBean> threeplRtoReceivingBeanList,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.threeplRtoReceivingCloseFunction(threeplRtoReceivingBeanList);
	}
	
	@RequestMapping(value = "/threeplPickupRequest", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean threeplPickupRequest(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.threeplPickupRequest(datatableRequestBean);
	}
	
	@RequestMapping(value = "/threeplPickupRequestUpdate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean threeplPickupRequestUpdate(@RequestBody ThreeplPickupRequestBean threeplPickupRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.threeplPickupRequestUpdate( threeplPickupRequestBean);
	}
	
	@RequestMapping(value = "/cancelPickupRequest/{keys}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean cancelPickupRequest(@PathVariable("keys") String keys,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderPickupRequestService.cancelPickupRequest(keys);
	}
	
	@RequestMapping(value = "/getDashboardDataRow7", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getDashboardDataRow7(HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getDashboardDataRow7();
	}
	
	@RequestMapping(value = "/getAllReAttemptShipmentDrs", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllReAttemptShipmentReadyForDrs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.getAllReAttemptShipmentDrs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllPacketOnHoldReport", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllPacketOnHoldReport(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllPacketOnHoldReport(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllCodAwaitedBranchEnd", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllCodAwaitedBranchEnd(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllCodAwaitedBranchEnd(datatableRequestBean);
	}
	
	@RequestMapping(value = "/rtoReceivedTerminalShipment", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean rtoReceivedTerminalShipment(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.rtoReceivedTerminalShipment(datatableRequestBean);
	}
	
	@RequestMapping(value = "/rtoReceivedTerminalShipmentPeport", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean rtoReceivedTerminalShipmentPeport(HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.rtoReceivedTerminalShipmentPeport(response);
	}
	
	@RequestMapping(value = "/getAllQCListToVerify/{checkQcStatus}", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllQCListToVerify(@PathVariable("checkQcStatus") String checkQcStatus,@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderExtraService.getAllQCListToVerify(checkQcStatus,datatableRequestBean);
	}
	
	@RequestMapping(value = "/verifiedQc/{awb}/{qcStatus}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean verifiedQc(@PathVariable("awb") String awb, @PathVariable("qcStatus") QCStatus qcStatus,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderExtraService.verifiedQc(qcStatus, awb);
	}
	
	@RequestMapping(value = "/verifiedClientQc/{awb}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean verifiedClientQc(@PathVariable("awb") String awb,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderExtraService.verifiedClientQc(awb);
	}
	
	@RequestMapping(value = "/getAllAwaitingClientInstruction", method = RequestMethod.POST)
	@ResponseBody 
	public DatatableResponseBean getAllAwaitingClientInstruction(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.getAllAwaitingClientInstruction(datatableRequestBean);
	}
	
	/*@RequestMapping(value = "/getAllOrderVerification/{clientKeys}/{telecallingFilter}/{teleCount}", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllOrderVerification(@PathVariable("clientKeys") String clientKeys, @PathVariable("telecallingFilter") String telecallingFilter,@PathVariable("teleCount") String teleCount, @RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllOrderVerification(clientKeys,telecallingFilter,teleCount,datatableRequestBean);
	}*/
	@RequestMapping(value = "/getAllOrderVerification", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllOrderVerification(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllOrderVerification(datatableRequestBean);
	}
	
	@RequestMapping(value = "/updateSaleOrderTelecallingStatus", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateSaleOrderTelecallingStatus(@RequestBody TeleCallingBean teleCallingBean, HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.updateSaleOrderTelecallingStatus(teleCallingBean);
	}

	@RequestMapping(value = "/createTelecallingManifest", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createTelecallingManifest(@RequestBody TeleCallingManifest teleCallingManifest, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.createTelecallingManifest(teleCallingManifest);
    }
	
	@RequestMapping(value = "/getDashboardDataRow8", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getDashboardDataRow8(HttpServletRequest request,
			HttpServletResponse response) {
		return saleOrderService.getDashboardDataRow8();
	}
	

	@RequestMapping(value = "/getAllTeleManifestOrders", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllTeleManifestOrders(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllTeleManifestOrders(datatableRequestBean);
	}
	

	@RequestMapping(value = "/getAllOrderVerifiedPendingForScanning", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllOrderVerifiedPendingForScanning( @RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllOrderVerifiedPendingForScanning(datatableRequestBean);
	}
	
	@RequestMapping(value = "/rtoInitiatePackets/{keys}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean rtoInitiatePackets(@PathVariable("keys") String keys,
			HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.rtoInitiatePackets(keys);
	}
	
	@RequestMapping(value = "/getAllOpenTeleCallingManifest", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllOpenTeleCallingManifest(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllOpenTeleCallingManifest(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllClosedTeleCallingManifest", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllClosedTeleCallingManifest(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllClosedTeleCallingManifest(datatableRequestBean);
	}
	
	@RequestMapping(value = "/deleteTeleManifestDetails/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteTeleManifestDetails(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.deleteTeleManifestDetails(key);
    }
	
	@RequestMapping(value = "/markedPublishedTeleCallingManifest/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean markedPublishedTeleCallingManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.markedPublishedTeleCallingManifest(key);
    }
	
	@RequestMapping(value = "/getAllPublishedTeleCallingManifest", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllPublishedTeleCallingManifest(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllPublishedTeleCallingManifest(datatableRequestBean);
	}
	
	@RequestMapping(value = "/manualClosedTeleCallingManifest/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean manualClosedTeleCallingManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.manualClosedTeleCallingManifest(key);
    }
	
	@RequestMapping(value = "/getAllPrepareCalling", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllPrepareCalling(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getAllPrepareCalling(datatableRequestBean);
	}
	
	@RequestMapping(value = "/createAllTelecallingManifest", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createNdrTelecallingManifest(@RequestBody TeleCallingManifest teleCallingManifest, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.createAllTelecallingManifest(teleCallingManifest);
    }
	
	@RequestMapping(value = "/getAllOrderSkuMapping", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllOrderSkuMapping(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderService.getAllOrderSkuMapping(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getSaleOrderAvailableForSkuMapping/{awbNumber}/{productSku}/{branchKey}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getSaleOrderAvailableForSkuMapping(@PathVariable("awbNumber") String awbNumber, @PathVariable("productSku") String productSku, @PathVariable("branchKey") String branchKey, HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getSaleOrderAvailableForSkuMapping(awbNumber, productSku, branchKey);
	}
	
	@RequestMapping(value = "/createOrderSkuMap/{key}/{productSku}", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean createOrderSkuMap(@PathVariable(value="key") String awbNumbers, @PathVariable(value="productSku") String productSkus,@RequestBody OrderSkuScan orderSkuScan, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderService.createOrderSkuMap(orderSkuScan, awbNumbers, productSkus);
	}
	
	@RequestMapping(value = "/viewOrderSkuMap/{key}", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean viewOrderSkuMap(@PathVariable("key") String key, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderService.viewOrderSkuMap(key);
	}
	
	@RequestMapping(value = "/getSaleOrderByAwbAndProductSku", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean getSaleOrderByAwbAndProductSku(@RequestParam(value = "awbNumbers") String awbNumbers, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return saleOrderService.getSaleOrderByAwbAndProductSku(awbNumbers);
	}
	
	@RequestMapping(value = "/api/getAllReadyForRTO", method = RequestMethod.GET)
  	@ResponseBody
	public  void getAllReadyForRTO(HttpServletRequest request,HttpServletResponse response) {
		 saleOrderService.getAllReadyForRTO(response);
	}
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updateStatus(@RequestParam(value = "key") List<String> awbNUmberList,HttpServletResponse response) throws Exception {
		return saleOrderService.updateStatus(awbNUmberList, response);
	}

	@RequestMapping(value = "/api/getAllCancelOrder", method = RequestMethod.GET)
  	@ResponseBody
	public  void getAllCancelOrder(HttpServletRequest request,HttpServletResponse response) {
		 saleOrderService.getAllCancelOrder(response);
	}
	
	
	@RequestMapping(value = "/addRalInvoiceDetails", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addRalInvoiceDetails(@RequestBody RalInvoiceDetails ralInvoiceDetails, HttpServletRequest request, HttpServletResponse response) {
		return ralInvoiceDetailsService.addRalInvoiceDetails(ralInvoiceDetails);
    }
	
	@RequestMapping(value = "/deleteRalPushShipment", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean deleteRalPushShipment(@RequestParam(value = "key")  String awbNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return ralInvoiceDetailsService.deleteRalPushShipment(awbNumber);
	}
	
	@RequestMapping(value = "/getAllRalInvoiceDetails", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllRalInvoiceDetails(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return ralInvoiceDetailsService.getAllRalInvoiceDetails(datatableRequestBean);
	}
	
	@RequestMapping(value = "/dashBoardDataCount", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean dashBoardDataCount(HttpServletRequest request,HttpServletResponse response) {
		return saleOrderService.dashBoardDataCount();
	}
	
	@RequestMapping(value = "/pendingWeightReport/{type}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean pendingWeightReport(@PathVariable(value = "type") String type,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.pendingWeightReport(type, response);
	}
	
	@RequestMapping(value = "/clientAllOrderStage", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean clientAllOrderStage(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.clientAllOrderStage(datatableRequestBean);
	}
	
	@RequestMapping(value = "/rateCalculator", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean rateCalculator(@RequestBody SaleOrder saleOrder,@RequestParam(value = "type") String  type ,HttpServletRequest request, HttpServletResponse response)throws Exception {
		return saleOrderService.rateCalculator(saleOrder,type);
	}
	@RequestMapping(value = "/getOrderCountForStatus", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean getOrderCountForStatus(@RequestParam("dateRange") String dateRange,@RequestParam("clientId") String clientId,
			HttpServletRequest request,HttpServletResponse response) {
		return saleOrderService.getOrderCountForStatus(dateRange,clientId);
	}
	@RequestMapping(value = "/getDashBoardDataCountReports", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getDashBoardDataCountReports(@RequestParam("key") String key,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getDashBoardDataCountReports(key);
    }
	@RequestMapping(value = "/getTotalPendingCodRemittance", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getTotalPendingCodRemittance(HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getTotalPendingCodRemittance();
    }
	@RequestMapping(value = "/loadAllRemittanceClients", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadAllRemittanceClients( HttpServletRequest request, HttpServletResponse response) {
		return remittanceService.loadAllRemittanceClients();
    }
	
	/*@RequestMapping(value = "/createSingleSaleOrder", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean createSingleSaleOrder(@RequestBody StagingSaleOrder stagingSaleOrder,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return stagingSaleOrderService.createSingleSaleOrder(stagingSaleOrder);
	}*/
	
	@RequestMapping(value = "/createSingleSaleOrder", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createSingleSaleOrder(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("invoiceDoc", request.getFile("invoiceDoc"));
		doc.put("ewayBillDoc", request.getFile("ewayBillDoc"));
		
		String stagingSaleOrderBean = request.getParameter("stagingSaleOrderBean");
		ObjectMapper mapper = new ObjectMapper();
		StagingSaleOrder stagingSaleOrder = mapper.readValue(stagingSaleOrderBean, StagingSaleOrder.class);
        return stagingSaleOrderService.createSingleSaleOrder(stagingSaleOrder, doc);
	}
	
	@RequestMapping(value = "/getAllMarketPlaceOrder", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllMarketPlaceOrder(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return marketPlaceOrderService.getAllMarketPlaceOrder(datatableRequestBean);
	}
	
	@RequestMapping(value = "/fetchMarketPlaceOrder", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean fetchMarketPlaceOrder(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "range", required = false) Integer range, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return marketplaceService.fetchMarketPlaceOrder(key, range);
	}
	
	@RequestMapping(value = "/updateOrderAsFulfill", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean updateOrderAsFulfill(@RequestBody List<FulfillRequestBean> fulfillRequestBeans, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return vendorApiService.updateOrderAsFulfill(fulfillRequestBeans);
	}
	
	@RequestMapping(value = "/test/updateOrderAsFulfillManual", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean updateOrderAsFulfillManual(@RequestBody List<String> list ,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.updateOrderAsFulfillManual(list);
	}

	@RequestMapping(value = "/getSaleOrderData", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getSaleOrderData(@RequestParam("val") Integer val,HttpServletRequest request, HttpServletResponse response) {
		return saleOrderService.getSaleOrderData(val);
	}
	
}