package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientServiceablePincodeDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientServiceablePincode;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("ClientServiceablePincodeDaoImpl")
public class ClientServiceablePincodeDaoImpl extends MongoBaseDaoImpl<ClientServiceablePincode> implements ClientServiceablePincodeDao {

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	


}
