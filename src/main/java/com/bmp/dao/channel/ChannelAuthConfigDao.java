package com.bmp.dao.channel;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.channel.ChannelAuthConfig;

public interface ChannelAuthConfigDao extends MongoBaseDao<ChannelAuthConfig> {

	 ChannelAuthConfig getObjectByChannel(String channel,final Class<ChannelAuthConfig> classVal);
	 void deleteFieldBeanByChannel(String channel);
	 void deleteFieldRecordByFieldCode(String channel,String fieldCode);
	 boolean checkChannelExist(ChannelAuthConfig existingRecord);
     ChannelAuthConfig getByChannel(String key);
}
