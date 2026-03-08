package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.SaleOrderPickupRequestDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("saleOrderPickupRequestDaoImpl")
public class SaleOrderPickupRequestDaoImpl extends MongoBaseDaoImpl<SaleOrderPickupRequest> implements SaleOrderPickupRequestDao {

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Override
	public List<SaleOrderPickupRequest> getSaleOrderPickupRequestList(String branchKey, String statusKey)
			throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		solrSearchDTO.setQueryString("branchKey_s:"+branchKey+" AND status.key_s:"+statusKey);
		solrSearchDTO.setSortField("createdDate_l");
		List<String> saleOrderPickupRequestKeyList = searchDao.getKeys(solrSearchDTO, SaleOrderPickupRequest.class);*/
		
		Query query = new Query();
		query.addCriteria(Criteria.where("branchKey_s").is(branchKey).and("status._id").is(statusKey));
		query.with(Sort.by(Sort.Direction.ASC, "createdDate_l"));
		return getObjectByQuery(query, SaleOrderPickupRequest.class);
	}

	@Override
	public List<SaleOrderPickupRequest> getSaleOrderPickupRequestList(String pickupSheepKey) throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		solrSearchDTO.setQueryString("pickupSheet_s:"+pickupSheepKey);
		List<String> saleOrderPickupRequestKeyList = searchDao.getKeys(solrSearchDTO, SaleOrderPickupRequest.class);*/
		
		Query query = new Query();
		query.addCriteria(Criteria.where("pickupSheet_s").is(pickupSheepKey));
		return getObjectByQuery(query, SaleOrderPickupRequest.class);
	}
	
}