package com.bmp.model.app.saleorder;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.CamplainStatus;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="complan")
@AssignKey(assvalue=false)
public class Camplain extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String awbNumber;
	private String clientKey;
	private String category;
	private String subcategory;
	private CamplainStatus status;
	private String agentKey;
	private String agentName;
	private String agentContact;
	private String assignedBy;
	private String assignedDate;
	private String closedDate;
	private Boolean working;
	private Boolean assigned;
	/* private CamplainHistory camplainHistory; */
	private Map<String,CamplainHistory> camplainHistorymap;
	
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	public String getAgentKey() {
		return agentKey;
	}
	public void setAgentKey(String agentKey) {
		this.agentKey = agentKey;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	public String getAgentContact() {
		return agentContact;
	}
	public void setAgentContact(String agentContact) {
		this.agentContact = agentContact;
	}
	public String getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}
	public CamplainStatus getStatus() {
		return status;
	}
	public void setStatus(CamplainStatus status) {
		this.status = status;
	}

	/*
	 * public CamplainHistory getCamplainHistory() { return camplainHistory; }
	 * public void setCamplainHistory(CamplainHistory camplainHistory) {
	 * this.camplainHistory = camplainHistory; }
	 */
	public Map<String,CamplainHistory> getCamplainHistorymap() {
		return camplainHistorymap;
	}
	public void setCamplainHistorymap(Map<String,CamplainHistory> camplainHistorymap) {
		this.camplainHistorymap = camplainHistorymap;
	}
	public Boolean getWorking() {
		return working;
	}
	public void setWorking(Boolean working) {
		this.working = working;
	}
	public Boolean getAssigned() {
		return assigned;
	}
	public void setAssigned(Boolean assigned) {
		this.assigned = assigned;
	}
	
	
}
