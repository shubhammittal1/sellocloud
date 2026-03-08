package com.bmp.dao.c2c.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.c2c.C2cPricingDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.c2c.C2cPricing;

@Repository
@Qualifier("c2cPricingDaoImpl")
public class C2cPricingDaoImpl extends MongoBaseDaoImpl<C2cPricing> implements C2cPricingDao {

}
