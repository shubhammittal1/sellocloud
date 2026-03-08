package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="clientCode")
@AssignKey(assvalue=false)
public class ClientCode extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String clientKey;
	private String code;
	private String type;
	private String name;
	private String contactNumber;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String issuingBranch;
	private String email;
	private String alternetNumber;
	
	public ClientCode() {
		super();
	}

	
	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getIssuingBranch() {
		return issuingBranch;
	}

	public void setIssuingBranch(String issuingBranch) {
		this.issuingBranch = issuingBranch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlternetNumber() {
		return alternetNumber;
	}

	public void setAlternetNumber(String alternetNumber) {
		this.alternetNumber = alternetNumber;
	}
	
}
