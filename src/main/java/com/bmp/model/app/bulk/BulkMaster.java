package com.bmp.model.app.bulk;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="bulkMaster")
@AssignKey(assvalue=false)
public class BulkMaster extends MongoBaseBean{

	private static final long serialVersionUID = -4530979286142210566L;

	private String name;
	private String beanName;
	private String daoName;
	private Map<String, BulkHeader> bulkHeaderMap;
	private Map<String, BulkHeader> bulkSuccessHeaderMap;
	private Map<String, BulkHeader> bulkFailureHeaderMap;
	private String bulkHeaderSequence;
	private String successHeaderSequence;
	private String failureHeaderSequence;
	
	public BulkMaster() {
		super();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}
	
	public Map<String, BulkHeader> getBulkHeaderMap() {
		return bulkHeaderMap;
	}

	public void setBulkHeaderMap(Map<String, BulkHeader> bulkHeaderMap) {
		this.bulkHeaderMap = bulkHeaderMap;
	}

	public Map<String, BulkHeader> getBulkSuccessHeaderMap() {
		return bulkSuccessHeaderMap;
	}

	public void setBulkSuccessHeaderMap(Map<String, BulkHeader> bulkSuccessHeaderMap) {
		this.bulkSuccessHeaderMap = bulkSuccessHeaderMap;
	}

	public Map<String, BulkHeader> getBulkFailureHeaderMap() {
		return bulkFailureHeaderMap;
	}

	public void setBulkFailureHeaderMap(Map<String, BulkHeader> bulkFailureHeaderMap) {
		this.bulkFailureHeaderMap = bulkFailureHeaderMap;
	}
	
	public String getBulkHeaderSequence() {
		return bulkHeaderSequence;
	}

	public void setBulkHeaderSequence(String bulkHeaderSequence) {
		this.bulkHeaderSequence = bulkHeaderSequence;
	}

	public String getSuccessHeaderSequence() {
		return successHeaderSequence;
	}

	public void setSuccessHeaderSequence(String successHeaderSequence) {
		this.successHeaderSequence = successHeaderSequence;
	}

	public String getFailureHeaderSequence() {
		return failureHeaderSequence;
	}

	public void setFailureHeaderSequence(String failureHeaderSequence) {
		this.failureHeaderSequence = failureHeaderSequence;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}