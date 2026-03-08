package com.bmp.oms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmp.model.app.wms.PurchaseOrder;
import com.bmp.model.app.wms.StockTransferNote;
import com.bmp.oms.service.wms.impl.PurchaseOrderServiceImpl;
import com.bmp.oms.service.wms.impl.StockTransferNoteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bmp.bean.BulkUploadBean;
import com.bmp.bean.BulkUploadMasterBean;
import com.bmp.bean.c2c.SessionWebUserBean;
import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.FileDirectory;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LocationType;
import com.bmp.constant.MessageConstant;
import com.bmp.constant.ResponseStatus;
import com.bmp.constant.StnTransferType;
import com.bmp.exception.BulkException;
import com.bmp.model.app.bulk.BulkHeader;
import com.bmp.model.app.bulk.BulkMaster;
import com.bmp.model.app.bulk.BulkValidation;
import com.bmp.model.app.courier.Courier;
import com.bmp.model.app.facility.User;
import com.bmp.oms.service.bulk.BulkHeaderService;
import com.bmp.oms.service.bulk.BulkMasterService;
import com.bmp.oms.service.bulk.BulkService;
import com.bmp.oms.service.bulk.BulkValidationService;
import com.bmp.oms.service.c2c.impl.PacketServiceImpl;
import com.bmp.oms.service.client.ClientCodeService;
import com.bmp.oms.service.client.ClientService;
import com.bmp.oms.service.client.impl.ClientBillingServiceImpl;
import com.bmp.oms.service.client.impl.ClientCodeServiceImpl;
import com.bmp.oms.service.client.impl.ClientProductSkuRateServiceImpl;
import com.bmp.oms.service.client.impl.ClientSKUWeigthLookerServiceImpl;
import com.bmp.oms.service.courier.impl.CourierServiceImpl;
import com.bmp.oms.service.masters.impl.AWBSeriesServiceImpl;
import com.bmp.oms.service.masters.impl.CityServiceImpl;
import com.bmp.oms.service.masters.impl.PincodeServiceImpl;
import com.bmp.oms.service.masters.impl.ServiceablePincodeServiceImpl;
import com.bmp.oms.service.masters.impl.StateServiceImpl;
import com.bmp.oms.service.saleorder.impl.InscanServiceImpl;
import com.bmp.oms.service.saleorder.impl.MarketPlaceOrderServiceImpl;
import com.bmp.oms.service.saleorder.impl.RemittanceFrom3PLServiceImpl;
import com.bmp.oms.service.saleorder.impl.SaleOrderExtraServiceImpl;
import com.bmp.oms.service.saleorder.impl.SaleOrderPickupRequestServiceImpl;
import com.bmp.oms.service.saleorder.impl.SaleOrderServiceImpl;
import com.bmp.oms.service.saleorder.impl.StagingSaleOrderServiceImpl;
import com.bmp.oms.service.wms.impl.CatalogueServiceImpl;
import com.bmp.oms.service.wms.impl.MarketplaceSkuMappingServiceImpl;
import com.bmp.oms.service.wms.impl.OrderServiceImpl;
import com.bmp.utility.logger.AsyncLogger;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/bulkupload")
public class BulkUploadController {			

//	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("bulkMasterService")
	private BulkMasterService bulkMasterService;
	
	@Autowired
	@Qualifier("bulkService")
	private BulkService bulkService;

	@Autowired
	@Qualifier("bulkHeaderService")
	private BulkHeaderService bulkHeaderService;
	
	@Autowired
	@Qualifier("bulkValidationService")
	private BulkValidationService bulkValidationService;
	
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;
	
	@Autowired
	@Qualifier("sessionWebUserBean")
	private SessionWebUserBean sessionWebUserBean;
	
	@Autowired
	@Qualifier("clientServiceImpl")
	private ClientService clientService;

	@Scheduled(cron = "* * */10 * * *")
	public void createCron(){
		//System.out.println("Cron recated successfully.");
	}
	
	@RequestMapping("/bulkUpload")	
	public ModelAndView bulkUplad() {
		ModelAndView modelAndView = new ModelAndView("bulk/bulkUpload");
		modelAndView.addObject("bulkUploadBean", new BulkUploadBean());
		return modelAndView;	
	}
	
