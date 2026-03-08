package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.NumberMetadataDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.systemCalling.NumberMetadata;

@Repository
@Qualifier("numberMetadataDaoImpl")
public class NumberMetadataDaoImpl extends MongoBaseDaoImpl<NumberMetadata> implements NumberMetadataDao{
	
}
