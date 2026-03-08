package com.bmp.model.app.masters;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="cityZoneLookup")
@AssignKey(assvalue=false)
public class CityZoneLookup extends MongoBaseBean implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Indexed
	private String rateZoneTypeKey;
	@Indexed
	private String cityKey;
	@Indexed
	private String stateKey;
	@Indexed
	private String countryKey;
	@Indexed
	private String zoneKey;
	
	public String getRateZoneTypeKey() {
		return rateZoneTypeKey;
	}
	public void setRateZoneTypeKey(String rateZoneTypeKey) {
		this.rateZoneTypeKey = rateZoneTypeKey;
	}
	public String getCityKey() {
		return cityKey;
	}
	public void setCityKey(String cityKey) {
		this.cityKey = cityKey;
	}
	public String getStateKey() {
		return stateKey;
	}
	public void setStateKey(String stateKey) {
		this.stateKey = stateKey;
	}
	public String getZoneKey() {
		return zoneKey;
	}
	public void setZoneKey(String zoneKey) {
		this.zoneKey = zoneKey;
	}
	
	public String getCountryKey() {
		return countryKey;
	}
	public void setCountryKey(String countryKey) {
		this.countryKey = countryKey;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
