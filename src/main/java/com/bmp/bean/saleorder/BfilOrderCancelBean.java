package com.bmp.bean.saleorder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BfilOrderCancelBean {

	@JsonProperty("LoanProposalID")
	private String LoanProposalID;
	
	@JsonProperty("CancelDate")
	private String CancelDate;
	
	@JsonProperty("CancelRemarks")
	private String CancelRemarks;
	
	@JsonProperty("CancelStatus")
	private String CancelStatus;        //Order Cancelled
	
	public BfilOrderCancelBean() {
		super();
	}

	public String getLoanProposalID() {
		return LoanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		LoanProposalID = loanProposalID;
	}

	public String getCancelDate() {
		return CancelDate;
	}

	public void setCancelDate(String cancelDate) {
		CancelDate = cancelDate;
	}

	public String getCancelRemarks() {
		return CancelRemarks;
	}

	public void setCancelRemarks(String cancelRemarks) {
		CancelRemarks = cancelRemarks;
	}

	public String getCancelStatus() {
		return CancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		CancelStatus = cancelStatus;
	}
	
	
}
