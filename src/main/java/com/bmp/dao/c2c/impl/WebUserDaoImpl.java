package com.bmp.dao.c2c.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.c2c.WebUserDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.c2c.WebUser;

@Repository
@Qualifier("webUserDaoImplImpl")
public class WebUserDaoImpl extends MongoBaseDaoImpl<WebUser> implements WebUserDao {
	
	@Override
	public WebUser getWebUserByMobileNumber(String mobileNo) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("mobileNumber_s").is(mobileNo.trim()));
	    List<WebUser> users = getObjectByQuery(query, WebUser.class);
	    if(users == null || users.size() < 0){
	    	return null;
	    }
	    WebUser user = null;
		for(WebUser user1 : users){
			user = user1;
		}
		return user;
	}
	
	@Override
	public WebUser getWebUserByEmailId(String emailId) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("emailid_s").is(emailId.trim()));
	    List<WebUser> users = getObjectByQuery(query, WebUser.class);
	    if(users == null || users.size() < 0){
	    	return null;
	    }
	    WebUser user = null;
		for(WebUser user1 : users){
			user = user1;
		}
		return user;
	}
	
	@Override
	public WebUser validateMobileEmailId(String key) throws Exception {
		
		Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("mobileNumber_s").is(key.trim()),Criteria.where("emailid_s").is(key.trim()));
 
		Query query = new Query(criteria);
		
	    List<WebUser> users = getObjectByQuery(query, WebUser.class);
	    if(users == null || users.size() < 0){
	    	return null;
	    }
	    WebUser user = null;
		for(WebUser user1 : users){
			user = user1;
		}
		return user;
	}
	
}
