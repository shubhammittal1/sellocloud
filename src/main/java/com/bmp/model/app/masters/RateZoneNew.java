package com.bmp.model.app.masters;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="rateZoneNew")
@AssignKey(assvalue=false)
public class RateZoneNew extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = -9176776470082830992L;
	@Indexed
	private String rateZoneTypeKey;
	private String name;
	private String type;
	private String desc;
	private Map<String, List<String>> zoneStateCityMap;
	
	public RateZoneNew(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Map<String, List<String>> getZoneStateCityMap() {
		return zoneStateCityMap;
	}

	public void setZoneStateCityMap(Map<String, List<String>> zoneStateCityMap) {
		this.zoneStateCityMap = zoneStateCityMap;
	}

	public String getRateZoneTypeKey() {
		return rateZoneTypeKey;
	}

	public void setRateZoneTypeKey(String rateZoneTypeKey) {
		this.rateZoneTypeKey = rateZoneTypeKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
