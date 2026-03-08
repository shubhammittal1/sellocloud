package com.bmp.model.app.wms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.constant.CatalogueSource;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import antlr.collections.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="marketPlaceSkuMapping")
@AssignKey(assvalue=true)
public class MarketPlaceSkuMapping extends MongoBaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String skuCode;
	private String skuName;
	private Map<CatalogueSource,MarketPlaceSkuMappingBean> sourceSkuMap;// key= marketplace value=marketplace
	
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public Map<CatalogueSource, MarketPlaceSkuMappingBean> getSourceSkuMap() {
		return sourceSkuMap;
	}
	public void setSourceSkuMap(Map<CatalogueSource, MarketPlaceSkuMappingBean> sourceSkuMap) {
		this.sourceSkuMap = sourceSkuMap;
	}
	
	
	
}
