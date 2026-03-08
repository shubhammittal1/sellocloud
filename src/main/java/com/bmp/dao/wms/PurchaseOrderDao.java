package com.bmp.dao.wms;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.PurchaseOrder;

public interface PurchaseOrderDao extends MongoBaseDao<PurchaseOrder> {
	List<PurchaseOrder> getPoByClienyKeyAndWarehouseKey(String clientKey,String warehouseKey);
}
