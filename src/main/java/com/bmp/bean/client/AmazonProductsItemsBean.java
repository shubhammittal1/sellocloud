package com.bmp.bean.client;

import java.util.List;

public class AmazonProductsItemsBean {

    private String asin;
    private List<AmazonProductsSummaryBean> summaries;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public List<AmazonProductsSummaryBean> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<AmazonProductsSummaryBean> summaries) {
        this.summaries = summaries;
    }
}
