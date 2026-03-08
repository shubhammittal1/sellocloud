package com.bmp.model.app.masters;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="pincodeDirectory")
@AssignKey(assvalue=false)
public class PincodeDirectory extends MongoBaseBean {
	
	private static final long serialVersionUID = 8809916544181801112L;
	private String areaName;
	@Indexed
	private String taluka_s;
	@Indexed
	private String pincode_s;
	@Indexed
	private String district_s;
	private City city;
	private State state;
	private Country country;
	@Indexed
	private Boolean urban_b;
	
	public PincodeDirectory(){}
	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getTaluka_s() {
		return taluka_s;
	}

	public void setTaluka_s(String taluka_s) {
		this.taluka_s = taluka_s;
	}

	public String getPincode_s() {
		return pincode_s;
	}

	public void setPincode_s(String pincode_s) {
		this.pincode_s = pincode_s;
	}

	public String getDistrict_s() {
		return district_s;
	}

	public void setDistrict_s(String district_s) {
		this.district_s = district_s;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Boolean getUrban_b() {
		return urban_b;
	}

	public void setUrban_b(Boolean urban_b) {
		this.urban_b = urban_b;
	}

}