package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CourierRateListDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.CourierRateList;

@Repository
@Qualifier("courierRateListDaoImpl")
public class CourierRateListDaoImpl extends MongoBaseDaoImpl<CourierRateList>  implements CourierRateListDao{

}
