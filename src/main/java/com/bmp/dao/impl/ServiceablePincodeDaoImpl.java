package com.bmp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.dao.ServiceablePincodeDao;
import com.bmp.dao.config.MongoBaseDaoImplWithModifiedKey;
import com.bmp.model.app.masters.ServiceablePincode;
import com.bmp.oms.service.masters.impl.ServiceablePincodeServiceImpl;
import com.bmp.utility.logger.AsyncLogger;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

@Repository
@Qualifier("ServiceablePincodeDaoImpl")
public class ServiceablePincodeDaoImpl extends MongoBaseDaoImplWithModifiedKey<ServiceablePincode>
		implements ServiceablePincodeDao {

	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;

	@Override
	public List<String> pincodeByBranchName(String branchKey) throws Exception {
		try {

			Query query = new Query();
			query.addCriteria(Criteria.where("branch._id").is(branchKey));
			query.fields().include("_id");
			List<ServiceablePincode> resultList = getObjectByQuery(query, ServiceablePincode.class);

			List<String> keyList = new ArrayList<String>();
			for (ServiceablePincode object : resultList) {
				keyList.add(object.getKey_s());
			}

			return keyList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getPincodeZone(String courierKey, String zoneFieldName) throws Exception {
		try {
			MongoTemplate mongoTemplate = getMongoTemplate();
			MongoCollection<Document> collection = mongoTemplate.getCollection("serviceablePincode");
			List<BasicDBObject> list = new ArrayList<>(5);

			String aggration = "{\n"
					+ "      $match: {\n"
					+ "        'serviceProviders.#courierKey.courierKey':\n"
					+ "          '#courierKey'\n"
					+ "      }\n"
					+ "    }";
			aggration = aggration.replaceAll("#courierKey", courierKey);
			BasicDBObject matchAggregation = BasicDBObject.parse(aggration);
			list.add(matchAggregation);

			aggration = "{\n"
					+ "      $project: {\n"
					+ "        'serviceProviders.#courierKey.pincodeGroup': 1,\n"
					+ "        'serviceProviders.#courierKey.north': 1,\n"
					+ "        'serviceProviders.#courierKey.east': 1,\n"
					+ "        'serviceProviders.#courierKey.west': 1,\n"
					+ "        'serviceProviders.#courierKey.south': 1,\n"
					+ "        'serviceProviders.#courierKey.other': 1\n"
					+ "      }\n"
					+ "    }";
			aggration = aggration.replaceAll("#courierKey", courierKey);
			BasicDBObject projectAggregation = BasicDBObject.parse(aggration);
			list.add(projectAggregation);

			aggration = "{\n"
					+ "      $group: {\n"
					+ "        _id: '$serviceProviders.#courierKey.#fieldName'\n"
					+ "      }\n"
					+ "    }";
			aggration = aggration.replaceAll("#courierKey", courierKey).replaceAll("#fieldName", zoneFieldName);
			BasicDBObject groupAggregation = BasicDBObject.parse(aggration);
			list.add(groupAggregation);

			aggration = "{ $sort: { _id: 1 } }";
			aggration = aggration.replaceAll("#courierKey", courierKey);
			BasicDBObject sortAggregation = BasicDBObject.parse(aggration);
			list.add(sortAggregation);

			MongoCursor<Document> countOutput = collection.aggregate(list).iterator();
			List<String> zonelist = new ArrayList<>();
			while (countOutput.hasNext()) {
				Document dbObject = countOutput.next();
				if (dbObject.containsKey("_id") && dbObject.get("_id") != null) {
					zonelist.add(dbObject.get("_id").toString());
				}
			}
			return zonelist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
