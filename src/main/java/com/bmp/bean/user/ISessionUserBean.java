package com.bmp.bean.user;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.bmp.model.app.facility.Page;
import com.bmp.model.app.facility.User;

public interface ISessionUserBean {
	public User getUser();
	public void setUser(User user);
	public Map<String, Page> getAllowPagesUrl();
	public void setAllowPagesUrl(Map<String, Page> allowPagesUrl);
	public Map<String, LinkedHashMap<String, ArrayList<Page>>> getMenu();
	public void setMenu(Map<String, LinkedHashMap<String, ArrayList<Page>>> menu);
}
