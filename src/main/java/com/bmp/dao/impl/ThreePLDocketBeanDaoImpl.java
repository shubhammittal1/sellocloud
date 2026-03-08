package com.bmp.dao.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ThreePLDocketBeanDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.threePL.ThreePLDocketBean;

@Repository
@Qualifier("threePLDocketBeanDaoImpl")
public class ThreePLDocketBeanDaoImpl extends MongoBaseDaoImpl<ThreePLDocketBean>  implements ThreePLDocketBeanDao{

}
