package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.saleorder.MarketPlaceOrder;

public interface MarketPlaceOrderDao extends MongoBaseDao<MarketPlaceOrder>{
	MarketPlaceOrder getMarketPlaceOrderByOrderId(String clientKey,String OrderId);
}
