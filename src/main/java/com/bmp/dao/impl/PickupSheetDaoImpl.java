package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PickupSheetDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.PickupSheet;
import com.bmp.solr.common.ISolrSearchDao;


@Repository
@Qualifier("pickupSheetDaoImpl")
public class PickupSheetDaoImpl extends MongoBaseDaoImpl<PickupSheet> implements PickupSheetDao{

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Override
	public List<PickupSheet> getIntransitPickupSheetListByBranch(String branchKey, String statusKey) throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		solrSearchDTO.setQueryString("branchKey_s:"+branchKey+" AND status.key_s:"+statusKey);
		List<String> keyList = searchDao.getKeys(solrSearchDTO, PickupSheet.class);
		List<PickupSheet> pickupSheetList = getEntityByLocationKey(keyList, PickupSheet.class);*/
		
		Query query = new Query();
		query.addCriteria(Criteria.where("branchKey_s").is(branchKey).and("status._id").is(statusKey));
		List<PickupSheet> pickupSheetList = getObjectByQuery(query, PickupSheet.class);
		return pickupSheetList;
	}

	@Override
	public List<PickupSheet> getPickupSheetListByUserId(String userId,String statusId) throws Exception {
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		solrSearchDTO.setQueryString("pickerKey_s:"+userId+" AND status.key_s:"+statusId);
		List<String> keyList = searchDao.getKeys(solrSearchDTO, PickupSheet.class);
		List<PickupSheet> pickupSheetList = getEntityByLocationKey(keyList, PickupSheet.class);*/
		
		Query query = new Query();
		query.addCriteria(Criteria.where("pickerKey_s").is(userId).and("status._id").is(statusId));
		List<PickupSheet> pickupSheetList = getObjectByQuery(query, PickupSheet.class);
		return pickupSheetList;
	}

}
