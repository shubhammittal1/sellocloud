package com.bmp.model.app.wms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WmsOrderHistory {
	private String fromStatusKey;
	private String toStatusKey;
    private String location;
    private String date;
    private String remarks;
    private Long createdDate;
    private String createdByKey;
    private String createdByName;
	private boolean statusPushed = false;
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedByKey() {
		return createdByKey;
	}
	public void setCreatedByKey(String createdByKey) {
		this.createdByKey = createdByKey;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public boolean isStatusPushed() {
		return statusPushed;
	}
	public void setStatusPushed(boolean statusPushed) {
		this.statusPushed = statusPushed;
	}

}
