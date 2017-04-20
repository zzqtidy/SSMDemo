package com.zzq.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.zzq.service.TestManager;

//Ҫ����unit������������
@RunWith(BlockJUnit4ClassRunner.class)
public class TestOne extends UnitTestBase{
	public TestOne(){
		super("classpath*:spring-ioc.xml");
	}
	
	//ÿ������Ҫ��unit���ԣ����ϴ�ע��
	@Test
	public void Test01(){
		System.out.println("test");
	}
	
	@Test
	public void Test02(){
		TestManager testManager=super.getBean("testManager");
		testManager.save();
	}
}
