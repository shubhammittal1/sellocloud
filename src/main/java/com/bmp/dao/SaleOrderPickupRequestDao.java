package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;

public interface SaleOrderPickupRequestDao extends MongoBaseDao<SaleOrderPickupRequest> {
	
	List<SaleOrderPickupRequest> getSaleOrderPickupRequestList(String branchKey, String statusKey) throws Exception;
	List<SaleOrderPickupRequest> getSaleOrderPickupRequestList(String pickupSheepKey) throws Exception;
}
