package com.bmp.dao.wms;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.StockTransferNote;

public interface StockTransferNoteDao extends MongoBaseDao<StockTransferNote>{
    Integer getTotalQuantityByKey(String key,String clientKey,String warehouseKey,String skuCode,String locationType);
}
