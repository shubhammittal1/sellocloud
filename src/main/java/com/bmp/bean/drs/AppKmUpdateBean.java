package com.bmp.bean.drs;

import java.io.Serializable;

public class AppKmUpdateBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String loginId;
	private String appKm;
	
	public AppKmUpdateBean() {
		super();
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getAppKm() {
		return appKm;
	}

	public void setAppKm(String appKm) {
		this.appKm = appKm;
	}
	
}
