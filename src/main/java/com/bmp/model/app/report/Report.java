package com.bmp.model.app.report;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="report")
@AssignKey(assvalue=false)
public class Report extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = -4563993301132745518L;
	
	private String name;
	private String duration;
	private String length;
	private int progressLength;
	private String query;
	@Indexed
	private String status_s;
	@Indexed
	private String userType_s;
	@Indexed
	private String entityKey_s;
	private String filter;
	private String subFilter;
	private String formatType;
	
	public Report() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getStatus_s() {
		return status_s;
	}

	public void setStatus_s(String status_s) {
		this.status_s = status_s;
	}

	public String getUserType_s() {
		return userType_s;
	}

	public void setUserType_s(String userType_s) {
		this.userType_s = userType_s;
	}

	public String getEntityKey_s() {
		return entityKey_s;
	}

	public void setEntityKey_s(String entityKey_s) {
		this.entityKey_s = entityKey_s;
	}

	public String getFilter() {
		return filter;
	}

	public String getSubFilter() {
		return subFilter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public void setSubFilter(String subFilter) {
		this.subFilter = subFilter;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public int getProgressLength() {
		return progressLength;
	}

	public void setProgressLength(int progressLength) {
		this.progressLength = progressLength;
	}
	
	

}
