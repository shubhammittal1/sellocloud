package com.bmp.bean.drs;

import java.util.List;

import com.bmp.constant.DeliveryType;

public class SaleOrderAppBean {
	   
	   private String lastRefreshTime;
	   private String key_s;
	   private String createdDate_l;
	   private String awbNumber;
	   private String clientKey_s;
	   private String pickupSheetKey_s;
	   private String pickupRequestKey_s;
	   private String senderName;
	   private String senderMobileNumber_s;
	   private String senderAltNumber;
	   private String senderEmail;
	   private String senderCountry;
	   private String senderState;
	   private String senderCity;
	   private String senderAddress;
	   private String senderLandmark;
	   private String senderPincode_s;
	   private String consigneeName;
	   private String consigneeMobileNumber_s;
	   private String consigneeAlternateNumber;
	   private String consigneeEmailId;
	   private String consigneeCountry;
	   private String consigneeState;
	   private String consigneeCity;
	   private String consigneeAddress;
	   private String consigneeLandmark;
	   private String consigneePincode_s;
	   private String productType;
	   private String paymentType_s;
	   private String saleOrderNumber_s;
	   private String saleOrderDate;
	   private String productName;
	   private String collectableAmount;
	   private String productPrice;
	   private String drsAttemptedCount;
	   private List<String> drsList_ss;
	   private String reason;
	   private String packetStatus;
	   private String sourceLatLong;               //optional
	   private String destLatLong;
	   private boolean otpActive;
	   private boolean idproofActive;
	   private String deliveryOtp;
	   private boolean appCalling;
	   private DeliveryType deliveryType;
	   private String orderType_s;
	   private String otp1;
	   private String otp2;
	   private String otp3;
	   private String consigneeMobileNumberActual;
	   private String clientPodSampleUrls;
	   
