package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BfilOrderDao;
import com.bmp.dao.RdspDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.BfilOrder;
import com.bmp.model.app.saleorder.RDSP;

@Repository
@Qualifier("rdspDaoImpl")
public class RdspDaoImpl extends MongoBaseDaoImpl<RDSP> implements RdspDao{

}
