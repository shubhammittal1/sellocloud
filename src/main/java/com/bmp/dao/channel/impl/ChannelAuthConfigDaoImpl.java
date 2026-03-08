package com.bmp.dao.channel.impl;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.bmp.bean.user.SessionUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.bean.courier.FieldBean;
import com.bmp.dao.channel.ChannelAuthConfigDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.channel.ChannelAuthConfig;

@Repository
@Qualifier("channelAuthConfigDaoImpl")
public class ChannelAuthConfigDaoImpl extends MongoBaseDaoImpl<ChannelAuthConfig> implements ChannelAuthConfigDao {
	
	@Autowired 
	@Qualifier("mongoTemplateRead")
	private MongoTemplate mongoTemplate;

    @Autowired
    @Qualifier("sessionUserBean")
    private SessionUserBean sessionUserBean;

	@Override
	public ChannelAuthConfig getObjectByChannel(String channel, Class<ChannelAuthConfig> classVal) {
		Query query = new Query();
		query.addCriteria(Criteria.where("channel").is(channel));
		
		return this.mongoTemplate.findOne(query, classVal);
	}

	@Override
	public void deleteFieldBeanByChannel(String channel) {
		ChannelAuthConfig channelAuthConfig = getObjectByChannel(channel,ChannelAuthConfig.class);
		try {
			if(channelAuthConfig != null) {
				saveObject(channelAuthConfig, ChannelAuthConfig.class);
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean checkChannelExist(ChannelAuthConfig existingRecord) {
		if(existingRecord.getChannel() == null || existingRecord.getChannel().isEmpty()) {
			return false;
		}
		 Query query = new Query();
		 query = query.addCriteria(Criteria.where("channel").regex("^" + Pattern.quote( existingRecord.getChannel()) + "$" + "i"));
		 ChannelAuthConfig dbQuery= mongoTemplate.findOne(query,ChannelAuthConfig.class);
		 
		 return dbQuery != null;
	}

    @Override
    public ChannelAuthConfig getByChannel(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("channel").regex("^"+key+"$","i"));
        if(sessionUserBean.getUser().getThirdPartyKey() != null) {
            query.addCriteria(Criteria.where("createdBy").is(sessionUserBean.getUser().getDeviceId()));
        }
        List<ChannelAuthConfig> list = getObjectByQuery(query, ChannelAuthConfig.class);
        if(list != null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
	public void deleteFieldRecordByFieldCode(String channel, String fieldCode) {
		ChannelAuthConfig channelAuthConfig = getObjectByChannel(channel, ChannelAuthConfig.class);
		List<FieldBean> fieldBean= channelAuthConfig.getFieldBean();
		Iterator<FieldBean> iterator = fieldBean.iterator();
		try {
				 while (iterator.hasNext()) {
		                FieldBean fieldBeanIterator = iterator.next();
		                if (fieldBeanIterator.getFieldCode().equals(fieldCode)) {
		                    iterator.remove();
		                    break;
		                }
		            }
			if(channelAuthConfig != null) {
				saveObject(channelAuthConfig, ChannelAuthConfig.class);
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
