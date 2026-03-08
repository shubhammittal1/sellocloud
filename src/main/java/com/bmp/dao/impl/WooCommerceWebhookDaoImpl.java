package com.bmp.dao.impl;

import com.bmp.bean.wms.WooCommerceWebhook;
import com.bmp.dao.WooCommerceWebhookDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("wooCommerceWebhookDaoImpl")
public class WooCommerceWebhookDaoImpl extends MongoBaseDaoImpl<WooCommerceWebhook> implements WooCommerceWebhookDao {
    @Override
    public WooCommerceWebhook findByUrlAndTopic(String url, String topic) {
        Query query = new Query(Criteria.where("storeUrl").is(url)).addCriteria(Criteria.where("topic").is(topic));
        return getObjectByQuery(query, WooCommerceWebhook.class) != null && getObjectByQuery(query, WooCommerceWebhook.class).get(0) != null ? getObjectByQuery(query, WooCommerceWebhook.class).get(0) : null;
    }
}
