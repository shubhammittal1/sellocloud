package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.OrderSkuScanDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.OrderSkuScan;

@Repository
@Qualifier("orderSkuScanDaoImpl")
public class OrderSkuScanDaoImpl extends MongoBaseDaoImpl<OrderSkuScan> implements OrderSkuScanDao{
	
}
