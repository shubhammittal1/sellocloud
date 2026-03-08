package com.bmp.oms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmp.constant.ResponseStatus;
import com.bmp.model.app.client.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
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
import com.bmp.model.app.wms.Catalogue;
import com.bmp.model.app.wms.Category;
import com.bmp.model.app.wms.MarketPlaceSkuMapping;
import com.bmp.model.app.wms.StockTransferNote;
import com.bmp.oms.service.wms.CatalogueService;
import com.bmp.oms.service.wms.CategoryService;
import com.bmp.oms.service.wms.MarketplaceSkuMappingService;
import com.bmp.oms.service.wms.StockTransferNoteService;
import com.bmp.oms.service.wms.WmsPendingPushService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/wms")
public class WmsController {

	@Autowired
	@Qualifier("categoryServiceImpl")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("wmsPendingPushServiceImpl")
	private WmsPendingPushService wmsPendingPushService;
	
	@Autowired
	@Qualifier("marketplaceSkuMappingServiceImpl")
	private MarketplaceSkuMappingService marketplaceSkuMappingService;
	
	@Autowired
	@Qualifier("catalogueServiceImpl")
	private CatalogueService catalogueService;
	
	@Autowired
	@Qualifier("stockTransferNoteServiceImpl")
	private StockTransferNoteService stockTransferNoteService;
	
