package com.bmp.model.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseBean implements Serializable {

	private static final long serialVersionUID = 2557171511720295408L;

	private Boolean expired_b;
    private Long expiryDate;
    private Long lastRefreshTime;
    private String key_s;
    private Long createdDate_l;
    private Long modifiedDate_l;
    private String createdBy;
    private String updatedBy;

    protected BaseBean() {
    	super();
    }

	public Boolean getExpired_b() {
		return expired_b;
	}

	public void setExpired_b(Boolean expired_b) {
		this.expired_b = expired_b;
	}

	public String getKey_s() {
		return key_s;
	}

	public void setKey_s(String key_s) {
		this.key_s = key_s;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key_s == null) ? 0 : key_s.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseBean other = (BaseBean) obj;
		if (key_s == null) {
			if (other.key_s != null)
				return false;
		} else if (!key_s.equals(other.key_s))
			return false;
		return true;
	}
}