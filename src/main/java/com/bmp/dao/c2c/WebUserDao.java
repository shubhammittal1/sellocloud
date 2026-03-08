package com.bmp.dao.c2c;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.c2c.WebUser;

public interface WebUserDao extends MongoBaseDao<WebUser> {

	WebUser getWebUserByMobileNumber(String mobileNo) throws Exception;
	WebUser getWebUserByEmailId(String emailId) throws Exception;
	WebUser validateMobileEmailId(String key) throws Exception;

}
