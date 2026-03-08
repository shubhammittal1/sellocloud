package com.bmp.oms.controller;

import com.bmp.bean.c2c.PutAwayBean;
import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bmpwims.SkuInventoryService;
import com.bmp.constant.LocationType;
import com.bmp.model.app.wms.WarehouseLocationMaster;
import com.bmp.oms.service.wms.PutAwayService;
import com.bmp.oms.service.wms.WarehouseLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/warehouseLocation")
public class WarehouseLocationController {

    @Autowired
    @Qualifier("warehouseLocationServiceImpl")
    private WarehouseLocationService warehouseLocationService;

    @Autowired
    @Qualifier("putAwayServiceImpl")
    private PutAwayService putAwayService;

    @Autowired
    @Qualifier("skuInventoryServiceImpl")
    private SkuInventoryService skuInventoryService;

    @RequestMapping(value = "/getAllWarehouseLocation", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllWarehouseLocation(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return warehouseLocationService.getAllWarehouseLocation(datatableRequestBean);
    }

    @RequestMapping(value = "/checkWHLCodeAvailable", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean checkWHLCodeAvailable(@RequestParam( value = "locationCode", defaultValue = "false") String locationCode, HttpServletRequest request, HttpServletResponse response) {
        return warehouseLocationService.checkWHLCodeAvailable(locationCode);
    }

    @RequestMapping(value = "/createWarehouseLocation", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean createWarehouseLocation(@RequestBody WarehouseLocationMaster warehouseLocation, HttpServletRequest request, HttpServletResponse response) {
        return warehouseLocationService.createWarehouseLocation(warehouseLocation);
    }

    @RequestMapping(value = "/updateWarehouseLocation", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseBean updateWarehouseLocation(@RequestBody WarehouseLocationMaster warehouseLocation, HttpServletRequest request, HttpServletResponse response) {
        return warehouseLocationService.updateWarehouseLocation(warehouseLocation);
    }

    @RequestMapping(value = "/deleteWarehouseLocation", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseBean deleteWarehouseLocation(@RequestParam (value= "warehouseCode")String warehouseKey, HttpServletRequest request, HttpServletResponse response) {
        return warehouseLocationService.deleteWarehouseLocation(warehouseKey);
    }

	
	 @RequestMapping(value = "/createPutAway", method = RequestMethod.POST)
	 @ResponseBody 
	 public ResponseBean createPutAway(@RequestBody PutAwayBean putAwayBean,HttpServletRequest request, HttpServletResponse response) {
	 return putAwayService.createPutAway(putAwayBean); 
	 }
	 

    @RequestMapping(value = "/getAllWarehouseLocationByKey", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getAllWarehouseLocationByKey(@RequestParam(value = "clientKey") String clientKey, @RequestParam(value="warehouseKey") String warehouseKey,@RequestParam(value="locationType") String locationType, HttpServletRequest request, HttpServletResponse response) {
        return warehouseLocationService.getAllWarehouseLocationByKey(clientKey,warehouseKey,locationType);
    }
    @RequestMapping(value = "/getWHLocationByCLKeyAndWHKey", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getWHLocationByCLKeyAndWHKey(@RequestParam(value = "clientKey") String clientKey, @RequestParam(value="warehouseKey") String warehouseKey,HttpServletRequest request, HttpServletResponse response) {
        return warehouseLocationService.getWHLocationByCLKeyAndWHKey(clientKey,warehouseKey);
    }

    @RequestMapping(value = "/generateInventoryReport",produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", method = RequestMethod.GET)
    @ResponseBody
    public void generateInventoryReport(@RequestParam(value = "clientKey") String clientKey,@RequestParam(value="warehouseKey") String warehouseKey, HttpServletRequest request, HttpServletResponse response) {
        skuInventoryService.generateInventoryReport(response,clientKey,warehouseKey);
    }
}
