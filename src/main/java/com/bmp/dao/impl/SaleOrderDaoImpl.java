package com.bmp.dao.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import com.bmp.bean.saleorder.AggregationResult;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bmp.constant.GlobalConstant;
import com.bmp.constant.OrderSource;
import com.bmp.constant.PacketFlow;
import com.bmp.dao.CourierDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.config.BaseDaoImpl;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.Courier;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.solr.common.SOLRSearchDTO;
import com.bmp.utility.QueryUtility;
import com.mongodb.MongoGridFSException;

@Repository
@Qualifier("saleOrderDaoImpl")
@Component("com.bmp.dao.impl.SaleOrderDaoImpl")
public class SaleOrderDaoImpl extends MongoBaseDaoImpl<SaleOrder> implements SaleOrderDao {

	@Autowired
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	@Qualifier("courierDaoImpl")
	private CourierDao courierDao;

	@Override
	public int total3PlShipmentOnBtranch(String branchKey, String courierKey, String statusKey) throws Exception {
		String threePlKey = messageSource.getMessage(GlobalConstant.INSCANNED_AWAITING_FOR_3PL_TRANSFER, null, null)
				.trim();
		String internalTransferKey = messageSource
				.getMessage(GlobalConstant.INSCANNED_AWAITING_FOR_INTERNAL_TRANSFER, null, null).trim();

		Query query = new Query();
		Object currentStatus[] = { threePlKey, internalTransferKey };
		Object routing[] = { PacketFlow.HANDOVER_TO_3PL.toString(), PacketFlow.INTERNAL_TRANSFER.toString() };

		query.addCriteria(Criteria.where("handOver_b").is(false).and("currentStatus._id").in(currentStatus)
				.and("currentBranch_s").is(branchKey)
				.and("courierKey_s").is(courierKey).and("routingMode_s").in(routing));

		return getObjectCount(query, SaleOrder.class);

		/*
		 * SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		 * String query = "currentStatus.key_s:("+threePlKey+" OR "
		 * +internalTransferKey+") AND currentBranch_s:"+branchKey+" AND courierKey_s:"
		 * +courierKey+
		 * " AND handOver_b:false AND routingMode_s:("+PacketFlow.HANDOVER_TO_3PL+" OR "
		 * +PacketFlow.INTERNAL_TRANSFER+")";
		 * solrSearchDTO.setQueryString(query);
		 * return searchDao.getCount(solrSearchDTO, SaleOrder.class);
		 */
	}

	@Override
	public List<SaleOrder> total3PlShipmentOnUser(List<String> userBranchKeys, String statusKey) throws Exception {
		String selfLogisticKey = messageSource.getMessage(GlobalConstant.SELF_LOGISTIC_KEY, null, null).trim();
		String threePlKey = messageSource.getMessage(GlobalConstant.INSCANNED_AWAITING_FOR_3PL_TRANSFER, null, null)
				.trim();
		String internalTransferKey = messageSource
				.getMessage(GlobalConstant.INSCANNED_AWAITING_FOR_INTERNAL_TRANSFER, null, null).trim();

		Query query = new Query();
		query.fields().include("_id");
		query.fields().include("courierKey_s");

		Object cs[] = { threePlKey, internalTransferKey };
		Object routing[] = { PacketFlow.HANDOVER_TO_3PL.toString(), PacketFlow.INTERNAL_TRANSFER.toString() };

		query.addCriteria(
				Criteria.where("handOver_b").is(false).and("currentStatus._id").in(cs).and("routingMode_s").in(routing)
						.and("currentBranch_s").in(userBranchKeys).and("courierKey_s").ne(selfLogisticKey));

		return getObjectByQuery(query, SaleOrder.class);

		/*
		 * SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		 * String pendingForHanover3PlQuery="currentStatus.key_s:("+threePlKey+" OR "
		 * +internalTransferKey+") AND handOver_b:false"
		 * + " AND routingMode_s:("+PacketFlow.HANDOVER_TO_3PL.toString()+" OR "
		 * +PacketFlow.INTERNAL_TRANSFER.toString()+")"
		 * + " AND -courierKey_s:"+selfLogisticKey+" AND currentBranch_s:("+
		 * getBranchOrQueryFromList (userBranchKeys)+")";
		 * solrSearchDTO.setQueryString(pendingForHanover3PlQuery);
		 * List<String> list = searchDao.getKeys(solrSearchDTO, SaleOrder.class);
		 * return getEntityByLocationKey(list, SaleOrder.class);
		 */
	}

