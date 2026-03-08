package com.bmp.model.app.saleorder;

import java.io.Serializable;

import com.bmp.constant.CamplainHistoryType;
import com.bmp.constant.CamplainStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CamplainHistory implements Serializable {
	
	
	private String comment;
	private String date;
	private String entityKey;
	private CamplainHistoryType camplainHistoryType;
	private CamplainStatus status;
	private String remarks;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEntityKey() {
		return entityKey;
	}
	public void setEntityKey(String entityKey) {
		this.entityKey = entityKey;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public CamplainStatus getStatus() {
		return status;
	}
	public void setStatus(CamplainStatus status) {
		this.status = status;
	}
	public CamplainHistoryType getCamplainHistoryType() {
		return camplainHistoryType;
	}
	public void setCamplainHistoryType(CamplainHistoryType camplainHistoryType) {
		this.camplainHistoryType = camplainHistoryType;
	}
	

}
