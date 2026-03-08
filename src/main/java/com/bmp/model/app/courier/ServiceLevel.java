package com.bmp.model.app.courier;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="serviceLevel")
@AssignKey(assvalue=false)
public class ServiceLevel extends MongoBaseBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	/*private String region;
	private String performance;*/
	private String serviceName;
	private String serviceType;
	
	public ServiceLevel() {
		super();
	}
	
	/*public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}*/
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

}
