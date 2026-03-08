package com.bmp.model.app.utility;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5548739107912148156L;
	private String id;
    private String notificationId;
	private String title;
	private String message1;
	private String message2;
	private String message3;
	private String message4;
	private String message5;
    private String action;
	private String photo;
	private String topic;
	private String timeStamp;
	private String delhiveryBoyKey;
	private String selectedBranches;
	private Map<String, String> deliveryBoys;
	
	public NotificationBean() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage1() {
		return message1;
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String getMessage3() {
		return message3;
	}

	public void setMessage3(String message3) {
		this.message3 = message3;
	}

	public String getMessage4() {
		return message4;
	}

	public void setMessage4(String message4) {
		this.message4 = message4;
	}

	public String getMessage5() {
		return message5;
	}

	public void setMessage5(String message5) {
		this.message5 = message5;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDelhiveryBoyKey() {
		return delhiveryBoyKey;
	}

	public void setDelhiveryBoyKey(String delhiveryBoyKey) {
		this.delhiveryBoyKey = delhiveryBoyKey;
	}

	public String getSelectedBranches() {
		return selectedBranches;
	}

	public void setSelectedBranches(String selectedBranches) {
		this.selectedBranches = selectedBranches;
	}

	public Map<String, String> getDeliveryBoys() {
		return deliveryBoys;
	}

	public void setDeliveryBoys(Map<String, String> deliveryBoys) {
		this.deliveryBoys = deliveryBoys;
	}
}
