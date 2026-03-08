package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientRateListDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientRateList;

@Repository
@Qualifier("clientRateListDaoImpl")
public class ClientRateListDaoImpl extends MongoBaseDaoImpl<ClientRateList>  implements ClientRateListDao {

}
