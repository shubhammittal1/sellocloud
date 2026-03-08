package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.model.app.systemCalling.CallManifest;
import com.bmp.dao.CallManifestDao;
import com.bmp.dao.config.MongoBaseDaoImpl;

@Repository
@Qualifier("callManifestDaoImpl")
public class CallManifestDaoImpl extends MongoBaseDaoImpl<CallManifest> implements CallManifestDao{

}
