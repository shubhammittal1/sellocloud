package com.bmp.bean.saleorder;

public class UpdatePacketHistory {
	private String key;
	private String date;
	private String location;
	private String previousStatus;
	private String newStatus;
	private String createdBy;
	private String drsReason;
	private String previousStatusDate;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPreviousStatus() {
		return previousStatus;
	}
	public void setPreviousStatus(String previousStatus) {
		this.previousStatus = previousStatus;
	}
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDrsReason() {
		return drsReason;
	}
	public void setDrsReason(String drsReason) {
		this.drsReason = drsReason;
	}
	public String getPreviousStatusDate() {
		return previousStatusDate;
	}
	public void setPreviousStatusDate(String previousStatusDate) {
		this.previousStatusDate = previousStatusDate;
	}
	

}
