package com.bmp.bean.report;


public class ReportBean {
	
	private String fromDate;
	private String toDate;
	private String filter;
	private String subFilter;
	private String awbNumber;
	private String formatType;
		
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
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getSubFilter() {
		return subFilter;
	}
	public void setSubFilter(String subFilter) {
		this.subFilter = subFilter;
	}
	public String getAwbNumber() {
		return awbNumber;
	}
	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}
	public String getFormatType() {
		return formatType;
	}
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}
}
