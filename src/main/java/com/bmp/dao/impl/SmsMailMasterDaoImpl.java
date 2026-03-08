package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.SmsMailMasterDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.utility.SmsMailMaster;

@Repository
@Qualifier("smsMailMasterDaoImpl")
public class SmsMailMasterDaoImpl extends MongoBaseDaoImpl<SmsMailMaster> implements SmsMailMasterDao {

}
