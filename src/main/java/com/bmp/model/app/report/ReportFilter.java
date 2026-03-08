package com.bmp.model.app.report;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportFilter implements Serializable {
	
	private static final long serialVersionUID = 1292559317597746920L;

	private String key;
	private String indexField;
	private String displayName;
	private String fieldType;
	private Boolean isStatic;
	private String staticValues;			//id#~#value - comma sep
	private String searchQuery;
	private String secondaryClass;
	private String idFieldSecClass;
	private String valueFieldSecClass;
	private Boolean isMandate;
	
	public ReportFilter() {
		super();
	}
	
	public String getIndexField() {
		return indexField;
	}

	public void setIndexField(String indexField) {
		this.indexField = indexField;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Boolean getIsStatic() {
		return isStatic;
	}

	public void setIsStatic(Boolean isStatic) {
		this.isStatic = isStatic;
	}

	public String getStaticValues() {
		return staticValues;
	}

	public void setStaticValues(String staticValues) {
		this.staticValues = staticValues;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public String getSecondaryClass() {
		return secondaryClass;
	}

	public void setSecondaryClass(String secondaryClass) {
		this.secondaryClass = secondaryClass;
	}

	public String getIdFieldSecClass() {
		return idFieldSecClass;
	}

	public void setIdFieldSecClass(String idFieldSecClass) {
		this.idFieldSecClass = idFieldSecClass;
	}

	public String getValueFieldSecClass() {
		return valueFieldSecClass;
	}

	public void setValueFieldSecClass(String valueFieldSecClass) {
		this.valueFieldSecClass = valueFieldSecClass;
	}

	public Boolean getIsMandate() {
		return isMandate;
	}

	public void setIsMandate(Boolean isMandate) {
		this.isMandate = isMandate;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
