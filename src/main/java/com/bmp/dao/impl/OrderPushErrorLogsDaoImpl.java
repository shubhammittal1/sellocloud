package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.OrderPushErrorLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.OrderPushErrorLogs;

@Repository
@Qualifier("orderPushErrorLogsDaoImpl")
public class OrderPushErrorLogsDaoImpl extends MongoBaseDaoImpl<OrderPushErrorLogs> implements OrderPushErrorLogsDao {

}
