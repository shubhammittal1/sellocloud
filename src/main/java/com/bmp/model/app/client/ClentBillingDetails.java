package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.saleorder.BillingOtherCharge;
import com.bmp.bean.saleorder.OrderLbhBean;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="clientBillingDetails")
@AssignKey(assvalue=false)
public class ClentBillingDetails extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Indexed
	private String clientBillingKey;
	@Indexed
	private String awbNumber;
	private StatusMasterNew currentStatus;
	
	@Indexed
	private String clientKey_s;
	
	private String bookingDate;
	
	private String consigneeState;
	private String consigneeCity;
	private String consigneePincode;
	
	private String senderState; // new
	private String senderCity;
	private String senderPincode;
	
	private String productType;
	private String paymentType_s;
	private String serviceMode;
	private String saleOrderNumber_s;
	private Double collectableAmount;
	private Double productPrice;
	private String productName;
	
	private Integer quantity;
	private Double weight;
	private Double volWeight;
	
	private String brand;
	private String serviceType;
	
	private Double billingWeght;
	private Double otherCharge;
	private Double freightRate;
	private Double freightAmount;
	private String zone;
	private Double grossTotal;
	private Double gstAmount;
	private Double fsAmount;
	private Double fovCharge;
	private Double awbCharge;
	private Double codCharge;
	private Double totalAmount;
	private boolean isClientLbhUsed;
	private boolean isError;
	private String errorMsg;
	
	private Map<String,BillingOtherCharge> billingOtherCharges;
	private List<OrderLbhBean> dimensions;
	private List<OrderLbhBean> actualDimensions;
	
	
	public String getClientBillingKey() {
		return clientBillingKey;
	}
	public void setClientBillingKey(String clientBillingKey) {
		this.clientBillingKey = clientBillingKey;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public StatusMasterNew getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(StatusMasterNew currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getClientKey_s() {
		return clientKey_s;
	}
	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
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
	public String getConsigneePincode() {
		return consigneePincode;
	}
	public void setConsigneePincode(String consigneePincode) {
		this.consigneePincode = consigneePincode;
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
	public String getSenderPincode() {
		return senderPincode;
	}
	public void setSenderPincode(String senderPincode) {
		this.senderPincode = senderPincode;
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
	public String getServiceMode() {
		return serviceMode;
	}
	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}
	public String getSaleOrderNumber_s() {
		return saleOrderNumber_s;
	}
	public void setSaleOrderNumber_s(String saleOrderNumber_s) {
		this.saleOrderNumber_s = saleOrderNumber_s;
	}
	public Double getCollectableAmount() {
		return collectableAmount;
	}
	public void setCollectableAmount(Double collectableAmount) {
		this.collectableAmount = collectableAmount;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getVolWeight() {
		return volWeight;
	}
	public void setVolWeight(Double volWeight) {
		this.volWeight = volWeight;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Double getBillingWeght() {
		return billingWeght;
	}
	public void setBillingWeght(Double billingWeght) {
		this.billingWeght = billingWeght;
	}
	
	public Map<String, BillingOtherCharge> getBillingOtherCharges() {
		return billingOtherCharges;
	}
	public void setBillingOtherCharges(Map<String, BillingOtherCharge> billingOtherCharges) {
		this.billingOtherCharges = billingOtherCharges;
	}
	public Double getOtherCharge() {
		return otherCharge;
	}
	public void setOtherCharge(Double otherCharge) {
		this.otherCharge = otherCharge;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	public Double getGstAmount() {
		return gstAmount;
	}
	public void setGstAmount(Double gstAmount) {
		this.gstAmount = gstAmount;
	}
	public Double getFsAmount() {
		return fsAmount;
	}
	public void setFsAmount(Double fsAmount) {
		this.fsAmount = fsAmount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public List<OrderLbhBean> getDimensions() {
		return dimensions;
	}
	public void setDimensions(List<OrderLbhBean> dimensions) {
		this.dimensions = dimensions;
	}
	public List<OrderLbhBean> getActualDimensions() {
		return actualDimensions;
	}
	public void setActualDimensions(List<OrderLbhBean> actualDimensions) {
		this.actualDimensions = actualDimensions;
	}
	public boolean isClientLbhUsed() {
		return isClientLbhUsed;
	}
	public void setClientLbhUsed(boolean isClientLbhUsed) {
		this.isClientLbhUsed = isClientLbhUsed;
	}
	public Double getFovCharge() {
		return fovCharge;
	}
	public void setFovCharge(Double fovCharge) {
		this.fovCharge = fovCharge;
	}
	public Double getAwbCharge() {
		return awbCharge;
	}
	public void setAwbCharge(Double awbCharge) {
		this.awbCharge = awbCharge;
	}
	public Double getFreightRate() {
		return freightRate;
	}
	public void setFreightRate(Double freightRate) {
		this.freightRate = freightRate;
	}
	public Double getFreightAmount() {
		return freightAmount;
	}
	public void setFreightAmount(Double freightAmount) {
		this.freightAmount = freightAmount;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getCodCharge() {
		return codCharge;
	}
	public void setCodCharge(Double codCharge) {
		this.codCharge = codCharge;
	}
	
	
	
	
}
