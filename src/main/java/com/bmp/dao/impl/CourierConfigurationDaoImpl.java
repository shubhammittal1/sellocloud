package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CourierConfigurationDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.CourierConfiguration;

@Repository
@Qualifier("courierConfigurationDaoImpl")
public class CourierConfigurationDaoImpl extends MongoBaseDaoImpl<CourierConfiguration> implements CourierConfigurationDao{

	@Override
	public CourierConfiguration getCourierConfiguration(String clientKey) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("clientKey_s").is(clientKey));
		List<CourierConfiguration> list = getObjectByQuery(query, CourierConfiguration.class);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
