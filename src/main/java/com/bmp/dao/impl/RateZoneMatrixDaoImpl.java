package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RateZoneMatrixDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.RateZoneMatrix;

@Repository
@Qualifier("rateZoneMatrixDaoImpl")
public class RateZoneMatrixDaoImpl extends MongoBaseDaoImpl<RateZoneMatrix> implements RateZoneMatrixDao{

}
