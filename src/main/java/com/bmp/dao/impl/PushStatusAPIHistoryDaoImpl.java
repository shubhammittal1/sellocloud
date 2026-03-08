package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PushStatusAPIHistoryDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.PushStatusAPIHistory;

@Repository
@Qualifier("pushStatusAPIHistoryDaoImpl")
public class PushStatusAPIHistoryDaoImpl extends MongoBaseDaoImpl<PushStatusAPIHistory> implements PushStatusAPIHistoryDao {
	
	
}