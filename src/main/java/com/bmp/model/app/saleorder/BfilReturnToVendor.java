package com.bmp.model.app.saleorder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BfilReturnToVendor {
	
	@JsonProperty("LoanProposalID")
	private String LoanProposalID;
	
	@JsonProperty("ReturnDate")
	private String ReturnDate;
	
	@JsonProperty("MerchantID")
	private String MerchantID;
	
	@JsonProperty("ProductID")
	private String ProductID;
	
	@JsonProperty("Stage")
	private String Stage;
	
	@JsonProperty("Reason")
	private String Reason;
	
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
	

	public BfilReturnToVendor() {
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

	
	@JsonProperty("ProductID")
	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	@JsonProperty("ReturnDate")
	public String getReturnDate() {
		return ReturnDate;
	}


	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}

	@JsonProperty("Stage")
	public String getStage() {
		return Stage;
	}


	public void setStage(String stage) {
		Stage = stage;
	}

	@JsonProperty("Reason")
	public String getReason() {
		return Reason;
	}


	public void setReason(String reason) {
		Reason = reason;
	}

}
