package com.bmp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RemittanceDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.Remittance;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.conversions.Bson;

@Repository
@Qualifier("remittanceDaoImpl")
public class RemittanceDaoImpl extends MongoBaseDaoImpl<Remittance> implements RemittanceDao {

	@Override
	public List<String> getClients() throws Exception {
		try {
			MongoTemplate mongoTemplate = getMongoTemplate();
			MongoCollection<Document> collection = mongoTemplate.getCollection("saleOrder");
			List<Bson> list = new ArrayList<>();

			String aggration = "{\n"
					+ "      $match: {\n"
					+ "'paymentType_s':'COD'\n"
					+ "'currentStatus._id':'116'\n"
					+ "remittanceStatus_s: {\n"
					+ "$not: { $regex: '' }\n"
					+ "}\n"
					+ "      }\n"
					+ "    }";
			BasicDBObject matchAggregation = BasicDBObject.parse(aggration);
			list.add(matchAggregation);

			aggration = "{\n"
					+ "      $group: {\n"
					+ "        _id: '$clientKey_s'\n"
					+ "      }\n"
					+ "    }";

			BasicDBObject groupAggregation = BasicDBObject.parse(aggration);
			list.add(groupAggregation);
			MongoCursor<Document> countOutput = collection.aggregate(list).allowDiskUse(true).iterator();
			List<String> clientList = new ArrayList<>();
			while (countOutput.hasNext()) {
				Document dbObject = countOutput.next();
				if (dbObject.containsKey("_id") && dbObject.get("_id") != null) {
					clientList.add(dbObject.get("_id").toString());
				}
			}
			return clientList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
