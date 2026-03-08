package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RateZoneTypeDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.RateZoneType;

@Repository
@Qualifier("rateZoneTypeDaoImpl")
public class RateZoneTypeDaoImpl extends MongoBaseDaoImpl<RateZoneType> implements RateZoneTypeDao{

}
