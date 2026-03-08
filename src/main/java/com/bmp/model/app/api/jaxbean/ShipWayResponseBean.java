package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipWayResponseBean {
	
	private String status;
	private Response response;
	
	public String getStatus() {
		return status;
	}

	public Response getResponse() {
		return response;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public static class Response{
		private String awbno;
		private String carrier;
		private String pickupdate;
		private String current_status;
		private String current_status_code;
		private String recipient;
		private String from;
		private String to;
		private String time;
		private List<Scan> scan;
		private String tracking_url;
		
		public String getAwbno() {
			return awbno;
		}
		public String getCarrier() {
			return carrier;
		}
		public String getPickupdate() {
			return pickupdate;
		}
		public String getCurrent_status() {
			return current_status;
		}
		public String getCurrent_status_code() {
			return current_status_code;
		}
		public String getRecipient() {
			return recipient;
		}
		public String getFrom() {
			return from;
		}
		public String getTo() {
			return to;
		}
		public String getTime() {
			return time;
		}
		public List<Scan> getScan() {
			return scan;
		}
		public void setAwbno(String awbno) {
			this.awbno = awbno;
		}
		public void setCarrier(String carrier) {
			this.carrier = carrier;
		}
		public void setPickupdate(String pickupdate) {
			this.pickupdate = pickupdate;
		}
		public void setCurrent_status(String current_status) {
			this.current_status = current_status;
		}
		public void setCurrent_status_code(String current_status_code) {
			this.current_status_code = current_status_code;
		}
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public void setScan(List<Scan> scan) {
			this.scan = scan;
		}
		public String getTracking_url() {
			return tracking_url;
		}
		public void setTracking_url(String tracking_url) {
			this.tracking_url = tracking_url;
		}

		public static class Scan{
			private String time;
			private String location;
			private String status_detail;
			
			public String getTime() {
				return time;
			}
			public String getLocation() {
				return location;
			}
			public String getStatus_detail() {
				return status_detail;
			}
			public void setTime(String time) {
				this.time = time;
			}
			public void setLocation(String location) {
				this.location = location;
			}
			public void setStatus_detail(String status_detail) {
				this.status_detail = status_detail;
			}
		}
	}
	
}
