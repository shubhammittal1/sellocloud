package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.DeletedSaleOrdersDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.DeletedSaleOrders;

@Repository
@Qualifier("deletedSaleOrdersDaoImpl")
public class DeletedSaleOrdersDaoImpl extends MongoBaseDaoImpl<DeletedSaleOrders> implements DeletedSaleOrdersDao{

}
