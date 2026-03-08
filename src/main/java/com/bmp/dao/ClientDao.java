package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.client.Client;

public interface ClientDao extends MongoBaseDao<Client>{
	Client getEntityByLocationKey(String key) throws Exception;
	

}
