package com.bmp.bean.saleorder;

import java.io.Serializable;

public class ClosePickupSheetBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String endKm;
	private String statusID;
	private String notCloseReasonKey;
	private String actualPacket;
	private String pickupRequestId;
	private boolean scaned;
	private Double lat;
	private Double lng;

	public ClosePickupSheetBean() {
		super();
	}

	public String getEndKm() {
		return endKm;
	}

	public String getStatusID() {
		return statusID;
	}

	public String getNotCloseReasonKey() {
		return notCloseReasonKey;
	}

	public String getActualPacket() {
		return actualPacket;
	}

	public String getPickupRequestId() {
		return pickupRequestId;
	}

	public void setEndKm(String endKm) {
		this.endKm = endKm;
	}

	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}

	public void setNotCloseReasonKey(String notCloseReasonKey) {
		this.notCloseReasonKey = notCloseReasonKey;
	}

	public void setActualPacket(String actualPacket) {
		this.actualPacket = actualPacket;
	}

	public void setPickupRequestId(String pickupRequestId) {
		this.pickupRequestId = pickupRequestId;
	}

	public boolean isScaned() {
		return scaned;
	}

	public void setScaned(boolean scaned) {
		this.scaned = scaned;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

}
