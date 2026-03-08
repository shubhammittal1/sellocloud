package com.bmp.bean;

import java.util.List;

import com.bmp.model.app.masters.QCMaster;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QCCheckBean {
	
	private String awbNumber;
	private String productName;
	private String productSKU;
	private String category;
	private String brand;
	private String size;
	private String color;
	private String returnReason;
	private List<QCMaster> qclist;
	private String productImagesUrl;
	private String latlong;
	
	public QCCheckBean() {
		super();
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public List<QCMaster> getQclist() {
		return qclist;
	}

	public void setQclist(List<QCMaster> qclist) {
		this.qclist = qclist;
	}

	public String getProductImagesUrl() {
		return productImagesUrl;
	}

	public void setProductImagesUrl(String productImagesUrl) {
		this.productImagesUrl = productImagesUrl;
	}

	public String getLatlong() {
		return latlong;
	}

	public void setLatlong(String latlong) {
		this.latlong = latlong;
	}

}
