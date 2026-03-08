package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.bean.courier.ClientProductCourierPriority;
import com.bmp.constant.PodType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.masters.City;
import com.bmp.model.app.masters.Country;
import com.bmp.model.app.masters.PincodeGroupZoneMatrix;
import com.bmp.model.app.masters.State;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="client")
@AssignKey(assvalue=false)
public class Client extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -4677577840752533287L;
	
	@Indexed
	private String companyName_s;
	private String logoImageName;
	private String displayName;
	private String registeredAdd;
	private Country country;
	private State state;
	private City city;
	private String pincode;
	private String contactPerson;
	private String phone;
	private String mobile;
	private String email;
	//private String companyVAT;
	//private String companyCST;
	//private String companyLST;
	//private String companyServiceTaxNo;
	//private String moaDocument;
	//private String additionalDocument1;
	//private String additionalDocument2;
	//private String cancelCheque;
	//private String panCard;
	@Deprecated
	private String deliveryAttempt;   
	@Deprecated
	private int pickupAttempt;                                        
	private Boolean rTOConfirmRequired;
	private Boolean awbAuto;
	private String clientCode;
	private String awbSequence;
	//private BillingCycle billingCycle;
	//private BillingCycle remittenceCycle;
	//private String accountNumber;
	//private String bankName;
	//private String ifscCode;
	private String token;
	private PincodeGroupZoneMatrix pincodeGroupZoneMatrix;
	private Map<String, List<String>> pincodeGroupCourierPriorityMap;
	private Map<String, ClientProductCourierPriority> clientProductCourierPriorityMap;
	private Boolean useClientAWBNumber;
	private String accountManager;
	@Deprecated
	private Boolean alertAllow;   
	@Deprecated
	private Boolean otpRequireForDeliver;                              
	private String selceManager;
	private boolean walletAvailable;
	@Indexed
	private List<String> productType_ss;
	private boolean otpActive;
	private boolean idproofActive;
	private Map<String, ClientProductServiceBean> productServiceMap;
	private int maxTelecallingCount;
	private boolean orderVerifyRequired;
	//private boolean appCalling;
	private List<String> receiverRelation;
	//private List<String> idProofType;
	private int maxNdrTelecallingCount;
	private boolean ndrValidateRequired;
	private int maxDeliveryTelecallingCount;
	private boolean deliveryConfirmRequired;
	
	public Client(){
		
	}

	public Boolean getUseClientAWBNumber() {
		return useClientAWBNumber;
	}

	public void setUseClientAWBNumber(Boolean useClientAWBNumber) {
		this.useClientAWBNumber = useClientAWBNumber;
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

	public String getDeliveryAttempt() {
		return deliveryAttempt;
	}

	public void setDeliveryAttempt(String deliveryAttempt) {
		this.deliveryAttempt = deliveryAttempt;
	}

	public int getPickupAttempt() {
		return pickupAttempt;
	}

	public void setPickupAttempt(int pickupAttempt) {
		this.pickupAttempt = pickupAttempt;
	}

	public Boolean getrTOConfirmRequired() {
		return rTOConfirmRequired;
	}

	public Boolean getAwbAuto() {
		return awbAuto;
	}

	public void setrTOConfirmRequired(Boolean rTOConfirmRequired) {
		this.rTOConfirmRequired = rTOConfirmRequired;
	}

	public void setAwbAuto(Boolean awbAuto) {
		this.awbAuto = awbAuto;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getAwbSequence() {
		return awbSequence;
	}

	public void setAwbSequence(String awbSequence) {
		this.awbSequence = awbSequence;
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

	public void setPincodeGroupZoneMatrix(PincodeGroupZoneMatrix pincodeGroupZoneMatrix) {
		this.pincodeGroupZoneMatrix = pincodeGroupZoneMatrix;
	}

	public Map<String, List<String>> getPincodeGroupCourierPriorityMap() {
		return pincodeGroupCourierPriorityMap;
	}

	public void setPincodeGroupCourierPriorityMap(
			Map<String, List<String>> pincodeGroupCourierPriorityMap) {
		this.pincodeGroupCourierPriorityMap = pincodeGroupCourierPriorityMap;
	}

	public Map<String, ClientProductCourierPriority> getClientProductCourierPriorityMap() {
		return clientProductCourierPriorityMap;
	}

	public void setClientProductCourierPriorityMap(Map<String, ClientProductCourierPriority> clientProductCourierPriorityMap) {
		this.clientProductCourierPriorityMap = clientProductCourierPriorityMap;
	}
	
	public String getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public Boolean getAlertAllow() {
		return alertAllow;
	}

	public void setAlertAllow(Boolean alertAllow) {
		this.alertAllow = alertAllow;
	}

	public Boolean getOtpRequireForDeliver() {
		return otpRequireForDeliver;
	}

	public void setOtpRequireForDeliver(Boolean otpRequireForDeliver) {
		this.otpRequireForDeliver = otpRequireForDeliver;
	}

	public String getSelceManager() {
		return selceManager;
	}

	public void setSelceManager(String selceManager) {
		this.selceManager = selceManager;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isWalletAvailable() {
		return walletAvailable;
	}

	public void setWalletAvailable(boolean walletAvailable) {
		this.walletAvailable = walletAvailable;
	}

	public List<String> getProductType_ss() {
		return productType_ss;
	}

	public void setProductType_ss(List<String> productType_ss) {
		this.productType_ss = productType_ss;
	}

	public boolean isOtpActive() {
		return otpActive;
	}

	public void setOtpActive(boolean otpActive) {
		this.otpActive = otpActive;
	}

	public boolean isIdproofActive() {
		return idproofActive;
	}

	public void setIdproofActive(boolean idproofActive) {
		this.idproofActive = idproofActive;
	}

	public Map<String, ClientProductServiceBean> getProductServiceMap() {
		return productServiceMap;
	}

	public void setProductServiceMap(Map<String, ClientProductServiceBean> productServiceMap) {
		this.productServiceMap = productServiceMap;
	}

	public int getMaxTelecallingCount() {
		return maxTelecallingCount;
	}

	public void setMaxTelecallingCount(int maxTelecallingCount) {
		this.maxTelecallingCount = maxTelecallingCount;
	}

	public boolean isOrderVerifyRequired() {
		return orderVerifyRequired;
	}

	public void setOrderVerifyRequired(boolean orderVerifyRequired) {
		this.orderVerifyRequired = orderVerifyRequired;
	}

	/*public boolean isAppCalling() {
		return appCalling;
	}

	public void setAppCalling(boolean appCalling) {
		this.appCalling = appCalling;
	}*/

	public List<String> getReceiverRelation() {
		return receiverRelation;
	}

	public void setReceiverRelation(List<String> receiverRelation) {
		this.receiverRelation = receiverRelation;
	}

	/*public List<String> getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(List<String> idProofType) {
		this.idProofType = idProofType;
	}*/

	public int getMaxNdrTelecallingCount() {
		return maxNdrTelecallingCount;
	}

	public void setMaxNdrTelecallingCount(int maxNdrTelecallingCount) {
		this.maxNdrTelecallingCount = maxNdrTelecallingCount;
	}

	public boolean isNdrValidateRequired() {
		return ndrValidateRequired;
	}

	public void setNdrValidateRequired(boolean ndrValidateRequired) {
		this.ndrValidateRequired = ndrValidateRequired;
	}

	public int getMaxDeliveryTelecallingCount() {
		return maxDeliveryTelecallingCount;
	}

	public void setMaxDeliveryTelecallingCount(int maxDeliveryTelecallingCount) {
		this.maxDeliveryTelecallingCount = maxDeliveryTelecallingCount;
	}

	public boolean isDeliveryConfirmRequired() {
		return deliveryConfirmRequired;
	}

	public void setDeliveryConfirmRequired(boolean deliveryConfirmRequired) {
		this.deliveryConfirmRequired = deliveryConfirmRequired;
	}

	
}