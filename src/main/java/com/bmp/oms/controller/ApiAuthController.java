package com.bmp.oms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmp.bean.client.ApiAwbSeriesBean;
import com.bmp.bean.client.ClientRateApiBean;
import com.bmp.bean.client.ClientWarehouseApiBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.courier.CheckServiceabilityApiBean;
import com.bmp.bean.saleorder.ApiPrintLeableBean;
import com.bmp.bean.saleorder.BfilOrderBean;
import com.bmp.bean.saleorder.PickupRequestApiBean;
import com.bmp.bean.saleorder.SaleOrderApiBean;
import com.bmp.bean.saleorder.StagingSaleOrderApiBean;
import com.bmp.bean.trackStatus.TrackOrderBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.model.app.api.jaxbean.BluedartPodConsumeBean;
import com.bmp.model.app.api.jaxbean.DelhiveryPodConsumeBean;
import com.bmp.oms.service.client.ClientBillingService;
import com.bmp.oms.service.courier.CourierService;
import com.bmp.oms.service.masters.AWBSeriesService;
import com.bmp.oms.service.saleorder.BmpApiService;

@Controller
@RequestMapping("/api/auth/v1")
public class ApiAuthController {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("bmpApiServiceImpl")
	private BmpApiService bmpApiService;
	
	@Autowired
	@Qualifier("awbSeriesServiceImp")
	private AWBSeriesService awbSeriesService;
	
	@Autowired
	@Qualifier("courierServiceImpl")
	private CourierService courierService;
	
	@Autowired
	@Qualifier("clientBillingServiceImpl")
	private ClientBillingService clientBillingService;
	
	@RequestMapping(value = "/SaleOrderPush", method = RequestMethod.POST)
	@ResponseBody 
	public List<ResponseBean> pushSaleOrder(@RequestBody List<SaleOrderApiBean> saleOrderList, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.pushSaleOrder(saleOrderList, tokenValue);
	}
	
	@RequestMapping(value = "/StagingSaleOrderPush", method = RequestMethod.POST)
	@ResponseBody 
	public List<ResponseBean> pushStagingSaleOrder(@RequestBody List<StagingSaleOrderApiBean> saleOrderList, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.pushStagingSaleOrder(saleOrderList, tokenValue);
	}
	
