package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.client.ShippingChargeBean;
import com.bmp.constant.OrderTransactionType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="clientAccountLog")
@AssignKey(assvalue=false)
public class ClientAccountLog extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -4677577840752533287L;
	@Indexed
	private String clientKey_s;
	private Double amount;
	private Double currentBalance;
	private Double modifiedBalance;
	@Indexed
	private String paymentType;
	@Indexed
	private String paymentSubType;
	@Indexed
	private String transactionKey_s;
	@Indexed
	private String courierAwb;
	private String orderId;
	private String remark;
	@Indexed
	private OrderTransactionType orderTransactionType;
	@Transient
	private String orderTransactionTypeRemarks;
	private ShippingChargeBean shippingChargeBean;
	
	public ClientAccountLog(){}
	
	public String getClientKey_s() {
		return clientKey_s;
	}
	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public Double getModifiedBalance() {
		return modifiedBalance;
	}
	public void setModifiedBalance(Double modifiedBalance) {
		this.modifiedBalance = modifiedBalance;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentSubType() {
		return paymentSubType;
	}
	public void setPaymentSubType(String paymentSubType) {
		this.paymentSubType = paymentSubType;
	}
	public String getTransactionKey_s() {
		return transactionKey_s;
	}
	public void setTransactionKey_s(String transactionKey_s) {
		this.transactionKey_s = transactionKey_s;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getOrderTransactionTypeRemarks() {
		return orderTransactionTypeRemarks;
	}

	public void setOrderTransactionTypeRemarks(String orderTransactionTypeRemarks) {
		this.orderTransactionTypeRemarks = orderTransactionTypeRemarks;
	}

	public ShippingChargeBean getShippingChargeBean() {
		return shippingChargeBean;
	}

	public void setShippingChargeBean(ShippingChargeBean shippingChargeBean) {
		this.shippingChargeBean = shippingChargeBean;
	}
	

}
