package com.bmp.model.app.saleorder;

import com.bmp.model.app.status.StatusMaster;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupHistory {
	
	//private StatusMaster status;
	//private StatusMaster fromStatus;
	//private StatusMaster toStatus;
	private String fromStatusKey;
	private String toStatusKey;
	private String location;
	private String date;
	private Long createdDate;
	private String createdByKey;
	private String createdByName;
	
	public PickupHistory() {
		super();
	}

	/*public StatusMaster getStatus() {
		return status;
	}

	public void setStatus(StatusMaster status) {
		this.status = status;
	}*/
	

	/*public StatusMaster getFromStatus() {
		return fromStatus;
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

	/*public void setFromStatus(StatusMaster fromStatus) {
		this.fromStatus = fromStatus;
	}

	public StatusMaster getToStatus() {
		return toStatus;
	}

	public void setToStatus(StatusMaster toStatus) {
		this.toStatus = toStatus;
	}*/

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

	

}
