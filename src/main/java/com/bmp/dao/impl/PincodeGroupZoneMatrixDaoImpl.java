package com.bmp.dao.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.PincodeGroupZoneMatrixDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.masters.PincodeGroupZoneMatrix;

@Repository
@Qualifier("pincodeGroupZoneMatrixDaoImpl")
public class PincodeGroupZoneMatrixDaoImpl extends MongoBaseDaoImpl<PincodeGroupZoneMatrix> 
        implements PincodeGroupZoneMatrixDao {

}
