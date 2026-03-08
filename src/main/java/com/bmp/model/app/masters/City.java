package com.bmp.model.app.masters;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Component("com.bmp.model.app.masters.City")
@Document(collection="city")
@AssignKey(assvalue=false)
public class City extends MongoBaseBean {
	
	private static final long serialVersionUID = -8018911391705831381L;
	
	@Indexed
	private String cityCode_s;
	@Indexed
	private String cityName_s;
	private State state;
	
	public City(){}

	public String getCityCode_s() {
		return cityCode_s;
	}

	public void setCityCode_s(String cityCode_s) {
		this.cityCode_s = cityCode_s;
	}

	public String getCityName_s() {
		return cityName_s;
	}

	public void setCityName_s(String cityName_s) {
		this.cityName_s = cityName_s;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}