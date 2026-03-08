package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.report.ReportQueue;

public interface ReportQueueDao extends MongoBaseDao<ReportQueue>{
	public void updateReportProgessCount (String reportKey, int count);

}
