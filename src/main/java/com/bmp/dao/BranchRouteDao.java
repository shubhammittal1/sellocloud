package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.facility.BranchRoute;

public interface BranchRouteDao extends MongoBaseDao<BranchRoute>{
	
	List<BranchRoute> routeListByBranchName(String branchName) throws Exception;
}
