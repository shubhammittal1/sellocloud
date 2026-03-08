package com.bmp.dao.wms;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.wms.OrderIdGenerator;
import com.bmp.model.app.wms.StnIdGenerator;

public interface OrderIdGeneratorDao extends MongoBaseDao<OrderIdGenerator> {

    void deleteAtFirst() ;
}
