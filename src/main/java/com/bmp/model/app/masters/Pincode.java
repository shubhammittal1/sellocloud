package com.bmp.model.app.masters;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="pincode")
@AssignKey(assvalue=false)
@Component("com.bmp.model.app.masters.Pincode")
public class Pincode extends MongoBaseBean {
	
	private static final long serialVersionUID = -8018911391705831381L;
	
	@Indexed
	private String pinCode_s;
	@Indexed
	private String region_s;
	private City city;
	
	public Pincode(){
		super();
	}

	public String getPinCode_s() {
		return pinCode_s;
	}

	public void setPinCode_s(String pinCode_s) {
		this.pinCode_s = pinCode_s;
	}

	public String getRegion_s() {
		return region_s;
	}

	public void setRegion_s(String region_s) {
		this.region_s = region_s;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}