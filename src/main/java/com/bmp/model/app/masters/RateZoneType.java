package com.bmp.model.app.masters;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="rateZoneType")
@AssignKey(assvalue=false)
public class RateZoneType extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = -8018911391705831381L;
	
	private String name;
	private String desc;
	
	public RateZoneType(){}

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

}
