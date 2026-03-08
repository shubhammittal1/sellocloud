package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.bmp.dao.StatusMasterDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.status.StatusMaster;

@Repository
@Qualifier("statusMasterDaoImpl")
public class StatusMasterDaoImpl extends MongoBaseDaoImpl<StatusMaster> implements StatusMasterDao {

	@Override
	@Cacheable(value="status")
	public StatusMaster getEntityByLocationKey(String key) throws Exception {
		return getObjectById(key, StatusMaster.class);
	}
	
	
}