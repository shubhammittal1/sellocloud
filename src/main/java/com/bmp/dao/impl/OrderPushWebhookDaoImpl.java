package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bmp.dao.OrderPushWebhookDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.webhook.OrderPushWebhook;
@Repository
@Qualifier("orderPushWebhookDaoImpl")
@Component("com.bmp.dao.impl.OrderPushWebhookDaoImpl")
public class OrderPushWebhookDaoImpl extends MongoBaseDaoImpl<OrderPushWebhook> implements OrderPushWebhookDao{

}
