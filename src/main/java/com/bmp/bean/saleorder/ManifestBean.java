package com.bmp.bean.saleorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.bmp.model.app.bag.Bag;
import com.bmp.model.app.manifest.ManifestHistory;
import com.bmp.model.app.status.StatusMasterNew;

public class ManifestBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key_s;
	private Boolean expired_b;
    private Long createdDate_l;
    private Long modifiedDate_l;
    private Long expiryDate;
    private Long lastRefreshTime;
    private String createdBy;
    private String updatedBy;
	
	private String manifestNo_s;
	private String manifestType;
	private String originBranchKey_s;
	private String originBranchName;
	private String destinationBranchKey_s;
	private String destinationBranchName;
	private String productType;
	private String coloaderKey_s;
	private String coloaderName;
	private String coloaderTrackingNo;
	private String startKm;
	private String endKm;
	private Double netManifestWeight;
	private String statusFlowKey;
	private StatusMasterNew status;
	private List<String> bagList_ss;
	private Map<String, ManifestHistory> manifestHistories;
	private Map<String, String> bagKeyAndbagSealNoMap;
	private List<String> bagNotScannedAtDestinationList;
	private String coLoaderVehicleNo;
	private String coLoaderDiverName;
	private String coLoaderDriverContact;
	
	private List<Bag> bagObjectList;
	private String organizationKey;

	public String getKey_s() {
		return key_s;
	}

	public void setKey_s(String key_s) {
		this.key_s = key_s;
	}

	public Boolean getExpired_b() {
		return expired_b;
	}

	public void setExpired_b(Boolean expired_b) {
		this.expired_b = expired_b;
	}

	public Long getCreatedDate_l() {
		return createdDate_l;
	}

	public void setCreatedDate_l(Long createdDate_l) {
		this.createdDate_l = createdDate_l;
	}

	public Long getModifiedDate_l() {
		return modifiedDate_l;
	}

	public void setModifiedDate_l(Long modifiedDate_l) {
		this.modifiedDate_l = modifiedDate_l;
	}

	public Long getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Long expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getLastRefreshTime() {
		return lastRefreshTime;
	}

	public void setLastRefreshTime(Long lastRefreshTime) {
		this.lastRefreshTime = lastRefreshTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getManifestNo_s() {
		return manifestNo_s;
	}

	public void setManifestNo_s(String manifestNo_s) {
		this.manifestNo_s = manifestNo_s;
	}

	public String getManifestType() {
		return manifestType;
	}

	public void setManifestType(String manifestType) {
		this.manifestType = manifestType;
	}

	public String getOriginBranchKey_s() {
		return originBranchKey_s;
	}

	public void setOriginBranchKey_s(String originBranchKey_s) {
		this.originBranchKey_s = originBranchKey_s;
	}

	public String getOriginBranchName() {
		return originBranchName;
	}

	public void setOriginBranchName(String originBranchName) {
		this.originBranchName = originBranchName;
	}

	public String getDestinationBranchKey_s() {
		return destinationBranchKey_s;
	}

	public void setDestinationBranchKey_s(String destinationBranchKey_s) {
		this.destinationBranchKey_s = destinationBranchKey_s;
	}

	public String getDestinationBranchName() {
		return destinationBranchName;
	}

	public void setDestinationBranchName(String destinationBranchName) {
		this.destinationBranchName = destinationBranchName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getColoaderKey_s() {
		return coloaderKey_s;
	}

	public void setColoaderKey_s(String coloaderKey_s) {
		this.coloaderKey_s = coloaderKey_s;
	}

	public String getColoaderName() {
		return coloaderName;
	}

	public void setColoaderName(String coloaderName) {
		this.coloaderName = coloaderName;
	}

	public String getColoaderTrackingNo() {
		return coloaderTrackingNo;
	}

	public void setColoaderTrackingNo(String coloaderTrackingNo) {
		this.coloaderTrackingNo = coloaderTrackingNo;
	}

	public String getStartKm() {
		return startKm;
	}

	public void setStartKm(String startKm) {
		this.startKm = startKm;
	}

	public String getEndKm() {
		return endKm;
	}

	public void setEndKm(String endKm) {
		this.endKm = endKm;
	}

	public Double getNetManifestWeight() {
		return netManifestWeight;
	}

	public void setNetManifestWeight(Double netManifestWeight) {
		this.netManifestWeight = netManifestWeight;
	}

	public String getStatusFlowKey() {
		return statusFlowKey;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}

	public StatusMasterNew getStatus() {
		return status;
	}

	public void setStatus(StatusMasterNew status) {
		this.status = status;
	}

	public List<String> getBagList_ss() {
		return bagList_ss;
	}

	public void setBagList_ss(List<String> bagList_ss) {
		this.bagList_ss = bagList_ss;
	}

	public Map<String, ManifestHistory> getManifestHistories() {
		return manifestHistories;
	}

	public void setManifestHistories(Map<String, ManifestHistory> manifestHistories) {
		this.manifestHistories = manifestHistories;
	}

	public Map<String, String> getBagKeyAndbagSealNoMap() {
		return bagKeyAndbagSealNoMap;
	}

	public void setBagKeyAndbagSealNoMap(Map<String, String> bagKeyAndbagSealNoMap) {
		this.bagKeyAndbagSealNoMap = bagKeyAndbagSealNoMap;
	}

	public List<String> getBagNotScannedAtDestinationList() {
		return bagNotScannedAtDestinationList;
	}

	public void setBagNotScannedAtDestinationList(List<String> bagNotScannedAtDestinationList) {
		this.bagNotScannedAtDestinationList = bagNotScannedAtDestinationList;
	}

	public String getCoLoaderVehicleNo() {
		return coLoaderVehicleNo;
	}

	public void setCoLoaderVehicleNo(String coLoaderVehicleNo) {
		this.coLoaderVehicleNo = coLoaderVehicleNo;
	}

	public String getCoLoaderDiverName() {
		return coLoaderDiverName;
	}

	public void setCoLoaderDiverName(String coLoaderDiverName) {
		this.coLoaderDiverName = coLoaderDiverName;
	}

	public String getCoLoaderDriverContact() {
		return coLoaderDriverContact;
	}

	public void setCoLoaderDriverContact(String coLoaderDriverContact) {
		this.coLoaderDriverContact = coLoaderDriverContact;
	}

	public List<Bag> getBagObjectList() {
		return bagObjectList;
	}

	public void setBagObjectList(List<Bag> bagObjectList) {
		this.bagObjectList = bagObjectList;
	}

	public String getOrganizationKey() {
		return organizationKey;
	}

	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}
	
}
