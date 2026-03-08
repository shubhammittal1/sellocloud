package com.bmp.dao.wms;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.Category;

public interface CategoryDao extends MongoBaseDao<Category>{

    String getCategoryKeyByName(String categoryName) throws Exception;

}
