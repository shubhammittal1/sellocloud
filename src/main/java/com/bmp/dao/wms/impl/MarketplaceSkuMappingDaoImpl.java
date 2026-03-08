package com.bmp.dao.wms.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.constant.CatalogueSource;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.MarketplaceSkuMappingDao;
import com.bmp.model.app.wms.MarketPlaceSkuMapping;
@Repository
@Qualifier("marketplaceSkuMappingDaoImpl")
public class MarketplaceSkuMappingDaoImpl extends MongoBaseDaoImpl<MarketPlaceSkuMapping> implements MarketplaceSkuMappingDao{

	@Override
	public MarketPlaceSkuMapping getSkuMappingBySkuCode(String skuCode) {
		Query recordExist = new Query().addCriteria(Criteria.where("skuCode").is(skuCode));
		List<MarketPlaceSkuMapping> list = getObjectByQuery(recordExist, MarketPlaceSkuMapping.class);
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public MarketPlaceSkuMapping getSkuMappingBySourceAndSourceSku(CatalogueSource source, String sourceSku) {
		
		 if (source == null || sourceSku == null || sourceSku.trim().length() == 0) {
		        return null;
		    }
		    String fieldPath = "sourceSkuMap." + source.name() + ".skuCode";

		    Query query = new Query();
		    query.addCriteria(Criteria.where(fieldPath).is(sourceSku));
		    
		    List<MarketPlaceSkuMapping> list = getObjectByQuery(query, MarketPlaceSkuMapping.class);
			return (list != null && list.size() > 0) ? list.get(0) : null;
	}

}
