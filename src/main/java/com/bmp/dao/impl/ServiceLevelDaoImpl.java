package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ServiceLevelDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.ServiceLevel;

@Repository
@Qualifier("serviceLevelDaoImpl")
public class ServiceLevelDaoImpl extends MongoBaseDaoImpl<ServiceLevel> implements ServiceLevelDao{

}
