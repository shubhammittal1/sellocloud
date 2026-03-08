package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ComplaintBoxDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ComplaintBox;

@Repository
@Qualifier("complaintBoxDaoImpl")
public class ComplaintBoxDaoImpl extends MongoBaseDaoImpl<ComplaintBox> implements ComplaintBoxDao {
	
	
}