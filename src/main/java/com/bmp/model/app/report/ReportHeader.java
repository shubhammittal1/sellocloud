package com.bmp.model.app.report;

import java.io.Serializable;

import com.bmp.model.app.bulk.BulkHeader;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportHeader implements Serializable {
	
	private static final long serialVersionUID = 1292559317597746920L;

	private String key;
	private String indexField;
	private BulkHeader header;
	
	public ReportHeader() {
		super();
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getIndexField() {
		return indexField;
	}
	public void setIndexField(String indexField) {
		this.indexField = indexField;
	}
	public BulkHeader getHeader() {
		return header;
	}
	public void setHeader(BulkHeader header) {
		this.header = header;
	}
}
