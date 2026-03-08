package com.bmp.bean.c2c;

import java.math.BigDecimal;


public class C2cPricingResponseBean implements Comparable<C2cPricingResponseBean> {
	
	private String id;
	private String courierName;
	private String displayName;
	private BigDecimal baseWeight;
	private BigDecimal slabWeight;
	private Boolean isLocal;
	private String fromZone;
	private String toZone;
	private BigDecimal basePrice;
	private BigDecimal slabPrice;
	private BigDecimal amount;
	private BigDecimal tax;
	private String serviceType;
	private String tat;
	private Boolean isActive;
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getBaseWeight() {
		return baseWeight;
	}
	public void setBaseWeight(BigDecimal baseWeight) {
		this.baseWeight = baseWeight;
	}
	public BigDecimal getSlabWeight() {
		return slabWeight;
	}
	public void setSlabWeight(BigDecimal slabWeight) {
		this.slabWeight = slabWeight;
	}
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	public BigDecimal getSlabPrice() {
		return slabPrice;
	}
	public void setSlabPrice(BigDecimal slabPrice) {
		this.slabPrice = slabPrice;
	}
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public Boolean getIsLocal() {
		return isLocal;
	}
	public void setIsLocal(Boolean isLocal) {
		this.isLocal = isLocal;
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getTat() {
		return tat;
	}
	public void setTat(String tat) {
		this.tat = tat;
	}
	@Override
	public int compareTo(C2cPricingResponseBean o) {
		return this.amount.compareTo(o.getAmount());
	}
}