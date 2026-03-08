package com.bmp.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BagDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.bag.Bag;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.solr.common.SOLRSearchDTO;

@Repository
@Qualifier("bagDaoImpl")
public class BagDaoImpl extends MongoBaseDaoImpl<Bag> implements BagDao{


	@Override
	public Bag getBag(String bagSealNo) throws Exception {
		//solrSearchDTO.setQueryString("bagSealNo_s:"+bagSealNo);
	   // List<Bag> bags = getEntityByLocationKey(searchDao.getKeys(solrSearchDTO, Bag.class), Bag.class);
		Query query = new Query();
		query.addCriteria(Criteria.where("bagSealNo_s").is(bagSealNo));
		List<Bag> bags = getObjectByQuery(query, Bag.class);
	    if(bags == null || bags.size() < 0){
	    	return null;
	    }
	    Bag bag1 = null;
		for(Bag bag : bags){
			 bag1 = bag;
		}
		return bag1;
	}
	
	@Override
	public List<Bag> getBagList(String key) throws Exception {
		List<String>  list = Arrays.asList(key.split(","));
		//solrSearchDTO.setQueryString("bagSealNo_s:"+getBagOrQueryFromList (list));
		Query query = new Query();
	    List<Bag> bags = getObjectByQuery(query.addCriteria(Criteria.where("bagSealNo_s").is(list)), Bag.class);
		return bags;
	}
	
	private String getBagOrQueryFromList (List<String> strings) {
		if (strings == null || strings.size() == 0) {
			return null;
		}
		String query = strings.get(0);
		for (int i=1; i < strings.size() ; i++) {
			query = query +" OR "+ strings.get(i);
		}
		return query;
	}
}
