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

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.ResponseStatus;
import com.bmp.model.app.masters.AWBSeries;
import com.bmp.model.app.masters.BranchStockRecon;
import com.bmp.model.app.masters.CountryStateCitySearch;
import com.bmp.model.app.masters.PincodeGroup;
import com.bmp.model.app.masters.PincodeGroupZoneMatrix;
import com.bmp.model.app.masters.ProductType;
import com.bmp.model.app.masters.QCCheckList;
import com.bmp.model.app.masters.QCMaster;
import com.bmp.model.app.masters.RateZone;
import com.bmp.model.app.masters.RateZoneMatrix;
import com.bmp.model.app.masters.RateZoneNew;
import com.bmp.model.app.masters.RateZoneType;
import com.bmp.oms.service.masters.AWBSeriesService;
import com.bmp.oms.service.masters.BranchStockReconService;
import com.bmp.oms.service.masters.CityService;
import com.bmp.oms.service.masters.CountryService;
import com.bmp.oms.service.masters.PincodeGroupService;
import com.bmp.oms.service.masters.PincodeGroupZoneMatrixService;
import com.bmp.oms.service.masters.ProductTypeService;
import com.bmp.oms.service.masters.QCCheckListService;
import com.bmp.oms.service.masters.QCMasterService;
import com.bmp.oms.service.masters.RateZoneMatrixService;
import com.bmp.oms.service.masters.RateZoneNewService;
import com.bmp.oms.service.masters.RateZoneService;
import com.bmp.oms.service.masters.RateZoneTypeService;
import com.bmp.oms.service.masters.ServiceablePincodeService;
import com.bmp.oms.service.masters.StateService;

@Controller
@RequestMapping("/masters")
public class MastersController {

	@Autowired
	@Qualifier("rateZoneServiceImpl")
	private RateZoneService rateZoneService;
	
	@Autowired
	@Qualifier("pincodeGroupServiceImpl")
	private PincodeGroupService pincodeGroupService;
	
	@Autowired
	@Qualifier("productTypeServiceImpl")
	private ProductTypeService productTypeService;
	
	@Autowired
	@Qualifier("pincodeGroupZoneMatrixService")
	private PincodeGroupZoneMatrixService pincodeGroupZoneMatrixService;
	
	@Autowired
	@Qualifier("serviceablePincodeServiceImpl")
	private ServiceablePincodeService serviceablePincodeService;
	
	@Autowired
	@Qualifier("awbSeriesServiceImp")
	private AWBSeriesService awbSeriesService;
	
	@Autowired
	@Qualifier("cityServiceImpl")
	private CityService cityService;
	
	@Autowired
	@Qualifier("stateServiceImpl")
	private StateService stateService;
	
	@Autowired
	@Qualifier("countryServiceImpl")
	private CountryService countryService;
	
	@Autowired
	@Qualifier("branchStockReconImpl")
	private BranchStockReconService branchStockReconService;
	
	@Autowired
	@Qualifier("qcMasterServiceImpl")
	private QCMasterService qcMasterService;

	@Autowired
	@Qualifier("qcCheckListServiceImpl")
	private QCCheckListService qcCheckListService;
	
	@Autowired
	@Qualifier("rateZoneNewServiceImpl")
	private RateZoneNewService rateZoneNewService;
	
	@Autowired
	@Qualifier("rateZoneTypeServiceImpl")
	private RateZoneTypeService rateZoneTypeService;
	
