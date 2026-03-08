package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CashQueryDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.config.MongoBaseDaoImplWithModifiedKey;
import com.bmp.model.app.saleorder.CashQuery;

@Repository
@Qualifier("cashQueryDaoImpl")
public class CashQueryDaoImpl extends MongoBaseDaoImplWithModifiedKey<CashQuery> implements CashQueryDao{

}
