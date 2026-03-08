package com.bmp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.SettingsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.config.Settings;

@Repository
@Qualifier("settingsDaoImpl")
public class SettingsDaoImpl extends MongoBaseDaoImpl<Settings>  implements SettingsDao {
	
	@Override
	public List<Settings> getReason(String type) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("typeName_s").is(type));
		List<Settings> resultList = getObjectByQuery(query, Settings.class);
		return resultList;
	}
	
	@Override
	public List<Settings> getMulitipleReason(String type) throws Exception {
		Query query = new Query();
		Object obj[] = type.split(",");
		query.addCriteria(Criteria.where("typeName_s").in(obj));
		List<Settings> resultList = getObjectByQuery(query, Settings.class);
		return resultList;
	}

	@Override
	public List<String> getReasonKeyList(String type) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("typeName_s").is(type));
		query.fields().include("_id");
		List<Settings> resultList = getObjectByQuery(query, Settings.class);
		
		List<String> keyList = new ArrayList<String>();
		for(Settings settings : resultList) {
			keyList.add(settings.getKey_s());
		}
		
		return keyList;
	}
}