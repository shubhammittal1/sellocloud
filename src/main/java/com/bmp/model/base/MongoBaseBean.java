package com.bmp.model.base;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public abstract class MongoBaseBean implements Serializable {

	private static final long serialVersionUID = -2070997497378647395L;

	@Id
	private String key_s;

	@Indexed
	private Boolean expired_b;
	
	@Indexed
    private Long createdDate_l;
	
	@Indexed
    private Long modifiedDate_l;
    
    private Long expiryDate;
    private Long lastRefreshTime;
    private String createdBy;
    private String updatedBy;
    
    @Indexed
	private String organizationKey;
    
	
    protected MongoBaseBean() {
    	super();
    }

	public String getKey_s() {
		return key_s;
	}

	public void setKey_s(String key_s) {
		this.key_s = key_s;
	}

	public Boolean getExpired_b() {
		return expired_b;
	}

	public void setExpired_b(Boolean expired_b) {
		this.expired_b = expired_b;
	}

	public Long getCreatedDate_l() {
		return createdDate_l;
	}

	public void setCreatedDate_l(Long createdDate_l) {
		this.createdDate_l = createdDate_l;
	}

	public Long getModifiedDate_l() {
		return modifiedDate_l;
	}

	public void setModifiedDate_l(Long modifiedDate_l) {
		this.modifiedDate_l = modifiedDate_l;
	}

	public Long getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Long expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getLastRefreshTime() {
		return lastRefreshTime;
	}

	public void setLastRefreshTime(Long lastRefreshTime) {
		this.lastRefreshTime = lastRefreshTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getOrganizationKey() {
		return organizationKey;
	}

	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}
    
}
