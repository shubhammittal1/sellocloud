package com.bmp.dao.wms;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.StnIdGenerator;

public interface StnIdGeneratorDao extends MongoBaseDao<StnIdGenerator> {
    void deleteAtFirst();
}
