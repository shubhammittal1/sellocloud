package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.config.Settings;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface SettingsDao extends MongoBaseDao<Settings> {

	List<Settings> getReason(String type) throws Exception;

	List<Settings> getMulitipleReason(String type) throws Exception;
	List<String> getReasonKeyList(String type) throws Exception;
}