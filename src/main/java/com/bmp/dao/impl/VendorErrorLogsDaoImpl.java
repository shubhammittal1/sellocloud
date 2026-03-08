package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.VendorErrorLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.api.VendorErrorLogs;

@Repository
@Qualifier("vendorErrorLogsDaoImpl")
public class VendorErrorLogsDaoImpl extends MongoBaseDaoImpl<VendorErrorLogs> implements VendorErrorLogsDao {

}
