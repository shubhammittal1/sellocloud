package com.bmp.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CourierDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.courier.Courier;
import com.bmp.model.app.masters.Pincode;

@Repository
@Qualifier("courierDaoImpl")
public class CourierDaoImpl extends MongoBaseDaoImpl<Courier> implements CourierDao{
	@Autowired 
	@Qualifier("mongoTemplateRead")
	private MongoTemplate mongoTemplate;
	
	@Override
	@Cacheable(value="courier")
	public Courier getEntityByLocationKey(String key) throws Exception {
		return getObjectById(key, Courier.class);
	}
	@Override
    public Map<String,String> findDistinctParentKeys() {
	 	Query query = new Query();
        query.fields().include("key_s").include("expired_b");
        query.addCriteria(new Criteria().orOperator(
                Criteria.where("parentCourier").is(null),       
                Criteria.where("parentCourier").is("")            
            ));

        // Fetch all records that match the query
        List<Courier> courier = mongoTemplate.find(query, Courier.class);
        // Use Map to collect distinct parent keys
        
        Map<String,String> uniqueRecords = new TreeMap<>();

        // Loop through the results and add each parentKey to the Map
        for (Courier courierIterate : courier) {
                uniqueRecords.put(courierIterate.getKey_s(), courierIterate.getKey_s());
            
        }

        // Convert the Set to a List and return
        return uniqueRecords;
    }
	@Override
	public String getCourierNameByKey(String key) {
		Query query = new Query();
		query.fields().include("companyName_s");
		query.addCriteria(Criteria.where("_id").is(key));
		List<Courier> courierList = getObjectByQuery(query, Courier.class);
		if(courierList != null && courierList.size() > 0) {
			Courier Courier = courierList.get(0);
			return Courier.getCompanyName_s();
		}
		return null;
	}
	
	
}
