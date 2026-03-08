package com.bmp.bean.client;

import java.util.List;
import java.util.Map;

import com.bmp.bean.saleorder.BillingOtherCharge;
import com.bmp.bean.saleorder.OrderLbhBean;

public class ShippingChargeBean {
	private String awb;
	private String clientKey;
	private String courierKey;
	private String zone;
	private String fromToZone;
	private Integer quantity;
	private Double weight;
	private Double volWeight;
	
	private Double billingWeght;
	private Double totalOtherCharge;
	private Double freightRate;
	private Double freightAmount;
	private Double grossTotal;
	private Double gstAmount;
	private Double fscAmount;
	private Double fovCharge;
	private Double awbCharge;
	private Double totalAmount;
	
	private Map<String,Double> otherCharges;
	private List<OrderLbhBean> dimensions;
	public String getAwb() {
		return awb;
	}
	public void setAwb(String awb) {
		this.awb = awb;
	}
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getCourierKey() {
		return courierKey;
	}
	public void setCourierKey(String courierKey) {
		this.courierKey = courierKey;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
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
	public Double getBillingWeght() {
		return billingWeght;
	}
	public void setBillingWeght(Double billingWeght) {
		this.billingWeght = billingWeght;
	}
	
	public Double getTotalOtherCharge() {
		return totalOtherCharge;
	}
	public void setTotalOtherCharge(Double totalOtherCharge) {
		this.totalOtherCharge = totalOtherCharge;
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
	
	public Double getFscAmount() {
		return fscAmount;
	}
	public void setFscAmount(Double fscAmount) {
		this.fscAmount = fscAmount;
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
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Map<String, Double> getOtherCharges() {
		return otherCharges;
	}
	public void setOtherCharges(Map<String, Double> otherCharges) {
		this.otherCharges = otherCharges;
	}
	public List<OrderLbhBean> getDimensions() {
		return dimensions;
	}
	public void setDimensions(List<OrderLbhBean> dimensions) {
		this.dimensions = dimensions;
	}
	public String getFromToZone() {
		return fromToZone;
	}
	public void setFromToZone(String fromToZone) {
		this.fromToZone = fromToZone;
	}

}