	@RequestMapping(value = "/BulkAwbGenerate", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean bulkAwbGenerate(@RequestBody ApiAwbSeriesBean apiAwbSeriesBean, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return awbSeriesService.bulkAwbGenerate(apiAwbSeriesBean, tokenValue);
	}
	
	@RequestMapping(value = "/FetchAwbNumber", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean fetchAwbNumber(@RequestBody ApiAwbSeriesBean apiAwbSeriesBean, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return awbSeriesService.fetchAwbNumber(apiAwbSeriesBean, tokenValue);
	}
	
	@RequestMapping(value = "/CheckServiceability", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean serviceabilityCheck(@RequestBody CheckServiceabilityApiBean checkServiceabilityApiBean, HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return courierService.checkServiceability(checkServiceabilityApiBean, tokenValue);
    }

	@RequestMapping(value = "/TrackCurrentStatus", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getDocketCurrentStatus(@RequestBody TrackOrderBean trStatusBean, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getDocketCurrentStatus(trStatusBean, tokenValue);
	}
	
	@RequestMapping(value = "/TrackAllStatus", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getDocketDetails(@RequestBody TrackOrderBean trStatusBean,HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getDocketDetails(trStatusBean, tokenValue);
	}
	
	@RequestMapping(value = "/TrackOrderForApollo", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getOrderDetailsForApollo(@RequestBody TrackOrderBean trStatusBean,HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getOrderDetailsForApollo(trStatusBean, tokenValue);
	}
	
	@RequestMapping(value = "/Tracking", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getShipment(@RequestBody TrackOrderBean trStatusBean, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getShipment(trStatusBean, tokenValue);
	}
	
	@RequestMapping(value = "/GetClientWarehouses", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getClientWarehouses(@RequestBody ClientWarehouseApiBean clientWarehouse, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getClientWarehouses(clientWarehouse, tokenValue);
	}
	
	@RequestMapping(value = "/GeneratePickupRequest", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean generatePickupRequest(@RequestBody PickupRequestApiBean pickupRequest, HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.generatePickupRequest(pickupRequest, tokenValue);
	}
	
	@RequestMapping(value = "/OrderPrintLable", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean orderPrintLable(@RequestBody ApiPrintLeableBean apiPrintLeableBean, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		//bmpApiService.orderPrintLable(apiPrintLeableBean, tokenValue,request,response);
		return bmpApiService.orderPrintLable(apiPrintLeableBean, tokenValue,request,response);
	}
	
	@RequestMapping(value = "/OrderPrintLables", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getPrintLabel(@RequestBody ApiPrintLeableBean apiPrintLeableBean, HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.orderPrintLableNew(apiPrintLeableBean, tokenValue,request,response);
	}
	
	@RequestMapping(value = "/GetRateEstimate", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getClientRates(@RequestBody ClientRateApiBean clientRateBean, HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getRateEstimate(clientRateBean, tokenValue);
    }
	
	@RequestMapping(value = "/TrackOrder", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getOrderDetailsForClient(@RequestBody TrackOrderBean trStatusBean,HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getOrderDetailsForClient(trStatusBean, tokenValue);
	}
	
	@RequestMapping(value = "/TrackOrderForApolloIVR", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getOrderDetailsForApolloIVR(@RequestBody TrackOrderBean trStatusBean,HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getOrderDetailsForApolloIVR(trStatusBean, tokenValue);
	}
	
	/*Start - Apollo HealthJinn Apis*/
	@RequestMapping(value = "/CheckPincodeServiceability", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean pincodeServiceabilityCheck(@RequestBody CheckServiceabilityApiBean checkServiceabilityApiBean, HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return courierService.checkPincodeServiceability(checkServiceabilityApiBean, tokenValue);
    }
	
	@RequestMapping(value = "/PickupAppointmentSlot", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean pickupAppointmentSlot(HttpServletRequest request, HttpServletResponse response) {
		return courierService.pickupAppointmentSlot();
    }
	/*End - Apollo HealthJinn Apis*/
	
	@RequestMapping(value = "/GetOrderPOD", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean getOrderPOD(@RequestBody BfilOrderBean bfilOrderBean, HttpServletRequest request, HttpServletResponse response){
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return bmpApiService.getOrderPOD(bfilOrderBean, tokenValue);
	}
	
	@RequestMapping(value = "/ConsumeBluedartPod", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean consumeBluedartPod(@RequestBody BluedartPodConsumeBean bluedartPodConsumeBean,HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return courierService.consumeBluedartPod(bluedartPodConsumeBean, tokenValue);
	}
	
	@RequestMapping(value = "/ConsumeDelhiveryPod", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean consumeDelhiveryPod(@RequestBody DelhiveryPodConsumeBean delhiveryPodConsumeBean,HttpServletRequest request, HttpServletResponse response) {
		String tokenValue = request.getHeaderNames()!=null ? request.getHeader(GlobalConstant.HEADER_TOKEN) : null;
		return courierService.consumeDelhiveryPod(delhiveryPodConsumeBean, tokenValue);
	}


    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    public String handleCallback(@RequestBody Map<String, Object> payload) {
        System.out.println("Received API key payload: " + payload);

        Integer keyId = (Integer) payload.get("key_id");
        String userId = String.valueOf(payload.get("user_id"));
        String consumerKey = (String) payload.get("consumer_key");
        String consumerSecret = (String) payload.get("consumer_secret");
        String permissions = (String) payload.get("key_permissions");

        // TODO: save securely (database/encryption)
        System.out.printf("User %s: Key %s, Secret %s, Permissions %s%n",
                userId, consumerKey, consumerSecret, permissions);

        // Return 200 OK to WooCommerce
        return "OK";
    }
	
}
