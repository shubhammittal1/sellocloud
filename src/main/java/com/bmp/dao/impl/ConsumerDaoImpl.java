package com.bmp.dao.impl;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.UserType;
import com.bmp.dao.ConsumerDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.saleorder.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Qualifier("consumerDaoImpl")
public class ConsumerDaoImpl extends MongoBaseDaoImpl<Consumer> implements ConsumerDao {

    @Autowired
    @Qualifier("mongoTemplateRead")
    private MongoTemplate mongoTemplateRead;
    
    @Autowired
    @Qualifier("sessionUserBean")
    private SessionUserBean sessionUserBean;

    @Override
    public List<Consumer> getAllConsumers(String clientKey,String key) {
        Query query = new Query();
        if (sessionUserBean != null && sessionUserBean.getUser().getType().equals(UserType.CLIENT)) {
			query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()).and("name").regex(key, GlobalConstant.CASE_SENSITIVE));
		}else {
			query.addCriteria(Criteria.where("clientKey").is(clientKey).and("name").regex(key, GlobalConstant.CASE_SENSITIVE));
		}
        
        return getObjectByQuery(query, Consumer.class);
    }
}
