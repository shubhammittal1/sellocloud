package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.coloader.Coloader;
import com.bmp.model.app.masters.PincodeGroup;

public interface ColoaderDao extends MongoBaseDao<Coloader> {
	
	List<Coloader> getColoader(List<PincodeGroup> groups) throws Exception;
	List<Coloader> getColoader(List<PincodeGroup> sourceBranchpincodeGroupList, List<PincodeGroup> destinationBranchpincodeGroupList) throws Exception;
}

