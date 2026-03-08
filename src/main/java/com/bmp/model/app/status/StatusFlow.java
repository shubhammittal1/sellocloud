package com.bmp.model.app.status;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;


@Document(collection="statusFlow")
@AssignKey(assvalue=false)
public class StatusFlow extends StatusTransition{
	
	
	private static final long serialVersionUID = 6381211981474998143L;
	
	private String statusTransitionMachineName;
	private Map<String,StatusTransition> statusTransitionsMap;
	
	
	public String getStatusTransitionMachineName() {
		return statusTransitionMachineName;
	}

	public void setStatusTransitionMachineName(String statusTransitionMachineName) {
		this.statusTransitionMachineName = statusTransitionMachineName;
	}

	public Map<String, StatusTransition> getStatusTransitionsMap() {
		return statusTransitionsMap;
	}

	public void setStatusTransitionsMap(Map<String, StatusTransition> statusTransitionsMap) {
		this.statusTransitionsMap = statusTransitionsMap;
	}

	
}
