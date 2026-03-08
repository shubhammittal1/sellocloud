package com.bmp.model.app.masters;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="country")
@AssignKey(assvalue=false)
@Component("com.bmp.model.app.masters.Country")
public class Country extends MongoBaseBean {
	
	private static final long serialVersionUID = -4488911284221039453L;

	@Indexed
	private String countryName_s;
	@Indexed
	private String countryCode_s;
	
	public Country(){}

	public String getCountryName_s() {
		return countryName_s;
	}

	public void setCountryName_s(String countryName_s) {
		this.countryName_s = countryName_s;
	}

	public String getCountryCode_s() {
		return countryCode_s;
	}

	public void setCountryCode_s(String countryCode_s) {
		this.countryCode_s = countryCode_s;
	}
	
}