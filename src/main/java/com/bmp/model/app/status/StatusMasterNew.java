package com.bmp.model.app.status;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusMasterNew  implements Serializable{

	private static final long serialVersionUID = -2612505429093457904L;

	@Id
	private String key_s;
	private String statusName;
	private String statusGroupName;
	private String oldStatusKey;
	private String oldStatusName;
	private String displayName;
	private Boolean internal;
	
	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public String getStatusGroupName() {
		return statusGroupName;
	}
	
	public void setStatusGroupName(String statusGroupName) {
		this.statusGroupName = statusGroupName;
	}

	public String getOldStatusKey() {
		return oldStatusKey;
	}

	public void setOldStatusKey(String oldStatusKey) {
		this.oldStatusKey = oldStatusKey;
	}

	public String getOldStatusName() {
		return oldStatusName;
	}

	public void setOldStatusName(String oldStatusName) {
		this.oldStatusName = oldStatusName;
	}

	public Boolean getInternal() {
		return internal;
	}

	public void setInternal(Boolean internal) {
		this.internal = internal;
	}

	public String getKey_s() {
		return key_s;
	}

	public void setKey_s(String key_s) {
		this.key_s = key_s;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}