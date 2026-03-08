package com.bmp.model.app.saleorder;

public class MarketPlaceOrderSku {
	private String skuCode;
	private String skuName;
	private Boolean closed;
	private Double originalUnitPrice;
	private Double discountedUnitPrice;
	private Double taxPercentage;
	private Double totalTaxAmount;
	private Double toatlAmount;
	private Double weight;
	private Double length;
	private Double width;
	private Double hight;
	private String imageUrl;
	private Integer quantity = 0;
	private Integer fulfilledQuantity = 0;
	private Integer nonFulfillableQuantity = 0;
	private Integer unfulfilledQuantity = 0;
	private String marketPlaceFulfillmentOrderId;
	private String marketPlaceFulfillmentOrderItemId;
	private String marketPlaceInventoryItemId;
	private Address pickupLocationAddress;
	
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
	public Boolean getClosed() {
		return closed;
	}
	public void setClosed(Boolean closed) {
		this.closed = closed;
	}
	public Double getOriginalUnitPrice() {
		return originalUnitPrice;
	}
	public void setOriginalUnitPrice(Double originalUnitPrice) {
		this.originalUnitPrice = originalUnitPrice;
	}
	public Double getDiscountedUnitPrice() {
		return discountedUnitPrice;
	}
	public void setDiscountedUnitPrice(Double discountedUnitPrice) {
		this.discountedUnitPrice = discountedUnitPrice;
	}
	public Double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(Double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	public Double getTotalTaxAmount() {
		return totalTaxAmount;
	}
	public void setTotalTaxAmount(Double totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}
	public Double getToatlAmount() {
		return toatlAmount;
	}
	public void setToatlAmount(Double toatlAmount) {
		this.toatlAmount = toatlAmount;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getFulfilledQuantity() {
		return fulfilledQuantity;
	}
	public void setFulfilledQuantity(Integer fulfilledQuantity) {
		this.fulfilledQuantity = fulfilledQuantity;
	}
	public String getMarketPlaceFulfillmentOrderId() {
		return marketPlaceFulfillmentOrderId;
	}
	public void setMarketPlaceFulfillmentOrderId(String marketPlaceFulfillmentOrderId) {
		this.marketPlaceFulfillmentOrderId = marketPlaceFulfillmentOrderId;
	}
	public String getMarketPlaceFulfillmentOrderItemId() {
		return marketPlaceFulfillmentOrderItemId;
	}
	public void setMarketPlaceFulfillmentOrderItemId(String marketPlaceFulfillmentOrderItemId) {
		this.marketPlaceFulfillmentOrderItemId = marketPlaceFulfillmentOrderItemId;
	}
	public String getMarketPlaceInventoryItemId() {
		return marketPlaceInventoryItemId;
	}
	public void setMarketPlaceInventoryItemId(String marketPlaceInventoryItemId) {
		this.marketPlaceInventoryItemId = marketPlaceInventoryItemId;
	}
	public Integer getNonFulfillableQuantity() {
		return nonFulfillableQuantity;
	}
	public void setNonFulfillableQuantity(Integer nonFulfillableQuantity) {
		this.nonFulfillableQuantity = nonFulfillableQuantity;
	}
	public Integer getUnfulfilledQuantity() {
		return unfulfilledQuantity;
	}
	public void setUnfulfilledQuantity(Integer unfulfilledQuantity) {
		this.unfulfilledQuantity = unfulfilledQuantity;
	}
	public Address getPickupLocationAddress() {
		return pickupLocationAddress;
	}
	public void setPickupLocationAddress(Address pickupLocationAddress) {
		this.pickupLocationAddress = pickupLocationAddress;
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
	public Double getHight() {
		return hight;
	}
	public void setHight(Double hight) {
		this.hight = hight;
	}
	
	
	
}
