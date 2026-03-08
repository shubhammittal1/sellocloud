package com.bmp.model.app.courier;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection = "clientCourier")
@AssignKey(assvalue = false)
public class ClientCourier extends MongoBaseBean  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String clientKey; 
	private String courierKey;
	private String name;
	private Map<String,String> authMap;
	@Transient
	private String logoDoc;
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getCourierKey() {
		return courierKey;
	}
	public void setCourierKey(String courierKey) {
		this.courierKey = courierKey;
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
	public String getLogoDoc() {
		return logoDoc;
	}
	public void setLogoDoc(String logoDoc) {
		this.logoDoc = logoDoc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
