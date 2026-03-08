package com.bmp.model.c2c;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="c2cPricing")
@AssignKey(assvalue=true)
public class C2cPricing extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String courierName_s;
	@Indexed
	private String displayName_s;
	
	private BigDecimal baseWeight;
	private BigDecimal slabWeight;
	private BigDecimal basePrice;
	private BigDecimal slabPrice;
	
	@Indexed
	private Boolean isLocal_b;
	@Indexed
	private String serviceType_s;
	@Indexed
	private String fromZone_s;
	@Indexed
	private String toZone_s;
	
	private Boolean isActive;
	private String tat;
	
	
	public String getCourierName_s() {
		return courierName_s;
	}
	public void setCourierName_s(String courierName_s) {
		this.courierName_s = courierName_s;
	}
	public String getDisplayName_s() {
		return displayName_s;
	}
	public void setDisplayName_s(String displayName_s) {
		this.displayName_s = displayName_s;
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
	public Boolean getIsLocal_b() {
		return isLocal_b;
	}
	public void setIsLocal_b(Boolean isLocal_b) {
		this.isLocal_b = isLocal_b;
	}
	public String getServiceType_s() {
		return serviceType_s;
	}
	public void setServiceType_s(String serviceType_s) {
		this.serviceType_s = serviceType_s;
	}
	public String getFromZone_s() {
		return fromZone_s;
	}
	public void setFromZone_s(String fromZone_s) {
		this.fromZone_s = fromZone_s;
	}
	public String getToZone_s() {
		return toZone_s;
	}
	public void setToZone_s(String toZone_s) {
		this.toZone_s = toZone_s;
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

}
