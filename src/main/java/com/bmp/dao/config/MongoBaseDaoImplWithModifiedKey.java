package com.bmp.dao.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Transactional;

import com.basho.riak.client.core.RiakNode.State;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.MessageConstant;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.bulk.BulkHeader;
import com.bmp.model.app.bulk.BulkMaster;
import com.bmp.model.app.bulk.BulkValidation;
import com.bmp.model.app.config.Settings;
import com.bmp.model.app.facility.Role;
import com.bmp.model.app.facility.User;
import com.bmp.model.app.masters.City;
import com.bmp.model.app.masters.Country;
import com.bmp.model.app.masters.Pincode;
import com.bmp.model.app.masters.PincodeDirectory;
import com.bmp.model.app.masters.ProductType;
import com.bmp.model.app.masters.RateZone;
import com.bmp.model.app.report.ReportMaster;
import com.bmp.model.app.saleorder.CashQuery;
import com.bmp.model.app.status.StatusFlow;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.app.status.StatusTransition;
import com.bmp.model.app.systemCalling.NumberMetadata;
import com.bmp.model.app.utility.AlertMaster;
import com.bmp.model.app.utility.SmsMailMaster;
import com.bmp.model.base.MongoBaseBean;

public abstract class MongoBaseDaoImplWithModifiedKey<T extends MongoBaseBean> implements MongoBaseDao<T> {

	private List<Class> classList = new ArrayList<Class>(25);
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	@Qualifier("mongoTemplateRead")
	private MongoTemplate mongoTemplateRead;

	@Autowired
	private MessageSource messageSource;

	private static final String ID_FIELD = "_id";

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void setMongoTemplateRead(MongoTemplate mongoTemplateRead) {
		this.mongoTemplateRead = mongoTemplateRead;
	}

	@Override
	public List<T> getAllObjects(final Class<T> classVal) {
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		return removeOrganizationKeyFromObjectKey(this.mongoTemplateRead.find(query, classVal));
	}

	@Override
	public List<T> getAllObjects(List<String> fieldList, final Class<T> classVal) {
		List<T> list = new ArrayList<T>();
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		for (String string : fieldList) {
			query.fields().include(string);
		}
		// list.addAll(this.mongoTemplate.find(query, classVal));
		list.addAll(this.mongoTemplateRead.find(query, classVal));
		return removeOrganizationKeyFromObjectKey(list);
	}

	@Override
	public boolean isKeyExist(String id, final Class<T> classVal) {
		id = appendOrganizationKey(id);
		return this.mongoTemplateRead.exists(new Query(Criteria.where(ID_FIELD).is(id)), classVal);
	}

	@Override
	public boolean isObjectExist(Query query, final Class<T> classVal) {
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		return this.mongoTemplateRead.exists(query, classVal);
	}

	@Override
	public int saveObject(T object, final Class<T> classVal) throws Exception {
		try {

			Class<T> obj = classVal;
			if (!obj.isAnnotationPresent(AssignKey.class)) {
				throw new NoSuchElementException(
						messageSource.getMessage(MessageConstant.ANNOTATION_NOT_PRESENT, null, null)
								+ classVal.getName());
			}

			if (obj.getAnnotation(AssignKey.class).assvalue()) {
				String keyObject = Id.next().toString();
				object.setKey_s(keyObject);
			}

			Date date = new Date();
			object.setCreatedDate_l(date.getTime());
			object.setModifiedDate_l(date.getTime());
			object.setLastRefreshTime(date.getTime());
			User user = null;
			try {
				user = sessionUserBean.getUser();
			} catch (Exception e) {
			}
			if (user != null) {
				object.setCreatedBy(user.getKey_s());
			}
			// Set Origination key
			object.setOrganizationKey(sessionUserBean.getOrganization().getKey());

			if (sessionUserBean.getOrganization().getKey() != null) {
				object.setKey_s(object.getKey_s() + "_" + sessionUserBean.getOrganization().getKey());
			}
			this.mongoTemplate.save(object);
			return GlobalConstant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return GlobalConstant.ERROR;
		}
	}

