package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.masters.RateZoneNew;

public interface RateZoneNewDao extends MongoBaseDao<RateZoneNew>{
	List<RateZoneNew> getRateZoneNew(String rateZoneTypeKey);

}
