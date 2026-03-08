package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.masters.City;

public interface CityDao extends MongoBaseDao<City> {
	List<City> getAllCityFromState (String state) throws Exception;
	List<City> getAllCity (String state) throws Exception;
}
