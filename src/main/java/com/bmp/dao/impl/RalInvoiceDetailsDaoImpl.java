package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RalInvoiceDetailsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.RalInvoiceDetails;

@Repository
@Qualifier("ralInvoiceDetailsDaoImpl")
public class RalInvoiceDetailsDaoImpl extends MongoBaseDaoImpl<RalInvoiceDetails> implements RalInvoiceDetailsDao{

}


