package com.bmp.model.app.systemCalling;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.GreetingSmsTemplateType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="greetingSmsTemplate")
@AssignKey(assvalue=false)
public class GreetingSmsTemplate extends MongoBaseBean implements Serializable{

	private static final long serialVersionUID = 1022222002L;
	
	private String templateName;
	private String template;
	private String description;
	private GreetingSmsTemplateType templateType;
	
	public GreetingSmsTemplate(){
		super();
	}
	
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GreetingSmsTemplateType getTemplateType() {
		return templateType;
	}
	public void setTemplateType(GreetingSmsTemplateType templateType) {
		this.templateType = templateType;
	}
	
	

}
