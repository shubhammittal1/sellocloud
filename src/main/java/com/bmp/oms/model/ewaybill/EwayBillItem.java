package com.bmp.oms.model.ewaybill;

public class EwayBillItem {
    private int itemNo;
    private int productId;
    private String productName;
    private String productDesc;
    private long hsnCode;
    private double quantity;
    private String qtyUnit;
    private double cgstRate;
    private double sgstRate;
    private double igstRate;
    private double cessRate;
    private double cessNonAdvol;
    private double taxableAmount;

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public long getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(long hsnCode) {
        this.hsnCode = hsnCode;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getQtyUnit() {
        return qtyUnit;
    }

    public void setQtyUnit(String qtyUnit) {
        this.qtyUnit = qtyUnit;
    }

    public double getCgstRate() {
        return cgstRate;
    }

    public void setCgstRate(double cgstRate) {
        this.cgstRate = cgstRate;
    }

    public double getSgstRate() {
        return sgstRate;
    }

    public void setSgstRate(double sgstRate) {
        this.sgstRate = sgstRate;
    }

    public double getIgstRate() {
        return igstRate;
    }

    public void setIgstRate(double igstRate) {
        this.igstRate = igstRate;
    }

    public double getCessRate() {
        return cessRate;
    }

    public void setCessRate(double cessRate) {
        this.cessRate = cessRate;
    }

    public double getCessNonAdvol() {
        return cessNonAdvol;
    }

    public void setCessNonAdvol(double cessNonAdvol) {
        this.cessNonAdvol = cessNonAdvol;
    }

    public double getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(double taxableAmount) {
        this.taxableAmount = taxableAmount;
    }
}
