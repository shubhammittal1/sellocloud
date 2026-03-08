package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.StagingSaleOrderDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.StagingSaleOrder;

@Repository
@Qualifier("stagingSaleOrderDaoImpl")
public class StagingSaleOrderDaoImpl extends MongoBaseDaoImpl<StagingSaleOrder> implements StagingSaleOrderDao{

}
