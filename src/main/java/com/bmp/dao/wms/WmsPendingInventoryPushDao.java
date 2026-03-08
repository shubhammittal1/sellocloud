package com.bmp.dao.wms;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.WmsPendingInventoryPush;

public interface WmsPendingInventoryPushDao extends MongoBaseDao<WmsPendingInventoryPush>{
	WmsPendingInventoryPush getPendingInventoryByInvkeySkuCodeClKeyAndMRtKey(String inventorykey,String skuCode,String clientKey, String marketplaceKey);
}
