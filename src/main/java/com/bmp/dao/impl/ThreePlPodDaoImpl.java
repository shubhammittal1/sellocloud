package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ThreePlPodDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.api.ThreePlPod;

@Repository
@Qualifier("threePlPodDaoImpl")
public class ThreePlPodDaoImpl extends MongoBaseDaoImpl<ThreePlPod>  implements ThreePlPodDao{

}
