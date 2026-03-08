package com.bmp.bean.saleorder;

public class PickupHistoryBean {
	
	private String statusID;
	private String notCloseReasonKey;
	private String actualPacket;
	private String pickupRequestId;
	
	public String getStatusID() {
		return statusID;
	}
	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}
	
	public String getNotCloseReasonKey() {
		return notCloseReasonKey;
	}
	public void setNotCloseReasonKey(String notCloseReasonKey) {
		this.notCloseReasonKey = notCloseReasonKey;
	}
	public String getActualPacket() {
		return actualPacket;
	}
	public void setActualPacket(String actualPacket) {
		this.actualPacket = actualPacket;
	}
	public String getPickupRequestId() {
		return pickupRequestId;
	}
	public void setPickupRequestId(String pickupRequestId) {
		this.pickupRequestId = pickupRequestId;
	}
	

}
