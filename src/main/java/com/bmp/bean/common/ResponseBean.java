package com.bmp.bean.common;

import com.bmp.constant.ResponseStatus;

public class ResponseBean {
	
	private ResponseStatus status;
	private String message;
	private Object response;
	
	public ResponseBean() {
		super();
	}

	public ResponseBean(ResponseStatus responseStatus, String trackingDetailsAlreadyAdded, Object o) {
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
	
}
