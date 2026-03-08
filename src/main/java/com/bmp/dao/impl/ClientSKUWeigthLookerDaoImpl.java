package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientSKUWeigthLookerDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientSKUWeigthLooker;

@Repository
@Qualifier("clientSKUWeigthLookerDaoImpl")
public class ClientSKUWeigthLookerDaoImpl extends MongoBaseDaoImpl<ClientSKUWeigthLooker>  implements ClientSKUWeigthLookerDao {

}
