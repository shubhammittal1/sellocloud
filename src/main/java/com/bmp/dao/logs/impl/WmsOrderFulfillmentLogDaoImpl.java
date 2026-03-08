package com.bmp.dao.logs.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.logs.WmsOrderFulfillmentLogDao;
import com.bmp.model.app.logs.WmsOrderFulfillmentLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("wmsOrderFulfillmentLogDaoImpl")
public class WmsOrderFulfillmentLogDaoImpl extends MongoBaseDaoImpl<WmsOrderFulfillmentLog> implements WmsOrderFulfillmentLogDao {
}
