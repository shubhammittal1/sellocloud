package com.bmp.dao.channel.impl;

import java.util.List;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.model.app.channel.ChannelAuthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.channel.ClientChannelDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.channel.ClientChannel;

@Repository
@Qualifier("clientChannelDaoImpl")
public class ClientChannelDaoImpl extends MongoBaseDaoImpl<ClientChannel> implements ClientChannelDao{

    @Autowired
    @Qualifier("sessionUserBean")
    private SessionUserBean sessionUserBean;

	@Override
	public List<ClientChannel> getShopifyClientChannelByShop(String shop) {
		Query query = new Query();
		query.addCriteria(Criteria.where("storeName").is(shop));
		return getObjectByQuery(query, ClientChannel.class);
	}

    @Override
    public ClientChannel getByChannelKey(String key) {
        Query query = new Query();
        if(sessionUserBean != null ) {
            if(sessionUserBean.getUser() != null && sessionUserBean.getUser().getThirdPartyKey() != null ) {
                query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
            }
        }
        query.addCriteria(Criteria.where("channelKey").regex("^"+key+"$","i"));
        List<ClientChannel> list = getObjectByQuery(query, ClientChannel.class);
        if(list != null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ClientChannel getByChannelAndData(String key, String data,String value) {
        Query query = new Query();
        if(sessionUserBean != null && !sessionUserBean.getUser().getThirdPartyKey().isEmpty()) {
            query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
        }
        query.addCriteria(Criteria.where("channelKey").regex("^"+key+"$","i"));
        query.addCriteria(Criteria.where("authMap." + data).is(value));
        List<ClientChannel> list = getObjectByQuery(query, ClientChannel.class);
        if(list != null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
	public List<ClientChannel> getShopifyClientChannelByShopAndClient(String shop, String clientKey) {
		Query query = new Query();
		query.addCriteria(Criteria.where("storeName").is(shop).and("clientKey").is(clientKey));
		return getObjectByQuery(query, ClientChannel.class);
	}

	@Override
	public ClientChannel getByChannelKeyAndClient(String channelKey, String clientKey) {
        Query query = new Query();
		query.addCriteria(Criteria.where("channelKey").is(channelKey).and("clientKey").is(clientKey));
		return getObjectByQuery(query, ClientChannel.class) != null && !getObjectByQuery(query, ClientChannel.class).isEmpty() ? getObjectByQuery(query, ClientChannel.class).get(0): null;
	}

    @Override
    public ClientChannel getByFieldBeanValue(String key, String value) {
        Query query = new Query();
        query.addCriteria(Criteria.where("authMap." + key).is(value));
        List<ClientChannel> list = getObjectByQuery(query, ClientChannel.class);
        if(list != null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

	@Override
	public ClientChannel getSpfyClientChannelByChannelKeyAndStoreName(String channelKey, String storeName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("channelKey").is(channelKey).and("storeName").is(storeName));
		return getObjectByQuery(query, ClientChannel.class) != null && !getObjectByQuery(query, ClientChannel.class).isEmpty() ? getObjectByQuery(query, ClientChannel.class).get(0): null;
	}

}
