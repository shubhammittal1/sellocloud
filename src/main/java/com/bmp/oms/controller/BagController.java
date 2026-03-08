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
import com.bmp.model.app.bag.Bag;
import com.bmp.oms.service.bag.BagService;


@Controller
@RequestMapping("/bag")
public class BagController {

	@Autowired
	@Qualifier("bagServiceImpl")
	private BagService bagService;
	
	
	@RequestMapping(value = "/getAllNewBag", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllNewBag(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return bagService.getAllNewBag(datatableRequestBean);
	}
	
	@RequestMapping(value = "/createBag/{awbNo}", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createBag(@RequestBody Bag bag,@PathVariable("awbNo") String awbNo, HttpServletRequest request, HttpServletResponse response) {
		return bagService.createBag(bag,awbNo);
    }
	
	@RequestMapping(value = "/getPacketsOfBag/{bagKey}", method = RequestMethod.GET)
  	@ResponseBody
	public  ResponseBean getPacketsOfBag(@PathVariable("bagKey") String bagKey, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return bagService.getPacketsOfBag(bagKey);
	}
	
	@RequestMapping(value = "/deleteBag/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteBag(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return bagService.deleteBag(key);
    }
	
	@RequestMapping(value = "/getBagSaleOrders/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBagSaleOrders(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return bagService.getBagSaleOrders(key);
    }
	
	@RequestMapping(value = "/editBag/{awbNo}", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean editBag(@RequestBody Bag bag,@PathVariable("awbNo") String awbNo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return bagService.editBag(bag,awbNo);
	}
	
	@RequestMapping(value = "/isAvailableBagSealNo/{bagSealNo_s}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean isAvailableBagSealNo (@PathVariable("bagSealNo_s") String bagSealNo) {
		return bagService.isAvailableBagSealNo(bagSealNo);
    }
	
	@RequestMapping(value = "/getPacketsOnBranch/{destinationBranch}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getPacketsOnBranch (@PathVariable("destinationBranch") String destinationBranch) {
		return bagService.getPacketsOnBranch(destinationBranch);
    }
	
	@RequestMapping(value = "/getBagReadyForDebagging", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getIntransitBags(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return bagService.getBagReadyForDebagging(datatableRequestBean);
	}
	
	@RequestMapping(value = "/closeBag", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean closeBag(@RequestBody Bag bag,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return bagService.closeBag(bag);
	}
	
	@RequestMapping(value = "/removePacketFromBag/{key}/{bagKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean updateSaleOrderStatus(@PathVariable("key") String key,@PathVariable("bagKey") String bagKey, HttpServletRequest request, HttpServletResponse response) {
		return bagService.removePacketFromBag(key,bagKey);
    }
	
	@RequestMapping(value = "/getAllMissingBag", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllMissingBag(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return bagService.getAllMissingBag(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getBagDetailsByKey/{sealNo}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBagDetailsByKey(@PathVariable("sealNo") String sealNo, HttpServletRequest request, HttpServletResponse response) {
		return bagService.getBagDetailsByKey(sealNo);
    }
	
	@RequestMapping(value = "/getDebagReport", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getDebagReport (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return bagService.getDebagReport(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getCloseBagReport", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getCloseBagReport (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return bagService.getCloseBagReport(datatableRequestBean);
    }
	 
	@RequestMapping(value = "/getPendingBagForManifest", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getPendingBagForManifest (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return bagService.getPendingBagForManifest(datatableRequestBean);
    }
	
	@RequestMapping(value = "/bagSealedForManifest/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean bagSealedForManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return bagService.bagSealedForManifest(key);
    }
	
	@RequestMapping(value = "/lostConfirm/{key}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean lostConfirm(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return bagService.lostConfirm(key);
    }
}