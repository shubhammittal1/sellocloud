package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BulkHeaderDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.bulk.BulkHeader;

@Repository
@Qualifier("bulkHeaderDaoImpl")
public class BulkHeaderDaoImpl extends MongoBaseDaoImpl<BulkHeader>  implements BulkHeaderDao{
	
}