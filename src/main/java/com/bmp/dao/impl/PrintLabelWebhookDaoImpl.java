package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PrintLabelWebhookDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.webhook.PrintLabelWebhook;
@Repository
@Qualifier("printLabelWebhookDaoImpl")
public class PrintLabelWebhookDaoImpl extends MongoBaseDaoImpl<PrintLabelWebhook> implements PrintLabelWebhookDao{

}
