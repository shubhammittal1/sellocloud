package com.bmp.model.app.status;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="statusTransition")
@AssignKey(assvalue=false)
public class StatusTransition extends MongoBaseBean{

	
	private static final long serialVersionUID = -3342381335235683016L;
	
	private StatusMaster fromStatus;
	private StatusMaster toStatus;
	
	public StatusMaster getFromStatus() {
		return fromStatus;
	}
	
	public void setFromStatus(StatusMaster fromStatus) {
		this.fromStatus = fromStatus;
	}
	
	public StatusMaster getToStatus() {
		return toStatus;
	}
	
	public void setToStatus(StatusMaster toStatus) {
		this.toStatus = toStatus;
	}
	
	
	
}
