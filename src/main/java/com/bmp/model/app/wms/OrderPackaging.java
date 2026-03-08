package com.bmp.model.app.wms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.PaymentType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="orderPackaging")
@AssignKey(assvalue=false)
public class OrderPackaging extends MongoBaseBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String clientKey;
	private String orderKey;
	private StatusMasterNew currentStatus;
	private String warehouseKey;
	private Integer packQty;
	private Double totalAmount;
	private Double codAmount;
	@Indexed
	private PaymentType paymentType;
	private String courierKey;
	private String awbNumber;
	private String threePlAwb;
	private Double length;
	private Double width;
	private Double height;
	private Double weight;
	private String statusFlowKey;
	private List<OrderPackagingSku> orderPackagingSkuList;
	private Map<String, OrderPackagingHistory> orderPackagingHistory;
	private Boolean sellocloudServiceProvider = false;
	private String shopifyFulfillmentId;
	
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getOrderKey() {
		return orderKey;
	}
	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}
	public String getWarehouseKey() {
		return warehouseKey;
	}
	public void setWarehouseKey(String warehouseKey) {
		this.warehouseKey = warehouseKey;
	}
	public Integer getPackQty() {
		return packQty;
	}
	public void setPackQty(Integer packQty) {
		this.packQty = packQty;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
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
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public List<OrderPackagingSku> getOrderPackagingSkuList() {
		return orderPackagingSkuList;
	}
	public void setOrderPackagingSkuList(List<OrderPackagingSku> orderPackagingSkuList) {
		this.orderPackagingSkuList = orderPackagingSkuList;
	}
	public Map<String, OrderPackagingHistory> getOrderPackagingHistory() {
		return orderPackagingHistory;
	}
	public void setOrderPackagingHistory(Map<String, OrderPackagingHistory> orderPackagingHistory) {
		this.orderPackagingHistory = orderPackagingHistory;
	}
	public StatusMasterNew getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(StatusMasterNew currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getStatusFlowKey() {
		return statusFlowKey;
	}
	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}
	public String getCourierKey() {
		return courierKey;
	}
	public void setCourierKey(String courierKey) {
		this.courierKey = courierKey;
	}
	public Boolean getSellocloudServiceProvider() {
		return sellocloudServiceProvider;
	}
	public void setSellocloudServiceProvider(Boolean sellocloudServiceProvider) {
		this.sellocloudServiceProvider = sellocloudServiceProvider;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getThreePlAwb() {
		return threePlAwb;
	}
	public void setThreePlAwb(String threePlAwb) {
		this.threePlAwb = threePlAwb;
	}
	public String getShopifyFulfillmentId() {
		return shopifyFulfillmentId;
	}
	public void setShopifyFulfillmentId(String shopifyFulfillmentId) {
		this.shopifyFulfillmentId = shopifyFulfillmentId;
	}
}
