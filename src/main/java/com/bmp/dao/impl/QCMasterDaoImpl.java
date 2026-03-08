package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.QCMasterDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.QCMaster;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("qcMasterDaoImpl")
public class QCMasterDaoImpl extends MongoBaseDaoImpl<QCMaster> implements QCMasterDao {

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
}