	private String getBranchOrQueryFromList(List<String> strings) {
		if (strings == null || strings.size() == 0) {
			return null;
		}
		String query = strings.get(0);
		for (int i = 1; i < strings.size(); i++) {
			query = query + " OR " + strings.get(i);
		}
		return query;
	}

	@Override
	public List<String> getAllSaleorderNumber(String courierAwb) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("courierAWBNumber_s").is(courierAwb));
		query.fields().include("_id");
		return getKeys(query, SaleOrder.class);

		/*
		 * SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		 * String query = "courierAWBNumber_s:"+courierAwb;
		 * solrSearchDTO.setQueryString(query);
		 * return searchDao.getKeys(solrSearchDTO, SaleOrder.class);
		 */
	}

	@Override
	public List<SaleOrder> getSaleOrdersByOrderNoAndSource(String saleOrderNumber, OrderSource orderSource)
			throws Exception {
		Query query = new Query();
		query.addCriteria(
				Criteria.where("saleOrderNumber_s").is(saleOrderNumber).and("source").is(orderSource.SHOPIFY.name()));
		return getObjectByQuery(query, SaleOrder.class);
	}

	public AggregationResult getSaleOrderAggregations(boolean flag, String user, Long from, Integer days) {
		DBObject matchStage;
		Query queryRTO = new Query();
		// String RTO_CONFIRM = messageSource.getMessage(GlobalConstant.CONFIRM_RTO, null, null).trim();
		// Replaced below to include both RTO_CONFIRM and RTO_GENERATED IDs
		String RTO_CONFIRM = messageSource.getMessage(GlobalConstant.CONFIRM_RTO, null, null).trim();
		String RTO_GEN = messageSource.getMessage(GlobalConstant.RTO_GENERATED, null, null).trim();
		
		if (flag) {
			matchStage = new BasicDBObject("$match",
					new BasicDBObject("createdDate_l", new BasicDBObject("$gte", from))
							.append("clientKey_s", user)
							.append("_id", new BasicDBObject("$not", Pattern.compile("RTO"))));

			// queryRTO.addCriteria(Criteria.where("currentStatus._id").is(RTO_CONFIRM))
			// Updated to include both RTO status IDs
			queryRTO.addCriteria(Criteria.where("currentStatus._id").in(Arrays.asList(RTO_CONFIRM, RTO_GEN)))
					.addCriteria(Criteria.where("rtoDate").gte(from))
					.addCriteria(Criteria.where("clientKey_s").is(user))
					.addCriteria(Criteria.where("_id").not().regex("RTO"));
		} else {
			matchStage = new BasicDBObject("$match",
					new BasicDBObject("createdDate_l", new BasicDBObject("$gte", from))
							.append("_id", new BasicDBObject("$not", Pattern.compile("RTO"))));

			// queryRTO.addCriteria(Criteria.where("currentStatus._id").is(RTO_CONFIRM))
			// Updated to include both RTO status IDs
			queryRTO.addCriteria(Criteria.where("currentStatus._id").in(Arrays.asList(RTO_CONFIRM, RTO_GEN)))
					.addCriteria(Criteria.where("rtoDate").gte(from))
					.addCriteria(Criteria.where("_id").not().regex("RTO"));
		}

		DBObject dailyGroup = new BasicDBObject("$group", new BasicDBObject("_id", new BasicDBObject("$dateToString",
				new BasicDBObject("date", new BasicDBObject("$toDate", "$createdDate_l")).append("format", "%Y-%m-%d")))
				.append("count", new BasicDBObject("$sum", 1)));
		DBObject sort = new BasicDBObject("$sort", new BasicDBObject("_id", 1));
		List<DBObject> dailyPipeline = Arrays.asList(dailyGroup, sort);

		DBObject courierMatch = new BasicDBObject("$match",
				new BasicDBObject("courierKey_s", new BasicDBObject("$nin", Arrays.asList(null, "")))
						.append("_id", new BasicDBObject("$not", Pattern.compile("RTO"))));
		DBObject courierGroup = new BasicDBObject("$group",
				new BasicDBObject("_id", "$courierKey_s")
						.append("count", new BasicDBObject("$sum", 1)));
		List<DBObject> courierPipeline = Arrays.asList(courierMatch, courierGroup, sort);

		DBObject rateZoneMatch = new BasicDBObject("$match",
				new BasicDBObject("consigneeState", new BasicDBObject("$nin", Arrays.asList(null, ""))).append("_id",
						new BasicDBObject("$not", Pattern.compile("RTO"))));
		DBObject ratezoneGroup = new BasicDBObject("$group",
				new BasicDBObject("_id", "$consigneeState").append("count", new BasicDBObject("$sum", 1)));
		List<DBObject> ratezonePipeline = Arrays.asList(rateZoneMatch, ratezoneGroup, sort);

		DBObject orderStatusMatch = new BasicDBObject("$match",
				new BasicDBObject("currentStatus._id", new BasicDBObject("$nin", Arrays.asList(null, ""))).append("_id",
						new BasicDBObject("$not", new BasicDBObject("$regex", "RTO"))));
		DBObject orderStatusGroup = new BasicDBObject("$group",
				new BasicDBObject("_id", "$currentStatus._id").append("count", new BasicDBObject("$sum", 1)));
		List<DBObject> orderStatusPipeline = Arrays.asList(orderStatusMatch, orderStatusGroup, sort);

		DBObject facetStage = new BasicDBObject("$facet", new BasicDBObject()
				.append("daily_orders", dailyPipeline)
				.append("courier_wise_orders", courierPipeline)
				.append("ratezone_wise_data", ratezonePipeline)
				.append("order_status", orderStatusPipeline));

		List<DBObject> pipeline = Arrays.asList(matchStage, facetStage);

		BasicDBObject command = new BasicDBObject();
		command.put("aggregate", "saleOrder");
		command.put("pipeline", pipeline);
		command.put("cursor", new BasicDBObject());
		command.put("maxTimeMS", 60000);
		command.put("allowDiskUse", true);

		DBObject commandResult = mongoTemplate.getDb().runCommand(command, BasicDBObject.class);

		long dbRTOCount = mongoTemplate.count(queryRTO, "saleOrder");
		int rtoCount = (int) dbRTOCount;
		DBObject cursor = (DBObject) commandResult.get("cursor");

		List<DBObject> aggregationResults = (List<DBObject>) cursor.get("firstBatch");
		AggregationResult result = new AggregationResult();

		if (aggregationResults != null && !aggregationResults.isEmpty()) {
			DBObject aggregatedDoc = aggregationResults.get(0);

			List<DBObject> dailyList = (List<DBObject>) aggregatedDoc.get("daily_orders");
			List<Integer> dailyOrdersCount = new ArrayList<>();
			List<Object> dailyOrders = new ArrayList<>();

			if (days > 45) {
				List<String> twoWeeksOrders = new ArrayList<>();
				List<Integer> twoWeeksOrdersCount = new ArrayList<>();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				List<Date> sortedDates = new ArrayList<>();
				List<Integer> currentWeekData = new ArrayList<>();
				Date weekStart = null;
				Date currentDate = null;
				int sum = 0;

				for (DBObject order : dailyList) {
					String str = (String) order.get("_id");
					try {
						currentDate = sdf.parse(str);
						sortedDates.add(currentDate);
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
				}
				Collections.sort(sortedDates);
				/* sortedDates.sort(Comparator.naturalOrder());// introduce in java 8 */
				weekStart = getStartOfWeek(sortedDates.get(0));

				for (int i = 0; i < sortedDates.size() - 1; i++) {
					currentDate = sortedDates.get(i);

					if (isSameWeek(currentDate, weekStart)) {
						currentWeekData.add(((Number) dailyList.get(i).get("count")).intValue());
					} else {
						twoWeeksOrders.add(formatDate(weekStart) + " to " + formatDate(addDays(weekStart, 6)));
						sum = 0;
						for (Integer value : currentWeekData) {
							if (value != null) {
								sum += value;
							}
						}
						twoWeeksOrdersCount.add(sum);

						weekStart = getStartOfWeek(currentDate);
						currentWeekData.clear();
						currentWeekData.add(((Number) dailyList.get(i).get("count")).intValue());
					}
				}

				if (!currentWeekData.isEmpty()) {
					twoWeeksOrders.add(formatDate(weekStart) + " to " + formatDate(addDays(weekStart, 6)));
					/*
					 * twoWeeksOrdersCount.add(currentWeekData.stream().mapToInt(Integer::intValue).
					 * sum());
					 */
					sum = 0;
					for (Integer value : currentWeekData) {
						if (value != null) {
							sum += value;
						}
					}
					twoWeeksOrdersCount.add(sum);
				}

				List<Object> finalTwoWeeksOrders = new ArrayList<>();
				List<Integer> finalTwoWeeksCounts = new ArrayList<>();
				for (int i = 0; i < twoWeeksOrders.size() - 1; i += 2) {
					int sumCount = twoWeeksOrdersCount.get(i);
					String rangeStart = twoWeeksOrders.get(i).split(" to ")[0];
					String rangeEnd = twoWeeksOrders.get(i + 1).split(" to ")[1];

					if (i + 1 < twoWeeksOrders.size()) {
						sumCount += twoWeeksOrdersCount.get(i + 1);
					}

					finalTwoWeeksOrders.add(rangeStart + " to " + rangeEnd);
					finalTwoWeeksCounts.add(sumCount);
				}
				result.setDailyOrders(finalTwoWeeksOrders);
				result.setDailyOrdersCount(finalTwoWeeksCounts);
			} else {
				if (dailyList != null) {
					for (DBObject order : dailyList) {
						dailyOrders.add(order.get("_id"));
						dailyOrdersCount.add(((Number) order.get("count")).intValue());
					}
				}
				result.setDailyOrders(dailyOrders);
				result.setDailyOrdersCount(dailyOrdersCount);
			}

			List<DBObject> courierList = (List<DBObject>) aggregatedDoc.get("courier_wise_orders");
			List<String> courierName = new ArrayList<>();
			List<Integer> courierCount = new ArrayList<>();
			if (courierList != null) {
				for (DBObject order : courierList) {
					courierName.add(courierDao.getCourierNameByKey((String) order.get("_id")));
					courierCount.add(((Number) order.get("count")).intValue());
				}
			}
			result.setCourierName(courierName);
			result.setCourierCount(courierCount);

			List<Object> zonesName = new ArrayList<>();
			List<Integer> zonesCount = new ArrayList<>();

			List<DBObject> ratezoneList = (List<DBObject>) aggregatedDoc.get("ratezone_wise_data");
			String jsArray = "";
			if (ratezoneList != null) {
				Map<String, Integer> mergedMap = mergeStates(ratezoneList);
				jsArray = generateGeoChartDataArray(mergedMap);
				jsArray = jsArray.replaceAll("\\\\", "");
			}
			result.setStatesWithCountArray(jsArray);

			List<Object> statusName = new ArrayList<>();
			List<Integer> statusCount = new ArrayList<>();

			List<DBObject> orderStatusList = (List<DBObject>) aggregatedDoc.get("order_status");
			if (orderStatusList != null) {
				int bookedCount = 0, holdCount = 0, intransitCount = 0, ofdCount = 0, deliveredCount = 0;
				// Set<String> intransitValues = new HashSet<>(Arrays.asList("119", "118", "114", "122", "124", "136", "137", "146", "128", "147", "154", "156"));
				// Updated groupings: Moved 128 to hold, 156 to RTO (handled separately), added other hold/delivered IDs
				Set<String> intransitValues = new HashSet<>(Arrays.asList("119", "118", "114", "122", "124", "136", "137", "146", "147", "154"));
				Set<String> holdValues = new HashSet<>(Arrays.asList("128", "149", "150", "151"));
				Set<String> deliveredValues = new HashSet<>(Arrays.asList("116", "163", "137"));
				
				Set<String> orderReceived = new HashSet<>(Arrays.asList("101", "104", "105"));
				for (DBObject order : orderStatusList) {
					String str1 = (String) order.get("_id");
					// if (str1.equals("116")) {
					// 	deliveredCount += ((Number) order.get("count")).intValue();
					// } else if (str1.equals("128")) {
					// 	holdCount += ((Number) order.get("count")).intValue();
					// }
					// Updated count logic for multiple IDs
					if (deliveredValues.contains(str1)) {
						deliveredCount += ((Number) order.get("count")).intValue();
					} else if (holdValues.contains(str1)) {
						holdCount += ((Number) order.get("count")).intValue();
					} else if (intransitValues.contains(str1)) {
						intransitCount += ((Number) order.get("count")).intValue();
					} else if (str1.equals("115")) {
						ofdCount += ((Number) order.get("count")).intValue();
					} else if (orderReceived.contains(str1)) {
						bookedCount += ((Number) order.get("count")).intValue();
					}

				}
				// List<String> statusList = Arrays.asList("Booked", "Hold", "In-Transit", "Out For Delivery", "Delivered", "RTO");
				// Renamed labels for consistency
				List<String> statusList = Arrays.asList("Booked", "Hold", "In-Transit", "Out for Delivery", "Delivered",
						"RTO Order");
				List<Integer> statusCountList = Arrays.asList(bookedCount, holdCount, intransitCount, ofdCount,
						deliveredCount, rtoCount);
				statusName.addAll(statusList);
				statusCount.addAll(statusCountList);
				result.setStatusName(statusName);
				result.setStatusCount(statusCount);
			}

		}

		return result;
	}

	private static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}

	private static boolean isSameWeek(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);

		return cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
	}

	private static Date getStartOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	private static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, days);
		return cal.getTime();
	}

	// function help to merge states with their alias names
	private static Map<String, String> createAliasMap() {
		Map<String, String> map = new HashMap<>();
		map.put("AP", "Andhra Pradesh");
		map.put("Arunachal", "Arunachal Pradesh");
		map.put("AR", "Arunachal Pradesh");
		map.put("Assam", "Assam");
		map.put("BR", "Bihar");
		map.put("Bihar", "Bihar");
		map.put("CH", "Chhattisgarh");
		map.put("Chhatisgarh", "Chhattisgarh");
		map.put("Goa", "Goa");
		map.put("GJ", "Gujarat");
		map.put("Guj", "Gujarat");
		map.put("HR", "Haryana");
		map.put("Haryana", "Haryana");
		map.put("HP", "Himachal Pradesh");
		map.put("Himachal", "Himachal Pradesh");
		map.put("Jh", "Jharkhand");
		map.put("JH", "Jharkhand");
		map.put("JK", "Jammu and Kashmir");
		map.put("Karnataka", "Karnataka");
		map.put("KA", "Karnataka");
		map.put("KL", "Kerala");
		map.put("Kerala", "Kerala");
		map.put("MP", "Madhya Pradesh");
		map.put("MH", "Maharashtra");
		map.put("Mumbai", "Maharashtra");
		map.put("MN", "Manipur");
		map.put("Manipur", "Manipur");
		map.put("Meghalaya", "Meghalaya");
		map.put("ML", "Meghalaya");
		map.put("Mizoram", "Mizoram");
		map.put("MZ", "Mizoram");
		map.put("Nagaland", "Nagaland");
		map.put("NL", "Nagaland");
		map.put("Odisha", "Odisha");
		map.put("OR", "Odisha");
		map.put("Punjab", "Punjab");
		map.put("PB", "Punjab");
		map.put("Rajasthan", "Rajasthan");
		map.put("RJ", "Rajasthan");
		map.put("SK", "Sikkim");
		map.put("Sikkim", "Sikkim");
		map.put("TN", "Tamil Nadu");
		map.put("TamilNadu", "Tamil Nadu");
		map.put("TS", "Telangana");
		map.put("TG", "Telangana");
		map.put("TR", "Tripura");
		map.put("Tripura", "Tripura");
		map.put("UP", "Uttar Pradesh");
		map.put("Uttarakhand", "Uttarakhand");
		map.put("UK", "Uttarakhand");
		map.put("WB", "West Bengal");
		map.put("WestBengal", "West Bengal");

		return map;
	}

	// generate states names and count with alias names
	public static Map<String, Integer> mergeStates(List<DBObject> inputList) {
		Map<String, Integer> merged = new LinkedHashMap<>();
		Map<String, String> aliasMap = createAliasMap();
		for (DBObject obj : inputList) {
			String key = obj.get("_id").toString().trim();
			int count = (int) obj.get("count");
			String normalized = aliasMap.getOrDefault(key, key);
			merged.put(normalized, merged.getOrDefault(normalized, 0) + count);
		}
		return merged;
	}

	// Convert a map to String useful in Chart
	public static String generateGeoChartDataArray(Map<String, Integer> mergedData) {
		StringBuilder builder = new StringBuilder();
		builder.append("[[\"State\",\"Count\"],");
		for (Map.Entry<String, Integer> entry : mergedData.entrySet()) {
			builder.append("[\"").append(entry.getKey()).append("\",").append(entry.getValue()).append("],");
		}
		if (builder.charAt(builder.length() - 1) == ',') {
			builder.setLength(builder.length() - 1);
		}
		builder.append("]");
		return builder.toString();
	}

}
