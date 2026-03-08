package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.courier.CourierPriority;

public interface CourierPriorityDao extends MongoBaseDao<CourierPriority> {
	public CourierPriority getEntityByLocationKey(String key) throws Exception;
}
