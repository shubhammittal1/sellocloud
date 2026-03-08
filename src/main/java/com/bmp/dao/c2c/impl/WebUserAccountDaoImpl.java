package com.bmp.dao.c2c.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.c2c.WebUserAccountLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.c2c.WebUserAccountLog;

@Repository
@Qualifier("webUserAccountDaoImpl")
public class WebUserAccountDaoImpl extends MongoBaseDaoImpl<WebUserAccountLog> implements WebUserAccountLogsDao {

}