	@RequestMapping(value = "/createBulkValidation", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createBulkValidation(@RequestBody BulkValidation bulkValidation, HttpServletRequest request, HttpServletResponse response) {
		return bulkValidationService.createBulkValidation(bulkValidation);
	}
	
	@RequestMapping(value = "/updateBulkValidation", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBulkValidation(@RequestBody BulkValidation bulkValidation, HttpServletRequest request, HttpServletResponse response) {
		return bulkValidationService.updateBulkValidation(bulkValidation);
	}
	
	@RequestMapping(value = "/deleteBulkValidation/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteBulkValidation(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return bulkValidationService.deleteBulkValidation(key);
	}
	
	@RequestMapping(value = "/checkBulkValidationAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkBulkValidationAvailable(@PathVariable("key") String key) {
		return bulkValidationService.checkBulkValidationAvailable(key);
	}
	
	@RequestMapping(value = "/getAllBulkValidations", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllBulkValidations (@RequestBody DatatableRequestBean datatableRequestBean,BindingResult result, RedirectAttributes redir, HttpServletRequest request, HttpServletResponse response) {
		return bulkValidationService.getAllBulkValidations(datatableRequestBean);
    }
	//
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ExceptionHandler({BulkException.class})
    public ModelAndView uploadData(@RequestParam("uploadId") String name,
			@RequestParam("files") MultipartFile file,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView;
		if(!"".equals(name) && name.equals(FileDirectory.STAGINGSALEORDER.getFileDirectory())){
			 modelAndView = new ModelAndView("courierServices/stagingSaleOrderBulkUpload");
		}else if(!"".equals(name) && name.equals(FileDirectory.STAGINGBULKSALEORDER.getFileDirectory())){
			modelAndView = new ModelAndView("courierServices/stagingSaleOrderBulkUpload");
		}else if(!"".equals(name) && name.equals(FileDirectory.SERVICEABLEPINCODE.getFileDirectory())){
			 modelAndView = new ModelAndView("setup/masters/serviceablepincode");
		}else if(name.equals(FileDirectory.UPLOADLBH.getFileDirectory())){
			 modelAndView = new ModelAndView("saleOrder/uploadlbh");
		}else if(name.equals(FileDirectory.THREEPLCOURIERTOSALEORDER.getFileDirectory())){
			 modelAndView = new ModelAndView("saleOrder/3plassigncouriertosaleorder");
		}else if(name.equals(FileDirectory.AWBSERIES.getFileDirectory())){
			 modelAndView = new ModelAndView("setup/masters/awbSeries");
		}else if(name.equals(FileDirectory.UPLOAD_3PL_REMMITTANCE.getFileDirectory())){
			 modelAndView = new ModelAndView("/saleOrder/upload3PLRemmittance");
		}else if(name.equals(FileDirectory.THREEPL_STATUS_UPDATE.getFileDirectory())){
			 modelAndView = new ModelAndView("/threePl/update3PlStatus");
		}else if(name.equals(FileDirectory.PICKUP_REQUEST_MASTER.getFileDirectory())){
			 modelAndView = new ModelAndView("saleOrder/uploadPickupRequest");
		}else if(name.equals(FileDirectory.BULK_INSCAN.getFileDirectory())){
			 modelAndView = new ModelAndView("support/bulkInscan");
		}else if(name.equals(FileDirectory.CLIENT_SKU_WEIGTH_LOOKER.getFileDirectory())){
			 modelAndView = new ModelAndView("courierServices/clientSKUWeigthLookerBulkUpload");
		}else if(name.equals(FileDirectory.CTOC_BULK.getFileDirectory())){
			 modelAndView = new ModelAndView("c2c/myaccount/bulkShipping");
		}else if(name.equals(FileDirectory.UPDATE_CLIENT_BILL.getFileDirectory())){
			 modelAndView = new ModelAndView("setup/client/updateBill");
		}else if(name.equals(FileDirectory.UPDATE_DELIVERED_PERSON_DETAILS.getFileDirectory())){
			 modelAndView = new ModelAndView("support/updateDeliveredPersonDetails");
		}else if(name.equals(FileDirectory.UPDATE_COURIER_AWB.getFileDirectory())){
			 modelAndView = new ModelAndView("support/updateCourierAwb");
		}else if(name.equals(FileDirectory.RECONNECT_BULK.getFileDirectory())){
			 modelAndView = new ModelAndView("support/reconnectBulk");
		}else if(name.equals(FileDirectory.REDIRECT_BULK.getFileDirectory())){
			 modelAndView = new ModelAndView("support/redirectBulk");
		}else if(name.equals(FileDirectory.CHANGE_AWB_SERIES_PRODUCT_TYPE.getFileDirectory())){
			 modelAndView = new ModelAndView("setup/masters/changeSeriesProductType");
		}else if(name.equals(FileDirectory.CLIENT_CODE.getFileDirectory())){
			 modelAndView = new ModelAndView("setup/client/clientCode");
		}else if(name.equals(FileDirectory.RAL_SALEORDER_UPDATE.getFileDirectory())){
			 modelAndView = new ModelAndView("/saleOrder/orderSkuScan");
		}else if(name.equals(FileDirectory.CLIENT_PRODUCT_SKU_RATE.getFileDirectory())){
			 modelAndView = new ModelAndView("/setup/client/clientProductSkuRate");
		}else{
			modelAndView = new ModelAndView("bulk/bulkUpload");
		}
		//FileDirectory.CLIENT_PRODUCT_SKU_RATE.getFileDirectory()
		BulkUploadBean bulkUploadBean = new BulkUploadBean();
		try {
			
			User user = sessionUserBean.getUser();
			BulkMaster bulkMaster = bulkMasterService.getMasterByKey(name);
			
			List<BulkHeader> headerList = new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values());
			String clientKey = null;
			String clientCategory = null;
			if(!"".equals(name) && (name.equals(FileDirectory.STAGINGSALEORDER.getFileDirectory()) || name.equals(FileDirectory.STAGINGBULKSALEORDER.getFileDirectory()))){
				clientKey = request.getParameter("clientKeyBulk");
				clientCategory = request.getParameter("clientCategoryBulk");
				if(clientKey != null && !"".equals(clientKey.trim()) && clientCategory != null && !"".equals(clientCategory.trim()) ){
					List<BulkHeader> qcHeaderList = clientService.getClientQcHeaders(clientKey, clientCategory);
					if(qcHeaderList != null && qcHeaderList.size() > 0){
						headerList.addAll(qcHeaderList);
					}
				}
			}
			
			List<Map<String, Object>> list = bulkService.getBulkData(headerList, file);
			if(!"".equals(name) && (name.equals(FileDirectory.STAGINGSALEORDER.getFileDirectory()) || name.equals(FileDirectory.STAGINGBULKSALEORDER.getFileDirectory()))){
				if(clientKey != null && !"".equals(clientKey.trim()) && clientCategory != null && !"".equals(clientCategory.trim()) ){
					if(list != null && list.size() > 0){
						list.get(0).put("clientKey", clientKey);
						list.get(0).put("clientCategory", clientCategory);
					}
				}
			}
			if(list != null && !list.isEmpty()){
				BulkUploadMasterBean bulkUploadMasterBean = new BulkUploadMasterBean();
				bulkUploadMasterBean.setRecords(list);
				bulkUploadMasterBean.setBulkHeaders(headerList);
				bulkUploadMasterBean.setBulkMaster(bulkMaster);
				if(user != null){
					bulkUploadMasterBean.setCurrentUser(user.getLoginId());
				}else{
					bulkUploadMasterBean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
				}
				bulkUploadMasterBean = bulkService.validateRecords(bulkUploadMasterBean, false);
				if(!"".equals(name) && name.equals(FileDirectory.SERVICEABLEPINCODE.getFileDirectory())){
					Object mainBean = applicationContext.getBean("serviceablePincodeServiceImpl");
					ServiceablePincodeServiceImpl impl = (ServiceablePincodeServiceImpl) mainBean;  
					//bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.STAGINGSALEORDER.getFileDirectory())){
					Object mainBean = applicationContext.getBean("stagingSaleOrderServiceImpl");
					StagingSaleOrderServiceImpl impl = (StagingSaleOrderServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.STAGINGBULKSALEORDER.getFileDirectory())){
					Object mainBean = applicationContext.getBean("stagingSaleOrderServiceImpl");
					StagingSaleOrderServiceImpl impl = (StagingSaleOrderServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.PICKUP_REQUEST_MASTER.getFileDirectory())){
					Object mainBean = applicationContext.getBean("saleOrderPickupRequestServiceImpl");
					SaleOrderPickupRequestServiceImpl impl = (SaleOrderPickupRequestServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				}else if(!"".equals(name) && name.equals(FileDirectory.THREEPL_STATUS_UPDATE.getFileDirectory())){
					Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
					SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
					//bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.UPLOAD_3PL_REMMITTANCE.getFileDirectory())){
					Object mainBean = applicationContext.getBean("remittanceFrom3PLServiceImpl");
					RemittanceFrom3PLServiceImpl impl = (RemittanceFrom3PLServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				}else if(!"".equals(name) && name.equals(FileDirectory.PINCODEMASTER.getFileDirectory())){
					Object mainBean = applicationContext.getBean("pincodeServiceImpl");
					PincodeServiceImpl impl = (PincodeServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				}else if(!"".equals(name) && name.equals(FileDirectory.UPLOADLBH.getFileDirectory())){
					Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
					SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean; 
					bulkUploadMasterBean = impl.uploadLbhBulk(bulkUploadMasterBean);
				}else if(!"".equals(name) && name.equals(FileDirectory.AWBSERIES.getFileDirectory())){
					Object mainBean = applicationContext.getBean("com.bmp.oms.service.masters.impl.AWBSeriesServiceImpl");
					AWBSeriesServiceImpl impl = (AWBSeriesServiceImpl) mainBean; 
					//bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.THREEPLCOURIERTOSALEORDER.getFileDirectory())){
					Object mainBean = applicationContext.getBean("courierServiceImpl");
					CourierServiceImpl impl = (CourierServiceImpl) mainBean; 
					//bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.BULK_INSCAN.getFileDirectory())){
					//Object mainBean = applicationContext.getBean("com.bmp.oms.service.saleorder.impl.InscanServiceImpl");
					Object mainBean = applicationContext.getBean("inscanServiceImpl");
					InscanServiceImpl impl = (InscanServiceImpl) mainBean; 
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				}else if(!"".equals(name) && name.equals(FileDirectory.CLIENT_SKU_WEIGTH_LOOKER.getFileDirectory())){
					Object mainBean = applicationContext.getBean("clientSKUWeigthLookerServiceImpl");
					ClientSKUWeigthLookerServiceImpl impl = (ClientSKUWeigthLookerServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.CTOC_BULK.getFileDirectory())){
					Object mainBean = applicationContext.getBean("packetServiceImpl");
					PacketServiceImpl impl = (PacketServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.UPDATE_CLIENT_BILL.getFileDirectory())){
					Object mainBean = applicationContext.getBean("clientBillingServiceImpl");
					ClientBillingServiceImpl impl = (ClientBillingServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.UPDATE_DELIVERED_PERSON_DETAILS.getFileDirectory())){
					Object mainBean = applicationContext.getBean("saleOrderExtraServiceImpl");
					SaleOrderExtraServiceImpl impl = (SaleOrderExtraServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.UPDATE_COURIER_AWB.getFileDirectory())){
					Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
					SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.updateCourierAwb(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.RECONNECT_BULK.getFileDirectory())){
					Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
					SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.reconnectBulk(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.REDIRECT_BULK.getFileDirectory())){
					Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
					SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.redirectBulk(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.CHANGE_AWB_SERIES_PRODUCT_TYPE.getFileDirectory())){
					Object mainBean = applicationContext.getBean("com.bmp.oms.service.masters.impl.AWBSeriesServiceImpl");
					AWBSeriesServiceImpl impl = (AWBSeriesServiceImpl) mainBean; 
					bulkUploadMasterBean = impl.changeProductType(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.CLIENT_CODE.getFileDirectory())){
					Object mainBean = applicationContext.getBean("com.bmp.oms.service.client.impl.ClientCodeServiceImpl");
					ClientCodeService impl = (ClientCodeServiceImpl) mainBean; 
					bulkUploadMasterBean = impl.clientCodeBulkUpload(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.CLIENT_PRODUCT_SKU_RATE.getFileDirectory())){
					Object mainBean = applicationContext.getBean("com.bmp.oms.service.client.impl.ClientProductSkuRateServiceImpl");
					ClientProductSkuRateServiceImpl impl = (ClientProductSkuRateServiceImpl) mainBean; 
					bulkUploadMasterBean = impl.clientProductSkuRateBulkUpload(bulkUploadMasterBean, request, response);
				}else if(!"".equals(name) && name.equals(FileDirectory.RAL_SALEORDER_UPDATE.getFileDirectory())){
					Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
					SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean; 
					bulkUploadMasterBean = impl.updateRalSaleOrderBulk(bulkUploadMasterBean);
				}else if(!"".equals(name) && name.equals(FileDirectory.STATEMASTER.getFileDirectory())){
					Object mainBean = applicationContext.getBean("stateServiceImpl");
					StateServiceImpl impl = (StateServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				}else if(!"".equals(name) && name.equals(FileDirectory.CITYMASTER.getFileDirectory())){
					Object mainBean = applicationContext.getBean("cityServiceImpl");
					CityServiceImpl impl = (CityServiceImpl) mainBean;  
					bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				}
				else{
					bulkUploadMasterBean = bulkService.uploadData(bulkUploadMasterBean);	
				}
				
				if(user != null){
					bulkUploadMasterBean.setCurrentUser(user.getLoginId());
				}else{
					bulkUploadMasterBean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
				}
				
				Long successCount = bulkUploadMasterBean.getSuccessRecords() == null ? 0L : bulkUploadMasterBean.getSuccessRecords().size();
				Long errorCount = bulkUploadMasterBean.getErrorRecords() == null ? 0L : bulkUploadMasterBean.getErrorRecords().size();
				
				String successFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkSuccessHeaderMap().values()),GlobalConstant.SUCCESS_STRING);
				String errorFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkFailureHeaderMap().values()),GlobalConstant.ERROR_STRING);
				bulkUploadBean.setUploadName(name);
				
				modelAndView.addObject("TotalRecord", successCount+errorCount);
				modelAndView.addObject("successRecord", successCount);
				modelAndView.addObject("errorRecord", errorCount);
				modelAndView.addObject("successFileName", successFileName);
				modelAndView.addObject("errorFileName", errorFileName);
				modelAndView.addObject("type", name);
				if(sessionWebUserBean.getWebUser() != null){
					modelAndView.addObject("C2C_SUCCESS_ORDER", bulkUploadMasterBean.getCurrentUser());
				}
				
			}else{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject(bulkUploadBean);
		
        return modelAndView;
    }
	
	@RequestMapping(value = "/uploadConverter", method = RequestMethod.POST)
	@ExceptionHandler({BulkException.class})
    public ModelAndView uploadConverter(@RequestParam("uploadId") String name, @RequestParam("files") MultipartFile file,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView;
		if(!"".equals(name) && name.equals("OrderConverter")){
			 modelAndView = new ModelAndView("courierServices/orderConverterBulkUpload");
		}else{
			modelAndView = new ModelAndView("bulk/bulkUpload");
		}
		
		BulkUploadBean bulkUploadBean = new BulkUploadBean();
		try {
			BulkMaster bulkMaster = bulkMasterService.getMasterByKey(FileDirectory.STAGINGSALEORDER.getFileDirectory());
			List<Map<String, Object>> list = bulkService.getConverterBulkData(file);
			if(list != null && !list.isEmpty()){
				BulkUploadMasterBean bulkUploadMasterBean = new BulkUploadMasterBean();
				bulkUploadMasterBean.setRecords(list);
				bulkUploadMasterBean.setBulkHeaders(new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values()));
				bulkUploadMasterBean.setBulkMaster(bulkMaster);
				bulkUploadMasterBean.setCurrentUser(sessionUserBean.getUser().getLoginId());
				
				//bulkUploadMasterBean = bulkService.validateRecords(bulkUploadMasterBean, false);
				if(!"".equals(name) && name.equals("OrderConverter")){
					bulkUploadMasterBean = bulkService.convertData(bulkUploadMasterBean, request, response);
				}else{
					bulkUploadMasterBean = bulkService.uploadData(bulkUploadMasterBean);	
				}
				
				Long successCount = bulkUploadMasterBean.getSuccessRecords() == null ? 0L : bulkUploadMasterBean.getSuccessRecords().size();
				Long errorCount = bulkUploadMasterBean.getErrorRecords() == null ? 0L : bulkUploadMasterBean.getErrorRecords().size();
				
				String successFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values()),GlobalConstant.SUCCESS_STRING);
				String errorFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkFailureHeaderMap().values()),GlobalConstant.ERROR_STRING);
				bulkUploadBean.setUploadName(name);
				
				modelAndView.addObject("TotalRecord", successCount+errorCount);
				modelAndView.addObject("successRecord", successCount);
				modelAndView.addObject("errorRecord", errorCount);
				modelAndView.addObject("successFileName", successFileName);
				modelAndView.addObject("errorFileName", errorFileName);
				modelAndView.addObject("type", name);
				
			}else{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject(bulkUploadBean);
		
        return modelAndView;
    }

	@RequestMapping(value = "/createBulkHeader", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean createBulkHeader(@RequestBody BulkHeader bulkHeader, HttpServletRequest request, HttpServletResponse response) {
		return bulkHeaderService.createBulkHeader(bulkHeader);
	}
	
	@RequestMapping(value = "/updateBulkHeader", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBulkHeader(@RequestBody BulkHeader bulkHeader, HttpServletRequest request, HttpServletResponse response) {
		return bulkHeaderService.updateBulkHeader(bulkHeader);
	}
	
	@RequestMapping(value = "/deleteBulkHeader/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteBulkHeader(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return bulkHeaderService.deleteBulkHeader(key);
	}
	
	@RequestMapping(value = "/checkBulkHeaderKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkBulkHeaderKeyAvailable(@PathVariable("key") String key) {
		return bulkHeaderService.checkBulkHeaderKeyAvailable(key);
	}
	
	@RequestMapping(value = "/getAllBulkHeaders", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllBulkHeaders (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return bulkHeaderService.getAllBulkHeaders(datatableRequestBean);
    }
	
	@RequestMapping(value = "/loadBulkValidations", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadBulkValidations(HttpServletRequest request, HttpServletResponse response) {
		return bulkValidationService.loadBulkValidations();
    }
	
	@RequestMapping(value = "/createBulkMaster", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean createBulkMaster(@RequestBody BulkMaster bulkMaster, HttpServletRequest request, HttpServletResponse response) {
		return bulkMasterService.createBulkMaster(bulkMaster);
	}
	
	@RequestMapping(value = "/updateBulkMaster", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateBulkMaster(@RequestBody BulkMaster bulkMaster, HttpServletRequest request, HttpServletResponse response) {
		return bulkMasterService.updateBulkMaster(bulkMaster);
	}
	
	@RequestMapping(value = "/getBulkMasterList", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getBulkMasterList(HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setStatus(ResponseStatus.SUCCESS);
		responseBean.setResponse(bulkMasterService.getBulkMasterList());
		return responseBean;
	}
	
	@RequestMapping(value = "/deleteBulkMaster/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteBulkMaster(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return bulkMasterService.deleteBulkMaster(key);
	}
	
	@RequestMapping(value = "/checkBulkMasterKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkBulkMasterKeyAvailable(@PathVariable("key") String key) {
		return bulkMasterService.checkBulkMasterKeyAvailable(key);
	}
	
	@RequestMapping(value = "/getAllBulkMasters", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllBulkMasters (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return bulkMasterService.getAllBulkMasters(datatableRequestBean);
    }
	
	@RequestMapping(value = "/loadBulkHeaders", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadBulkHeaders(HttpServletRequest request, HttpServletResponse response) {
		return bulkHeaderService.loadBulkHeaders();
    }
	
	@RequestMapping(value = "/loadBulkMasters", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadBulkMasters(HttpServletRequest request, HttpServletResponse response) {
		return bulkMasterService.loadBulkMasters();
    }
	
	
  @RequestMapping(value = "/restBulkUpload", method = RequestMethod.POST)
  public @ResponseBody ResponseBean restBulkUpload(@RequestParam("uploadId")String name, @RequestParam(value="orderType", required = false)String orderType,
		  @RequestParam("files") MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
  
  ResponseBean responseBean = new ResponseBean();
	try {
		
		User user = sessionUserBean.getUser();
		BulkMaster bulkMaster = bulkMasterService.getMasterByKey(name);
		
		List<BulkHeader> headerList = new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values());
		String clientKey = null;
		String clientCategory = null;
		if(!"".equals(name) && (name.equals(FileDirectory.STAGINGSALEORDER.getFileDirectory()) || name.equals(FileDirectory.STAGINGBULKSALEORDER.getFileDirectory()))){
			clientKey = request.getParameter("clientKeyBulk");
			clientCategory = request.getParameter("clientCategoryBulk");
			if(clientKey != null && !"".equals(clientKey.trim()) && clientCategory != null && !"".equals(clientCategory.trim()) ){
				List<BulkHeader> qcHeaderList = clientService.getClientQcHeaders(clientKey, clientCategory);
				if(qcHeaderList != null && qcHeaderList.size() > 0){
					headerList.addAll(qcHeaderList);
				}
			}
		}
		
		List<Map<String, Object>> list = bulkService.getBulkData(headerList, file);
		if(!"".equals(name) && (name.equals(FileDirectory.STAGINGSALEORDER.getFileDirectory()) || name.equals(FileDirectory.STAGINGBULKSALEORDER.getFileDirectory()))){
			if(clientKey != null && !"".equals(clientKey.trim()) && clientCategory != null && !"".equals(clientCategory.trim()) ){
				if(list != null && list.size() > 0){
					list.get(0).put("clientKey", clientKey);
					list.get(0).put("clientCategory", clientCategory);
				}
			}
		}
		if(list != null && !list.isEmpty()){
			BulkUploadMasterBean bulkUploadMasterBean = new BulkUploadMasterBean();
			bulkUploadMasterBean.setRecords(list);
			bulkUploadMasterBean.setBulkHeaders(headerList);
			bulkUploadMasterBean.setBulkMaster(bulkMaster);
			bulkUploadMasterBean.setUploadType(orderType);
			if(user != null){
				bulkUploadMasterBean.setCurrentUser(user.getLoginId());
			}else{
				bulkUploadMasterBean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
			}
			bulkUploadMasterBean = bulkService.validateRecords(bulkUploadMasterBean, false);
			if(!"".equals(name) && name.equals(FileDirectory.SERVICEABLEPINCODE.getFileDirectory())){
				Object mainBean = applicationContext.getBean("serviceablePincodeServiceImpl");
				ServiceablePincodeServiceImpl impl = (ServiceablePincodeServiceImpl) mainBean;  
				//bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.STAGINGSALEORDER.getFileDirectory())){
				Object mainBean = applicationContext.getBean("stagingSaleOrderServiceImpl");
				StagingSaleOrderServiceImpl impl = (StagingSaleOrderServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.STAGINGBULKSALEORDER.getFileDirectory())){
				Object mainBean = applicationContext.getBean("stagingSaleOrderServiceImpl");
				StagingSaleOrderServiceImpl impl = (StagingSaleOrderServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.CATALOGUEBUKLUPLOAD.getFileDirectory())){
				Object mainBean = applicationContext.getBean("catalogueServiceImpl");
				CatalogueServiceImpl impl = (CatalogueServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
			}else if(!"".equals(name) && name.equals(FileDirectory.PICKUP_REQUEST_MASTER.getFileDirectory())){
				Object mainBean = applicationContext.getBean("saleOrderPickupRequestServiceImpl");
				SaleOrderPickupRequestServiceImpl impl = (SaleOrderPickupRequestServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
			}else if(!"".equals(name) && name.equals(FileDirectory.THREEPL_STATUS_UPDATE.getFileDirectory())){
				Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
				SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				//bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.UPLOAD_3PL_REMMITTANCE.getFileDirectory())){
				Object mainBean = applicationContext.getBean("remittanceFrom3PLServiceImpl");
				RemittanceFrom3PLServiceImpl impl = (RemittanceFrom3PLServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
			}else if(!"".equals(name) && name.equals(FileDirectory.PINCODEMASTER.getFileDirectory())){
				Object mainBean = applicationContext.getBean("pincodeServiceImpl");
				PincodeServiceImpl impl = (PincodeServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
			}else if(!"".equals(name) && name.equals(FileDirectory.UPLOADLBH.getFileDirectory())){
				Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
				SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean; 
				bulkUploadMasterBean = impl.uploadLbhBulk(bulkUploadMasterBean);
			}else if(!"".equals(name) && name.equals(FileDirectory.AWBSERIES.getFileDirectory())){
				Object mainBean = applicationContext.getBean("com.bmp.oms.service.masters.impl.AWBSeriesServiceImpl");
				AWBSeriesServiceImpl impl = (AWBSeriesServiceImpl) mainBean; 
				//bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.THREEPLCOURIERTOSALEORDER.getFileDirectory())){
				Object mainBean = applicationContext.getBean("courierServiceImpl");
				CourierServiceImpl impl = (CourierServiceImpl) mainBean; 
				//bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.BULK_INSCAN.getFileDirectory())){
				//Object mainBean = applicationContext.getBean("com.bmp.oms.service.saleorder.impl.InscanServiceImpl");
				Object mainBean = applicationContext.getBean("inscanServiceImpl");
				InscanServiceImpl impl = (InscanServiceImpl) mainBean; 
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
			}else if(!"".equals(name) && name.equals(FileDirectory.CLIENT_SKU_WEIGTH_LOOKER.getFileDirectory())){
				Object mainBean = applicationContext.getBean("clientSKUWeigthLookerServiceImpl");
				ClientSKUWeigthLookerServiceImpl impl = (ClientSKUWeigthLookerServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.CTOC_BULK.getFileDirectory())){
				Object mainBean = applicationContext.getBean("packetServiceImpl");
				PacketServiceImpl impl = (PacketServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.UPDATE_CLIENT_BILL.getFileDirectory())){
				Object mainBean = applicationContext.getBean("clientBillingServiceImpl");
				ClientBillingServiceImpl impl = (ClientBillingServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.UPDATE_DELIVERED_PERSON_DETAILS.getFileDirectory())){
				Object mainBean = applicationContext.getBean("saleOrderExtraServiceImpl");
				SaleOrderExtraServiceImpl impl = (SaleOrderExtraServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.UPDATE_COURIER_AWB.getFileDirectory())){
				Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
				SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.updateCourierAwb(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.RECONNECT_BULK.getFileDirectory())){
				Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
				SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.reconnectBulk(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.CATALOGUEBUKLUPLOAD.getFileDirectory())){
				Object mainBean = applicationContext.getBean("catalogueServiceImpl");
				CatalogueServiceImpl impl = (CatalogueServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
			}else if(!"".equals(name) && name.equals(FileDirectory.REDIRECT_BULK.getFileDirectory())){
				Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
				SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.redirectBulk(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.CHANGE_AWB_SERIES_PRODUCT_TYPE.getFileDirectory())){
				Object mainBean = applicationContext.getBean("com.bmp.oms.service.masters.impl.AWBSeriesServiceImpl");
				AWBSeriesServiceImpl impl = (AWBSeriesServiceImpl) mainBean; 
				bulkUploadMasterBean = impl.changeProductType(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.CLIENT_CODE.getFileDirectory())){
				Object mainBean = applicationContext.getBean("com.bmp.oms.service.client.impl.ClientCodeServiceImpl");
				ClientCodeService impl = (ClientCodeServiceImpl) mainBean; 
				bulkUploadMasterBean = impl.clientCodeBulkUpload(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.CLIENT_PRODUCT_SKU_RATE.getFileDirectory())){
				Object mainBean = applicationContext.getBean("com.bmp.oms.service.client.impl.ClientProductSkuRateServiceImpl");
				ClientProductSkuRateServiceImpl impl = (ClientProductSkuRateServiceImpl) mainBean; 
				bulkUploadMasterBean = impl.clientProductSkuRateBulkUpload(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.RAL_SALEORDER_UPDATE.getFileDirectory())){
				Object mainBean = applicationContext.getBean("saleOrderServiceImpl");
				SaleOrderServiceImpl impl = (SaleOrderServiceImpl) mainBean; 
				bulkUploadMasterBean = impl.updateRalSaleOrderBulk(bulkUploadMasterBean);
			}else if(!"".equals(name) && name.equals(FileDirectory.CHANNEL_ORDER_BULK_UPLOAD.getFileDirectory())){
				Object mainBean = applicationContext.getBean("orderServiceImpl");
				OrderServiceImpl impl = (OrderServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean, request, response);
			}else if(!"".equals(name) && name.equals(FileDirectory.MARKETPLACE_SKU_MAPPING.getFileDirectory())){
				Object mainBean = applicationContext.getBean("marketplaceSkuMappingServiceImpl");
				MarketplaceSkuMappingServiceImpl impl = (MarketplaceSkuMappingServiceImpl) mainBean;  
				bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
			}else{
				bulkUploadMasterBean = bulkService.uploadData(bulkUploadMasterBean);	
			}
			
			if(user != null){
				bulkUploadMasterBean.setCurrentUser(user.getLoginId());
			}else{
				bulkUploadMasterBean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
			}
			
			Long successCount = bulkUploadMasterBean.getSuccessRecords() == null ? 0L : bulkUploadMasterBean.getSuccessRecords().size();
			Long errorCount = bulkUploadMasterBean.getErrorRecords() == null ? 0L : bulkUploadMasterBean.getErrorRecords().size();
			
			String successFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkSuccessHeaderMap().values()),GlobalConstant.SUCCESS_STRING);
			String errorFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkFailureHeaderMap().values()),GlobalConstant.ERROR_STRING);
			
			Map<String,Object>map=new HashMap<>();
			
			
			map.put("TotalRecord", successCount+errorCount);
			map.put("successRecord", successCount);
			map.put("errorRecord", errorCount);
			map.put("successFileName", successFileName);
			map.put("errorFileName", errorFileName);
			map.put("type", name);
			if(sessionWebUserBean.getWebUser() != null){
				map.put("C2C_SUCCESS_ORDER", bulkUploadMasterBean.getCurrentUser());
			}
			
			responseBean.setStatus(ResponseStatus.SUCCESS); 
			responseBean.setResponse(map);
		}else{
			responseBean.setStatus(ResponseStatus.FAIL); 
			responseBean.setMessage("File is empty.");
			
		}
	} catch (Exception e) {
		responseBean.setStatus(ResponseStatus.FAIL); 
		responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
		e.printStackTrace();
		e.getCause();
	}

  return responseBean;
  
  }
	@RequestMapping(value = "/uploadPOFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean uploadPOFile(MultipartHttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		BulkUploadBean bulkUploadBean = new BulkUploadBean();
		try {
			
			String name = request.getParameter("uploadId");
			String clientKey = request.getParameter("clientKey");
			String supplierKey = request.getParameter("supplierKey");
			String warehouseKey = request.getParameter("warehouseKey");
			String poDate = request.getParameter("poDate");
			MultipartFile file = request.getFile("files");

			User user = sessionUserBean.getUser();
			BulkMaster bulkMaster = bulkMasterService.getMasterByKey(name);
			if( bulkMaster != null) {
				List<BulkHeader> headerList = new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values());
				List<Map<String, Object>> list = bulkService.getBulkData(headerList, file);
				if (list != null && !list.isEmpty()) {
					BulkUploadMasterBean bulkUploadMasterBean = new BulkUploadMasterBean();
					bulkUploadMasterBean.setRecords(list);
					bulkUploadMasterBean.setBulkHeaders(headerList);
					bulkUploadMasterBean.setBulkMaster(bulkMaster);

					if (user != null) {
						bulkUploadMasterBean.setCurrentUser(user.getLoginId());
					} else {
						bulkUploadMasterBean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
					}
					bulkUploadMasterBean = bulkService.validateRecords(bulkUploadMasterBean, false);
					List<Map<String,Object>> successRecord =new ArrayList<>();
					successRecord= bulkUploadMasterBean.getSuccessRecords();
					successRecord.get(0).put("clientKey",clientKey);
					successRecord.get(0).put("supplierKey",supplierKey);
					successRecord.get(0).put("warehouseKey",warehouseKey);
					successRecord.get(0).put("poDate",poDate);
					if (!"".equals(name) && name.equals(FileDirectory.PO_UPLOAD.getFileDirectory())) {
						Object mainBean = applicationContext.getBean("purchaseOrderServiceImpl");
						PurchaseOrderServiceImpl impl = (PurchaseOrderServiceImpl) mainBean;
						bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
					} else {
						bulkUploadMasterBean = bulkService.uploadData(bulkUploadMasterBean);
					}

					if (user != null) {
						bulkUploadMasterBean.setCurrentUser(user.getLoginId());
					} else {
						bulkUploadMasterBean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
					}
					PurchaseOrder poList = (PurchaseOrder) bulkUploadMasterBean.getSuccessRecords().get(0).get("poList");
					int successLength = bulkUploadMasterBean.getSuccessRecords().get(0).size();
					if(successLength == 1 ){
						bulkUploadMasterBean.getSuccessRecords().remove(0);
					}else {
						bulkUploadMasterBean.getSuccessRecords().get(0).remove("poList");
					}

					Long successCount = bulkUploadMasterBean.getSuccessRecords() == null ? 0L : bulkUploadMasterBean.getSuccessRecords().size();
					Long errorCount = bulkUploadMasterBean.getErrorRecords() == null ? 0L : bulkUploadMasterBean.getErrorRecords().size();


					bulkUploadBean.setUploadName(name);

					Map<String,Object> finalReport = new HashMap<>();
					finalReport.put("TotalRecord", successCount + errorCount);
					finalReport.put("successRecord", successCount);
					finalReport.put("errorRecord", errorCount);
					if(successCount >0) {
						String successFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkSuccessHeaderMap().values()), GlobalConstant.SUCCESS_STRING);
						finalReport.put("successFileName", successFileName);
					}

					if(errorCount >0) {
						String errorFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkFailureHeaderMap().values()), GlobalConstant.ERROR_STRING);
						finalReport.put("errorFileName", errorFileName);
					}

					finalReport.put("type", name);
					finalReport.put("poList",poList);
					if (sessionWebUserBean.getWebUser() != null) {
						finalReport.put("C2C_SUCCESS_ORDER", bulkUploadMasterBean.getCurrentUser());
					}
					responseBean.setResponse(finalReport);
					responseBean.setStatus(ResponseStatus.SUCCESS);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_SAVING, null, null));
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/uploadStnBulkFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean uploadSTNFile(MultipartHttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		BulkUploadBean bulkUploadBean = new BulkUploadBean();
		try {
			String name = request.getParameter("uploadId");
			String clientKey = request.getParameter("clientKey");
			String transferType = request.getParameter("transferType");
			String stnType = request.getParameter("stnType");
			String fromWarehouseKey = request.getParameter("fromWarehouse");
			String toWarehouseKey = request.getParameter("toWarehouse");
			String supplierKey = request.getParameter("supplierKey");
			MultipartFile file = request.getFile("files");
			/*
			 * 
			 * @RequestParam("uploadId") String name,@RequestParam("clientKey") String
			 * clientKey,@RequestParam("transferType") String
			 * transferType,@RequestParam("stnType") String stnType,
			 * 
			 * @RequestParam("fromWarehouse") String
			 * fromWarehouseKey,@RequestParam("toWarehouse") String
			 * toWarehouseKey,@RequestParam("supplierKey") String
			 * supplierKey, @RequestParam("files") MultipartFile file
			 */
	
			User user = sessionUserBean.getUser();
			BulkMaster bulkMaster = bulkMasterService.getMasterByKey(name);
			if( bulkMaster != null) {
				List<BulkHeader> headerList = new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values());
				List<Map<String, Object>> list = bulkService.getBulkData(headerList, file);
				if (list != null && !list.isEmpty()) {
					BulkUploadMasterBean bulkUploadMasterBean = new BulkUploadMasterBean();
					bulkUploadMasterBean.setRecords(list);
					bulkUploadMasterBean.setBulkHeaders(headerList);
					bulkUploadMasterBean.setBulkMaster(bulkMaster);
	
					if (user != null) {
						bulkUploadMasterBean.setCurrentUser(user.getLoginId());
					} else {
						bulkUploadMasterBean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
					}
					bulkUploadMasterBean = bulkService.validateRecords(bulkUploadMasterBean, false);
					List<Map<String,Object>> successRecord =new ArrayList<>();
					successRecord= bulkUploadMasterBean.getSuccessRecords();
					successRecord.get(0).put("clientKey",clientKey);
					successRecord.get(0).put("transferType",transferType);
					successRecord.get(0).put("stnType",stnType);
					successRecord.get(0).put("fromWarehouseKey",fromWarehouseKey);
					successRecord.get(0).put("toWarehouseKey",toWarehouseKey);
					successRecord.get(0).put("supplierKey",supplierKey);
					
					if (!"".equals(name) && name.equals(FileDirectory.STN_BULK_UPLOAD.getFileDirectory())) {
						Object mainBean = applicationContext.getBean("stockTransferNoteServiceImpl");
						StockTransferNoteServiceImpl impl = (StockTransferNoteServiceImpl) mainBean;
						bulkUploadMasterBean = impl.addData(bulkUploadMasterBean);
					}
	
					if (user != null) {
						bulkUploadMasterBean.setCurrentUser(user.getLoginId());
					} else {
						bulkUploadMasterBean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
					}
					StockTransferNote stnList = (StockTransferNote) bulkUploadMasterBean.getSuccessRecords().get(0).get("stnList");
					int successLength = bulkUploadMasterBean.getSuccessRecords().get(0).size();
					if(successLength == 1 ){
						bulkUploadMasterBean.getSuccessRecords().remove(0);
					}else {
						bulkUploadMasterBean.getSuccessRecords().get(0).remove("stnList");
					}
	
					Long successCount = bulkUploadMasterBean.getSuccessRecords() == null ? 0L : bulkUploadMasterBean.getSuccessRecords().size();
					Long errorCount = bulkUploadMasterBean.getErrorRecords() == null ? 0L : bulkUploadMasterBean.getErrorRecords().size();
	
	
					bulkUploadBean.setUploadName(name);
	
					Map<String,Object> finalReport = new HashMap<>();
					finalReport.put("TotalRecord", successCount + errorCount);
					finalReport.put("successRecord", successCount);
					finalReport.put("errorRecord", errorCount);
					if(successCount >0) {
						String successFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkSuccessHeaderMap().values()), GlobalConstant.SUCCESS_STRING);
						finalReport.put("successFileName", successFileName);
					}
	
					if(errorCount >0) {
						String errorFileName = bulkService.writeFile(bulkUploadMasterBean, new ArrayList<BulkHeader>(bulkMaster.getBulkFailureHeaderMap().values()), GlobalConstant.ERROR_STRING);
						finalReport.put("errorFileName", errorFileName);
					}
	
					finalReport.put("type", name);
					finalReport.put("stnList",stnList);
					if (sessionWebUserBean.getWebUser() != null) {
						finalReport.put("C2C_SUCCESS_ORDER", bulkUploadMasterBean.getCurrentUser());
					}
					responseBean.setResponse(finalReport);
					responseBean.setStatus(ResponseStatus.SUCCESS);
				}
	
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_SAVING, null, null));
		}
		return responseBean;
	}
	
}