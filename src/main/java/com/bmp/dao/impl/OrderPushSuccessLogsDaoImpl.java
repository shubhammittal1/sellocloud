package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.OrderPushSuccessLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.OrderPushSuccessLogs;

@Repository
@Qualifier("orderPushSuccessLogsDaoImpl")
public class OrderPushSuccessLogsDaoImpl extends MongoBaseDaoImpl<OrderPushSuccessLogs> implements OrderPushSuccessLogsDao {

}
