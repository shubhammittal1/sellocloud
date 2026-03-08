package com.bmp.model.app.facility;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.Employee;
import com.bmp.constant.KycStatus;
import com.bmp.constant.OnBoardingStatus;
import com.bmp.constant.UserType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="user")
@AssignKey(assvalue=false)
public class User extends MongoBaseBean {
	
	private static final long serialVersionUID = 1L;
	@Indexed
	private String loginId;
	private String password;
	private String fisrtName;
	private String lastName;
	@Indexed
	private String fisrtName_s;
	@Indexed
	private String lastName_s;
	private String gender;
	private String country;
	private String state;
	private String city;
	private String pincode;
	private String address;
	@Indexed
	private String email;
	private String mobile;
	@Indexed
	private String mobile_s;
	private String department;
	private String designation;
	private String image;
	private UserType type;
	private String thirdPartyKey;
	private String thirdPartyWarehouseKey;
	private Map<String,Role> rolesMap;    
	private Map<String,Branch> branchsMap;
	private Boolean admin;
	private String vehicle;
	private List<String> assignClients;
	private String deviceId;
	private String employeeCode;
	private Employee employeeType;
	private Long passwordResetDate;
	private boolean passwordExpired;
	private String appVersion;
	@Indexed
	private String diallerPin;
	private boolean twoWayCalling;
	
	private String otp;
	private Long otpDate;
	private OnBoardingStatus onBoardingStatus;
	private KycStatus kycStatus;
	private String panCard;
	private String panCardImg;
	private String aadharCard;
	private String aadharCardImg;
	private String drivingLicence;
	private String drivingLicenceImg;
	private String vehicleImg;
	private String bankName;
	private String accountNumber;
	private String ifscCode;
	private String cancelCheque;
	private boolean kycComplete;
	private boolean bankDetailsComplete;
	private boolean profileComplete;
	private Integer kycRejectedsmsCount;
	
	public User() {
		super();
	}	

	public String getLoginId() {
		
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getThirdPartyKey() {
		return thirdPartyKey;
	}

	public void setThirdPartyKey(String thirdPartyKey) {
		this.thirdPartyKey = thirdPartyKey;
	}
	
	public Map<String, Role> getRolesMap() {
		return rolesMap;
	}

	public void setRolesMap(Map<String, Role> rolesMap) {
		this.rolesMap = rolesMap;
	}

	public Map<String, Branch> getBranchsMap() {
		return branchsMap;
	}

	public void setBranchsMap(Map<String, Branch> branchsMap) {
		this.branchsMap = branchsMap;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public List<String> getAssignClients() {
		return assignClients;
	}

	public void setAssignClients(List<String> assignClients) {
		this.assignClients = assignClients;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getFisrtName_s() {
		return fisrtName_s;
	}

	public void setFisrtName_s(String fisrtName_s) {
		this.fisrtName_s = fisrtName_s;
	}

	public String getLastName_s() {
		return lastName_s;
	}

	public void setLastName_s(String lastName_s) {
		this.lastName_s = lastName_s;
	}

	public String getMobile_s() {
		return mobile_s;
	}

	public void setMobile_s(String mobile_s) {
		this.mobile_s = mobile_s;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Employee getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(Employee employeeType) {
		this.employeeType = employeeType;
	}

	public Long getPasswordResetDate() {
		return passwordResetDate;
	}

	public void setPasswordResetDate(Long passwordResetDate) {
		this.passwordResetDate = passwordResetDate;
	}

	public boolean isPasswordExpired() {
		return passwordExpired;
	}

	public void setPasswordExpired(boolean passwordExpired) {
		this.passwordExpired = passwordExpired;
	}
	
	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getDiallerPin() {
		return diallerPin;
	}

	public void setDiallerPin(String diallerPin) {
		this.diallerPin = diallerPin;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Long getOtpDate() {
		return otpDate;
	}

	public void setOtpDate(Long otpDate) {
		this.otpDate = otpDate;
	}
	
	public OnBoardingStatus getOnBoardingStatus() {
		return onBoardingStatus;
	}

	public void setOnBoardingStatus(OnBoardingStatus onBoardingStatus) {
		this.onBoardingStatus = onBoardingStatus;
	}
	
	public KycStatus getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(KycStatus kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getPanCardImg() {
		return panCardImg;
	}

	public void setPanCardImg(String panCardImg) {
		this.panCardImg = panCardImg;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getAadharCardImg() {
		return aadharCardImg;
	}

	public void setAadharCardImg(String aadharCardImg) {
		this.aadharCardImg = aadharCardImg;
	}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public String getDrivingLicenceImg() {
		return drivingLicenceImg;
	}

	public void setDrivingLicenceImg(String drivingLicenceImg) {
		this.drivingLicenceImg = drivingLicenceImg;
	}

	public String getVehicleImg() {
		return vehicleImg;
	}

	public void setVehicleImg(String vehicleImg) {
		this.vehicleImg = vehicleImg;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public String getCancelCheque() {
		return cancelCheque;
	}

	public void setCancelCheque(String cancelCheque) {
		this.cancelCheque = cancelCheque;
	}

	public boolean isKycComplete() {
		return kycComplete;
	}

	public void setKycComplete(boolean kycComplete) {
		this.kycComplete = kycComplete;
	}

	public boolean isBankDetailsComplete() {
		return bankDetailsComplete;
	}

	public void setBankDetailsComplete(boolean bankDetailsComplete) {
		this.bankDetailsComplete = bankDetailsComplete;
	}

	public boolean isProfileComplete() {
		return profileComplete;
	}

	public void setProfileComplete(boolean profileComplete) {
		this.profileComplete = profileComplete;
	}

	public boolean isTwoWayCalling() {
		return twoWayCalling;
	}

	public void setTwoWayCalling(boolean twoWayCalling) {
		this.twoWayCalling = twoWayCalling;
	}

	public Integer getKycRejectedsmsCount() {
		return kycRejectedsmsCount;
	}

	public void setKycRejectedsmsCount(Integer kycRejectedsmsCount) {
		this.kycRejectedsmsCount = kycRejectedsmsCount;
	}

	public String getThirdPartyWarehouseKey() {
		return thirdPartyWarehouseKey;
	}

	public void setThirdPartyWarehouseKey(String thirdPartyWarehouseKey) {
		this.thirdPartyWarehouseKey = thirdPartyWarehouseKey;
	}
	
	
	
}