package com.bmp.oms.service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.SaleOrderExtraDao;
import com.bmp.dao.SettingsDao;
import com.bmp.dao.VendorStatusMappingDao;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderExtra;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.logger.AsyncLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

@Service
@Qualifier("dbBackupService")
public class DbBackupService {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;

	@Autowired
	@Qualifier("settingsDaoImpl")
	SettingsDao settingsDao;

	@Autowired
	@Qualifier("vendorStatusMappingDaoImpl")
	private VendorStatusMappingDao vendorStatusMappingDao;

	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;

	@Autowired
	@Qualifier("saleOrderExtraDaoImpl")
	private SaleOrderExtraDao saleOrderExtraDao;

	public List<String> getAllKeys(String collectionName) {
		List<String> keyList = new ArrayList<>();
		try {
			MongoTemplate mongoTemplate = settingsDao.getMongoTemplate();
			MongoCollection<Document> dbCollection = mongoTemplate.getCollection(collectionName);
			Document projection = new Document("_id", 1);

			Iterator<Document> irerator = dbCollection.find().projection(projection).iterator();
			while (irerator.hasNext()) {
				Document object = irerator.next();
				keyList.add(object.get("_id").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyList;
	}

	public ResponseBean ceateDbBackup() {
		ResponseBean responseBean = new ResponseBean();
		String backupPath = messageSource.getMessage(GlobalConstant.DB_BACKUP_PATH, null, null).trim();
		backupPath += CommonUtility.convertCurrentDateToDDMMYYYY(new Date()) + "/";
		File file = new File(backupPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		try {
			VendorStatusMappingBean collectionMapping = vendorStatusMappingDao.getObjectById("DB_BACKUP_MAPPING",
					VendorStatusMappingBean.class);
			if (collectionMapping == null || collectionMapping.getStatusMap() == null
					|| collectionMapping.getStatusMap().isEmpty()) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Collection mapping is not found");
				return responseBean;
			}
			for (Entry<String, String> entry : collectionMapping.getStatusMap().entrySet()) {
				if (entry.getKey() == null || "".equals(entry.getKey().trim())) {
					continue;
				}

				List<String> keys = getAllKeys(entry.getKey().trim());
				if (keys == null || keys.isEmpty()) {
					continue;
				}

				String path = backupPath + entry.getKey() + "/";
				file = new File(path);
				if (!file.exists()) {
					file.mkdirs();
				}

				Iterator<String> iterator = keys.iterator();
				ObjectMapper objectMapper = new ObjectMapper();

				MongoTemplate mongoTemplate = settingsDao.getMongoTemplate();
				MongoCollection<Document> dbCollection = mongoTemplate.getCollection(entry.getKey().trim());
				BasicDBObject basicDBObject = new BasicDBObject();
				int cout = 0;
				StringBuffer copyError = new StringBuffer();
				while (iterator.hasNext()) {
					try {
						String key = iterator.next();
						basicDBObject.put("_id", key);
						List<Document> objectList = new ArrayList<>();
						dbCollection.find(basicDBObject).into(objectList);
						if (objectList != null && !objectList.isEmpty()) {
							String objJson = objectMapper.writeValueAsString(objectList.get(0));
							writeObjectInFile(objJson, key, path);
							logger.info(String.class, entry.getKey() + " -----> " + cout++ + "/" + keys.size());
						} else {
							copyError.append(key + "\n");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (copyError.length() > 0) {
					writeObjectInFile(copyError.toString(), "error", path);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}

	public ResponseBean backupSaleOrder() {
		ResponseBean responseBean = new ResponseBean();
		try {
			Calendar calFrom = Calendar.getInstance();
			calFrom.add(Calendar.DATE, -90);
			Calendar calTo = Calendar.getInstance();

			Query query = new Query();
			query.fields().include("_id");
			query.addCriteria(
					Criteria.where("createdDate_l").gte(calFrom.getTimeInMillis()).lte(calTo.getTimeInMillis()));
			List<String> keys = saleOrderDao.getKeys(query, SaleOrder.class);
			if (keys == null || keys.isEmpty()) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage("Not Keys found : please check query");
				return responseBean;
			}

			String saleOrderPath = messageSource.getMessage(GlobalConstant.DB_BACKUP_PATH, null, null).trim();
			saleOrderPath += CommonUtility.convertCurrentDateToDDMMYYYY(new Date()) + "/saleOrder/";
			File file = new File(saleOrderPath);
			if (!file.exists()) {
				file.mkdirs();
			}

			String saleOrderExtraPath = messageSource.getMessage(GlobalConstant.DB_BACKUP_PATH, null, null).trim();
			saleOrderExtraPath += CommonUtility.convertCurrentDateToDDMMYYYY(new Date()) + "/saleOrderExtra/";
			file = new File(saleOrderExtraPath);
			if (!file.exists()) {
				file.mkdirs();
			}

			ObjectMapper objectMapper = new ObjectMapper();
			int count = 0;
			StringBuffer saleOrderError = new StringBuffer();
			StringBuffer saleOrderExtraError = new StringBuffer();
			for (String key : keys) {
				try {
					logger.info(SaleOrder.class, "saleOrder backup count -----> " + count++ + "/" + keys.size());

					SaleOrder saleOrder = saleOrderDao.getObjectById(key, SaleOrder.class);
					if (saleOrder == null) {
						saleOrderError.append(key + "\n");
						continue;
					}
					String jsonString = objectMapper.writeValueAsString(saleOrder);
					writeObjectInFile(jsonString, key, saleOrderPath);

					// SaleOrderExtra Backup
					SaleOrderExtra orderExtra = saleOrderExtraDao.getObjectById(key, SaleOrderExtra.class);
					if (orderExtra == null) {
						saleOrderExtraError.append(key + "\n");
						continue;
					}
					jsonString = objectMapper.writeValueAsString(orderExtra);
					writeObjectInFile(jsonString, key, saleOrderExtraPath);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (saleOrderError.length() > 0) {
				writeObjectInFile(saleOrderError.toString(), "error", saleOrderPath);
			}
			if (saleOrderExtraError.length() > 0) {
				writeObjectInFile(saleOrderExtraError.toString(), "error", saleOrderExtraPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}

	public void writeObjectInFile(String object, String key, String path) {
		File file = new File(path + key + ".txt");
		FileWriter fr = null;
		try {
			fr = new FileWriter(file);
			fr.write(object);
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
