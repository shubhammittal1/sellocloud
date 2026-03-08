package com.bmp.dao.logs.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.logs.WmsOrderDispatchLogDao;
import com.bmp.model.app.logs.WmsOrderDispatchLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("wmsOrderDispatchLogDaoImpl")
public class WmsOrderDispatchLogDaoImpl extends MongoBaseDaoImpl<WmsOrderDispatchLog> implements WmsOrderDispatchLogDao {
}
