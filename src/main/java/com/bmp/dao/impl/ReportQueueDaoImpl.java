package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ReportQueueDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.report.ReportQueue;

@Repository
@Qualifier("reportQueueDaoImpl")
public class ReportQueueDaoImpl extends MongoBaseDaoImpl<ReportQueue> implements ReportQueueDao{
	@Override
	public void updateReportProgessCount (String reportKey, int count) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(reportKey));
			Update update = new Update(); 
			update.set("progressCount", count);
			updateMultiple(query, update, ReportQueue.class);
		}catch(Exception e) {}
	}

}
