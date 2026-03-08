package com.bmp.bean.saleorder;

import java.util.List;

public class ApiPrintLeableBean {
	private String  clientName;
	private List<String> awbNumber;
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public List<String> getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(List<String> awbNumber) {
		this.awbNumber = awbNumber;
	}
	
	
}
