package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.TrackingWebhookDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.webhook.TrackingWebhook;

@Repository
@Qualifier("trackingWebhookDaoImpl")
public class TrackingWebhookDaoImpl extends MongoBaseDaoImpl<TrackingWebhook> implements TrackingWebhookDao{

}
