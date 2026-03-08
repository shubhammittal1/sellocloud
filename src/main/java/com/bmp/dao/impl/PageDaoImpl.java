package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PageDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.facility.Page;

@Repository
@Qualifier("pageDaoImpl")
public class PageDaoImpl extends MongoBaseDaoImpl<Page> implements PageDao {
	
	
}