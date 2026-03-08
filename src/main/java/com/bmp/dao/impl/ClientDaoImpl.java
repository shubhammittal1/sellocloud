package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.Client;

@Repository
@Qualifier("clientDaoImpl")
public class ClientDaoImpl extends MongoBaseDaoImpl<Client>  implements ClientDao {
	
	@Autowired 
	@Qualifier("mongoTemplateRead")
	private MongoTemplate mongoTemplateRead;
	
	
	@Override
	@Cacheable(value="client")
	public Client getEntityByLocationKey(String key) throws Exception {
		return getObjectById(key, Client.class);
	}
	
}
