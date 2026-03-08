package com.bmp.model.app.saleorder;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacketsHistoryNew implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//private StatusMaster fromStatus;
	//private StatusMaster toStatus;
	private String fromStatusKey;
	private String toStatusKey;
	private String location;
	private String previousLocation;
	private String date;
	private String rtoReason;
	private String remarks;
	private Long createdDate;
	private String createdByKey;
	private String createdByName;
	private String fromLocation;
	private String toLocation;
	private String shipmentPickupTime;
	private String paymentType;
	private String collectableAmount;
	private String longitude;
	private String latitude;
	private String deliveryAgentNumber;
	private String receivedBy;
	private String statusType;
	private String externalStatus;
	private String externalStatusCode;
	private boolean statusPushed;
	
	public PacketsHistoryNew() {
		super();
	}

	/*public StatusMaster getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(StatusMaster fromStatus) {
		this.fromStatus = fromStatus;
	}

	public StatusMaster getToStatus() {
		return toStatus;
	}

	public void setToStatus(StatusMaster toStatus) {
		this.toStatus = toStatus;
	}*/

	public String getFromStatusKey() {
		return fromStatusKey;
	}

	public void setFromStatusKey(String fromStatusKey) {
		this.fromStatusKey = fromStatusKey;
	}

	public String getToStatusKey() {
		return toStatusKey;
	}

	public void setToStatusKey(String toStatusKey) {
		this.toStatusKey = toStatusKey;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedByKey() {
		return createdByKey;
	}

	public void setCreatedByKey(String createdByKey) {
		this.createdByKey = createdByKey;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getRtoReason() {
		return rtoReason;
	}

	public void setRtoReason(String rtoReason) {
		this.rtoReason = rtoReason;
	}

	public boolean isStatusPushed() {
		return statusPushed;
	}

	public void setStatusPushed(boolean statusPushed) {
		this.statusPushed = statusPushed;
	}

	public String getPreviousLocation() {
		return previousLocation;
	}

	public void setPreviousLocation(String previousLocation) {
		this.previousLocation = previousLocation;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCollectableAmount() {
		return collectableAmount;
	}

	public void setCollectableAmount(String collectableAmount) {
		this.collectableAmount = collectableAmount;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getShipmentPickupTime() {
		return shipmentPickupTime;
	}

	public void setShipmentPickupTime(String shipmentPickupTime) {
		this.shipmentPickupTime = shipmentPickupTime;
	}

	public String getDeliveryAgentNumber() {
		return deliveryAgentNumber;
	}

	public void setDeliveryAgentNumber(String deliveryAgentNumber) {
		this.deliveryAgentNumber = deliveryAgentNumber;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getExternalStatus() {
		return externalStatus;
	}

	public void setExternalStatus(String externalStatus) {
		this.externalStatus = externalStatus;
	}

	public String getExternalStatusCode() {
		return externalStatusCode;
	}

	public void setExternalStatusCode(String externalStatusCode) {
		this.externalStatusCode = externalStatusCode;
	}
	
	
	
}