package com.bmp.model.app.api.jaxbean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WowshipDataPushResponseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Response> response;
	
	public WowshipDataPushResponseBean() {
		super();
	}
	
	public List<Response> getResponse() {
		return response;
	}
	public void setResponse(List<Response> response) {
		this.response = response;
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Response{
		
		private String awbno;
		private String Courier;
		private String success;
		private String error;
		
		public Response() {
			
		}
		
		public String getAwbno() {
			return awbno;
		}
		public void setAwbno(String awbno) {
			this.awbno = awbno;
		}

		public String getCourier() {
			return Courier;
		}
		public void setCourier(String courier) {
			Courier = courier;
		}

		public String getSuccess() {
			return success;
		}
		public void setSuccess(String success) {
			this.success = success;
		}

		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
	}
	
}
