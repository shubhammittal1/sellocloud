package com.bmp.model.app.saleorder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BfilMerchantCallingStatus {
	
	@JsonProperty("LoanProposalID")
	private String LoanProposalID;
	
	@JsonProperty("CallDate")
	private String CallDate	;
	
	@JsonProperty("MerchantID")
	private String MerchantID;
	
	@JsonProperty("Status")
	private String Status;
	
	@JsonProperty("Reason")
	private String Reason;
	
	@JsonProperty("RejectionChannel")
	private String RejectionChannel;
	
	@JsonProperty("GeoTag")
	private String GeoTag;
	
	@JsonProperty("VendorID")
	private String VendorID;
	
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
	

	public BfilMerchantCallingStatus() {
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

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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

	@JsonProperty("CallDate")
	public String getCallDate() {
		return CallDate;
	}

	public void setCallDate(String callDate) {
		CallDate = callDate;
	}

	@JsonProperty("Reason")
	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	@JsonProperty("RejectionChannel")
	public String getRejectionChannel() {
		return RejectionChannel;
	}

	public void setRejectionChannel(String rejectionChannel) {
		RejectionChannel = rejectionChannel;
	}

	@JsonProperty("GeoTag")
	public String getGeoTag() {
		return GeoTag;
	}

	public void setGeoTag(String geoTag) {
		GeoTag = geoTag;
	}

	@JsonProperty("VendorID")
	public String getVendorID() {
		return VendorID;
	}

	public void setVendorID(String vendorID) {
		VendorID = vendorID;
	}

}
