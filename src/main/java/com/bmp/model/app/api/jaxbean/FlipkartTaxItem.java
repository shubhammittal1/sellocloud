package com.bmp.model.app.api.jaxbean;

public class FlipkartTaxItem {
    private String orderItemId;
    private Double purchasePrice;
    private Double taxRate;
    private Integer quantity;

    public FlipkartTaxItem() {
        super();
    }
    public String getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }
    public Double getPurchasePrice() {
        return purchasePrice;
    }
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public Double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
