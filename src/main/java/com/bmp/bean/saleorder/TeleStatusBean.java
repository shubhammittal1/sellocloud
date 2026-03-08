package com.bmp.bean.saleorder;

import java.io.Serializable;

public class TeleStatusBean implements Serializable {

	private static final long serialVersionUID = 2557171511720295408L;
	
	private String telecallingStatus;
	private int telecallingCount;
	private String callingManifestId;
	private String callingManifestStatus;
	private String callingManifestUserKey;
	private String telecallingStatusKey;
	
	
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
	public String getTelecallingStatusKey() {
		return telecallingStatusKey;
	}
	public void setTelecallingStatusKey(String telecallingStatusKey) {
		this.telecallingStatusKey = telecallingStatusKey;
	}

}
