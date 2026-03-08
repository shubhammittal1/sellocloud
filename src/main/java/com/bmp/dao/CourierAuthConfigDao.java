package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.courier.CourierAuthConfig;

public interface CourierAuthConfigDao extends MongoBaseDao<CourierAuthConfig> {
	CourierAuthConfig getObjectByCourier(String courier,final Class<CourierAuthConfig> classVal);
	
	void deleteFieldBeanByCourier(String courier);
	void deleteFieldRecordByFieldCode(String courier,String fieldCode);
}