	@Override
	public int updateObject(T object) {
		try {
			if (object.getKey_s() == null) {
				Class<T> classVal = (Class<T>) object.getClass();
				Class<T> obj = classVal;
				if (!obj.isAnnotationPresent(AssignKey.class)) {
					throw new NoSuchElementException(
							messageSource.getMessage(MessageConstant.ANNOTATION_NOT_PRESENT, null, null)
									+ classVal.getName());
				}

				if (obj.getAnnotation(AssignKey.class).assvalue()) {
					String keyObject = Id.next().toString();
					object.setKey_s(keyObject);
				}
			}

			Date date = new Date();
			if (object.getCreatedDate_l() == null) {
				object.setCreatedDate_l(date.getTime());
			}
			object.setModifiedDate_l(date.getTime());
			object.setLastRefreshTime(date.getTime());

			User user = null;
			try {
				user = sessionUserBean.getUser();
			} catch (Exception e) {
			}
			if (user != null) {
				if (object.getCreatedBy() == null) {
					object.setCreatedBy(user.getKey_s());
				}
				object.setUpdatedBy(user.getKey_s());
			}

			this.mongoTemplate.save(object);
			return GlobalConstant.SUCCESS;
		} catch (Exception e) {
			return GlobalConstant.ERROR;
		}
	}

