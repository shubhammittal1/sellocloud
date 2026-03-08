package com.bmp.model.app.saleorder;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupRequestHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fromStatusKey;
	private String toStatusKey;
	private String location;
	private String date;
	private Long createdDate;
	private String createdByKey;
	private String createdByName;
	private String remark;
	private boolean scaned;
	private boolean appRequest;
	private String latLong;
	
	public PickupRequestHistory() {
		super();
	}

	public String getFromStatusKey() {
		return fromStatusKey;
	}

	public void setFromStatusKey(String fromStatusKey) {
		this.fromStatusKey = fromStatusKey;
	}

	public String getToStatusKey() {
		return toStatusKey;
	}

	public void setToStatusKey(String toStatusKey) {
		this.toStatusKey = toStatusKey;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLocation() {
		return location;
	}

	public String getDate() {
		return date;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public String getCreatedByKey() {
		return createdByKey;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public void setCreatedByKey(String createdByKey) {
		this.createdByKey = createdByKey;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public boolean isScaned() {
		return scaned;
	}

	public void setScaned(boolean scaned) {
		this.scaned = scaned;
	}

	public boolean isAppRequest() {
		return appRequest;
	}

	public void setAppRequest(boolean appRequest) {
		this.appRequest = appRequest;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}

}
