package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PushPacketStatusHistoryDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.PushPacketStatusHistory;

@Repository
@Qualifier("pushPacketStatusHistoryDaoImpl")
public class PushPacketStatusHistoryDaoImpl extends MongoBaseDaoImpl<PushPacketStatusHistory> implements PushPacketStatusHistoryDao {
	
	
}