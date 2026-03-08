package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.AlertSuccessLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.AlertSuccessLogs;

@Repository
@Qualifier("alertSuccessLogsDaoImpl")
public class AlertSuccessLogsDaoImpl extends MongoBaseDaoImpl<AlertSuccessLogs> implements AlertSuccessLogsDao {

}
