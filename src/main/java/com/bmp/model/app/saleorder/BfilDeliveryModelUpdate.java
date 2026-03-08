package com.bmp.model.app.saleorder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BfilDeliveryModelUpdate {
	
	@JsonProperty("LoanProposalID")
	private String LoanProposalID;
	
	@JsonProperty("CurrentDeliveryType")
	private String CurrentDeliveryType;
	
	@JsonProperty("RevisedDeliveryType")
	private String RevisedDeliveryType;
	
	@JsonProperty("MerchantID")
	private String MerchantID;
	
	@JsonProperty("Text1")
	private String Text1;

	@JsonProperty("Text2")
	private String Text2;
	
	@JsonProperty("Numeric1")
	private String Numeric1;
	
	@JsonProperty("Numeric2")
	private String Numeric2;
	
	@JsonProperty("Boolean")
	private String Boolean;
	
	@JsonProperty("Date")
	private String Date;
	

	public BfilDeliveryModelUpdate() {
		super();
	}


	@JsonProperty("LoanProposalID")
	public String getLoanProposalID() {
		return LoanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		LoanProposalID = loanProposalID;
	}

	@JsonProperty("MerchantID")
	public String getMerchantID() {
		return MerchantID;
	}

	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}

	

	@JsonProperty("Text1")
	public String getText1() {
		return Text1;
	}

	public void setText1(String text1) {
		Text1 = text1;
	}

	@JsonProperty("Text2")
	public String getText2() {
		return Text2;
	}

	public void setText2(String text2) {
		Text2 = text2;
	}

	@JsonProperty("Numeric1")
	public String getNumeric1() {
		return Numeric1;
	}

	public void setNumeric1(String numeric1) {
		Numeric1 = numeric1;
	}

	@JsonProperty("Numeric2")
	public String getNumeric2() {
		return Numeric2;
	}

	public void setNumeric2(String numeric2) {
		Numeric2 = numeric2;
	}

	@JsonProperty("Boolean")
	public String getBoolean() {
		return Boolean;
	}

	public void setBoolean(String b) {
		Boolean = b;
	}

	@JsonProperty("Date")
	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@JsonProperty("CurrentDeliveryType")
	public String getCurrentDeliveryType() {
		return CurrentDeliveryType;
	}


	public void setCurrentDeliveryType(String currentDeliveryType) {
		CurrentDeliveryType = currentDeliveryType;
	}

	@JsonProperty("RevisedDeliveryType")
	public String getRevisedDeliveryType() {
		return RevisedDeliveryType;
	}


	public void setRevisedDeliveryType(String revisedDeliveryType) {
		RevisedDeliveryType = revisedDeliveryType;
	}

	
}
