package com.bmp.dao.c2c.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.c2c.EnquiryDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.c2c.Enquiry;

@Repository
@Qualifier("enquiryDaoImpl")
public class EnquiryDaoImpl extends MongoBaseDaoImpl<Enquiry> implements EnquiryDao {

}
