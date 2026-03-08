package com.bmp.bean.order;

public class ProductBean {

    private String key_s;
    private String productSku;
    private Double productPrice;
    private String productImageUrls;
    private String barCode;
    private Integer quantity;
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getKey_s() {
        return key_s;
    }

    public void setKey_s(String key_s) {
        this.key_s = key_s;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageUrls() {
        return productImageUrls;
    }

    public void setProductImageUrls(String productImageUrls) {
        this.productImageUrls = productImageUrls;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
