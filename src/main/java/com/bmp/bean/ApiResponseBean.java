package com.bmp.bean;

import com.bmp.constant.ResponseStatus;


public class ApiResponseBean {
	
	private int statusCode;
	private ResponseStatus statusMessage;
	private String messageDetails;
	private Object data;
	
	public ApiResponseBean(){
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}