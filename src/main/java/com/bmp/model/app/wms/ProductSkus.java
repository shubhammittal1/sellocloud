package com.bmp.model.app.wms;

import java.util.Map;
import java.util.Objects;

import com.bmp.constant.InventoryNotReceivedReason;
import org.springframework.data.mongodb.core.index.Indexed;

public class ProductSkus {
    private String skuName;
    private String skuCode;
    private int qty;
    private double price;
    private double taxPercentage;
    private double amount;
    private int receivedQty ;
    private int rejectedQty ;
    private int missingQty;
    private String receivedRemarks;
    private Map<String,Integer> whLocationSkuQty;

    public ProductSkus() {
        super();
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(int receivedQty) {
        this.receivedQty = receivedQty;
    }

    public String getReceivedRemarks() {
        return receivedRemarks;
    }
    public void setReceivedRemarks(String receivedRemarks) {
        this.receivedRemarks = receivedRemarks;
    }
    public int getRejectedQty() {
        return rejectedQty;
    }

    public void setRejectedQty(int rejectQty) {
        this.rejectedQty = rejectQty;
    }

    public int getMissingQty() {
        return missingQty;
    }

    public void setMissingQty(int missingQty) {
        this.missingQty = missingQty;
    }

	public Map<String,Integer> getWhLocationSkuQty() {
		return whLocationSkuQty;
	}

	public void setWhLocationSkuQty(Map<String,Integer> whLocationSkuQty) {
		this.whLocationSkuQty = whLocationSkuQty;
	}
	
	@Override

	public boolean equals(Object o) {

	        if (this == o) return true;   // same reference

	        if (!(o instanceof ProductSkus)) return false; // different type

	        ProductSkus sku = (ProductSkus) o;

	        return Objects.equals(skuCode, sku.skuCode); // compare only name

	}
	 
	@Override

	public int hashCode() {

	    return Objects.hash(skuCode);

	}
	 

}
