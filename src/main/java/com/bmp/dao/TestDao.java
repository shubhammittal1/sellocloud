package com.bmp.dao;

import java.util.List;

import com.bmp.bean.Test;

public interface TestDao /*extends GenericDao<MasterData>*/ {

	List<Test> getAllTest() throws Exception;
	
}