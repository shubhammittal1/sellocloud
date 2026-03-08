package com.bmp.model.app.saleorder;

import java.util.List;

import com.bmp.constant.PaymentType;

public class MarketPlaceOrderShipping {

	private String awbNumber;
	private String warehouseKey;
	private String courierKey;
	private String courierName;
	private String courierAwbNumber;
	private Double weight;
	private Double amount;
	private Double codAmount;
	private PaymentType paymentType;
	private List<MarketPlaceFulfilledOrderSku> fulfilledSkus;
	
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getCourierKey() {
		return courierKey;
	}
	public void setCourierKey(String courierKey) {
		this.courierKey = courierKey;
	}
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public String getCourierAwbNumber() {
		return courierAwbNumber;
	}
	public void setCourierAwbNumber(String courierAwbNumber) {
		this.courierAwbNumber = courierAwbNumber;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getCodAmount() {
		return codAmount;
	}
	public void setCodAmount(Double codAmount) {
		this.codAmount = codAmount;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public List<MarketPlaceFulfilledOrderSku> getFulfilledSkus() {
		return fulfilledSkus;
	}
	public void setFulfilledSkus(List<MarketPlaceFulfilledOrderSku> fulfilledSkus) {
		this.fulfilledSkus = fulfilledSkus;
	}
	public String getWarehouseKey() {
		return warehouseKey;
	}
	public void setWarehouseKey(String warehouseKey) {
		this.warehouseKey = warehouseKey;
	}
	
	
}
