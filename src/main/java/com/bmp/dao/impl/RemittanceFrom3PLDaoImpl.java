package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RemittanceFrom3PLDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.RemittanceFrom3PL;

@Repository
@Qualifier("remittanceFrom3PLDaoImpl") 
public class RemittanceFrom3PLDaoImpl extends MongoBaseDaoImpl<RemittanceFrom3PL> implements RemittanceFrom3PLDao{

}
