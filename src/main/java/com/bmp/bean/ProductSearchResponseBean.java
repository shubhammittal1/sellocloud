package com.bmp.bean;

public class ProductSearchResponseBean {
	private String key_s;
    private String skuCode;
    private Double sellingPrice;
    private String skuImageUrls;
    private Integer totalQty;
    private String skuName;
    private String setWarehouseLocationKey;
    private Double taxPercent;
    
    
	public String getKey_s() {
		return key_s;
	}
	public void setKey_s(String key_s) {
		this.key_s = key_s;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getSkuImageUrls() {
		return skuImageUrls;
	}
	public void setSkuImageUrls(String skuImageUrls) {
		this.skuImageUrls = skuImageUrls;
	}
	
	public Integer getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSetWarehouseLocationKey() {
		return setWarehouseLocationKey;
	}
	public void setSetWarehouseLocationKey(String setWarehouseLocationKey) {
		this.setWarehouseLocationKey = setWarehouseLocationKey;
	}
    
    public Double getTaxPercent() {
        return taxPercent;
    }
    public void setTaxPercent(Double taxPercent) {
        this.taxPercent = taxPercent;
    }

}
