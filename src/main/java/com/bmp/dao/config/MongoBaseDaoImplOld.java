package com.bmp.dao.config;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.bson.BSONObject;
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
import com.bmp.model.app.utility.SmsMailMaster;
import com.bmp.model.base.MongoBaseBean;
import com.bmp.model.config.Organization;

public abstract class MongoBaseDaoImplOld<T extends MongoBaseBean> implements MongoBaseDao<T> {

	private List<Class> list = new ArrayList<Class>(25);
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

		// return this.mongoTemplate.findAll(classVal);
		// return this.mongoTemplateRead.findAll(classVal);

		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		return this.mongoTemplateRead.find(query, classVal);
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
		return list;
	}

	@Override
	public boolean isKeyExist(String id, final Class<T> classVal) {
		// return this.mongoTemplate.exists(new
		// Query(Criteria.where(ID_FIELD).is(id)),classVal);
		return this.mongoTemplateRead.exists(new Query(Criteria.where(ID_FIELD).is(id)), classVal);
	}

	@Override
	public boolean isObjectExist(Query query, final Class<T> classVal) {
		// return this.mongoTemplate.exists(query,classVal);
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
		// return this.mongoTemplate.findOne(new Query(Criteria.where(ID_FIELD).is(id)),
		// classVal);
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).is(id)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).is(id));
		}
		return this.mongoTemplateRead.findOne(query, classVal);
		// return this.mongoTemplateRead.findOne(new
		// Query(CritesessionUserBean.getOrganization()ria.where(ID_FIELD).is(id)),
		// classVal);

	}

	@Override
	public T getObjectById(String id, List<String> fieldList, final Class<T> classVal) {
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
		return this.mongoTemplateRead.findOne(query, classVal);
	}

	@Override
	public List<T> getObjectByQuery(Query query, final Class<T> classVal) {
		// return this.mongoTemplate.find(query, classVal);
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		}
		return this.mongoTemplateRead.find(query, classVal);
	}

	@Override
	public T removeObjectById(String id, final Class<T> classVal) {
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).is(id)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).is(id));
		}
		T t = this.mongoTemplate.findAndRemove(query, classVal);
		return t;
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
			t.setOrganizationKey(sessionUserBean.getOrganization().getKey());
		}
		mongoTemplate.insert(tl, classVal);
	}

	@Override
	@Transactional
	public void delete(List<T> tl, final Class<T> classVal) {
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
		List<T> list = new ArrayList<T>();
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where(ID_FIELD).in(ids)
					.and("organizationKey").is(sessionUserBean.getOrganization().getKey()));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).in(ids));
		}
		try {
			// list.addAll(this.mongoTemplate.find(query, classVal));
			list.addAll(this.mongoTemplateRead.find(query, classVal));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * for (String key : ids) {
		 * try {
		 * T t = this.mongoTemplate.findOne(new Query(Criteria.where(ID_FIELD).is(key)),
		 * classVal);
		 * list.add(t);
		 * } catch (Exception e) {
		 * e.printStackTrace();
		 * }
		 * }
		 */
		return list;
	}

	@Override
	public List<T> getObjectListByIds(final List<String> ids, List<String> fieldList, final Class<T> classVal) {
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
		return list;
	}

	@Override
	@Transactional
	public int remove(final String id, final Class<T> classVal) {
		try {
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
		List<T> list = this.mongoTemplateRead.find(query, classVal);
		for (T t : list) {
			idList.add(t.getKey_s());
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
		// List<? extends MongoBaseBean> list = this.mongoTemplate.find(query,
		// classVal);
		List<? extends MongoBaseBean> list = this.mongoTemplateRead.find(query, classVal);
		for (MongoBaseBean t : list) {
			idList.add(t.getKey_s());
		}
		return idList;
	}

	@Override
	public Object getObject(String id, Class<? extends MongoBaseBean> classVal) throws Exception {
		// return this.mongoTemplate.findOne(new Query(Criteria.where(ID_FIELD).is(id)),
		// classVal);
		Query query = new Query();
		if (isOrganizationQueryApplied(classVal, query)) {
			query.addCriteria(Criteria.where("organizationKey").is(sessionUserBean.getOrganization().getKey())
					.and(ID_FIELD).is(id));
		} else {
			query.addCriteria(Criteria.where(ID_FIELD).is(id));
		}
		return this.mongoTemplateRead.findOne(query, classVal);
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
		// Case-1 If already organization query applied then ignore.
		if (query.getQueryObject().containsKey("organizationKey")) {
			return false;
		}
		if (list.contains(className)) {
			return false;
		}
		return true;
	}

	{
		list.add(NumberMetadata.class);
		list.add(Role.class);
		list.add(SmsMailMaster.class);
		list.add(VendorStatusMappingBean.class);
		list.add(BulkHeader.class);
		list.add(BulkMaster.class);
		list.add(BulkValidation.class);
		list.add(Settings.class);
		list.add(City.class);
		list.add(State.class);
		list.add(Country.class);
		list.add(Pincode.class);
		list.add(PincodeDirectory.class);
		list.add(RateZone.class);
		list.add(ReportMaster.class);
		list.add(StatusFlow.class);
		list.add(StatusMaster.class);
		list.add(StatusTransition.class);
		list.add(ProductType.class);
		list.add(CashQuery.class);
	}
}

