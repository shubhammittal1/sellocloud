package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientBillingDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientBilling;

@Repository
@Qualifier("clientBillingDaoImpl")
public class ClientBillingDaoImpl extends MongoBaseDaoImpl<ClientBilling>  implements ClientBillingDao{

}
