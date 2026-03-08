package com.bmp.bean.courier;


public class FieldBean{

	private String fieldCode;
	private String fieldType;
	private String fieldName;
	private boolean isRequired;
	private boolean isStatic;
	private String fieldValue;
	private String description;
	
	
	public FieldBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Getter and Setter
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public boolean getIsRequired() {
		return isRequired;
	}
	public void setIsRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}
	public boolean getIsStatic() {
		return isStatic;
	}
	public void setIsStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
