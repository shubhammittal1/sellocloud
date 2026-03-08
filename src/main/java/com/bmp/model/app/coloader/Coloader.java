package com.bmp.model.app.coloader;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.masters.City;
import com.bmp.model.app.masters.Country;
import com.bmp.model.app.masters.PincodeGroupZoneMatrix;
import com.bmp.model.app.masters.State;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="coloader")
@AssignKey(assvalue=false)
public class Coloader extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -2971568709190332822L;
    
	@Indexed
	private String companyName_s;
	private String logoImageName;
	private String registeredAdd;
	private Country country;
	private State state;
	private City city;
	private String pincode;
	private String contactPerson;
	private String phone;
	private String mobile;
	private String email;
	private String companyVAT;
	private String companyCST;
	private String companyLST;
	private String companyServiceTaxNo;
	private String moaDocument;
	private String additionalDocument1;
	private String additionalDocument2;
	private String cancelCheque;
	private String panCard;
	private String token;
	private String clientKey_s;
	private PincodeGroupZoneMatrix pincodeGroupZoneMatrix;
	
	public Coloader() {
	}

	public String getCompanyName_s() {
		return companyName_s;
	}

	public void setCompanyName_s(String companyName_s) {
		this.companyName_s = companyName_s;
	}

	public String getLogoImageName() {
		return logoImageName;
	}

	public void setLogoImageName(String logoImageName) {
		this.logoImageName = logoImageName;
	}

	public String getRegisteredAdd() {
		return registeredAdd;
	}

	public void setRegisteredAdd(String registeredAdd) {
		this.registeredAdd = registeredAdd;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyVAT() {
		return companyVAT;
	}

	public void setCompanyVAT(String companyVAT) {
		this.companyVAT = companyVAT;
	}

	public String getCompanyCST() {
		return companyCST;
	}

	public void setCompanyCST(String companyCST) {
		this.companyCST = companyCST;
	}

	public String getCompanyLST() {
		return companyLST;
	}

	public void setCompanyLST(String companyLST) {
		this.companyLST = companyLST;
	}

	public String getCompanyServiceTaxNo() {
		return companyServiceTaxNo;
	}

	public void setCompanyServiceTaxNo(String companyServiceTaxNo) {
		this.companyServiceTaxNo = companyServiceTaxNo;
	}

	public String getMoaDocument() {
		return moaDocument;
	}

	public void setMoaDocument(String moaDocument) {
		this.moaDocument = moaDocument;
	}

	public String getAdditionalDocument1() {
		return additionalDocument1;
	}

	public void setAdditionalDocument1(String additionalDocument1) {
		this.additionalDocument1 = additionalDocument1;
	}

	public String getAdditionalDocument2() {
		return additionalDocument2;
	}

	public void setAdditionalDocument2(String additionalDocument2) {
		this.additionalDocument2 = additionalDocument2;
	}

	public String getCancelCheque() {
		return cancelCheque;
	}

	public void setCancelCheque(String cancelCheque) {
		this.cancelCheque = cancelCheque;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public PincodeGroupZoneMatrix getPincodeGroupZoneMatrix() {
		return pincodeGroupZoneMatrix;
	}

	public void setPincodeGroupZoneMatrix(
			PincodeGroupZoneMatrix pincodeGroupZoneMatrix) {
		this.pincodeGroupZoneMatrix = pincodeGroupZoneMatrix;
	}

	public String getClientKey_s() {
		return clientKey_s;
	}

	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}

}