package com.bmp.model.c2c;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebUserDevice  {
    private String deviceid_s;
    private boolean otpverified_s;
    private String otpcode_s;
    private boolean isactive_s;
    private String pushtoken_s;
    
    public WebUserDevice() {
		super();
	}
    
	public String getDeviceid_s() {
		return deviceid_s;
	}
	public void setDeviceid_s(String deviceid_s) {
		this.deviceid_s = deviceid_s;
	}
	public boolean isOtpverified_s() {
		return otpverified_s;
	}
	public void setOtpverified_s(boolean otpverified_s) {
		this.otpverified_s = otpverified_s;
	}
	public String getOtpcode_s() {
		return otpcode_s;
	}
	public void setOtpcode_s(String otpcode_s) {
		this.otpcode_s = otpcode_s;
	}
	public boolean isIsactive_s() {
		return isactive_s;
	}
	public void setIsactive_s(boolean isactive_s) {
		this.isactive_s = isactive_s;
	}
	public String getPushtoken_s() {
		return pushtoken_s;
	}
	public void setPushtoken_s(String pushtoken_s) {
		this.pushtoken_s = pushtoken_s;
	}
    
}
