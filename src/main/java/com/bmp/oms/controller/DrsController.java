package com.bmp.oms.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
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
import com.bmp.bean.drs.DrsCloseBean;
import com.bmp.bean.drs.UploadPodBean;
import com.bmp.constant.MessageConstant;
import com.bmp.model.app.drs.BranchCashClosing;
import com.bmp.model.app.drs.Drs;
import com.bmp.oms.service.drs.BranchCashClosingService;
import com.bmp.oms.service.drs.DrsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@RequestMapping("/drs")
@Controller
public class DrsController {
	
	@Autowired
	@Qualifier("drsServiceImpl")
	private DrsService drsService;
	
	@Autowired
	@Qualifier("branchCashClosingServiceImpl")
	private BranchCashClosingService branchCashClosingService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/getAllNewDrs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllDrs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getAllNewDrs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllIntransitDrs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllIntransitDrs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getAllIntransitDrs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllPendingForPodDrs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllPendingForPodDrs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getAllPendingForPodDrs(datatableRequestBean);
	}
    
    @RequestMapping(value = "/getAllCloseDrs", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllCloseDrs(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getAllCloseDrs(datatableRequestBean);
	}
	
	@RequestMapping(value = "/createDrs/{key}", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean createDrs(@PathVariable(value="key") String awbNumbers, @RequestBody Drs drs,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.createDrs(drs,awbNumbers);
	}
	
	@RequestMapping(value = "/editDrs", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean editDrs(@RequestParam(value="key") String awbNumbers, @RequestBody Drs drs,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.editDrs(drs,awbNumbers);
	}
	
	@RequestMapping(value = "/deleteDrs/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteUser(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return drsService.deleteDrs(key);
    }
	
	@RequestMapping(value = "/editDrsSaleOrderList/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean editDrsSaleOrderList(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return drsService.editDrsSaleOrderList(key);
    }
	
	@RequestMapping(value = "/updateDrs/{key}", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean updateDrs(@PathVariable("key") String key, MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {	
		String buttonName  = request.getParameter("button");
		String val = request.getParameter("bean");
		//Map<String,MultipartFile> file = new HashMap<String,MultipartFile>();
		Map<String,List<MultipartFile>> file = new HashMap<String,List<MultipartFile>>();
		file.put("userSignature", request.getFiles("userSignature"));
		file.put("userIdimage", request.getFiles("userIdimage"));
		ObjectMapper mapper = new ObjectMapper();
		List<DrsCloseBean> list = mapper.readValue(val,TypeFactory.defaultInstance().constructCollectionType(List.class, DrsCloseBean.class));
		return drsService.updateDrs(list, key, buttonName,file);
	}
	
	@RequestMapping(value = "/viewDrs/{drsNumber}", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean viewDrs(@PathVariable("drsNumber") String drsNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.viewDrs(drsNumber);
	}
	
	@RequestMapping(value = "/getDrsByKey/{drsNumber}", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean getDrsByKey(@PathVariable("drsNumber") String drsNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getDrsByKey(drsNumber);
	}
	
	@RequestMapping(value = "/markIntransitDrs/{drsNumber}", method = RequestMethod.GET)
  	@ResponseBody
	public ResponseBean markIntransitDrs(@PathVariable("drsNumber") String drsNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.markIntransitDrs(drsNumber);
	}
	
	@RequestMapping(value = "/getShipmentAndDrsStatus/{drsNumber}", method = RequestMethod.GET)
  	@ResponseBody
	public ResponseBean getShipmentAndDrsStatus(@PathVariable("drsNumber") String drsNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getShipmentAndDrsStatus(drsNumber);
	}
	
	@RequestMapping("/createPDF/{drsKey}")
	@ResponseBody
    public void createPDF(@PathVariable("drsKey") String drsKey, HttpServletRequest request, HttpServletResponse response) {
		String fileName = "PickupSheetReports.pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		try {
			drsService.createPDF(fileName,drsKey, request);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = drsService.convertPDFToByteArrayOutputStream(fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
	
	@RequestMapping(value = "uploadDrsScannedFile", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean uploadDrsScannedFile(MultipartHttpServletRequest request,HttpServletResponse response){
		UploadPodBean uploadItem = new UploadPodBean();
		uploadItem.setFileList(request.getFiles("fileList"));
		uploadItem.setKey(request.getParameter("key"));
		return  drsService.uploadDrsPod(uploadItem);
	}
	
	/*@RequestMapping( value="/uploadDrsScannedFile", method = RequestMethod.POST)
	public ModelAndView uploadDrsScannedFile(@ModelAttribute("uploadDrsFile") UploadPodBean uploadItem,
			HttpServletResponse response, HttpServletRequest request) {
		    drsService.uploadDrsPod(uploadItem);
		return new ModelAndView("drs/pendingForPodDrs");
	}*/
	
	//Download the uploaded images file
	@RequestMapping("/downloadDrsScannedFile")
	@ResponseBody
		public void downloadDrsScannedFile(@RequestParam(value="key") String drsNo, HttpServletResponse response) throws Exception{
		String path = messageSource.getMessage(MessageConstant.DRS_PATH, null, null);
		drsService.downloadPodDrsDoc(drsNo,path,response);
	}
	
	@RequestMapping("/downloadDrsScannedFileNew")
	@ResponseBody
		public void downloadDrsScannedFileNew(@RequestParam(value="key") String drsNo, HttpServletResponse response, HttpServletRequest request) {
		String path = messageSource.getMessage(MessageConstant.DRS_PATH, null, null);
		drsService.downloadPodDrsDocNew(drsNo,path,response, request);
	}
	
	@RequestMapping("/downloadShipmentPod")
	@ResponseBody
		public void downloadShipmentPod(@RequestParam(value="key") String key, HttpServletResponse response, HttpServletRequest request) throws Exception{
		drsService.downloadShipmentPod(key,response, request);
	}
	
	@RequestMapping("/downloadShipmentPodNew")
	@ResponseBody
		public void downloadShipmentPodNew(@RequestParam(value="key") String key,HttpServletRequest request, HttpServletResponse response) throws Exception{
		drsService.downloadShipmentPodNew(key,response, request);
	}
	
	@RequestMapping("/shipmentPOD")
	@ResponseBody
		public void shipmentPod(@RequestParam(value="key") String key,HttpServletRequest request, HttpServletResponse response) throws Exception{
		drsService.downloadBulkPOD(key,response, request);
	}
	
	@RequestMapping(value = "/getBranchCodCashClosing", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getBranchCodCashClosing (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.getBranchCodCashClosing (datatableRequestBean);
	}
	
	@RequestMapping(value = "/getBranchClosingDetails", method = RequestMethod.GET)
  	@ResponseBody
	public ResponseBean getBranchClosingDetails(@RequestParam(value = "branch", required = true) String branch , 
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getBranchClosingDetails (branch);
	}

	@RequestMapping(value = "/saveBranchClosing", method = RequestMethod.POST)
  	@ResponseBody
	public ResponseBean saveBranchClosing(@RequestBody BranchCashClosing branchCashClosing, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.saveBranchClosing (branchCashClosing);
	}
	
	@RequestMapping("/createBranchClosingPDF")
	@ResponseBody
    public void createBranchClosingPDF(@RequestParam(value="closingCode", required=true) String closingCode, HttpServletRequest request, HttpServletResponse response) {
		
		String fileName = "BranchClosingPDF.pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		
		try {
			branchCashClosingService.createBranchClosingPDF(fileName, closingCode, request);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = drsService.convertPDFToByteArrayOutputStream(fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
	
	@RequestMapping(value = "/getBranchCodBankDepositDetails", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getBranchCodBankDepositDetails (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.getBranchCodBankDepositDetails (datatableRequestBean);
	}
	
	@RequestMapping(value = "/getClosingCodeAndBankDetails", method = RequestMethod.GET)
  	@ResponseBody
	public ResponseBean getClosingCodeAndBankDetails(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.getClosingCodeAndBankDetails ();
	}
	
	@RequestMapping(value = "/saveBranchDepositSlip", method = RequestMethod.POST)
	public @ResponseBody ResponseBean saveBranchDepositSlip (MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		MultipartFile file = request.getFile("bankSlip");
		
		param.put("bankSlip", file);
		param.put("depositDate", request.getParameter("depositDate"));
		param.put("closingCode", request.getParameter("closingCode"));
		param.put("bankName", request.getParameter("bankName"));
		param.put("accNo", request.getParameter("accNo"));
		param.put("transactionID", request.getParameter("transactionID"));
		param.put("depositeAmount", request.getParameter("depositeAmount"));
		
        return branchCashClosingService.saveBranchDepositSlip (param) ;
	}
	
	@RequestMapping("/downloadBankSlip")
	@ResponseBody
	public void downloadBankSlip(@RequestParam(value="bankSlipName", required=true) String bankSlipName, HttpServletResponse response) throws Exception{
		branchCashClosingService.downloadBankSlip(bankSlipName,response);
	}
	
	@RequestMapping(value = "/getOpenCashClosing", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getOpenCashClosing (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.getOpenCashClosing (datatableRequestBean);
	}
	
	@RequestMapping(value = "/verifyAndCloseBranchClosing", method = RequestMethod.GET)
  	@ResponseBody
	public ResponseBean verifyAndCloseBranchClosing(@RequestParam(value="closingCode", required=true) String closingCode,@RequestParam(value="remark") String remark, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.verifyAndCloseBranchClosing (closingCode,remark);
	}
	
	@RequestMapping(value = "/getCloseCashClosing", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getCloseCashClosing (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.getCloseCashClosing (datatableRequestBean);
	}
	
	@RequestMapping(value = "/getBranchClosingAmount", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean getBranchClosingAmount (@RequestParam(value="key", required=true) String key,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.getBranchClosingAmount (key);
	}
	
	@RequestMapping(value = "/searchPod", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean searchPod(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.searchPod(datatableRequestBean.getSearch());
	}
	
	@RequestMapping(value = "/getPentingForDrsCount", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean getPentingForDrsCount(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getPentingForDrsCount();
	}
	
	@RequestMapping(value = "/pendingShipmentForCODDeposit", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean pendingShipmentForCODDeposit (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.pendingShipmentForCODDeposit (datatableRequestBean);
	}
	
	@RequestMapping(value = "/pendingShipmentForCODReceive", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean pendingShipmentForCODReceive (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.pendingShipmentForCODReceive (datatableRequestBean);
	}
	
	@RequestMapping(value = "/pendingShipmentForCODVerify", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean pendingShipmentForCODVerify (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.pendingShipmentForCODVerify (datatableRequestBean);
	}
	
	@RequestMapping(value = "/shipmentForCODVerified", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean shipmentForCODVerified (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return branchCashClosingService.shipmentForCODVerified (datatableRequestBean);
	}
	
	@RequestMapping(value = "/trackDrsPacketDetails/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean trackDrsPacketDetails(@PathVariable("key") String key, HttpServletRequest request,HttpServletResponse response) {
		return drsService.trackDrsPacketDetails(key);
	}
	
	@RequestMapping("/downloadBulkPOD")
	@ResponseBody
		public void downloadBulkPOD(@RequestParam(value="awbNumber") String awbNumber, HttpServletResponse response,HttpServletRequest request) throws Exception{
		drsService.downloadBulkPOD(awbNumber,response,request);
	}
	
	@RequestMapping("/ndrImage")
	@ResponseBody
		public void ndrImage(@RequestParam(value="awbNumber") String awbNumber, HttpServletResponse response,HttpServletRequest request) throws Exception{
		drsService.ndrImage(awbNumber,response,request);
	}
	
	@RequestMapping("/downloadDrsExcell/{DRS}")
	@ResponseBody
		public void downloadDrsExcell(@PathVariable(value="DRS") String DRS, HttpServletResponse response,HttpServletRequest request) throws Exception{
		drsService.exportDrsDeliveryDetails(DRS,response,request);
	}
}