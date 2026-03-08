package com.bmp.model.app.wms;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="orderIdGenerator")
@AssignKey(assvalue=false)
public class OrderIdGenerator extends MongoBaseBean {
    private String orderIdPrefix;
    private long orderSequenceNo;

    public long getOrderSequenceNo() {
        return orderSequenceNo;
    }

    public void setOrderSequenceNo(long orderSequenceNo) {
        this.orderSequenceNo = orderSequenceNo;
    }

    public String getOrderIdPrefix() {
        return orderIdPrefix;
    }

    public void setOrderIdPrefix(String orderIdPrefix) {
        this.orderIdPrefix = orderIdPrefix;
    }
}
