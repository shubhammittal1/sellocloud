package com.bmp.bean.client;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;

public class ClientBillingBean {
	@Indexed
	private String clientKey_s;
	private String fromDate;
	private String toDate;
	private Boolean approvedWeight;
	private Boolean terminalStatus;
	private Double totalBillingWight;
	private List<String> awbList;
	private Double totalAmount;
	
	public ClientBillingBean(){
		super();
	}
	
	public Double getTotalAmount() {
		return totalAmount;
	}
	
	public Double getTotalBillingWight() {
		return totalBillingWight;
	}

	public void setTotalBillingWight(Double totalBillingWight) {
		this.totalBillingWight = totalBillingWight;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getClientKey_s() {
		return clientKey_s;
	}
	public String getToDate() {
		return toDate;
	}
	public Boolean getApprovedWeight() {
		return approvedWeight;
	}
	public Boolean getTerminalStatus() {
		return terminalStatus;
	}
	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public void setApprovedWeight(Boolean approvedWeight) {
		this.approvedWeight = approvedWeight;
	}
	public void setTerminalStatus(Boolean terminalStatus) {
		this.terminalStatus = terminalStatus;
	}
	public List<String> getAwbList() {
		return awbList;
	}
	public void setAwbList(List<String> awbList) {
		this.awbList = awbList;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	
}
