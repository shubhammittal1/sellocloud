package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientCourierDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.ClientCourier;

@Repository
@Qualifier("clientCourierDaoImpl")
public class ClientCourierDaoImpl extends MongoBaseDaoImpl<ClientCourier> implements ClientCourierDao {

}
