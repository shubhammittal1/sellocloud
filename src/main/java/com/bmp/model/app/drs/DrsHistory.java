package com.bmp.model.app.drs;

import com.bmp.model.app.status.StatusMaster;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrsHistory {
	
	//private StatusMaster fromStatus;
	//private StatusMaster toStatus;
	private String fromStatusKey;
	private String toStatusKey;
	private String location;
	private String date;
	private String remarks;
	private Long createdDate;
	private String createdByKey;
	private String createdByName;
	
	public DrsHistory() {
		super();
	}
	
	

	/*public StatusMaster getFromStatus() {
		return fromStatus;
	}

	public StatusMaster getToStatus() {
		return toStatus;
	}*/

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

	public String getDate() {
		return date;
	}

	public String getRemarks() {
		return remarks;
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

	/*public void setFromStatus(StatusMaster fromStatus) {
		this.fromStatus = fromStatus;
	}

	public void setToStatus(StatusMaster toStatus) {
		this.toStatus = toStatus;
	}*/

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	
}
