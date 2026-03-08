package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.client.ClientNew;

public interface ClientNewDao  extends MongoBaseDao<ClientNew>{
	public String getClientActiveCourierPriority(String clientKey)  throws Exception;
}
