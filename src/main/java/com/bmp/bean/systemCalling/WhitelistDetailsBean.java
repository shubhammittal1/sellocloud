package com.bmp.bean.systemCalling;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WhitelistDetailsBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Result Result;
	private RestException RestException;
	
	public WhitelistDetailsBean(){
		super();
	}
	
	public Result getResult() {
		return Result;
	}

	public void setResult(Result result) {
		Result = result;
	}

	public RestException getRestException() {
		return RestException;
	}

	public void setRestException(RestException restException) {
		RestException = restException;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Result{
		
		private String Status;
		private String Type;
		private Long Expiry;
		
		public Result(){
			super();
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}

		public Long getExpiry() {
			return Expiry;
		}

		public void setExpiry(Long expiry) {
			Expiry = expiry;
		}
		
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class RestException{
		
		private String Status;
		private String Message;
		
		public RestException() {
			super();
		}

		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		
	}

}
