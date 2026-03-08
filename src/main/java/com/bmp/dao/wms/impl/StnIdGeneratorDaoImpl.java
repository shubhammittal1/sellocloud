package com.bmp.dao.wms.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.StnIdGeneratorDao;
import com.bmp.model.app.wms.StnIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("stnIdGeneratorDaoImpl")
public class StnIdGeneratorDaoImpl extends MongoBaseDaoImpl<StnIdGenerator> implements StnIdGeneratorDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void deleteAtFirst() {
        String key_s = mongoTemplate.findAll(StnIdGenerator.class).get(0).getKey_s();
        if(key_s != null) {
            removeObjectById(key_s, StnIdGenerator.class);
        }
    }
}
