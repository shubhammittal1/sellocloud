package com.bmp.model.app.courier;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.BillingCycle;
import com.bmp.constant.BusinessType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.masters.City;
import com.bmp.model.app.masters.Country;
import com.bmp.model.app.masters.PincodeGroupZoneMatrix;
import com.bmp.model.app.masters.State;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="courier")
@AssignKey(assvalue=false)
public class Courier extends MongoBaseBean implements Serializable,Comparable<Courier>{

	private static final long serialVersionUID = -4677577840752533287L;

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
	private Boolean awbManuallyAssigned;
	private String codAddress;
	private String prepaidAddress;
	private BillingCycle billingCycle;
	private BillingCycle remittenceCycle;
	private String accountNumber;
	private String bankName;
	private String ifscCode;
	@Indexed
	private String token;
	private PincodeGroupZoneMatrix pincodeGroupZoneMatrix;
	private Boolean isCourierAwbSameAsSelfAwbNumber;
	
	//For indiapost courier
	private String parcelType;
	private String senderAddress;
	private String footerNote;
	private Boolean isPrintWeightNotVisible;
	
	@Indexed
	private List<String> serviceLevel;
	//Normal Courier
	private String barCodeDisplayName;
	private String returnAddress;
	private String supportMail;
	private BusinessType courierType;
	private Double weightDimensionFactor;
	private String parentCourier;
	private Boolean useCourierLabel;
	private Date tokenExpiredDate;
	
	public Courier() {
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
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

	public Boolean getAwbManuallyAssigned() {
		return awbManuallyAssigned;
	}

	public void setAwbManuallyAssigned(Boolean awbManuallyAssigned) {
		this.awbManuallyAssigned = awbManuallyAssigned;
	}

	public String getCodAddress() {
		return codAddress;
	}

	public void setCodAddress(String codAddress) {
		this.codAddress = codAddress;
	}

	public String getPrepaidAddress() {
		return prepaidAddress;
	}

	public void setPrepaidAddress(String prepaidAddress) {
		this.prepaidAddress = prepaidAddress;
	}

	public BillingCycle getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(BillingCycle billingCycle) {
		this.billingCycle = billingCycle;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
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

	public BillingCycle getRemittenceCycle() {
		return remittenceCycle;
	}

	public void setRemittenceCycle(BillingCycle remittenceCycle) {
		this.remittenceCycle = remittenceCycle;
	}

	public Boolean getIsCourierAwbSameAsSelfAwbNumber() {
		return isCourierAwbSameAsSelfAwbNumber;
	}

	public void setIsCourierAwbSameAsSelfAwbNumber(Boolean isCourierAwbSameAsSelfAwbNumber) {
		this.isCourierAwbSameAsSelfAwbNumber = isCourierAwbSameAsSelfAwbNumber;
	}
	
	public String getParcelType() {
		return parcelType;
	}

	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}

	public String getFooterNote() {
		return footerNote;
	}

	public void setFooterNote(String footerNote) {
		this.footerNote = footerNote;
	}

	public Boolean getIsPrintWeightNotVisible() {
		return isPrintWeightNotVisible;
	}

	public void setIsPrintWeightNotVisible(Boolean isPrintWeightNotVisible) {
		this.isPrintWeightNotVisible = isPrintWeightNotVisible;
	}
	
	public String getBarCodeDisplayName() {
		return barCodeDisplayName;
	}
	
	public void setBarCodeDisplayName(String barCodeDisplayName) {
		this.barCodeDisplayName = barCodeDisplayName;
	}

	public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}

	public String getSupportMail() {
		return supportMail;
	}

	public void setSupportMail(String supportMail) {
		this.supportMail = supportMail;
	}

	@Override
	public int compareTo(Courier o) {
		return this.getKey_s().compareToIgnoreCase(o.getKey_s());
	}
	public List<String> getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(List<String> serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public BusinessType getCourierType() {
		return courierType;
	}

	public void setCourierType(BusinessType courierType) {
		this.courierType = courierType;
	}

	public Double getWeightDimensionFactor() {
		return weightDimensionFactor;
	}

	public void setWeightDimensionFactor(Double weightDimensionFactor) {
		this.weightDimensionFactor = weightDimensionFactor;
	}

	public String getParentCourier() {
		return parentCourier;
	}

	public void setParentCourier(String parentCourier) {
		this.parentCourier = parentCourier;
	}
	public Boolean getUseCourierLabel() {
		return useCourierLabel;
	}

	public void setUseCourierLabel(Boolean useCourierLabel) {
		this.useCourierLabel = useCourierLabel;
	}

	public Date getTokenExpiredDate() {
		return tokenExpiredDate;
	}

	public void setTokenExpiredDate(Date tokenExpiredDate) {
		this.tokenExpiredDate = tokenExpiredDate;
	}
	

	
}