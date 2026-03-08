package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.client.ClientWarehouse;

public interface ClientWarehouseDao extends MongoBaseDao<ClientWarehouse> {
	public List<ClientWarehouse> getAllWarehouseListByClient (String key) throws Exception;
	public List<ClientWarehouse> getClientByWareHouseNameAndClient(String wareHouseName, String clientKey);
	public List<ClientWarehouse> getClientByPincodeAndClient(String pincode, String clientKey);
	public List<String> getAllClients();
}
