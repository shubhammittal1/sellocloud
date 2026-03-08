package com.bmp.dao.wms.impl;

import java.util.List;

import com.bmp.constant.OrderSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.OrderDao;
import com.bmp.model.app.wms.Order;

@Repository
@Qualifier("orderDaoImpl")
public class OrderDaoImpl extends MongoBaseDaoImpl<Order> implements OrderDao{

	@Autowired
    @Qualifier("mongoTemplateRead")
    private MongoTemplate mongoTemplate;
	
	@Override
	public Order getOrderByOrderId(String OrderId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("orderId").is(OrderId));

        // Fetch all records that match the query
        List<Order> order = mongoTemplate.find(query, Order.class);
        if(order!=null && order.size()>0) {
        	return order.get(order.size()-1);
        }
		return null;
	}

    @Override
    public boolean isApiOrderExist(String clientKey, OrderSource source, String shopCode, String orderId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("shopCode").is(shopCode));
        query.addCriteria(Criteria.where("orderId").is(orderId));
        query.addCriteria(Criteria.where("orderSource").is(source));
        query.addCriteria(Criteria.where("clientKey").is(clientKey));

        return isObjectExist(query, Order.class);
    }

}
