package com.zzq.test.beanscope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.zzq.other.beanscope.BeanScope;
import com.zzq.test.UnitTestBase;

/**
* @ClassName: BeanScopeTest
* @Description: ���ڲ���bean��������
* 1��singleton ��ͬһ��bean��������ֻ��һ��ʵ��
* 2��ÿ���������ÿ��ʹ�ö��ᴴ���µ�ʵ����ͬʱdestroy��ʽ������Ч
* @author tylerz
* @date 2017��4��20�� ����10:13:05
*
*/ 
//Ҫ����unit������������
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanScopeTest extends UnitTestBase{
	//������һ��Spring�ļ������ڲ���bean��������
	public BeanScopeTest() {
		super("classpath*:spring-beanscope.xml");
	}
	
	
	/**
	* @Description: ����bean�ĵ��������򣬴˷�����hashcodeֵ��һ�µ�
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
	* @Description: ����bean��prototype�������򣬴˷������ص�hashcodeֵ�ǲ�һ����
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
