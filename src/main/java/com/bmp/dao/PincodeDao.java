package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.masters.Pincode;

public interface PincodeDao extends MongoBaseDao<Pincode>{
	List<Pincode> getAllSourceCityByPincode (String city) throws Exception;
	String cityKeyByPincode(String pincode);
}