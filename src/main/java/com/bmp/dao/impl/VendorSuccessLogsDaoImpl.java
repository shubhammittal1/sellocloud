package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.VendorSuccessLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.api.VendorSuccessLogs;

@Repository
@Qualifier("vendorSuccessLogsDaoImpl")
public class VendorSuccessLogsDaoImpl extends MongoBaseDaoImpl<VendorSuccessLogs> implements VendorSuccessLogsDao {

}
