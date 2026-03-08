package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BillingOtherChargesDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.BillingOtherCharges;

@Repository
@Qualifier("billingOtherChargesDaoImpl")
public class BillingOtherChargesDaoImpl extends MongoBaseDaoImpl<BillingOtherCharges> implements BillingOtherChargesDao {

}
