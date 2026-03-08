package com.bmp.bean.saleorder;

import java.util.Date;

public class InvoiceStatusBean {

	private String saleOrderNumber;
	private String invoiceStatus;
	private Date invoiceDate;
	private String loanCode;
	private String sksVendorId;
	private String imeNumber;
	
	public InvoiceStatusBean() {
		super();
	}

	public String getSaleOrderNumber() {
		return saleOrderNumber;
	}
	public void setSaleOrderNumber(String saleOrderNumber) {
		this.saleOrderNumber = saleOrderNumber;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}
	public String getSksVendorId() {
		return sksVendorId;
	}
	public void setSksVendorId(String sksVendorId) {
		this.sksVendorId = sksVendorId;
	}

	public String getImeNumber() {
		return imeNumber;
	}

	public void setImeNumber(String imeNumber) {
		this.imeNumber = imeNumber;
	}
	
	
}
