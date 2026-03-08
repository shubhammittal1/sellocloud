package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.masters.Country;

public interface CountryDao extends MongoBaseDao<Country> {
	Country getCountryByName(String Name);
}
