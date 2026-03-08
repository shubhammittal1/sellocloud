package com.bmp.model.app.utility;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertBean implements Serializable {
	
	private static final long serialVersionUID = 5548739107912148156L;
	private String USER_NAME;
	private String PASSWORD;
    private String SENDER_ID;
    private String API_URL;
	private String smsMobileNo;
	private String smsMessage;
	private String awbNos;
	private String alertTemplate;
	
	public AlertBean() {
		super();
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getSENDER_ID() {
		return SENDER_ID;
	}

	public void setSENDER_ID(String sENDER_ID) {
		SENDER_ID = sENDER_ID;
	}

	public String getAPI_URL() {
		return API_URL;
	}

	public void setAPI_URL(String aPI_URL) {
		API_URL = aPI_URL;
	}

	public String getSmsMobileNo() {
		return smsMobileNo;
	}

	public void setSmsMobileNo(String smsMobileNo) {
		this.smsMobileNo = smsMobileNo;
	}

	public String getSmsMessage() {
		return smsMessage;
	}

	public void setSmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
	}

	public String getAwbNos() {
		return awbNos;
	}

	public void setAwbNos(String awbNos) {
		this.awbNos = awbNos;
	}

	public String getAlertTemplate() {
		return alertTemplate;
	}

	public void setAlertTemplate(String alertTemplate) {
		this.alertTemplate = alertTemplate;
	}
}
