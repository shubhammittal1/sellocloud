package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.BaseDao;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.drs.Drs;

public interface DrsDao extends MongoBaseDao<Drs>{
	
	List<Drs> getDrsByBranchName(String branchKey) throws Exception;
	List<Drs> getDrsByUserKey(String userKey,String currentStatus) throws Exception;

}
