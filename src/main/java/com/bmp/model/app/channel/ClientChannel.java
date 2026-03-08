package com.bmp.model.app.channel;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;


@Document(collection = "clientChannel")
@AssignKey(assvalue = true)
public class ClientChannel extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String clientKey; 
	private String channelKey;
	private String name;
	private Map<String,String> authMap;
	private String storeName;
	@Transient
	private String logoDoc;
	
	//Constructor from super class
	public ClientChannel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getter and setter

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getChannelKey() {
		return channelKey;
	}

	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getAuthMap() {
		return authMap;
	}

	public void setAuthMap(Map<String, String> authMap) {
		this.authMap = authMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLogoDoc() {
		return logoDoc;
	}

	public void setLogoDoc(String logoDoc) {
		this.logoDoc = logoDoc;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}