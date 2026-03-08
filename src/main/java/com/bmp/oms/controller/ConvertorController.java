package com.bmp.oms.controller;

import java.util.Map;

import javax.servlet.ServletContext;
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
import org.springframework.web.servlet.ModelAndView;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.model.app.convertor.ConvertorConfig;
import com.bmp.oms.service.bulk.BulkMasterService;
import com.bmp.oms.service.convertor.ConvertorConfigService;


@Controller
@RequestMapping("/convertor")
public class ConvertorController {
	
	@Autowired
	@Qualifier("convertorConfigServiceImpl")
	private ConvertorConfigService convertorConfigService;

	@Autowired
	@Qualifier("bulkMasterService")
	private BulkMasterService bulkMasterService;
	
	@Autowired
	ServletContext context; 
	
	
	
	@RequestMapping(value = "/getAllConvertors", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllConvertors (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return convertorConfigService.getAllConvertorConfig(datatableRequestBean);
    }
	
	@RequestMapping(value = "/checkConvertorKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkConvertorKeyAvailable(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return convertorConfigService.checkConvertorKeyAvailable(key);
    }
	
	@RequestMapping(value = "/createConvertor", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createConvertor(@RequestBody ConvertorConfig convertor, HttpServletRequest request, HttpServletResponse response) {
		return convertorConfigService.createConvertorConfig(convertor);
    }
	
	@RequestMapping(value = "/updateConvertor", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateConvertor(@RequestBody ConvertorConfig convertor, HttpServletRequest request, HttpServletResponse response) {
		return convertorConfigService.updateConvertorConfig(convertor);
    }
	
	@RequestMapping(value = "/deleteConvertor/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteConvertor(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return convertorConfigService.deleteConvertorConfig(key);
    }
	
	@RequestMapping(value = "/getBulkHeader/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBulkHeader(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return bulkMasterService.getBulkHeader(key);
    }
	
	@RequestMapping(value = "/getConvertorConfig", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getConvertor( HttpServletRequest request, HttpServletResponse response) {
		return convertorConfigService.getConvertorConfig();
    }
	
	@RequestMapping(value="/fileUpload", method = RequestMethod.POST)
	public ModelAndView fileUpload(@RequestParam("files") MultipartFile file , @RequestParam("convertorConfigKey") String convertorConfigKey, 
			@RequestParam(value="isDataUpload",required=false) String isDataUpload, HttpServletRequest request,HttpServletResponse response) {
		ResponseBean responseBean = convertorConfigService.fileUpload(file, convertorConfigKey, request, response);
		Map<String,Object> obj = (Map<String, Object>) responseBean.getResponse();
		return new ModelAndView("convertor/convertorUpload","data",obj);	
	}
	
	@RequestMapping(value="/downloadFile", method = RequestMethod.GET)
	public void downloadFile(@RequestParam("fileName") String fileName, HttpServletRequest request,HttpServletResponse response){
		convertorConfigService.downloadFile(fileName, request, response);
	}
}	
