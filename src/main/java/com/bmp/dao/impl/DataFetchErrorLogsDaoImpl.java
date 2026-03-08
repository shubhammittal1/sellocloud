package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.DataFetchErrorLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.DataFetchErrorLogs;

@Repository
@Qualifier("dataFetchErrorLogsDaoImpl")
public class DataFetchErrorLogsDaoImpl extends MongoBaseDaoImpl<DataFetchErrorLogs>  implements DataFetchErrorLogsDao{

}
