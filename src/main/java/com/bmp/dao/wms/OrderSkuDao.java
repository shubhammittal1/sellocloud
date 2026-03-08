package com.bmp.dao.wms;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.OrderSku;

public interface OrderSkuDao extends MongoBaseDao<OrderSku>{
	OrderSku getOrderSkuByOrderIdAndSkuCode(String orderKey,String skuCode);
	List<String>getskuListByOrderSkuKey(List<String>skuKeyList);

}
