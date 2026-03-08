package com.bmp.bean.courier;

import com.bmp.constant.PaymentType;

public class ServiceabilityCheckBean {

	private String sourcePincode;
	private String destinationPincode;
	private String clientKey;
	private PaymentType paymentType;
	private String productType;
	private Boolean perishable;
	private Boolean flammable;
	private String serviceType;
	
	public String getSourcePincode() {
		return sourcePincode;
	}
	
	public void setSourcePincode(String sourcePincode) {
		this.sourcePincode = sourcePincode;
	}
	
	public String getDestinationPincode() {
		return destinationPincode;
	}
	public void setDestinationPincode(String destinationPincode) {
		this.destinationPincode = destinationPincode;
	}
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Boolean getPerishable() {
		return perishable;
	}
	public void setPerishable(Boolean perishable) {
		this.perishable = perishable;
	}
	public Boolean getFlammable() {
		return flammable;
	}
	public void setFlammable(Boolean flammable) {
		this.flammable = flammable;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	
}
