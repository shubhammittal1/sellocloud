package com.bmp.dao.wms;

import com.bmp.constant.CatalogueSource;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.MarketPlaceSkuMapping;

public interface MarketplaceSkuMappingDao extends MongoBaseDao<MarketPlaceSkuMapping>{
	MarketPlaceSkuMapping getSkuMappingBySkuCode(String skuCode);
	MarketPlaceSkuMapping getSkuMappingBySourceAndSourceSku(CatalogueSource source,String sourceSku);

}
