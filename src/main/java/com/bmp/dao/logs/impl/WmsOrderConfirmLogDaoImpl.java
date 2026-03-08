package com.bmp.dao.logs.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.logs.WmsOrderConfirmLogDao;
import com.bmp.model.app.logs.WmsOrderConfirmLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("wmsOrderConfirmLogDaoImpl")
public class WmsOrderConfirmLogDaoImpl extends MongoBaseDaoImpl<WmsOrderConfirmLog> implements WmsOrderConfirmLogDao {
}
