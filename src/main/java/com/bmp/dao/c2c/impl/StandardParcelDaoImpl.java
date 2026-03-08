package com.bmp.dao.c2c.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.c2c.StandardParcelDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.c2c.StandardParcel;

@Repository
@Qualifier("standardParcelDaoImpl")
public class StandardParcelDaoImpl extends MongoBaseDaoImpl<StandardParcel> implements StandardParcelDao {

}
