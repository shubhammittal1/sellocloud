package com.bmp.bean.saleorder;

import java.io.Serializable;

public class ShipmentPodBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String awbNumber;
	private String saleOrderNumber_s;
	private String saleOrderDate;
	private String destinationBranch_s;
	private String consigneeName;
	private String consigneeMobileNumber;
	private String consigneeAlternateNumber;
	private String productName;
	private String productPrice;
	private String currentStatus;
	
	private String deliveredPresonName;
	private String deliveredPresonMobileNo;
	private String idProofType;
	private String idProofNo;
	private String receiverRelation;
	private String deliveryOtp;
	private String userSignature;
	private String userIdimage;
	private String deliveryType;
	private boolean podExist;
	
	public ShipmentPodBean() {
		super();
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getSaleOrderNumber_s() {
		return saleOrderNumber_s;
	}

	public void setSaleOrderNumber_s(String saleOrderNumber_s) {
		this.saleOrderNumber_s = saleOrderNumber_s;
	}

	public String getSaleOrderDate() {
		return saleOrderDate;
	}

	public void setSaleOrderDate(String saleOrderDate) {
		this.saleOrderDate = saleOrderDate;
	}

	public String getDestinationBranch_s() {
		return destinationBranch_s;
	}

	public void setDestinationBranch_s(String destinationBranch_s) {
		this.destinationBranch_s = destinationBranch_s;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeMobileNumber() {
		return consigneeMobileNumber;
	}

	public void setConsigneeMobileNumber(String consigneeMobileNumber) {
		this.consigneeMobileNumber = consigneeMobileNumber;
	}

	public String getConsigneeAlternateNumber() {
		return consigneeAlternateNumber;
	}

	public void setConsigneeAlternateNumber(String consigneeAlternateNumber) {
		this.consigneeAlternateNumber = consigneeAlternateNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getDeliveredPresonName() {
		return deliveredPresonName;
	}

	public void setDeliveredPresonName(String deliveredPresonName) {
		this.deliveredPresonName = deliveredPresonName;
	}

	public String getDeliveredPresonMobileNo() {
		return deliveredPresonMobileNo;
	}

	public void setDeliveredPresonMobileNo(String deliveredPresonMobileNo) {
		this.deliveredPresonMobileNo = deliveredPresonMobileNo;
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

	public String getReceiverRelation() {
		return receiverRelation;
	}

	public void setReceiverRelation(String receiverRelation) {
		this.receiverRelation = receiverRelation;
	}

	public String getDeliveryOtp() {
		return deliveryOtp;
	}

	public void setDeliveryOtp(String deliveryOtp) {
		this.deliveryOtp = deliveryOtp;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public String getUserIdimage() {
		return userIdimage;
	}

	public void setUserIdimage(String userIdimage) {
		this.userIdimage = userIdimage;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public boolean isPodExist() {
		return podExist;
	}

	public void setPodExist(boolean podExist) {
		this.podExist = podExist;
	}
	
	
	
}
