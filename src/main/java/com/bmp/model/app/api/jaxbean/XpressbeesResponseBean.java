package com.bmp.model.app.api.jaxbean;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class XpressbeesResponseBean {

	private String AWBNo;
	private String AuthKey;
	private String OrderNo;
	private String ReturnMessage;
	private List<ShipmentSummary> ShipmentSummary = null;


	public String getAWBNo() {
		return AWBNo;
	}
	public void setAWBNo(String aWBNo) {
		AWBNo = aWBNo;
	}
	public String getAuthKey() {
		return AuthKey;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public String getReturnMessage() {
		return ReturnMessage;
	}
	public List<ShipmentSummary> getShipmentSummary() {
		return ShipmentSummary;
	}
	public void setAuthKey(String authKey) {
		AuthKey = authKey;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public void setReturnMessage(String returnMessage) {
		ReturnMessage = returnMessage;
	}
	public void setShipmentSummary(List<ShipmentSummary> shipmentSummary) {
		ShipmentSummary = shipmentSummary;
	}



	public static class ShipmentSummary {

		private String PickUpDate;
		private String PickUpTime;
		private String OriginLocation;
		private String DestinationLocation;
		private String Weight;
		private String ExpectedDeliveryDate;
		private String Status;
		private String StatusCode;
		private String StatusDate;
		private String StatusTime;
		private String Location;
		private String Comment;
		
		public String getPickUpDate() {
			return PickUpDate;
		}
		public String getPickUpTime() {
			return PickUpTime;
		}
		public String getOriginLocation() {
			return OriginLocation;
		}
		public String getDestinationLocation() {
			return DestinationLocation;
		}
		public String getWeight() {
			return Weight;
		}
		public String getExpectedDeliveryDate() {
			return ExpectedDeliveryDate;
		}
		public String getStatus() {
			return Status;
		}
		public String getStatusCode() {
			return StatusCode;
		}
		public String getStatusDate() {
			return StatusDate;
		}
		public String getStatusTime() {
			return StatusTime;
		}
		public String getLocation() {
			return Location;
		}
		public String getComment() {
			return Comment;
		}
		public void setPickUpDate(String pickUpDate) {
			PickUpDate = pickUpDate;
		}
		public void setPickUpTime(String pickUpTime) {
			PickUpTime = pickUpTime;
		}
		public void setOriginLocation(String originLocation) {
			OriginLocation = originLocation;
		}
		public void setDestinationLocation(String destinationLocation) {
			DestinationLocation = destinationLocation;
		}
		public void setWeight(String weight) {
			Weight = weight;
		}
		public void setExpectedDeliveryDate(String expectedDeliveryDate) {
			ExpectedDeliveryDate = expectedDeliveryDate;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public void setStatusCode(String statusCode) {
			StatusCode = statusCode;
		}
		public void setStatusDate(String statusDate) {
			StatusDate = statusDate;
		}
		public void setStatusTime(String statusTime) {
			StatusTime = statusTime;
		}
		public void setLocation(String location) {
			Location = location;
		}
		public void setComment(String comment) {
			Comment = comment;
		}
	}

}