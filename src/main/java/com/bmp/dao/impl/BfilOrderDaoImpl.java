package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BfilOrderDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.BfilOrder;

@Repository
@Qualifier("bfilOrderDaoImpl")
public class BfilOrderDaoImpl extends MongoBaseDaoImpl<BfilOrder> implements BfilOrderDao{

}
