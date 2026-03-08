package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.StatusPushErrorLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.StatusPushErrorLogs;

@Repository
@Qualifier("statusPushErrorLogsDaoImpl")
public class StatusPushErrorLogsDaoImpl extends MongoBaseDaoImpl<StatusPushErrorLogs> implements StatusPushErrorLogsDao {

}
