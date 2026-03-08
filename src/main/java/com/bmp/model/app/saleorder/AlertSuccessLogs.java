package com.bmp.model.app.saleorder;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.LogTypes;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="alertSuccessLogs")
@AssignKey(assvalue=true)
public class AlertSuccessLogs extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String awbNumber;
	private LogTypes logTypes;
	private String subLogType;
	private String successMsg;
	private String requestDetails;
	private String responseDetails;
	@Indexed
	private String awbNumber_s;
	@Indexed
	private String status;
	@Indexed
	private String ndr;
	private String text;
	@Indexed
	private String alertId;
	@Indexed
	private String sendManualSmsId;

	public AlertSuccessLogs() {
		super();
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public LogTypes getLogTypes() {
		return logTypes;
	}

	public void setLogTypes(LogTypes logTypes) {
		this.logTypes = logTypes;
	}

	public String getSubLogType() {
		return subLogType;
	}

	public void setSubLogType(String subLogType) {
		this.subLogType = subLogType;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
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
	
	public String getAwbNumber_s() {
		return awbNumber_s;
	}

	public void setAwbNumber_s(String awbNumber_s) {
		this.awbNumber_s = awbNumber_s;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNdr() {
		return ndr;
	}

	public void setNdr(String ndr) {
		this.ndr = ndr;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getSendManualSmsId() {
		return sendManualSmsId;
	}

	public void setSendManualSmsId(String sendManualSmsId) {
		this.sendManualSmsId = sendManualSmsId;
	}
	
	
}