package com.bmp.model.app.saleorder;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="rdsp")
@AssignKey(assvalue=false)
public class RDSP extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("MerchantID")
	private String MerchantID;
	
	@JsonProperty("MerchantName")
	private String MerchantName;
	
	@JsonProperty("MerchantMobile")
	private String MerchantMobile;
	
	@JsonProperty("MerchantAddress")
	private String MerchantAddress;
	
	@JsonProperty("MerchantLatLong")
	private String MerchantLatLong;
	
	@JsonProperty("Status")
	private String Status;
	
	@JsonProperty("Text1")
	private String Text1;
	
	@JsonProperty("Text2")
	private String Text2;
	
	@JsonProperty("Numeric1")
	private String Numeric1;
	
	@JsonProperty("Numeric2")
	private String Numeric2;
	
	@JsonProperty("Boolean")
	private String Boolean;
	
	@JsonProperty("Date")
	private String Date;
	
	private String city;
	private String state;
	private String country;
	private String pincode;
	@Indexed
	private Boolean isPushInRal;
	
	public RDSP() {
		super();
	}
	
	@JsonProperty("MerchantID")
	public String getMerchantID() {
		return MerchantID;
	}

	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}

	@JsonProperty("MerchantName")
	public String getMerchantName() {
		return MerchantName;
	}


	public void setMerchantName(String merchantName) {
		MerchantName = merchantName;
	}

	@JsonProperty("MerchantMobile")
	public String getMerchantMobile() {
		return MerchantMobile;
	}


	public void setMerchantMobile(String merchantMobile) {
		MerchantMobile = merchantMobile;
	}

	@JsonProperty("MerchantAddress")
	public String getMerchantAddress() {
		return MerchantAddress;
	}


	public void setMerchantAddress(String merchantAddress) {
		MerchantAddress = merchantAddress;
	}

	@JsonProperty("MerchantLatLong")
	public String getMerchantLatLong() {
		return MerchantLatLong;
	}


	public void setMerchantLatLong(String merchantLatLong) {
		MerchantLatLong = merchantLatLong;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}

	@JsonProperty("Text1")
	public String getText1() {
		return Text1;
	}


	public void setText1(String text1) {
		Text1 = text1;
	}

	@JsonProperty("Text2")
	public String getText2() {
		return Text2;
	}


	public void setText2(String text2) {
		Text2 = text2;
	}

	@JsonProperty("Numeric2")
	public String getNumeric2() {
		return Numeric2;
	}


	public void setNumeric2(String numeric2) {
		Numeric2 = numeric2;
	}

	@JsonProperty("Boolean")
	public String getBoolean() {
		return Boolean;
	}


	public void setBoolean(String b) {
		Boolean = b;
	}

	@JsonProperty("Date")
	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getIsPushInRal() {
		return isPushInRal;
	}

	public void setIsPushInRal(Boolean isPushInRal) {
		this.isPushInRal = isPushInRal;
	}

	public String getNumeric1() {
		return Numeric1;
	}

	public void setNumeric1(String numeric1) {
		Numeric1 = numeric1;
	}
	

	
}
