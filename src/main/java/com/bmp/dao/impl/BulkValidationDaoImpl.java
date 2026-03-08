package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BulkValidationDao;
import com.bmp.dao.config.BaseDaoImpl;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.bulk.BulkValidation;

@Repository
@Qualifier("bulkValidationDaoImpl")
public class BulkValidationDaoImpl extends MongoBaseDaoImpl<BulkValidation>  implements BulkValidationDao{
	
}