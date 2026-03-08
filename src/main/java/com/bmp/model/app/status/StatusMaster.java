package com.bmp.model.app.status;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="statusMaster")
@AssignKey(assvalue=false)
public class StatusMaster extends MongoBaseBean{

	private static final long serialVersionUID = -2612505429093457904L;

	private String statusName;
	private String statusGroupName;
	private String oldStatusKey;
	private String oldStatusName;
	private String displayName;
	private Boolean internal;
	
	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public String getStatusGroupName() {
		return statusGroupName;
	}
	
	public void setStatusGroupName(String statusGroupName) {
		this.statusGroupName = statusGroupName;
	}

	public String getOldStatusKey() {
		return oldStatusKey;
	}

	public void setOldStatusKey(String oldStatusKey) {
		this.oldStatusKey = oldStatusKey;
	}

	public String getOldStatusName() {
		return oldStatusName;
	}

	public void setOldStatusName(String oldStatusName) {
		this.oldStatusName = oldStatusName;
	}

	public Boolean getInternal() {
		return internal;
	}

	public void setInternal(Boolean internal) {
		this.internal = internal;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}