package com.bmp.oms.controller;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.drs.DrsCloseBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.GreetingSmsTemplateType;
import com.bmp.constant.KycStatus;
import com.bmp.constant.MessageConstant;
import com.bmp.constant.QCStatus;
import com.bmp.constant.ResponseStatus;
import com.bmp.constant.UserType;
import com.bmp.dao.SaleOrderDao;
import com.bmp.model.app.client.ClientFinance;
import com.bmp.model.app.client.ClientProductSkuRate;
import com.bmp.model.app.config.Settings;
import com.bmp.model.app.facility.Branch;
import com.bmp.model.app.facility.BranchRoute;
import com.bmp.model.app.systemCalling.CallManifest;
import com.bmp.model.app.systemCalling.Campaign;
import com.bmp.model.app.systemCalling.GreetingSmsTemplate;
import com.bmp.model.app.systemCalling.SendManualSms;
import com.bmp.model.app.facility.Page;
import com.bmp.model.app.facility.PageAction;
import com.bmp.model.app.facility.Role;
import com.bmp.model.app.facility.User;
import com.bmp.model.app.masters.QCMaster;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.utility.AlertBean;
import com.bmp.model.app.utility.AlertMaster;
import com.bmp.model.app.utility.NotificationBean;
import com.bmp.model.c2c.C2cPricing;
import com.bmp.oms.service.api.alert.AlertHelper;
import com.bmp.oms.service.app.notication.NotificationHelper;
import com.bmp.oms.service.c2c.C2cPricingService;
import com.bmp.oms.service.c2c.EnquiryService;
import com.bmp.oms.service.client.ClientProductSkuRateService;
import com.bmp.oms.service.facility.AlertMasterService;
import com.bmp.oms.service.facility.BranchRouteService;
import com.bmp.oms.service.facility.BranchService;
import com.bmp.oms.service.systemCalling.CallManifestService;
import com.bmp.oms.service.systemCalling.CampaignService;
import com.bmp.oms.service.systemCalling.GreetingSmsTemplateService;
import com.bmp.oms.service.systemCalling.SendManualSmsService;
import com.bmp.oms.service.facility.PageActionService;
import com.bmp.oms.service.facility.PageService;
import com.bmp.oms.service.facility.RoleService;
import com.bmp.oms.service.facility.SettingsService;
import com.bmp.oms.service.facility.SmsMailMasterService;
import com.bmp.oms.service.facility.UserService;
import com.bmp.oms.service.masters.ServiceablePincodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;

@Controller
@RequestMapping("/facility")
public class FacilityController {

	@Autowired
	@Qualifier("pageActionService")
	private PageActionService pageActionService;
	
	@Autowired
	@Qualifier("pageServiceImpl")
	private PageService pageService;
	
	@Autowired
	@Qualifier("roleServiceImpl")
	private RoleService roleService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("branchService")
	private BranchService branchService;
	
	@Autowired
	@Qualifier("settingsServiceImpl")
	private SettingsService settingsService;
	
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;

	@Autowired
	@Qualifier("branchRouteServiceImpl")
	private BranchRouteService branchRouteService;
	
	@Autowired
	@Qualifier("serviceablePincodeServiceImpl")
	private ServiceablePincodeService serviceablePincodeService;
	
	@Autowired
	@Qualifier("alertMasterServiceImpl")
	private AlertMasterService alertMasterService;
	
	@Autowired
	@Qualifier("alertHelperImpl")
	private AlertHelper alertHelper;
	
	@Autowired
	@Qualifier("notificationHelperImpl")
	private NotificationHelper notificationHelper;
	
	@Autowired
	@Qualifier("c2cPricingServiceImpl")
	private C2cPricingService c2cPricingService;
	
	@Autowired
	@Qualifier("enquiryServiceImpl")
	private EnquiryService enquiryService;
	
	@Autowired
	@Qualifier("smsMailMasterServiceImpl")
	private SmsMailMasterService smsMailMasterService;
	
	@Autowired
	@Qualifier("campaignServiceImpl")
	private CampaignService campaignService;
	
	@Autowired
	@Qualifier("callManifestServiceImpl")
	private CallManifestService callManifestService;
	
	@Autowired
	@Qualifier("greetingSmsTemplateServiceImpl")
	private GreetingSmsTemplateService greetingSmsTemplateService;
	
	@Autowired
	@Qualifier("sendManualSmsServiceImpl")
	private SendManualSmsService sendManualSmsService;
	
	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired
	@Qualifier("clientProductSkuRateServiceImpl")
	private ClientProductSkuRateService clientProductSkuRateService;
	
	@Autowired
	private MessageSource messageSource;
	
	
	
