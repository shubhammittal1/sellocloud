package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ReportMasterDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.report.ReportMaster;

@Repository
@Qualifier("reportMasterDaoImpl")
public class ReportMasterDaoImpl extends MongoBaseDaoImpl<ReportMaster> implements ReportMasterDao{


}
