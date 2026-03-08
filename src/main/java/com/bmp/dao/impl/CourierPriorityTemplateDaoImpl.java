package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CourierPriorityTemplateDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.CourierPriorityTemplate;

@Repository
@Qualifier("courierPriorityTemplateDaoImpl")
public class CourierPriorityTemplateDaoImpl extends MongoBaseDaoImpl<CourierPriorityTemplate>  implements CourierPriorityTemplateDao{
	
	@Override
	@Cacheable(value="courierPriorityTemplate")
	public List<CourierPriorityTemplate> getEntityByLocationKey(List<String> keys) throws Exception {
		return getObjectListByIds(keys, CourierPriorityTemplate.class);
	}
	
}
