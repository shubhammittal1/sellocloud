package com.bmp.oms.controller;

import java.util.HashMap;
import java.util.List;
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
import com.bmp.bean.courier.ServiceabilityCheckBean;
import com.bmp.constant.BusinessType;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.ResponseStatus;
import com.bmp.model.app.courier.ClientCourier;
import com.bmp.model.app.courier.Courier;
import com.bmp.model.app.courier.CourierAuthConfig;
import com.bmp.model.app.courier.CourierConfiguration;
import com.bmp.model.app.courier.CourierPriority;
import com.bmp.model.app.courier.CourierPriorityTemplate;
import com.bmp.model.app.courier.CourierRateList;
import com.bmp.model.app.courier.ServiceLevel;
import com.bmp.oms.service.client.ClientDashboardService;
import com.bmp.oms.service.courier.ClientCourierService;
import com.bmp.oms.service.courier.CourierAuthConfigService;
import com.bmp.oms.service.courier.CourierConfigurationService;
import com.bmp.oms.service.courier.CourierPriorityService;
import com.bmp.oms.service.courier.CourierPriorityTemplateService;
import com.bmp.oms.service.courier.CourierRateListService;
import com.bmp.oms.service.courier.CourierService;
import com.bmp.oms.service.courier.ServiceLevelService;
import com.bmp.oms.service.masters.ProductTypeService;
import com.bmp.oms.service.masters.RateZoneService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/courier")
public class CourierController {
	
	@Autowired
	@Qualifier("courierServiceImpl")
	private CourierService courierService;
	
	@Autowired
	@Qualifier("courierRateListService")
	private CourierRateListService courierRateListService;
	
	@Autowired
	@Qualifier("productTypeServiceImpl")
	private ProductTypeService productTypeService;

	@Autowired
	@Qualifier("rateZoneServiceImpl")
	private RateZoneService rateZoneService;
	
	@Autowired
	@Qualifier("courierPriorityServiceImpl")
	private CourierPriorityService courierPriorityService;
	
	@Autowired
	@Qualifier("courierPriorityTemplateServiceImpl")
	private CourierPriorityTemplateService courierPriorityTemplateService;
	
	@Autowired
	@Qualifier("clientDashboardServiceImpl")
	private ClientDashboardService clientDashboardService;
	
	@Autowired
	@Qualifier("serviceLevelServiceImpl")
	private ServiceLevelService serviceLevelService;
	
	@Autowired
	@Qualifier("courierConfigurationServiceImpl")
	private CourierConfigurationService courierConfigurationService;
	
	@Autowired
	@Qualifier("courierAuthConfigServiceImpl")
	private CourierAuthConfigService courierConfigServ;
	
	@Autowired
	@Qualifier("clientCourierServiceImpl")
	private ClientCourierService clientCourierService;
	
	
	@RequestMapping(value = "/getAllCourier", method = RequestMethod.POST)
	@ResponseBody
        public DatatableResponseBean getAllCourier (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return courierService.getAllCourier(datatableRequestBean);
       }

