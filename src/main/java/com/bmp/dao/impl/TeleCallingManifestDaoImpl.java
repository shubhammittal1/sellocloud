package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.model.app.saleorder.TeleCallingManifest;
import com.bmp.model.app.systemCalling.CallManifest;
import com.bmp.dao.CallManifestDao;
import com.bmp.dao.TeleCallingManifestDao;
import com.bmp.dao.config.MongoBaseDaoImpl;

@Repository
@Qualifier("teleCallingManifestDaoImpl")
public class TeleCallingManifestDaoImpl extends MongoBaseDaoImpl<TeleCallingManifest> implements TeleCallingManifestDao{

}
