package com.bmp.model.app.bulk;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="bulkHeader")
@AssignKey(assvalue=false)
public class BulkHeader extends MongoBaseBean implements Comparable<BulkHeader>{

	private static final long serialVersionUID = -5903092307348283334L;

	private String headerName;
	private String displayName;
	private String datatype;
	private Map<String, BulkValidation> bulkValidationMap;
	private Boolean mandatory;
	private Boolean primaryKey;
	private Boolean secondaryKey;
	private String beanClass;
	private String daoClass;
	private int sequenceNo;
	private String classField;
	
	public BulkHeader() {
		super();
	}

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public Map<String, BulkValidation> getBulkValidationMap() {
		return bulkValidationMap;
	}

	public void setBulkValidationMap(Map<String, BulkValidation> bulkValidationMap) {
		this.bulkValidationMap = bulkValidationMap;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public Boolean getPrimaryKey() {
		return primaryKey;
	}

	public Boolean getSecondaryKey() {
		return secondaryKey;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public void setPrimaryKey(Boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public void setSecondaryKey(Boolean secondaryKey) {
		this.secondaryKey = secondaryKey;
	}

	public String getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}

	public String getDaoClass() {
		return daoClass;
	}

	public void setDaoClass(String daoClass) {
		this.daoClass = daoClass;
	}

	@Override
	public int compareTo(BulkHeader o) {
		if(this.sequenceNo < o.getSequenceNo())
			return -1;
		else if(this.sequenceNo > o.getSequenceNo())
			return 1;
		return 0;
	}

	public String getClassField() {
		return classField;
	}

	public void setClassField(String classField) {
		this.classField = classField;
	}
}