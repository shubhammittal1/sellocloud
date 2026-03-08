package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CourierPriorityDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.CourierPriority;

@Repository
@Qualifier("courierPriorityDaoImpl")
public class CourierPriorityDaoImpl extends MongoBaseDaoImpl<CourierPriority> implements CourierPriorityDao {

	@Override
	@Cacheable(value="courierPrioritys")
	public CourierPriority getEntityByLocationKey(String key) throws Exception {
		return getObjectById(key, CourierPriority.class);
	}
	
}