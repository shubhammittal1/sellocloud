package com.bmp.dao;

import java.util.List;

import com.bmp.constant.PaymentType;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.courier.CourierAWBUnusedSeries;

public interface CourierAWBUnusedSeriesDao extends MongoBaseDao<CourierAWBUnusedSeries>{

	int getUnusedCodAwbSeries(String entityKey_s);
	int getUnusedPPAwbSeries(String entityKey_s);
	int getUnusedBothAwbSeries(String clientKey);
	List<String> getUnUsedCourierAwbnumber(String courierKey, PaymentType paymentType) throws Exception;

	
}
