package com.bmp.model.c2c;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebUserAddressList  {
	
	private String addressListKey;
	private String name;
    private String address1;
    private String address2;
    private String pincode;
    private String city;
    private String state;
    private String country;
    private String email;
    private String mobile;
    private String phone;
    private String landmark;
    private Boolean isPickup;
    
    public WebUserAddressList(){
    	super();
    }
    
	public String getAddressListKey() {
		return addressListKey;
	}

	public void setAddressListKey(String addressListKey) {
		this.addressListKey = addressListKey;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Boolean getIsPickup() {
		return isPickup;
	}

	public void setIsPickup(Boolean isPickup) {
		this.isPickup = isPickup;
	}
	
}