package com.bmp.model.app.facility;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="page")
@AssignKey(assvalue=false)
public class Page extends MongoBaseBean {

	private static final long serialVersionUID = -3202393018553544275L;
    
	private String module;
	private String subModule;
	private String page;
	private String displayName;
	private String pageURL;
	private String description;
	private Map<String, PageAction> pageActionMap;
	
	public Page() {
		super();
	}
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getSubModule() {
		return subModule;
	}
	public void setSubModule(String subModule) {
		this.subModule = subModule;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPageURL() {
		return pageURL;
	}
	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Map<String, PageAction> getPageActionMap() {
		return pageActionMap;
	}

	public void setPageActionMap(Map<String, PageAction> pageActionMap) {
		this.pageActionMap = pageActionMap;
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