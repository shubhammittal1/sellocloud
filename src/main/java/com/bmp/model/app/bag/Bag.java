package com.bmp.model.app.bag;

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
@Document(collection="bag")
@AssignKey(assvalue=false)
public class Bag extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String bagName_s;
	private String bagDocName;
	@Indexed
	private String manifestKey_s;
	private Double bagOriginWeight;
	private Double bagDestinationWeight;
	@Indexed
	private String bagSealNo_s;
	private String productType;
	private String statusFlowKey;
	private StatusMasterNew status;
	@Indexed
	private String generatedByBranchKey_s;
	@Indexed
	private String currentBranchKey_s;
	@Indexed
	private String nextBranchKey_s;
	@Indexed
	private String previousBranchKey_s;
	@Indexed
	private String destinationBranchKey_s;
	private Map<String, BagHistory> bagHistories;
	@Indexed
	private List<String> packetList_ss;
	private List<String> packetNotScannedAtDestinationList;
	
	public Bag() {
		super();
	}

	public String getBagName_s() {
		return bagName_s;
	}

	public void setBagName_s(String bagName_s) {
		this.bagName_s = bagName_s;
	}
	
	public String getBagDocName() {
		return bagDocName;
	}

	public void setBagDocName(String bagDocName) {
		this.bagDocName = bagDocName;
	}

	public String getManifestKey_s() {
		return manifestKey_s;
	}

	public void setManifestKey_s(String manifestKey_s) {
		this.manifestKey_s = manifestKey_s;
	}

	public Double getBagOriginWeight() {
		return bagOriginWeight;
	}

	public void setBagOriginWeight(Double bagOriginWeight) {
		this.bagOriginWeight = bagOriginWeight;
	}

	public Double getBagDestinationWeight() {
		return bagDestinationWeight;
	}

	public void setBagDestinationWeight(Double bagDestinationWeight) {
		this.bagDestinationWeight = bagDestinationWeight;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBagSealNo_s() {
		return bagSealNo_s;
	}

	public void setBagSealNo_s(String bagSealNo_s) {
		this.bagSealNo_s = bagSealNo_s;
	}

	public String getStatusFlowKey() {
		return statusFlowKey;
	}

	public void setStatusFlowKey(String statusFlowKey) {
		this.statusFlowKey = statusFlowKey;
	}

	public String getGeneratedByBranchKey_s() {
		return generatedByBranchKey_s;
	}

	public void setGeneratedByBranchKey_s(String generatedByBranchKey_s) {
		this.generatedByBranchKey_s = generatedByBranchKey_s;
	}

	public String getCurrentBranchKey_s() {
		return currentBranchKey_s;
	}

	public void setCurrentBranchKey_s(String currentBranchKey_s) {
		this.currentBranchKey_s = currentBranchKey_s;
	}

	public String getNextBranchKey_s() {
		return nextBranchKey_s;
	}

	public void setNextBranchKey_s(String nextBranchKey_s) {
		this.nextBranchKey_s = nextBranchKey_s;
	}

	public String getPreviousBranchKey_s() {
		return previousBranchKey_s;
	}

	public void setPreviousBranchKey_s(String previousBranchKey_s) {
		this.previousBranchKey_s = previousBranchKey_s;
	}

	public String getDestinationBranchKey_s() {
		return destinationBranchKey_s;
	}

	public void setDestinationBranchKey_s(String destinationBranchKey_s) {
		this.destinationBranchKey_s = destinationBranchKey_s;
	}

	public Map<String, BagHistory> getBagHistories() {
		return bagHistories;
	}

	public void setBagHistories(Map<String, BagHistory> bagHistories) {
		this.bagHistories = bagHistories;
	}

	public List<String> getPacketList_ss() {
		return packetList_ss;
	}

	public void setPacketList_ss(List<String> packetList_ss) {
		this.packetList_ss = packetList_ss;
	}

	public List<String> getPacketNotScannedAtDestinationList() {
		return packetNotScannedAtDestinationList;
	}

	public void setPacketNotScannedAtDestinationList(
			List<String> packetNotScannedAtDestinationList) {
		this.packetNotScannedAtDestinationList = packetNotScannedAtDestinationList;
	}

	public StatusMasterNew getStatus() {
		return status;
	}

	public void setStatus(StatusMasterNew status) {
		this.status = status;
	}
	
}
