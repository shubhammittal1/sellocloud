package com.bmp.bean.wms;

import com.bmp.dao.config.AssignKey;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.base.BaseBean;
import com.bmp.model.base.MongoBaseBean;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="WooCommerceWebhook")
@AssignKey(assvalue=false)
public class WooCommerceWebhook extends MongoBaseBean {
    private String name;
    private String topic;
    private String deliveryUrl;
    private boolean active;
    private String secret;
    private String storeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDeliveryUrl() {
        return deliveryUrl;
    }

    public void setDeliveryUrl(String deliveryUrl) {
        this.deliveryUrl = deliveryUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }
}
