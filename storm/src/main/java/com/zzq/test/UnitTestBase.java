package com.zzq.test;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
/**
* @ClassName: UnitTestBase
* @Description: ����spring�Ļ���
* @author tylerz
* @date 2017��4��18�� ����10:32:50
*
*/ 
public class UnitTestBase {
	//ͨ������xml��ʵ��������
	private ClassPathXmlApplicationContext context;
	private String springXmlPath;
	//�޲������캯��
	public UnitTestBase(String springXmlPath){
		this.springXmlPath=springXmlPath;
	}
	

	/**
	* @Description: ��Ԫ���Է���ִ��֮ǰ����
	* @Author: tylerz
	* @Title: before
	* @param 
	* @return void
	* @throws
	*/ 
	@Before
	public void before(){
		if (StringUtils.isEmpty(springXmlPath)) {
			springXmlPath="classpath*:spring-*.xml";
		}
		try {
			context=new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
			context.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/**
	* @Description: ��Ԫ���Է���ִ��֮������
	* @Author: tylerz
	* @Title: after
	* @param 
	* @return void
	* @throws
	*/ 
	@After
	public void after(){
		context.destroy();
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId){
		return (T)context.getBean(beanId);
	}
	protected <T extends Object> T getBean(Class<T> clazz){
		return (T)context.getBean(clazz);
	}
}