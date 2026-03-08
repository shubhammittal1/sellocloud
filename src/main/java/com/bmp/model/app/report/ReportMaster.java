package com.bmp.model.app.report;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="reportMaster")
@AssignKey(assvalue=false)
public class ReportMaster extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -6225583283504213321L;

	private String displayName;
	private String beanClass;
	private String implClass;
	private Map<String, ReportFilter> filters;
	private Map<String, ReportHeader> headers;
	private String headerSequence;
	@Indexed
	private List<String> roleList_ss;
	private List<String> clientList;
	
	private boolean multipleSheet;
	private String alertKey;
	
	public ReportMaster() {
		super();
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}

	public String getImplClass() {
		return implClass;
	}

	public void setImplClass(String implClass) {
		this.implClass = implClass;
	}

	public Map<String, ReportFilter> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, ReportFilter> filters) {
		this.filters = filters;
	}

	public Map<String, ReportHeader> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, ReportHeader> headers) {
		this.headers = headers;
	}

	public String getHeaderSequence() {
		return headerSequence;
	}

	public void setHeaderSequence(String headerSequence) {
		this.headerSequence = headerSequence;
	}

	public List<String> getRoleList_ss() {
		return roleList_ss;
	}

	public void setRoleList_ss(List<String> roleList_ss) {
		this.roleList_ss = roleList_ss;
	}

	public List<String> getClientList() {
		return clientList;
	}

	public void setClientList(List<String> clientList) {
		this.clientList = clientList;
	}

	public boolean isMultipleSheet() {
		return multipleSheet;
	}

	public void setMultipleSheet(boolean multipleSheet) {
		this.multipleSheet = multipleSheet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAlertKey() {
		return alertKey;
	}

	public void setAlertKey(String alertKey) {
		this.alertKey = alertKey;
	}
	
}