	@RequestMapping(value = "/loadOrganizationStatic", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadOrganizationStatic() {
		ResponseBean responseBean = new ResponseBean();
		try{
			Map<String,String> map = new HashMap<>(4);
			map.put("ORGANIZATION_NAME", messageSource.getMessage(GlobalConstant.ORGANIZATION_NAME, null, null));
			map.put("ORGANIZATION_KEY", messageSource.getMessage(GlobalConstant.ORGANIZATION_KEY, null, null));
			map.put("ORGANIZATION_ICON", messageSource.getMessage(GlobalConstant.ORGANIZATION_ICON, null, null));
			map.put("ORGANIZATION_LOGO", messageSource.getMessage(GlobalConstant.ORGANIZATION_LOGO, null, null));
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(map);
		}catch(Exception e){
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return responseBean;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean login(@RequestBody User user, @RequestParam(value = "source", required = false) String source, @RequestParam(value = "shop", required = false) String shop, 
    		HttpSession session, HttpServletRequest request) {
		String deviceId = request.getHeaderNames()!=null ? request.getHeader("Device-ID") : "";
		user.setDeviceId(deviceId);
		ResponseBean responseBean = userService.login(user, source, shop,session);
		if(ResponseStatus.SUCCESS.equals(responseBean.getStatus())) {
			session.removeAttribute("source");  // Used for shopify app install
			session.removeAttribute("shop");
		}
		return responseBean;
    }
	
	@RequestMapping(value = "/getAllPageActions", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllPageActions (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return pageActionService.getAllPageAction(datatableRequestBean);
    }
	
	@RequestMapping(value = "/checkPageActionKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkPageActionKeyAvailable (@PathVariable("key") String key) {
		return pageActionService.checkPageActionKeyAvailable(key);
    }
	
	@RequestMapping(value = "/createPageAction", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPageAction(@RequestBody PageAction pageAction, HttpServletRequest request, HttpServletResponse response) {
		return pageActionService.createPageAction(pageAction);
    }
	
	@RequestMapping(value = "/updatePageAction", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updatePageAction(@RequestBody PageAction pageAction, HttpServletRequest request, HttpServletResponse response) {
		return pageActionService.updatePageAction(pageAction);
    }
	
	@RequestMapping(value = "/deletePageAction/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deletePageAction(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return pageActionService.deletePageAction(key);
    }
	
	@RequestMapping(value = "/checkPageKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkPageKeyAvailable (@PathVariable("key") String key) {
		return pageService.checkPageKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllPages", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllPages (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return pageService.getAllPages(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createPage", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPage(@RequestBody Page page, HttpServletRequest request, HttpServletResponse response) {
		return pageService.createPage(page);
    }
	
	@RequestMapping(value = "/updatePage", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updatePage(@RequestBody Page page, HttpServletRequest request, HttpServletResponse response) {
		return pageService.updatePage(page);
    }
	
	@RequestMapping(value = "/deletePage/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deletePage(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return pageService.deletePage(key);
    }

	@RequestMapping(value = "/loadPageActions", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadPageActions(HttpServletRequest request, HttpServletResponse response) {
		return pageActionService.loadPageActions();
    }
	
	@RequestMapping(value = "/getAllRole", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllRole (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return roleService.getAllRole(datatableRequestBean);
    }
	
	@RequestMapping(value = "/checkRoleKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkRoleKeyAvailable (@PathVariable("key") String key) {
		return roleService.checkRoleKeyAvailable(key);
    }
	
	@RequestMapping(value = "/createRole", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createRole(@RequestBody Role role, HttpServletRequest request, HttpServletResponse response) {
		return roleService.createRole(role);
    }
	
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateRole(@RequestBody Role role, HttpServletRequest request, HttpServletResponse response) {
		return roleService.updateRole(role);
    }
	
	@RequestMapping(value = "/deleteRole/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteRole(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return roleService.deleteRole(key);
    }
	
	@RequestMapping(value = "/getAllPages", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadPage(HttpServletRequest request, HttpServletResponse response) {
		return pageService.getAllPages ();
    }
	
	@RequestMapping(value = "/checkUserKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkUserKeyAvailable (@PathVariable("key") String key) {
		return userService.checkUserKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllUsers (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return userService.getAllUsers(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createUser(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("image", request.getFile("image"));
		
		String userBean = request.getParameter("userBean");
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userBean, User.class);
        return userService.createUser(user,doc);
    }
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateUser(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("image", request.getFile("image"));
		
		String userBean = request.getParameter("userBean");
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userBean, User.class);
        return userService.updateUser(user,doc);
    }
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteUser(@RequestParam("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return userService.deleteUser(key);
    }
    
    @RequestMapping(value = "/loadRoleList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadRoleList( HttpServletRequest request, HttpServletResponse response) {
		return roleService.loadRoleList();
    }
    
    @RequestMapping(value = "/loadParentBranch", method = RequestMethod.POST)
   	@ResponseBody
       public ResponseBean loadParentBranch( HttpServletRequest request, HttpServletResponse response) {
   		return branchService.loadParentBranch();
       }
    
    @RequestMapping(value = "/checkBranchKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkBranchKeyAvailable (@PathVariable("key") String key) {
		return branchService.checkBranchKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllBranches", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllBranches (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return branchService.getAllBranch(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createBranch", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createBranch(@RequestBody Branch branch, HttpServletRequest request, HttpServletResponse response) {
		return branchService.createBranch(branch);
    }
	
	@RequestMapping(value = "/updateBranch", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateBranch(@RequestBody Branch branch, HttpServletRequest request, HttpServletResponse response) {
		return branchService.updateBranch(branch);
    }
	
	@RequestMapping(value = "/deleteBranch/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteBranch(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return branchService.deleteBranch(key);
    }
	
	@RequestMapping(value = "/getAllBranchRoute", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllBranchRoute (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return branchRouteService.getAllBranchRoute(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createBranchRoute", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createBranchRoute(@RequestBody BranchRoute branchRoute, HttpServletRequest request, HttpServletResponse response) {
		return branchRouteService.createBranchRoute(branchRoute);
    }
	
	@RequestMapping(value = "/updateBranchRoute", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateBranchRoute(@RequestBody BranchRoute branchRoute, HttpServletRequest request, HttpServletResponse response) {
		return branchRouteService.updateBranchRoute(branchRoute);
    }
	
	@RequestMapping(value = "/deleteBranchRoute/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteBranchRoute(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return branchRouteService.deleteBranchRoute(key);
    }
	
	@RequestMapping(value = "/getdeliveryboy", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getDeliveryBoy(HttpServletRequest request, HttpServletResponse response) {
		return userService.getDeliveryBoyList();
    }
	
	@RequestMapping(value = "/getAllSetting", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllSetting (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return settingsService.getAllSetting(datatableRequestBean);
    }
	
	@RequestMapping(value = "/checkSettingKeyAvailable/{key_s}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkSettingKeyAvailable (@PathVariable("key_s") String key) {
		return settingsService.checkSettingKeyAvailable(key);
    }
	
	@RequestMapping(value = "/createSetting", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createSetting(@RequestBody Settings settings, HttpServletRequest request, HttpServletResponse response) {
		return settingsService.createSetting(settings);
    }
	
	@RequestMapping(value = "/updateSetting", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateSetting(@RequestBody Settings settings, HttpServletRequest request, HttpServletResponse response) {
		return settingsService.updateSetting(settings);
    }
	
	@RequestMapping(value = "/deleteSetting/{key_s}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteSetting(@PathVariable("key_s") String key, HttpServletRequest request, HttpServletResponse response) {
		return settingsService.deleteSetting(key);
    }
    
    @RequestMapping(value = "/getUserBranchList", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean userBranchList(HttpServletRequest request, HttpServletResponse response) {
		return branchService.userBranchList();
    }
    
    @RequestMapping(value = "/getDestinationBranchListForManifest/{branchKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getDestinationBranchListForManifest (@PathVariable("branchKey") String branchKey, HttpServletRequest request, HttpServletResponse response) {
		return branchService.getDestinationBranchListForManifest (branchKey);
    }
    
    @RequestMapping(value = "/branchRouteByBranchName/{key_s}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean branchRouteByBranchName(@PathVariable("key_s") String key, HttpServletRequest request, HttpServletResponse response) {
		return branchRouteService.branchRouteByBranchKey(key);
    }
    
    @RequestMapping(value = "/deliveryBoyByRouteKey/{key_s}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getDeliveryBoyByRouteKey(@PathVariable("key_s") String key, HttpServletRequest request, HttpServletResponse response) {
		return userService.getDeliveryBoyByRouteKey(key);
    }
    
    @RequestMapping(value = "/pincodeByBranchName/{branchKey}", method = RequestMethod.GET)
   	@ResponseBody
   	public ResponseBean pincodeByBranchName(@PathVariable("branchKey") String branchKey, HttpServletRequest request, HttpServletResponse response) {
	return serviceablePincodeService.pincodeByBranchName(branchKey);
   }
    
    @RequestMapping(value = "/getDeliveryBoyBranch/{branchKey}", method = RequestMethod.GET)
   	@ResponseBody
   	public ResponseBean getDeliveryBoyBranch(@PathVariable("branchKey") String branchKey, HttpServletRequest request, HttpServletResponse response) {
	return userService.getDeliveryBoyBranch(branchKey);
   }
    
    @RequestMapping(value = "/loadDestinationBranch/{branchKey}", method = RequestMethod.GET)
   	@ResponseBody
   	public ResponseBean loadDestinationBranch(@PathVariable("branchKey") String branchKey, HttpServletRequest request, HttpServletResponse response) {
	return branchService.loadDestinationBranch(branchKey);
    }
    
    @RequestMapping(value = "/getDesBranchListForManifest/{branchKey}", method = RequestMethod.GET)
   	@ResponseBody
   	public ResponseBean getDesBranchListForManifest(@PathVariable("branchKey") String branchKey, HttpServletRequest request, HttpServletResponse response) {
	return branchService.getDesBranchListForManifest(branchKey);
    }
    
    @RequestMapping(value = "/changePasswordByUserId/{userId}/{newPassword}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean changePasswordByUserId(@PathVariable("userId") String userId, @PathVariable("newPassword") String newPassword, HttpServletRequest request, HttpServletResponse response) {
		return userService.changePasswordByUserId(userId,newPassword);
    }
    
    @RequestMapping(value = "/loadUser", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadUser(HttpServletRequest request, HttpServletResponse response) {
		return userService.loadUser();
    }
    
    @RequestMapping(value = "/getAllAlertMaster", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllAlertMaster (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return alertMasterService.getAllAlertMaster(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createAlertMaster", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createAlertMaster(@RequestBody AlertMaster alertMaster, HttpServletRequest request, HttpServletResponse response) {
		return alertMasterService.createAlertMaster(alertMaster);
    }
	
	@RequestMapping(value = "/updateAlertMaster", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateAlertMaster(@RequestBody AlertMaster alertMaster, HttpServletRequest request, HttpServletResponse response) {
		return alertMasterService.updateAlertMaster(alertMaster);
    }
	
	@RequestMapping(value = "/deleteAlertMaster/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteAlertMaster(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return alertMasterService.deleteAlertMaster(key);
    }
	
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean forgatePassword(@RequestParam(value="userId", required=true) String userId, HttpServletRequest request, HttpServletResponse response) {
		return userService.forgetPassword(userId);
    }
	
	@RequestMapping(value = "/testSMS", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean testSMS(@RequestParam(value="mobileNo", required=true) String mobileNo, HttpServletRequest request, HttpServletResponse response) {
		return userService.testSMS(mobileNo);
    }
	
	@RequestMapping(value = "/getThirdPartyKey", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getThirdPartyKey(@RequestParam(value="key") String type, HttpServletRequest request, HttpServletResponse response) {
		return userService.getThirdPartyKey(type);
    }
    
    @RequestMapping(value = "/getDeliveryDetails", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getDeliveryDetails(@RequestParam(value="key") String key, HttpServletRequest request, HttpServletResponse response) {
		return userService.getDeliveryDetails(key);
    }
    
    @RequestMapping(value = "/getNotDeliveredAndNotPickReason", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getNotDeliveredAndNotPickReason(@RequestParam(value="type") String type, HttpServletRequest request, HttpServletResponse response) {
    	return settingsService.getNotDeliveredAndNotPickReason(type);
    }
    
   /* @RequestMapping(value = "/sendMail/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean sendMail(@PathVariable("key") String alertKey, HttpServletRequest request, HttpServletResponse response) {
		return alertMasterService.sendMailForAlert(alertKey);
    }*/

    @RequestMapping(value = "/getUndeliveredAndNotPickReason", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getNotDeliveredAndNotPickReason(HttpServletRequest request, HttpServletResponse response) {
    	return settingsService.getNotDeliveredAndNotPickReason();
    }
    
    @RequestMapping(value = "/getNotDeliveredAndNotPickReasonList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getNotDeliveredAndNotPickReasonList(HttpServletRequest request, HttpServletResponse response) {
    	return settingsService.getNotDeliveredAndNotPickReasonList();
    }
    
    @RequestMapping(value = "/getSettingListByType", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getSettingListByType(@RequestParam(value="type") String type, HttpServletRequest request, HttpServletResponse response) {
    	return settingsService.getSettingListByType(type);
    }
    
	@RequestMapping(value = "/getBranchList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getBranchList(HttpServletRequest request, HttpServletResponse response) {
		return branchService.getBranchList();
	}
	
	@RequestMapping(value = "/getAllBranchList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getAllBranchList(@RequestParam(value="branch") String branch,HttpServletRequest request, HttpServletResponse response) {
		return branchService.getAllBranchList(branch);
	}
	
	@RequestMapping(value = "/getAccountNumber", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getAccountNumber (@RequestParam(value="key") String key, HttpServletRequest request, HttpServletResponse response) {
		return settingsService.getAccountNumber(key);
    }
	
	@RequestMapping(value = "/getUserByType", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getUserByType (@RequestBody UserType userType, HttpServletRequest request, HttpServletResponse response) {
		
		return userService.getUserByType(userType);
    }
	
	@RequestMapping(value = "/loadAlertTypes", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadAlertTypes( HttpServletRequest request, HttpServletResponse response) {
		return alertMasterService.loadAlertTypes();
    }
	
	@RequestMapping(value = "/loadSubAlertTypes", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadSubAlertTypes( HttpServletRequest request, HttpServletResponse response) {
		return alertMasterService.loadSubAlertTypes();
    }
	
	@RequestMapping(value = "/checkAlertKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkColoaderKeyAvailable (@PathVariable("key") String key) {
		return alertMasterService.checkAlertKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getSettingListByMultipleType", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getSettingListByMultipleType(@RequestParam(value="type") String type, HttpServletRequest request, HttpServletResponse response) {
    	return settingsService.getSettingListByMultipleType(type);
    }
	
	@RequestMapping(value = "/getAlertTemplates", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getAlertTemplates( HttpServletRequest request, HttpServletResponse response) {
		return alertMasterService.getAlertTemplates();
    }
	
	@RequestMapping(value = "/sendManualAlert", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean sendManualAlert(@RequestBody AlertBean alertBean, HttpServletRequest request, HttpServletResponse response) {
		return alertHelper.sendManualAlert(alertBean);
    }
	
	@RequestMapping(value = "/getAllReasonEngine", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllReasonEngine (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return settingsService.getAllReasonEngine(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllPickuFailAndNdrReason", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getAllPickuFailAndNdrReason (HttpServletRequest request, HttpServletResponse response) {
        return settingsService.getAllPickuFailAndNdrReason();
    }
	
	@RequestMapping(value = "/getAlldeliveryBoysOfSeletedBranches", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getAlldeliveryBoysOfSeletedBranches(@RequestBody NotificationBean notificationBean, HttpServletRequest request, HttpServletResponse response) {
		return branchService.getAlldeliveryBoysOfSeletedBranches(notificationBean);
	}
	
	@RequestMapping(value = "/sendManualNotification", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean sendManualNotification(@RequestBody NotificationBean notificationBean, HttpServletRequest request, HttpServletResponse response) {
		return notificationHelper.sendManualNotification(notificationBean);
    }
	
	@RequestMapping(value = "/checkEmployeeCodeAvailable/{empCode}/{id}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkEmployeeCodeAvailable (@PathVariable("empCode") String empCode, @PathVariable("id") String id){
		return userService.checkEmployeeCodeAvailable(empCode, id);
    }
	
	@RequestMapping(value = "/loadClientDepartmentUser", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadClientDepartmentUser(HttpServletRequest request, HttpServletResponse response) {
		return userService.loadClientDepartmentUser();
    }
	 
	@RequestMapping(value = "/getAllRtoRejectedReason", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getAllRtoRejectedReason (HttpServletRequest request, HttpServletResponse response) {
        return settingsService.getAllRtoRejectedReason();
    }
	
	@RequestMapping(value = "/getAllReversePickupReason", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getAllReversePickupReason (HttpServletRequest request, HttpServletResponse response) {
        return settingsService.getAllReversePickupReason();
    }
	
	@RequestMapping(value = "/getAllCTocPricing", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllC2cPricing (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return c2cPricingService.getAllC2cPricing(datatableRequestBean);
    }
	
	@RequestMapping(value = "/addC2cPricing", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addC2cPricing(@RequestBody C2cPricing c2cPricing, HttpServletRequest request, HttpServletResponse response) {
		return c2cPricingService.addC2cPricing(c2cPricing);
    }
	
	@RequestMapping(value = "/updateC2cPricing", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateC2cPricing(@RequestBody C2cPricing c2cPricing, HttpServletRequest request, HttpServletResponse response) {
		return c2cPricingService.updateC2cPricing(c2cPricing);
    }
	
	@RequestMapping(value = "/deleteC2cPricing/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteC2cPricing(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return c2cPricingService.deleteC2cPricing(key);
    }
	
	@RequestMapping(value = "/getAllEnquiry", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllEnquiry(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return enquiryService.getAllEnquiry(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getNewEnquiry", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getNewEnquiry(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return enquiryService.getNewEnquiry(datatableRequestBean);
	}
	
	@RequestMapping(value = "/closeEnquiry/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean closeEnquiry(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return enquiryService.closeEnquiry(key);
    }
	
	@RequestMapping(value = "/getAllSmsMailMaster", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllSmsMailMaster(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response) {
		return smsMailMasterService.getAllSmsMailMaster(datatableRequestBean);
    }
	
	@RequestMapping(value = "/deleteSmsMailMaster/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteSmsMailMaster(@PathVariable("key") String key,HttpServletRequest request, HttpServletResponse response) {
		return smsMailMasterService.deleteSmsMailMaster(key);
    }
	
	
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean forgot (@RequestParam(value="email") String email) {
		return userService.forgotPassword(email);
    }
	
	
	@RequestMapping(value = "/checkCampaignKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkCampaignKeyAvailable (@PathVariable("key") String key) {
		return campaignService.checkCampaignKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllCampaign", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllCampaign (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return campaignService.getAllCampaign(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createCampaign", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createCampaign(@RequestBody Campaign campaign, HttpServletRequest request, HttpServletResponse response) {
		return campaignService.createCampaign(campaign);
    }
	
	@RequestMapping(value = "/updateCampaign", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateCampaign(@RequestBody Campaign campaign, HttpServletRequest request, HttpServletResponse response) {
		return campaignService.updateCampaign(campaign);
    }
	
	@RequestMapping(value = "/deleteCampaign/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteCampaign(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return campaignService.deleteCampaign(key);
    }
	
	
	@RequestMapping(value = "/getAllIvrNumbersDatatable", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllIvrNumbersDatatable (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return settingsService.getAllIvrNumbers(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllIvrNumbers", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getAllIvrNumbers (HttpServletRequest request, HttpServletResponse response) {
		return settingsService.getAllIvrNumbers();
    }
	
	@RequestMapping(value = "/createIvrNumber", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createIvrNumber(@RequestBody Settings settings, HttpServletRequest request, HttpServletResponse response) {
		return settingsService.createIvrNumber(settings);
    }
	
	@RequestMapping(value = "/getCampaigns", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getCampaigns (HttpServletRequest request, HttpServletResponse response) {
		return campaignService.getCampaigns();
    }
	
	@RequestMapping(value = "/getAllCallManifest", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllCallManifest (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return callManifestService.getAllCallManifest(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createCallManifest", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createCallManifest(@RequestBody CallManifest callManifest, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.createCallManifest(callManifest);
    }
	
	@RequestMapping(value = "/updateCallManifest", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateCallManifest(@RequestBody CallManifest callManifest, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.updateCallManifest(callManifest);
    }
	
	@RequestMapping(value = "/deleteCallManifest/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteCallManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.deleteCallManifest(key);
    }
	
	@RequestMapping(value = "/getAllPublishedCallManifest", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllPublishedCallManifest (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return callManifestService.getAllPublishedCallManifest(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllClosedCallManifest", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClosedCallManifest (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return callManifestService.getAllClosedCallManifest(datatableRequestBean);
    }
	
	@RequestMapping(value = "/markedPublishedCallManifest/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean markedPublishedCallManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.markedPublishedCallManifest(key);
    }

	@RequestMapping(value = "/manualClosedCallManifest/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean manualClosedCallManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.manualClosedCallManifest(key);
    }
	
	@RequestMapping(value = "/getAllOutgoingCallLogs", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllOutgoingCallLogs (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return callManifestService.getAllOutgoingCallLogs(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllGreetingSmsTemplate", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllGreetingSmsTemplate (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return greetingSmsTemplateService.getAllGreetingSmsTemplate(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createGreetingSmsTemplate", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createGreetingSmsTemplate(@RequestBody GreetingSmsTemplate greetingSmsTemplate, HttpServletRequest request, HttpServletResponse response) {
		return greetingSmsTemplateService.createGreetingSmsTemplate(greetingSmsTemplate);
    }
	
	@RequestMapping(value = "/updateGreetingSmsTemplate", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateGreetingSmsTemplate(@RequestBody GreetingSmsTemplate greetingSmsTemplate, HttpServletRequest request, HttpServletResponse response) {
		return greetingSmsTemplateService.updateGreetingSmsTemplate(greetingSmsTemplate);
    }
	
	@RequestMapping(value = "/deleteGreetingSmsTemplate/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteGreetingSmsTemplate(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return greetingSmsTemplateService.deleteGreetingSmsTemplate(key);
    }
	
	@RequestMapping(value = "/checkGreetingSmsTemplateKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkGreetingSmsTemplateAvailable(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return greetingSmsTemplateService.checkGreetingSmsTemplateAvailable(key);
    }
	
	@RequestMapping(value = "/getGreetingSmsTemplate/{templateType}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getGreetingSmsTemplate(@PathVariable("templateType") GreetingSmsTemplateType templateType, HttpServletRequest request, HttpServletResponse response) {
		return greetingSmsTemplateService.getGreetingSmsTemplate(templateType);
    }
	
	@RequestMapping(value = "/manualOutgoingCall/{awb}/{number}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getGreetingSmsTemplate(@PathVariable("awb") String awb,@PathVariable("number") String number, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.manualOutgoingCall(awb, number);
    }
	
	@RequestMapping(value = "/downloadRecordingFromExtole/{callSid}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean downloadRecordingFromExtole(@PathVariable("callSid") String callSid, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.downloadRecordingFromExtole(callSid, null);
    }
	
	@RequestMapping(value = "/playAudio/{callSid}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public HttpEntity<byte[]> playAudio(@PathVariable("callSid") String callSid, ModelMap model, HttpServletResponse response){
		return callManifestService.playAudio(callSid);
	}
	
	@RequestMapping(value = "/downloadRecording/{callSid}", method = RequestMethod.GET)
	@ResponseBody
    public void downloadRecording(@PathVariable("callSid") String callSid, HttpServletRequest request, HttpServletResponse response) {
		callManifestService.downloadRecording(callSid, request,response);
    }
	
	@RequestMapping(value = "/whitelistDetails/{contactNumber}", method = RequestMethod.GET)
	@ResponseBody
    public void whitelistDetails(@PathVariable("contactNumber") String contactNumber, HttpServletRequest request, HttpServletResponse response) {
		callManifestService.whitelistDetails(contactNumber, null);
    }
	
	@RequestMapping(value = "/numbersMetadata/{contactNumber}", method = RequestMethod.GET)
	@ResponseBody
    public void numbersMetadata(@PathVariable("contactNumber") String contactNumber, HttpServletRequest request, HttpServletResponse response) {
		callManifestService.numbersMetadata(contactNumber, null);
    }
	
	@RequestMapping(value = "/getNumberMetadata", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getNumberMetadata(@RequestParam(value="phoneNumber") String phoneNumber, HttpServletRequest request, HttpServletResponse response) {
		return callManifestService.getNumberMetadata(phoneNumber);
    }
	
	@RequestMapping(value = "/getAllSendManualSms", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllSendManualSms (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return sendManualSmsService.getAllSendManualSms(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createSendManualSms", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createSendManualSms(@RequestBody SendManualSms sendManualSms, HttpServletRequest request, HttpServletResponse response) {
		return sendManualSmsService.createSendManualSms(sendManualSms);
    }
	
	@RequestMapping(value = "/deleteSendManualSms/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteSendManualSms(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return sendManualSmsService.deleteSendManualSms(key);
    }
	
	@RequestMapping(value = "/getTemplates", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getTemplates(@RequestBody SendManualSms sendManualSms, HttpServletRequest request, HttpServletResponse response) {
		return sendManualSmsService.getTemplates(sendManualSms);
    }
	
	@RequestMapping(value = "/publishedSendManualSms/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean publishedSendManualSms(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return sendManualSmsService.markePublished(key);
    }
	
	@RequestMapping(value = "/sendManualSmsCron", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean sendManualSmsCron( HttpServletRequest request, HttpServletResponse response) {
		return sendManualSmsService.sendManualSmsCron();
    }
	
	@RequestMapping(value = "/getUserListTeleManifest", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getUserListTeleManifest(HttpServletRequest request, HttpServletResponse response) {
		return userService.getUserListTeleManifest();
    }
	
	/*@RequestMapping(value = "/downloadProformaInvoice/{awbNumbers}", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getProformaInvoice(@PathVariable("awbNumbers") String awbNumbers, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return alertHelper.getProformaInvoice(awbNumbers);
    }*/
	
	/*@RequestMapping(value = "/downloadProformaInvoice", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getProformaInvoice(@RequestParam(value = "awbNumbers") String awbNumbers,@RequestParam(value = "productSkus") String productSkus, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return alertHelper.getProformaInvoice(awbNumbers, productSkus);
    }
	*/
	@RequestMapping(value = "/downloadProformaInvoice", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView downloadPackageSlip (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("saleOrder/proformaInvoice");
		if (request.getParameter("awbList") != null && !request.getParameter("awbList").trim().equals("")) {
			try {
				String awbNumbers = request.getParameter("awbList");
				List<String> errorList = new ArrayList<>();
				for(String awb : awbNumbers.split(",")){
					SaleOrder saleOrder = saleOrderDao.getObjectById(awb.trim(), SaleOrder.class);
					
					ClientProductSkuRate clientProductSkuRate = clientProductSkuRateService.getClientProductSkuRate(saleOrder.getClientKey_s(), saleOrder.getProductName());
					if(clientProductSkuRate == null) {
						errorList.add("Client Product SKU Rate not present of AWB:"+saleOrder.getAwbNumber());
					}
					
					/*if(saleOrder.getHsnCode() == null){
						errorList.add("HsnCode cannot be empty for awbNumber "+saleOrder.getAwbNumber());
					}else if(saleOrder.getProductPrice() == null){
						errorList.add("Product price cannot be empty for awbNumber "+saleOrder.getAwbNumber());
					}else if(saleOrder.getTaxableValue() == null){
						errorList.add("Taxable value cannot be empty for awbNumber "+saleOrder.getAwbNumber());
					}else if(saleOrder.getcGSTAmount() == null){
						errorList.add("CGST cannot be empty for awbNumber "+saleOrder.getAwbNumber());
					}else if(saleOrder.getsGSTAmount() == null){
						errorList.add("SGST cannot be empty for awbNumber "+saleOrder.getAwbNumber());
					}else if(saleOrder.getiGSTAmount() == null){
						errorList.add("IGST cannot be empty for awbNumber "+saleOrder.getAwbNumber());
					}else if(saleOrder.getProformaInvoiceNumber() == null || "".equals(saleOrder.getProformaInvoiceNumber().trim())){
						errorList.add("OrderSku Mapping Not Present For AwbNumber "+saleOrder.getAwbNumber());
					}*/
				}
				
				String productSkus = null;
				if(errorList.isEmpty()){
				ResponseBean responseBean = alertHelper.getProformaInvoice(awbNumbers, productSkus);
					model.addObject("responseBean", responseBean);
					model.addObject("responseBeanHtml", responseBean.getResponse());
					model.addObject("isError", false);
				}
				else{
					model.addObject("responseBeanHtml", errorList);
					return model;
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addObject("isError", true);
				model.addObject("errorMsg", "Please Provide Valid AwbNumbers");
				model.addObject("responseBeanHtml", "Please Provide Valid AwbNumbers");
				return model;
			}
		}else if (request.getParameter("productSkuList") != null && !request.getParameter("productSkuList").trim().equals("")) {
			try {
				String awbNumbers = null;
				String productSkus = request.getParameter("productSkuList");
				String[] productSkuArr = productSkus.split(",");
				
				Query query = new Query();
				//query.addCriteria(Criteria.where("awbNumber").in(productSkuArr).orOperator(Criteria.where("productSKU").in(productSkuArr)));
				query.addCriteria( new Criteria().orOperator(where("awbNumber").in(productSkuArr),(where("productSKU").in(productSkuArr))));
				List<SaleOrder> resultList = saleOrderDao.getObjectByQuery(query, SaleOrder.class);
				if(resultList != null && !resultList.isEmpty()){
					for(SaleOrder saleorder : resultList){
						if(saleorder.getKey_s().endsWith("RTO")){
							continue;
						}
						if(awbNumbers == null){
							awbNumbers = saleorder.getAwbNumber();
						}else{
							awbNumbers = awbNumbers + "," + saleorder.getAwbNumber();
						}
					}
				}
				ResponseBean responseBean = alertHelper.getProformaInvoice(awbNumbers, productSkus);
				model.addObject("responseBean", responseBean);
				model.addObject("responseBeanHtml", responseBean.getResponse());
				model.addObject("isError", false);
			} catch (Exception e) {
				e.printStackTrace();
				model.addObject("isError", true);
				model.addObject("errorMsg", "Please Provide Valid AwbNumbers");
				model.addObject("responseBeanHtml", "Please Provide Valid AwbNumbers");
				return model;
			}
		} else {
			model.addObject("isError", true);
			model.addObject("errorMsg", "Please Provide AwbNumbers");
			model.addObject("responseBeanHtml", "Please Provide Valid AwbNumbers");
			return model;
		}
		return model;
	}
	
	@RequestMapping(value = "/getReasonsByType", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getReasonsByType(@RequestParam(value="type") String type, HttpServletRequest request, HttpServletResponse response) {
    	return settingsService.getReasonsByType(type);
    }
	
	@RequestMapping(value = "/validateDiallerPin", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean validateDiallerPin(@RequestParam(value="diallerPin") String diallerPin,@RequestParam(value="userId") String userId,
    		HttpServletRequest request, HttpServletResponse response) {
    	return userService.validateDiallerPin(diallerPin,userId);
    }
	
	@RequestMapping(value = "/sendRegisterOtp", method = RequestMethod.POST)
	public @ResponseBody ResponseBean sendRegisterOtp(@RequestParam(value="userId", required=true) String userId, HttpServletRequest request, HttpServletResponse response) {
		return userService.sendRegisterOtp(userId);
	}
	
	@RequestMapping(value = "/createUserAndSendOtp", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createUserAndSendOtp(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("image", request.getFile("file"));
		System.out.println(doc);
		System.out.println(request.getFileMap());
		
		String userBean = request.getParameter("userBean");
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userBean, User.class);
        return userService.createUserAndSendOtp(user,doc);
    }
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean updateDrs(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {	
		String userBean = request.getParameter("userBean");
		Map<String,List<MultipartFile>> file = new HashMap<String,List<MultipartFile>>();
		file.put("panCardImg", request.getFiles("panCardImg"));
		file.put("aadharCardImg", request.getFiles("aadharCardImg"));
		file.put("drivingLicenceImg", request.getFiles("drivingLicenceImg"));
		file.put("vehicleImg", request.getFiles("vehicleImg"));
		file.put("cancelCheque", request.getFiles("cancelCheque"));
		System.out.println("************registerUser*************");
		System.out.println(file);
		System.out.println(request.getFileMap());
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userBean, User.class);
        return userService.registerUser(user,file);
	}
	
	@RequestMapping(value = "/updateKycAndBankDetails", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean updateKycAndBankDetails(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {	
		String userBean = request.getParameter("userBean");
		Map<String,List<MultipartFile>> file = new HashMap<String,List<MultipartFile>>();
		file.put("panCardImg", request.getFiles("panCardImg"));
		file.put("aadharCardImg", request.getFiles("aadharCardImg"));
		file.put("drivingLicenceImg", request.getFiles("drivingLicenceImg"));
		file.put("vehicleImg", request.getFiles("vehicleImg"));
		file.put("cancelCheque", request.getFiles("cancelCheque"));
		System.out.println("************updateKycAndBankDetails*************");
		System.out.println(file);
        System.out.println(request.getFileMap());
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userBean, User.class);
        return userService.updateKycAndBankDetails(user,file);
	}
	
	@RequestMapping(value = "/getBankList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getBankList(HttpServletRequest request, HttpServletResponse response) {
    	return settingsService.getBankList();
    }
	
	@RequestMapping(value = "/getAllFieldExecutive", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllFieldExecutive (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return userService.getAllFieldExecutive(datatableRequestBean);
    }
	
	@RequestMapping(value = "/loadKycStatus", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadKycStatus( HttpServletRequest request, HttpServletResponse response) {
		return userService.loadKycStatus();
    }
	
	@RequestMapping("/downloadUserKycDoc")
	@ResponseBody
	public void downloadShipmentQcPod(@RequestParam(value = "key") String key,
			HttpServletResponse response) throws Exception {
		userService.downloadUserKycDoc(key, response);
	}
	
	@RequestMapping(value = "/approveRejectKyc/{kycStatus}", method = RequestMethod.POST)
		
		public @ResponseBody ResponseBean approveRejectKyc(@PathVariable("kycStatus") KycStatus kycStatus, MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
			Map<String,List<MultipartFile>> doc = new HashMap<String,List<MultipartFile>>();
			doc.put("aadharCardImg", request.getFiles("aadharCardImage"));
			doc.put("panCardImg", request.getFiles("panCardImage"));
			doc.put("drivingLicenceImg", request.getFiles("drivingLicenceImage"));
			doc.put("vehicleImg", request.getFiles("vehicleImage"));
			doc.put("cancelCheque", request.getFiles("cancelChequeImage"));
			System.out.println("************approveRejectKyc*************");
			System.out.println(doc);
			System.out.println(request.getFileMap());
			String userBean = request.getParameter("userBean");
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(userBean, User.class);
	        return userService.approveRejectKyc(user, doc, kycStatus);
			
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean register(
			@RequestParam(value="companyName") String companyName,
			@RequestParam(value="concernPerson") String concernPerson,
			@RequestParam(value="mobile") String mobile,
			@RequestParam(value="emailId") String emailId,
			@RequestParam(value="password") String password,
			@RequestParam(value="city") String city,
			HttpServletRequest request, HttpServletResponse response) {
		return userService.register(companyName,concernPerson,mobile,emailId,password,city);
	}
	@RequestMapping(value = "/otpVerification", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean otpVerification(
			@RequestParam(value="otp") String otp,
			HttpServletRequest request, HttpServletResponse response) {
		return userService.otpVerification(otp);
	}
	@RequestMapping(value = "/resendOtp", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean resendOtp(
			@RequestParam(value="mobile") String mobile,
			@RequestParam(value="emailId", required = false) String emailId,
			@RequestParam(value="type") String type,
			HttpServletRequest request, HttpServletResponse response) {
		return userService.resendOtp(mobile,emailId, type);
	}
	@RequestMapping(value = "/getSessionUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getSessionUser(HttpServletRequest request, HttpServletResponse response) {
		return userService.getSessionUser();
	}
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updatePassword(
			@RequestParam(value="mobile") String mobileNo,
			@RequestParam(value="otp") String otp,
			@RequestParam(value="password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		return userService.updatePassword(mobileNo,otp,password);
	}
}