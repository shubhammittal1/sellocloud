package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection="clientNew")
@AssignKey(assvalue=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientNew extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = -46775778407525337L;
		
	@Indexed
	private String name;
	private String contactNumber;
	private String email;
	
	private Company company;
	
	private String panCardNumber;
	private String panCardDoc;
	private String gstNumber;
	private String gstDoc;
	
	private String bankName;
	private String beneficiaryName;
	private String accountNumber;
	private String ifscCode;
	private String blankChequeDoc;
	
	private Boolean isPrepaid; //True (Wallet) else Postpaid
	private Boolean isSelfServe;//  or Managed
	private Integer currentSection;
	private Boolean autoCourierAssignment;
	
	private Long awbSequence;
	private String awbSeriesPrefix;
	private Boolean profileComplated;
	private String token;
	private String logoDoc;
	private String clientActiveCourierPriority;
	
	private Boolean selfAwbAsCourierAwb;
	private Boolean usedWarehousingService = false;
	
	public  ClientNew() {
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}
	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}
	public String getPanCardDoc() {
		return panCardDoc;
	}
	public void setPanCardDoc(String panCardDoc) {
		this.panCardDoc = panCardDoc;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getGstDoc() {
		return gstDoc;
	}
	public void setGstDoc(String gstDoc) {
		this.gstDoc = gstDoc;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBlankChequeDoc() {
		return blankChequeDoc;
	}
	public void setBlankChequeDoc(String blankChequeDoc) {
		this.blankChequeDoc = blankChequeDoc;
	}
	public Boolean getIsPrepaid() {
		return isPrepaid;
	}
	public void setIsPrepaid(Boolean isPrepaid) {
		this.isPrepaid = isPrepaid;
	}
	public Boolean getIsSelfServe() {
		return isSelfServe;
	}
	public void setIsSelfServe(Boolean isSelfServe) {
		this.isSelfServe = isSelfServe;
	}
	public Integer getCurrentSection() {
		return currentSection;
	}
	public void setCurrentSection(Integer currentSection) {
		this.currentSection = currentSection;
	}

	public Boolean getAutoCourierAssignment() {
		return autoCourierAssignment;
	}

	public void setAutoCourierAssignment(Boolean autoCourierAssignment) {
		this.autoCourierAssignment = autoCourierAssignment;
	}

	public Long getAwbSequence() {
		return awbSequence;
	}

	public void setAwbSequence(Long awbSequence) {
		this.awbSequence = awbSequence;
	}

	public String getAwbSeriesPrefix() {
		return awbSeriesPrefix;
	}

	public void setAwbSeriesPrefix(String awbSeriesPrefix) {
		this.awbSeriesPrefix = awbSeriesPrefix;
	}

	public Boolean getProfileComplated() {
		return profileComplated;
	}

	public void setProfileComplated(Boolean profileComplated) {
		this.profileComplated = profileComplated;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLogoDoc() {
		return logoDoc;
	}

	public void setLogoDoc(String logoDoc) {
		this.logoDoc = logoDoc;
	}

	public String getClientActiveCourierPriority() {
		return clientActiveCourierPriority;
	}

	public void setClientActiveCourierPriority(String clientActiveCourierPriority) {
		this.clientActiveCourierPriority = clientActiveCourierPriority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getSelfAwbAsCourierAwb() {
		return selfAwbAsCourierAwb;
	}

	public void setSelfAwbAsCourierAwb(Boolean selfAwbAsCourierAwb) {
		this.selfAwbAsCourierAwb = selfAwbAsCourierAwb;
	}

	public Boolean getUsedWarehousingService() {
		return usedWarehousingService;
	}

	public void setUsedWarehousingService(Boolean usedWarehousingService) {
		this.usedWarehousingService = usedWarehousingService;
	}
	
	
	
	
	
}
