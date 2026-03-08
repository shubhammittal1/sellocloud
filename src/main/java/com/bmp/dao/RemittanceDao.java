package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.saleorder.Remittance;

public interface RemittanceDao extends MongoBaseDao<Remittance>{
	List<String> getClients() throws Exception;
	

}
