package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.masters.State;

public interface StateDao extends MongoBaseDao<State> {
	List<State> getAllStateFromCountry (String country) throws Exception; 
}
