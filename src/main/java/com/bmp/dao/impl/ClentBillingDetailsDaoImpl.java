package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClentBillingDetailsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClentBillingDetails;

@Repository
@Qualifier("clentBillingDetailsDaoImpl")
public class ClentBillingDetailsDaoImpl extends MongoBaseDaoImpl<ClentBillingDetails> implements ClentBillingDetailsDao{

}
