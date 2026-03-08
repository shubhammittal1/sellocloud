package com.bmp.dao.logs.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.logs.WmsUpdateInventoryLogDao;
import com.bmp.model.app.logs.WmsUpdateInventoryLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("wmsUpdateInventoryLogDaoImpl")
public class WmsUpdateInventoryLogDaoImpl extends MongoBaseDaoImpl<WmsUpdateInventoryLog> implements WmsUpdateInventoryLogDao {
}
