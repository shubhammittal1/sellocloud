package com.bmp.model.app.systemCalling;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="numberMetadata")
@AssignKey(assvalue=false)
public class NumberMetadata extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;
	private String circle;
	private String circleName;
	@Indexed
	private String type;
	private String operator;
	private String operatorName;
	@Indexed
	private String dnd;
	private String customerName;
	//@Indexed
	//private boolean isLandline;
	
	public NumberMetadata() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDnd() {
		return dnd;
	}

	public void setDnd(String dnd) {
		this.dnd = dnd;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	
	

}
