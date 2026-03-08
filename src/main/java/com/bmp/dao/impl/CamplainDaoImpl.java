package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CamplainDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.Camplain;

@Repository
@Qualifier("camplainDaoImpl")
public class CamplainDaoImpl extends MongoBaseDaoImpl<Camplain>  implements CamplainDao{

}
