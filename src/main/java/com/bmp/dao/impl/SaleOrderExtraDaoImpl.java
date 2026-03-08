package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.SaleOrderExtraDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.SaleOrderExtra;

@Repository
@Qualifier("saleOrderExtraDaoImpl")
public class SaleOrderExtraDaoImpl extends MongoBaseDaoImpl<SaleOrderExtra>  implements SaleOrderExtraDao{

}
