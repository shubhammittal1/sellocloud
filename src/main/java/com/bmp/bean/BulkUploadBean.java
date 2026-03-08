package com.bmp.bean;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BulkUploadBean {
	
	private String uploadId;
	private Long uploadAddId;
	private Long uploadUpdateId;
	private String uploadName;
	private String uploadType;
	private List<MultipartFile> files;
	private String errorMessage;
	
	public String getUploadId() {
		return uploadId;
	}
	public void setUploadId(String uploadId) {
		this.uploadId = uploadId;
	}
	public Long getUploadAddId() {
		return uploadAddId;
	}
	public void setUploadAddId(Long uploadAddId) {
		this.uploadAddId = uploadAddId;
	}
	public Long getUploadUpdateId() {
		return uploadUpdateId;
	}
	public void setUploadUpdateId(Long uploadUpdateId) {
		this.uploadUpdateId = uploadUpdateId;
	}
	public String getUploadName() {
		return uploadName;
	}
	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}
	public String getUploadType() {
		return uploadType;
	}
	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}