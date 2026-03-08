package com.bmp.dao.logs.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.logs.WmsPendingTrackingPushDao;
import com.bmp.model.app.logs.WmsPendingTrackingPush;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("wmsPendingTrackingPushDaoImpl")
public class WmsPendingTrackingPushDaoImpl extends MongoBaseDaoImpl<WmsPendingTrackingPush> implements WmsPendingTrackingPushDao {
}
