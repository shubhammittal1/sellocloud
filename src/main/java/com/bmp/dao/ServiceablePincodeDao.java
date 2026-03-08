package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.masters.ServiceablePincode;

public interface ServiceablePincodeDao extends MongoBaseDao<ServiceablePincode> {

	List<String> pincodeByBranchName(String branchKey) throws Exception;
	List<String> getPincodeZone(String courierKey, String zoneFieldName) throws Exception;
	
}
