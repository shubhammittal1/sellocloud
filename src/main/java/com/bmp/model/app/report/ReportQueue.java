package com.bmp.model.app.report;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="reportQueue")
@AssignKey(assvalue=false)
public class ReportQueue extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = -1653566048825959255L;

	@Indexed
	private String reportKey_s;
	private String reportType;
	private String fromDate;
	private String toDate;
	private Map<String, Object> filters;
	private String keys;
	private String formatType;
	private String length;
	@Indexed
	private String status_s;
	@Indexed
	private String userType_s;
	@Indexed
	private String entityKey_s;
	@Indexed
	private String executionType_s;
	private String scheduleDate;
	@Indexed
	private Long scheduleDate_l;
	private String duration;
	private String mailIds;
	private int progressCount;
	private String clientReportName;
	
	public ReportQueue() {
		super();
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Map<String, Object> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Object> filters) {
		this.filters = filters;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
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

	public String getExecutionType_s() {
		return executionType_s;
	}

	public void setExecutionType_s(String executionType_s) {
		this.executionType_s = executionType_s;
	}

	public Long getScheduleDate_l() {
		return scheduleDate_l;
	}

	public void setScheduleDate_l(Long scheduleDate_l) {
		this.scheduleDate_l = scheduleDate_l;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReportKey_s() {
		return reportKey_s;
	}

	public void setReportKey_s(String reportKey_s) {
		this.reportKey_s = reportKey_s;
	}

	public String getEntityKey_s() {
		return entityKey_s;
	}

	public void setEntityKey_s(String entityKey_s) {
		this.entityKey_s = entityKey_s;
	}

	public String getMailIds() {
		return mailIds;
	}

	public void setMailIds(String mailIds) {
		this.mailIds = mailIds;
	}

	public int getProgressCount() {
		return progressCount;
	}

	public void setProgressCount(int progressCount) {
		this.progressCount = progressCount;
	}

	public String getClientReportName() {
		return clientReportName;
	}

	public void setClientReportName(String clientReportName) {
		this.clientReportName = clientReportName;
	}

	
}
