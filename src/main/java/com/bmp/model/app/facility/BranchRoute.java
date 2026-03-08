package com.bmp.model.app.facility;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="branchRoute")
@AssignKey(assvalue=true)
public class BranchRoute extends MongoBaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Indexed
	private String branchKey_s;
	private String routeName;
	private List<String> pincodes;
	private List<String> assignUsers;
	
	public BranchRoute() {
		super();
	}
	public String getBranchKey_s() {
		return branchKey_s;
	}
	public void setBranchKey_s(String branchKey_s) {
		this.branchKey_s = branchKey_s;
	}
	
	
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<String> getPincodes() {
		return pincodes;
	}
	public void setPincodes(List<String> pincodes) {
		this.pincodes = pincodes;
	}
	public List<String> getAssignUsers() {
		return assignUsers;
	}
	public void setAssignUsers(List<String> assignUsers) {
		this.assignUsers = assignUsers;
	}

}
