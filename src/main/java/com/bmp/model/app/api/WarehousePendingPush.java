package com.bmp.model.app.api;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.ApiRequestType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="warehousePendingPush")
@AssignKey(assvalue=false)
public class WarehousePendingPush extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String warehouseKey;
	private String courierKey;
	private Integer count;
	private ApiRequestType type;
	public String getWarehouseKey() {
		return warehouseKey;
	}
	public void setWarehouseKey(String warehouseKey) {
		this.warehouseKey = warehouseKey;
	}
	public String getCourierKey() {
		return courierKey;
	}
	public void setCourierKey(String courierKey) {
		this.courierKey = courierKey;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public ApiRequestType getType() {
		return type;
	}
	public void setType(ApiRequestType type) {
		this.type = type;
	}
	

}
