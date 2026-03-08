package com.bmp.dao.wms;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.OrderPackaging;

public interface OrderPackagingDao extends MongoBaseDao<OrderPackaging>{
	List<OrderPackaging> findByOrderKey(String key);
	List<OrderPackaging> findOrderPackagingByOrderIdAndStatus(String key, String statusKey);
}
