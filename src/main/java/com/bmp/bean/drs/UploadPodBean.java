package com.bmp.bean.drs;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadPodBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<MultipartFile> fileList;
	private String key;
	
	public List<MultipartFile> getFileList() {
		return fileList;
	}
	public void setFileList(List<MultipartFile> fileList) {
		this.fileList = fileList;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
