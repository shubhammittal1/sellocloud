package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PincodeGroupDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.PincodeGroup;

@Repository
@Qualifier("pincodeGroupDaoImpl")
public class PincodeGroupDaoImpl extends MongoBaseDaoImpl<PincodeGroup> implements PincodeGroupDao{

	@Override
	@Cacheable(value="pincodeGroups")
	public PincodeGroup getEntityByLocationKey(String key) throws Exception {
		return getObjectById(key, PincodeGroup.class);
	}
	
}
