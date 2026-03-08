package com.bmp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.UserDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.facility.Branch;
import com.bmp.model.app.facility.User;

@Repository
@Qualifier("userDaoImpl")
public class UserDaoImpl extends MongoBaseDaoImpl<User>  implements UserDao {

	@Override
	public List<String> getBranchByUser(String key) {
		List<String> branList = new ArrayList<String>();
		try{
			User user = getObjectById(key, User.class);
			
			for(Map.Entry<String, Branch> map : user.getBranchsMap().entrySet()){
				branList.add(map.getValue().getKey_s());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return branList;
	}

	@Override
	public User getUserByEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email.trim()));
		 List<User> users = getObjectByQuery(query, User.class);
		    if(users == null || users.size() < 0){
		    	return null;
		    }
		    User user = null;
			for(User user1 : users){
				user = user1;
			}
			return user;
		}
	@Override
	public User getUserByMobile(String mobile) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mobile").is(mobile.trim()));
		 List<User> users = getObjectByQuery(query, User.class);
		    if(users == null || users.size() < 0){
		    	return null;
		    }
		    User user = null;
			for(User user1 : users){
				user = user1;
			}
			return user;
		}

	@Override
	public User getUserByOtp(String otp) {
		Query query = new Query();
		query.addCriteria(Criteria.where("otp").is(otp.trim()));
		 List<User> users = getObjectByQuery(query, User.class);
		    if(users == null || users.size() < 0){
		    	return null;
		    }
		    User user = null;
			for(User user1 : users){
				user = user1;
			}
			return user;
	}
}