package com.bmp.dao.logs.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.logs.MarketplaceProductSuccessLogsDao;
import com.bmp.model.app.logs.MarketplaceProductSuccessLogs;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("marketplaceProductSuccessLogsDaoImpl")
public class MarketplaceProductSuccessLogsDaoImpl extends MongoBaseDaoImpl<MarketplaceProductSuccessLogs> implements MarketplaceProductSuccessLogsDao {
}
