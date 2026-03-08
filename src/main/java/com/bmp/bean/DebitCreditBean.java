package com.bmp.bean;

import java.io.Serializable;

import com.bmp.bean.client.ShippingChargeBean;
import com.bmp.constant.OrderTransactionType;

public class DebitCreditBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderRefNo;
	private String transactionType;
	private String paymentSubType;
	private String clientKey;
	private Double amount;
	private String courierAwb;
	private String orderId;
	private OrderTransactionType orderTransactionType;
	private ShippingChargeBean shippingChargeBean;
	
	public DebitCreditBean() {
		super();
	}

	public String getOrderRefNo() {
		return orderRefNo;
	}

	public void setOrderRefNo(String orderRefNo) {
		this.orderRefNo = orderRefNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getPaymentSubType() {
		return paymentSubType;
	}

	public void setPaymentSubType(String paymentSubType) {
		this.paymentSubType = paymentSubType;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCourierAwb() {
		return courierAwb;
	}

	public void setCourierAwb(String courierAwb) {
		this.courierAwb = courierAwb;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public OrderTransactionType getOrderTransactionType() {
		return orderTransactionType;
	}

	public void setOrderTransactionType(OrderTransactionType orderTransactionType) {
		this.orderTransactionType = orderTransactionType;
	}

	public ShippingChargeBean getShippingChargeBean() {
		return shippingChargeBean;
	}

	public void setShippingChargeBean(ShippingChargeBean shippingChargeBean) {
		this.shippingChargeBean = shippingChargeBean;
	}
	
	
}
