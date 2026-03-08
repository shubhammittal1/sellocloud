package com.bmp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.bean.Test;
import com.bmp.dao.TestDao;

@Repository
@Qualifier("testDaoImpl")
public class TestDaoImpl /*extends HibernateDaoImpl<MasterData> */ implements TestDao {

	@Override
	public List<Test> getAllTest() throws Exception {
		List<Test> tests = new ArrayList<>();
		Test test = new Test();
		test.setId(1l);
		test.setName("aaa");
		Test test1 = new Test();
		test1.setId(2l);
		test1.setName("bbb");
		tests.add(test);
		tests.add(test1);
		return tests;
	}
	
	
}
