package com.bmp.model.app.saleorder;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.RalInvoiceType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="ralInvoiceDetails")
@AssignKey(assvalue=true)
public class RalInvoiceDetails extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String clientKey;
	@Indexed
	private String loanCode;
	@Indexed
	private String awbNumber;
	private String invoiceNumber;
	private String date;
	@Indexed
	private RalInvoiceType ralInvoiceType;
	
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
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
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
    
}
