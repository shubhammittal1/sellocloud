package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecuraexTrackingResponseBean {
	
	private Data data;
	
	public SecuraexTrackingResponseBean() {
		super();
	}
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data{
		
		private String awb;
		private String consignee;
		private String customer_name;
		private String state;
		private String remarks;
		private String no_of_attempts;
		private String current_status;
		private String pincode;
		private String destination_city;
		private String last_updated_by;
		private String price;
		private String last_updated_at;
		private String payment_mode;
		private String branch;
		private String consignee_address;
		private String collectable_value;
		private String mobile;
		private History []history;
		
		public Data() {
			super();
		}
		    
		public String getAwb() {
			return awb;
		}
		public void setAwb(String awb) {
			this.awb = awb;
		}
		public String getConsignee() {
			return consignee;
		}
		public void setConsignee(String consignee) {
			this.consignee = consignee;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		public String getNo_of_attempts() {
			return no_of_attempts;
		}
		public void setNo_of_attempts(String no_of_attempts) {
			this.no_of_attempts = no_of_attempts;
		}
		public String getCurrent_status() {
			return current_status;
		}
		public void setCurrent_status(String current_status) {
			this.current_status = current_status;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getDestination_city() {
			return destination_city;
		}
		public void setDestination_city(String destination_city) {
			this.destination_city = destination_city;
		}
		public String getLast_updated_by() {
			return last_updated_by;
		}
		public void setLast_updated_by(String last_updated_by) {
			this.last_updated_by = last_updated_by;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getLast_updated_at() {
			return last_updated_at;
		}
		public void setLast_updated_at(String last_updated_at) {
			this.last_updated_at = last_updated_at;
		}
		public String getPayment_mode() {
			return payment_mode;
		}
		public void setPayment_mode(String payment_mode) {
			this.payment_mode = payment_mode;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public String getConsignee_address() {
			return consignee_address;
		}
		public void setConsignee_address(String consignee_address) {
			this.consignee_address = consignee_address;
		}
		public String getCollectable_value() {
			return collectable_value;
		}
		public void setCollectable_value(String collectable_value) {
			this.collectable_value = collectable_value;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public History[] getHistory() {
			return history;
		}
		public void setHistory(History[] history) {
			this.history = history;
		}


		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class History{
		    
		    private String location;
		    private String status;
		    private String remarks;
		    private String date;
		    
		    public History() {
		    	super();
		    }
		    
			public String getLocation() {
				return location;
			}
			public void setLocation(String location) {
				this.location = location;
			}
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			public String getRemarks() {
				return remarks;
			}
			public void setRemarks(String remarks) {
				this.remarks = remarks;
			}
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
		    
		 }
		
	}

}
