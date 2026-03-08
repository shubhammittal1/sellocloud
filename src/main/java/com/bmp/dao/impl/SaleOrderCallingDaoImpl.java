package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.SaleOrderCallingDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.SaleOrderCalling;

@Repository
@Qualifier("saleOrderCallingDaoImpl")
public class SaleOrderCallingDaoImpl extends MongoBaseDaoImpl<SaleOrderCalling>  implements SaleOrderCallingDao{

}
