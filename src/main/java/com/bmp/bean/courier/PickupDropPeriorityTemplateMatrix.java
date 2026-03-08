package com.bmp.bean.courier;


public class PickupDropPeriorityTemplateMatrix {

	private String priorityKey;
	private String pickupGroup;
    private String dropGroup;
	private String transitTime;
	private String rateZone;
	
	public String getPriorityKey() {
		return priorityKey;
	}
	public void setPriorityKey(String priorityKey) {
		this.priorityKey = priorityKey;
	}
	public String getPickupGroup() {
		return pickupGroup;
	}
	public void setPickupGroup(String pickupGroup) {
		this.pickupGroup = pickupGroup;
	}
	public String getDropGroup() {
		return dropGroup;
	}
	public void setDropGroup(String dropGroup) {
		this.dropGroup = dropGroup;
	}
	public String getTransitTime() {
		return transitTime;
	}
	public void setTransitTime(String transitTime) {
		this.transitTime = transitTime;
	}
	public String getRateZone() {
		return rateZone;
	}
	public void setRateZone(String rateZone) {
		this.rateZone = rateZone;
	}
	
}
