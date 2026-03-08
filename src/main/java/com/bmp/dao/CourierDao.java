package com.bmp.dao;

import java.util.Map;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.courier.Courier;

public interface CourierDao extends MongoBaseDao<Courier>{
	Courier getEntityByLocationKey(String key) throws Exception;
	Map<String,String> findDistinctParentKeys();
	String getCourierNameByKey(String key);
}
