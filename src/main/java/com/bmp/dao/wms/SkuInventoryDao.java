package com.bmp.dao.wms;

import com.bmp.bean.ProductSearchResponseBean;
import com.bmp.constant.LocationType;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.SkuInventory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SkuInventoryDao extends MongoBaseDao<SkuInventory> {
    Set<String> findDistinctSkuNames();
    Set<String> findDistinctWarehouseKey();
    List<SkuInventory> findSkuInventoryByWarehouseAndClientKey(String warehouseKey,String clientKey);
    List<ProductSearchResponseBean> filtInvByWarehouseAndClientKey(Map<String, Object> filterMap);
    List<ProductSearchResponseBean> filtInvByClientKey(Map<String, Object> filterMap);
    SkuInventory getSkuInventory(String clientKey,String warehouseKey,String locationKey, String skuCode);
    SkuInventory getSkuInventory1(String clientKey, String warehouseKey, String locationKey, String skuCode);
    List<SkuInventory> getSkuInventoryByClientKeyAndWhKeyAndSkuCode(String clientKey,String warehouseKey,String skuCode,LocationType locationType);
    List<SkuInventory> findByWarehouseAndClientKey(String warehouseKey,String clientKey);
    List<Map<String, Object>> getInvByClientKeyAndSkuCode(String clientKey,String skuCode);
    Map<String,Integer> getSkuQuntityByClientKeyAndSkuCode(String clientKey,List<String> skuCode);
    List<SkuInventory> findBySkuCode(String key);
    Integer getStockBySkuAndWarehouse(String skuCode, String warehouseKey);
    List<Map<String,Object>> getAllSkuInventory(Integer skip , String searchValue);
    Integer getAllSkuInventoryCount();
}
