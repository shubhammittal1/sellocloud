package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.MarketPlaceOrderDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.MarketPlaceOrder;

@Repository
@Qualifier("marketPlaceOrderDaoImpl")
public class MarketPlaceOrderDaoImpl extends MongoBaseDaoImpl<MarketPlaceOrder> implements MarketPlaceOrderDao{

	 @Autowired
    @Qualifier("mongoTemplateRead")
    private MongoTemplate mongoTemplate;
	
	@Override
	public MarketPlaceOrder getMarketPlaceOrderByOrderId(String clientKey,String OrderId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("clientKey").is(clientKey).and("orderId").is(OrderId));

        // Fetch all records that match the query
        List<MarketPlaceOrder> marketPlaceOrder = mongoTemplate.find(query, MarketPlaceOrder.class);
        if(marketPlaceOrder!=null && marketPlaceOrder.size()>0) {
        	return marketPlaceOrder.get(marketPlaceOrder.size()-1);
        }
		return null;
	}
	/**/
}
