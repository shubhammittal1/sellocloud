package com.bmp.model.app.wms;

import org.springframework.data.mongodb.core.index.Indexed;

public class OrderPackagingSku {

	private String orderSkuKey;
	@Indexed
	private String skuCode;
	private String skuName;
	private String skuImageUrl;
	private Integer quantity;
	private double totalAmount;
	private double codAmount;
	private double singleSkuPrice;
	private double skuMrp;
	private double taxPercentage;
	private double taxAmount;
	private Integer badQuantity;
	private String qcReason;
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getCodAmount() {
		return codAmount;
	}
	public void setCodAmount(double codAmount) {
		this.codAmount = codAmount;
	}
	public double getSingleSkuPrice() {
		return singleSkuPrice;
	}
	public void setSingleSkuPrice(double singleSkuPrice) {
		this.singleSkuPrice = singleSkuPrice;
	}
	public double getSkuMrp() {
		return skuMrp;
	}
	public void setSkuMrp(double skuMrp) {
		this.skuMrp = skuMrp;
	}
	public double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSkuImageUrl() {
		return skuImageUrl;
	}
	public void setSkuImageUrl(String skuImageUrl) {
		this.skuImageUrl = skuImageUrl;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrderSkuKey() {
		return orderSkuKey;
	}
	public void setOrderSkuKey(String orderSkuKey) {
		this.orderSkuKey = orderSkuKey;
	}
	public Integer getBadQuantity() {
		return badQuantity;
	}
	public void setBadQuantity(Integer badQuantity) {
		this.badQuantity = badQuantity;
	}
	public String getQcReason() {
		return qcReason;
	}
	public void setQcReason(String qcReason) {
		this.qcReason = qcReason;
	}
	

}
