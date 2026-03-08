package com.bmp.model.app.bag;

import com.bmp.model.app.status.StatusMaster;

public class BagHistory {
	
	private StatusMaster toStatus;
	private StatusMaster fromStatus;
	private String fromStatusKey;
	private String toStatusKey;
	private String manifestKey;
	private String remarks;
	private String generatedByBranchKey;
	private String currentBranchKey;
	private String nextBranchKey;
	private String previousBranchKey;
	private String destinationBranchKey;
	private Long createdDate;
    private String createdBy;
	
	public BagHistory() {
		super();
	}

	public StatusMaster getToStatus() {
		return toStatus;
	}

	public void setToStatus(StatusMaster toStatus) {
		this.toStatus = toStatus;
	}

	public StatusMaster getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(StatusMaster fromStatus) {
		this.fromStatus = fromStatus;
	}

	public String getManifestKey() {
		return manifestKey;
	}

	public void setManifestKey(String manifestKey) {
		this.manifestKey = manifestKey;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getGeneratedByBranchKey() {
		return generatedByBranchKey;
	}

	public void setGeneratedByBranchKey(String generatedByBranchKey) {
		this.generatedByBranchKey = generatedByBranchKey;
	}

	public String getCurrentBranchKey() {
		return currentBranchKey;
	}

	public void setCurrentBranchKey(String currentBranchKey) {
		this.currentBranchKey = currentBranchKey;
	}

	public String getNextBranchKey() {
		return nextBranchKey;
	}

	public void setNextBranchKey(String nextBranchKey) {
		this.nextBranchKey = nextBranchKey;
	}

	public String getPreviousBranchKey() {
		return previousBranchKey;
	}

	public void setPreviousBranchKey(String previousBranchKey) {
		this.previousBranchKey = previousBranchKey;
	}

	public String getDestinationBranchKey() {
		return destinationBranchKey;
	}

	public void setDestinationBranchKey(String destinationBranchKey) {
		this.destinationBranchKey = destinationBranchKey;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getFromStatusKey() {
		return fromStatusKey;
	}

	public String getToStatusKey() {
		return toStatusKey;
	}

	public void setFromStatusKey(String fromStatusKey) {
		this.fromStatusKey = fromStatusKey;
	}

	public void setToStatusKey(String toStatusKey) {
		this.toStatusKey = toStatusKey;
	}
	
}
