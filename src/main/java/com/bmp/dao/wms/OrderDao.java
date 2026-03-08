package com.bmp.dao.wms;

import com.bmp.constant.OrderSource;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.Order;

public interface OrderDao extends MongoBaseDao<Order>{
	Order getOrderByOrderId(String OrderId);

    boolean isApiOrderExist(String clientKey, OrderSource source, String shopCode, String orderId);
}
