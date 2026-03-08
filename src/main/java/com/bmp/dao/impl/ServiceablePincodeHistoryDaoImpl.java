package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ServiceablePincodeHistoryDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.ServiceablePincodeHistory;

@Repository
@Qualifier("serviceablePincodeHistoryDaoImpl")
public class ServiceablePincodeHistoryDaoImpl extends MongoBaseDaoImpl<ServiceablePincodeHistory> implements
		ServiceablePincodeHistoryDao {

}
