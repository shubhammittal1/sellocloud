package com.bmp.dao;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.saleorder.Consumer;

import java.util.List;

public interface ConsumerDao extends MongoBaseDao<Consumer> {
    List<Consumer> getAllConsumers(String clientKey,String key);
}
