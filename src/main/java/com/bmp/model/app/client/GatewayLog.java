package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="gatewayLog")
@AssignKey(assvalue=false)
public class GatewayLog extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -4677577840752533287L;
	@Indexed
	private String clientKey_s;
	@Indexed
	private String webUserKey_s;
	private String requestType;
	private String requestDetails;
	private String responseDetails;
	private String responseMessage;
	private String statusType;
	private String requestId;
	private String paymentId;
	@Indexed
	private String paymentTransactionNo_s;
	private Double requestAmount;
	private Double responseAmount;
	private String crossCheckResponse;
	
	public GatewayLog(){}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}

	public String getResponseDetails() {
		return responseDetails;
	}

	public void setResponseDetails(String responseDetails) {
		this.responseDetails = responseDetails;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentTransactionNo_s() {
		return paymentTransactionNo_s;
	}

	public void setPaymentTransactionNo_s(String paymentTransactionNo_s) {
		this.paymentTransactionNo_s = paymentTransactionNo_s;
	}

	public Double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(Double requestAmount) {
		this.requestAmount = requestAmount;
	}

	public Double getResponseAmount() {
		return responseAmount;
	}

	public void setResponseAmount(Double responseAmount) {
		this.responseAmount = responseAmount;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getWebUserKey_s() {
		return webUserKey_s;
	}

	public void setWebUserKey_s(String webUserKey_s) {
		this.webUserKey_s = webUserKey_s;
	}

	public String getCrossCheckResponse() {
		return crossCheckResponse;
	}

	public void setCrossCheckResponse(String crossCheckResponse) {
		this.crossCheckResponse = crossCheckResponse;
	}
}
