package com.bmp.bean.client;

import java.io.Serializable;
import java.util.List;

public class ClientPincodeGroupCourierPriorityBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String clientKey;
	private String groupToGroupKey;
	private List<String> courierKeyList;
	
	public ClientPincodeGroupCourierPriorityBean() {
		super();
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getGroupToGroupKey() {
		return groupToGroupKey;
	}

	public void setGroupToGroupKey(String groupToGroupKey) {
		this.groupToGroupKey = groupToGroupKey;
	}

	public List<String> getCourierKeyList() {
		return courierKeyList;
	}

	public void setCourierKeyList(List<String> courierKeyList) {
		this.courierKeyList = courierKeyList;
	}
	
}
