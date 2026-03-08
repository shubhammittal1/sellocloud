package com.bmp.model.app.masters;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.app.config.Settings;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="qcCheckList")
@AssignKey(assvalue=false)
@Component("com.bmp.model.app.masters.QCCheckList")
public class QCCheckList extends MongoBaseBean {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String clientName_s;
	private Map<String, Settings> category;			//Type Setting
	private Map<String, Settings> returnReason;		//Type Setting (returnReason, list of applicable qcCheck)
	private Map<String, Map<String, QCMaster>> qcCheckList;

	public QCCheckList(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientName_s() {
		return clientName_s;
	}

	public void setClientName_s(String clientName_s) {
		this.clientName_s = clientName_s;
	}

	public Map<String, Settings> getCategory() {
		return category;
	}

	public void setCategory(Map<String, Settings> category) {
		this.category = category;
	}

	public Map<String, Settings> getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(Map<String, Settings> returnReason) {
		this.returnReason = returnReason;
	}

	public Map<String, Map<String, QCMaster>> getQcCheckList() {
		return qcCheckList;
	}

	public void setQcCheckList(Map<String, Map<String, QCMaster>> qcCheckList) {
		this.qcCheckList = qcCheckList;
	}
}