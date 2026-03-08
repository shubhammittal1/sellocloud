package com.bmp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bmp.constant.UserType;
import com.bmp.dao.AWBSeriesDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.AWBSeries;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("awbSeriesDaoImpl")
@Component("com.bmp.dao.impl.AWBSeriesDaoImpl")
public class AWBSeriesDaoImpl extends MongoBaseDaoImpl<AWBSeries> implements AWBSeriesDao {

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Override
	public int getUnUsedCODAWBSeries(UserType type, String typeKey) throws Exception {
		//SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		//String unUsedCODSeriesQuery = "entityType_s:"+type+" AND entityKey_s:"+typeKey+" AND paymentType_s:COD AND used_b:false";
		//solrSearchDTO.setQueryString(unUsedCODSeriesQuery);
		//return searchDao.getCount(solrSearchDTO, AWBSeries.class);
		List<Criteria> andQueryList = new ArrayList<>();
		Query query = new Query();
		andQueryList.add((new Criteria().where("entityType_s").is(type)));
		andQueryList.add((new Criteria().where("entityKey_s").is(typeKey)));
		andQueryList.add((new Criteria().where("paymentType_s").is("COD")));
		andQueryList.add((new Criteria().where("used_b").is(false)));
		query.addCriteria(new Criteria().andOperator(andQueryList.toArray(new Criteria[andQueryList.size()])));
		return getObjectCount(query, AWBSeries.class);
	}

	@Override
	public int getUnUsedPPAWBSeries(UserType type, String typeKey) throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		String unUsedPPSeriesQuery = "entityType_s:"+type+" AND entityKey_s:"+typeKey+" AND paymentType_s:PREPAID AND used_b:false";
		solrSearchDTO.setQueryString(unUsedPPSeriesQuery);
		return searchDao.getCount(solrSearchDTO, AWBSeries.class);*/
		
		List<Criteria> andList = new ArrayList<>();
		Query query = new Query();
		andList.add((new Criteria().where("entityType_s").is(type)));
		andList.add((new Criteria().where("entityKey_s").is(typeKey)));
		andList.add((new Criteria().where("paymentType_s").is("COD")));
		andList.add((new Criteria().where("used_b").is(false)));
		query.addCriteria(new Criteria().andOperator(andList.toArray(new Criteria[andList.size()])));
		return getObjectCount(query, AWBSeries.class);
	}
	
	@Override
	public int getUnUsedBothAWBSeries(UserType type, String typeKey)
			throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		String unUsedPPSeriesQuery = "entityType_s:"+type+" AND entityKey_s:"+typeKey+" AND paymentType_s:BOTH AND used_b:false";
		solrSearchDTO.setQueryString(unUsedPPSeriesQuery);
		return searchDao.getCount(solrSearchDTO, AWBSeries.class);*/
		
		List<Criteria> andList = new ArrayList<>();
		Query query = new Query();
		andList.add((new Criteria().where("entityType_s").is(type)));
		andList.add((new Criteria().where("entityKey_s").is(typeKey)));
		andList.add((new Criteria().where("paymentType_s").is("COD")));
		andList.add((new Criteria().where("used_b").is(false)));
		query.addCriteria(new Criteria().andOperator(andList.toArray(new Criteria[andList.size()])));
		return getObjectCount(query, AWBSeries.class);
	}

	@Override
	public int getUnUsedCourierAwbnumber(String courierKey, String paymentType) throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		String query = "entityKey_s:"+courierKey+" AND paymentType_s:"+paymentType.toUpperCase()+" AND used_b:false";
		solrSearchDTO.setPageSize(10);
		solrSearchDTO.setQueryString(query);
		return getEntityByLocationKey(searchDao.getKeys(solrSearchDTO, AWBSeries.class), AWBSeries.class);*/
		
		List<Criteria> andList = new ArrayList<>();
		Query query = new Query();
		andList.add((new Criteria().where("entityKey_s").is(courierKey)));
		andList.add((new Criteria().where("paymentType_s").is(paymentType.toUpperCase())));
		andList.add((new Criteria().where("used_b").is(false)));
		query.addCriteria(new Criteria().andOperator(andList.toArray(new Criteria[andList.size()])));
		return getObjectCount(query, AWBSeries.class);
	}

	@Override
	public AWBSeries getAWBSeriesFromAwb(String awbSeries) throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		String query = "awbNumber_s:"+awbSeries;
		solrSearchDTO.setQueryString(query);
		List<AWBSeries> series = getEntityByLocationKey(searchDao.getKeys(solrSearchDTO, AWBSeries.class), AWBSeries.class);
		if(series != null && !series.isEmpty()){
			return series.get(0);
		}
		return null;*/
		
		Query query = new Query();
		query.addCriteria(Criteria.where("awbNumber_s").is(awbSeries));
		List<AWBSeries> series = getObjectByQuery(query, AWBSeries.class);
		if(series != null && !series.isEmpty()){
			return series.get(0);
		}
		return null;
	}
	
}
