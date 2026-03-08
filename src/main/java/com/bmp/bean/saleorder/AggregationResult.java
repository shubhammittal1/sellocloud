package com.bmp.bean.saleorder;

import java.util.List;

public class AggregationResult {
        // The facet names should match those defined in the pipeline.
    private List<Object> dailyOrders;
    private List<Integer> dailyOrdersCount;
    private List<String> courierName;
    private List<Integer> courierCount;
    private String statesWithCountArray;
    private List<Object> statusName;
    private List<Integer> statusCount;

    public List<Object> getDailyOrders() {
        return dailyOrders;
    }

    public void setDailyOrders(List<Object> dailyOrders) {
        this.dailyOrders = dailyOrders;
    }

    public List<Integer> getDailyOrdersCount() {
        return dailyOrdersCount;
    }

    public void setDailyOrdersCount(List<Integer> dailyOrdersCount) {
        this.dailyOrdersCount = dailyOrdersCount;
    }

    public List<String> getCourierName() {
        return courierName;
    }

    public void setCourierName(List<String> courierName) {
        this.courierName = courierName;
    }

    public List<Integer> getCourierCount() {
        return courierCount;
    }

    public void setCourierCount(List<Integer> courierCount) {
        this.courierCount = courierCount;
    }

    public String getStatesWithCountArray() {
        return statesWithCountArray;
    }

    public void setStatesWithCountArray(String statesWithCountArray) {
        this.statesWithCountArray = statesWithCountArray;
    }

    public List<Object> getStatusName() {
        return statusName;
    }

    public void setStatusName(List<Object> statusName) {
        this.statusName = statusName;
    }

    public List<Integer> getStatusCount() {
        return statusCount;
    }

    public void setStatusCount(List<Integer> statusCount) {
        this.statusCount = statusCount;
    }
}
