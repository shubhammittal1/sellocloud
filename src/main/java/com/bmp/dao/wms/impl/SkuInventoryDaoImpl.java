package com.bmp.dao.wms.impl;

import com.bmp.bean.ProductSearchResponseBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.LocationType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.bmp.constant.UserType;
import com.bmp.model.app.facility.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.constant.VirtualLocation;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.SkuInventoryDao;
import com.bmp.dao.wms.WarehouseLocationDao;
import com.bmp.model.app.channel.ChannelMaster;
import com.bmp.model.app.wms.SkuInventory;
import com.bmp.model.app.wms.WarehouseLocationMaster;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

@Repository
@Qualifier("skuInventoryRepo")
public class SkuInventoryDaoImpl extends MongoBaseDaoImpl<SkuInventory> implements SkuInventoryDao {

	@Autowired
	@Qualifier("mongoTemplateRead")
	private MongoTemplate mongoTemplate;

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;

	@Autowired
	@Qualifier("warehouseLocationDaoImpl")
	private WarehouseLocationDao warehouseLocationDao;

	@Override
	public Set<String> findDistinctSkuNames() {
		Query query = new Query();
		query.fields().include("key_s").include("skuName").include("expired_b");

		// Fetch all records that match the query
		List<SkuInventory> skuInventory = mongoTemplate.find(query, SkuInventory.class);

		// Use Map to collect distinct records
		Set<String> uniqueRecords = new HashSet<>();

		// Loop through the results and add each parentKey to the Map
		for (SkuInventory skuInventoryIterate : skuInventory) {
			uniqueRecords.add(skuInventoryIterate.getSkuName());
		}

		// Convert the Set to a List and return
		return uniqueRecords;
	}

	@Override
	public Set<String> findDistinctWarehouseKey() {
		Query query = new Query();
		query.fields().include("key_s").include("warehouseKey").include("expired_b");

		// Fetch all records that match the query
		List<SkuInventory> skuInventory = mongoTemplate.find(query, SkuInventory.class);

		// Use Map to collect distinct records
		Set<String> uniqueRecords = new HashSet<>();

		// Loop through the results and add each parentKey to the Map
		for (SkuInventory skuInventoryIterate : skuInventory) {
			uniqueRecords.add(skuInventoryIterate.getWarehouseKey());
		}

		// Convert the Set to a List and return
		return uniqueRecords;
	}

	@Override
	public List<SkuInventory> findSkuInventoryByWarehouseAndClientKey(String warehouseKey, String clientKey) {
		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");
		// List<BasicDBObject> list = new ArrayList<>();

		List<BasicDBObject> pipeline = Arrays.asList(
				// Stage 1: Match documents
				new BasicDBObject("$match", new BasicDBObject("clientKey", clientKey)
						.append("warehouseKey", warehouseKey)
						.append("totalQty", new BasicDBObject("$gt", 0))),

				// Stage 2: Lookup warehouse location

				new BasicDBObject("$lookup", new BasicDBObject("from", "warehouseLocation")
						.append("localField", "warehouseLocationKey")
						.append("foreignField", "_id")
						.append("as", "warehouseLocation")),

				// Stage 3: Project renamed fields and flatten the lookup result
				new BasicDBObject("$project", new BasicDBObject("id", "$_id")
						.append("skuCode", 1)
						.append("skuName", 1)
						.append("totalQty", 1)
						.append("skuImageUrls", 1)
						.append("warehouseLocation",
								new BasicDBObject("$arrayElemAt", Arrays.asList("$warehouseLocation", 0)))),

				// Stage 4: Filter out virtual locations Project renamed fields and flatten the
				// lookup result

				new BasicDBObject("$match", new BasicDBObject("warehouseLocation.isVirtualLocation", false)),

				// Stage 5: Group by skuCode
				new BasicDBObject("$group", new BasicDBObject("_id", "$skuCode")
						.append("totalQty", new BasicDBObject("$sum", "$totalQty"))
						.append("warehouseLocationKey", new BasicDBObject("$addToSet", "$warehouseLocation._id"))
						.append("skuName", new BasicDBObject("$first", "$skuName"))
						.append("skuImageUrls", new BasicDBObject("$first", "$skuImageUrls")))

		);

		// Execute aggregation

		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();

		List<SkuInventory> skuInventoryList = new ArrayList<>();

		while (cursor.hasNext()) {
			Document doc = cursor.next();

			SkuInventory skuInventory = new SkuInventory();
			skuInventory.setSkuCode((String) doc.get("_id"));
			skuInventory.setSkuName((String) doc.get("skuName"));
			skuInventory.setTotalQty((int) doc.get("totalQty"));
			skuInventory.setSkuImageUrls((String) doc.get("skuImageUrls"));
			List<String> warehouseLocationKeyList = (List<String>) doc.get("warehouseLocationKey");
			skuInventory.setWarehouseLocationKey(warehouseLocationKeyList.stream().collect(Collectors.joining(",")));

			skuInventoryList.add(skuInventory);

		}
		return skuInventoryList;
	}

