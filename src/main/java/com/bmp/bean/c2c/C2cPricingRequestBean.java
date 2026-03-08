package com.bmp.bean.c2c;

import java.math.BigDecimal;

public class C2cPricingRequestBean {
	
	private String courierName;
	private BigDecimal baseWeight;
	private BigDecimal slabWeight;
	private Boolean isLocal;
	private String fromZone;
	private String toZone;
	private BigDecimal basePrice;
	private BigDecimal slabPrice;
	private String serviceType;
	private Boolean isActive;
	private String fromPincode;
	private String toPincode;
	private String fromCity;
	private String toCity;
	private String displayName;
	private String dR;
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getFromPincode() {
		return fromPincode;
	}
	public void setFromPincode(String fromPincode) {
		this.fromPincode = fromPincode;
	}
	public String getToPincode() {
		return toPincode;
	}
	public void setToPincode(String toPincode) {
		this.toPincode = toPincode;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getdR() {
		return dR;
	}
	public void setdR(String dR) {
		this.dR = dR;
	}
	

}
