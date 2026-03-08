package com.bmp.bean.common;

import java.util.List;

import com.bmp.model.app.facility.Branch;
import com.bmp.model.app.facility.Role;
import com.bmp.model.app.facility.User;

public class SessionBean {
	
	private User user;
	private List<Role> roles;
	private Branch branch;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}