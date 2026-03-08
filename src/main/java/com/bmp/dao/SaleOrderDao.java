package com.bmp.dao;

import java.util.List;

import com.bmp.bean.saleorder.AggregationResult;
import com.bmp.constant.OrderSource;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.saleorder.SaleOrder;

public interface SaleOrderDao extends MongoBaseDao<SaleOrder> {

	int total3PlShipmentOnBtranch(String branchKey, String courierKey, String satauskay) throws Exception;
	List<SaleOrder> total3PlShipmentOnUser(List<String> userBranchKeys,String s) throws Exception;
	List<String> getAllSaleorderNumber(String courierAwb) throws Exception;
	List<SaleOrder> getSaleOrdersByOrderNoAndSource(String saleOrderNumber, OrderSource orderSource)  throws Exception;
	AggregationResult getSaleOrderAggregations(boolean flag, String user, Long customDaysData, Integer val);
}
