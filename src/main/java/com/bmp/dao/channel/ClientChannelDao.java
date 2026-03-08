package com.bmp.dao.channel;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.channel.ClientChannel;

public interface ClientChannelDao extends MongoBaseDao<ClientChannel> {
	
	List<ClientChannel> getShopifyClientChannelByShopAndClient(String shop, String clientKey);
	List<ClientChannel> getShopifyClientChannelByShop(String shop);
	ClientChannel getSpfyClientChannelByChannelKeyAndStoreName(String channelKey, String storeName);
    ClientChannel getByChannelKey(String channel);
    ClientChannel getByChannelAndData(String channel,String data,String value);
	ClientChannel getByChannelKeyAndClient(String channelKey, String clientKey);
    ClientChannel getByFieldBeanValue(String key,String value);
}
