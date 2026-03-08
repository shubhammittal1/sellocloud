package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.VendorStatusMappingDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.api.VendorStatusMappingBean;

@Repository
@Qualifier("vendorStatusMappingDaoImpl")
public class VendorStatusMappingDaoImpl extends MongoBaseDaoImpl<VendorStatusMappingBean>  implements VendorStatusMappingDao{

}
