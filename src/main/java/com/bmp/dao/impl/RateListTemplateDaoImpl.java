package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RateListTemplateDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.RateListTemplate;

@Repository
@Qualifier("rateListTemplateDaoImpl")
public class RateListTemplateDaoImpl extends MongoBaseDaoImpl<RateListTemplate>  implements RateListTemplateDao{

}
