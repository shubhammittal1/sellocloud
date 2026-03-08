package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientAWBUsedSeriesDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientAWBUsedSeries;

@Repository
@Qualifier("ClientAWBUsedSeriesDaoImpl")
public class ClientAWBUsedSeriesDaoImpl extends MongoBaseDaoImpl<ClientAWBUsedSeries> implements ClientAWBUsedSeriesDao {
	
	
}