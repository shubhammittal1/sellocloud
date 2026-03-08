package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.BusinessType;
import com.bmp.constant.FreightType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="clientCourierRateListTemplate")
@AssignKey(assvalue=false)
public class ClientCourierRateListTemplate extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -2895853850392968242L;

	private String name;
	private String clientName;
	private String clientKey;
	private String courierName;
	private String courierKey;
	private String description;
	private BusinessType businessType;
	private FreightType freightType;
	private Map<String, RateMatrix> rateZoneMatrix;
	private Map<String, RateMatrix> rotRateZoneMatrix;
	
	public ClientCourierRateListTemplate() {}

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

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getCourierKey() {
		return courierKey;
	}

	public void setCourierKey(String courierKey) {
		this.courierKey = courierKey;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public Map<String, RateMatrix> getRotRateZoneMatrix() {
		return rotRateZoneMatrix;
	}

	public void setRotRateZoneMatrix(Map<String, RateMatrix> rotRateZoneMatrix) {
		this.rotRateZoneMatrix = rotRateZoneMatrix;
	}
	
	
	
	

}
