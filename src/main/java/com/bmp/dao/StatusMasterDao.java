package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.status.StatusMaster;

public interface StatusMasterDao extends MongoBaseDao<StatusMaster> {
	StatusMaster getEntityByLocationKey(String key) throws Exception;
}
