package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.client.ClientAWBUnusedSeries;

public interface ClientAWBUnusedSeriesDao extends MongoBaseDao<ClientAWBUnusedSeries>{
	
	int getUnusedCodAwbSeries(String clientKey);
	int getUnusedPPAwbSeries(String clientKey);
	int getUnusedBothAwbSeries(String clientKey);

	
}
