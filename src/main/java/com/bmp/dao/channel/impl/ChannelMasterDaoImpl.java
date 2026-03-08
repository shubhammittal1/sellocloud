package com.bmp.dao.channel.impl;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.channel.ChannelMasterDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.channel.ChannelMaster;

@Repository
@Qualifier("channelMasterDaoImpl")
public class ChannelMasterDaoImpl extends MongoBaseDaoImpl<ChannelMaster> implements ChannelMasterDao {

	@Autowired 
	@Qualifier("mongoTemplateRead")
	private MongoTemplate mongoTemplate;

	 @Override
	 public Map<String,String> findDistinctParentKeys(String key) {
         Query query = new Query();
         query.fields().include("key_s").include("channelName").include("expired_b");
         Pattern pattern = Pattern.compile(".*" + Pattern.quote(key) + ".*", Pattern.CASE_INSENSITIVE);
         query.addCriteria(new Criteria().orOperator(Criteria.where("_id").regex(pattern), Criteria.where("channelName").regex(pattern)));

         // Fetch all records that match the query
         List<ChannelMaster> channelMasters = mongoTemplate.find(query, ChannelMaster.class);

         Map<String, String> uniqueRecords = new TreeMap<>();

         // Loop through the results and add each parentKey to the Map
         if (channelMasters != null){
             for (ChannelMaster channelMaster : channelMasters) {
                 uniqueRecords.put(channelMaster.getKey_s(), channelMaster.getChannelName());
             }
         }

		return uniqueRecords;
	 }

	 @Override
	 public boolean checkIfDatabaseEmpty() {
		Long noOfRecords = mongoTemplate.count(new Query(),ChannelMaster.class);
		if(noOfRecords == null || noOfRecords == 0) {
			return true;
		}else {
			return false;
		}
	 }
	 
	 @Override
	 public boolean checkifChannelNameExist(ChannelMaster channelMaster) {	 
		 if (channelMaster.getChannelName() == null || channelMaster.getChannelName().isEmpty()) {
		        return false;
		    }
		 	Query query =new Query();
			query.addCriteria(Criteria.where("channelName").regex("^" + Pattern.quote(channelMaster.getChannelName()) + "$", "i"));
			ChannelMaster dbRecord= mongoTemplate.findOne( query,ChannelMaster.class);
			return dbRecord !=null;
	 }

    @Override
    public List<ChannelMaster> getActiveRecords() {
        Query query = new Query();
        query.addCriteria(Criteria.where("expired_b").is(false));
        List<ChannelMaster> list = getObjectByQuery(query, ChannelMaster.class);
        return list;
    }

    @Override
    public List<ChannelMaster> getByChannelName(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("channelName").regex(key, "i"));
        query.addCriteria(Criteria.where("expired_b").is(false));
        List<ChannelMaster> list = getObjectByQuery(query, ChannelMaster.class);
        return list;
    }

}
