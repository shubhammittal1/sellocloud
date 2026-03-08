package com.bmp.model.app.masters;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="qcMaster")
@AssignKey(assvalue=false)
@Component("com.bmp.model.app.masters.QCMaster")
public class QCMaster extends MongoBaseBean {
	
	private static final long serialVersionUID = 1L;
	
	private String qcName;
	private String qcDisplayName;
	private String qcType;
	private String qcValidation;
	private String qcMandatory;
	private String qcClientValue;
	private String qcCustomerValue;
	private String qcImage;
	
	private Boolean imageRequired;
	private Boolean primaryImageRequired;
	private String primaryImage;
	private Boolean clientValueRequired;
	private List<String> subTypes;
	private String customerSubTypeValue;
	
	public QCMaster(){}

	public String getQcName() {
		return qcName;
	}

	public void setQcName(String qcName) {
		this.qcName = qcName;
	}

	public String getQcDisplayName() {
		return qcDisplayName;
	}

	public void setQcDisplayName(String qcDisplayName) {
		this.qcDisplayName = qcDisplayName;
	}

	public String getQcType() {
		return qcType;
	}

	public void setQcType(String qcType) {
		this.qcType = qcType;
	}

	public String getQcValidation() {
		return qcValidation;
	}

	public void setQcValidation(String qcValidation) {
		this.qcValidation = qcValidation;
	}

	public String getQcMandatory() {
		return qcMandatory;
	}

	public void setQcMandatory(String qcMandatory) {
		this.qcMandatory = qcMandatory;
	}

	public String getQcClientValue() {
		return qcClientValue;
	}

	public void setQcClientValue(String qcClientValue) {
		this.qcClientValue = qcClientValue;
	}

	public String getQcCustomerValue() {
		return qcCustomerValue;
	}

	public void setQcCustomerValue(String qcCustomerValue) {
		this.qcCustomerValue = qcCustomerValue;
	}

	public String getQcImage() {
		return qcImage;
	}

	public void setQcImage(String qcImage) {
		this.qcImage = qcImage;
	}

	public Boolean getImageRequired() {
		return imageRequired;
	}

	public void setImageRequired(Boolean imageRequired) {
		this.imageRequired = imageRequired;
	}

	public Boolean getPrimaryImageRequired() {
		return primaryImageRequired;
	}

	public void setPrimaryImageRequired(Boolean primaryImageRequired) {
		this.primaryImageRequired = primaryImageRequired;
	}

	public String getPrimaryImage() {
		return primaryImage;
	}

	public void setPrimaryImage(String primaryImage) {
		this.primaryImage = primaryImage;
	}

	public Boolean getClientValueRequired() {
		return clientValueRequired;
	}

	public void setClientValueRequired(Boolean clientValueRequired) {
		this.clientValueRequired = clientValueRequired;
	}

	public List<String> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(List<String> subTypes) {
		this.subTypes = subTypes;
	}

	public String getCustomerSubTypeValue() {
		return customerSubTypeValue;
	}

	public void setCustomerSubTypeValue(String customerSubTypeValue) {
		this.customerSubTypeValue = customerSubTypeValue;
	}

}