	@RequestMapping(value = "/checkCategoryKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkCategoryKeyAvailable (@PathVariable("key") String key) {
		return categoryService.checkCategorywKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllCategorys", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllCategorys (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return categoryService.getAllCategorys(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createCategory", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createCategory(@RequestBody Category category, HttpServletRequest request, HttpServletResponse response) {
		return categoryService.createCategory(category);
    }
	
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateCategory(@RequestBody Category category, HttpServletRequest request, HttpServletResponse response) {
		return categoryService.updateCategory(category);
    }
	
	@RequestMapping(value = "/deleteCategory/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteCategory(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return categoryService.deleteCategory(key);
    }
	
	
	@RequestMapping(value = "/getAllSkuMApping", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllSkuMApping (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return marketplaceSkuMappingService.getAllSkuMApping(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createSkuMapping", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createSkuMapping(@RequestBody MarketPlaceSkuMapping marketPlaceSkuMapping, HttpServletRequest request, HttpServletResponse response) {
		return marketplaceSkuMappingService.createSkuMapping(marketPlaceSkuMapping);
    }
	
	@RequestMapping(value = "/updateSkuMapping", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateSkuMapping(@RequestBody MarketPlaceSkuMapping marketPlaceSkuMapping, HttpServletRequest request, HttpServletResponse response) {
		return marketplaceSkuMappingService.updateSkuMapping(marketPlaceSkuMapping);
    }
	
	@RequestMapping(value = "/deleteSkuMapping/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteSkuMapping(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return marketplaceSkuMappingService.deleteSkuMapping(key);
    }
	
	
	
	@RequestMapping(value = "/getCategorys", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getCategorys(HttpServletRequest request, HttpServletResponse response) {
		return categoryService.getAllCategory();
    }

	@RequestMapping(value = "/checkCatalogueKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkCatalogueKeyAvailable (@PathVariable("key") String key) {
		return catalogueService.checkCatalogueKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllCatalogues", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllCatalogues (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return catalogueService.getAllCatalogues(datatableRequestBean);
    }
	@RequestMapping(value = "/getAllApprovedCatalogue", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllApprovedCatalogue (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return catalogueService.getAllApprovedCatalogue(datatableRequestBean);
    }

    @RequestMapping(value = "/createCatalogue", method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseBean createCatalogue(MultipartHttpServletRequest request, HttpServletResponse response) {
        return catalogueService.prepareFinalResponse(request,false);
    }


    @RequestMapping(value = "/updateCatalogue", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateCatalogue(MultipartHttpServletRequest request, HttpServletResponse response) {
        try {
            return catalogueService.prepareFinalResponse(request, true);
        }catch (Exception e){
            e.printStackTrace();
            ResponseBean responseBean = new ResponseBean();
            responseBean.setStatus(ResponseStatus.FAIL);
            responseBean.setMessage("Something went wrong");
            return responseBean;
        }
    }
	
	@RequestMapping(value = "/deleteCatalogue/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteCatalogue(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return catalogueService.deleteCatalogue(key);
    }
	@RequestMapping(value = "/approveCatalogue/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean approveCatalogue(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return catalogueService.approveCatalogue(key);
    }
	@RequestMapping(value = "/loadProductMap", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean loadProductMap(@RequestBody Map<String, Object> fiterMap, HttpServletRequest request, HttpServletResponse response) {
		return catalogueService.loadProductMap(fiterMap);
	}

	@RequestMapping(value = "/loadPdtMapByClient/{clientKey}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean loadPdtMapByClient(@PathVariable("clientKey") String clientKey, HttpServletRequest request, HttpServletResponse response) {
		return catalogueService.loadPdtMapByClient( clientKey);
	}
	
	
	@RequestMapping(value = "/getAllStockTransferNote", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllStockTransferNote (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return stockTransferNoteService.getAllStockTransferNote(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createStockTransferNote", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createStockTransferNote(@RequestBody StockTransferNote stockTransferNote, HttpServletRequest request, HttpServletResponse response) {
		return stockTransferNoteService.createStockTransferNote(stockTransferNote);
    }
	
	@RequestMapping(value = "/updateStockTransferNote", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateStockTransferNote(@RequestBody StockTransferNote stockTransferNote, HttpServletRequest request, HttpServletResponse response) {
		return stockTransferNoteService.updateStockTransferNote(stockTransferNote);
    }
	@RequestMapping(value = "/editStockTransferNote", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean editStockTransferNote(@RequestBody StockTransferNote stockTransferNote, HttpServletRequest request, HttpServletResponse response) {
		return stockTransferNoteService.editStockTransferNote(stockTransferNote);
    }
	
	

    /*@RequestMapping(value = "/updateStockTransferNote", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean updateStockTransferNote(@RequestBody Object stockTransferNote, HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new Gson();
        String json = gson.toJson(stockTransferNote);
        StockTransferNote p = gson.fromJson(json, StockTransferNote.class);
        return stockTransferNoteService.updateStockTransferNote(p);
    }*/
	
	@RequestMapping(value = "/deleteStockTransferNote/{key}", method = RequestMethod.DELETE)
	@ResponseBody
    public ResponseBean deleteStockTransferNote(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return stockTransferNoteService.deleteStockTransferNote(key);
    }
	
	@RequestMapping(value = "/getStnProductListById", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getStnProductListById(@RequestBody String key, HttpServletRequest request, HttpServletResponse response) {
        return stockTransferNoteService.getStnProductListById(key);
    }
	
	@RequestMapping(value = "/approveStn/{key}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseBean approveStn(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
        return stockTransferNoteService.approveStn(key);
    }
	@RequestMapping(value = "/getAllClosedStn", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClosedStn (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return stockTransferNoteService.getAllClosedStn(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllSTNForward", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllSTNForward (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return stockTransferNoteService.getAllSTNForward(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getAllWmsPendingInventoryPush", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllWmsPendingInventoryPush(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return wmsPendingPushService.getAllWmsPendingInventoryPush(datatableRequestBean);
	}
	@RequestMapping(value = "/getAllWmsPendingTrackingPush", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllWmsPendingTrackingPush(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return wmsPendingPushService.getAllWmsPendingTrackingPush(datatableRequestBean);
	}
	
	@RequestMapping(value = "/deleteWmsPendingInventoryPush", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean deleteWmsPendingInventoryPush(@RequestBody String awbNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return wmsPendingPushService.deleteWmsPendingInventoryPush(awbNumber);
	}
	
	@RequestMapping(value = "/deleteWmsPendingTrackingPush", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean deleteWmsPendingTrackingPush(@RequestBody String awbNumber, HttpServletRequest request,HttpServletResponse response) throws Exception {
		return wmsPendingPushService.deleteWmsPendingTrackingPush(awbNumber);
	}

	@RequestMapping(value = "/getWarehouseAndSupplierDetails/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getWarehouseAndSupplierDetails(@PathVariable("key") String key ,HttpServletRequest request, HttpServletResponse response) {
		return stockTransferNoteService.getWarehouseAndSupplierDetails(key);
	}
	@RequestMapping(value = "/getAllRecordsCount", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllRecordsCount( HttpServletRequest request, HttpServletResponse response) {
		return catalogueService.getAllRecordsCount();
	}
	
	@RequestMapping(value = "/searchProduct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean searchProduct(@RequestBody Map<String, Object> fiterMap, HttpServletRequest request, HttpServletResponse response) {
		return catalogueService.searchProduct(fiterMap);
	}
/*
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
        return catalogueService.uploadAndCompressFiles(files, request);
    }*/
	

}