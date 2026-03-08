package com.bmp.model.app.masters;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="pincodeGroupZoneMatrix")
@AssignKey(assvalue=false)
public class PincodeGroupZoneMatrix extends MongoBaseBean implements Serializable {
	
	private static final long serialVersionUID = -1500189576102871560L;
	
	private String name;
	private String desc;
	private Map<String,PincodeGroup> groups;
	@Indexed
	private List<String> groupToGroups_ss;
	private Map<String, RateZone> pincodeGroupZoneMatrixMap;

	public PincodeGroupZoneMatrix(){}
	
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


	public Map<String, RateZone> getPincodeGroupZoneMatrixMap() {
		return pincodeGroupZoneMatrixMap;
	}

	public Map<String, PincodeGroup> getGroups() {
		return groups;
	}

	public void setGroups(Map<String, PincodeGroup> groups) {
		this.groups = groups;
	}

	public void setPincodeGroupZoneMatrixMap(Map<String, RateZone> pincodeGroupZoneMatrixMap) {
		this.pincodeGroupZoneMatrixMap = pincodeGroupZoneMatrixMap;
	}

	public List<String> getGroupToGroups_ss() {
		return groupToGroups_ss;
	}

	public void setGroupToGroups_ss(List<String> groupToGroups_ss) {
		this.groupToGroups_ss = groupToGroups_ss;
	}
	
}