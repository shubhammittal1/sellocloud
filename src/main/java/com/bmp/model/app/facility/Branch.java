package com.bmp.model.app.facility;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.PaymentType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="branch")
@AssignKey(assvalue=false)
public class Branch extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -6795138052416627564L;

	private String name;
	private String branchCode;
	private String address;
	private String mobileNo;
	private String phoneNo;
	private String emailId;
	private String pincode;
	private String city;
	private String state;
	private String country;
	private Branch parentBranch;
	private Boolean autoAWB;
	private Long capacity;
	private Long maxAmount;
	private PaymentType allowedPaymentMode;
	private Boolean destinationBaggingAllow;
	private Boolean manulManifestAllow;
	private String gstNo;
	
	@Indexed
	private Boolean hub_b;
	@Indexed
	private String parentKey_s;
	@Indexed
	private Boolean franchise_b;
	@Indexed
	private String franchiseKey_s;
	
	private Double latitude;
	private Double longitude;
	private Integer geofencesRange;
	
	public Branch() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Branch getParentBranch() {
		return parentBranch;
	}

	public void setParentBranch(Branch parentBranch) {
		this.parentBranch = parentBranch;
	}

	public String getParentKey_s() {
		return parentKey_s;
	}

	public void setParentKey_s(String parentKey_s) {
		this.parentKey_s = parentKey_s;
	}

	public String getFranchiseKey_s() {
		return franchiseKey_s;
	}

	public void setFranchiseKey_s(String franchiseKey_s) {
		this.franchiseKey_s = franchiseKey_s;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public Long getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Long maxAmount) {
		this.maxAmount = maxAmount;
	}

	public PaymentType getAllowedPaymentMode() {
		return allowedPaymentMode;
	}

	public void setAllowedPaymentMode(PaymentType allowedPaymentMode) {
		this.allowedPaymentMode = allowedPaymentMode;
	}
	
	public Boolean getDestinationBaggingAllow() {
		return destinationBaggingAllow;
	}

	public Boolean getManulManifestAllow() {
		return manulManifestAllow;
	}

	public void setDestinationBaggingAllow(Boolean destinationBaggingAllow) {
		this.destinationBaggingAllow = destinationBaggingAllow;
	}

	public void setManulManifestAllow(Boolean manulManifestAllow) {
		this.manulManifestAllow = manulManifestAllow;
	}

	public Boolean getHub_b() {
		return hub_b;
	}

	public Boolean getAutoAWB() {
		return autoAWB;
	}

	public Boolean getFranchise_b() {
		return franchise_b;
	}

	public void setHub_b(Boolean hub_b) {
		this.hub_b = hub_b;
	}

	public void setAutoAWB(Boolean autoAWB) {
		this.autoAWB = autoAWB;
	}

	public void setFranchise_b(Boolean franchise_b) {
		this.franchise_b = franchise_b;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	

	public Integer getGeofencesRange() {
		return geofencesRange;
	}

	public void setGeofencesRange(Integer geofencesRange) {
		this.geofencesRange = geofencesRange;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
}