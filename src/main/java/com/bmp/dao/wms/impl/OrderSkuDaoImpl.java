package com.bmp.dao.wms.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.OrderSkuDao;
import com.bmp.model.app.wms.OrderSku;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

@Repository
@Qualifier("orderSkuDaoImpl")
public class OrderSkuDaoImpl extends MongoBaseDaoImpl<OrderSku> implements OrderSkuDao {

	@Autowired
	@Qualifier("mongoTemplateRead")
	private MongoTemplate mongoTemplate;

	@Override
	public OrderSku getOrderSkuByOrderIdAndSkuCode(String orderKey, String skuCode) {
		Query query = new Query();
		query.addCriteria(Criteria.where("orderKey").is(orderKey).and("skuCode").is(skuCode));
		// Fetch all records that match the query
		List<OrderSku> orderSku = mongoTemplate.find(query, OrderSku.class);
		if (orderSku != null && orderSku.size() > 0) {
			return orderSku.get(orderSku.size() - 1);
		}
		return null;
	}

	@Override
	public List<String> getskuListByOrderSkuKey(List<String> skuKeyList) {

		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");

		List<BasicDBObject> pipeline = Arrays.asList(new BasicDBObject("$match",
				new BasicDBObject("_id",
						new BasicDBObject("$in", skuKeyList))),
				new BasicDBObject("$project",
						new BasicDBObject("_id", 0L)
								.append("skuCode", 1L)));

		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();
		List<String> outputList = new ArrayList<>();
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			outputList.add((String) doc.get("skuCode"));

		}

		return outputList;
	}

}
