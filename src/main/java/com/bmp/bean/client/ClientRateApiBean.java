package com.bmp.bean.client;


public class ClientRateApiBean {
	
	private String clientKey;                  //mandate - Client Key Given by BMP
	private String pickupPincode;              //mandate
	private String consigneePincode;           //mandate
	private Double weight;                     //mandate - Product weight
	private Double length;                     //mandate - Product length
	private Double width;                      //mandate - Product width
	private Double height;                     //mandate - Product height
	private Double collectableAmount;          //mandate - Total Collectible Amount
	private Double shipmentPrice;              //mandate - Declared Product Price
	private String paymentMode;                //mandate - COD/PREPAID
	private String dgProduct;                  //mandate - yes/no
	private String productType;                //optional - default standard

	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
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
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getCollectableAmount() {
		return collectableAmount;
	}
	public void setCollectableAmount(Double collectableAmount) {
		this.collectableAmount = collectableAmount;
	}
	public Double getShipmentPrice() {
		return shipmentPrice;
	}
	public void setShipmentPrice(Double shipmentPrice) {
		this.shipmentPrice = shipmentPrice;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getDgProduct() {
		return dgProduct;
	}
	public void setDgProduct(String dgProduct) {
		this.dgProduct = dgProduct;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}

}
