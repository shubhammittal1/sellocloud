package com.bmp.bean.report;

import java.util.Map;

public class SystemReportBean {
	
	private String reportKey;
	private String reportType;
	private String fromDate;
	private String toDate;
	private Map<String, Object> filters;
	private String keys;
	private String formatType;

	public String getReportKey() {
		return reportKey;
	}
	public void setReportKey(String reportKey) {
		this.reportKey = reportKey;
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
}
