package com.bmp.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.indexes.BinIndexQuery;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.ListKeys;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.api.commands.kv.UpdateValue;
import com.basho.riak.client.api.commands.kv.UpdateValue.Update;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.operations.FetchBucketPropsOperation;
import com.basho.riak.client.core.query.BucketProperties;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.query.RiakObject;
import com.basho.riak.client.core.query.indexes.LongIntIndex;
import com.basho.riak.client.core.query.indexes.StringBinIndex;
import com.basho.riak.client.core.util.BinaryValue;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.BucketConstants;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.MessageConstant;
import com.bmp.dao.GenericMasterDao;
import com.bmp.dao.config.BaseDaoImpl;
import com.bmp.dao.config.Id;
import com.bmp.model.app.facility.User;
import com.bmp.model.base.BaseBean;
import com.bmp.model.common.RiakContinuationObject;
import com.bmp.model.config.BaseBucketModel;
import com.bmp.model.config.BucketModelFactory;
import com.bmp.riak.config.RiakClientFactory;
import com.bmp.utility.logger.AsyncLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
@Qualifier("genericMasterDaoImpl")
public class GenericMasterDaoImpl<T extends BaseBean> implements GenericMasterDao<T>{

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired
	private RiakClientFactory riakClientFactory;
	
	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;

	@Autowired
	private MessageSource messageSource;

	@SuppressWarnings("rawtypes")
	private static Class loggerClass = BaseDaoImpl.class;

	@Override
	public boolean checkRiakConnection() throws Exception {
		RiakClient riakClient = riakClientFactory.getRiakClient();
		if (riakClient != null) {
			return true;
		}
		return false;
	}

