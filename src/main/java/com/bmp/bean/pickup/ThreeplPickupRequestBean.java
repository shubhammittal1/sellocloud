package com.bmp.bean.pickup;

import java.io.Serializable;
import java.util.List;

public class ThreeplPickupRequestBean implements Serializable{

	private String pickupRequestStatus;
	private String pickupRequestReason;
	private List<String> pickupRequestKey;
	
	public ThreeplPickupRequestBean() {
		super();
	}

	public String getPickupRequestStatus() {
		return pickupRequestStatus;
	}

	public String getPickupRequestReason() {
		return pickupRequestReason;
	}

	public List<String> getPickupRequestKey() {
		return pickupRequestKey;
	}

	public void setPickupRequestStatus(String pickupRequestStatus) {
		this.pickupRequestStatus = pickupRequestStatus;
	}

	public void setPickupRequestReason(String pickupRequestReason) {
		this.pickupRequestReason = pickupRequestReason;
	}

	public void setPickupRequestKey(List<String> pickupRequestKey) {
		this.pickupRequestKey = pickupRequestKey;
	}
	

}
