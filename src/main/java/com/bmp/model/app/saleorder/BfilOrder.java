package com.bmp.model.app.saleorder;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="bfilOrder")
@AssignKey(assvalue=false)
public class BfilOrder extends MongoBaseBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

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
	
	@Indexed
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
	private String SmName;
	
	@JsonProperty("SMNumber")
	private String SmNumber;
	
	@JsonProperty("BMName")
	private String BmName;
	
	@JsonProperty("BMNumber")
	private String BmNumber;
	
	@JsonProperty("Text1")
	private String Text1;
	
	@JsonProperty("Text2")
	private String Text2;
	
	@JsonProperty("Numeric1")
	private String Numeric1;
	
	@JsonProperty("Numeric2")
	private String Numeric2;
	
	//New fields
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
	
	//Manage fields 
	@Indexed
	private Boolean isOrderConvert;
	@Indexed
	private Boolean isOrderPushInRal;
	@Indexed
	private Boolean isOrderCancel;
	@Indexed
	private Boolean errorAtConvertingOrder;
	private String errorMsg;
	
	private BfilOrderCancel bfilOrderCancel;
	private BfilRdspProductReceived bfilRdspProductReceived;
	private BfilRdspProductMemberHandover bfilRdspProductMemberHandover;
	private BfilDeliveryModelUpdate bfilDeliveryModelUpdate;
	private BfilReturnToVendor bfilReturnToVendor;
	
	public BfilOrder() {
		super();
	}

	@JsonProperty("BatchNumber")
	public String getBatchNumber() {
		return BatchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		BatchNumber = batchNumber;
	}

	@JsonProperty("BatchDate")
	public String getBatchDate() {
		return BatchDate;
	}

	public void setBatchDate(String batchDate) {
		BatchDate = batchDate;
	}

	@JsonProperty("BranchID")
	public String getBranchID() {
		return BranchID;
	}

	public void setBranchID(String branchID) {
		BranchID = branchID;
	}

	@JsonProperty("BranchName")
	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}

	@JsonProperty("LoanApprovaldate")
	public String getLoanApprovaldate() {
		return LoanApprovaldate;
	}

	public void setLoanApprovaldate(String loanApprovaldate) {
		LoanApprovaldate = loanApprovaldate;
	}

	@JsonProperty("LoanProposalID")
	public String getLoanProposalID() {
		return LoanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		LoanProposalID = loanProposalID;
	}

	@JsonProperty("ProposalID")
	public String getProposalID() {
		return ProposalID;
	}

	public void setProposalID(String proposalID) {
		ProposalID = proposalID;
	}

	@JsonProperty("ClientID")
	public String getClientID() {
		return ClientID;
	}

	public void setClientID(String clientID) {
		ClientID = clientID;
	}

	@JsonProperty("ClientUniqueID")
	public String getClientUniqueID() {
		return ClientUniqueID;
	}

	public void setClientUniqueID(String clientUniqueID) {
		ClientUniqueID = clientUniqueID;
	}

	@JsonProperty("ClientName")
	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	@JsonProperty("ProductID")
	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	@JsonProperty("Model")
	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	@JsonProperty("MemberOfferPrice")
	public String getMemberOfferPrice() {
		return MemberOfferPrice;
	}

	public void setMemberOfferPrice(String memberOfferPrice) {
		MemberOfferPrice = memberOfferPrice;
	}

	@JsonProperty("VendorId")
	public String getVendorId() {
		return VendorId;
	}

	public void setVendorId(String vendorId) {
		VendorId = vendorId;
	}

	@JsonProperty("SupplierName")
	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	@JsonProperty("AddressLine1")
	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	@JsonProperty("AddressLine2")
	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	@JsonProperty("Landmark")
	public String getLandmark() {
		return Landmark;
	}

	public void setLandmark(String landmark) {
		Landmark = landmark;
	}

	@JsonProperty("Village")
	public String getVillage() {
		return Village;
	}

	public void setVillage(String village) {
		Village = village;
	}

	@JsonProperty("DistrictName")
	public String getDistrictName() {
		return DistrictName;
	}

	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}

	@JsonProperty("StateName")
	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	@JsonProperty("Pincode")
	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	@JsonProperty("MobileNumber")
	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	@JsonProperty("MemberAlternateMobileNumber")
	public String getMemberAlternateMobileNumber() {
		return MemberAlternateMobileNumber;
	}

	public void setMemberAlternateMobileNumber(String memberAlternateMobileNumber) {
		MemberAlternateMobileNumber = memberAlternateMobileNumber;
	}

	@JsonProperty("SpouseName")
	public String getSpouseName() {
		return SpouseName;
	}

	public void setSpouseName(String spouseName) {
		SpouseName = spouseName;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@JsonProperty("FatherName")
	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	@JsonProperty("SMName")
	public String getSmName() {
		return SmName;
	}

	public void setSmName(String smName) {
		SmName = smName;
	}

	@JsonProperty("SMNumber")
	public String getSmNumber() {
		return SmNumber;
	}

	public void setSmNumber(String smNumber) {
		SmNumber = smNumber;
	}

	@JsonProperty("BMName")
	public String getBmName() {
		return BmName;
	}

	public void setBmName(String bmName) {
		BmName = bmName;
	}

	@JsonProperty("BMNumber")
	public String getBmNumber() {
		return BmNumber;
	}

	public void setBmNumber(String bmNumber) {
		BmNumber = bmNumber;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@JsonProperty("CenterLatLong")
	public String getCenterLatLong() {
		return CenterLatLong;
	}

	public void setCenterLatLong(String centerLatLong) {
		CenterLatLong = centerLatLong;
	}

	@JsonProperty("RdspID")
	public String getRdspID() {
		return RdspID;
	}

	public void setRdspID(String rdspID) {
		RdspID = rdspID;
	}

	@JsonProperty("DeliveryType")
	public String getDeliveryType() {
		return DeliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		DeliveryType = deliveryType;
	}

	@JsonProperty("DeliveryModel")
	public String getDeliveryModel() {
		return DeliveryModel;
	}

	public void setDeliveryModel(String deliveryModel) {
		DeliveryModel = deliveryModel;
	}

	@JsonProperty("UN1")
	public String getUN1() {
		return UN1;
	}

	public void setUN1(String uN1) {
		UN1 = uN1;
	}

	@JsonProperty("UN2")
	public String getUN2() {
		return UN2;
	}

	public void setUN2(String uN2) {
		UN2 = uN2;
	}

	@JsonProperty("UN3")
	public String getUN3() {
		return UN3;
	}

	public void setUN3(String uN3) {
		UN3 = uN3;
	}

	@JsonProperty("Boolean")
	public Boolean getBoolean() {
		return Boolean;
	}

	public void setBoolean(Boolean b) {
		Boolean = b;
	}

	public Boolean getIsOrderConvert() {
		return isOrderConvert;
	}

	public void setIsOrderConvert(Boolean isOrderConvert) {
		this.isOrderConvert = isOrderConvert;
	}

	public Boolean getIsOrderPushInRal() {
		return isOrderPushInRal;
	}

	public void setIsOrderPushInRal(Boolean isOrderPushInRal) {
		this.isOrderPushInRal = isOrderPushInRal;
	}

	public Boolean getIsOrderCancel() {
		return isOrderCancel;
	}

	public void setIsOrderCancel(Boolean isOrderCancel) {
		this.isOrderCancel = isOrderCancel;
	}

	public BfilOrderCancel getBfilOrderCancel() {
		return bfilOrderCancel;
	}

	public void setBfilOrderCancel(BfilOrderCancel bfilOrderCancel) {
		this.bfilOrderCancel = bfilOrderCancel;
	}

	public Boolean getErrorAtConvertingOrder() {
		return errorAtConvertingOrder;
	}

	public void setErrorAtConvertingOrder(Boolean errorAtConvertingOrder) {
		this.errorAtConvertingOrder = errorAtConvertingOrder;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public BfilRdspProductReceived getBfilRdspProductReceived() {
		return bfilRdspProductReceived;
	}

	public void setBfilRdspProductReceived(BfilRdspProductReceived bfilRdspProductReceived) {
		this.bfilRdspProductReceived = bfilRdspProductReceived;
	}

	public BfilRdspProductMemberHandover getBfilRdspProductMemberHandover() {
		return bfilRdspProductMemberHandover;
	}

	public void setBfilRdspProductMemberHandover(BfilRdspProductMemberHandover bfilRdspProductMemberHandover) {
		this.bfilRdspProductMemberHandover = bfilRdspProductMemberHandover;
	}

	public BfilDeliveryModelUpdate getBfilDeliveryModelUpdate() {
		return bfilDeliveryModelUpdate;
	}

	public void setBfilDeliveryModelUpdate(BfilDeliveryModelUpdate bfilDeliveryModelUpdate) {
		this.bfilDeliveryModelUpdate = bfilDeliveryModelUpdate;
	}

	public BfilReturnToVendor getBfilReturnToVendor() {
		return bfilReturnToVendor;
	}

	public void setBfilReturnToVendor(BfilReturnToVendor bfilReturnToVendor) {
		this.bfilReturnToVendor = bfilReturnToVendor;
	}

	
	

	

	
	
}
