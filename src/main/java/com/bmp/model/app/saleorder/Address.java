package com.bmp.model.app.saleorder;

import org.springframework.data.annotation.Transient;

public class Address {
	private String name;
    private Double latitude;
    private Double longitude;
    private String phone;
    private String altNo;
    private String email;
    private String city;
    private String address1;
    private String address2;
    private String zip;
    @Transient
    private String consumerKey;
    @Transient
    private Boolean isStoreAddress;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAltNo() {
		return altNo;
	}
	public void setAltNo(String altNo) {
		this.altNo = altNo;
	}
	public String getConsumerKey() {
		return consumerKey;
	}
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}
	public Boolean getIsStoreAddress() {
		return isStoreAddress;
	}
	public void setIsStoreAddress(Boolean isStoreAddress) {
		this.isStoreAddress = isStoreAddress;
	}
    
    

}
