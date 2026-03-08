package com.bmp.model.app.manifest;

import com.bmp.model.app.status.StatusMaster;

public class ManifestHistory {
	
	private StatusMaster toStatus;
	private StatusMaster fromStatus;
	private String fromStatusKey;
	private String toStatusKey;
	private String remarks;
	private Long createdDate;
    private String createdBy;
	
    public ManifestHistory() {
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
