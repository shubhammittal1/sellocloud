package com.bmp.bean.saleorder;

import java.io.Serializable;

public class RdspResponseBean implements Serializable{

private static final long serialVersionUID = 1L;
	
	private String MerchantID;
	private String Code;
	private String Remarks;
	
	public String getMerchantID() {
		return MerchantID;
	}
	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
	
}
