package com.bmp.dao.wms;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.Catalogue;

import java.util.List;
import java.util.Map;

public interface CatalogueDao extends MongoBaseDao<Catalogue>{
    boolean findBySkuCode(String productSku,String clientKey);
    Catalogue getCatalogueBySkuCode(String productSku);
    String getSkuCodeByBarCode(String barCode);
    List<Catalogue> getCatalogueByClient(String client);
    List<Catalogue> getCatalogueData(Map<String, Object> fiterMap);
    Integer getCatalogRecordsCount();
    Map<String,Integer> getAllSkuWithQty();
}
