package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.FreightType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="rateListTemplate")
@AssignKey(assvalue=false)
public class RateListTemplate extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -2895853850392968242L;

	private String name;
	private String description;
	private FreightType freightType;
	private Map<String, RateMatrix> rateZoneMatrix;
	
	public RateListTemplate() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FreightType getFreightType() {
		return freightType;
	}

	public void setFreightType(FreightType freightType) {
		this.freightType = freightType;
	}

	public Map<String, RateMatrix> getRateZoneMatrix() {
		return rateZoneMatrix;
	}

	public void setRateZoneMatrix(Map<String, RateMatrix> rateZoneMatrix) {
		this.rateZoneMatrix = rateZoneMatrix;
	}

}
