package com.bmp.model.app.systemCalling;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.TeleCallingType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="outgoingCallLogs")
@AssignKey(assvalue=true)
public class OutgoingCallLogs extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String from;
	private String to;
	private String callerId;
	private String callerName;
	@Indexed
	private String awbNumber;
	@Indexed
	private String callSid;
	private String response;
	private String date;
	@Indexed
	private boolean recordingDownload;
	private boolean requestComplated;
	private Integer requestCount = 0;
	@Indexed
	private boolean smsSend;
	private String smsSendDate;
	private String callStatus;
	private String disposition;
	@Indexed
	private String diallerPin;
	@Indexed
	private String clientKey;
	@Indexed
	private TeleCallingType teleCallingType;
	
	
	
	public OutgoingCallLogs() {
		super();
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCallerId() {
		return callerId;
	}
	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}
	public String getCallerName() {
		return callerName;
	}
	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getCallSid() {
		return callSid;
	}
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	public Boolean getRecordingDownload() {
		return recordingDownload;
	}
	public void setRecordingDownload(boolean recordingDownload) {
		this.recordingDownload = recordingDownload;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getRequestCount() {
		return requestCount;
	}

	public void setRequestCount(Integer requestCount) {
		this.requestCount = requestCount;
	}

	public boolean isRequestComplated() {
		return requestComplated;
	}

	public void setRequestComplated(boolean requestComplated) {
		this.requestComplated = requestComplated;
	}

	public boolean isSmsSend() {
		return smsSend;
	}

	public void setSmsSend(boolean smsSend) {
		this.smsSend = smsSend;
	}

	public String getSmsSendDate() {
		return smsSendDate;
	}

	public void setSmsSendDate(String smsSendDate) {
		this.smsSendDate = smsSendDate;
	}

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public String getDiallerPin() {
		return diallerPin;
	}

	public void setDiallerPin(String diallerPin) {
		this.diallerPin = diallerPin;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public TeleCallingType getTeleCallingType() {
		return teleCallingType;
	}

	public void setTeleCallingType(TeleCallingType teleCallingType) {
		this.teleCallingType = teleCallingType;
	}
	
	
}
