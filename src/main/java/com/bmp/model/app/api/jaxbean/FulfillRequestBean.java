package com.bmp.model.app.api.jaxbean;

import java.util.List;

public class FulfillRequestBean {
	private String marketPlaceOrderKey;
	private String pickupLocationKey;
	private String marketPlaceFulfillmentOrderId;
	private List<FulFillDetails> fulFillDetails;
	
	public String getMarketPlaceOrderKey() {
		return marketPlaceOrderKey;
	}
	public void setMarketPlaceOrderKey(String marketPlaceOrderKey) {
		this.marketPlaceOrderKey = marketPlaceOrderKey;
	}
	public String getPickupLocationKey() {
		return pickupLocationKey;
	}
	public void setPickupLocationKey(String pickupLocationKey) {
		this.pickupLocationKey = pickupLocationKey;
	}
	public List<FulFillDetails> getFulFillDetails() {
		return fulFillDetails;
	}
	public void setFulFillDetails(List<FulFillDetails> fulFillDetails) {
		this.fulFillDetails = fulFillDetails;
	}
	public String getMarketPlaceFulfillmentOrderId() {
		return marketPlaceFulfillmentOrderId;
	}
	public void setMarketPlaceFulfillmentOrderId(String marketPlaceFulfillmentOrderId) {
		this.marketPlaceFulfillmentOrderId = marketPlaceFulfillmentOrderId;
	}


	public static class FulFillDetails{
		private String skuCode;
		private String skuName;
		private Integer quantity;
		private String marketPlaceFulfillmentOrderItemId;
		
		public String getSkuCode() {
			return skuCode;
		}
		public void setSkuCode(String skuCode) {
			this.skuCode = skuCode;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public String getMarketPlaceFulfillmentOrderItemId() {
			return marketPlaceFulfillmentOrderItemId;
		}
		public void setMarketPlaceFulfillmentOrderItemId(String marketPlaceFulfillmentOrderItemId) {
			this.marketPlaceFulfillmentOrderItemId = marketPlaceFulfillmentOrderItemId;
		}
		public String getSkuName() {
			return skuName;
		}
		public void setSkuName(String skuName) {
			this.skuName = skuName;
		}
		
	}
}
