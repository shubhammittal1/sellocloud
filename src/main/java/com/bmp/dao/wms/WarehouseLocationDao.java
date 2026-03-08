package com.bmp.dao.wms;

import com.bmp.constant.LocationType;

import com.bmp.constant.VirtualLocation;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.WarehouseLocationMaster;

import java.util.List;

public interface WarehouseLocationDao extends MongoBaseDao<WarehouseLocationMaster> {
	WarehouseLocationMaster getWarehouseLocation(String clientKey, String warehouseKey, String locationCode);
	WarehouseLocationMaster getWarehouseVirtualLocation(String clientKey, String warehouseKey, VirtualLocation locationCode)throws Exception ;
	List<String> getWHLocationKeyListByCKAndWHKeyAndLocationType(String clientKey,String warehouseKey,String Locationtype);
	String getNameByLocationKey(String Key);
	List<WarehouseLocationMaster> getWhLocByKey(String key1, String key2, String locType);
    WarehouseLocationMaster getWarehouseVirtualLocByType(String clientKey, String warehouseKey, VirtualLocation locationCode,LocationType locationType)throws Exception ;
    List<String> getWarehouseLocationByKeyAndType(String clientKey, String warehouseKey,String type, String isVirtualLocation)throws Exception;
    List<WarehouseLocationMaster> getWHLocationByCLKeyAndWHKey(String clientKey, String warehouseKey)throws Exception;
}