	public String getLastRefreshTime() {
		return lastRefreshTime;
	}
	public void setLastRefreshTime(String lastRefreshTime) {
		this.lastRefreshTime = lastRefreshTime;
	}
	public String getKey_s() {
		return key_s;
	}
	public void setKey_s(String key_s) {
		this.key_s = key_s;
	}
	public String getCreatedDate_l() {
		return createdDate_l;
	}
	public void setCreatedDate_l(String createdDate_l) {
		this.createdDate_l = createdDate_l;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getClientKey_s() {
		return clientKey_s;
	}
	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}
	public String getPickupSheetKey_s() {
		return pickupSheetKey_s;
	}
	public void setPickupSheetKey_s(String pickupSheetKey_s) {
		this.pickupSheetKey_s = pickupSheetKey_s;
	}
	public String getPickupRequestKey_s() {
		return pickupRequestKey_s;
	}
	public void setPickupRequestKey_s(String pickupRequestKey_s) {
		this.pickupRequestKey_s = pickupRequestKey_s;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderMobileNumber_s() {
		return senderMobileNumber_s;
	}
	public void setSenderMobileNumber_s(String senderMobileNumber_s) {
		this.senderMobileNumber_s = senderMobileNumber_s;
	}
	public String getSenderAltNumber() {
		return senderAltNumber;
	}
	public void setSenderAltNumber(String senderAltNumber) {
		this.senderAltNumber = senderAltNumber;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getSenderCountry() {
		return senderCountry;
	}
	public void setSenderCountry(String senderCountry) {
		this.senderCountry = senderCountry;
	}
	public String getSenderState() {
		return senderState;
	}
	public void setSenderState(String senderState) {
		this.senderState = senderState;
	}
	public String getSenderCity() {
		return senderCity;
	}
	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getSenderLandmark() {
		return senderLandmark;
	}
	public void setSenderLandmark(String senderLandmark) {
		this.senderLandmark = senderLandmark;
	}
	public String getSenderPincode_s() {
		return senderPincode_s;
	}
	public void setSenderPincode_s(String senderPincode_s) {
		this.senderPincode_s = senderPincode_s;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeMobileNumber_s() {
		return consigneeMobileNumber_s;
	}
	public void setConsigneeMobileNumber_s(String consigneeMobileNumber_s) {
		this.consigneeMobileNumber_s = consigneeMobileNumber_s;
	}
	public String getConsigneeAlternateNumber() {
		return consigneeAlternateNumber;
	}
	public void setConsigneeAlternateNumber(String consigneeAlternateNumber) {
		this.consigneeAlternateNumber = consigneeAlternateNumber;
	}
	public String getConsigneeEmailId() {
		return consigneeEmailId;
	}
	public void setConsigneeEmailId(String consigneeEmailId) {
		this.consigneeEmailId = consigneeEmailId;
	}
	public String getConsigneeCountry() {
		return consigneeCountry;
	}
	public void setConsigneeCountry(String consigneeCountry) {
		this.consigneeCountry = consigneeCountry;
	}
	public String getConsigneeState() {
		return consigneeState;
	}
	public void setConsigneeState(String consigneeState) {
		this.consigneeState = consigneeState;
	}
	public String getConsigneeCity() {
		return consigneeCity;
	}
	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getConsigneeLandmark() {
		return consigneeLandmark;
	}
	public void setConsigneeLandmark(String consigneeLandmark) {
		this.consigneeLandmark = consigneeLandmark;
	}
	public String getConsigneePincode_s() {
		return consigneePincode_s;
	}
	public void setConsigneePincode_s(String consigneePincode_s) {
		this.consigneePincode_s = consigneePincode_s;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getPaymentType_s() {
		return paymentType_s;
	}
	public void setPaymentType_s(String paymentType_s) {
		this.paymentType_s = paymentType_s;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCollectableAmount() {
		return collectableAmount;
	}
	public void setCollectableAmount(String collectableAmount) {
		this.collectableAmount = collectableAmount;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getDrsAttemptedCount() {
		return drsAttemptedCount;
	}
	public void setDrsAttemptedCount(String drsAttemptedCount) {
		this.drsAttemptedCount = drsAttemptedCount;
	}
	public List<String> getDrsList_ss() {
		return drsList_ss;
	}
	public void setDrsList_ss(List<String> drsList_ss) {
		this.drsList_ss = drsList_ss;
	}
	
	public String getPacketStatus() {
		return packetStatus;
	}
	public void setPacketStatus(String packetStatus) {
		this.packetStatus = packetStatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSourceLatLong() {
		return sourceLatLong;
	}
	public String getDestLatLong() {
		return destLatLong;
	}
	public void setSourceLatLong(String sourceLatLong) {
		this.sourceLatLong = sourceLatLong;
	}
	public void setDestLatLong(String destLatLong) {
		this.destLatLong = destLatLong;
	}
	public boolean isOtpActive() {
		return otpActive;
	}
	public void setOtpActive(boolean otpActive) {
		this.otpActive = otpActive;
	}
	public boolean isIdproofActive() {
		return idproofActive;
	}
	public void setIdproofActive(boolean idproofActive) {
		this.idproofActive = idproofActive;
	}
	public String getDeliveryOtp() {
		return deliveryOtp;
	}
	public void setDeliveryOtp(String deliveryOtp) {
		this.deliveryOtp = deliveryOtp;
	}
	public boolean isAppCalling() {
		return appCalling;
	}
	public void setAppCalling(boolean appCalling) {
		this.appCalling = appCalling;
	}
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getOrderType_s() {
		return orderType_s;
	}
	public void setOrderType_s(String orderType_s) {
		this.orderType_s = orderType_s;
	}
	public String getOtp1() {
		return otp1;
	}
	public void setOtp1(String otp1) {
		this.otp1 = otp1;
	}
	public String getOtp2() {
		return otp2;
	}
	public void setOtp2(String otp2) {
		this.otp2 = otp2;
	}
	public String getOtp3() {
		return otp3;
	}
	public void setOtp3(String otp3) {
		this.otp3 = otp3;
	}
	public String getConsigneeMobileNumberActual() {
		return consigneeMobileNumberActual;
	}
	public void setConsigneeMobileNumberActual(String consigneeMobileNumberActual) {
		this.consigneeMobileNumberActual = consigneeMobileNumberActual;
	}
	public String getClientPodSampleUrls() {
		return clientPodSampleUrls;
	}
	public void setClientPodSampleUrls(String clientPodSampleUrls) {
		this.clientPodSampleUrls = clientPodSampleUrls;
	}
	
	
	   
}
