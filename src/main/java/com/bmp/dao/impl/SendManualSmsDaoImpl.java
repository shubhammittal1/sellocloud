package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.SendManualSmsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.systemCalling.SendManualSms;

@Repository
@Qualifier("sendManualSmsDaoImpl")
public class SendManualSmsDaoImpl extends MongoBaseDaoImpl<SendManualSms> implements SendManualSmsDao {

}
