package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RateZoneNewDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.RateZoneNew;

@Repository
@Qualifier("rateZoneNewDaoImpl")
public class RateZoneNewDaoImpl extends MongoBaseDaoImpl<RateZoneNew> implements RateZoneNewDao{
	@Override
	public List<RateZoneNew> getRateZoneNew(String rateZoneTypeKey) {
		Query query = new Query();
		query.addCriteria(Criteria.where("rateZoneTypeKey").is(rateZoneTypeKey));
		
		return getObjectByQuery(query, RateZoneNew.class);
	}

}
