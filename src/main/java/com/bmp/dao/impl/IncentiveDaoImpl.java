package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.IncentiveDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.incentive.Incentive;

@Repository
@Qualifier("incentiveDaoImpl")
public class IncentiveDaoImpl extends MongoBaseDaoImpl<Incentive> implements IncentiveDao{

}
