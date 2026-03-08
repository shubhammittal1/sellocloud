package com.bmp.dao;

import java.util.List;

import com.bmp.model.base.BaseBean;
import com.bmp.model.common.RiakContinuationObject;

public interface GenericMasterDao<T extends BaseBean> {
	boolean checkRiakConnection() throws Exception;

	String getBucketProperties(String bucketName) throws Exception;

	T getEntityByLocationKey(String key, Class<T> classVal) throws Exception;
	
	List<T> getEntityByLocationKey(List<String> key, Class<T> classVal) throws Exception;

	int updateEntity(T t, String objectKey) throws Exception;

	int updateEntity(T t) throws Exception;

	int deleteEntity(String key, Class<T> classVal) throws Exception;

	int saveEntity(final T t) throws Exception;

	List<T> getEntityByIndexedKey(String indexedField, String keyObject,
			Class<T> classVal) throws Exception;

	List<T> getAllEntities(Class<T> classVal) throws Exception;

	List<T> getEntityByIndexedKey(String indexedField, Class<T> classVal,
			String from, String to,
			RiakContinuationObject riakContinuationObject) throws Exception;
	
	List<String> getAllKeys(final Class<T> classVal) throws Exception;
}
