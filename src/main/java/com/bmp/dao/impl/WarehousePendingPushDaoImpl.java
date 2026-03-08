package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.WarehousePendingPushDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.api.WarehousePendingPush;

@Repository
@Qualifier("warehousePendingPushDaoImpl")
public class WarehousePendingPushDaoImpl extends MongoBaseDaoImpl<WarehousePendingPush> implements WarehousePendingPushDao{

	@Override
	public WarehousePendingPush getWarehousePendingPushByWarehouseKey(String warehouseKey) {
		Query query = new Query();
		query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey.trim()));
		 List<WarehousePendingPush> warehousePendingPushList = getObjectByQuery(query, WarehousePendingPush.class);
		    if(warehousePendingPushList != null && !warehousePendingPushList.isEmpty()){
		    	return warehousePendingPushList.get(0);
		    }
			return null;
	}

}
