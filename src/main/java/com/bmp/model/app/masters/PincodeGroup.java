package com.bmp.model.app.masters;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
@Document(collection="pincodeGroup")
@AssignKey(assvalue=false)
public class PincodeGroup extends MongoBaseBean implements Serializable {

	
	private static final long serialVersionUID = -6578827589367337841L;
	
	private String name;
	private String desc;
	private List<String> pincodes;

	public PincodeGroup(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<String> getPincodes() {
		return pincodes;
	}

	public void setPincodes(List<String> pincodes) {
		this.pincodes = pincodes;
	}
	

}