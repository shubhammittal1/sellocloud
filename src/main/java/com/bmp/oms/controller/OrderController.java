package com.bmp.oms.controller;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.BusinessType;
import com.bmp.constant.OrderSource;
import com.bmp.model.app.wms.Order;
import com.bmp.model.app.wms.OrderPackaging;
import com.bmp.model.app.wms.ProductSkus;
import com.bmp.model.app.wms.PurchaseOrder;
import com.bmp.oms.service.saleorder.ConsumerService;
import com.bmp.oms.service.wms.OrderService;
import com.bmp.oms.service.wms.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Qualifier("purchaseOrderServiceImpl")
    private PurchaseOrderService purchaseOrderService;
    
    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;
    
    @Autowired
    @Qualifier("consumerServiceImpl")
    private ConsumerService consumerService;
    
    

    @RequestMapping(value = "/createPurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }

    @RequestMapping(value = "/updatePurchaseOrder", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseBean updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.updatePurchaseOrder(purchaseOrder);
    }

    @RequestMapping(value = "/deletePurchaseOrder/{key}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseBean deletePurchaseOrder(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.deletePurchaseOrder(key);
    }

    @RequestMapping(value = "/getAllPurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllPurchaseOrder(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.getAllPurchaseOrder(datatableRequestBean);
    }
   @RequestMapping(value = "/getProductListById", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getProductListById(@RequestBody String key, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.getProductListById(key);
    }

    @RequestMapping(value = "/getPurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getPurchaseOrder(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.getPurchaseOrder(datatableRequestBean);
    }

    @RequestMapping(value = "/approvePurchaseOrder/{key}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseBean approvePurchaseOrder(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.approvePurchaseOrder(key);
    }

    @RequestMapping(value = "/getPurchaseOrderCount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getPurchaseOrderCount( HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.getPurchaseOrderStatusCount();
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getData( HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.getData();
    }

    @RequestMapping(value = "/getPdfData/{key}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getPdfData( @PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.getPdfData(key);
    }
    @RequestMapping(value = "/getCatalogueDataBySku", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getCatalogueDataBySku(@RequestParam String key, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.getCatalogueDataBySku(key);
    }

    @RequestMapping(value = "/generate-product-sheet", method = RequestMethod.GET)
    @ResponseBody
    public void generateProductSheet(@RequestParam String clientKey, HttpServletRequest request, HttpServletResponse response) throws IOException {
        purchaseOrderService.generatePurchaseOrderSheet(response,clientKey);
    }

    @RequestMapping(value = "/generateProductsTable1", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean generateProductsTable1(@RequestBody List<ProductSkus> productSkus, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.createFullTable(productSkus);
    }

    @RequestMapping(value = "/generateProductsTable", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean generateProductsTable(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        return purchaseOrderService.genPdtsTableFromFile(file);
    }
    
    @RequestMapping(value = "/getAllOrder", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllOrder(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return orderService.getAllOrder(datatableRequestBean);
    }
    @RequestMapping(value = "/getAllPackedOrder", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllPackedOrder(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return orderService.getAllPackedOrder(datatableRequestBean);
    }
    @RequestMapping(value = "/getAllRTOPackedOrder", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllRTOPackedOrder(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return orderService.getAllRTOPackedOrder(datatableRequestBean);
    }
    @RequestMapping(value = "/getOrderStatusCount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getOrderStatusCount( HttpServletRequest request, HttpServletResponse response) {
        return orderService.getOrderStatusCount();
    }
    @RequestMapping(value = "/getRTOPackageStatusCount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getRTOPackageStatusCount( HttpServletRequest request, HttpServletResponse response) {
        return orderService.getRTOPackageStatusCount();
    }
    
    @RequestMapping(value = "/confirmOrder/{key}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseBean confirmOrder(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
        return orderService.confirmOrder(key);
    }
    @RequestMapping(value = "/markDelivered/{key}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseBean markDelivered(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
        return orderService.markDelivered(key);
    }
    @RequestMapping(value = "/markRTO/{key}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseBean markRTO(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
        return orderService.markRTO(key);
    }
    @RequestMapping(value = "/createSingleOrder", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean createSingleOrder(@RequestBody Order order, HttpServletRequest request, HttpServletResponse response) {
		return orderService.createSingleOrder(order);
	}
    
    @RequestMapping(value = "/cancelOrder/{key}", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean cancelOrder(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return orderService.cancelOrder(key);
    }

    @RequestMapping(value = "/generatePOSlip", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean generatePOSlip(@RequestBody PurchaseOrder purchaseOrder, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return purchaseOrderService.generatePOSlip(request,purchaseOrder);
    }

    @RequestMapping(value = "/getOrderSkuListByOrderId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getOrderSkuListByOrderId(@RequestParam(value = "orderKey") String orderKey, HttpServletRequest request, HttpServletResponse response) {
		return orderService.getOrderSkuListByOrderId(orderKey);
	}


    @RequestMapping(value = "/getOrderPackageSkuListById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getOrderPackageSkuListById(@RequestParam(value = "orderPackageKey") String orderPackageKey, HttpServletRequest request, HttpServletResponse response) {
		return orderService.getOrderPackageSkuListById(orderPackageKey);
	}

    @RequestMapping(value = "/createOrderPackaging", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean createOrderPackaging(@RequestBody OrderPackaging orderPackaging, HttpServletRequest request, HttpServletResponse response) {
		return orderService.createOrderPackaging(orderPackaging);
	}
    @RequestMapping(value = "/receriveRTO", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean receriveRTO(@RequestBody OrderPackaging orderPackaging, HttpServletRequest request, HttpServletResponse response) {
		return orderService.receriveRTO(orderPackaging);
	}

    @RequestMapping(value = "/generateInvoice", method = RequestMethod.GET)
    public void generateInvoice(@RequestParam(value = "key") String key, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;filename=\""+ key +".pdf\"");
        orderService.generateInvoice(key,response,request);
    }
    @RequestMapping(value = "/dispatchOrder", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean dispatchOrder(@RequestParam(value = "key") String key, @RequestParam(value = "courierKey") String courierKey,@RequestParam(value = "courierAwb") String courierAwb, 
			@RequestParam(value = "coloaderKey") String coloaderKey, @RequestParam(value = "coloaderVehicleNo") String coloaderVehicleNo,@RequestParam(value = "eWayBill") String eWayBill
			,@RequestParam(value = "businessType") BusinessType businessType,HttpServletRequest request,HttpServletResponse response) {
		return orderService.dispatchOrder(key,courierKey,courierAwb,coloaderKey,coloaderVehicleNo,eWayBill,businessType);
	}
    @RequestMapping(value = "/getAllOrderPackagingByOiderId/{key}/{statusKey}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getAllOrderPackagingByOiderId(@PathVariable("key") String key,@PathVariable("statusKey") String statusKey, HttpServletRequest request, HttpServletResponse response) {
        return orderService.getAllOrderPackagingByOiderId(key,statusKey);
    }
    
    @RequestMapping(value = "/changeOrderWarehouse", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean changeOrderWarehouse(@RequestParam(value = "orderKey") String orderKey, @RequestParam(value = "warehouseKey") String warehouseKey, HttpServletRequest request, HttpServletResponse response) {
		return orderService.changeOrderWarehouse(orderKey, warehouseKey);
	}
    @RequestMapping(value = "/searchConsumerName", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean searchConsumerName (@RequestParam(value = "clientKey") String clientKey, @RequestParam(value = "input") String input) {
		return consumerService.searchConsumerName(clientKey,input);
    }
    
    @RequestMapping(value = "/getQCReason", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getQCReason( HttpServletRequest request, HttpServletResponse response) {
        return orderService.getQCReason();
    }
    @RequestMapping(value = "/getOrderSkuData", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getOrderSkuData(@RequestBody List<String> data, HttpServletRequest request, HttpServletResponse response) {
        return orderService.getOrderSku(data);
    }
    @RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseBean updateOrder(@RequestBody Order order, HttpServletRequest request, HttpServletResponse response) {
            return orderService.createSingleOrder(order);
    }
    @RequestMapping(value = "/uploadOrderFiles", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean saveOrderFiles(MultipartHttpServletRequest request, HttpServletResponse response) {
        try {
            return orderService.saveFilesInDirectory(request);
        }catch (Exception e){
            e.printStackTrace();
            ResponseBean responseBean = new ResponseBean();
            responseBean.setStatus(com.bmp.constant.ResponseStatus.FAIL);
            responseBean.setMessage("Something went wrong");
            return responseBean;
        }
    }

    @RequestMapping(value = "/downloadFiles", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFiles(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) {
        try {
            orderService.downloadFilesWithRandomNames(id,request,response);
        }catch (Exception e){
            e.printStackTrace();
            ResponseBean responseBean = new ResponseBean();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/podStatus", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean podStatus(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) {
        return orderService.podStatus(id);
    }
    @RequestMapping(value = "/sellocloudStatus", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean sellocloudStatus(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) {
        return orderService.sellocloudStatus(id);
    }
}
