package com.bmp.bean.saleorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BfilOrderBean {
	
	@JsonProperty("BatchNumber")
	private String BatchNumber;
	
	@JsonProperty("BatchDate")
	private String BatchDate;
	
	@JsonProperty("BranchID")
	private String BranchID;
	
	@JsonProperty("BranchName")
	private String BranchName;
	
	@JsonProperty("LoanApprovaldate")
	private String LoanApprovaldate;
	
	@JsonProperty("LoanProposalID")
	private String LoanProposalID;
	
	@JsonProperty("ProposalID")
	private String ProposalID;
	
	@JsonProperty("ClientID")
	private String ClientID;
	
	@JsonProperty("ClientUniqueID")
	private String ClientUniqueID;
	
	@JsonProperty("ClientName")
	private String ClientName;
	
	@JsonProperty("ProductID")
	private String ProductID;
	
	@JsonProperty("Model")
	private String Model;
	
	@JsonProperty("MemberOfferPrice")
	private String MemberOfferPrice;
	
	@JsonProperty("VendorId")
	private String VendorId;
	
	@JsonProperty("SupplierName")
	private String SupplierName;
	
	@JsonProperty("AddressLine1")
	private String AddressLine1;
	
	@JsonProperty("AddressLine2")
	private String AddressLine2;
	
	@JsonProperty("Landmark")
	private String Landmark;
	
	@JsonProperty("Village")
	private String Village;
	
	@JsonProperty("DistrictName")
	private String DistrictName;
	
	@JsonProperty("StateName")
	private String StateName;
	
	@JsonProperty("Pincode")
	private String Pincode;
	
	@JsonProperty("MobileNumber")
	private String MobileNumber;
	
	@JsonProperty("MemberAlternateMobileNumber")
	private String MemberAlternateMobileNumber;
	
	@JsonProperty("SpouseName")
	private String SpouseName;
	
	@JsonProperty("Status")
	private String Status;
	
	@JsonProperty("FatherName")
	private String FatherName;
	
	@JsonProperty("SMName")
	private String SMName;
	
	@JsonProperty("SMNumber")
	private String SMNumber;
	
	@JsonProperty("BMName")
	private String BMName;
	
	@JsonProperty("BMNumber")
	private String BMNumber;
	
	@JsonProperty("Text1")
	private String Text1;
	
	@JsonProperty("Text2")
	private String Text2;
	
	@JsonProperty("Numeric1")
	private String Numeric1;
	
	@JsonProperty("Numeric2")
	private String Numeric2;
	
	@JsonProperty("OrderDate")
	private String OrderDate;
	
	
	@JsonProperty("CenterLatLong")
	private String CenterLatLong;
	
	@JsonProperty("RdspID")
	private String RdspID;
	
	@JsonProperty("DeliveryType")
	private String DeliveryType;
	
	@JsonProperty("DeliveryModel")
	private String DeliveryModel;
	
	@JsonProperty("UN1")
	private String UN1;
	
	@JsonProperty("UN2")
	private String UN2;
	
	@JsonProperty("UN3")
	private String UN3;
	
	@JsonProperty("Boolean")
	private Boolean Boolean;
	
	public BfilOrderBean() {
		super();
	}

	public String getBatchNumber() {
		return BatchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		BatchNumber = batchNumber;
	}

	public String getBatchDate() {
		return BatchDate;
	}

	public void setBatchDate(String batchDate) {
		BatchDate = batchDate;
	}

	public String getBranchID() {
		return BranchID;
	}

	public void setBranchID(String branchID) {
		BranchID = branchID;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}

	public String getLoanApprovaldate() {
		return LoanApprovaldate;
	}

	public void setLoanApprovaldate(String loanApprovaldate) {
		LoanApprovaldate = loanApprovaldate;
	}

	public String getLoanProposalID() {
		return LoanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		LoanProposalID = loanProposalID;
	}

	public String getProposalID() {
		return ProposalID;
	}

	public void setProposalID(String proposalID) {
		ProposalID = proposalID;
	}

	public String getClientID() {
		return ClientID;
	}

	public void setClientID(String clientID) {
		ClientID = clientID;
	}

	public String getClientUniqueID() {
		return ClientUniqueID;
	}

	public void setClientUniqueID(String clientUniqueID) {
		ClientUniqueID = clientUniqueID;
	}

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getMemberOfferPrice() {
		return MemberOfferPrice;
	}

	public void setMemberOfferPrice(String memberOfferPrice) {
		MemberOfferPrice = memberOfferPrice;
	}

	public String getVendorId() {
		return VendorId;
	}

	public void setVendorId(String vendorId) {
		VendorId = vendorId;
	}

	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getLandmark() {
		return Landmark;
	}

	public void setLandmark(String landmark) {
		Landmark = landmark;
	}

	public String getVillage() {
		return Village;
	}

	public void setVillage(String village) {
		Village = village;
	}

	public String getDistrictName() {
		return DistrictName;
	}

	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getMemberAlternateMobileNumber() {
		return MemberAlternateMobileNumber;
	}

	public void setMemberAlternateMobileNumber(String memberAlternateMobileNumber) {
		MemberAlternateMobileNumber = memberAlternateMobileNumber;
	}

	public String getSpouseName() {
		return SpouseName;
	}

	public void setSpouseName(String spouseName) {
		SpouseName = spouseName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getSMName() {
		return SMName;
	}

	public void setSMName(String sMName) {
		SMName = sMName;
	}

	public String getSMNumber() {
		return SMNumber;
	}

	public void setSMNumber(String sMNumber) {
		SMNumber = sMNumber;
	}

	public String getBMName() {
		return BMName;
	}

	public void setBMName(String bMName) {
		BMName = bMName;
	}

	public String getBMNumber() {
		return BMNumber;
	}

	public void setBMNumber(String bMNumber) {
		BMNumber = bMNumber;
	}

	public String getText1() {
		return Text1;
	}

	public void setText1(String text1) {
		Text1 = text1;
	}

	public String getText2() {
		return Text2;
	}

	public void setText2(String text2) {
		Text2 = text2;
	}

	public String getNumeric1() {
		return Numeric1;
	}

	public void setNumeric1(String numeric1) {
		Numeric1 = numeric1;
	}

	public String getNumeric2() {
		return Numeric2;
	}

	public void setNumeric2(String numeric2) {
		Numeric2 = numeric2;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getCenterLatLong() {
		return CenterLatLong;
	}

	public void setCenterLatLong(String centerLatLong) {
		CenterLatLong = centerLatLong;
	}

	public String getRdspID() {
		return RdspID;
	}

	public void setRdspID(String rdspID) {
		RdspID = rdspID;
	}

	public String getDeliveryType() {
		return DeliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		DeliveryType = deliveryType;
	}

	public String getDeliveryModel() {
		return DeliveryModel;
	}

	public void setDeliveryModel(String deliveryModel) {
		DeliveryModel = deliveryModel;
	}

	public String getUN1() {
		return UN1;
	}

	public void setUN1(String uN1) {
		UN1 = uN1;
	}

	public String getUN2() {
		return UN2;
	}

	public void setUN2(String uN2) {
		UN2 = uN2;
	}

	public String getUN3() {
		return UN3;
	}

	public void setUN3(String uN3) {
		UN3 = uN3;
	}

	public Boolean getBoolean() {
		return Boolean;
	}

	public void setBoolean(Boolean b) {
		Boolean = b;
	}
	
	
}
