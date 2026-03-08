package com.bmp.model.app.saleorder;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="dataFetchErrorLogs")
@AssignKey(assvalue=false)
public class DataFetchErrorLogs extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Indexed
	private String orderNumber;
	private String client;
	@Indexed
	private String loanProposalID;
	private String status;
	private String message;
	private String date;
	private String request;
	
	public DataFetchErrorLogs() {
		super();
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getLoanProposalID() {
		return loanProposalID;
	}

	public void setLoanProposalID(String loanProposalID) {
		this.loanProposalID = loanProposalID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	
}
