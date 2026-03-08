package com.bmp.model.app.wms;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.CatalogueSource;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="wmsPendingInventoryPush")
@AssignKey(assvalue=true)
public class WmsPendingInventoryPush extends MongoBaseBean{
	private String skuInventoryKey;
	private String skuCode;
    private String clientKey;
    private String marketPlaceKey;
    private CatalogueSource source;
    private int attemptedCount;
	
    public String getSkuInventoryKey() {
		return skuInventoryKey;
	}
	public void setSkuInventoryKey(String skuInventoryKey) {
		this.skuInventoryKey = skuInventoryKey;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getMarketPlaceKey() {
		return marketPlaceKey;
	}
	public void setMarketPlaceKey(String marketPlaceKey) {
		this.marketPlaceKey = marketPlaceKey;
	}
	public CatalogueSource getSource() {
		return source;
	}
	public void setSource(CatalogueSource source) {
		this.source = source;
	}
	public int getAttemptedCount() {
		return attemptedCount;
	}
	public void setAttemptedCount(int attemptedCount) {
		this.attemptedCount = attemptedCount;
	}
	
}
