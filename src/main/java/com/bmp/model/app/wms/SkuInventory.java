package com.bmp.model.app.wms;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="skuInventory")
@AssignKey(assvalue=true)
public class SkuInventory extends MongoBaseBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Indexed
    private String skuCode;
    @Indexed
    private String warehouseKey;
    private String skuName;
    private String skuImageUrls;
    private int goodQty;
    private int badQty;
    private int totalQty;
    @Indexed
    private String clientKey;
    @Indexed
    private String warehouseLocationKey;

    public SkuInventory(){super();}

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public int getGoodQty() {
        return goodQty;
    }

    public void setGoodQty(int goodQty) {
        this.goodQty = goodQty;
    }

    public int getBadQty() {
        return badQty;
    }

    public void setBadQty(int badQty) {
        this.badQty = badQty;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuImageUrls() {
		return skuImageUrls;
	}

	public void setSkuImageUrls(String skuImageUrls) {
		this.skuImageUrls = skuImageUrls;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getWarehouseKey() {
		return warehouseKey;
	}

	public void setWarehouseKey(String warehouseKey) {
		this.warehouseKey = warehouseKey;
	}

	public String getWarehouseLocationKey() {
		return warehouseLocationKey;
	}

	public void setWarehouseLocationKey(String warehouseLocationKey) {
		this.warehouseLocationKey = warehouseLocationKey;
	}
	
    
}
