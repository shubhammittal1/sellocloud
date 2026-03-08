package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.AlertErrorLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.AlertErrorLogs;

@Repository
@Qualifier("alertErrorLogsDaoImpl")
public class AlertErrorLogsDaoImpl extends MongoBaseDaoImpl<AlertErrorLogs> implements AlertErrorLogsDao {

}
