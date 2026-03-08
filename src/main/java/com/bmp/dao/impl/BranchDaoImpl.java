
package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BranchDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.facility.Branch;

@Repository
@Qualifier("branchDaoImpl")
public class BranchDaoImpl extends MongoBaseDaoImpl<Branch>  implements BranchDao {
	
}