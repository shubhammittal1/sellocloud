package com.bmp.dao.wms.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.WmsPendingInventoryPushDao;
import com.bmp.model.app.wms.Order;
import com.bmp.model.app.wms.WmsPendingInventoryPush;

@Repository
@Qualifier("wmsPendingInventoryPushDaoImpl")
public class WmsPendingInventoryPushDaoImpl extends MongoBaseDaoImpl<WmsPendingInventoryPush> implements WmsPendingInventoryPushDao{

	@Autowired
    @Qualifier("mongoTemplateRead")
    private MongoTemplate mongoTemplate;
	
	@Override
	public WmsPendingInventoryPush getPendingInventoryByInvkeySkuCodeClKeyAndMRtKey(String inventorykey, String skuCode,
			String clientKey, String marketplaceKey) {
		Query query = new Query();
        query.addCriteria(Criteria.where("skuInventoryKey").is(inventorykey));
        query.addCriteria(Criteria.where("skuCode").is(skuCode));
        query.addCriteria(Criteria.where("clientKey").is(clientKey));
        query.addCriteria(Criteria.where("marketPlaceKey").is(marketplaceKey));

        // Fetch all records that match the query
        List<WmsPendingInventoryPush> wmsPendingInventoryPush = mongoTemplate.find(query, WmsPendingInventoryPush.class);
        if(wmsPendingInventoryPush!=null && wmsPendingInventoryPush.size()>0) {
        	return wmsPendingInventoryPush.get(wmsPendingInventoryPush.size()-1);
        }
		return null;
	}

}
