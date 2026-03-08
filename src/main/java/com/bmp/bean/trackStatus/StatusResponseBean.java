package com.bmp.bean.trackStatus;

import java.io.Serializable;

public class StatusResponseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String statusCode;
	private String status;
	private String date;
	private String location;
	private String reasonCode;
	private String reason;
	private String remark;
	
	public String getStatusCode() {
		return statusCode;
	}
	public String getStatus() {
		return status;
	}
	public String getDate() {
		return date;
	}
	public String getLocation() {
		return location;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public String getReason() {
		return reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
