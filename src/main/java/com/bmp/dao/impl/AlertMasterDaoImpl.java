package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.AlertMasterDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.config.MongoBaseDaoImplWithModifiedKey;
import com.bmp.model.app.utility.AlertMaster;

@Repository
@Qualifier("alertMasterDaoImpl")
public class AlertMasterDaoImpl extends MongoBaseDaoImpl<AlertMaster> implements AlertMasterDao {

}
