package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientCourierRateListTemplateDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientCourierRateListTemplate;

@Repository
@Qualifier("clientCourierRateListTemplateDaoImpl")
public class ClientCourierRateListTemplateDaoImpl extends MongoBaseDaoImpl<ClientCourierRateListTemplate>  implements ClientCourierRateListTemplateDao{

}
