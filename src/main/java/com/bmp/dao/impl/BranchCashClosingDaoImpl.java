package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.dao.BranchCashClosingDao;
import com.bmp.dao.StatusMasterDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.drs.BranchCashClosing;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.utility.logger.AsyncLogger;

@Repository
@Qualifier("branchCashClosingDaoImpl")
public class BranchCashClosingDaoImpl extends MongoBaseDaoImpl<BranchCashClosing> implements BranchCashClosingDao {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;
	
	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired	
	@Qualifier("statusMasterDaoImpl")
	private StatusMasterDao statusMasterDao;

	
	
}
