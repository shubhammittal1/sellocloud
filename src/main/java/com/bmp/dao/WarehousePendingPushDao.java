package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.api.WarehousePendingPush;

public interface WarehousePendingPushDao extends MongoBaseDao<WarehousePendingPush>{
	public WarehousePendingPush getWarehousePendingPushByWarehouseKey(String warehouseKey);
}
