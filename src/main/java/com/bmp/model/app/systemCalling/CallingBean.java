package com.bmp.model.app.systemCalling;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="callingBean")
@AssignKey(assvalue=true)
public class CallingBean extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String callManifestKey_s;
	@Indexed
	private String awb;
	private String saleOrderNumber;
	@Indexed
	private String callsId;
	@Indexed
	private String firstCallSid;
	@Indexed
	private String fromNumber;
	private String customerName;
	@Indexed
	private String customerNumber;
	private String message;
	private String sms;
	private String clientKey;
	private String responseId;
	private String response;
	@Indexed
	private String callStatus;
	@Indexed
	private boolean smsSend;
	private String callDetails;
	
	public CallingBean() {
		super();
	}

	public String getCallManifestKey_s() {
		return callManifestKey_s;
	}

	public void setCallManifestKey_s(String callManifestKey_s) {
		this.callManifestKey_s = callManifestKey_s;
	}

	public String getAwb() {
		return awb;
	}

	public void setAwb(String awb) {
		this.awb = awb;
	}

	public String getSaleOrderNumber() {
		return saleOrderNumber;
	}

	public void setSaleOrderNumber(String saleOrderNumber) {
		this.saleOrderNumber = saleOrderNumber;
	}

	public String getCallsId() {
		return callsId;
	}

	public void setCallsId(String callsId) {
		this.callsId = callsId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}

	public String getFirstCallSid() {
		return firstCallSid;
	}

	public void setFirstCallSid(String firstCallSid) {
		this.firstCallSid = firstCallSid;
	}

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	public boolean isSmsSend() {
		return smsSend;
	}

	public void setSmsSend(boolean smsSend) {
		this.smsSend = smsSend;
	}

	public String getCallDetails() {
		return callDetails;
	}

	public void setCallDetails(String callDetails) {
		this.callDetails = callDetails;
	}
	

}
