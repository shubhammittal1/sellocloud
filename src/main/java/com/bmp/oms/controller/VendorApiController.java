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
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.oms.service.api.VendorApiService;

@Controller
@RequestMapping("/vendorApi")
public class VendorApiController {
	
	@Autowired
	@Qualifier("vendorApiServiceImpl")
	private VendorApiService vendorApiService;
	
	/*@RequestMapping(value = "/getStatusUpdateApi", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getStatusUpdateApi(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return vendorApiService.getVendorApiCall(null, null);
	}*/
	
	@RequestMapping(value = "/getAllApiConfig", method = RequestMethod.POST)
	@ResponseBody
        public DatatableResponseBean getAllApiConfig (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return vendorApiService.getAllApiConfig(datatableRequestBean);
       }

	@RequestMapping(value = "/createApiConfig", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createApiConfig(@RequestBody VendorApiBean apiBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        return vendorApiService.createApiConfig(apiBean);
	}
	
	@RequestMapping(value = "/updateApiConfig", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateApiConfig(@RequestBody VendorApiBean apiBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        return vendorApiService.updateApiConfig(apiBean);
	}
	
	@RequestMapping(value = "/deleteApiConfig/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteApiConfig(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return vendorApiService.deleteApiConfig(key);
    }
	
	@RequestMapping(value = "/checkApiConfigKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkApiConfigKeyAvailable (@PathVariable("key") String key) {
		return vendorApiService.checkApiConfigKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllApiStatusMapping", method = RequestMethod.POST)
	@ResponseBody
        public DatatableResponseBean getAllApiStatusMapping (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return vendorApiService.getAllApiStatusMapping(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createApiStatusMapping", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createApiStatusMapping(@RequestBody VendorStatusMappingBean vendorStatusMappingBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
		return vendorApiService.createApiStatusMapping(vendorStatusMappingBean);
	}
	
	@RequestMapping(value = "/checkApiStatusMappingKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkApiStatusMappingKeyAvailable (@PathVariable("key") String key) {
		return vendorApiService.checkApiStatusMappingKeyAvailable(key);
    }
	
	@RequestMapping(value = "/updateApiStatusMapping", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateApiStatusMapping(@RequestBody VendorStatusMappingBean vendorStatusMappingBean, HttpServletRequest request, HttpServletResponse response) {
		return vendorApiService.updateApiStatusMapping(vendorStatusMappingBean);
    }
	
	@RequestMapping(value = "/deleteApiStatusMapping/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteApiStatusMapping(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return vendorApiService.deleteApiStatusMapping(key);
    }
}
