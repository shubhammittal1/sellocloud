package com.bmp.bean.client;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.bmp.bean.courier.ClientProductCourierPriority;

public class ClientProductCourierPriorityBean implements Serializable {

	private static final long serialVersionUID = -128560521667229399L;

	//private Map<String, ClientProductCourierPriority> clientProductCourierPriorityMap;
	private String productType;
	private List<String> allowedCouriorKey;
	private String courierPeriorityTemplateKey;
	
	public ClientProductCourierPriorityBean() {
		super();
	}

	/*public Map<String, ClientProductCourierPriority> getClientProductCourierPriorityMap() {
		return clientProductCourierPriorityMap;
	}

	public void setClientProductCourierPriorityMap(Map<String, ClientProductCourierPriority> clientProductCourierPriorityMap) {
		this.clientProductCourierPriorityMap = clientProductCourierPriorityMap;
	}*/
	public String getProducttype() {
		return productType;
	}
	public void setProducttype(String productType) {
		this.productType = productType;
	}
	public List<String> getAllowedCouriorKey() {
		return allowedCouriorKey;
	}
	public void setAllowedCouriorKey(List<String> allowedCouriorKey) {
		this.allowedCouriorKey = allowedCouriorKey;
	}
	public String getCourierPeriorityTemplateKey() {
		return courierPeriorityTemplateKey;
	}
	public void setCourierPeriorityTemplateKey(String courierPeriorityTemplateKey) {
		this.courierPeriorityTemplateKey = courierPeriorityTemplateKey;
	}
	
}
