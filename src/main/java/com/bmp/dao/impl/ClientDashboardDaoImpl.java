package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientDashboardDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientDashboard;

@Repository
@Qualifier("clientDashboardDaoImpl")
public class ClientDashboardDaoImpl extends MongoBaseDaoImpl<ClientDashboard>  implements ClientDashboardDao {

}
