package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.FulfillmentStatus;
import com.bmp.constant.OrderSource;
import com.bmp.constant.PaymentType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="marketPlaceOrder")
@AssignKey(assvalue=true)
public class MarketPlaceOrder extends MongoBaseBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Indexed
	private String clientKey;
	private String clientName;
	@Indexed
	private String clientChannelKey;
	@Indexed
	private String shopCode;
	@Indexed
	private OrderSource orderSource;
	@Indexed
	private FulfillmentStatus fulfillmentStatus;
	@Indexed
	private PaymentType paymentType;
	@Indexed
	private String orderId;
	@Indexed
	private String subOrderId;
	private Double orderAmount;
	private Double orderCodAmount;
	private String orderDate;
	
	private String productName;
	private String skucode;
	
	private Integer quantity = 0;
	private Integer fulfilledQuantity;
	private List<MarketPlaceOrderSku> orderSku;
	private List<MarketPlaceOrderShipping> orderShipping;
	private Address shippingAddress;
	private Address billingAddress;
	private Boolean orderConfirm = false;
	private String convertOrderErrorMsg;
	
	public MarketPlaceOrder() {
		this.setKey_s(new ObjectId().toString());
	}
	
	
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientChannelKey() {
		return clientChannelKey;
	}
	public void setClientChannelKey(String clientChannelKey) {
		this.clientChannelKey = clientChannelKey;
	}
	public String getShopCode() {
		return shopCode;
	}
	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}
	public OrderSource getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(OrderSource orderSource) {
		this.orderSource = orderSource;
	}
	public FulfillmentStatus getFulfillmentStatus() {
		return fulfillmentStatus;
	}
	public void setFulfillmentStatus(FulfillmentStatus fulfillmentStatus) {
		this.fulfillmentStatus = fulfillmentStatus;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSubOrderId() {
		return subOrderId;
	}
	public void setSubOrderId(String subOrderId) {
		this.subOrderId = subOrderId;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Double getOrderCodAmount() {
		return orderCodAmount;
	}
	public void setOrderCodAmount(Double orderCodAmount) {
		this.orderCodAmount = orderCodAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSkucode() {
		return skucode;
	}
	public void setSkucode(String skucode) {
		this.skucode = skucode;
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
	public List<MarketPlaceOrderSku> getOrderSku() {
		return orderSku;
	}
	public void setOrderSku(List<MarketPlaceOrderSku> orderSku) {
		this.orderSku = orderSku;
	}
	public List<MarketPlaceOrderShipping> getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(List<MarketPlaceOrderShipping> orderShipping) {
		this.orderShipping = orderShipping;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Boolean getOrderConfirm() {
		return orderConfirm;
	}

	public void setOrderConfirm(Boolean orderConfirm) {
		this.orderConfirm = orderConfirm;
	}

	public String getConvertOrderErrorMsg() {
		return convertOrderErrorMsg;
	}

	public void setConvertOrderErrorMsg(String convertOrderErrorMsg) {
		this.convertOrderErrorMsg = convertOrderErrorMsg;
	}
	
}
