package com.zzq.dao.impl;

import com.zzq.dao.TestDao;

public class TestDaoImpl implements TestDao {

	@Override
	public void save(String args) {
		// TODO Auto-generated method stub
		System.out.println("进入TestDao实现类，数据库层面保存："+args);
	}

}
