package com.bmp.model.app.saleorder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BfilOrderCancel {
	
	@JsonProperty("LoanProposalID")
	private String LoanProposalID;
	
	@JsonProperty("CancelDate")
	private String CancelDate;
	
	@JsonProperty("CancelRemarks")
	private String CancelRemarks;
	
	@JsonProperty("CancelStatus")
	private String CancelStatus;
	
	@JsonProperty("TypeOfDelivery")
	private String TypeOfDelivery;
	
	public BfilOrderCancel() {
		super();
	}

	@JsonProperty("LoanProposalID")
	public String getLoanProposalID() {
		return LoanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		LoanProposalID = loanProposalID;
	}

	@JsonProperty("CancelDate")
	public String getCancelDate() {
		return CancelDate;
	}

	public void setCancelDate(String cancelDate) {
		CancelDate = cancelDate;
	}

	@JsonProperty("CancelRemarks")
	public String getCancelRemarks() {
		return CancelRemarks;
	}

	public void setCancelRemarks(String cancelRemarks) {
		CancelRemarks = cancelRemarks;
	}

	@JsonProperty("CancelStatus")
	public String getCancelStatus() {
		return CancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		CancelStatus = cancelStatus;
	}

	@JsonProperty("TypeOfDelivery")
	public String getTypeOfDelivery() {
		return TypeOfDelivery;
	}

	public void setTypeOfDelivery(String typeOfDelivery) {
		TypeOfDelivery = typeOfDelivery;
	}
	

}
