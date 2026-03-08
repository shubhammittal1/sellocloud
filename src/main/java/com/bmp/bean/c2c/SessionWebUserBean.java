package com.bmp.bean.c2c;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.bmp.model.c2c.WebUser;

@Component
@Qualifier("SessionWebUserBean")
@Scope(value="session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionWebUserBean {
	
	private WebUser webUser;
	
	public SessionWebUserBean() {
		super();
	}

	public WebUser getWebUser() {
		return webUser;
	}

	public void setWebUser(WebUser webUser) {
		this.webUser = webUser;
	}
	
}
