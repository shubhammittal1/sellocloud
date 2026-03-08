package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BulkMasterDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.bulk.BulkMaster;

@Repository
@Qualifier("bulkMasterDaoImpl")
public class BulkMasterDaoImpl extends MongoBaseDaoImpl<BulkMaster>  implements BulkMasterDao{
	
}