package com.bmp.bean.trackStatus;

import java.io.Serializable;
import java.util.List;

import com.bmp.constant.ResponseStatus;

public class ApiStatusResponseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ResponseStatus status;
	private String message;
	private String awbNumber;
	private List<StatusResponseBean> response;

	public ResponseStatus getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public List<StatusResponseBean> getResponse() {
		return response;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public void setResponse(List<StatusResponseBean> response) {
		this.response = response;
	}
	
}
