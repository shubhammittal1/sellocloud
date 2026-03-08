package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CityDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.City;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("cityDaoImpl")
public class CityDaoImpl extends MongoBaseDaoImpl<City> implements CityDao {

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Override
	public List<City> getAllCityFromState (String state) throws Exception {
		
		Query query = new Query();
		
		query.addCriteria(Criteria.where("state._id").is(state));
		List<City> cities = getObjectByQuery(query, City.class);
		
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		solrSearchDTO.setQueryString("state.key_s:"+state);
		
		List<String> cityList = searchDao.getKeys(solrSearchDTO, City.class);
		Collections.sort(cityList);
		List<City> cities = getEntityByLocationKey(cityList, City.class);*/
		return cities;
	}
	@Override
	public List<City> getAllCity (String state) throws Exception {
		Query query = new Query();
		query.fields().include("cityCode_s").include("cityName_s")
		.include("state.stateCode_s").include("state.stateName_s");
		
		query.addCriteria(Criteria.where("state._id").is(state));
		List<City> cities = getObjectByQuery(query, City.class);
		return cities;
	}
}
