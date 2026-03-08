package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.VendorOrderReadyToPushDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.api.VendorOrderReadyToPush;

@Repository
@Qualifier("vendorOrderReadyToPushDaoImpl")
public class VendorOrderReadyToPushDaoImpl extends MongoBaseDaoImpl<VendorOrderReadyToPush> implements VendorOrderReadyToPushDao {

}
