package com.bmp.bean.c2c;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBean {
	
    private BigDecimal weight;
    private BigDecimal length;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal packetPrice;
    private String pickupPincode;
    private String consigneePincode;
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
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getPacketPrice() {
		return packetPrice;
	}
	public void setPacketPrice(BigDecimal packetPrice) {
		this.packetPrice = packetPrice;
	}
	public String getPickupPincode() {
		return pickupPincode;
	}
	public void setPickupPincode(String pickupPincode) {
		this.pickupPincode = pickupPincode;
	}
	public String getConsigneePincode() {
		return consigneePincode;
	}
	public void setConsigneePincode(String consigneePincode) {
		this.consigneePincode = consigneePincode;
	}
	
	
}
