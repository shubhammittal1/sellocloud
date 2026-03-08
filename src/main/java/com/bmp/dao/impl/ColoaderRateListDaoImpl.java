package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ColoaderRateListDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.coloader.ColoaderRateList;

@Repository
@Qualifier("coloaderRateListDaoImpl")
public class ColoaderRateListDaoImpl extends MongoBaseDaoImpl<ColoaderRateList>  implements ColoaderRateListDao{

}
