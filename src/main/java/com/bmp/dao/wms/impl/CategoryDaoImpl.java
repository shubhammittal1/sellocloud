package com.bmp.dao.wms.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.CategoryDao;
import com.bmp.model.app.wms.Category;

import java.util.List;

@Repository
@Qualifier("categoryDaoImpl")
public class CategoryDaoImpl extends MongoBaseDaoImpl<Category> implements CategoryDao{

    @Override
    public String getCategoryKeyByName(String categoryName) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(categoryName));
        List<Category> category = getObjectByQuery(query, Category.class);
        if(category != null && category.size() > 0) {
            return category.get(0).getKey_s();
        }
        return "";
    }
}
