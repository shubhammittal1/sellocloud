package com.bmp.oms.controller;

import java.util.List;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.courier.ThreeplScanBean;
import com.bmp.bean.drs.UploadPodBean;
import com.bmp.constant.MessageConstant;
import com.bmp.model.app.threePL.ThreePLDocketBean;
import com.bmp.oms.service.threePL.ThreePLDocketBeanService;

@Controller
@RequestMapping("/3pl")
public class ThreePLDocketController {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("threePLDocketBeanServiceImpl")
	private ThreePLDocketBeanService threePLDocketBeanService;
	
	@RequestMapping(value = "/getAllThreeNewThreePLDocketList", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllThreeNewThreePLDocketList (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return threePLDocketBeanService.getAllThreeNewThreePLDocketList(datatableRequestBean);
    }
	
	@RequestMapping(value = "/total3PlShipment/{branchKey}/{courierKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean total3PlShipment(@PathVariable("branchKey") String branchKey, @PathVariable("courierKey") String courierKey, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.totalShipment(branchKey, courierKey);
    }
	
	@RequestMapping(value = "/get3PlShipment", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean get3PlShipment(@RequestBody ThreeplScanBean threeplScanBean, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.get3PlShipment(threeplScanBean);
    }
	
	@RequestMapping(value = "/get3PlCourier", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean get3PlCourier( HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.get3PlCourier();
    }
	
	@RequestMapping(value = "/get3PlCourierNew", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean get3PlCourierNew(@RequestParam("clientKey") String clientKey,  HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.get3PlCourierNew(clientKey);
    }
	
	@RequestMapping(value = "/addThreePLDocket", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addThreePLDocket(@RequestBody ThreePLDocketBean threePLDocketBean, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.addThreePLDocket(threePLDocketBean);
    }
	
	@RequestMapping(value = "/updateThreePLDocket", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateThreePLDocket(@RequestBody ThreePLDocketBean threePLDocketBean, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.updateThreePLDocket(threePLDocketBean);
    }
	
	@RequestMapping(value = "/deleteThreePLDocket/{threePlKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteThreePLDocket(@PathVariable("threePlKey") String threePlKey, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.deleteThreePLDocket(threePlKey);
    }
	
	@RequestMapping(value = "/getTotalShipmentIn3Pl/{threePlKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getTotalShipmentIn3Pl(@PathVariable("threePlKey") String threePlKey, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.getTotalShipmentIn3Pl(threePlKey);
    }
	
	@RequestMapping(value = "/markIntransit3Pl/{threePlKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean markIntransit3Pl(@PathVariable("threePlKey") String threePlKey, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.markIntransit3Pl(threePlKey);
    }
    
    @RequestMapping(value = "/get3PlView/{threePlKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean get3PlView(@PathVariable("threePlKey") String threePlKey, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.get3PlView(threePlKey);
    }
    
    @RequestMapping(value = "/getAllIntransitThreePLDocketList", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllIntransitThreePLDocketList (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return threePLDocketBeanService.getAllIntransitThreePLDocketList(datatableRequestBean);
    }
    
	@RequestMapping(value = "/getAllThreePlManifestPod", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllThreePlManifestPod (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
	    return threePLDocketBeanService.getAllThreePlManifestPod(datatableRequestBean);
	}
    
    @RequestMapping(value = "upload3plPodScannedFile", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean upload3plPodScannedFile(MultipartHttpServletRequest request,HttpServletResponse response){
		UploadPodBean uploadItem = new UploadPodBean();
		uploadItem.setFileList(request.getFiles("fileList"));
		uploadItem.setKey(request.getParameter("key"));
		return  threePLDocketBeanService.upload3plPod(uploadItem);
	}
    
    @RequestMapping("/download3plManifestPod")
	@ResponseBody
		public void download3plManifestPod(@RequestParam(value="key") String threePlManifestKey, HttpServletResponse response) throws Exception{
		String path = messageSource.getMessage(MessageConstant.THREEPL_PATH, null, null);
		threePLDocketBeanService.download3plManifestPod(threePlManifestKey,path,response);
	}
    
    @RequestMapping(value = "/rollbackAmountDeduction/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean rollbackAmountDeduction(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.rollbackAmountDeduction(key);
    }
    
    @RequestMapping(value = "/getClientShipmentPendingToHandover", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getClientShipmentPendingToHandover(@RequestParam(value = "clientkey") String clientKey,@RequestParam(value = "courierKey") String courierKey , HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.getClientShipmentPendingToHandover(clientKey, courierKey);
    }
    
    @RequestMapping(value = "/markOrderIntransit/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean markOrderIntransit(@PathVariable ("key")  String awbNumbers, HttpServletRequest request, HttpServletResponse response) {
		return threePLDocketBeanService.markOrderIntransit(awbNumbers);
    }
}
