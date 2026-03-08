package com.bmp.model.app.api;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="vendorOrderReadyToPush")
@AssignKey(assvalue=false)
public class VendorOrderReadyToPush extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String awbNumber;

	public VendorOrderReadyToPush() {
		super();
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	
}