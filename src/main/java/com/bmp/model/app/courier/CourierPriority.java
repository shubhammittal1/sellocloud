package com.bmp.model.app.courier;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.BusinessType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="courierPriority")
@AssignKey(assvalue=false)
public class CourierPriority extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -2895853850392968242L;
	
	private String name;
	private String description;
	private BusinessType courierType;
	private List<String> courierName;
	
	public CourierPriority(){
	    
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public List<String>  getCourierName() {
	    return courierName;
	}

	public void setCourierName(List<String>  courierName) {
	    this.courierName = courierName;
	}

	public BusinessType getCourierType() {
		return courierType;
	}

	public void setCourierType(BusinessType courierType) {
		this.courierType = courierType;
	}

	
	
}
