package com.bmp.model.app.wms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.CatalogueSource;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="catalogue")
@AssignKey(assvalue=true)
public class Catalogue extends MongoBaseBean implements Serializable{
	
	  private static final long serialVersionUID = 1L;
	  
	  @Indexed
	  private String clientKey;
	  //private String skuMasterCode;
	  //private String parentProductKey;
	  //private String inventoryItemId;
	  @Indexed
	  private String categoryKey;
	  @Indexed
	  private String productName;
	  private String description;
	  @Indexed
	  private String subTitle;
	  //private String productKey;
	  @Indexed
	  private String productSku;
	  private String hsnCode;
	  private String eanCode;
	  private String upcCode;
	  private String isbnCode;
	  private Double productMrp;
	  private Double sellingPrice;
	  private Integer quantity;
	  private Double taxPercentage;
	  private String productImageUrls;
	  private Double length;
	  private Double breadth;
	  private Double height;
	  private Double weight;
	  @Indexed
	  private String brandName;
	  private String color;
	  private String size;
	  private String channelKey;
	  @Indexed
	  private CatalogueSource source;
	  private Map<String, Integer> combo; //skucode/qty
	  private boolean approved;

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public CatalogueSource getSource() {
		return source;
	}

	public void setSource(CatalogueSource source) {
		this.source = source;
	}

	public String getCategoryKey() {
		return categoryKey;
	}
	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSku() {
		return productSku;
	}
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public String getEanCode() {
		return eanCode;
	}
	public void setEanCode(String eanCode) {
		this.eanCode = eanCode;
	}
	public String getUpcCode() {
		return upcCode;
	}
	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}
	
	public String getIsbnCode() {
		return isbnCode;
	}
	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}
	public Double getProductMrp() {
		return productMrp;
	}
	public void setProductMrp(Double productMrp) {
		this.productMrp = productMrp;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(Double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	
	public String getProductImageUrls() {
		return productImageUrls;
	}
	public void setProductImageUrls(String productImageUrls) {
		this.productImageUrls = productImageUrls;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getBreadth() {
		return breadth;
	}
	public void setBreadth(Double breadth) {
		this.breadth = breadth;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Map<String, Integer> getCombo() {
		return combo;
	}
	public void setCombo(Map<String, Integer> combo) {
		this.combo = combo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getChannelKey() {
		return channelKey;
	}
	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
