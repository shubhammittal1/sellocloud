package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientCategoryMappingDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientCategoryMapping;

@Repository
@Qualifier("clientCategoryMappingDao")
public class ClientCategoryMappingDaoImpl extends MongoBaseDaoImpl<ClientCategoryMapping> implements ClientCategoryMappingDao {
	
	
}