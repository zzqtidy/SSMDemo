package com.zzq.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.zzq.service.TestManager;

//要运行unit，必须加上这句
@RunWith(BlockJUnit4ClassRunner.class)
public class TestOne extends UnitTestBase{
	public TestOne(){
		super("classpath*:spring-ioc.xml");
	}
	
	//每个方法要用unit测试，加上此注解
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
