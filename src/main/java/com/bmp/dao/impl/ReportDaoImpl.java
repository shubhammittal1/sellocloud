package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ReportDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.report.Report;

@Repository
@Qualifier("reportDaoImpl")
public class ReportDaoImpl extends MongoBaseDaoImpl<Report> implements ReportDao {

}
