package com.bmp.model.app.masters;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="state")
@AssignKey(assvalue=false)
@Component("com.bmp.model.app.masters.State")
public class State extends MongoBaseBean {
	
	private static final long serialVersionUID = -2103839018867460964L;

	@Indexed
	private String stateCode_s;
	@Indexed
	private String stateName_s;
	private Country country;
	
	public State(){
		super();
	}

	public String getStateCode_s() {
		return stateCode_s;
	}

	public void setStateCode_s(String stateCode_s) {
		this.stateCode_s = stateCode_s;
	}

	public String getStateName_s() {
		return stateName_s;
	}

	public void setStateName_s(String stateName_s) {
		this.stateName_s = stateName_s;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}