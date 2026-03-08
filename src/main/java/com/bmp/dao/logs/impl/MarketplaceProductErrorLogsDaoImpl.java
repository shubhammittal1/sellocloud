package com.bmp.dao.logs.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.logs.MarketplaceProductErrorLogsDao;
import com.bmp.model.app.logs.MarketplaceProductErrorLogs;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("marketplaceProductErrorLogsDaoImpl")
public class MarketplaceProductErrorLogsDaoImpl extends MongoBaseDaoImpl<MarketplaceProductErrorLogs> implements MarketplaceProductErrorLogsDao {
}
