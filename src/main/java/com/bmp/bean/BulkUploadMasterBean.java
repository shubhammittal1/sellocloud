package com.bmp.bean;

import java.util.List;
import java.util.Map;

import com.bmp.model.app.bulk.BulkHeader;
import com.bmp.model.app.bulk.BulkMaster;


public class BulkUploadMasterBean{
	
	private List<Map<String,Object>> records;
	private List<BulkHeader> bulkHeaders;
	private List<Map<String,Object>> successRecords;
	private List<Map<String,Object>> errorRecords;
	private BulkMaster bulkMaster;
	private String currentUser;
	private String uploadType;
	
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public BulkUploadMasterBean() {
		super();
	}
	public List<Map<String, Object>> getSuccessRecords() {
		return successRecords;
	}
	public void setSuccessRecords(List<Map<String, Object>> successRecords) {
		this.successRecords = successRecords;
	}
	public List<Map<String, Object>> getErrorRecords() {
		return errorRecords;
	}
	public void setErrorRecords(List<Map<String, Object>> errorRecords) {
		this.errorRecords = errorRecords;
	}
	public List<Map<String, Object>> getRecords() {
		return records;
	}
	public void setRecords(List<Map<String, Object>> records) {
		this.records = records;
	}
	public List<BulkHeader> getBulkHeaders() {
		return bulkHeaders;
	}
	public void setBulkHeaders(List<BulkHeader> bulkHeaders) {
		this.bulkHeaders = bulkHeaders;
	}
	public BulkMaster getBulkMaster() {
		return bulkMaster;
	}
	public void setBulkMaster(BulkMaster bulkMaster) {
		this.bulkMaster = bulkMaster;
	}
	public String getUploadType() {
		return uploadType;
	}
	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}
}