	@Autowired
	@Qualifier("rateZoneMatrixServiceImpl")
	private RateZoneMatrixService rateZoneMatrixService;
	
	
	@RequestMapping(value = "/checkRateZoneKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkRateZoneKeyAvailable (@PathVariable("key") String key) {
		return rateZoneService.checkRateZoneKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllRateZones", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllRateZones (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return rateZoneService.getAllRateZones(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createRateZone", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createRateZone(@RequestBody RateZone rateZone, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneService.createRateZone(rateZone);
    }
	
	@RequestMapping(value = "/updateRateZone", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateRateZone(@RequestBody RateZone rateZone, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneService.updateRateZone(rateZone);
    }
	
	@RequestMapping(value = "/deleteRateZone/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteRateZone(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneService.deleteRateZone(key);
    }

	@RequestMapping(value = "/checkPincodeGroupKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkPincodeGroupKeyAvailable (@PathVariable("key") String key) {
		return pincodeGroupService.checkPincodeGroupKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllPincodeGroups", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllPincodeGroups (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return pincodeGroupService.getAllPincodeGroups(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createPincodeGroup", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPincodeGroup(@RequestBody PincodeGroup pincodeGroup, HttpServletRequest request, HttpServletResponse response) {
		return pincodeGroupService.createPincodeGroup(pincodeGroup);
    }
	
	@RequestMapping(value = "/updatePincodeGroup", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updatePincodeGroup(@RequestBody PincodeGroup pincodeGroup, HttpServletRequest request, HttpServletResponse response) {
		return pincodeGroupService.updatePincodeGroup(pincodeGroup);
    }
	
	@RequestMapping(value = "/deletePincodeGroup/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deletePincodeGroup(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return pincodeGroupService.deletePincodeGroup(key);
    }

	@RequestMapping(value = "/checkProductTypeKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkProductTypeKeyAvailable (@PathVariable("key") String key) {
		return productTypeService.checkProductTypeKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllProductTypes", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllProductTypes (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return productTypeService.getAllProductTypes(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createProductType", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createProductType(@RequestBody ProductType productType, HttpServletRequest request, HttpServletResponse response) {
		return productTypeService.createProductType(productType);
    }
	
	@RequestMapping(value = "/updateProductType", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateProductType(@RequestBody ProductType productType, HttpServletRequest request, HttpServletResponse response) {
		return productTypeService.updateProductType(productType);
    }
	
	@RequestMapping(value = "/deleteProductType/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteProductType(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return productTypeService.deleteProductType(key);
    }
	
	@RequestMapping(value = "/getAllPincodeGroupZoneMatrix", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllPincodeGroupZoneMatrix (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return pincodeGroupZoneMatrixService.getAllPincodeGroupZoneMatrix(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createPincodeGroupZoneMatrix", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPincodeGroupZoneMatrix(@RequestBody PincodeGroupZoneMatrix pincodeGroupZoneMatrix, @RequestParam(value="grops") String grops, HttpServletRequest request, HttpServletResponse response) {
		return pincodeGroupZoneMatrixService.createPincodeGroupZoneMatrix(pincodeGroupZoneMatrix, grops);
    }
	
	@RequestMapping(value = "/updatePincodeGroupZoneMatrix", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updatepincodeGroupZoneMatrix(@RequestBody PincodeGroupZoneMatrix pincodeGroupZoneMatrix, @RequestParam(value="grops") String grops, HttpServletRequest request, HttpServletResponse response) {
		return pincodeGroupZoneMatrixService.updatePincodeGroupZoneMatrix(pincodeGroupZoneMatrix, grops);
    }

	@RequestMapping(value = "/deletePincodeGroupZoneMatrix/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deletePincodeGroupZoneMatrix(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return pincodeGroupZoneMatrixService.deletePincodeGroupZoneMatrix(key);
    }
	
	@RequestMapping(value = "/checkPincodeGroupZoneMatrixKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkPincodeGroupZoneMatrixKeyAvailable (@PathVariable("key") String key) {
		return pincodeGroupZoneMatrixService.checkPincodeGroupZoneMatrixKeyAvailable(key);
    }

	@RequestMapping(value = "/loadPincodeGroup", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadPincodeGroup(HttpServletRequest request, HttpServletResponse response) {
		return pincodeGroupService.loadPincodeGroup();
    }

	@RequestMapping(value = "/loadRateZones", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean loadRateZones(HttpServletRequest request,HttpServletResponse response) {
		return rateZoneService.loadRateZones();
	}
	
	@RequestMapping(value = "/loadPincodeGroupZoneMatrix", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean loadPincodeGroupZoneMatrix(HttpServletRequest request,HttpServletResponse response) {
		return pincodeGroupZoneMatrixService.loadPincodeGroupZoneMatrix();
	}

	@RequestMapping(value = "/activatePincode/{activeCourier}/{pincodes}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean activatePincode(@PathVariable("activeCourier") String courier, @PathVariable("pincodes") String pincodes,HttpServletRequest request, HttpServletResponse response) {
		return serviceablePincodeService.activatePincode(courier,pincodes);
    }
	
	@RequestMapping(value = "/deactivatePincode/{deactiveCourier}/{pincodes}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deactivatePincode(@PathVariable("deactiveCourier") String courier, @PathVariable("pincodes") String pincodes,HttpServletRequest request, HttpServletResponse response) {
		return serviceablePincodeService.deactivatePincode(courier,pincodes);
    }
	
	@RequestMapping(value = "/deleteSeries", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean deleteSeries(@RequestBody AWBSeries awbSeries, HttpServletRequest request, HttpServletResponse response) {
		return awbSeriesService.deleteAWBSeries(awbSeries);
    }
	
	@RequestMapping(value = "/searchSeries", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean searchSeries(@RequestBody AWBSeries awbSeries, HttpServletRequest request, HttpServletResponse response) {
		return awbSeriesService.awbSearchList(awbSeries);
    }
	@RequestMapping(value = "/loadCitys/{stateName}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadCitys(@PathVariable("stateName") String stateName, HttpServletRequest request, HttpServletResponse response) {
		return cityService.loadCitys(stateName);
    }
	
	@RequestMapping(value = "/loadStates/{countryName}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadStates(@PathVariable("countryName") String countryName, HttpServletRequest request, HttpServletResponse response) {
		return stateService.loadStates(countryName);
    }
	
	@RequestMapping(value = "/loadCountrys", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadCountrys(HttpServletRequest request, HttpServletResponse response) {
		return countryService.loadCountrys();
    }
	@RequestMapping(value = "/loadCitysState", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadCitysState (@RequestBody CountryStateCitySearch countryStateCitySearch, HttpServletRequest request, HttpServletResponse response) {
		return cityService.loadCitysState (countryStateCitySearch);
    }
	
	@RequestMapping(value = "/generateAWBSeries/{key}", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean generateAWBSeries(@RequestBody AWBSeries awbSeries, @PathVariable("key") int total, HttpServletRequest request, HttpServletResponse response) {
		return awbSeriesService.generateAWBSeries(awbSeries, total,true);
    }
	
	@RequestMapping(value = "/getCountryStateCity/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getCountryStateCity(@PathVariable("key") String pincode, HttpServletRequest request, HttpServletResponse response) {
		return countryService.getCountryStateCity(pincode);
    }
	
	@RequestMapping(value = "/getPincodeByCountryStateCity/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getPincodeByCountryStateCity(@PathVariable("key") String pincode, HttpServletRequest request, HttpServletResponse response) {
		return countryService.getPincodeByCountryStateCity(pincode);
    }
	
	@RequestMapping(value = "/getProductTypes", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getProductTypes (HttpServletRequest request, HttpServletResponse response) {
		return productTypeService.loadProductTypes ();
    }
	
	@RequestMapping(value = "/getConsingCountryStateCity", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getConsingCountryStateCity(@RequestParam(value="key") String pincode, HttpServletRequest request, HttpServletResponse response) {
		return countryService.getConsingCountryStateCity(pincode);
    }
	
	@RequestMapping(value = "/getAllBranchStockRecon", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllBranchStockRecon (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return branchStockReconService.getAllBranchStockRecon(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createBranchStockRecon", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createBranchStockRecon(@RequestBody BranchStockRecon branchStockRecon, HttpServletRequest request, HttpServletResponse response) {
		return branchStockReconService.createBranchStockRecon(branchStockRecon);
    }
	
	@RequestMapping(value = "/scanAwbNoForBranchStockRecon/{branchName}/{awbNo}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean scanAwbNoForBranchStockRecon(@PathVariable("branchName") String branchName, @PathVariable("awbNo") String awbNo, 
    		 HttpServletRequest request, HttpServletResponse response) {
		return branchStockReconService.scanAwbNoForBranchStockRecon(branchName,awbNo);
    }
	
	@RequestMapping(value = "/getBranchStockReconCloseReport", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getBranchStockReconCloseReport (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return branchStockReconService.getBranchStockReconCloseReport(datatableRequestBean);
    }

	@RequestMapping(value = "/closeBranchStockRecon/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean closeBranchStockRecon(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return branchStockReconService.closeBranchStockRecon(key);
    }
	
	@RequestMapping(value = "/getAllQC", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllQC (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return qcMasterService.getAllQC(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createQCMaster", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createQCMaster(@RequestBody QCMaster qcMaster, HttpServletRequest request, HttpServletResponse response) {
		return qcMasterService.createQCMaster(qcMaster);
    }
	
	@RequestMapping(value = "/updateQCMaster", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateQCMaster(@RequestBody QCMaster qcMaster, HttpServletRequest request, HttpServletResponse response) {
		return qcMasterService.updateQCMaster(qcMaster);
    }
	
	@RequestMapping(value = "/deleteQCMaster/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteQCMaster(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return qcMasterService.deleteQCMaster(key);
    }
	
	@RequestMapping(value = "/checkQCMasterKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkQCMasterKeyAvailable (@PathVariable("key") String key) {
		return qcMasterService.checkQCMasterKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllQCCheckList", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllQCCheckList (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return qcCheckListService.getAllQCCheckList(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createQCCheckListMatrix", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createQCCheckListMatrix(@RequestBody QCCheckList qcCheckList, HttpServletRequest request, HttpServletResponse response) {
		return qcCheckListService.createQCCheckListMatrix(qcCheckList);
    }
	
	@RequestMapping(value = "/updateQCCheckListMatrix", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateQCCheckListMatrix(@RequestBody QCCheckList qcCheckList, HttpServletRequest request, HttpServletResponse response) {
		return qcCheckListService.updateQCCheckListMatrix(qcCheckList);
    }
	
	@RequestMapping(value = "/deleteQCCheckListMatrix/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteQCCheckListMatrix(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return qcCheckListService.deleteQCCheckListMatrix(key);
    }
	
	@RequestMapping(value = "/checkQCCheckListMatrixKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkQCCheckListMatrixKeyAvailable (@PathVariable("key") String key) {
		return qcCheckListService.checkQCCheckListMatrixKeyAvailable(key);
    }
	
	@RequestMapping(value = "/loadQCMasterList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadQCMasterList(HttpServletRequest request, HttpServletResponse response) {
		return qcMasterService.loadQCMasterList();
    }
	
	@RequestMapping(value = "/loadQCCheckList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean loadQCCheckList(HttpServletRequest request, HttpServletResponse response) {
		return qcCheckListService.loadQCCheckList();
    }
	
	@RequestMapping(value = "/serviceablepincodeUploadedCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkOrderUploadedCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.SERVICIBLE_PINCODE_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.SERVICIBLE_PINCODE_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.SERVICIBLE_PINCODE_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.SERVICIBLE_PINCODE_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.SERVICIBLE_PINCODE_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.SERVICIBLE_PINCODE_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/transferCourierSeries", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean transferCourierSeries(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> transferCourierSeriesDetails) {
		return awbSeriesService.transferCourierSeries(transferCourierSeriesDetails);
    }
	
	@RequestMapping(value = "/awbSeriesUploadedCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkAwbSeriesUploadedCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.AWBSERIES_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.AWBSERIES_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.AWBSERIES_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.AWBSERIES_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.AWBSERIES_UPLOAD_COUNT_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.AWBSERIES_UPLOAD_COUNT_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/threeplStatusUploadedCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkthreeplStatusUploadedCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.THREE_PL_STATUS_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.THREE_PL_STATUS_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.THREE_PL_STATUS_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.THREE_PL_STATUS_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.THREE_PL_STATUS_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.THREE_PL_STATUS_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/checkClientBillUploadedCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkClientBillUploadedCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.CLIENT_BILL_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.CLIENT_BILL_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.CLIENT_BILL_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.CLIENT_BILL_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.CLIENT_BILL_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.CLIENT_BILL_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/updateDeliveredPersonDetailsCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updateDeliveredPersonDetailsCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.UPDATE_DELIVERED_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.UPDATE_DELIVERED_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.UPDATE_DELIVERED_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.UPDATE_DELIVERED_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.UPDATE_DELIVERED_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.UPDATE_DELIVERED_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	
	@RequestMapping(value = "/reconnectBulkCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean reconnectBulkCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.RECONNECT_BULK_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.RECONNECT_BULK_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.RECONNECT_BULK_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.RECONNECT_BULK_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.RECONNECT_BULK_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.RECONNECT_BULK_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	
	@RequestMapping(value = "/updateCourierAwbCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updateCourierAwbCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.COURIER_AWB_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.COURIER_AWB_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.COURIER_AWB_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.COURIER_AWB_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.COURIER_AWB_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.COURIER_AWB_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/redirectBulkCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean redirectBulkCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.REDIRECT_BULK_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.REDIRECT_BULK_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.REDIRECT_BULK_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.REDIRECT_BULK_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.REDIRECT_BULK_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.REDIRECT_BULK_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/changeSeriesProductTypeBulkCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean changeSeriesProductTypeBulkCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.CHANGE_SERIES_PRODUCT_TYPE_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.CHANGE_SERIES_PRODUCT_TYPE_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.CHANGE_SERIES_PRODUCT_TYPE_BULK_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.CHANGE_SERIES_PRODUCT_TYPE_BULK_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.CHANGE_SERIES_PRODUCT_TYPE_BULK_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.CHANGE_SERIES_PRODUCT_TYPE_BULK_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/clientCodeBulkUploadCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean clientCodeBulkUploadCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.CLIENT_CODE_BULK_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.CLIENT_CODE_BULK_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.CLIENT_CODE_BULK_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.CLIENT_CODE_BULK_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.CLIENT_CODE_BULK_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.CLIENT_CODE_BULK_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/clientProductSkuRateBulkUploadCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean ClientProductSkuRateBulkUploadCount(
			@RequestParam(value = "isFirstCall") boolean isFirstCall,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		if (isFirstCall) {
			request.getSession().setAttribute(
					GlobalConstant.CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_COUNT_FIRST_CALL, true);
		}
		if ((Boolean) request.getSession().getAttribute(
				GlobalConstant.CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_COUNT_FIRST_CALL)) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("File Not Process, Please Wait...");
		} else {
			responseBean.setStatus(ResponseStatus.SUCCESS);
			Map<String, String> map = new HashMap<>();
			map.put(GlobalConstant.CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_CURRENT_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_CURRENT_COUNT));
			map.put(GlobalConstant.CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_TOTAL_COUNT,
					""
							+ request
									.getSession()
									.getAttribute(
											GlobalConstant.CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_TOTAL_COUNT));
			responseBean.setResponse(map);
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/checkRateZoneNewKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkRateZoneNewKeyAvailable (@PathVariable("key") String key) {
		return rateZoneNewService.checkRateZoneNewKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllRateZonesNew", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllRateZonesNew (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return rateZoneNewService.getAllRateZonesNew(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createRateZoneNew", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createRateZoneNew(@RequestBody RateZoneNew rateZone, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneNewService.createRateZoneNew(rateZone);
    }
	
	@RequestMapping(value = "/updateRateZoneNew", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateRateZoneNew(@RequestBody RateZoneNew rateZone, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneNewService.updateRateZoneNew(rateZone);
    }
	
	@RequestMapping(value = "/deleteRateZoneNew/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteRateZoneNew(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneNewService.deleteRateZoneNew(key);
    }
	
	@RequestMapping(value = "/loadStatesCity/{countryName}/{rateType}/{type}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadStatesCity(@PathVariable("countryName") String countryName, @PathVariable("rateType") String rateType, @PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneNewService.loadStatesCity(countryName, rateType,type);
    }
	
	@RequestMapping(value = "/getRateZonesCity/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getRateZonesCity(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneNewService.getRateZonesCity(key);
    }
	
	@RequestMapping(value = "/loadRateZonesNew/{zoneType}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadRateZonesNew(@PathVariable("zoneType") String zoneType, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneNewService.loadRateZonesNew(zoneType);
    }
	
	
	@RequestMapping(value = "/checkRateZoneMatrixKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkRateZoneMatrixKeyAvailable (@PathVariable("key") String key) {
		return rateZoneMatrixService.checkRateZoneMatrixKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllRateZoneMatrix", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllRateZoneMatrix (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return rateZoneMatrixService.getAllRateZoneMatrix(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createRateZoneMatrix", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createRateZoneMatrix(@RequestBody RateZoneMatrix rateZoneMatrix, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneMatrixService.createRateZoneMatrix(rateZoneMatrix);
    }
	
	@RequestMapping(value = "/updateRateZoneMatrix", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateRateZoneMatrix(@RequestBody RateZoneMatrix rateZoneMatrix, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneMatrixService.updateRateZoneMatrix(rateZoneMatrix);
    }
	
	@RequestMapping(value = "/deleteRateZoneMatrix/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteRateZoneMatrix(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneMatrixService.deleteRateZoneMatrix(key);
    }
	
	
	@RequestMapping(value = "/checkRateZoneTypeKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkRateZoneTypeKeyAvailable (@PathVariable("key") String key) {
		return rateZoneTypeService.checkRateZoneTypeKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllRateZonesType", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllRateZonesType (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return rateZoneTypeService.getAllRateZonesType(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createRateZoneType", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createRateZoneType(@RequestBody RateZoneType rateZone, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneTypeService.createRateZoneType(rateZone);
    }
	
	@RequestMapping(value = "/updateRateZoneType", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateRateZoneType(@RequestBody RateZoneType rateZone, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneTypeService.updateRateZoneType(rateZone);
    }
	
	@RequestMapping(value = "/deleteRateZoneType/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteRateZoneType(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return rateZoneTypeService.deleteRateZoneType(key);
    }
	
	@RequestMapping(value = "/loadRateZoneType", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadRateZonesType(HttpServletRequest request, HttpServletResponse response) {
		return rateZoneTypeService.loadRateZoneType();
    }
	@RequestMapping(value = "/getZoneMatrix", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getZoneMatrix(HttpServletRequest request, HttpServletResponse response) {
		return rateZoneMatrixService.getZoneMatrix ();
    }
	
	@RequestMapping(value = "/getClientZoneMatrix", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getClientZoneMatrix(HttpServletRequest request, HttpServletResponse response) {
		return rateZoneMatrixService.getClientZoneMatrix ();
    }
	
	
}