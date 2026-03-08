package com.bmp.model.app.saleorder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BfilRdspProductMemberHandover {
	
	@JsonProperty("LoanProposalID")
	private String LoanProposalID;
	
	@JsonProperty("DeliveryDate")
	private String DeliveryDate	;
	
	@JsonProperty("MerchantID")
	private String MerchantID;
	
	@JsonProperty("TypeofPOD")
	private String TypeofPOD;
	
	@JsonProperty("POD")
	private String POD;
	
	@JsonProperty("Status")
	private String Status;
	
	@JsonProperty("Reason")
	private String Reason;

	@JsonProperty("GeoTag")
	private String GeoTag;
	
	@JsonProperty("ReceivedBy")
	private String ReceivedBy;
	
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
	

	public BfilRdspProductMemberHandover() {
		super();
	}


	@JsonProperty("LoanProposalID")
	public String getLoanProposalID() {
		return LoanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		LoanProposalID = loanProposalID;
	}

	@JsonProperty("DeliveryDate")
	public String getDeliveryDate() {
		return DeliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}

	@JsonProperty("MerchantID")
	public String getMerchantID() {
		return MerchantID;
	}

	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}

	@JsonProperty("TypeofPOD")
	public String getTypeofPOD() {
		return TypeofPOD;
	}

	public void setTypeofPOD(String typeofPOD) {
		TypeofPOD = typeofPOD;
	}

	@JsonProperty("POD")
	public String getPOD() {
		return POD;
	}

	public void setPOD(String pOD) {
		POD = pOD;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@JsonProperty("Reason")
	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	@JsonProperty("GeoTag")
	public String getGeoTag() {
		return GeoTag;
	}

	public void setGeoTag(String geoTag) {
		GeoTag = geoTag;
	}

	@JsonProperty("ReceivedBy")
	public String getReceivedBy() {
		return ReceivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		ReceivedBy = receivedBy;
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

}
