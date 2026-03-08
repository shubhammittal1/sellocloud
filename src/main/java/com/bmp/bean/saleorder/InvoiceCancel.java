package com.bmp.bean.saleorder;

import java.io.Serializable;
import java.util.Date;

public class InvoiceCancel /*implements Serializable*/{
	//private static final long serialVersionUID = 1L;
	
	private String loanproposalid;
	private String invoiceNumber;
	private String serialNumber;
	private String invoiceCancelDate;
	private String status;
	
	public InvoiceCancel(){
		super();
	}
	
	public String getLoanproposalid() {
		return loanproposalid;
	}
	public void setLoanproposalid(String loanproposalid) {
		this.loanproposalid = loanproposalid;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getInvoiceCancelDate() {
		return invoiceCancelDate;
	}
	public void setInvoiceCancelDate(String invoiceCancelDate) {
		this.invoiceCancelDate = invoiceCancelDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
