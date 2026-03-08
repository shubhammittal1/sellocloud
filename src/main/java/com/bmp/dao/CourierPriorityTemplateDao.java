package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.courier.CourierPriorityTemplate;

public interface CourierPriorityTemplateDao extends MongoBaseDao<CourierPriorityTemplate> {
	public List<CourierPriorityTemplate> getEntityByLocationKey(List<String> keys) throws Exception;

}
