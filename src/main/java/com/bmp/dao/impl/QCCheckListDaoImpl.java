package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.QCCheckListDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.QCCheckList;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("qcCheckListDaoImpl")
public class QCCheckListDaoImpl extends MongoBaseDaoImpl<QCCheckList> implements QCCheckListDao {

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
}
