package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.GreetingSmsTemplateDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.systemCalling.GreetingSmsTemplate;

@Repository
@Qualifier("greetingSmsTemplateDaoImpl")
public class GreetingSmsTemplateDaoImpl extends MongoBaseDaoImpl<GreetingSmsTemplate> implements GreetingSmsTemplateDao{

}
