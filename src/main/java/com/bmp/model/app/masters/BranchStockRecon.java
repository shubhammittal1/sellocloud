package com.bmp.model.app.masters;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component("com.bmp.model.app.masters.BranchStockRecon")
@Document(collection="branchStockRecon")
@AssignKey(assvalue=true)
public class BranchStockRecon extends MongoBaseBean {
	
	private static final long serialVersionUID = 1L;
	@Indexed
	private String branchKey_s;
	private String branchName;
	@Indexed
	private String statusenginekey_s;
	@Indexed
	private String currentstatus_s;
	@Indexed
	private List<String> systemPackets_ss;
	@Indexed
	private List<String> scanPackets_ss;
	@Indexed
	private List<String> systemMissingPackets_ss;
	@Indexed
	private List<String> deviationMissingPackets_ss;
	private String closeby;
	private String remarks;
	private String closeRemarks;
	
	public BranchStockRecon(){}

	public String getBranchKey_s() {
		return branchKey_s;
	}

	public void setBranchKey_s(String branchKey_s) {
		this.branchKey_s = branchKey_s;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getStatusenginekey_s() {
		return statusenginekey_s;
	}

	public void setStatusenginekey_s(String statusenginekey_s) {
		this.statusenginekey_s = statusenginekey_s;
	}

	public String getCurrentstatus_s() {
		return currentstatus_s;
	}

	public void setCurrentstatus_s(String currentstatus_s) {
		this.currentstatus_s = currentstatus_s;
	}

	public List<String> getSystemPackets_ss() {
		return systemPackets_ss;
	}

	public void setSystemPackets_ss(List<String> systemPackets_ss) {
		this.systemPackets_ss = systemPackets_ss;
	}

	public List<String> getScanPackets_ss() {
		return scanPackets_ss;
	}

	public void setScanPackets_ss(List<String> scanPackets_ss) {
		this.scanPackets_ss = scanPackets_ss;
	}

	public List<String> getSystemMissingPackets_ss() {
		return systemMissingPackets_ss;
	}

	public void setSystemMissingPackets_ss(List<String> systemMissingPackets_ss) {
		this.systemMissingPackets_ss = systemMissingPackets_ss;
	}

	public List<String> getDeviationMissingPackets_ss() {
		return deviationMissingPackets_ss;
	}

	public void setDeviationMissingPackets_ss(List<String> deviationMissingPackets_ss) {
		this.deviationMissingPackets_ss = deviationMissingPackets_ss;
	}

	public String getCloseby() {
		return closeby;
	}

	public void setCloseby(String closeby) {
		this.closeby = closeby;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCloseRemarks() {
		return closeRemarks;
	}

	public void setCloseRemarks(String closeRemarks) {
		this.closeRemarks = closeRemarks;
	}

}