package com.bmp.model.app.logs;

import com.bmp.constant.CatalogueSource;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="wmsPendingTrackingPush")
@AssignKey(assvalue=true)
public class WmsPendingTrackingPush extends MongoBaseBean {
    private String orderKey;
    private String clientKey;
    private String marketPlaceKey;
    private CatalogueSource source;
    private Object response;
    private int attemptedCount = 1;

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getMarketPlaceKey() {
        return marketPlaceKey;
    }

    public void setMarketPlaceKey(String marketPlaceKey) {
        this.marketPlaceKey = marketPlaceKey;
    }

    public CatalogueSource getSource() {
        return source;
    }

    public void setSource(CatalogueSource source) {
        this.source = source;
    }

    public int getAttemptedCount() {
        return attemptedCount;
    }

    public void setAttemptedCount(int attemptedCount) {
        this.attemptedCount = attemptedCount;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
