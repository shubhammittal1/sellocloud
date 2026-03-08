package com.bmp.bean.courier;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.bmp.model.app.courier.ServiceLevel;

public class ClientProductCourierPriority implements Serializable {

	private static final long serialVersionUID = 8507532583960529017L;

	
	private String productType;
	private List<String> allowedCourierKey;
	private List<String> courierPeriorityTemplateKey;
	private Map<String, List<String>> allowedCourierMap;		//ServiceLevel
	
	public ClientProductCourierPriority() {
		super();
	}


	public String getProductType() {
		return productType;
	}


	public List<String> getAllowedCourierKey() {
		return allowedCourierKey;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public void setAllowedCourierKey(List<String> allowedCourierKey) {
		this.allowedCourierKey = allowedCourierKey;
	}


	public List<String> getCourierPeriorityTemplateKey() {
		return courierPeriorityTemplateKey;
	}


	public void setCourierPeriorityTemplateKey(List<String> courierPeriorityTemplateKey) {
		this.courierPeriorityTemplateKey = courierPeriorityTemplateKey;
	}


	public Map<String, List<String>> getAllowedCourierMap() {
		return allowedCourierMap;
	}


	public void setAllowedCourierMap(Map<String, List<String>> allowedCourierMap) {
		this.allowedCourierMap = allowedCourierMap;
	}

	
	
}
