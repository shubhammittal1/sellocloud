package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PageActionDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.facility.PageAction;

@Repository
@Qualifier("pageActionDaoImpl")
public class PageActionDaoImpl extends MongoBaseDaoImpl<PageAction> implements PageActionDao {
	
	
}