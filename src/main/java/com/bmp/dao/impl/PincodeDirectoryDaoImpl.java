package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PincodeDirectoryDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.PincodeDirectory;

@Repository
@Qualifier("pincodeDirectoryDaoImpl")
public class PincodeDirectoryDaoImpl extends MongoBaseDaoImpl<PincodeDirectory>
		implements PincodeDirectoryDao{

}
