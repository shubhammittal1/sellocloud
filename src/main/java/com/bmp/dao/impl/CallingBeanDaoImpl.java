package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CallingBeanDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.systemCalling.CallingBean;

@Repository
@Qualifier("callingBeanDaoImpl")
public class CallingBeanDaoImpl extends MongoBaseDaoImpl<CallingBean>  implements CallingBeanDao{

}
