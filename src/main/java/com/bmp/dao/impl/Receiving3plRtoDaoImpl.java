package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.Receiving3plRtoDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.Receiving3plRto;

@Repository
@Qualifier("receiving3plRtoDaoImpl")
public class Receiving3plRtoDaoImpl extends MongoBaseDaoImpl<Receiving3plRto> implements Receiving3plRtoDao {
	
	
}