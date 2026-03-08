package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EcartTrackingResponseBean {
	private String shipment_type;
    private String cod_amount;
    private String shipment_id;
    private String shipment_value;
    private String order_id;
    private String external_tracking_id;
    private String delivery_type;
    private String weight;
    private Boolean delivered;
    private String merchant_name;
    private Boolean rto;
    private List<History> history;
    
    public String getShipment_type() {
		return shipment_type;
	}

	public void setShipment_type(String shipment_type) {
		this.shipment_type = shipment_type;
	}

	public String getCod_amount() {
		return cod_amount;
	}

	public void setCod_amount(String cod_amount) {
		this.cod_amount = cod_amount;
	}

	public String getShipment_id() {
		return shipment_id;
	}

	public void setShipment_id(String shipment_id) {
		this.shipment_id = shipment_id;
	}

	public String getShipment_value() {
		return shipment_value;
	}

	public void setShipment_value(String shipment_value) {
		this.shipment_value = shipment_value;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getExternal_tracking_id() {
		return external_tracking_id;
	}

	public void setExternal_tracking_id(String external_tracking_id) {
		this.external_tracking_id = external_tracking_id;
	}

	public String getDelivery_type() {
		return delivery_type;
	}

	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}
	
	public Boolean getRto() {
		return rto;
	}

	public void setRto(Boolean rto) {
		this.rto = rto;
	}


	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class History{
        private String city;
        private String status;
        private String hub_notes;
        private String cs_notes;
        private String event_date;
        private String event_date_iso8601;
        private String hub_name;
        private String updated_datetime;
        private String public_description;
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getHub_notes() {
			return hub_notes;
		}
		public void setHub_notes(String hub_notes) {
			this.hub_notes = hub_notes;
		}
		public String getCs_notes() {
			return cs_notes;
		}
		public void setCs_notes(String cs_notes) {
			this.cs_notes = cs_notes;
		}
		public String getEvent_date() {
			return event_date;
		}
		public void setEvent_date(String event_date) {
			this.event_date = event_date;
		}
		public String getEvent_date_iso8601() {
			return event_date_iso8601;
		}
		public void setEvent_date_iso8601(String event_date_iso8601) {
			this.event_date_iso8601 = event_date_iso8601;
		}
		public String getHub_name() {
			return hub_name;
		}
		public void setHub_name(String hub_name) {
			this.hub_name = hub_name;
		}
		public String getUpdated_datetime() {
			return updated_datetime;
		}
		public void setUpdated_datetime(String updated_datetime) {
			this.updated_datetime = updated_datetime;
		}
		public String getPublic_description() {
			return public_description;
		}
		public void setPublic_description(String public_description) {
			this.public_description = public_description;
		}
        
		
    }
}
