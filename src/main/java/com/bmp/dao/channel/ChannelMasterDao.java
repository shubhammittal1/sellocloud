package com.bmp.dao.channel;

import java.util.List;
import java.util.Map;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.channel.ChannelMaster;

public interface ChannelMasterDao extends MongoBaseDao<ChannelMaster> {
	 Map<String,String> findDistinctParentKeys(String key);
	 boolean checkIfDatabaseEmpty();
	 boolean checkifChannelNameExist(ChannelMaster channelMaster);
     List<ChannelMaster> getActiveRecords();
     List<ChannelMaster> getByChannelName(String key);
}
