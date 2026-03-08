package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.saleorder.PickupSheet;

public interface PickupSheetDao extends MongoBaseDao<PickupSheet>{

	List<PickupSheet> getIntransitPickupSheetListByBranch(String branchKey, String statusKey) throws Exception;
	List<PickupSheet> getPickupSheetListByUserId(String userId,String statusId) throws Exception;
}
