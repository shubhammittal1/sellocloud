package com.bmp.bean.saleorder;

import com.bmp.constant.RalInvoiceType;

public class RalInvoiceDetailsBean {
	
	private String key;
	private String loanCode;
	private String invoiceNumber;
	private String date;
	private RalInvoiceType ralInvoiceType;
	
	private String status;
	private String errorMsg;
	
	public RalInvoiceDetailsBean() {
		super();
	}

	public String getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public RalInvoiceType getRalInvoiceType() {
		return ralInvoiceType;
	}
	public void setRalInvoiceType(RalInvoiceType ralInvoiceType) {
		this.ralInvoiceType = ralInvoiceType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
}
