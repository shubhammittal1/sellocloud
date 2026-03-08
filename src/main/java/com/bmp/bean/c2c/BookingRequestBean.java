package com.bmp.bean.c2c;

import java.math.BigDecimal;

public class BookingRequestBean {
	
	private String userId;
	private String packetId;
	private String pickupCity;
	private String pickupDisplayCity;
	private String pickupState;
	private String pickupPincode;
	private String pickupSenderName;
	private String pickupDate;                   
	private String pickupAddress;               
	private String pickupLandmark;             
	private String pickupMobileNumber;           
	private String pickupAlternateNumber; 
	private String pickupEmaiId;
	
	private String consigneeCity;
	private String consigneePincode;
	private String consigneeState;
	private String consigneeName;
	private String consigneeDisplayCity; 
	private String consigneeAddress;            
	private String consigneeLandmark;           
	private String consigneeMobileNumber;        
	private String consigneeAlternateNumber;      
	private String consigneeEmailId;
	
	private String fromZone;
    private String toZone;
	
    private String packetType;
    private String productDescription;
    private String productAmount;
	private String unit;                      
	private BigDecimal weight;                       
	private BigDecimal length;                      
	private BigDecimal width;                        
	private BigDecimal height;  
	private BigDecimal productPrice; 
	private String serviceId;
	private String serviceName;
	private String serviceType;
	
	private String pickupAddListId;
	private String consigneeAddListId;
	
	private String uploadSource;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPacketId() {
		return packetId;
	}
	public void setPacketId(String packetId) {
		this.packetId = packetId;
	}
	public String getPickupCity() {
		return pickupCity;
	}
	public void setPickupCity(String pickupCity) {
		this.pickupCity = pickupCity;
	}
	public String getPickupState() {
		return pickupState;
	}
	public void setPickupState(String pickupState) {
		this.pickupState = pickupState;
	}
	public String getPickupPincode() {
		return pickupPincode;
	}
	public void setPickupPincode(String pickupPincode) {
		this.pickupPincode = pickupPincode;
	}
	public String getPickupSenderName() {
		return pickupSenderName;
	}
	public void setPickupSenderName(String pickupSenderName) {
		this.pickupSenderName = pickupSenderName;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	public String getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	public String getPickupLandmark() {
		return pickupLandmark;
	}
	public void setPickupLandmark(String pickupLandmark) {
		this.pickupLandmark = pickupLandmark;
	}
	public String getPickupMobileNumber() {
		return pickupMobileNumber;
	}
	public void setPickupMobileNumber(String pickupMobileNumber) {
		this.pickupMobileNumber = pickupMobileNumber;
	}
	public String getPickupAlternateNumber() {
		return pickupAlternateNumber;
	}
	public void setPickupAlternateNumber(String pickupAlternateNumber) {
		this.pickupAlternateNumber = pickupAlternateNumber;
	}
	public String getPickupEmaiId() {
		return pickupEmaiId;
	}
	public void setPickupEmaiId(String pickupEmaiId) {
		this.pickupEmaiId = pickupEmaiId;
	}
	public String getConsigneeCity() {
		return consigneeCity;
	}
	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}
	public String getConsigneePincode() {
		return consigneePincode;
	}
	public void setConsigneePincode(String consigneePincode) {
		this.consigneePincode = consigneePincode;
	}
	public String getConsigneeState() {
		return consigneeState;
	}
	public void setConsigneeState(String consigneeState) {
		this.consigneeState = consigneeState;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
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
	public String getConsigneeEmailId() {
		return consigneeEmailId;
	}
	public void setConsigneeEmailId(String consigneeEmailId) {
		this.consigneeEmailId = consigneeEmailId;
	}
	public String getFromZone() {
		return fromZone;
	}
	public void setFromZone(String fromZone) {
		this.fromZone = fromZone;
	}
	public String getToZone() {
		return toZone;
	}
	public void setToZone(String toZone) {
		this.toZone = toZone;
	}
	public String getPacketType() {
		return packetType;
	}
	public void setPacketType(String packetType) {
		this.packetType = packetType;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getPickupDisplayCity() {
		return pickupDisplayCity;
	}
	public void setPickupDisplayCity(String pickupDisplayCity) {
		this.pickupDisplayCity = pickupDisplayCity;
	}
	public String getConsigneeDisplayCity() {
		return consigneeDisplayCity;
	}
	public void setConsigneeDisplayCity(String consigneeDisplayCity) {
		this.consigneeDisplayCity = consigneeDisplayCity;
	}
	public String getPickupAddListId() {
		return pickupAddListId;
	}
	public void setPickupAddListId(String pickupAddListId) {
		this.pickupAddListId = pickupAddListId;
	}
	public String getConsigneeAddListId() {
		return consigneeAddListId;
	}
	public void setConsigneeAddListId(String consigneeAddListId) {
		this.consigneeAddListId = consigneeAddListId;
	}
	public String getUploadSource() {
		return uploadSource;
	}
	public void setUploadSource(String uploadSource) {
		this.uploadSource = uploadSource;
	}
	
}
