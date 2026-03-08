package com.bmp.dao;

import com.bmp.constant.UserType;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.masters.AWBSeries;

public interface AWBSeriesDao extends MongoBaseDao<AWBSeries>{

	int getUnUsedCODAWBSeries(UserType type, String typeKey) throws Exception;
	int getUnUsedPPAWBSeries(UserType type, String typeKey) throws Exception;
	int getUnUsedBothAWBSeries(UserType type, String typeKey) throws Exception;
	//List<AWBSeries> getUnUsedCourierAwbnumber(String courierKey, String paymentType) throws Exception;
	int getUnUsedCourierAwbnumber(String courierKey, String paymentType) throws Exception;
	AWBSeries getAWBSeriesFromAwb(String awbSeries) throws Exception;
}
