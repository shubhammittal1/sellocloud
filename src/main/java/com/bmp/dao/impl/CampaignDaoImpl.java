package com.bmp.dao.impl;

import com.bmp.model.app.systemCalling.Campaign;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.CampaignDao;
import com.bmp.dao.config.MongoBaseDaoImpl;

@Repository
@Qualifier("campaignDaoImpl")
public class CampaignDaoImpl extends MongoBaseDaoImpl<Campaign> implements CampaignDao{

}