	@Override
	public T getObjectById(String id, final Class<T> classVal) {
		id = appendOrganizationKey(id);
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).is(id)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).is(id));
		}
		return removeOrganizationKeyFromObjectKey(this.mongoTemplateRead.findOne(query, classVal));
	}

	@Override
	public T getObjectById(String id, List<String> fieldList, final Class<T> classVal) {
		id = appendOrganizationKey(id);
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).is(id)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).is(id));
		}
		for (String field : fieldList) {
			query.fields().include(field);
		}
		// return this.mongoTemplate.findOne(query, classVal);
		return removeOrganizationKeyFromObjectKey(this.mongoTemplateRead.findOne(query, classVal));
	}

	@Override
	public List<T> getObjectByQuery(Query query, final Class<T> classVal) {
		// return this.mongoTemplate.find(query, classVal);
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		return removeOrganizationKeyFromObjectKey(this.mongoTemplateRead.find(query, classVal));
	}

	@Override
	public T removeObjectById(String id, final Class<T> classVal) {
		id = appendOrganizationKey(id);
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).is(id)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).is(id));
		}

		T t = this.mongoTemplate.findOne(query, classVal);
		this.mongoTemplate.remove(t);
		return appendOrganizationKeyInObjectKey(t);
	}

	@Override
	public int getAllObjectCount(final Class<T> classVal) {
		// int totalCount = (int) this.mongoTemplate.count(new Query(), classVal);
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		int totalCount = (int) this.mongoTemplateRead.count(query, classVal);
		return totalCount;
	}

	@Override
	public int getObjectCount(Query query, final Class<T> classVal) {
		// int totalCount = (int) this.mongoTemplate.count(query, classVal);
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		int totalCount = (int) this.mongoTemplateRead.count(query, classVal);
		return totalCount;
	}

	@Override
	public String findLastIdInCollection(final Class<T> classVal) {
		// return this.mongoTemplate.findOne(new Query().with(new
		// Sort(Direction.DESC,ID_FIELD)), classVal).getKey_s();
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		query.with(Sort.by(Direction.DESC, ID_FIELD));
		return this.mongoTemplateRead.findOne(query, classVal).getKey_s();
	}

	@Override
	public void bulkCreate(List<T> tl, final Class<T> classVal) {
		for (T t : tl) {
			t.setKey_s(t.getKey_s() + "_" + sessionUserBean.getOrganization().getKey());
			t.setOrganizationKey(sessionUserBean.getOrganization().getKey());
		}
		mongoTemplate.insert(tl, classVal);
	}

	@Override
	@Transactional
	public void delete(List<T> tl, final Class<T> classVal) {
		for (T t : tl) {
			t.setKey_s(t.getKey_s() + "_" + sessionUserBean.getOrganization().getKey());
		}
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).in(tl)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).in(tl));
		}
		this.mongoTemplate.remove(new Query(Criteria.where(ID_FIELD).in(tl)), classVal);
	}

	@Override
	public List<T> getObjectListByIds(final List<String> ids, final Class<T> classVal) {
		for (String id : ids) {
			id = appendOrganizationKey(id);
		}
		List<T> list = new ArrayList<T>();
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).in(ids)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).in(ids));
		}
		try {
			list.addAll(this.mongoTemplateRead.find(query, classVal));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return removeOrganizationKeyFromObjectKey(list);
	}

	@Override
	public List<T> getObjectListByIds(final List<String> ids, List<String> fieldList, final Class<T> classVal) {
		for (String id : ids) {
			id = appendOrganizationKey(id);
		}
		List<T> list = new ArrayList<T>();
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).in(ids)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).in(ids));
		}
		if (fieldList != null && !fieldList.isEmpty()) {
			for (String field : fieldList) {
				query.fields().include(field);
			}
		}
		try {
			// list.addAll(this.mongoTemplate.find(query, classVal));
			list.addAll(this.mongoTemplateRead.find(query, classVal));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return removeOrganizationKeyFromObjectKey(list);
	}

	@Override
	@Transactional
	public int remove(String id, final Class<T> classVal) {
		try {
			id = appendOrganizationKey(id);
			Query query = new Query();
			if (isOrganizationQueryApplied(classVal, query)) {
				query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey())
						.and(ID_FIELD).is(id));
			} else {
				query.addCriteria(Criteria.where(ID_FIELD).is(id));
			}
			this.mongoTemplate.remove(query, classVal);

			return GlobalConstant.SUCCESS;
		} catch (Exception e) {
			return GlobalConstant.ERROR;
		}
	}

	@Override
	public List<String> getObjectsIdList(Query query, final Class<T> classVal) {
		List<String> idList = new ArrayList<>();
		query.fields().include(ID_FIELD);
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		// List<T> list = this.mongoTemplate.find(query, classVal);
		List<T> list = removeOrganizationKeyFromObjectKey(this.mongoTemplateRead.find(query, classVal));
		for (T t : list) {
			idList.add(t.getKey_s().split("_")[0]);
		}
		return idList;
	}

	@Override
	public List<String> getKeys(Query query, Class<? extends MongoBaseBean> classVal) throws Exception {
		List<String> idList = new ArrayList<>();
		query.fields().include(ID_FIELD);
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		List<? extends MongoBaseBean> list = this.mongoTemplateRead.find(query, classVal);
		for (MongoBaseBean t : list) {
			idList.add(t.getKey_s().split("_")[0]);
		}
		return idList;
	}

	@Override
	public Object getObject(String id, Class<? extends MongoBaseBean> classVal) throws Exception {
		id = appendOrganizationKey(id);
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey())
					.and(ID_FIELD).is(id));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).is(id));
		}
		Object object = this.mongoTemplateRead.findOne(query, classVal);
		if (object instanceof MongoBaseBean) {
			MongoBaseBean bean = (MongoBaseBean) object;
			bean.setKey_s(bean.getKey_s().split("_")[0]);
		}
		return object;
	}

	@Override
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@Override
	public int updateMultiple(Query query, Update update, final Class<T> classVal) throws Exception {
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		this.mongoTemplate.updateMulti(query, update, classVal);
		return GlobalConstant.SUCCESS;

	}

	public boolean isOrganizationQueryApplied(Class className, Query query) {
		if (query.getQueryObject().containsKey("organizationKey")) {
			return false;
		}
		if (classList.contains(className)) {
			return false;
		}
		return true;
	}

	public String appendOrganizationKey(String key) {
		if (sessionUserBean.getOrganization().getKey() == null) {
			return key;
		}
		return key = key + "_" + sessionUserBean.getOrganization().getKey();
	}

	public List<T> appendOrganizationKeyInObjectKey(List<T> list) {
		if (sessionUserBean.getOrganization().getKey() == null
				|| list == null || list.isEmpty()) {
			return list;
		}
		for (T t : list) {
			t.setKey_s(t.getKey_s() + "_" + sessionUserBean.getOrganization().getKey());
		}
		return list;
	}

	public T appendOrganizationKeyInObjectKey(T t) {
		if (sessionUserBean.getOrganization().getKey() == null) {
			return t;
		}
		t.setKey_s(t.getKey_s() + "_" + sessionUserBean.getOrganization().getKey());
		return t;
	}

	public List<T> removeOrganizationKeyFromObjectKey(List<T> list) {
		if (sessionUserBean.getOrganization().getKey() == null
				|| list == null || list.isEmpty()) {
			return list;
		}
		for (T t : list) {
			t.setKey_s(t.getKey_s().split("_")[0]);
		}
		return list;
	}

	public T removeOrganizationKeyFromObjectKey(T t) {
		if (sessionUserBean.getOrganization().getKey() == null || t == null) {
			return t;
		}
		t.setKey_s(t.getKey_s().split("_")[0]);
		return t;
	}

	{
		classList.add(NumberMetadata.class);
		classList.add(Role.class);
		classList.add(AlertMaster.class);
		classList.add(SmsMailMaster.class);
		classList.add(VendorStatusMappingBean.class);
		classList.add(BulkHeader.class);
		classList.add(BulkMaster.class);
		classList.add(BulkValidation.class);
		classList.add(Settings.class);
		classList.add(City.class);
		classList.add(State.class);
		classList.add(Country.class);
		classList.add(Pincode.class);
		classList.add(PincodeDirectory.class);
		classList.add(RateZone.class);
		classList.add(ReportMaster.class);
		classList.add(StatusFlow.class);
		classList.add(StatusMaster.class);
		classList.add(StatusTransition.class);
		classList.add(ProductType.class);
	}

}

