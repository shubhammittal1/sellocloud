package com.bmp.oms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmp.bean.ApiResponseBean;
import com.bmp.bean.ApiResponseC2CBean;
import com.bmp.bean.LbhUploadApiBean;
import com.bmp.bean.saleorder.OldStagingSaleOrderBean;
import com.bmp.bean.saleorder.StagingSaleOrderResponse;
import com.bmp.bean.trackStatus.TrackCurrentStatusBean;
import com.bmp.oms.service.drs.DrsService;
import com.bmp.oms.service.saleorder.BmpApiService;
import com.bmp.oms.service.saleorder.SaleOrderService;
import com.bmp.oms.service.saleorder.StagingSaleOrderService;


@Controller
public class BmpApiController {
	
	@Autowired
	@Qualifier("bmpApiServiceImpl")
	private BmpApiService bmpApiService;
	
	@Autowired
	@Qualifier("stagingSaleOrderServiceImpl")
	private StagingSaleOrderService stagingSaleOrderService;
	
	@Autowired
	@Qualifier("drsServiceImpl")
	private DrsService drsService;
	
	@Autowired
	@Qualifier("saleOrderServiceImpl")
	private  SaleOrderService saleOrderService;
	
	/*@RequestMapping(value = "/trackCurrentStatus", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean trackCurrentStatusOfPackets(@RequestBody TrackCurrentStatusBean trStatusBean, HttpServletRequest request, HttpServletResponse response){
		return trackStatusService.getCurrentStatusOfPackets(trStatusBean.getClientKey(), trStatusBean.getSearchBy(), trStatusBean.getAwbNumber());
	}*/

	/*@RequestMapping(value = "/trackAllStatus", method = RequestMethod.POST)
	@ResponseBody 
	public ResponseBean trackAllStatusOfPackets(@RequestBody TrackCurrentStatusBean trStatusBean,HttpServletRequest request, HttpServletResponse response) {
		return trackStatusService.getAllStatusOfPackets(trStatusBean.getAwbNumber());
	}*/
	
	
	@RequestMapping(value = "/trackCurrentStatus", method = RequestMethod.GET)
	@ResponseBody 
	public ApiResponseBean getCurrentStatusOfShipment(@RequestParam("awbNumber") String awbNumber, @RequestParam(value = "searchBy", required=false) String searchBy, 
			@RequestParam(value = "clientId", required=false) String clientId, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.getCurrentStatusOfShipment(clientId, searchBy, awbNumber);
	}
	
	@RequestMapping(value = "/trackAllStatus", method = RequestMethod.GET)
	@ResponseBody 
	public ApiResponseBean getAllStatusOfShipment(@RequestParam("awbNumber") String awbNumber,HttpServletRequest request, HttpServletResponse response) {
		return bmpApiService.getAllStatusOfShipment(awbNumber);
	}
	
	@RequestMapping(value = "/getOrderForApollo", method = RequestMethod.POST)
	@ResponseBody 
	public ApiResponseBean getOrderForApollo(@RequestBody TrackCurrentStatusBean trStatusBean, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.getOrderForApollo(trStatusBean.getClientId(), trStatusBean.getSearchBy(), trStatusBean.getAwbNumber());
	}
	
	@RequestMapping(value = "/trackCurrentStatusNew", method = RequestMethod.POST)
	@ResponseBody 
	public ApiResponseBean gettrackCurrentStatusNew(@RequestBody TrackCurrentStatusBean trStatusBean, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.getCurrentStatusOfShipment(trStatusBean.getClientId(), trStatusBean.getSearchBy(), trStatusBean.getAwbNumber());
	}
	
	
	@RequestMapping(value = "/StagingSaleOrder", method = RequestMethod.POST)
	@ResponseBody 
	public StagingSaleOrderResponse getOldStagingSaleOrder(@RequestBody OldStagingSaleOrderBean stagingSaleOrder, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.getOldStagingSaleOrder(stagingSaleOrder);
	}
	
	@RequestMapping(value = "/trackAllStatusForC2C", method = RequestMethod.GET)
	@ResponseBody 
	public ApiResponseC2CBean getAllStatusShipmentForC2C(@RequestParam("awbNumber") String awbNumber, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.getAllStatusShipmentForC2C(awbNumber);
	}
	
	@RequestMapping(value = "/trackCurrentStatusForC2C", method = RequestMethod.GET)
	@ResponseBody 
	public ApiResponseBean trackCurrentStatusForC2C(@RequestParam("awbNumber") String awbNumber, @RequestParam(value = "searchBy", required=false) String searchBy, 
			@RequestParam(value = "clientId", required=false) String clientId, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.trackCurrentStatusForC2CNew(clientId, searchBy, awbNumber);
	}
	
	@RequestMapping(value = "/trackCurrentStatusForC2CPost", method = RequestMethod.POST)
	@ResponseBody 
	public ApiResponseBean trackCurrentStatusForC2C(@RequestBody TrackCurrentStatusBean trStatusBean, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.trackCurrentStatusForC2CNew(trStatusBean.getClientId(), trStatusBean.getSearchBy(), trStatusBean.getAwbNumber());
	}
	
	@RequestMapping(value = "/getDashBoardCount", method = RequestMethod.GET)
	@ResponseBody
	public ApiResponseBean getDashBoardCount(@RequestParam("user") String user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return drsService.getDashBoardCount(user);
	}
	
	@RequestMapping(value = "/trackPacket", method = RequestMethod.GET)
	public ResponseEntity<String> getContentByIdsAsXML(@RequestParam(value = "packet") String packet) throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/xml; charset=utf-8");
		String result = bmpApiService.getContentByIdsAsXMLData(packet).replaceAll("&", "&amp;");
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/trackPacketJSON", method = RequestMethod.GET)
	@ResponseBody 
	public String trackPacketJSON(@RequestParam("packet") String packet, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.trackPacketJSON(packet);
	}
	
	@RequestMapping(value = "/api/Tracking/{track}", method = RequestMethod.GET)
	@ResponseBody 
	public String getAllPacketDetails(@PathVariable("track") String awbNumber, HttpServletRequest request, HttpServletResponse response){
		return bmpApiService.getAllPacketDetails(awbNumber);
	}
	
	/*@RequestMapping(value = "/uploadLBHData", method = RequestMethod.POST)
	public @ResponseBody ApiResponseBean lbhUploadByApi(@RequestBody LbhUploadApiBean lbhUploadApiBean, HttpServletResponse response) throws Exception {
		return saleOrderService.lbhUploadByApi(lbhUploadApiBean);
	}*/
	
}
