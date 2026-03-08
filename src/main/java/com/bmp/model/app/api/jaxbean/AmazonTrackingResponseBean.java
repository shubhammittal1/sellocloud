package com.bmp.model.app.api.jaxbean;

import java.util.List;
import java.util.Map;

import org.stringtemplate.v4.compiler.CodeGenerator.primary_return;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmazonTrackingResponseBean {
	private Payload payload;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payload{
       
		private List<EventHistory> eventHistory;
		private Summary summary;
		private String trackingId; 
		private String promisedDeliveryDate; 
		public List<EventHistory> getEventHistory() {
			return eventHistory;
		}

		public void setEventHistory(List<EventHistory> eventHistory) {
			this.eventHistory = eventHistory;
		}


		public String getTrackingId() {
			return trackingId;
		}

		public void setTrackingId(String trackingId) {
			this.trackingId = trackingId;
		}

		public String getPromisedDeliveryDate() {
			return promisedDeliveryDate;
		}

		public void setPromisedDeliveryDate(String promisedDeliveryDate) {
			this.promisedDeliveryDate = promisedDeliveryDate;
		}
		

		public Summary getSummary() {
			return summary;
		}

		public void setSummary(Summary summary) {
			this.summary = summary;
		}
    }
	
	
	
	
	
	


	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class EventHistory{
        private String eventTime;
        private String eventCode;
        private String shipmentType;
        private Location location;
		public String getEventTime() {
			return eventTime;
		}
		public void setEventTime(String eventTime) {
			this.eventTime = eventTime;
		}
		public String getEventCode() {
			return eventCode;
		}
		public void setEventCode(String eventCode) {
			this.eventCode = eventCode;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public String getShipmentType() {
			return shipmentType;
		}
		public void setShipmentType(String shipmentType) {
			this.shipmentType = shipmentType;
		}
		
    }

	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Summary{
        private String status;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
        
    }
	
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location{
        private String stateOrRegion;
        private String countryCode;
        private String city;
        private String postalCode;
		public String getStateOrRegion() {
			return stateOrRegion;
		}
		public void setStateOrRegion(String stateOrRegion) {
			this.stateOrRegion = stateOrRegion;
		}
		public String getCountryCode() {
			return countryCode;
		}
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
        
    }

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}
}
