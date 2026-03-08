package com.bmp.dao.impl;

import java.util.List;
import java.util.ArrayList;

import com.bmp.bean.user.SessionUserBean;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientWarehouseDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("clientWarehouseDaoImpl")
public class ClientWarehouseDaoImpl extends MongoBaseDaoImpl<ClientWarehouse> implements ClientWarehouseDao {

	@Autowired
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;

	@Override
	public List<ClientWarehouse> getAllWarehouseListByClient(String clientKey) throws Exception {

		Query query = new Query();
		query.addCriteria(Criteria.where("clientKey_s").is(clientKey).and("expired_b").is(false));
		List<ClientWarehouse> warehouseList = getObjectByQuery(query, ClientWarehouse.class);
		if (sessionUserBean.getUser().getType().equals("CLIENT")) {
			String userName = sessionUserBean.getUser().getThirdPartyKey();
			query.addCriteria(Criteria.where("createdBy").is(userName));
		}

		/*
		 * SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		 * solrSearchDTO.setQueryString("clientKey_s:"+clentKey);
		 * List<String> keyList = searchDao.getKeys(solrSearchDTO,
		 * ClientWarehouse.class);
		 * List<ClientWarehouse> warehouseList = getEntityByLocationKey(keyList,
		 * ClientWarehouse.class);
		 */
		return warehouseList;
	}

	@Override
	public List<ClientWarehouse> getClientByWareHouseNameAndClient(String wareHouseName, String clientKey) {

		Query query = new Query();
		query.addCriteria(Criteria.where("warehouseName_s").is(wareHouseName).and("clientKey_s").is(clientKey));

		List<ClientWarehouse> warehouseList = getObjectByQuery(query, ClientWarehouse.class);
		return warehouseList;
	}

	@Override
	public List<ClientWarehouse> getClientByPincodeAndClient(String pincode, String clientKey) {
		Query query = new Query();
		query.addCriteria(Criteria.where("pincode").is(pincode).and("clientKey_s").is(clientKey));
		List<ClientWarehouse> warehouseList = getObjectByQuery(query, ClientWarehouse.class);
		return warehouseList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getAllClients() {
		MongoCollection<Document> collection = mongoTemplate.getCollection("clientWarehouse");
		BasicDBObject query = new BasicDBObject("createdBy", new BasicDBObject("$exists", true));
		List<String> distinctValues = collection.distinct("createdBy", query, String.class).into(new ArrayList<>());
		BasicDBObject query1 = new BasicDBObject("_id", new BasicDBObject("$exists", true));
		List<String> distinctIdValues = collection.distinct("_id", query1, String.class).into(new ArrayList<>());
		distinctValues.addAll(distinctIdValues);
		return distinctValues;
	}
}