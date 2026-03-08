package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.facility.User;

public interface UserDao extends MongoBaseDao<User> {

	public List<String> getBranchByUser(String key);
	public User getUserByEmail(String email);
	public User getUserByMobile(String mobile);
	public User getUserByOtp(String otp);
}