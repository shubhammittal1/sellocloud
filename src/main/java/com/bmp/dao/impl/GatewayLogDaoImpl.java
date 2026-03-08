package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.GatewayLogDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.GatewayLog;

@Repository
@Qualifier("gatewayLogDaoImpl")
public class GatewayLogDaoImpl extends MongoBaseDaoImpl<GatewayLog> implements GatewayLogDao {

}
