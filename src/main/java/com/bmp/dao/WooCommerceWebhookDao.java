package com.bmp.dao;


import com.bmp.bean.wms.WooCommerceWebhook;
import com.bmp.dao.config.MongoBaseDao;

public interface WooCommerceWebhookDao extends MongoBaseDao<WooCommerceWebhook> {
    WooCommerceWebhook findByUrlAndTopic(String url, String topic);
}
