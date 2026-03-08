package com.bmp.bean.saleorder;

import java.util.List;

public class RemittanceBean {
	
	private String clientKey_s;
	private String codReceived;
	private List<String> awbList;
	
	public String getClientKey_s() {
		return clientKey_s;
	}
	public String getCodReceived() {
		return codReceived;
	}
	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}
	public void setCodReceived(String codReceived) {
		this.codReceived = codReceived;
	}
	public List<String> getAwbList() {
		return awbList;
	}
	public void setAwbList(List<String> awbList) {
		this.awbList = awbList;
	}
	
	
}
