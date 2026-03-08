package com.bmp.bean;

import com.bmp.constant.ResponseStatus;


public class ApiResponseC2CBean {
	
	private int statusCode;
	private ResponseStatus statusMessage;
	private String messageDetails;
	private Object details;
	
	public ApiResponseC2CBean(){
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public ResponseStatus getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(ResponseStatus statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getMessageDetails() {
		return messageDetails;
	}

	public void setMessageDetails(String messageDetails) {
		this.messageDetails = messageDetails;
	}

	public Object getDetails() {
		return details;
	}

	public void setDetails(Object details) {
		this.details = details;
	}

}