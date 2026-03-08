package com.bmp.model.app.manifest;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.status.StatusMasterNew;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="manifest")
@AssignKey(assvalue=false)
public class Manifest extends MongoBaseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String manifestNo_s;
	private String manifestType;
	@Indexed
	private String originBranchKey_s;
	private String originBranchName;
	@Indexed
	private String destinationBranchKey_s;
	private String destinationBranchName;
	private String productType;
	@Indexed
	private String coloaderKey_s;
	private String coloaderName;
	private String coloaderTrackingNo;
	private String startKm;
	private String endKm;
	private Double netManifestWeight;
	private String statusFlowKey;
	private StatusMasterNew status;
	@Indexed
	private List<String> bagList_ss;
	private Map<String, ManifestHistory> manifestHistories;
	private Map<String, String> bagKeyAndbagSealNoMap;
	private List<String> bagNotScannedAtDestinationList;
	
	private String coLoaderVehicleNo;
	private String coLoaderDiverName;
	private String coLoaderDriverContact;

	
	public Manifest() {
		super();
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

	public String getDestinationBranchKey_s() {
		return destinationBranchKey_s;
	}

	public void setDestinationBranchKey_s(String destinationBranchKey_s) {
		this.destinationBranchKey_s = destinationBranchKey_s;
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

	public String getOriginBranchName() {
		return originBranchName;
	}

	public void setOriginBranchName(String originBranchName) {
		this.originBranchName = originBranchName;
	}

	public String getDestinationBranchName() {
		return destinationBranchName;
	}

	public void setDestinationBranchName(String destinationBranchName) {
		this.destinationBranchName = destinationBranchName;
	}

	public Map<String, String> getBagKeyAndbagSealNoMap() {
		return bagKeyAndbagSealNoMap;
	}

	public void setBagKeyAndbagSealNoMap(Map<String, String> bagKeyAndbagSealNoMap) {
		this.bagKeyAndbagSealNoMap = bagKeyAndbagSealNoMap;
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

	public List<String> getBagNotScannedAtDestinationList() {
		return bagNotScannedAtDestinationList;
	}

	public void setBagNotScannedAtDestinationList(
			List<String> bagNotScannedAtDestinationList) {
		this.bagNotScannedAtDestinationList = bagNotScannedAtDestinationList;
	}

	public StatusMasterNew getStatus() {
		return status;
	}

	public void setStatus(StatusMasterNew status) {
		this.status = status;
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

}
