package com.bmp.dao;

import java.util.List;

import com.bmp.dao.config.MongoBaseDao;
import com.bmp.model.app.bag.Bag;

public interface BagDao extends MongoBaseDao<Bag>{
	
	Bag getBag(String bagSealNo) throws Exception;

	List<Bag> getBagList(String key) throws Exception;

}
