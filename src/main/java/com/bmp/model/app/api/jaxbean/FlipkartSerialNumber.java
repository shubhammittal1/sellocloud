package com.bmp.model.app.api.jaxbean;

import java.util.List;

public class FlipkartSerialNumber {
    private String orderItemId;
    private List<List<String>> serialNumbers;

    public String getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }
    public List<List<String>> getSerialNumbers() {
        return serialNumbers;
    }

    public void setSerialNumbers(List<List<String>> serialNumbers) {
        this.serialNumbers = serialNumbers;
    }
}
