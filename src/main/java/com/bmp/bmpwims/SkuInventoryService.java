package com.bmp.bmpwims;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.model.app.wms.SkuInventory;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface SkuInventoryService {
	public ResponseBean updateSkuInventory();
	DatatableResponseBean getAllSkuInventory(DatatableRequestBean datatableRequestBean);
	DatatableResponseBean getSkuInventoryTableByClientAndWarehouseKey(DatatableRequestBean datatableRequestBean);
	ResponseBean getAllUniqueSkuRecords();
	ResponseBean getInventoryByWarehouseAndClientKey(String warehouseKey,String clientKey);
	ResponseBean filtInventoryByWarehouseAndClientKey(Map<String, Object> filterMap);
	ResponseBean filtInventoryByClientKey(Map<String, Object> filterMap);
	ResponseBean getSkuInventoryById(String Id);
	ResponseBean addQuntity(SkuInventory skunInventory);
	void generateInventoryReport(HttpServletResponse response, String clientKey, String warehouseKey);
}
