package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.constant.PickUpFrequency;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Component("com.bmp.model.app.client.ClientWarehouse")
@Document(collection="clientWarehouse")
@AssignKey(assvalue=false)
public class ClientWarehouse  extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String clientKey_s;
	@Indexed	
	private String warehouseName_s;
	private String contactPersonName;
	private String mobileNumber;
	private String altNumber;
	private String email;
	private String state;
	private String country;
	private String city;
	private String address;
	private String landmark;
	
	private String returnContactPersonName;
	private String returnMobileNumber;
	private String returnAddress;
	private String returnPincode;
	
	@Indexed
	private String pincode;
	private PickUpFrequency frequencyOfPickup;
	
	public ClientWarehouse() {
		super();
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

	public String getWarehouseName_s() {
		return warehouseName_s;
	}

	public void setWarehouseName_s(String warehouseName_s) {
		this.warehouseName_s = warehouseName_s;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAltNumber() {
		return altNumber;
	}

	public void setAltNumber(String altNumber) {
		this.altNumber = altNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public PickUpFrequency getFrequencyOfPickup() {
		return frequencyOfPickup;
	}

	public void setFrequencyOfPickup(PickUpFrequency frequencyOfPickup) {
		this.frequencyOfPickup = frequencyOfPickup;
	}

	public String getReturnContactPersonName() {
		return returnContactPersonName;
	}

	public void setReturnContactPersonName(String returnContactPersonName) {
		this.returnContactPersonName = returnContactPersonName;
	}

	public String getReturnMobileNumber() {
		return returnMobileNumber;
	}

	public void setReturnMobileNumber(String returnMobileNumber) {
		this.returnMobileNumber = returnMobileNumber;
	}

	public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}

	public String getReturnPincode() {
		return returnPincode;
	}

	public void setReturnPincode(String returnPincode) {
		this.returnPincode = returnPincode;
	}
	
}
