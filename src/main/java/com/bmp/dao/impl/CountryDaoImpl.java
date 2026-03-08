package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CountryDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.Country;

@Repository
@Qualifier("countryDaoImpl")
public class CountryDaoImpl extends MongoBaseDaoImpl<Country> implements CountryDao{
	@Override
	public Country getCountryByName(String Name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("countryName_s").is(Name));
		List<Country> list = getObjectByQuery(query, Country.class);
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}
}
