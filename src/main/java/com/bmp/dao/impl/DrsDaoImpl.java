package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.constant.GlobalConstant;
import com.bmp.dao.DrsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.drs.Drs;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.utility.QueryUtility;

@Repository
@Qualifier("drsDaoImpl")
public class DrsDaoImpl extends MongoBaseDaoImpl<Drs> implements DrsDao{

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Override
	public List<Drs> getDrsByBranchName(String branchKey) throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		String query = "branchKey_s:"+branchKey+" AND currentStatus.key_s:"+GlobalConstant.NEW_DRS;
		solrSearchDTO.setQueryString(query);
		List<String> list  = searchDao.getKeys(solrSearchDTO, Drs.class);*/
		
		Query query = new Query();
		Criteria[] criteriaArr = QueryUtility.orQuery("currentStatus._id", GlobalConstant.NEW_DRS);
		query.addCriteria(Criteria.where("branchKey_s").is(branchKey).orOperator(criteriaArr));
		List<Drs> objList  = getObjectByQuery(query, Drs.class);
		return objList;
	}

	@Override
	public List<Drs> getDrsByUserKey(String userKey, String currentStatus) throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		String query = "deliveryBoyKey_s:"+userKey+" AND currentStatus.key_s:"+currentStatus;
		solrSearchDTO.setQueryString(query);
		List<String> list  = searchDao.getKeys(solrSearchDTO, Drs.class);*/
		
		Query query = new Query();
		Criteria[] criteriaArr = QueryUtility.orQuery("currentStatus._id", currentStatus);
		query.addCriteria(Criteria.where("deliveryBoyKey_s").is(userKey).orOperator(criteriaArr));
		List<Drs> objList  = getObjectByQuery(query, Drs.class);
		return objList;
	}
	
}
