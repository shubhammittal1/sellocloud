package com.bmp.oms.controller;

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
import com.bmp.bean.incentive.IncentiveBean;
import com.bmp.model.app.incentive.Incentive;
import com.bmp.oms.service.incentive.IncentiveService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/incentive")
@Controller
public class IncentiveController {

	@Autowired
	@Qualifier("incentiveServiceImpl")
	private IncentiveService incentiveService;
	
	@RequestMapping(value = "/getAllCreatedIncentive", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllCreatedIncentive(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.getAllCreatedIncentive(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllApprovedIncentive", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllApprovedIncentive(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.getAllApprovedIncentive(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllClosedIncentive", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllClosedIncentive(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.getAllClosedIncentive(datatableRequestBean);
	}
	
	@RequestMapping(value = "/createIncentive", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean createIncentive(@RequestBody Incentive incentive,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.createIncentive(incentive);
	}
	
	@RequestMapping(value = "/deleteIncentive/{key}", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean getAllIntransitDrs(@PathVariable(value="key") String key,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.deleteIncentive(key);
	}
	
	@RequestMapping(value = "/markIncentiveApproved", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean markIncentiveApproved(@RequestParam(value="key") String incentiveKey,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.markIncentiveApproved(incentiveKey);
	}
	
	@RequestMapping(value = "/markIncentiveCredite", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean markIncentiveCredite(@RequestParam(value="key") String incentiveKey,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.markIncentiveCredite(incentiveKey);
	}
	
	@RequestMapping(value = "/loadIncentiveType", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean loadIncentiveType(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.loadIncentiveType();
	}
	
	@RequestMapping(value = "/generateIncentiveExcel", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean generateIncentiveExcel(@RequestBody Incentive incentive,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.generateIncentiveExcel(incentive);
	}
	
	@RequestMapping(value = "/getAllIncentiveSettings", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllIncentiveSettings(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return incentiveService.getAllIncentiveSettings(datatableRequestBean);
	}
	
	@RequestMapping(value = "/validateIncentive", method = RequestMethod.POST)
	public @ResponseBody ResponseBean validateClientBilling(MultipartHttpServletRequest request, HttpServletResponse response)throws Exception {
		MultipartFile file = request.getFile("file");
		String beanData = request.getParameter("beanData");
		ObjectMapper mapper = new ObjectMapper();
		IncentiveBean bean = mapper.readValue(beanData,IncentiveBean.class);
		return incentiveService.validateIncentive(bean, file);
	}
	
	@RequestMapping(value = "/finalizeIncentive", method = RequestMethod.POST)
	public @ResponseBody ResponseBean finalizeIncentive(@RequestBody IncentiveBean incentiveBean,HttpServletRequest request, HttpServletResponse response) {
		return incentiveService.finalizeIncentive(incentiveBean);
	}
}
