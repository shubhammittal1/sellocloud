package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.courier.CourierConfiguration;

public interface CourierConfigurationDao extends MongoBaseDao<CourierConfiguration>{
	
	public CourierConfiguration getCourierConfiguration(String clientKey) throws Exception;

}
