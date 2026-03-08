package com.bmp.model.app.auth;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="authFieldMaster")
@AssignKey(assvalue=false)
public class AuthFieldMaster extends MongoBaseBean{

    private static final long serialVersionUID = 1L;
    
    private String fieldCode; 
    private String fieldType;
    private String fieldName;
    private boolean isRequired;
    private boolean isStatic;
    private boolean isExpired;
    private String fieldValue;
    private String description;
    
    public AuthFieldMaster() {
		super();
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
	
	public boolean getIsExpired() {
		return isExpired;
	}
	
	public void setIsExpired(boolean isExpired) {
		this.isExpired = isExpired;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
