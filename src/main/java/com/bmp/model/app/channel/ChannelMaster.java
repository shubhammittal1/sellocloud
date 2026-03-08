package com.bmp.model.app.channel;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.ChannelType;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="channelMaster")
@AssignKey(assvalue=false)
public class ChannelMaster extends MongoBaseBean implements Serializable {

private static final long serialVersionUID = 1L;
	
	private String parentChannelKey;
	private String channelName;
	private ChannelType channelType;
	private String logoDoc;
	private String implClass;
	private String contactPerson;
	private String mobile;
	private String email;
	private String integrationRefUrl;
	private Boolean autoConfigure = false;
	private String autoConfigureProcess;
	
	public ChannelMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getter and Setter
	public String getParentChannelKey() {
		return parentChannelKey;
	}

	public void setParentChannelKey(String parentChannelKey) {
		this.parentChannelKey = parentChannelKey;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public ChannelType getChannelType() {
		return channelType;
	}


	public void setChannelType(ChannelType channelType) {
		this.channelType = channelType;
	}


	public String getLogoDoc() {
		return logoDoc;
	}

	public void setLogoDoc(String logoDoc) {
		this.logoDoc = logoDoc;
	}

	public String getImplClass() {
		return implClass;
	}

	public void setImplClass(String implClass) {
		this.implClass = implClass;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntegrationRefUrl() {
		return integrationRefUrl;
	}

	public void setIntegrationRefUrl(String integrationRefUrl) {
		this.integrationRefUrl = integrationRefUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getAutoConfigure() {
		return autoConfigure;
	}

	public void setAutoConfigure(Boolean autoConfigure) {
		this.autoConfigure = autoConfigure;
	}
	
	public String getAutoConfigureProcess() {
		return autoConfigureProcess;
	}
	
	public void setAutoConfigureProcess(String autoConfigureProcess) {
		this.autoConfigureProcess = autoConfigureProcess;
	}
	
}