	@RequestMapping(value = "/createCourier", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createCourier(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("logoImg", request.getFile("logoImageName"));
		doc.put("moaDoc", request.getFile("moaDocument"));
		doc.put("additionalDoc1", request.getFile("additionalDocument1"));
		doc.put("additionalDoc2", request.getFile("additionalDocument2"));
		doc.put("cancelCheque", request.getFile("cancelCheque"));
		doc.put("panCard", request.getFile("panCard"));
		
		String courierBean = request.getParameter("courierBean");
		ObjectMapper mapper = new ObjectMapper();
		Courier courier = mapper.readValue(courierBean, Courier.class);
        return courierService.createCourier(courier, doc);
	}
	
	@RequestMapping(value = "/updateCourier", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateCourier(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("logoImg", request.getFile("logoImageName"));
		doc.put("moaDoc", request.getFile("moaDocument"));
		doc.put("additionalDoc1", request.getFile("additionalDocument1"));
		doc.put("additionalDoc2", request.getFile("additionalDocument2"));
		doc.put("cancelCheque", request.getFile("cancelCheque"));
		doc.put("panCard", request.getFile("panCard"));
		
		String courierBean = request.getParameter("courierBean");
		ObjectMapper mapper = new ObjectMapper();
		Courier courier = mapper.readValue(courierBean, Courier.class);
        return courierService.updateCourier(courier, doc);
	}
	
	@RequestMapping(value = "/deleteCourier/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteCourier(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return courierService.deleteCourier(key);
    }
	
	@RequestMapping(value = "/checkCourierKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkCourierKeyAvailable (@PathVariable("key") String key) {
		return courierService.checkCourierKeyAvailable(key);
    }
	
	//-------------
	@RequestMapping(value = "/getAllCourierRateList", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllCourierRateList (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return courierRateListService.getAllCourierRateList(datatableRequestBean);
    }

	@RequestMapping(value = "/createCourierRateList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createCourierRateList(@RequestBody CourierRateList courierRateList, HttpServletRequest request, HttpServletResponse response) {
		return courierRateListService.createCourierRateList(courierRateList);
    }
	

	@RequestMapping(value = "/updateCourierRateList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateCourierRateList(@RequestBody CourierRateList courierRateList, HttpServletRequest request, HttpServletResponse response) {
		return courierRateListService.updateCourierRateList(courierRateList);
    }
	
	@RequestMapping(value = "/deleteCourierRateList/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteCourierRateList(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return courierRateListService.deleteCourierRateList(key);
    }
	
	@RequestMapping(value = "/checkCourierRateListKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkCourierRateListKeyAvailable (@PathVariable("key") String key) {
		return courierRateListService.checkCourierRateListKeyAvailable(key);
    }
	
	@RequestMapping(value = "/loadCouriers", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadCouriers( HttpServletRequest request, HttpServletResponse response) {
		return courierService.loadCouriers();
    }
	
	@RequestMapping(value = "/loadCouriersObj", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadCouriersObj( HttpServletRequest request, HttpServletResponse response) {
		return courierService.loadCouriersObj();
    }
	
    @RequestMapping(value = "/loadProductTypes", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean loadProductTypes( HttpServletRequest request, HttpServletResponse response) {
		return productTypeService.loadProductTypes();
    }
	

    @RequestMapping(value = "/loadCourierRateZones/{courierKey}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean loadCourierRateZones(@PathVariable("courierKey") String courierKey) {
		return courierService.loadCourierRateZones(courierKey);
    }
	
    @RequestMapping(value = "/checkCourierTokenAvailable/{token}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean checkCourierTokenAvailable(@PathVariable("token") String token) {
		return courierService.checkCourierTokenAvailable(token);
    }
	
    @RequestMapping(value = "/checkCourierPriorityKeyAvailable/{key}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean checkCourierPriorityKeyAvailable (@PathVariable("key") String key) {
	return courierPriorityService.checkCourierPriorityKeyAvailable(key);
    }
    
    @RequestMapping(value = "/getAllCourierPriority", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllCourierPriority (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return courierPriorityService.getAllCourierPriority(datatableRequestBean);
    }
    
    @RequestMapping(value = "/getAllCourierPriority", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getAllCourierPriority (HttpServletRequest request, HttpServletResponse response) {
        return courierPriorityService.getAllCourierPriority();
    }
	
    @RequestMapping(value = "/createCourierPriority", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean createCourierPriority(@RequestBody CourierPriority courierPriority, HttpServletRequest request, HttpServletResponse response) {
		return courierPriorityService.createCourierPriority(courierPriority);
    }

    @RequestMapping(value = "/updateCourierPriority", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean updatePage(@RequestBody CourierPriority courierPriority, HttpServletRequest request, HttpServletResponse response) {
		return courierPriorityService.updateCourierPriority(courierPriority);
    }
	
    @RequestMapping(value = "/deleteCourierPriority/{key}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean deletePage(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return courierPriorityService.deleteCourierPriority(key);
    }
    
    @RequestMapping(value = "/getAllCourierPriorityTemplate", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllCourierPriorityTemplate (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return courierPriorityTemplateService.getAllCourierPriorityTemplate(datatableRequestBean);
    }
	
    @RequestMapping(value = "/createCourierPriorityTemplate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean createCourierPriorityTemplate(@RequestBody CourierPriorityTemplate courierPriorityTemplate, HttpServletRequest request, HttpServletResponse response) {
		return courierPriorityTemplateService.createCourierPriorityTemplate(courierPriorityTemplate);
    }

    @RequestMapping(value = "/updateCourierPriorityTemplate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean updateCourierPriorityTemplate(@RequestBody CourierPriorityTemplate courierPriorityTemplate, HttpServletRequest request, HttpServletResponse response) {
		return courierPriorityTemplateService.updateCourierPriorityTemplate(courierPriorityTemplate);
    }
	
    @RequestMapping(value = "/deleteCourierPriorityTemplate", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean deleteCourierPriorityTemplate(@RequestParam("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return courierPriorityTemplateService.deleteCourierPriorityTemplate(key);
    }
    
    @RequestMapping(value = "/loadCourierPriorityTemplates", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadCourierPriorityTemplates( HttpServletRequest request, HttpServletResponse response) {
		return courierPriorityTemplateService.loadCourierPriorityTemplates();
    }
    
    @RequestMapping(value = "/getAllCourierPriorityTemplates", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getAllCourierPriorityTemplates( HttpServletRequest request, HttpServletResponse response) {
		return courierPriorityTemplateService.getAllCourierPriorityTemplates();
    }
    
    @RequestMapping(value = "/3plassigncouriertosaleorderUploadedCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkOrderUploadedCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(GlobalConstant.THREE_PL_STATUS_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(GlobalConstant.THREE_PL_STATUS_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.THREE_PL_STATUS_UPLOAD_CURRENT_COUNT,""+ request.getSession().getAttribute(GlobalConstant.THREE_PL_STATUS_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.THREE_PL_STATUS_UPLOAD_TOTAL_COUNT,""+ request.getSession().getAttribute(GlobalConstant.THREE_PL_STATUS_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}

    @RequestMapping(value = "/serviceabilityCheck", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean serviceabilityCheck(@RequestBody ServiceabilityCheckBean serviceabilityCheckBean, HttpServletRequest request, HttpServletResponse response) {
		return courierService.serviceabilityCheck(serviceabilityCheckBean);
    }
    
    @RequestMapping(value = "/getCourierShipmentsReport", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getCourierShipmentsReport(@RequestParam("key") String key, @RequestParam(value = "courierId", required=false) String courierId, HttpServletRequest request, HttpServletResponse response) {
		return clientDashboardService.getCourierShipmentsReport(key, courierId);
    }
    
    @RequestMapping(value = "/getAllClientAlloudCourier", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getAllClientAlloudCourier(@RequestParam("clientKey") String clientKey, @RequestParam(value = "productType") String productType, HttpServletRequest request, HttpServletResponse response) {
		return courierService.getAllClientAlloudCourier(clientKey, productType);
    }
    
    @RequestMapping(value = "/getAllCouriers", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getAllCouriers( HttpServletRequest request, HttpServletResponse response) {
		return courierService.getAllCouriers();
    }
    
    @RequestMapping(value = "/getAllServiceLevel", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllServiceLevel (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return serviceLevelService.getAllServiceLevel(datatableRequestBean);
    }
    
    @RequestMapping(value = "/createServiceLevel", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean createServiceLevel(@RequestBody ServiceLevel serviceLevel, HttpServletRequest request, HttpServletResponse response) {
		return serviceLevelService.createServiceLevel(serviceLevel);
    }
    
    @RequestMapping(value = "/updateServiceLevel", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean updateServiceLevel(@RequestBody ServiceLevel serviceLevel, HttpServletRequest request, HttpServletResponse response) {
		return serviceLevelService.updateServiceLevel(serviceLevel);
    }
    
    @RequestMapping(value = "/deleteServiceLevel", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean deleteServiceLevel(@RequestParam("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return serviceLevelService.deleteServiceLevel(key);
    }
    
    @RequestMapping(value = "/keyAvailable", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean keyAvailable(@RequestParam("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return serviceLevelService.keyAvailable(key);
    }
    
    @RequestMapping(value = "/getServiceLevels", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getServiceLevels (HttpServletRequest request, HttpServletResponse response) {
		return serviceLevelService.getServiceLevels ();
    }
    
    @RequestMapping(value = "/getCourierServiceLevel", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getCourierServiceLevel (HttpServletRequest request, HttpServletResponse response) {
		return courierService.getCourierServiceLevel ();
    }
    
    
    @RequestMapping(value = "/getAllCourierConfiguration", method = RequestMethod.POST)
	@ResponseBody
        public DatatableResponseBean getAllCourierConfiguration (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return courierConfigurationService.getAllCourierConfiguration(datatableRequestBean);
    }

	@RequestMapping(value = "/createCourierConfiguration", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createCourierConfiguration(@RequestBody CourierConfiguration courierConfiguration, HttpServletRequest request,HttpServletResponse response) throws Exception {
        return courierConfigurationService.createCourierConfiguration(courierConfiguration);
	}
	
	@RequestMapping(value = "/updateCourierConfiguration", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateCourierConfiguration(@RequestBody CourierConfiguration courierConfiguration, HttpServletRequest request,HttpServletResponse response) throws Exception {
        //return courierConfigurationService.updateCourierConfiguration(courierConfiguration);
		return courierConfigurationService.createCourierConfiguration(courierConfiguration);
	}
	
	@RequestMapping(value = "/deleteCourierConfiguration/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteCourierConfiguration(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return courierConfigurationService.deleteCourierConfiguration(key);
    }
	
	@RequestMapping(value = "/checkCourierConfigurationKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkCourierConfigurationKeyAvailable (@PathVariable("key") String key) {
		return courierConfigurationService.checkCourierConfigurationKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getClientZone/{key}/{businessType}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getClientZone (@PathVariable("key") String key, @PathVariable("businessType") BusinessType businessType) {
		return courierConfigurationService.getClientZone(key, businessType);
    }
	
	@RequestMapping(value = "/updateClientCourierPriority", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getClientZone (@RequestParam(value = "type") String type,@RequestParam(value = "clientId") String clientId, @RequestBody Map<String, Object> payload) {
		String key = (String) payload.get("key");
		List<String> couList = null;
		if(GlobalConstant.CUSTOME_COURIER_PRORITY.equals(key)) {
			couList = (List<String>) payload.get("courierPriority");
		}
		return courierPriorityService.updateClientCourierPriority(key, couList, type,clientId);
    }
	
	@RequestMapping(value = "/getAlloudeCourier", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getAlloudeCourier (@RequestParam("clientId") String clientId,HttpServletResponse response) {
		return courierConfigurationService.getAlloudeCourier(clientId);
    }
	@RequestMapping(value = "/pincodeServiceabilityCheck", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean pincodeServiceabilityCheck(@RequestParam(value = "pincode") String  pincode, HttpServletRequest request, HttpServletResponse response) {
		return courierService.pincodeServiceabilityCheck(pincode);
    }
	@RequestMapping(value = "/loadAllowedCouriers", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadAllowedCouriers () {
		return courierService.loadAllowedCouriers();
    }
	@RequestMapping(value = "/getAllCourierAuthConfig", method = RequestMethod.POST)
   	@ResponseBody
    public DatatableResponseBean getAllCourierAuthConfig(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return courierConfigServ.getAllCourierAuthConfig(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getCourierAuthConfig", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getCourierAuthConfig(@RequestParam(value = "courier") String key_s, HttpServletRequest request, HttpServletResponse response) {
		return courierConfigServ.getCourierAuthConfig(key_s);
    }
	
	@RequestMapping(value = "/createCourierAuthConfig", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean createCourierAuthConfig(@RequestBody CourierAuthConfig courierAuthConfig, HttpServletRequest request, HttpServletResponse response) {
		return courierConfigServ.createCourierAuthConfig(courierAuthConfig);
    }
	
	@RequestMapping(value = "/updateCourierAuthConfig", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateCourierAuthConfig(@RequestBody CourierAuthConfig courierAuthConfig, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        return courierConfigServ.updateCourierAuthConfig(courierAuthConfig);
	}
	
	@RequestMapping(value = "/deleteCourierAuthConfig", method = RequestMethod.PUT)
	@ResponseBody
    public ResponseBean deleteCourierAuthConfig(@RequestParam("courier") String key_s, HttpServletRequest request, HttpServletResponse response) {
		return courierConfigServ.deleteCourierAuthConfig(key_s);
    }
	
	@RequestMapping(value = "/checkCourierAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkCourierAvailable (@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return courierConfigServ.checkCourierAvailable(key);
    }
	
	@RequestMapping(value = "/getFieldTypes", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getFieldTypes (HttpServletRequest request, HttpServletResponse response) {
		return courierConfigServ.getFieldTypes();
    }
	
	@RequestMapping(value = "/getAllUniqueCouriers", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getAllUniqueCouriers( HttpServletRequest request, HttpServletResponse response) {
		return courierService.getAllUniqueCouriers();
    }
	
	@RequestMapping(value = "/loadFieldsMapById/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadFieldsMapById (@PathVariable("key") String key,HttpServletRequest request, HttpServletResponse response) {
		return clientCourierService.loadClientCourierById(key);
    }

	@RequestMapping(value = "/loadFieldsMap", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean loadFieldsMap (HttpServletRequest request, HttpServletResponse response) {
		return clientCourierService.loadClientCouriers();
	}
	
	@RequestMapping(value = "/loadCouriersData", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadCouriersData (HttpServletRequest request, HttpServletResponse response) {
		return clientCourierService.loadCouriersData();
    }
	
	@RequestMapping(value = "/createClientCourier", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean createClientCourier(@RequestBody ClientCourier courier, HttpServletRequest request, HttpServletResponse response) {
		return clientCourierService.createClientCourier(courier);
    }
	
	@RequestMapping(value = "/updateClientCourier", method = RequestMethod.PUT)
   	@ResponseBody
    public ResponseBean updateClientCourier(@RequestBody ClientCourier courier, HttpServletRequest request, HttpServletResponse response) {
		return clientCourierService.updateClientCourier(courier);
    }
	
	@RequestMapping(value = "/deleteClientCourier", method = RequestMethod.DELETE)
   	@ResponseBody
    public ResponseBean deleteClientCourier(@RequestParam String key, HttpServletRequest request, HttpServletResponse response) {
		return clientCourierService.deleteClientCourier(key);
    }
	
	@RequestMapping(value = "/getAllClientCourier", method = RequestMethod.POST)
   	@ResponseBody
    public DatatableResponseBean getAllClientCourier(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return clientCourierService.getAllClientCourier(datatableRequestBean);
    }
	
	@RequestMapping(value = "/loadParentCouriers", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadParentCouriers( HttpServletRequest request, HttpServletResponse response) {
		return courierService.getAllUniqueCouriers();
    }
	
	@RequestMapping("/downloadCourierLogodoc")
	@ResponseBody
		public void downloadCourierLogodoc(@RequestParam(value="key") String fileName, HttpServletResponse response) throws Exception{
		clientCourierService.downloadDoc(fileName,response);
	}
    
}