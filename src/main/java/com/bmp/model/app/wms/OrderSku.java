package com.bmp.model.app.wms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="orderSku")
@AssignKey(assvalue=true)
public class OrderSku extends MongoBaseBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Indexed
	private String orderKey;
	private String skuName;
	private StatusMasterNew currentStatus;
	@Indexed
	private String clientKey;
	@Indexed
    private String skuCode;
	@Indexed
    private String barCode;
	private String skuImageUrls;
    private int qty;
    private Integer fulfilledQuantity = 0;
    private double singleSkuPrice;
    private double totaSkuPrice;
    private double skuMrp;
    private double taxPercentage;
    private double taxAmount;
	private String statusFlowKey;
	private String marketPlaceFulfillmentOrderId;//for shopify
	
	private String marketPlaceFulfillmentOrderItemId;//for shopify
	private String marketPlaceInventoryItemId;//for shopify
    private Map<String, OrderSkuHistory> orderSkuHistory;
    @Indexed
    private String warehouseKey;
    private Map<String, Integer> skuLocationQty;
    
	public String getOrderKey() {
		return orderKey;
	}
	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getSkuImageUrls() {
		return skuImageUrls;
	}
	public void setSkuImageUrls(String skuImageUrls) {
		this.skuImageUrls = skuImageUrls;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getSingleSkuPrice() {
		return singleSkuPrice;
	}
	public void setSingleSkuPrice(double singleSkuPrice) {
		this.singleSkuPrice = singleSkuPrice;
	}
	public double getTotaSkuPrice() {
		return totaSkuPrice;
	}
	public void setTotaSkuPrice(double totaSkuPrice) {
		this.totaSkuPrice = totaSkuPrice;
	}
	public double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getWarehouseKey() {
		return warehouseKey;
	}
	public void setWarehouseKey(String warehouseKey) {
		this.warehouseKey = warehouseKey;
	}
	public Map<String, Integer> getSkuLocationQty() {
		return skuLocationQty;
	}
	public void setSkuLocationQty(Map<String, Integer> skuLocationQty) {
		this.skuLocationQty = skuLocationQty;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public StatusMasterNew getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(StatusMasterNew currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public Map<String, OrderSkuHistory> getOrderSkuHistory() {
		return orderSkuHistory;
	}
	public void setOrderSkuHistory(Map<String, OrderSkuHistory> orderSkuHistory) {
		this.orderSkuHistory = orderSkuHistory;
	}
	public String getStatusFlowKey() {
		return statusFlowKey;
	}
	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}
	public Integer getFulfilledQuantity() {
		return fulfilledQuantity;
	}
	public void setFulfilledQuantity(Integer fulfilledQuantity) {
		this.fulfilledQuantity = fulfilledQuantity;
	}
	public Double getSkuMrp() {
		return skuMrp;
	}
	public void setSkuMrp(Double skuMrp) {
		this.skuMrp = skuMrp;
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
    
}
