package com.bmp.bean.pickup;

import java.util.List;

public class AppPickupBean {

	  	private Long pickupDateTimeLong_l;
	    private Integer expectedPackageCount;
	    private Integer actualPackageCount;
	    private String clientName;
	    private String branchName;
	    private String status;
	    private String notPickReason;
	    private List<String> awbNumbers;
	    private String pickupSheet_s;
		private String warehouseName_s;
		private String contactPersonName;
		private String mobileNumber;
		private String state;
		private String country;
		private String city;
		private String address;
		private String landmark;
		private String pincode;
		private String pickupRequestId;
		private String orderType;
		private String altPhoneNumber;
		private boolean appCalling;
		private String clientManifestNo;
		private boolean isPickupOtpRequired = false;
		private String pickOtp;
		
		public Long getPickupDateTimeLong_l() {
			return pickupDateTimeLong_l;
		}
		public void setPickupDateTimeLong_l(Long pickupDateTimeLong_l) {
			this.pickupDateTimeLong_l = pickupDateTimeLong_l;
		}
		public Integer getExpectedPackageCount() {
			return expectedPackageCount;
		}
		public void setExpectedPackageCount(Integer expectedPackageCount) {
			this.expectedPackageCount = expectedPackageCount;
		}
		public Integer getActualPackageCount() {
			return actualPackageCount;
		}
		public void setActualPackageCount(Integer actualPackageCount) {
			this.actualPackageCount = actualPackageCount;
		}
		public String getClientName() {
			return clientName;
		}
		public void setClientName(String clientName) {
			this.clientName = clientName;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getNotPickReason() {
			return notPickReason;
		}
		public void setNotPickReason(String notPickReason) {
			this.notPickReason = notPickReason;
		}
		public List<String> getAwbNumbers() {
			return awbNumbers;
		}
		public void setAwbNumbers(List<String> awbNumbers) {
			this.awbNumbers = awbNumbers;
		}
		public String getPickupSheet_s() {
			return pickupSheet_s;
		}
		public void setPickupSheet_s(String pickupSheet_s) {
			this.pickupSheet_s = pickupSheet_s;
		}
		public String getWarehouseName_s() {
			return warehouseName_s;
		}
		public void setWarehouseName_s(String warehouseName_s) {
			this.warehouseName_s = warehouseName_s;
		}
		public String getContactPersonName() {
			return contactPersonName;
		}
		public void setContactPersonName(String contactPersonName) {
			this.contactPersonName = contactPersonName;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
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
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getLandmark() {
			return landmark;
		}
		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getPickupRequestId() {
			return pickupRequestId;
		}
		public void setPickupRequestId(String pickupRequestId) {
			this.pickupRequestId = pickupRequestId;
		}
		public String getOrderType() {
			return orderType;
		}
		public void setOrderType(String orderType) {
			this.orderType = orderType;
		}
		public String getAltPhoneNumber() {
			return altPhoneNumber;
		}
		public void setAltPhoneNumber(String altPhoneNumber) {
			this.altPhoneNumber = altPhoneNumber;
		}
		public boolean isAppCalling() {
			return appCalling;
		}
		public void setAppCalling(boolean appCalling) {
			this.appCalling = appCalling;
		}
		public String getClientManifestNo() {
			return clientManifestNo;
		}
		public void setClientManifestNo(String clientManifestNo) {
			this.clientManifestNo = clientManifestNo;
		}
		public boolean isPickupOtpRequired() {
			return isPickupOtpRequired;
		}
		public void setPickupOtpRequired(boolean isPickupOtpRequired) {
			this.isPickupOtpRequired = isPickupOtpRequired;
		}
		public String getPickOtp() {
			return pickOtp;
		}
		public void setPickOtp(String pickOtp) {
			this.pickOtp = pickOtp;
		}
		
}
