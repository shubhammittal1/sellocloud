package com.bmp.bean.saleorder;

import java.io.Serializable;

public class TeleCallingHistoryBean implements Serializable {

	private static final long serialVersionUID = 2557171511720295408L;
	
	private String awbNumber;
	private String callingDateTime;
	private Long callingDateTime_l;
	private String teleStatusKey;
	private String telecallingStatus;
	private String customerExpectedDeliveryDate;
	private String alternateNo;
	private String manifestId;
	private String outgoingCallLogsId;
	private String disposition;
	
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getCallingDateTime() {
		return callingDateTime;
	}
	public void setCallingDateTime(String callingDateTime) {
		this.callingDateTime = callingDateTime;
	}
	public Long getCallingDateTime_l() {
		return callingDateTime_l;
	}
	public void setCallingDateTime_l(Long callingDateTime_l) {
		this.callingDateTime_l = callingDateTime_l;
	}
	public String getTelecallingStatus() {
		return telecallingStatus;
	}
	public void setTelecallingStatus(String telecallingStatus) {
		this.telecallingStatus = telecallingStatus;
	}
	public String getCustomerExpectedDeliveryDate() {
		return customerExpectedDeliveryDate;
	}
	public void setCustomerExpectedDeliveryDate(String customerExpectedDeliveryDate) {
		this.customerExpectedDeliveryDate = customerExpectedDeliveryDate;
	}
	public String getTeleStatusKey() {
		return teleStatusKey;
	}
	public void setTeleStatusKey(String teleStatusKey) {
		this.teleStatusKey = teleStatusKey;
	}
	public String getAlternateNo() {
		return alternateNo;
	}
	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
	}
	public String getManifestId() {
		return manifestId;
	}
	public void setManifestId(String manifestId) {
		this.manifestId = manifestId;
	}
	public String getOutgoingCallLogsId() {
		return outgoingCallLogsId;
	}
	public void setOutgoingCallLogsId(String outgoingCallLogsId) {
		this.outgoingCallLogsId = outgoingCallLogsId;
	}
	public String getDisposition() {
		return disposition;
	}
	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}
	
		
}
