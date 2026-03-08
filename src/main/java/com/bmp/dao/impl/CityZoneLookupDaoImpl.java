package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CityZoneLookupDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.CityZoneLookup;
@Repository
@Qualifier("cityZoneLookupDaoImpl")
public class CityZoneLookupDaoImpl extends MongoBaseDaoImpl<CityZoneLookup> implements CityZoneLookupDao{

}
