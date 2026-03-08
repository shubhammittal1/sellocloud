package com.bmp.bean.saleorder;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private CommonsMultipartFile fileData;
	private String uploadTypes;

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}


	public String getUploadTypes() {
		return uploadTypes;
	}

	
	public void setUploadTypes(String uploadTypes) {
		this.uploadTypes = uploadTypes;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
