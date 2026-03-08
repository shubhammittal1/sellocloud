package com.bmp.dao.wms.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.WmsPendingOrderStatusPushDao;
import com.bmp.model.app.wms.WmsPendingOrderStatusPush;
@Repository
@Qualifier("wmsPendingInventoryPushDaoImpl")
public class WmsPendingOrderStatusPushDaoImpl extends MongoBaseDaoImpl<WmsPendingOrderStatusPush> implements WmsPendingOrderStatusPushDao{

}
