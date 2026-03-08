package com.bmp.bean.saleorder;

import java.io.Serializable;

public class BillingOtherCharge implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String key;
	private String name;
	private Double amount;
	private Double fsAmount;
	private boolean gst;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getFsAmount() {
		return fsAmount;
	}
	public void setFsAmount(Double fsAmount) {
		this.fsAmount = fsAmount;
	}
	public boolean isGst() {
		return gst;
	}
	public void setGst(boolean gst) {
		this.gst = gst;
	}
	
	
	
	
}
