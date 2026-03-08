package com.bmp.bean.common;

import com.bmp.constant.ResponseStatus;

public class ResponseApiBean {

	private ResponseStatus Result;
	private String messege;
	private Object Result_Details;
	
	public ResponseApiBean() {
		super();
	}

	public ResponseStatus getResult() {
		return Result;
	}

	public String getMessege() {
		return messege;
	}

	public Object getResult_Details() {
		return Result_Details;
	}

	public void setResult(ResponseStatus result) {
		Result = result;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public void setResult_Details(Object result_Details) {
		Result_Details = result_Details;
	}

}
