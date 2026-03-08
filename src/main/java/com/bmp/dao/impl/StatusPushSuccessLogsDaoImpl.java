package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.StatusPushSuccessLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.StatusPushSuccessLogs;

@Repository
@Qualifier("statusPushSuccessLogsDaoImpl")
public class StatusPushSuccessLogsDaoImpl extends MongoBaseDaoImpl<StatusPushSuccessLogs> implements StatusPushSuccessLogsDao {

}