	@Override
	public String getBucketProperties(final String bucketName) throws Exception {
		try {
			RiakCluster riakCluster = riakClientFactory.getRiakCluster();
			Namespace testType = new Namespace(bucketName);
			FetchBucketPropsOperation fetchProps = new FetchBucketPropsOperation.Builder(
					testType).build();
			riakCluster.execute(fetchProps);

			BucketProperties props = fetchProps.get().getBucketProperties();
			return props.toString();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@Override
	public T getEntityByLocationKey(final String key, final Class<T> classVal)
			throws Exception {
		BaseBucketModel baseBucketModel = BucketModelFactory
				.getCustomBucketModel(classVal);
		Location location = new Location(new Namespace(
				baseBucketModel.getBucketType(),
				baseBucketModel.getBucketName()), key);
		T t = getEntityByLocationKey(location, classVal);
		if (t != null) {
			t.setKey_s(key);
		}
		return t;
	}

	@Override
	public List<T> getEntityByLocationKey(final List<String> keys, final Class<T> classVal) throws Exception {
		List<T> list = new ArrayList<T>();
		for (String key : keys) {
			try {
				BaseBucketModel baseBucketModel = BucketModelFactory.getCustomBucketModel(classVal);
				Location location = new Location(new Namespace(baseBucketModel.getBucketType(),baseBucketModel.getBucketName()), key);
				T t = getEntityByLocationKey(location, classVal);
				if (t != null) {
					t.setKey_s(key);
				}
				list.add(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	private T getEntityByLocationKey(final Location location,final Class<T> classVal) throws Exception {
		RiakClient riakClient = riakClientFactory.getRiakClient();
		FetchValue fetchOp = new FetchValue.Builder(location).build();
		RiakObject fetchedObject;
		T t = null;
		try {
			fetchedObject = riakClient.execute(fetchOp).getValue(RiakObject.class);
			if (fetchedObject != null) {
				String data = fetchedObject.getValue().toStringUtf8().replaceAll("\\p{Cc}", "");
				//logger.info(loggerClass, data);
				ObjectMapper mapper = new ObjectMapper();
				t = mapper.readValue(data, classVal);
			} else {
				logger.info(loggerClass, messageSource.getMessage(
						MessageConstant.RECORD_NOT_FOUND, null, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(messageSource.getMessage(
					MessageConstant.ERROR_FETCHING, null, null), e);
		}
		return t;
	}

	@Override
	public int updateEntity(final T t) throws Exception {
		if (t.getKey_s() != null) {
			User user = sessionUserBean.getUser();
			if(user != null){
				t.setUpdatedBy(user.getKey_s());
			}
			return updateEntity(t, t.getKey_s());
		}
		return GlobalConstant.ERROR;
	}

	@Override
	public int updateEntity(final T t, final String objectKey) throws Exception {
		try {
			BaseBucketModel baseBucketModel = BucketModelFactory.getCustomBucketModel(t.getClass());
			t.setModifiedDate_l(new Date().getTime());
			t.setLastRefreshTime(new Date().getTime());
			Location location = new Location(new Namespace(baseBucketModel.getBucketType(),baseBucketModel.getBucketName()), objectKey);
			RiakClient riakClient = riakClientFactory.getRiakClient();
			String json = new ObjectMapper().writeValueAsString(t);
			RiakObject obj = new RiakObject().setContentType(GlobalConstant.APPLICATION_JSON).setValue(BinaryValue.create(json));
			StoreValue store = new StoreValue.Builder(obj).withLocation(location).build();
			final RiakObject finalEntity = obj;
			// TODO need to see different update methods for new riak release (2.0.7)
			UpdateValue updateOp = new UpdateValue.Builder(location)
				.withFetchOption(FetchValue.Option.DELETED_VCLOCK, true)
				.withUpdate(Update.clobberUpdate(store))
				.withUpdate(new UpdateValue.Update<RiakObject>() {
					@Override
					public RiakObject apply(final RiakObject original) {
						return finalEntity;
					}
				}).build();
			riakClient.execute(updateOp).getValue(RiakObject.class);
			return GlobalConstant.SUCCESS;
		} catch (ExecutionException | InterruptedException
				| JsonProcessingException e) {
			e.printStackTrace();
		}
		return GlobalConstant.ERROR;
	}

	@Override
	public int deleteEntity(final String key, final Class<T> classVal) throws Exception {
		try {
			RiakClient riakClient = riakClientFactory.getRiakClient();
			BaseBucketModel baseBucketModel = BucketModelFactory
					.getCustomBucketModel(classVal);
			Namespace namespace = new Namespace(
					baseBucketModel.getBucketType(),
					baseBucketModel.getBucketName());
			Location quoteObjectLocation = new Location(namespace, key);
			DeleteValue deleteOp = new DeleteValue.Builder(quoteObjectLocation)
					.build();
			riakClient.execute(deleteOp);
			return GlobalConstant.SUCCESS;
		} catch (ExecutionException | InterruptedException e) {
			throw new Exception("DAO", e);
		}
	}

//	protected abstract void addIndexes(final RiakObject obj, final T t) throws Exception;

	@Override
	public int saveEntity(final T t) throws Exception {
		RiakClient riakClient = riakClientFactory.getRiakClient();
		String json = null;
		String keyObject = null;
		BaseBucketModel baseBucketModel = BucketModelFactory
				.getCustomBucketModel(t.getClass());
		if (baseBucketModel.getKeyAssignmentType() == BucketConstants.NOT_ASSIGNED) {
			keyObject = Id.next().toString();
			t.setKey_s(keyObject);
		} else {
			keyObject = t.getKey_s();
		}
		try {
			Date  date  = new Date();
			t.setCreatedDate_l(date.getTime());
			t.setModifiedDate_l(date.getTime());
			t.setLastRefreshTime(date.getTime());
			User user = sessionUserBean.getUser();
			if(user != null){
				t.setCreatedBy(user.getKey_s());
			}
			Location location = new Location(new Namespace(baseBucketModel.getBucketType(),baseBucketModel.getBucketName()), keyObject);
			json = new ObjectMapper().writeValueAsString(t);
			RiakObject obj = new RiakObject().setContentType(GlobalConstant.APPLICATION_JSON).setValue(BinaryValue.create(json));
			StoreValue store = new StoreValue.Builder(obj).withLocation(location).build();
			if (t.getExpired_b() != null) {
				obj.getIndexes().getIndex(StringBinIndex.named("isExpired")).add(t.getExpired_b().toString());
			}
			if (t.getLastRefreshTime() != null) {
				obj.getIndexes().getIndex(LongIntIndex.named("lastRefreshTime")).add(t.getLastRefreshTime());
			}
//			addIndexes(obj, t);
			logger.info(loggerClass, "key = " + keyObject + " Bucket Type = "
					+ baseBucketModel.getBucketType() + " Bucket Name = "
					+ baseBucketModel.getBucketName());
			riakClient.execute(store);
		} catch (JsonProcessingException e) {
			throw new Exception("DAO", e);
		} catch (ExecutionException e) {
			throw new Exception("DAO", e);
		} catch (InterruptedException e) {
			throw new Exception("DAO", e);
		}
		return GlobalConstant.SUCCESS;
	}

	@Override
	public List<T> getEntityByIndexedKey(final String indexedField,
			final String keyObject, final Class<T> classVal) throws Exception {
		BaseBucketModel baseBucketModel = BucketModelFactory.getCustomBucketModel(classVal);
		Namespace namespace = new Namespace(baseBucketModel.getBucketType(),baseBucketModel.getBucketName());
		List<T> entityList = new ArrayList<T>();
		RiakClient riakClient = riakClientFactory.getRiakClient();
		try {
			BinIndexQuery biq = new BinIndexQuery.Builder(namespace,indexedField, keyObject).build();
			BinIndexQuery.Response response = riakClient.execute(biq);
			List<BinIndexQuery.Response.Entry> entries = response.getEntries();
			for (BinIndexQuery.Response.Entry entry : entries) {
				Location location = entry.getRiakObjectLocation();
				T entity = getEntityByLocationKey(location, classVal);
				String keyVal = entry.getRiakObjectLocation().getKey().toString();
				entity.setKey_s(keyVal);
				entityList.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("DAO", e);
		}
		return entityList;
	}

	@Override
	public List<T> getAllEntities(final Class<T> classVal) throws Exception {
		List<T> entityList = new ArrayList<T>();
		BaseBucketModel baseBucketModel = BucketModelFactory.getCustomBucketModel(classVal);
		RiakClient riakClient = riakClientFactory.getRiakClient();
		Namespace ns = new Namespace(baseBucketModel.getBucketType(), baseBucketModel.getBucketName());
		ListKeys lk = new ListKeys.Builder(ns).build();
		ListKeys.Response response;
		try {
			response = riakClient.execute(lk);
			for (Location l : response) {
				logger.debug(loggerClass, l.getKeyAsString());
				T entity = getEntityByLocationKey(l, classVal);
				if (entity != null) {
					entity.setKey_s(l.getKeyAsString());
				}
				entityList.add(entity);
			}
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
		return entityList;
	}
	
	@Override
	public List<String> getAllKeys(final Class<T> classVal) throws Exception {
		List<String> entityList = new ArrayList<String>();
		BaseBucketModel baseBucketModel = BucketModelFactory.getCustomBucketModel(classVal);
		RiakClient riakClient = riakClientFactory.getRiakClient();
		Namespace ns = new Namespace(baseBucketModel.getBucketType(), baseBucketModel.getBucketName());
		ListKeys lk = new ListKeys.Builder(ns).build();
		ListKeys.Response response;
		try {
			response = riakClient.execute(lk);
			for (Location l : response) {
				logger.debug(loggerClass, l.getKeyAsString());
				entityList.add(l.getKeyAsString());
			}
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
		return entityList;
	}

	@Override
	public List<T> getEntityByIndexedKey(final String indexedField,
			final Class<T> classVal, final String from, final String to,
			final RiakContinuationObject riakContinuationObject)
			throws Exception {
		BaseBucketModel baseBucketModel = BucketModelFactory
				.getCustomBucketModel(classVal);
		Namespace namespace = new Namespace(baseBucketModel.getBucketType(),
				baseBucketModel.getBucketName());
		List<T> entityList = new ArrayList<T>();
		RiakClient riakClient = riakClientFactory.getRiakClient();
		String INDEXED_MAX_RESULTS = messageSource.getMessage(
				GlobalConstant.INDEXED_MAX_RESULTS, null, null);
		try {
			BinIndexQuery biq = null;
			if (riakContinuationObject != null
					&& riakContinuationObject.getContinuationValue() != null) {
				System.out.println("Continuation::"
						+ riakContinuationObject.getContinuationValue());
				if (to != null) {
					biq = new BinIndexQuery.Builder(namespace, indexedField,
							from, to)
							.withContinuation(
									BinaryValue.create(riakContinuationObject
											.getContinuationValue()))
							.withPaginationSort(true)
							.withMaxResults(
									Integer.parseInt(INDEXED_MAX_RESULTS))
							.build();
				} else {
					biq = new BinIndexQuery.Builder(namespace, indexedField,
							from)
							.withContinuation(
									BinaryValue.create(riakContinuationObject
											.getContinuationValue()))
							.withPaginationSort(true)
							.withMaxResults(
									Integer.parseInt(INDEXED_MAX_RESULTS))
							.build();
				}
			} else {
				if (to != null) {
					biq = new BinIndexQuery.Builder(namespace, indexedField,
							from, to)
							.withPaginationSort(true)
							.withMaxResults(
									Integer.parseInt(INDEXED_MAX_RESULTS))
							.build();
				} else {
					biq = new BinIndexQuery.Builder(namespace, indexedField,
							from)
							.withPaginationSort(true)
							.withMaxResults(
									Integer.parseInt(INDEXED_MAX_RESULTS))
							.build();
				}
			}
			BinIndexQuery.Response response = riakClient.execute(biq);
			List<BinIndexQuery.Response.Entry> entries = response.getEntries();
			BinaryValue continuationValue = response.getContinuation();
			if (continuationValue != null) {
				riakContinuationObject.setContinuationValue(continuationValue
						.toString());
			} else {
				riakContinuationObject.setContinuationValue(null);
			}
			for (BinIndexQuery.Response.Entry entry : entries) {
				Location location = entry.getRiakObjectLocation();
				T entity = getEntityByLocationKey(location, classVal);
				String keyVal = entry.getRiakObjectLocation().getKey()
						.toString();
				if (entity != null) {
					entity.setKey_s(keyVal);
					entityList.add(entity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("DAO", e);
		}
		return entityList;
	}

}
