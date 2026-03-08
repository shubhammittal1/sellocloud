package com.bmp.model.c2c;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="webUser")
@AssignKey(assvalue=true)
public class WebUser extends MongoBaseBean implements Serializable {
	    
	    private static final long serialVersionUID = 2557171511720295408L; 
	    
	    @Indexed
	    private String loginType_s;
	    private String password;
	    private String name;
	    private String gander;
	    
	    @Indexed
	    private String emailid_s;
	    
	    @Indexed
	    private String mobileNumber_s;
	    
	    @Indexed
	    private String country_s;
	    private String address;
	    
	    @Indexed
	    private String pincode_s;
	    
	    @Indexed
	    private String city_s;
	    
	    @Indexed
	    private String state_s;
	    
	    @Indexed
	    private String phone_s;
	    
	    @Indexed
	    private String facebookid_s;
	    
	    @Indexed
	    private String googleplusid_s;
	    private boolean isRegistrationCompleted;
		private String deviceId;
		private List<WebUserAddressList> userAddresses;
		
		private Boolean registrationOtpVerified;
		private String registrationAndLoginOtp;
		private Long lastOtpSendDate;
		
	    
	    public WebUser(){
	    	super();
	    }

		public String getLoginType_s() {
			return loginType_s;
		}

		public void setLoginType_s(String loginType_s) {
			this.loginType_s = loginType_s;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGander() {
			return gander;
		}

		public void setGander(String gander) {
			this.gander = gander;
		}

		public String getEmailid_s() {
			return emailid_s;
		}

		public void setEmailid_s(String emailid_s) {
			this.emailid_s = emailid_s;
		}

		public String getMobileNumber_s() {
			return mobileNumber_s;
		}

		public void setMobileNumber_s(String mobileNumber_s) {
			this.mobileNumber_s = mobileNumber_s;
		}

		/*public String getCompanyName_s() {
			return companyName_s;
		}

		public void setCompanyName_s(String companyName_s) {
			this.companyName_s = companyName_s;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getBusinessIndustry() {
			return businessIndustry;
		}

		public void setBusinessIndustry(String businessIndustry) {
			this.businessIndustry = businessIndustry;
		}*/

		public String getCountry_s() {
			return country_s;
		}

		public void setCountry_s(String country_s) {
			this.country_s = country_s;
		}

		/*public boolean isOTPVerified() {
			return isOTPVerified;
		}

		public void setOTPVerified(boolean isOTPVerified) {
			this.isOTPVerified = isOTPVerified;
		}

		public String getOtpCode() {
			return otpCode;
		}

		public void setOtpCode(String otpCode) {
			this.otpCode = otpCode;
		}

		public Timestamp getAuthorizationdatetime_s() {
			return authorizationdatetime_s;
		}

		public void setAuthorizationdatetime_s(Timestamp authorizationdatetime_s) {
			this.authorizationdatetime_s = authorizationdatetime_s;
		}

		public String getStatus_s() {
			return status_s;
		}

		public void setStatus_s(String status_s) {
			this.status_s = status_s;
		}*/

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPincode_s() {
			return pincode_s;
		}

		public void setPincode_s(String pincode_s) {
			this.pincode_s = pincode_s;
		}

		public String getCity_s() {
			return city_s;
		}

		public void setCity_s(String city_s) {
			this.city_s = city_s;
		}

		public String getState_s() {
			return state_s;
		}

		public void setState_s(String state_s) {
			this.state_s = state_s;
		}

		public String getPhone_s() {
			return phone_s;
		}

		public void setPhone_s(String phone_s) {
			this.phone_s = phone_s;
		}

		public String getFacebookid_s() {
			return facebookid_s;
		}

		public void setFacebookid_s(String facebookid_s) {
			this.facebookid_s = facebookid_s;
		}

		public String getGoogleplusid_s() {
			return googleplusid_s;
		}

		public void setGoogleplusid_s(String googleplusid_s) {
			this.googleplusid_s = googleplusid_s;
		}

		public boolean isRegistrationCompleted() {
			return isRegistrationCompleted;
		}

		public void setRegistrationCompleted(boolean isRegistrationCompleted) {
			this.isRegistrationCompleted = isRegistrationCompleted;
		}
      
		public String getDeviceId() {
			return deviceId;
		}

		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

		/*public List<String> getPacketIds() {
			return packetIds;
		}

		public void setPacketIds(List<String> packetIds) {
			this.packetIds = packetIds;
		}

		public List<String> getSaleOrderIds() {
			return saleOrderIds;
		}

		public void setSaleOrderIds(List<String> saleOrderIds) {
			this.saleOrderIds = saleOrderIds;
		}

		public List<WebUserBulkOrder> getBulkOrders() {
			return bulkOrders;
		}

		public void setBulkOrders(List<WebUserBulkOrder> bulkOrders) {
			this.bulkOrders = bulkOrders;
		}*/

		public List<WebUserAddressList> getUserAddresses() {
			return userAddresses;
		}

		public void setUserAddresses(List<WebUserAddressList> userAddresses) {
			this.userAddresses = userAddresses;
		}

		public Boolean getRegistrationOtpVerified() {
			return registrationOtpVerified;
		}

		public void setRegistrationOtpVerified(Boolean registrationOtpVerified) {
			this.registrationOtpVerified = registrationOtpVerified;
		}

		public String getRegistrationAndLoginOtp() {
			return registrationAndLoginOtp;
		}

		public void setRegistrationAndLoginOtp(String registrationAndLoginOtp) {
			this.registrationAndLoginOtp = registrationAndLoginOtp;
		}

		public Long getLastOtpSendDate() {
			return lastOtpSendDate;
		}

		public void setLastOtpSendDate(Long lastOtpSendDate) {
			this.lastOtpSendDate = lastOtpSendDate;
		}
		
	    
}
