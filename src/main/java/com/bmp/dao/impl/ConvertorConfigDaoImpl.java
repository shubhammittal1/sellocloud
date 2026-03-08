package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ConvertorConfigDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.convertor.ConvertorConfig;

@Repository
@Qualifier("convertorConfigDaoImpl")
public class ConvertorConfigDaoImpl extends MongoBaseDaoImpl<ConvertorConfig>  implements ConvertorConfigDao {

}
