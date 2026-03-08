package com.bmp.bean.drs;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrsCloseBean implements Serializable{

	private String endKm;
	private String awbNumber;
	private String statusKey;
	private String settingKey;
	private String name;
	private String mobileNo;
	private Double collectableAmount;
	private String userKey;
	private String idProofType;
	private String idProofNo;
	private String deliveryOtp;
	private String rescheduleDate;
	private Double lat;
	private Double lng;
	private String otp;
	private String receiverRelation;
	
	
	public DrsCloseBean() {
		super();
	}

	public String getEndKm() {
		return endKm;
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public String getStatusKey() {
		return statusKey;
	}

	public String getSettingKey() {
		return settingKey;
	}

	public String getName() {
		return name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public Double getCollectableAmount() {
		return collectableAmount;
	}

	

	public void setEndKm(String endKm) {
		this.endKm = endKm;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}

	public void setSettingKey(String settingKey) {
		this.settingKey = settingKey;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setCollectableAmount(Double collectableAmount) {
		this.collectableAmount = collectableAmount;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProofNo() {
		return idProofNo;
	}

	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}

	public String getDeliveryOtp() {
		return deliveryOtp;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public void setDeliveryOtp(String deliveryOtp) {
		this.deliveryOtp = deliveryOtp;
	}

	public String getRescheduleDate() {
		return rescheduleDate;
	}

	public void setRescheduleDate(String rescheduleDate) {
		this.rescheduleDate = rescheduleDate;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getReceiverRelation() {
		return receiverRelation;
	}

	public void setReceiverRelation(String receiverRelation) {
		this.receiverRelation = receiverRelation;
	}
	
}