	@Override
	public SkuInventory getSkuInventory(String clientKey, String warehouseKey, String locationKey, String skuCode) {
		Query query = new Query();
		if (sessionUserBean.getUser().getThirdPartyKey().equals(UserType.CLIENT)) {
			query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
		} else {
			query.addCriteria(Criteria.where("clientKey").is(clientKey));
		}
		query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey).and("warehouseLocationKey").is(locationKey)
				.and("skuCode").is(skuCode));

		// Fetch all records that match the query
		List<SkuInventory> skuInventory = mongoTemplate.find(query, SkuInventory.class);
		if (skuInventory != null && !skuInventory.isEmpty()) {
			return skuInventory.get(skuInventory.size() - 1);
		}
		return null;
	}

	@Override
	public SkuInventory getSkuInventory1(String clientKey, String warehouseKey, String locationKey, String skuCode) {
		Query query = new Query();
		if (sessionUserBean.getUser().getThirdPartyKey().equals(UserType.CLIENT)) {
			query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
		} else {
			query.addCriteria(Criteria.where("clientKey").is(clientKey));
		}
		query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey).and("warehouseLocationKey")
				.is(clientKey + "_" + warehouseKey + "_" + locationKey)
				.and("skuCode").is(skuCode));

		// Fetch all records that match the query
		List<SkuInventory> skuInventory = mongoTemplate.find(query, SkuInventory.class);
		if (skuInventory != null && !skuInventory.isEmpty()) {
			return skuInventory.get(skuInventory.size() - 1);
		}
		return null;
	}

	@Override
	public List<SkuInventory> findByWarehouseAndClientKey(String warehouseKey, String clientKey) {
		Query query = new Query();
		if (sessionUserBean.getUser().getThirdPartyKey().equals(UserType.CLIENT)) {
			query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
		} else {
			query.addCriteria(Criteria.where("clientKey").is(clientKey));
		}
		query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey));

		List<SkuInventory> skuInventoryObj = getObjectByQuery(query, SkuInventory.class);
		return skuInventoryObj;
	}

	@Override
	public List<SkuInventory> findBySkuCode(String key) {
		List<SkuInventory> skuInventoryObj = Collections.emptyList();
		if (key != null && key.isEmpty()) {
			Query query = new Query();
			query.addCriteria(Criteria.where("skucode").is(key));
			query.addCriteria(Criteria.where("locationCode").is(VirtualLocation.PO_IN_WORD_VIRTUAL_LOCATION));
			skuInventoryObj = getObjectByQuery(query, SkuInventory.class);

		}
		return skuInventoryObj;
	}

	@Override
	public Integer getStockBySkuAndWarehouse(String skuCode, String warehouseKey) {
		Query query = new Query();
		query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey));
		query.addCriteria(Criteria.where("skuCode").is(skuCode));
		List<SkuInventory> skuInventoryObj = getObjectByQuery(query, SkuInventory.class);
		int qty = 0;
		for (SkuInventory skuInventory : skuInventoryObj) {
			qty += skuInventory.getTotalQty();
		}
		return qty;
	}

	@Override
	public List<SkuInventory> getSkuInventoryByClientKeyAndWhKeyAndSkuCode(String clientKey, String warehouseKey,
			String skuCode, LocationType locationType) {
		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");

		List<BasicDBObject> pipeline = Arrays.asList(
				// Stage 1: Match documents
				new BasicDBObject("$match", new BasicDBObject("clientKey", clientKey)
						.append("warehouseKey", warehouseKey)
						.append("skuCode", skuCode)),

				// Stage 2: Lookup warehouse location

				new BasicDBObject("$lookup", new BasicDBObject("from", "warehouseLocation")
						.append("localField", "warehouseLocationKey")
						.append("foreignField", "_id")
						.append("as", "warehouseLocation")),

				// Stage 3: Project renamed fields and flatten the lookup result
				new BasicDBObject("$project", new BasicDBObject("id", "$_id")
						.append("skuCode", 1)
						.append("skuName", 1)
						.append("totalQty", 1)
						.append("warehouseLocation",
								new BasicDBObject("$arrayElemAt", Arrays.asList("$warehouseLocation", 0)))),

				// Stage 4: Filter out virtual locations Project renamed fields and flatten the
				// lookup result

				new BasicDBObject("$match", new BasicDBObject("warehouseLocation.isVirtualLocation", false)
						.append("warehouseLocation.locationType", locationType.toString()))

		);

		// Execute aggregation

		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();

		List<SkuInventory> skuInventoryList = new ArrayList<>();
		while (cursor.hasNext()) {
			Document doc = cursor.next();

			SkuInventory skuInventory = new SkuInventory();
			skuInventory.setKey_s((String) doc.get("id"));
			skuInventory.setSkuCode((String) doc.get("skuCode"));
			skuInventory.setSkuName((String) doc.get("skuName"));
			skuInventory.setTotalQty((int) doc.get("totalQty"));
			skuInventory.setWarehouseLocationKey((String) doc.get("warehouseLocation._id"));

			skuInventoryList.add(skuInventory);

		}

		return skuInventoryList;
	}

	@Override
	public List<Map<String, Object>> getInvByClientKeyAndSkuCode(String clientKey, String skuCode) {
		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");

		List<BasicDBObject> pipeline = Arrays.asList(new BasicDBObject("$match",
				new BasicDBObject("clientKey", clientKey)
						.append("skuCode", skuCode)
						.append("warehouseLocationKey",
								new BasicDBObject("$not",
										new BasicDBObject("$regex", "VIRTUAL_LOCATION")))
						.append("totalQty",
								new BasicDBObject("$gt", 0L))),

				new BasicDBObject("$lookup",
						new BasicDBObject("from", "warehouseLocation")
								.append("localField", "warehouseLocationKey")
								.append("foreignField", "_id")
								.append("as", "warehouseLocation")),

				new BasicDBObject("$project",
						new BasicDBObject("skuCode", 1L)
								.append("skuName", 1L)
								.append("warehouseKey", 1L)
								.append("totalQty", 1L)
								.append("skuImageUrls", 1L)
								.append("warehouseLocationkey",
										new BasicDBObject("$arrayElemAt", Arrays.asList("$warehouseLocation._id", 0L)))
								.append("warehouseLocationType",
										new BasicDBObject("$arrayElemAt",
												Arrays.asList("$warehouseLocation.locationType", 0L)))),

				new BasicDBObject("$match",
						new BasicDBObject("warehouseLocationType", "GOOD")),

				new BasicDBObject("$group",
						new BasicDBObject("_id",
								new BasicDBObject("warehouseKey", "$warehouseKey"))
								.append("warehouseKey",
										new BasicDBObject("$first", "$warehouseKey"))
								.append("skuCode",
										new BasicDBObject("$first", "$skuCode"))
								.append("totalQty",
										new BasicDBObject("$sum", "$totalQty"))
								.append("skuName",
										new BasicDBObject("$first", "$skuName"))
								.append("skuImageUrls",
										new BasicDBObject("$first", "$skuImageUrls"))
								.append("warehouseLocationQty",
										new BasicDBObject("$push",
												new BasicDBObject("warehouseLocationKey", "$warehouseLocationkey")
														.append("quantity", "$totalQty")))));

		/*
		 * List<BasicDBObject> pipeline = Arrays.asList(
		 * 
		 * // Stage 1: Match
		 * new BasicDBObject("$match",
		 * new BasicDBObject("clientKey", clientKey)
		 * .append("skuCode", skuCode)
		 * .append("warehouseLocationKey",
		 * new BasicDBObject("$not",
		 * new BasicDBObject("$regex", "VIRTUAL_LOCATION")
		 * )
		 * )
		 * .append("totalQty",
		 * new BasicDBObject("$gt", 0)
		 * )
		 * ),
		 * 
		 * // Stage 2: Lookup
		 * new BasicDBObject("$lookup",
		 * new BasicDBObject("from", "warehouseLocation")
		 * .append("localField", "warehouseLocationKey")
		 * .append("foreignField", "_id")
		 * .append("as", "warehouseLocation")
		 * ),
		 * 
		 * // Stage 3: Project
		 * new BasicDBObject("$project",
		 * new BasicDBObject("skuCode", 1)
		 * .append("skuName", 1)
		 * .append("warehouseKey", 1)
		 * .append("totalQty", 1)
		 * .append("skuImageUrls",1)
		 * .append("warehouseLocation",
		 * new BasicDBObject("$arrayElemAt",
		 * Arrays.asList("$warehouseLocation", 0)
		 * )
		 * )
		 * ),
		 * // Stage 4: Group by skuCode and warehouseKey
		 * new BasicDBObject("$group",
		 * new BasicDBObject("_id",
		 * new BasicDBObject("warehouseKey", "$warehouseKey")
		 * .append("skuCode", "$skuCode")
		 * )
		 * .append("warehouseKey", new BasicDBObject("$first", "$warehouseKey"))
		 * .append("skuCode", new BasicDBObject("$first", "$skuCode"))
		 * .append("totalQty", new BasicDBObject("$sum", "$totalQty"))
		 * .append("skuName", new BasicDBObject("$first", "$skuName"))
		 * .append("skuImageUrls", new BasicDBObject("$first", "$skuImageUrls"))
		 * .append("locationKey", new BasicDBObject("$first", "$warehouseLocation._id"))
		 * .append("locationType", new BasicDBObject("$first",
		 * "$warehouseLocation.locationType"))
		 * ),
		 * // Stage 4: Match by skuCode
		 * new BasicDBObject("$match", new BasicDBObject("locationType",
		 * LocationType.GOOD ))
		 * 
		 * );
		 */

		// Execute aggregation

		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();
		List<Map<String, Object>> outputList = new ArrayList<>();
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			Map<String, Object> map = new HashMap<>(doc);
			outputList.add(map);

		}

		return outputList;
	}

	@Override
	public Map<String, Integer> getSkuQuntityByClientKeyAndSkuCode(String clientKey, List<String> skuCode) {
		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");

		List<BasicDBObject> pipeline = Arrays.asList(new BasicDBObject("$match",
				new BasicDBObject("clientKey", clientKey)
						.append("skuCode",
								new BasicDBObject("$in", skuCode))
						.append("warehouseLocationKey",
								new BasicDBObject("$not",
										new BasicDBObject("$regex", "VIRTUAL_LOCATION")))
						.append("totalQty",
								new BasicDBObject("$gt", 0L))),
				new BasicDBObject("$lookup",
						new BasicDBObject("from", "warehouseLocation")
								.append("localField", "warehouseLocationKey")
								.append("foreignField", "_id")
								.append("as", "warehouseLocation")),
				new BasicDBObject("$project",
						new BasicDBObject("skuCode", 1L)
								.append("totalQty", 1L)
								.append("warehouseLocation",
										new BasicDBObject("$arrayElemAt", Arrays.asList("$warehouseLocation", 0L)))),
				new BasicDBObject("$match",
						new BasicDBObject("warehouseLocation.locationType", "GOOD")),
				new BasicDBObject("$group",
						new BasicDBObject("_id",
								new BasicDBObject("skuCode", "$skuCode"))
								.append("skuCode",
										new BasicDBObject("$first", "$skuCode"))
								.append("totalQty",
										new BasicDBObject("$sum", "$totalQty"))));

		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();

		Map<String, Integer> map = new HashMap<>();
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			map.put((String) doc.get("skuCode"), (int) doc.get("totalQty"));
		}

		return map;
	}
	/*
	 * @Override
	 * public List<SkuInventory> filtInvByWarehouseAndClientKey(String
	 * warehouseKey,String clientKey,Map<String, Object> filterMap) {
	 * MongoTemplate mongoTemplate = getMongoTemplate();
	 * DBCollection collection = mongoTemplate.getCollection("skuInventory");
	 * 
	 * List<BasicDBObject> pipeline = Arrays.asList(
	 * // Stage 1: Match documents
	 * new BasicDBObject("$match", new BasicDBObject("clientKey", clientKey)
	 * .append("warehouseKey", warehouseKey)
	 * .append("totalQty", new BasicDBObject("$gt", 0))),
	 * 
	 * // Stage 2: Lookup warehouse location
	 * new BasicDBObject("$lookup", new BasicDBObject("from", "warehouseLocation")
	 * .append("localField", "warehouseLocationKey")
	 * .append("foreignField", "_id")
	 * .append("as", "warehouseLocation")),
	 * 
	 * // Stage 3: Project renamed fields and flatten the lookup result
	 * new BasicDBObject("$project", new BasicDBObject("id", "$_id")
	 * .append("skuCode", 1)
	 * .append("skuName", 1)
	 * .append("totalQty", 1)
	 * .append("skuImageUrls",1)
	 * .append("warehouseLocation", new BasicDBObject("$arrayElemAt",
	 * Arrays.asList("$warehouseLocation", 0)))),
	 * 
	 * // Stage 4: Filter out virtual locations Project renamed fields and flatten
	 * the lookup result
	 * new BasicDBObject("$match", new
	 * BasicDBObject("warehouseLocation.isVirtualLocation", false)),
	 * 
	 * // Stage 5: Group by skuCode
	 * new BasicDBObject("$group", new BasicDBObject("_id", "$skuCode")
	 * .append("totalQty", new BasicDBObject("$sum", "$totalQty"))
	 * .append("warehouseLocationKey", new BasicDBObject("$addToSet",
	 * "$warehouseLocation._id"))
	 * .append("skuName", new BasicDBObject("$first",
	 * "$skuName")).append("skuImageUrls", new BasicDBObject("$first",
	 * "$skuImageUrls")))
	 * 
	 * );
	 * 
	 * // Execute aggregation
	 * Cursor cursor = collection.aggregate(
	 * pipeline,
	 * AggregationOptions.builder().outputMode(AggregationOptions.OutputMode.CURSOR)
	 * .build()
	 * );
	 * 
	 * List<SkuInventory> skuInventoryList = new ArrayList<>();
	 * 
	 * while (cursor.hasNext()) {
	 * BasicDBObject doc = (BasicDBObject) cursor.next();
	 * 
	 * SkuInventory skuInventory = new SkuInventory();
	 * skuInventory.setSkuCode((String) doc.get("_id"));
	 * skuInventory.setSkuName((String) doc.get("skuName"));
	 * skuInventory.setTotalQty((int) doc.get("totalQty"));
	 * skuInventory.setSkuImageUrls((String) doc.get("skuImageUrls"));
	 * List<String>warehouseLocationKeyList = (List<String>)
	 * doc.get("warehouseLocationKey");
	 * skuInventory.setWarehouseLocationKey(warehouseLocationKeyList.stream().
	 * collect(Collectors.joining(",")));
	 * 
	 * skuInventoryList.add(skuInventory);
	 * 
	 * }
	 * return skuInventoryList;
	 * }
	 */

	@Override
	public List<ProductSearchResponseBean> filtInvByWarehouseAndClientKey(Map<String, Object> filterMap) {
		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");

		int limitRecords = 0, skipRecords = 0, totalRecords = 0;
		String search = "";
		if (filterMap.get("limit") != null) {
			limitRecords = Integer.parseInt(filterMap.get("limit").toString());
		}
		if (filterMap.get("skip") != null) {
			skipRecords = Integer.parseInt(filterMap.get("skip").toString());
		}
		if (filterMap.get("total") != null) {
			totalRecords = Integer.parseInt(filterMap.get("total").toString());
		}
		if (filterMap.get("search") != null) {
			search = filterMap.get("search").toString();
		}

		// Base aggregation pipeline
		List<BasicDBObject> pipeline = new ArrayList<>(Arrays.asList(
				// Stage 1: Match documents
				new BasicDBObject("$match", new BasicDBObject("clientKey", filterMap.get("clientKey").toString())
						.append("warehouseKey", filterMap.get("warehouseKey").toString())
						.append("skuName", new BasicDBObject("$regex", search).append("$options", "i"))
						.append("totalQty", new BasicDBObject("$gt", 0))),

				// Stage 2: Lookup warehouse location
				new BasicDBObject("$lookup", new BasicDBObject("from", "warehouseLocation")
						.append("localField", "warehouseLocationKey")
						.append("foreignField", "_id")
						.append("as", "warehouseLocation")),

				// Stage 3: Project renamed fields and flatten the lookup result
				new BasicDBObject("$project", new BasicDBObject("id", "$_id")
						.append("skuCode", 1)
						.append("skuName", 1)
						.append("totalQty", 1)
						.append("skuImageUrls", 1)
						.append("warehouseLocation",
								new BasicDBObject("$arrayElemAt", Arrays.asList("$warehouseLocation", 0)))),

				// Stage 4: Filter out virtual locations
				new BasicDBObject("$match", new BasicDBObject("warehouseLocation.isVirtualLocation", false)
						.append("warehouseLocation.locationType", filterMap.get("locationType"))),

				// Stage 5: Group by skuCode
				new BasicDBObject("$group", new BasicDBObject("_id", "$skuCode")
						.append("totalQty", new BasicDBObject("$sum", "$totalQty"))
						.append("warehouseLocationKey", new BasicDBObject("$addToSet", "$warehouseLocation._id"))
						.append("skuName", new BasicDBObject("$first", "$skuName"))
						.append("skuImageUrls", new BasicDBObject("$first", "$skuImageUrls")))));

		// Step: Get total count if not already in filterMap
		if (totalRecords <= 0) {
			List<BasicDBObject> countPipeline = new ArrayList<>(pipeline);
			countPipeline.add(new BasicDBObject("$count", "count"));

			MongoCursor<Document> countCursor = collection.aggregate(countPipeline).iterator();

			if (countCursor.hasNext()) {
				Document countResult = countCursor.next();
				totalRecords = countResult.getInteger("count");
				filterMap.put("total", totalRecords);
			}
		}

		// Step: Add pagination stages
		if (skipRecords > 0) {
			pipeline.add(new BasicDBObject("$skip", skipRecords));
		}
		if (limitRecords > 0) {
			pipeline.add(new BasicDBObject("$limit", limitRecords));
		}

		// Final aggregation execution
		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();

		List<ProductSearchResponseBean> skuInventoryList = new ArrayList<>();
		while (cursor.hasNext()) {
			Document doc = cursor.next();

			ProductSearchResponseBean bean = new ProductSearchResponseBean();
			// bean.setKey_s(pdt.getKey_s() != null ? pdt.getKey_s() : "");
			bean.setSkuName((String) doc.get("skuName"));
			bean.setSkuCode((String) doc.get("_id"));
			// bean.setSellingPrice(price);
			bean.setSkuImageUrls((String) doc.get("skuImageUrls"));
			bean.setTotalQty((int) doc.get("totalQty"));

			List<String> warehouseLocationKeyList = (List<String>) doc.get("warehouseLocationKey");
			bean.setSetWarehouseLocationKey(warehouseLocationKeyList != null
					? warehouseLocationKeyList.stream().collect(Collectors.joining(","))
					: "");

			skuInventoryList.add(bean);
		}

		return skuInventoryList;
	}

	@Override
	public List<ProductSearchResponseBean> filtInvByClientKey(Map<String, Object> filterMap) {
		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");

		int limitRecords = 0, skipRecords = 0, totalRecords = 0;
		String search = "";
		if (filterMap.get("limit") != null) {
			limitRecords = Integer.parseInt(filterMap.get("limit").toString());
		}
		if (filterMap.get("skip") != null) {
			skipRecords = Integer.parseInt(filterMap.get("skip").toString());
		}
		if (filterMap.get("total") != null) {
			totalRecords = Integer.parseInt(filterMap.get("total").toString());
		}
		if (filterMap.get("search") != null) {
			search = filterMap.get("search").toString();
		}

		// Base aggregation pipeline
		List<BasicDBObject> pipeline = new ArrayList<>(Arrays.asList(
				// Stage 1: Match documents
				new BasicDBObject("$match", new BasicDBObject("clientKey", filterMap.get("clientKey").toString())
						.append("totalQty", new BasicDBObject("$gt", 0))
						.append("skuName", new BasicDBObject("$regex", search).append("$options", "i"))),
				// Stage 2: Lookup warehouse location
				new BasicDBObject("$lookup", new BasicDBObject("from", "warehouseLocation")
						.append("localField", "warehouseLocationKey")
						.append("foreignField", "_id")
						.append("as", "warehouseLocation")),

				// Stage 3: Project renamed fields and flatten the lookup result
				new BasicDBObject("$project", new BasicDBObject("id", "$_id")
						.append("skuCode", 1)
						.append("skuName", 1)
						.append("totalQty", 1)
						.append("skuImageUrls", 1)
						.append("warehouseLocation",
								new BasicDBObject("$arrayElemAt", Arrays.asList("$warehouseLocation", 0)))),

				// Stage 4: Filter out virtual locations
				new BasicDBObject("$match", new BasicDBObject("warehouseLocation.isVirtualLocation", false)
						.append("warehouseLocation.locationType", filterMap.get("locationType"))),

				// Stage 5: Group by skuCode
				new BasicDBObject("$group", new BasicDBObject("_id", "$skuCode")
						.append("totalQty", new BasicDBObject("$sum", "$totalQty"))
						.append("warehouseLocationKey", new BasicDBObject("$addToSet", "$warehouseLocation._id"))
						.append("skuName", new BasicDBObject("$first", "$skuName"))
						.append("skuImageUrls", new BasicDBObject("$first", "$skuImageUrls")))));

		// Step: Get total count if not already in filterMap
		if (totalRecords <= 0) {
			List<BasicDBObject> countPipeline = new ArrayList<>(pipeline);
			countPipeline.add(new BasicDBObject("$count", "count"));

			MongoCursor<Document> countCursor = collection.aggregate(countPipeline).iterator();

			if (countCursor.hasNext()) {
				Document countResult = countCursor.next();
				totalRecords = countResult.getInteger("count");
				filterMap.put("total", totalRecords);
			}
		}

		// Step: Add pagination stages
		if (skipRecords > 0) {
			pipeline.add(new BasicDBObject("$skip", skipRecords));
		}
		if (limitRecords > 0) {
			pipeline.add(new BasicDBObject("$limit", limitRecords));
		}

		// Final aggregation execution
		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();

		List<ProductSearchResponseBean> skuInventoryList = new ArrayList<>();
		while (cursor.hasNext()) {
			Document doc = cursor.next();

			SkuInventory skuInventory = new SkuInventory();
			skuInventory.setSkuCode((String) doc.get("_id"));
			skuInventory.setSkuName((String) doc.get("skuName"));
			skuInventory.setTotalQty((int) doc.get("totalQty"));
			skuInventory.setSkuImageUrls((String) doc.get("skuImageUrls"));

			ProductSearchResponseBean bean = new ProductSearchResponseBean();
			bean.setSkuCode((String) doc.get("_id"));
			bean.setSkuName((String) doc.get("skuName"));
			bean.setSkuImageUrls((String) doc.get("skuImageUrls"));
			bean.setTotalQty((int) doc.get("totalQty"));
			List<String> warehouseLocationKeyList = (List<String>) doc.get("warehouseLocationKey");
			bean.setSetWarehouseLocationKey(warehouseLocationKeyList != null
					? warehouseLocationKeyList.stream().collect(Collectors.joining(","))
					: "");

			skuInventoryList.add(bean);
		}

		return skuInventoryList;
	}

	@Override
	public List<Map<String, Object>> getAllSkuInventory(Integer skip, String searchValue) {
		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");
		List<BasicDBObject> pipeline = Arrays.asList(
				new BasicDBObject("$match", new BasicDBObject("warehouseLocationKey",
						new BasicDBObject("$not", new BasicDBObject("$regex", "VIRTUAL_LOCATION")))),

				new BasicDBObject("$lookup", new BasicDBObject("from", "catalogue")
						.append("localField", "skuCode")
						.append("foreignField", "productSku")
						.append("as", "catalogue")),

				new BasicDBObject("$project", new BasicDBObject("skuCode", 1L)
						.append("skuName", 1L)
						.append("clientKey", 1L)
						.append("warehouseKey", 1L)
						.append("warehouseLocationKey", 1L)
						.append("goodQty", 1L)
						.append("badQty", 1L)
						.append("totalQty", 1L)
						.append("skuImageUrls", 1L)
						.append("createdDate_l", 1L)
						.append("approved",
								new BasicDBObject("$arrayElemAt", Arrays.asList("$catalogue.approved", 0L)))),

				new BasicDBObject("$match", new BasicDBObject("approved", true)),

				new BasicDBObject("$lookup", new BasicDBObject("from", "warehouseLocation")
						.append("localField", "warehouseLocationKey")
						.append("foreignField", "_id")
						.append("as", "warehouseLocation")),

				new BasicDBObject("$project", new BasicDBObject("skuCode", 1L)
						.append("skuName", 1L)
						.append("clientKey", 1L)
						.append("warehouseKey", 1L)
						.append("goodQty", 1L)
						.append("badQty", 1L)
						.append("totalQty", 1L)
						.append("skuImageUrls", 1L)
						.append("createdDate_l", 1L)
						.append("warehouseLocationkey",
								new BasicDBObject("$arrayElemAt", Arrays.asList("$warehouseLocation.locationName", 0L)))
						.append("warehouseLocationType",
								new BasicDBObject("$arrayElemAt",
										Arrays.asList("$warehouseLocation.locationType", 0L)))),

				new BasicDBObject("$match", new BasicDBObject("$or", Arrays.asList(
						new BasicDBObject("warehouseKey",
								new BasicDBObject("$regex", searchValue).append("$options", "i")),
						new BasicDBObject("warehouseLocationkey",
								new BasicDBObject("$regex", searchValue).append("$options", "i")),
						new BasicDBObject("skuCode", new BasicDBObject("$regex", searchValue).append("$options", "i")),
						new BasicDBObject("skuName",
								new BasicDBObject("$regex", searchValue).append("$options", "i"))))),

				new BasicDBObject("$sort", new BasicDBObject("createdDate_l", -1L)),

				new BasicDBObject("$skip", skip),
				new BasicDBObject("$limit", 10L));

		// Execute aggregation

		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();
		List<Map<String, Object>> skuMaplist = new ArrayList<>();

		while (cursor.hasNext()) {
			Document doc = cursor.next();
			Map<String, Object> map = new HashMap<>();
			map.put("key_s", doc.get("_id"));
			map.put("skuCode", doc.get("skuCode"));
			map.put("skuName", doc.get("skuName"));
			map.put("skuImageUrls", doc.get("skuImageUrls"));
			map.put("warehouseKey", doc.get("warehouseKey"));
			map.put("goodQty", doc.get("goodQty"));
			map.put("badQty", doc.get("badQty"));
			map.put("totalQty", doc.get("totalQty"));
			map.put("clientKey", doc.get("clientKey"));
			map.put("warehouseLocationKey", doc.get("warehouseLocationkey"));
			map.put("warehouseLocationType", doc.get("warehouseLocationType"));
			skuMaplist.add(map);

		}
		return skuMaplist;
	}

	@Override
	public Integer getAllSkuInventoryCount() {
		MongoTemplate mongoTemplate = getMongoTemplate();
		MongoCollection<Document> collection = mongoTemplate.getCollection("skuInventory");
		List<BasicDBObject> pipeline = Arrays.asList(

				// Match documents that do NOT have 'VIRTUAL_LOCATION' in warehouseLocationKey
				new BasicDBObject("$match", new BasicDBObject("warehouseLocationKey",
						new BasicDBObject("$not", new BasicDBObject("$regex", "VIRTUAL_LOCATION")))),

				// Join with 'catalogue' collection
				new BasicDBObject("$lookup", new BasicDBObject("from", "catalogue")
						.append("localField", "skuCode")
						.append("foreignField", "productSku")
						.append("as", "catalogue")),

				// Project fields + extract 'approved' from catalogue
				new BasicDBObject("$project", new BasicDBObject("skuCode", 1L)
						.append("skuName", 1L)
						.append("clientKey", 1L)
						.append("warehouseKey", 1L)
						.append("warehouseLocationKey", 1L)
						.append("goodQty", 1L)
						.append("badQty", 1L)
						.append("totalQty", 1L)
						.append("skuImageUrls", 1L)
						.append("createdDate_l", 1L)
						.append("approved",
								new BasicDBObject("$arrayElemAt", Arrays.asList("$catalogue.approved", 0L)))),

				// Match only approved = true
				new BasicDBObject("$match", new BasicDBObject("approved", true)),

				// Join with warehouseLocation collection
				new BasicDBObject("$lookup", new BasicDBObject("from", "warehouseLocation")
						.append("localField", "warehouseLocationKey")
						.append("foreignField", "_id")
						.append("as", "warehouseLocation")),

				// Project again to extract fields from warehouseLocation
				new BasicDBObject("$project", new BasicDBObject("skuCode", 1L)
						.append("skuName", 1L)
						.append("clientKey", 1L)
						.append("warehouseKey", 1L)
						.append("goodQty", 1L)
						.append("badQty", 1L)
						.append("totalQty", 1L)
						.append("skuImageUrls", 1L)
						.append("createdDate_l", 1L)
						.append("warehouseLocationkey",
								new BasicDBObject("$arrayElemAt", Arrays.asList("$warehouseLocation.locationName", 0L)))
						.append("warehouseLocationType",
								new BasicDBObject("$arrayElemAt",
										Arrays.asList("$warehouseLocation.locationType", 0L)))),

				// Count final matching documents
				new BasicDBObject("$count", "total"));

		// Execute aggregation

		MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();
		int totalCount = 0;

		while (cursor.hasNext()) {
			Document doc = cursor.next();
			totalCount = doc.getInteger("total");

		}
		return totalCount;
	}

}
