package com.bmp.bean.user;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.bmp.model.app.facility.Page;
import com.bmp.model.app.facility.PageAction;
import com.bmp.model.app.facility.User;
import com.bmp.model.config.Organization;

@Component
@Qualifier("sessionUserBean")
@Scope(value="session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionUserBean implements ISessionUserBean {
	
	private User user;
	private Map<String, LinkedHashMap<String, ArrayList<Page>>> menu;
	private Map<String, Page> allowPagesUrl;
	private List<String> userBranchKeyList;
	private Map<String, Map<String,PageAction>> pageActions;
	private String pushStatusClients;
	private boolean appRequest;
	private Organization organization;
	
	public SessionUserBean() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Map<String, Page> getAllowPagesUrl() {
		return allowPagesUrl;
	}
    
	public void setAllowPagesUrl(Map<String, Page> allowPagesUrl) {
		this.allowPagesUrl = allowPagesUrl;
	}

	public Map<String, LinkedHashMap<String, ArrayList<Page>>> getMenu() {
		return menu;
	}

	public void setMenu(Map<String, LinkedHashMap<String, ArrayList<Page>>> menu) {
		this.menu = menu;
	}

	public List<String> getUserBranchKeyList() {
		return userBranchKeyList;
	}

	public void setUserBranchKeyList(List<String> userBranchKeyList) {
		this.userBranchKeyList = userBranchKeyList;
	}

	public Map<String, Map<String, PageAction>> getPageActions() {
		return pageActions;
	}

	public void setPageActions(Map<String, Map<String, PageAction>> pageActions) {
		this.pageActions = pageActions;
	}

	public String getPushStatusClients() {
		return pushStatusClients;
	}

	public void setPushStatusClients(String pushStatusClients) {
		this.pushStatusClients = pushStatusClients;
	}

	public boolean isAppRequest() {
		return appRequest;
	}

	public void setAppRequest(boolean appRequest) {
		this.appRequest = appRequest;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
}
