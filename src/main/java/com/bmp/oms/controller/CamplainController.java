package com.bmp.oms.controller;

import java.io.IOException;
import java.util.HashMap;
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
import com.bmp.model.app.client.ClientNew;
import com.bmp.model.app.saleorder.Camplain;
import com.bmp.model.app.saleorder.CamplainHistory;
import com.bmp.oms.service.saleorder.CamplainService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/camplain")
public class CamplainController {
	
	@Autowired
	@Qualifier("camplainServiceImpl")
	private CamplainService camplainService;
	
	@RequestMapping(value = "/getAllNewCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllNewCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAllNewCamplains(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllOpenCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllOpenCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAllOpenCamplains(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllClosedCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClosedCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAllClosedCamplains(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAgentAssignedCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAgentAssignedCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAgentAssignedCamplains(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAgentOpenCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAgentOpenCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAgentOpenCamplains(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAgentClosedCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAgentClosedCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAgentClosedCamplains(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAgentWorkingCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAgentWorkingCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAgentWorkingCamplains(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAgentPrtialWorkingCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAgentPrtialWorkingCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAgentPrtialWorkingCamplains(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createCamplain", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createCamplain(@RequestBody Camplain camplain,HttpServletRequest request, HttpServletResponse response) {
		return camplainService.createCamplain(camplain);
    }
	
	@RequestMapping(value = "/updateCamplain", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateCamplain(@RequestBody Camplain camplain, HttpServletRequest request, HttpServletResponse response) {
		return camplainService.updateCamplain(camplain);
    }
	
	@RequestMapping(value = "/deleteCamplain/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteCamplain(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return camplainService.deleteCamplain(key);
    }
	
	@RequestMapping(value = "/camplainAssingeAPI/{camplainKey}/{agentKey}", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean camplainAssingeAPI(@PathVariable("camplainKey") String camplainKey,@PathVariable("agentKey") String agentKey, HttpServletRequest request, HttpServletResponse response) {
		return camplainService.camplainAssingeAPI(camplainKey,agentKey);
    }
	
	@RequestMapping(value = "/markAsWorking/{camplainKey}", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean markAsWorking(@PathVariable("camplainKey") String camplainKey, HttpServletRequest request, HttpServletResponse response) {
		return camplainService.markAsWorking(camplainKey);
    }
	
	@RequestMapping(value = "/getComplainByKey/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getComplainByKey(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return camplainService.getComplainByKey(key);
    }
	
	@RequestMapping(value = "/createCamplainHistory", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createCamplainHistory(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		CamplainHistory camplainHistory = null;
		try {
			doc.put("fileDoc", request.getFile("doc"));
			
			String camplainHistoryBean = request.getParameter("camplainHistoryBean");
			ObjectMapper mapper = new ObjectMapper();
			camplainHistory = mapper.readValue(camplainHistoryBean, CamplainHistory.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return camplainService.createCamplainHistory(camplainHistory,doc);
    }
	
	@RequestMapping(value = "/getAllclientCamplains", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllclientCamplains (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return camplainService.getAllclientCamplains(datatableRequestBean);
    }
	@RequestMapping(value = "/getAllComplainStatusCount", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean getAllComplainStatusCount(HttpServletRequest request,HttpServletResponse response) {
		return camplainService.getAllComplainStatusCount();
	}
	
	@RequestMapping("/downloadComplainDoc")
	@ResponseBody
		public void downloadComplainDoc(@RequestParam(value="key") String fileName, HttpServletResponse response) throws Exception{
		camplainService.downloadDoc(fileName,response);
	}

}
