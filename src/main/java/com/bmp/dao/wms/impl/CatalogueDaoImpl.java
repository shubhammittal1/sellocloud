package com.bmp.dao.wms.impl;

import java.util.*;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.ProductFilterType;
import com.bmp.constant.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.CatalogueDao;
import com.bmp.model.app.wms.Catalogue;

@Repository
@Qualifier("catalogueDaoImpl")
public class CatalogueDaoImpl extends MongoBaseDaoImpl<Catalogue> implements CatalogueDao{

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;

	@Autowired
	MongoTemplate mongoTemplate;

    @Override
    public boolean findBySkuCode(String productSku,String clientKey) {
        Query recordExist = new Query();
        recordExist.addCriteria(Criteria.where("productSku").is(productSku));
        recordExist.addCriteria(Criteria.where("clientKey").is(clientKey));
        return getMongoTemplate().exists(recordExist,Catalogue.class);
    }

	@Override
	public Catalogue getCatalogueBySkuCode(String productSku) {
		Query recordExist = new Query().addCriteria(Criteria.where("productSku").is(productSku));
		List<Catalogue> list = getObjectByQuery(recordExist, Catalogue.class);
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public String getSkuCodeByBarCode(String barCode) {
		String skuCode="";
		try {
			if (barCode != null && !barCode.isEmpty()) {
				Query query = new Query();
				query.addCriteria(Criteria.where("barCode").is(barCode));
				List<Catalogue> obj = getObjectByQuery(query, Catalogue.class);
				skuCode = obj.get(0).getProductSku();
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return skuCode;
	}

	@Override
	public List<Catalogue> getCatalogueByClient(String client) {
		Query query = new Query();
		query.addCriteria(Criteria.where("clientKey").is(client));
		if(sessionUserBean.getUser().getType().equals(UserType.CLIENT)){
			query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
		}
		List<Catalogue> catalogueList = getObjectByQuery(query, Catalogue.class);
		return catalogueList != null ? catalogueList : null;
	}

	@Override
	public List<Catalogue> getCatalogueData(Map<String, Object> filterMap) {
		Query query = new Query();

		if(filterMap.get("clientKey") != null && !filterMap.get("clientKey").toString().isEmpty()) {
			if(sessionUserBean.getUser().getType().equals(UserType.CLIENT)) {
				query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
			}else {
				query.addCriteria(Criteria.where("clientKey").is(filterMap.get("clientKey").toString()));
			}

			if (!filterMap.isEmpty()) {
				if (filterMap.get("filterType") != null) {
					ProductFilterType productFilterType = null;
					try {
						productFilterType = ProductFilterType.valueOf(filterMap.get("filterType").toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
                    if(!filterMap.get("search").toString().isEmpty()) {
                        if (ProductFilterType.SKU_CODE.equals(productFilterType)) {
                            query.addCriteria(Criteria.where("productSku").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE));
                        } else if (ProductFilterType.SKU_NAME.equals(productFilterType)) {
                            query.addCriteria(Criteria.where("productName").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE));
                        } else if (ProductFilterType.BAR_CODE.equals(productFilterType)) {
                            query.addCriteria(Criteria.where("barCode").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE));
                        } else {
                            query.addCriteria(new Criteria().orOperator(
                                    Criteria.where("productName").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE)
                                    , Criteria.where("productSku").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE)
							/*	, Criteria.where("barCode").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE)
								, Criteria.where("subTitle").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE)
								, Criteria.where("description").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE)
								, Criteria.where("brandName").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE)
								, Criteria.where("channelKey").regex(filterMap.get("search").toString(), GlobalConstant.CASE_SENSITIVE)*/
                            ));
                        }
                    }
				}
			}
			query.fields().include("id").include("productSku").include("productMrp").include("productName")
            .include("productImageUrls").include("quantity").include("barCode").include("sellingPrice")
            .include("taxPercentage");
			int limitRecords = 0, totalRecords = 0, skipRecords = 0;
			if (filterMap.get("limit") != null) {
				limitRecords = Integer.parseInt(filterMap.get("limit").toString());
				query.limit(limitRecords);
			}
			if (filterMap.get("total") != null) {
				totalRecords = Integer.parseInt(filterMap.get("total").toString());
			}

			if (filterMap.get("skip") != null) {
				skipRecords = Integer.parseInt(filterMap.get("skip").toString());
				query.skip(skipRecords);
			}

			if (totalRecords <= 0) {
				totalRecords = getObjectCount(query, Catalogue.class);
				filterMap.put("total", totalRecords);
			}
            query.addCriteria(Criteria.where("approved").is(true));
			List<Catalogue> catalogueList = getObjectByQuery(query, Catalogue.class);
			if (catalogueList != null && !catalogueList.isEmpty()) {
				return catalogueList;
			}
		}
		 return Collections.emptyList();
	}

	@Override
	public Integer getCatalogRecordsCount() {
		return getAllObjectCount(Catalogue.class);
	}

    @Override
    public Map<String,Integer> getAllSkuWithQty() {
        Map<String,Integer> allSku = new HashMap<>();
        List<Catalogue> allData = getAllObjects(Catalogue.class);
        if(allData != null){
            for(int i = 0 ; i < allData.size(); i++){
                allSku.put(allData.get(i).getProductSku(),allData.get(i).getQuantity());
            }
            return allSku;
        }
        return null;
    }

}
