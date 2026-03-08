package com.bmp.bean;

import java.util.List;

public class WooCommerceOrderWebhookBean {
    private Long id;
    private String status;
    private List<WooCommerceMetaDataBean> meta_data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<WooCommerceMetaDataBean> getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(List<WooCommerceMetaDataBean> meta_data) {
        this.meta_data = meta_data;
    }
}
