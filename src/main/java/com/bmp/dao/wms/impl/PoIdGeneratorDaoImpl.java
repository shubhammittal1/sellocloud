package com.bmp.dao.wms.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.PoIdGeneratorDao;
import com.bmp.model.app.wms.PoIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("poIdGeneratorDaoImpl")
public class PoIdGeneratorDaoImpl extends MongoBaseDaoImpl<PoIdGenerator> implements PoIdGeneratorDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void deleteAtFirst() {
        String key_s = mongoTemplate.findAll(PoIdGenerator.class).get(0).getKey_s();
        if(key_s != null) {
            removeObjectById(key_s, PoIdGenerator.class);
        }
    }
}
