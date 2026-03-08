package com.bmp.dao.config;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.bmp.model.base.MongoBaseBean;

public interface MongoBaseDao<T extends MongoBaseBean> {

	public int saveObject(T object,final Class<T> classVal) throws Exception;
	public int updateObject(T object) throws Exception;
	public List<T> getAllObjects(final Class<T> classVal);
	public List<T> getAllObjects( List<String> fieldList, final Class<T> classVal);
	public T getObjectById(String id,final Class<T> classVal) throws Exception;
	public T getObjectById(String id,List<String> fieldList,final Class<T> classVal) throws Exception;
	public T removeObjectById(String id, final Class<T> classVal) throws Exception;
	public int getAllObjectCount(final Class<T> classVal) throws Exception;
	
	public List<T> getObjectByQuery(Query query,final Class<T> classVal);
	public String findLastIdInCollection(final Class<T> classVal);
	public void bulkCreate(List<T> tl, Class<T> classVal);
	public void delete(List<T> tl, Class<T> classVal);
	public List<T> getObjectListByIds(final List<String> ids, final Class<T> classVal) throws Exception;
	public List<T> getObjectListByIds(final List<String> ids, List<String> fieldList, final Class<T> classVal) throws Exception;
	public int remove(String id, final Class<T> classVal) throws Exception;
	
	public boolean isKeyExist(String id, final Class<T> classVal) throws Exception;
	public int getObjectCount(Query query, Class<T> classVal);
	public List<String> getObjectsIdList(Query query, Class<T> classVal);
	public List<String> getKeys(Query query, Class<? extends MongoBaseBean> classVal) throws Exception;
	public Object getObject(String id, Class<? extends MongoBaseBean> classVal) throws Exception;
	public MongoTemplate getMongoTemplate();
	public boolean isObjectExist(Query query, Class<T> classVal);
	public int updateMultiple(Query query, Update update, final Class<T> classVal) throws Exception;
}
