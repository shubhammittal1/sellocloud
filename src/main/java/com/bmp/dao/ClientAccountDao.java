package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.client.ClientAccount;

public interface ClientAccountDao extends MongoBaseDao<ClientAccount>{
	Double getAccountBalance (String clientKey);
}
