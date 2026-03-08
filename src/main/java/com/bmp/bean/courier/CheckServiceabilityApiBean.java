package com.bmp.bean.courier;


public class CheckServiceabilityApiBean {
	
	private String sourcePincode;
	private String destinationPincode;
	private String paymentType;
	private String productType;
	private String dgProduct;
	private String clientName;
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
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getDgProduct() {
		return dgProduct;
	}
	public void setDgProduct(String dgProduct) {
		this.dgProduct = dgProduct;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

}
