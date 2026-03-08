package com.bmp.dao.wms;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.PoIdGenerator;

public interface PoIdGeneratorDao extends MongoBaseDao<PoIdGenerator> {
    void deleteAtFirst();
}
