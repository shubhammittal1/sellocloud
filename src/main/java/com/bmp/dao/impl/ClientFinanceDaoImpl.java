package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientFinanceDao;
import com.bmp.dao.config.BaseDaoImpl;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientFinance;

@Repository
@Qualifier("clientFinanceDaoImpl")
public class ClientFinanceDaoImpl extends MongoBaseDaoImpl<ClientFinance> implements ClientFinanceDao {

}
