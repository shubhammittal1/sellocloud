package com.bmp.bean;

import com.bmp.constant.ResponseStatus;

public class ApiLogResponseBean {
	
	private String url;
	private ResponseStatus Status;
	private String message;
	private Object response;
	private String request;
	private String header;
	private String requestMethod;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ResponseStatus getStatus() {
		return Status;
	}
	public void setStatus(ResponseStatus status) {
		Status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	
	
}
