package com.bmp.dao.wms.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.PurchaseOrderDao;
import com.bmp.model.app.wms.OrderSku;
import com.bmp.model.app.wms.PurchaseOrder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("purchaseOrderDaoImpl")
public class PurchaseOrderDaoImpl extends MongoBaseDaoImpl<PurchaseOrder> implements PurchaseOrderDao {
	
	@Autowired
    @Qualifier("mongoTemplateRead")
    private MongoTemplate mongoTemplate;
	
	@Override
	public List<PurchaseOrder> getPoByClienyKeyAndWarehouseKey(String clientKey, String warehouseKey) {
		Query query = new Query();
        query.addCriteria(Criteria.where("clientKey").is(clientKey).and("warehouseKey").is(warehouseKey));
        // Fetch all records that match the query
        List<PurchaseOrder> purchaseOrder = mongoTemplate.find(query, PurchaseOrder.class);
        
		return purchaseOrder;
	}
}
