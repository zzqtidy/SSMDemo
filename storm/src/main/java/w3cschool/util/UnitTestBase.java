package w3cschool.util;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
/**
* @ClassName: UnitTestBase
* @Description: 测试spring的基类
* @author tylerz
* @date 2017年4月18日 下午10:32:50
*
*/ 
public class UnitTestBase {
	//通过加载xml来实现上下文
	private ClassPathXmlApplicationContext context;
	private String springXmlPath;
	//构造函数
	public UnitTestBase(String springXmlPath){
		this.springXmlPath=springXmlPath;
	}
	

	/**
	* @Description: 单元测试方法执行之前运行
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
	* @Description: 单元测试方法执行之后运行
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
