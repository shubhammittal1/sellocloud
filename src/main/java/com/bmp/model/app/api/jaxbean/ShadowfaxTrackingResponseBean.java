package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShadowfaxTrackingResponseBean {
	
	private Client_request client_request;
	
	public ShadowfaxTrackingResponseBean() {
		super();
	}
	
	public Client_request getClient_request ()
    {
        return client_request;
    }
    public void setClient_request (Client_request client_request)
    {
        this.client_request = client_request;
    }
    
	public class Client_request{
	    
		private String customer_track_url;
	    private List<Delivery_request_state_histories> delivery_request_state_histories;
	    private String order_status;

	    public Client_request() {
	    	super();
	    }
	    
	    public String getCustomer_track_url ()
	    {
	        return customer_track_url;
	    }
	    public void setCustomer_track_url (String customer_track_url)
	    {
	        this.customer_track_url = customer_track_url;
	    }
	    public List<Delivery_request_state_histories> getDelivery_request_state_histories() {
			return delivery_request_state_histories;
		}
		public void setDelivery_request_state_histories(
				List<Delivery_request_state_histories> delivery_request_state_histories) {
			this.delivery_request_state_histories = delivery_request_state_histories;
		}
		public String getOrder_status ()
	    {
	        return order_status;
	    }
	    public void setOrder_status (String order_status)
	    {
	        this.order_status = order_status;
	    }
	    
	    public class Delivery_request_state_histories{
	       
	    	private int id;
	        private String scan_time;
	        private String updated_at;
	        private int delivery_request_id;
	        private int attempt_number;
	        private String state;
	        private String created_at;
	        private String scan;
	        private String comment;
	        private String scan_date;
	        private String scanned_location;
	        private int rider_id;
	        private String rider_name;
	        private String rider_contact;

	        public Delivery_request_state_histories() {
	        	super();
	        }
	        
	        public int getId ()
	        {
	            return id;
	        }
	        public void setId (int id)
	        {
	            this.id = id;
	        }
	        public String getScan_time ()
	        {
	            return scan_time;
	        }
	        public void setScan_time (String scan_time)
	        {
	            this.scan_time = scan_time;
	        }
	        public String getUpdated_at ()
	        {
	            return updated_at;
	        }
	        public void setUpdated_at (String updated_at)
	        {
	            this.updated_at = updated_at;
	        }
	        public int getDelivery_request_id ()
	        {
	            return delivery_request_id;
	        }
	        public void setDelivery_request_id (int delivery_request_id)
	        {
	            this.delivery_request_id = delivery_request_id;
	        }
	        public int getAttempt_number ()
	        {
	            return attempt_number;
	        }
	        public void setAttempt_number (int attempt_number)
	        {
	            this.attempt_number = attempt_number;
	        }
	        public String getState ()
	        {
	            return state;
	        }
	        public void setState (String state)
	        {
	            this.state = state;
	        }
	        public String getCreated_at ()
	        {
	            return created_at;
	        }
	        public void setCreated_at (String created_at)
	        {
	            this.created_at = created_at;
	        }
	        public String getScan ()
	        {
	            return scan;
	        }
	        public void setScan (String scan)
	        {
	            this.scan = scan;
	        }
	        public String getComment ()
	        {
	            return comment;
	        }
	        public void setComment (String comment)
	        {
	            this.comment = comment;
	        }
	        public String getScan_date ()
	        {
	            return scan_date;
	        }
	        public void setScan_date (String scan_date)
	        {
	            this.scan_date = scan_date;
	        }
			public String getScanned_location() {
				return scanned_location;
			}
			public void setScanned_location(String scanned_location) {
				this.scanned_location = scanned_location;
			}
			public int getRider_id() {
				return rider_id;
			}
			public void setRider_id(int rider_id) {
				this.rider_id = rider_id;
			}
			public String getRider_name() {
				return rider_name;
			}
			public void setRider_name(String rider_name) {
				this.rider_name = rider_name;
			}
			public String getRider_contact() {
				return rider_contact;
			}
			public void setRider_contact(String rider_contact) {
				this.rider_contact = rider_contact;
			}
	        
	    }
	}

}
