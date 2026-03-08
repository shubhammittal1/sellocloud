package com.bmp.oms.controller;

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
import com.bmp.model.app.coloader.Coloader;
import com.bmp.model.app.coloader.ColoaderRateList;
import com.bmp.oms.service.coloader.ColoaderRateListService;
import com.bmp.oms.service.coloader.ColoaderService;
import com.bmp.oms.service.masters.ProductTypeService;
import com.bmp.oms.service.masters.RateZoneService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/coloader")
public class ColoaderController {
	
	@Autowired
	@Qualifier("coloaderService")
	private ColoaderService coloaderService;
	
	@Autowired
	@Qualifier("coloaderRateListService")
	private ColoaderRateListService coloaderRateListService;
	
	@Autowired
	@Qualifier("productTypeServiceImpl")
	private ProductTypeService productTypeService;

	@Autowired
	@Qualifier("rateZoneServiceImpl")
	private RateZoneService rateZoneService;
	
	@RequestMapping(value = "/getAllColoader", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllColoader (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return coloaderService.getAllColoader(datatableRequestBean);
    }

	@RequestMapping(value = "/createColoader", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createColoader(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("logoImg", request.getFile("logoImageName"));
		doc.put("moaDoc", request.getFile("moaDocument"));
		doc.put("additionalDoc1", request.getFile("additionalDocument1"));
		doc.put("additionalDoc2", request.getFile("additionalDocument2"));
		doc.put("cancelCheque", request.getFile("cancelCheque"));
		doc.put("panCard", request.getFile("panCard"));
		
		String coloaderBean = request.getParameter("coloaderBean");
		ObjectMapper mapper = new ObjectMapper();
		Coloader coloader = mapper.readValue(coloaderBean, Coloader.class);
        return coloaderService.createColoader(coloader,doc);
	}
	
	@RequestMapping(value = "/updateColoader", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateClient(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("logoImg", request.getFile("logoImageName"));
		doc.put("moaDoc", request.getFile("moaDocument"));
		doc.put("additionalDoc1", request.getFile("additionalDocument1"));
		doc.put("additionalDoc2", request.getFile("additionalDocument2"));
		doc.put("cancelCheque", request.getFile("cancelCheque"));
		doc.put("panCard", request.getFile("panCard"));
		
		String coloaderBean = request.getParameter("coloaderBean");
		ObjectMapper mapper = new ObjectMapper();
		Coloader coloader = mapper.readValue(coloaderBean, Coloader.class);
        return coloaderService.updateColoader(coloader, doc);
	}
	
	@RequestMapping(value = "/deleteColoader/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteColoader(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return coloaderService.deleteColoader(key);
    }
	
	@RequestMapping(value = "/checkColoaderKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkColoaderKeyAvailable (@PathVariable("key") String key) {
		return coloaderService.checkColoaderKeyAvailable(key);
    }
	
	//-------------
	@RequestMapping(value = "/getAllColoaderRateList", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllColoaderRateList (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return coloaderRateListService.getAllColoaderRateList(datatableRequestBean);
    }

	@RequestMapping(value = "/createColoaderRateList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createColoaderRateList(@RequestBody ColoaderRateList coloaderRateList, HttpServletRequest request, HttpServletResponse response) {
		return coloaderRateListService.createColoaderRateList(coloaderRateList);
    }
	

	@RequestMapping(value = "/updateColoaderRateList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateColoaderRateList(@RequestBody ColoaderRateList coloaderRateList, HttpServletRequest request, HttpServletResponse response) {
		return coloaderRateListService.updateColoaderRateList(coloaderRateList);
    }
	
	@RequestMapping(value = "/deleteColoaderRateList/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteColoaderRateList(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return coloaderRateListService.deleteColoaderRateList(key);
    }
	
	@RequestMapping(value = "/checkColoaderRateListKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkColoaderRateListKeyAvailable (@PathVariable("key") String key) {
		return coloaderRateListService.checkColoaderRateListKeyAvailable(key);
    }
	
	@RequestMapping(value = "/loadColoaders", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadColoaders(@RequestParam(value = "coloaderKey") String coloaderKey, HttpServletRequest request, HttpServletResponse response) {
		return coloaderService.loadColoaders();
    }
	@RequestMapping(value = "/loadColoadersByClientKey", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadColoadersByClientKey(@RequestParam(value = "clientKey") String clientKey, HttpServletRequest request, HttpServletResponse response) {
		return coloaderService.loadColoadersByClientKey(clientKey);
    }
	
    
	@RequestMapping(value = "/loadProductTypes", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadProductTypes( HttpServletRequest request, HttpServletResponse response) {
		return productTypeService.loadProductTypes();
    }
	

	@RequestMapping(value = "/loadColoaderRateZones/{coloaderKey}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean loadColoaderRateZones(@PathVariable("coloaderKey") String coloaderKey) {
		return coloaderService.loadColoaderRateZones(coloaderKey);
    }
	//--------------coloaderListOfBranch
	
	@RequestMapping(value = "/checkColoaderTokenAvailable/{token}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean checkColoaderTokenAvailable(@PathVariable("token") String token) {
		return coloaderService.checkColoaderTokenAvailable(token);
    }
	
	@RequestMapping(value = "/coloaderListOfBranch/{branchKey}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean coloaderListOfBranch(@PathVariable("branchKey") String branchKey) {
		return coloaderService.coloaderListOfBranch(branchKey);
    }
	
	@RequestMapping(value = "/manifestColoaders/{sourceBranchKey}/{destinationBranchKey}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean manifestColoaders(@PathVariable("sourceBranchKey") String sourceBranchKey, @PathVariable("destinationBranchKey") String destinationBranchKey) {
		return coloaderService.manifestColoaders(sourceBranchKey, destinationBranchKey);
    }
}