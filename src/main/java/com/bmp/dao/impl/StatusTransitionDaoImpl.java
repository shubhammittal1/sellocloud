package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.StatusTransitionDao;
import com.bmp.dao.config.BaseDaoImpl;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.status.StatusTransition;

@Repository
@Qualifier("statusTransitionDaoImpl")
public class StatusTransitionDaoImpl extends MongoBaseDaoImpl<StatusTransition> implements StatusTransitionDao {
	
	
}