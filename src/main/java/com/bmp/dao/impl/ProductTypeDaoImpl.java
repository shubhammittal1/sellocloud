package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ProductTypeDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.ProductType;

@Repository
@Qualifier("productTypeDaoImpl")
public class ProductTypeDaoImpl extends MongoBaseDaoImpl<ProductType>
		implements ProductTypeDao{

}
