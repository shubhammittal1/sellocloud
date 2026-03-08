package com.bmp.dao.wms;


import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.PackageMaster;

import java.util.List;

public interface PackageMasterDao extends MongoBaseDao<PackageMaster> {

    List<PackageMaster> filterRecordsByClientKey(String clientKey);

    List<PackageMaster> getAllByRequest(DatatableRequestBean datatableRequestBean);

    boolean isExist(PackageMaster packageMaster);
}
