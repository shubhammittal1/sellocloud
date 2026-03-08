package com.bmp.model.app.masters;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.facility.Branch;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="serviceablePincodeHistory")
@AssignKey(assvalue=false)
public class ServiceablePincodeHistory extends MongoBaseBean {
	
	private static final long serialVersionUID = 8809916544181801112L;
	private Pincode pincode;
	private Branch branch;
	private Map<String,ServiceProvider> serviceProviders;
	
	public ServiceablePincodeHistory() {
		super();
	}

	public Pincode getPincode() {
		return pincode;
	}

	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Map<String, ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}

	public void setServiceProviders(Map<String, ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}

}