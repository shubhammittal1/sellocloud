package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.RoleDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.facility.Role;

@Repository
@Qualifier("roleDaoImpl")
public class RoleDaoImpl extends MongoBaseDaoImpl<Role>  implements RoleDao {
	
}