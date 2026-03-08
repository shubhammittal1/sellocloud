package com.bmp.dao.wms;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.Supplier;

import java.util.Map;

public interface SupplierDao extends MongoBaseDao<Supplier> {
    Map<String, String> findDistinctSupplier();
    Map<String, String> findSupplierByClient(String key);
}
