package com.bmp.bean.trackStatus;

import java.io.Serializable;

public class TrackCurrentStatusBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String clientId;
	private String searchBy;
	private String awbNumber;
	
	public String getClientId() {
		return clientId;
	}
	public String getSearchBy() {
		return searchBy;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	
	
}
