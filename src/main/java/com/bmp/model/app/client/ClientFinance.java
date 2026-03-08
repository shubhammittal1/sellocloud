package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.BillingCycle;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="clientFinance")
@AssignKey(assvalue=false)
public class ClientFinance extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -4677577840752533287L;
	
	private String contactPerson;
	private String registeredAdd;
	private String pincode;
	private String phone;
	private String mobile;
	private String email;
	private String moaDocument;
	private String logoImageName;
	private String additionalDocument1;
	private String additionalDocument2;
	private String cancelCheque;
	private String panCard;
	private BillingCycle billingCycle;
	private BillingCycle remittenceCycle;
	private String accountNumber;
	private String bankName;
	private String ifscCode;
	private String gstNo;
	@Indexed
	private List<String> productList_ss;
	private Map<String, ClientRate> clientRateMap;
	private Integer dimensionalWeightFactor;
	
	public ClientFinance(){}

	public String getRegisteredAdd() {
		return registeredAdd;
	}

	public String getPincode() {
		return pincode;
	}

	public void setRegisteredAdd(String registeredAdd) {
		this.registeredAdd = registeredAdd;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getMoaDocument() {
		return moaDocument;
	}

	public String getAdditionalDocument1() {
		return additionalDocument1;
	}

	public String getAdditionalDocument2() {
		return additionalDocument2;
	}

	public String getCancelCheque() {
		return cancelCheque;
	}

	public String getPanCard() {
		return panCard;
	}

	public BillingCycle getBillingCycle() {
		return billingCycle;
	}

	public BillingCycle getRemittenceCycle() {
		return remittenceCycle;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMoaDocument(String moaDocument) {
		this.moaDocument = moaDocument;
	}

	public void setAdditionalDocument1(String additionalDocument1) {
		this.additionalDocument1 = additionalDocument1;
	}

	public void setAdditionalDocument2(String additionalDocument2) {
		this.additionalDocument2 = additionalDocument2;
	}

	public void setCancelCheque(String cancelCheque) {
		this.cancelCheque = cancelCheque;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public void setBillingCycle(BillingCycle billingCycle) {
		this.billingCycle = billingCycle;
	}

	public void setRemittenceCycle(BillingCycle remittenceCycle) {
		this.remittenceCycle = remittenceCycle;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}


	public String getLogoImageName() {
		return logoImageName;
	}


	public void setLogoImageName(String logoImageName) {
		this.logoImageName = logoImageName;
	}

	public List<String> getProductList_ss() {
		return productList_ss;
	}

	public Map<String, ClientRate> getClientRateMap() {
		return clientRateMap;
	}

	public void setProductList_ss(List<String> productList_ss) {
		this.productList_ss = productList_ss;
	}

	public void setClientRateMap(Map<String, ClientRate> clientRateMap) {
		this.clientRateMap = clientRateMap;
	}

	public Integer getDimensionalWeightFactor() {
		return dimensionalWeightFactor;
	}

	public void setDimensionalWeightFactor(Integer dimensionalWeightFactor) {
		this.dimensionalWeightFactor = dimensionalWeightFactor;
	}
}
