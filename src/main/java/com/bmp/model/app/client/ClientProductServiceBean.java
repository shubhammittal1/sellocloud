package com.bmp.model.app.client;

import java.util.List;
import java.util.Map;
import com.bmp.constant.DeliveryType;

public class ClientProductServiceBean {
	
	private String deliveryAttempt;			
	private int pickupAttempt;			
	private Boolean alertAllow;			
	private DeliveryType deliveryType;
	private List<String> idProofType;
	private String clientPodSampleUrl;	
	
	public String getDeliveryAttempt() {
		return deliveryAttempt;
	}
	public void setDeliveryAttempt(String deliveryAttempt) {
		this.deliveryAttempt = deliveryAttempt;
	}
	public int getPickupAttempt() {
		return pickupAttempt;
	}
	public void setPickupAttempt(int pickupAttempt) {
		this.pickupAttempt = pickupAttempt;
	}
	public Boolean getAlertAllow() {
		return alertAllow;
	}
	public void setAlertAllow(Boolean alertAllow) {
		this.alertAllow = alertAllow;
	}
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}
	public List<String> getIdProofType() {
		return idProofType;
	}
	public void setIdProofType(List<String> idProofType) {
		this.idProofType = idProofType;
	}
	public String getClientPodSampleUrl() {
		return clientPodSampleUrl;
	}
	public void setClientPodSampleUrl(String clientPodSampleUrl) {
		this.clientPodSampleUrl = clientPodSampleUrl;
	}
	
	
}
