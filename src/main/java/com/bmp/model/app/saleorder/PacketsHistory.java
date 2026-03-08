package com.bmp.model.app.saleorder;

import java.io.Serializable;

import com.bmp.model.app.status.StatusMasterNew;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacketsHistory implements Serializable {
	
	private StatusMasterNew fromStatus;
	private StatusMasterNew toStatus;
	private String fromStatusKey;
	private String toStatusKey;
	private String location;
	private String date;
	private String rtoReason;
	private String remarks;
	private Long createdDate;
	private String createdByKey;
	private String createdByName;
	private String otp;
	private String latLong;
	private boolean appRequest;
	
	public PacketsHistory() {
		super();
	}

	public StatusMasterNew getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(StatusMasterNew fromStatus) {
		this.fromStatus = fromStatus;
	}

	public StatusMasterNew getToStatus() {
		return toStatus;
	}

	public void setToStatus(StatusMasterNew toStatus) {
		this.toStatus = toStatus;
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

	public String getRtoReason() {
		return rtoReason;
	}

	public void setRtoReason(String rtoReason) {
		this.rtoReason = rtoReason;
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

	public boolean isAppRequest() {
		return appRequest;
	}

	public void setAppRequest(boolean appRequest) {
		this.appRequest = appRequest;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}
	
	

}