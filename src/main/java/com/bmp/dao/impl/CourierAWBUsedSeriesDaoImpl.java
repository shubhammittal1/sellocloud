package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CourierAWBUsedSeriesDao;
import com.bmp.dao.config.BaseDaoImpl;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.CourierAWBUsedSeries;

@Repository
@Qualifier("courierAWBUsedSeriesDaoImpl")
public class CourierAWBUsedSeriesDaoImpl extends MongoBaseDaoImpl<CourierAWBUsedSeries> implements CourierAWBUsedSeriesDao {
	
	
}