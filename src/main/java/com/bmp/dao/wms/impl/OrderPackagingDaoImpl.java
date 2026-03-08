package com.bmp.dao.wms.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.constant.GlobalConstant;
import com.bmp.constant.VirtualLocation;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.OrderPackagingDao;
import com.bmp.model.app.wms.OrderPackaging;
import com.bmp.model.app.wms.SkuInventory;

@Repository
@Qualifier("orderPackagingDaoImpl")
public class OrderPackagingDaoImpl extends MongoBaseDaoImpl<OrderPackaging> implements OrderPackagingDao {
	@Autowired
	private MessageSource messageSource;
	@Override
	public List<OrderPackaging> findByOrderKey(String key) {
		List<OrderPackaging> orderPackagingObj = Collections.emptyList();
        if(key!=null) {
            Query query = new Query();
            query.addCriteria(Criteria.where("orderKey").is(key));
            orderPackagingObj = getObjectByQuery(query, OrderPackaging.class);
        }
        return orderPackagingObj;
	}
	
	@Override
	public List<OrderPackaging> findOrderPackagingByOrderIdAndStatus(String key,String statusKey) {
		List<OrderPackaging> orderPackagingObj = Collections.emptyList();
        if(key!=null) {
            Query query = new Query();
            query.addCriteria(Criteria.where("orderKey").is(key));
            query.addCriteria(Criteria.where("currentStatus._id").is(statusKey));
            orderPackagingObj = getObjectByQuery(query, OrderPackaging.class);
        }
        return orderPackagingObj;
	}

}
