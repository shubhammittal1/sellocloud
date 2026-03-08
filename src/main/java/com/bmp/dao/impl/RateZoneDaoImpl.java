package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RateZoneDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.RateZone;

@Repository
@Qualifier("rateZoneDaoImpl")
public class RateZoneDaoImpl extends MongoBaseDaoImpl<RateZone>
		implements RateZoneDao{

}
