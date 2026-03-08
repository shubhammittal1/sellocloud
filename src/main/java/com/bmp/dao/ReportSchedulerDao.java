package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.report.ReportScheduler;

public interface ReportSchedulerDao extends MongoBaseDao<ReportScheduler>{
	public void updateReportProgessCount (String reportKey, int count);

}
