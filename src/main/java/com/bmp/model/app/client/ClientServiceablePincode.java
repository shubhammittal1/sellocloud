package com.bmp.model.app.client;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="clientServiceablePincode")
@AssignKey(assvalue=false)
public class ClientServiceablePincode extends MongoBaseBean {
	
	private static final long serialVersionUID = 8809916544181801112L;
	
	private	Map<String, String> pickupPincodeMap;
	private	Map<String, String> dropPincodeMap;
	
	public ClientServiceablePincode() {
		super();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public Map<String, String> getPickupPincodeMap() {
		return pickupPincodeMap;
	}

	public void setPickupPincodeMap(Map<String, String> pickupPincodeMap) {
		this.pickupPincodeMap = pickupPincodeMap;
	}

	public Map<String, String> getDropPincodeMap() {
		return dropPincodeMap;
	}

	public void setDropPincodeMap(Map<String, String> dropPincodeMap) {
		this.dropPincodeMap = dropPincodeMap;
	}

}