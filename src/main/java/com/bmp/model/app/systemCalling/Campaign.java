package com.bmp.model.app.systemCalling;

import java.io.Serializable;
import java.util.LinkedHashMap;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="campaign")
@AssignKey(assvalue=false)
public class Campaign extends MongoBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String name_s;
	@Indexed
	private String ivrNumber_s;
	private String appId;
	private LinkedHashMap<String,String> smsTemplateMap;
	private String greetingTemplate;
	private Boolean smsActive;
	
	public Campaign() {
		super();
	}

	public String getName_s() {
		return name_s;
	}

	public void setName_s(String name_s) {
		this.name_s = name_s;
	}

	public String getIvrNumber_s() {
		return ivrNumber_s;
	}

	public void setIvrNumber_s(String ivrNumber_s) {
		this.ivrNumber_s = ivrNumber_s;
	}
	public LinkedHashMap<String, String> getSmsTemplateMap() {
		return smsTemplateMap;
	}

	public void setSmsTemplateMap(LinkedHashMap<String, String> smsTemplateMap) {
		this.smsTemplateMap = smsTemplateMap;
	}

	public String getGreetingTemplate() {
		return greetingTemplate;
	}

	public void setGreetingTemplate(String greetingTemplate) {
		this.greetingTemplate = greetingTemplate;
	}

	public Boolean getSmsActive() {
		return smsActive;
	}

	public void setSmsActive(Boolean smsActive) {
		this.smsActive = smsActive;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	
}
