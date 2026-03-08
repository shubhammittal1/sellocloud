package com.bmp.bean.client;

import com.bmp.model.app.wms.Catalogue;
import java.util.List;

public class AmazonDataTableResponse {
    private List<Catalogue> products;
    private String nextToken;
    private int totalCount;

    public List<Catalogue> getProducts() {
        return products;
    }
    public void setProducts(List<Catalogue> products) {
        this.products = products;
    }
    public String getNextToken() {
        return nextToken;
    }
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
