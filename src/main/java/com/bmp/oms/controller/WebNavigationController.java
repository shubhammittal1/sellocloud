package com.bmp.oms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bmp.constant.GlobalConstant;
import com.bmp.dao.SettingsDao;
import com.bmp.model.app.config.Settings;
import com.bmp.oms.service.c2c.WebUserService;

	
@Controller
public class WebNavigationController {
	
	@Autowired
	@Qualifier("webUserServiceImpl")
	private WebUserService webUserService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("settingsDaoImpl")
	private SettingsDao settingsDao;
	
	@RequestMapping("/onlineBooking")
	public ModelAndView c2cWeb(HttpServletRequest request,HttpServletResponse res) {
		try {
			Map<String,String> map = new HashedMap();
			List<Settings> settingList = settingsDao.getObjectListByIds(Arrays.asList(messageSource.getMessage(GlobalConstant.C2C_SOCIAL, null, null).split(",")), Settings.class);
			for(Settings setting : settingList){
				map.put(setting.getKey_s(), setting.getContextValue_s());
			}
			ServletContext context = request.getSession().getServletContext();
			context.setAttribute("social", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("c2c/home/home");
	}
	
	@RequestMapping("/parcelledDetail")
	public ModelAndView parcelledDetail(HttpServletRequest request,HttpServletResponse res) {
	        String name = request.getParameter("sourceCity");  
	        String password = request.getParameter("sourcePincode");  
		return new ModelAndView("c2c/order/parcelledDetail");
	}
	
	/*@RequestMapping("/deliveryAddressDetail")
	public ModelAndView confirmationAddressDetail() {
		return new ModelAndView("c2c/order/deliveryAddressDetail");
	}*/
	
	/*@RequestMapping(value="/parcelDetails", method= RequestMethod.POST)
	public ModelAndView serviceDetail(@ModelAttribute("bookingRequestBean") BookingRequestBean data,HttpServletRequest request) {
		return new ModelAndView("c2c/order/serviceDetail","data",data);
	}*/
	
	/*@RequestMapping("/parcelledReview")
	public ModelAndView parcelledReview() {
		return new ModelAndView("c2c/order/parcelledReview");
	}*/
	
	@RequestMapping("/contactUs")
	public ModelAndView contactUs() {
		return new ModelAndView("c2c/myaccount/enquiry");
	}
	
	/*@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("c2c/register/register");
	}*/
	
	/*@RequestMapping("/c2cWebLogin")
	public ModelAndView loginForm() {
		return new ModelAndView("c2c/myaccount/login");
	}*/
	
	@RequestMapping("/bulkShipping")
	public ModelAndView bulkShipping() {
		return new ModelAndView("c2c/staticpages/bulkShipping");
	}
	
	@RequestMapping("/accountSetting")
	public ModelAndView accountSetting() {
		return new ModelAndView("c2c/myaccount/accountSetting");
	}
	
	@RequestMapping("/courierServices")
	public ModelAndView services() {
		return new ModelAndView("c2c/staticpages/courierServices");
	}
	
	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs() {
		return new ModelAndView("c2c/staticpages/aboutUs");
	}
	
	@RequestMapping("/termCondition")
	public ModelAndView termCondition() {
		return new ModelAndView("c2c/staticpages/termCondition");
	}
	
	@RequestMapping("/prohibitedField")
	public ModelAndView prohibitedField() {
		return new ModelAndView("c2c/staticpages/prohibitedField");
	}
	
	@RequestMapping("/claimPolicy")
	public ModelAndView claimPolicy() {
		return new ModelAndView("c2c/staticpages/claimPolicy");
	}
	
	@RequestMapping("/refundPolicy")
	public ModelAndView refundPolicy() {
		return new ModelAndView("c2c/staticpages/refundPolicy");
	}
	
	@RequestMapping("/c2cBulkupload")
	public ModelAndView c2cBulkupload() {
		return new ModelAndView("c2c/order/c2cBulkupload");
	}
	
	@RequestMapping("/pay")
	public ModelAndView pay(HttpServletRequest request) {
		return new ModelAndView("wallet/ebs/pay");
	}
	
	@RequestMapping("/c2cOrderPrint")
	public ModelAndView c2cOrderPrint(HttpServletRequest request) {
		return new ModelAndView("c2c/order/c2cOrderPrint");
	}
	
	@RequestMapping("/faq")
	public ModelAndView faq() {
		return new ModelAndView("c2c/staticpages/faq");
	}
	
	/*@RequestMapping(value = "/trackingShipment")
	public ModelAndView trackingShipment() {
		return new ModelAndView("c2c/tracking/trackingShipment");
	}*/
	
	@RequestMapping(value = "/trackingShipment", method = RequestMethod.GET)
	public ModelAndView trackingShipment(@RequestParam(value="awbNumber", required=false) String awbNumber, HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("c2c/tracking/trackingShipment","awb",awbNumber);
	}
	
	//left pannal include 
	@RequestMapping("/userProfile")
	public ModelAndView userProfile() {
		return new ModelAndView("c2c/myaccount/userProfile");
	}
	
	@RequestMapping("/addressBook")
	public ModelAndView addressBook() {
		return new ModelAndView("c2c/myaccount/addressBook");
	}
	
	@RequestMapping("/passwordSetting")
	public ModelAndView passwordSetting() {
		return new ModelAndView("c2c/myaccount/passwordSetting");
	}
	
	@RequestMapping("/packetBulkShipping")
	public ModelAndView c2cBulkUpload() {
		return new ModelAndView("c2c/myaccount/bulkShipping");
	}
	
	@RequestMapping("/paymentPending")
	public ModelAndView paymentPending() {
		return new ModelAndView("c2c/myaccount/paymentPending");
	}
	
	@RequestMapping("/orderHistory")
	public ModelAndView orderHistory() {
		return new ModelAndView("c2c/order/orderHistory");
	}
	
	@RequestMapping("/deliveryStatement")
	public ModelAndView deliveryStatement() {
		return new ModelAndView("c2c/order/deliveryStatement");
	}
	
	@RequestMapping("/internationalBooking")
	public ModelAndView internationalBooking() {
		return new ModelAndView("c2c/order/internationalBooking");
	}
	
	
	
}
