package com.bmp.model.app.facility;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="role")
@AssignKey(assvalue=false)
public class Role extends MongoBaseBean {

	private static final long serialVersionUID = -7416733255996454336L;
    
	private String key;
	private String name;
	private Map<String,Page> pages;
	private Map<String, Map<String,PageAction>> pageActions;
	
	public Role() {
		super();
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Page> getPages() {
		return pages;
	}

	public void setPages(Map<String, Page> pages) {
		this.pages = pages;
	}

	public Map<String, Map<String, PageAction>> getPageActions() {
		return pageActions;
	}

	public void setPageActions(Map<String, Map<String, PageAction>> pageActions) {
		this.pageActions = pageActions;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}