package com.bmp.bean.trackStatus;

import java.io.Serializable;

import com.bmp.bean.saleorder.SearchVariable;

public class TrackOrderBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String clientKey;
	private SearchVariable searchBy;
	private String awbNumber;
	
	public String getClientKey() {
		return clientKey;
	}
	public SearchVariable getSearchBy() {
		return searchBy;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public void setSearchBy(SearchVariable searchBy) {
		this.searchBy = searchBy;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	
	
}
