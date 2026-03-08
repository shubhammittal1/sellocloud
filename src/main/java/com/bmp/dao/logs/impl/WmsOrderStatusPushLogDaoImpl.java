package com.bmp.dao.logs.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.logs.WmsOrderStatusPushLogDao;
import com.bmp.model.app.logs.WmsOrderStatusPushLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("wmsOrderStatusPushLogDaoImpl")
public class WmsOrderStatusPushLogDaoImpl extends MongoBaseDaoImpl<WmsOrderStatusPushLog> implements WmsOrderStatusPushLogDao {
}
