package com.bmp.model.app.client;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="clientCategoryMapping")
@AssignKey(assvalue=false)
public class ClientCategoryMapping extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -4677577840752533287L;
	
	@Indexed
	private String clientKey_s;
	private String name;
	@Indexed
	private String type_s;
	private String description;
	private String typeCode;
	
	public String getClientKey_s() {
		return clientKey_s;
	}
	public void setClientKey_s(String clientKey_s) {
		this.clientKey_s = clientKey_s;
	}
	public String getType_s() {
		return type_s;
	}
	public void setType_s(String type_s) {
		this.type_s = type_s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	
}