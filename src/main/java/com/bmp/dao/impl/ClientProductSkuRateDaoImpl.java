package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientProductSkuRateDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientProductSkuRate;

@Repository
@Qualifier("clientProductSkuRateDaoImpl")
public class ClientProductSkuRateDaoImpl extends MongoBaseDaoImpl<ClientProductSkuRate> implements ClientProductSkuRateDao{

}
