package com.bmp.model.app.config;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="settings")
@AssignKey(assvalue=false)
public class Settings extends MongoBaseBean implements Comparable<Settings>{

	private static final long serialVersionUID = -5903092307348283334L;
    
	@Indexed
	private String typeName_s;
	@Indexed
	private String contextValue_s;
	@Indexed
	private String contextCode_s;
	private String description;
	private String extra1;
	private String extra2;
	
	public String getTypeName_s() {
		return typeName_s;
	}
	
	public void setTypeName_s(String typeName_s) {
		this.typeName_s = typeName_s;
	}
	
	public String getContextValue_s() {
		return contextValue_s;
	}
	
	public void setContextValue_s(String contextValue_s) {
		this.contextValue_s = contextValue_s;
	}
	
	public String getContextCode_s() {
		return contextCode_s;
	}
	
	public void setContextCode_s(String contextCode_s) {
		this.contextCode_s = contextCode_s;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getExtra1() {
		return extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	public String getExtra2() {
		return extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

	@Override
	public int compareTo(Settings o) {
		 return this.description.compareTo(o.description);
	}
	
	
}