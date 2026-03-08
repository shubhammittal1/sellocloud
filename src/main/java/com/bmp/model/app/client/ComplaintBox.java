package com.bmp.model.app.client;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.UserType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="complaintBox")
@AssignKey(assvalue=true)
public class ComplaintBox extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -4677577840752533287L;
	@Indexed
	private UserType userType_s;
	@Indexed
	private String userKey_s;
	private String complaintSubject;
	private String complaint;
	private Map<String, ComplaintHistory> histMap;
	private Map<String, ComplaintHistory> commentMap;
	@Indexed
	private String status_s;
	@Indexed
	private String assignedAgentKey_s;
	@Indexed
	private String assignedGroup_s;
	
	public ComplaintBox(){}

	public UserType getUserType_s() {
		return userType_s;
	}

	public void setUserType_s(UserType userType_s) {
		this.userType_s = userType_s;
	}

	public String getUserKey_s() {
		return userKey_s;
	}

	public void setUserKey_s(String userKey_s) {
		this.userKey_s = userKey_s;
	}

	public String getComplaintSubject() {
		return complaintSubject;
	}

	public void setComplaintSubject(String complaintSubject) {
		this.complaintSubject = complaintSubject;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public Map<String, ComplaintHistory> getHistMap() {
		return histMap;
	}

	public void setHistMap(Map<String, ComplaintHistory> histMap) {
		this.histMap = histMap;
	}

	public Map<String, ComplaintHistory> getCommentMap() {
		return commentMap;
	}

	public void setCommentMap(Map<String, ComplaintHistory> commentMap) {
		this.commentMap = commentMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAssignedAgentKey_s() {
		return assignedAgentKey_s;
	}

	public void setAssignedAgentKey_s(String assignedAgentKey_s) {
		this.assignedAgentKey_s = assignedAgentKey_s;
	}

	public String getAssignedGroup_s() {
		return assignedGroup_s;
	}

	public void setAssignedGroup_s(String assignedGroup_s) {
		this.assignedGroup_s = assignedGroup_s;
	}

	public String getStatus_s() {
		return status_s;
	}

	public void setStatus_s(String status_s) {
		this.status_s = status_s;
	}
	
}
