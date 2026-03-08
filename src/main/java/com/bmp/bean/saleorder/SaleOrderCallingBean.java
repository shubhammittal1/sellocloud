package com.bmp.bean.saleorder;

import java.io.Serializable;
import java.util.Map;

import com.bmp.model.app.status.StatusMasterNew;

public class SaleOrderCallingBean implements Serializable {

	private static final long serialVersionUID = 2557171511720295408L;
	
	private String awbNumber;
	private String saleOrderNumber_s;
	private String saleOrderDate;
	private String consigneeName;
	private String consigneeMobileNumber;
	private String consigneeAlternateNumber;
	private String productName;
	private StatusMasterNew currentStatus;
	private String telecallingStatus;
	private int telecallingCount;
	private Map<String, TeleCallingBean> telecallingHistory;
	
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getSaleOrderNumber_s() {
		return saleOrderNumber_s;
	}
	public void setSaleOrderNumber_s(String saleOrderNumber_s) {
		this.saleOrderNumber_s = saleOrderNumber_s;
	}
	public String getSaleOrderDate() {
		return saleOrderDate;
	}
	public void setSaleOrderDate(String saleOrderDate) {
		this.saleOrderDate = saleOrderDate;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeMobileNumber() {
		return consigneeMobileNumber;
	}
	public void setConsigneeMobileNumber(String consigneeMobileNumber) {
		this.consigneeMobileNumber = consigneeMobileNumber;
	}
	public String getConsigneeAlternateNumber() {
		return consigneeAlternateNumber;
	}
	public void setConsigneeAlternateNumber(String consigneeAlternateNumber) {
		this.consigneeAlternateNumber = consigneeAlternateNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public StatusMasterNew getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(StatusMasterNew currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getTelecallingStatus() {
		return telecallingStatus;
	}
	public void setTelecallingStatus(String telecallingStatus) {
		this.telecallingStatus = telecallingStatus;
	}
	public int getTelecallingCount() {
		return telecallingCount;
	}
	public void setTelecallingCount(int telecallingCount) {
		this.telecallingCount = telecallingCount;
	}
	public Map<String, TeleCallingBean> getTelecallingHistory() {
		return telecallingHistory;
	}
	public void setTelecallingHistory(Map<String, TeleCallingBean> telecallingHistory) {
		this.telecallingHistory = telecallingHistory;
	}
	public String getCallingManifestId() {
		return callingManifestId;
	}
	public void setCallingManifestId(String callingManifestId) {
		this.callingManifestId = callingManifestId;
	}
	public String getCallingManifestStatus() {
		return callingManifestStatus;
	}
	public void setCallingManifestStatus(String callingManifestStatus) {
		this.callingManifestStatus = callingManifestStatus;
	}
	public String getCallingManifestUserKey() {
		return callingManifestUserKey;
	}
	public void setCallingManifestUserKey(String callingManifestUserKey) {
		this.callingManifestUserKey = callingManifestUserKey;
	}
	private String callingManifestId;
	private String callingManifestStatus;
	private String callingManifestUserKey;
	
	
}
