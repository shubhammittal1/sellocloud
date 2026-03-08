package com.bmp.model.app.facility;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="pageAction")
@AssignKey(assvalue=false)
public class PageAction extends MongoBaseBean {

	private static final long serialVersionUID = -3352984321762526987L;

	private String actionName;
	private String description;
	
	public PageAction() {
		super();
	}
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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