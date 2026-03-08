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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.model.app.status.StatusFlow;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.app.status.StatusTransition;
import com.bmp.oms.service.status.StatusFlowService;
import com.bmp.oms.service.status.StatusMasterService;
import com.bmp.oms.service.status.StatusTransitionService;

@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	@Qualifier("statusMasterServiceImpl")
	private StatusMasterService statusMasterService;
	

	@Autowired
	@Qualifier("statusTransitionServiceImpl")
	private StatusTransitionService statusTransitionService;
	
	@Autowired
	@Qualifier("statusFlowServiceImpl")
	private StatusFlowService statusFlowService;
	
	
	@RequestMapping(value = "/checkStatusMasterKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkStatusMasterKeyAvailable (@PathVariable("key") String key) {
		return statusMasterService.checkStatusMasterKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllStatusMasters", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllStatusMasters (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return statusMasterService.getAllStatusMasters(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createStatusMaster", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createStatusMaster(@RequestBody StatusMaster statusMaster, HttpServletRequest request, HttpServletResponse response) {
		return statusMasterService.createStatusMaster(statusMaster);
    }
	
	@RequestMapping(value = "/updateStatusMaster", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateStatusMaster(@RequestBody StatusMaster statusMaster, HttpServletRequest request, HttpServletResponse response) {
		return statusMasterService.updateStatusMaster(statusMaster);
    }
	
	@RequestMapping(value = "/deleteStatusMaster/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteStatusMaster(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return statusMasterService.deleteStatusMaster(key);
    }

	@RequestMapping(value = "/checkStatusTransitionKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkStatusTransitionKeyAvailable (@PathVariable("key") String key) {
		return statusTransitionService.checkStatusTransitionKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllStatusTransitions", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllStatusTransitions (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return statusTransitionService.getAllStatusTransitions(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createStatusTransition", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createStatusTransition(@RequestBody StatusTransition statusTransition, HttpServletRequest request, HttpServletResponse response) {
		return statusTransitionService.createStatusTransition(statusTransition);
    }
	
	@RequestMapping(value = "/updateStatusTransition", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateStatusTransition(@RequestBody StatusTransition statusTransition, HttpServletRequest request, HttpServletResponse response) {
		return statusTransitionService.updateStatusTransition(statusTransition);
    }
	
	@RequestMapping(value = "/deleteStatusTransition/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteStatusTransition(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return statusTransitionService.deleteStatusTransition(key);
    }

	@RequestMapping(value = "/loadStatusMasters", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadStatusMasters(HttpServletRequest request, HttpServletResponse response) {
		return statusMasterService.loadStatusMasters();
    }

	@RequestMapping(value = "/checkStatusFlowKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkStatusFlowKeyAvailable (@PathVariable("key") String key) {
		return statusFlowService.checkStatusFlowKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllStatusFlows", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllStatusFlows (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return statusFlowService.getAllStatusFlows(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createStatusFlow", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createStatusFlow(@RequestBody StatusFlow statusFlow, HttpServletRequest request, HttpServletResponse response) {
		return statusFlowService.createStatusFlow(statusFlow);
    }
	
	@RequestMapping(value = "/updateStatusFlow", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateStatusFlow(@RequestBody StatusFlow statusFlow, HttpServletRequest request, HttpServletResponse response) {
		return statusFlowService.updateStatusFlow(statusFlow);
    }
	
	@RequestMapping(value = "/deleteStatusFlow/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteStatusFlow(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return statusFlowService.deleteStatusFlow(key);
    }
	
	@RequestMapping(value = "/loadStatusTransitions", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadStatusTransitions(HttpServletRequest request, HttpServletResponse response) {
		return statusTransitionService.loadStatusTransitions();
    }
	
	@RequestMapping(value = "/getPacketsStatus", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getPacketsStatus(HttpServletRequest request, HttpServletResponse response) {
		return statusMasterService.getPacketsStatus();
    }
	
	@RequestMapping(value = "/getAllPacketStatus", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getAllPacketStatus(HttpServletRequest request, HttpServletResponse response) {
		return statusMasterService.getAllPacketStatus();
    }
	
	@RequestMapping(value = "/loadTelecallingStatus", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadTelecallingStatus( HttpServletRequest request, HttpServletResponse response) {
		return statusMasterService.loadTelecallingStatus();
    }
	
	@RequestMapping(value = "/loadTelecallingType", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadTelecallingType( HttpServletRequest request, HttpServletResponse response) {
		return statusMasterService.loadTelecallingType();
    }
	
	@RequestMapping(value = "/loadTelecallingStatusByType", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean loadTelecallingStatusByType(@RequestParam(value="type") String type, HttpServletRequest request, HttpServletResponse response) {
    	return statusMasterService.loadTelecallingStatusByType(type);
    }
	
	@RequestMapping(value = "/loadTelecallingStatusByTeliType", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean loadTelecallingStatusByTeliType(@RequestParam(value="type") String type, HttpServletRequest request, HttpServletResponse response) {
    	return statusMasterService.loadTelecallingStatusByTeliType(type);
    }
	
	
}
