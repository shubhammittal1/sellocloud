package com.bmp.bean.console;

import java.util.List;

public class MongoConsoleBean {

	private static final long serialVersionUID = 800549608904459136L;
	
	private String collectionName;
	private String key;
	private List<String> allKey;
	private String data;
	private String queryString;
	
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<String> getAllKey() {
		return allKey;
	}
	public void setAllKey(List<String> allKey) {
		this.allKey = allKey;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
}

