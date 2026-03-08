package com.bmp.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PincodeDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.Pincode;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("pincodeDaoImpl")
public class PincodeDaoImpl extends MongoBaseDaoImpl<Pincode> implements PincodeDao{
	
	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Override
	public List<Pincode> getAllSourceCityByPincode (String city) throws Exception {
		
		Query query = new Query();
		
		query.addCriteria(Criteria.where("city._id").is(city));
		List<Pincode> pincode = getObjectByQuery(query, Pincode.class);
		
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		solrSearchDTO.setQueryString("city.key_s:"+city);
		
		List<String> pincodeList = searchDao.getKeys(solrSearchDTO, Pincode.class);
		Collections.sort(pincodeList);
		List<Pincode> pincode = getEntityByLocationKey(pincodeList, Pincode.class);*/
		return pincode;
	}
	
	@Override
	public String cityKeyByPincode(String pincode) {
		Query query = new Query();
		query.fields().include("city._id");
		query.addCriteria(Criteria.where("_id").is(pincode));
		List<Pincode> pincodeList = getObjectByQuery(query, Pincode.class);
		if(pincodeList != null && pincodeList.size() > 0) {
			Pincode pincodeObj = pincodeList.get(0);
			return pincodeObj.getCity().getKey_s();
		}
		return null;
	}
}