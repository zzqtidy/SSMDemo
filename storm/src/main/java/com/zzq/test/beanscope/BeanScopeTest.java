package com.zzq.test.beanscope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.zzq.other.beanscope.BeanScope;
import com.zzq.test.UnitTestBase;

/**
* @ClassName: BeanScopeTest
* @Description: 用于测试bean的作用域
* 1、singleton 在同一个bean的容器中只有一份实例
* 2、每次请求或者每次使用都会创建新的实例，同时destroy方式不会生效
* @author tylerz
* @date 2017年4月20日 下午10:13:05
*
*/ 
//要运行unit，必须加上这句
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanScopeTest extends UnitTestBase{
	//加载另一个Spring文件，用于测试bean的作用域
	public BeanScopeTest() {
		super("classpath*:spring-beanscope.xml");
	}
	
	
	/**
	* @Description: 测试bean的单例作用域，此方法的hashcode值是一致的
	* @Author: tylerz
	* @Title: TestSingleton
	* @param 
	* @return void
	* @throws
	*/ 
	@Test
	public void TestSingleton(){
		BeanScope beanScopeSingleton1=(BeanScope)super.getBean("beanScopeSingleton");
		beanScopeSingleton1.say();
		
		BeanScope beanScopeSingleton2=(BeanScope)super.getBean("beanScopeSingleton");
		beanScopeSingleton2.say();
	}
	/**
	* @Description: 测试bean的prototype的作用域，此方法返回的hashcode值是不一样的
	* @Author: tylerz
	* @Title: TestPrototype
	* @param 
	* @return void
	* @throws
	*/ 
	@Test
	public void TestPrototype(){
		BeanScope beanScopePrototype1=(BeanScope)super.getBean("beanScopePrototype");
		beanScopePrototype1.say();
		
		BeanScope beanScopePrototype2=(BeanScope)super.getBean("beanScopePrototype");
		beanScopePrototype2.say();
	}
	
	
}
