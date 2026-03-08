package com.bmp.model.app.masters;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="rateZone")
@AssignKey(assvalue=false)
public class RateZone extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = -9176776470082830992L;
	
	private String name;
	private String desc;
	private String code;
	private String courierKey_s;
	
	public RateZone(){}

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCourierKey_s() {
		return courierKey_s;
	}

	public void setCourierKey_s(String courierKey_s) {
		this.courierKey_s = courierKey_s;
	}
	
	
}