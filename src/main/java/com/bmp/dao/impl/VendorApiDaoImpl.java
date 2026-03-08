package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.VendorApiDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.api.VendorApiBean;

@Repository
@Qualifier("vendorApiDaoImpl")
public class VendorApiDaoImpl extends MongoBaseDaoImpl<VendorApiBean> implements VendorApiDao{

}
