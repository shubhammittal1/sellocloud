package com.bmp.bean;

import java.util.List;

public class TwoTreadOrder {
	private long id;
	private String full_name;
	private String email;
	private String phone;
	private String mobile;
	private String province;
	private String district;
	private String city;
	private String street;
	private String house_number;
	private String zip;
	private String address;
	private String address_add;
	private String comment;
	private Double collectable_amount;
	private SenderDetails sender_details;
	private List<TwoTreadProduct> products;
	
	public TwoTreadOrder() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_add() {
		return address_add;
	}

	public void setAddress_add(String address_add) {
		this.address_add = address_add;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<TwoTreadProduct> getProducts() {
		return products;
	}

	public void setProducts(List<TwoTreadProduct> products) {
		this.products = products;
	}

	public Double getCollectable_amount() {
		return collectable_amount;
	}

	public void setCollectable_amount(Double collectable_amount) {
		this.collectable_amount = collectable_amount;
	}

	public SenderDetails getSender_details() {
		return sender_details;
	}

	public void setSender_details(SenderDetails sender_details) {
		this.sender_details = sender_details;
	}
	
}
