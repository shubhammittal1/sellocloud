package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.StateDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.State;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("stateDaoImpl")
public class StateDaoImpl extends MongoBaseDaoImpl<State> implements StateDao {
	
	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Override
	public List<State> getAllStateFromCountry (String country) throws Exception {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("country._id").is(country));
		query.with(Sort.by(Sort.Direction.ASC, "_id"));
		
		List<State> states = getObjectByQuery(query, State.class);
		
		return states;
	}
	
}