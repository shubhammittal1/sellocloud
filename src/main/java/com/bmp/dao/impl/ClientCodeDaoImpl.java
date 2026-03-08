package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientCodeDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientCode;

@Repository
@Qualifier("clientCodeDaoImpl")
public class ClientCodeDaoImpl extends MongoBaseDaoImpl<ClientCode> implements ClientCodeDao{

}
