package w3cschool.springdemo.springbeanfactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import w3cschool.util.UnitTestBase;

//要运行unit，必须加上这句
@RunWith(BlockJUnit4ClassRunner.class)
public class MainApp extends UnitTestBase {
	// 加载另一个Spring文件，用于测试bean的作用域
	public MainApp() {
		super("classpath*:w3cschool.xml");
	}

	@Test
	public void Test() {
		// XmlBeanFactory factory = new XmlBeanFactory
		// (new ClassPathResource("w3cschool.xml"));
		HelloWorld obj = (HelloWorld) super.getBean("helloWorld");
		obj.getMessage();
	}
	@Test
	public void Test2() {
		//ApplicationContext 包含 BeanFactory 所有的功能，
		//一般情况下，相对于 BeanFactory，ApplicationContext 会被推荐使用。BeanFactory 仍然可以在轻量级应用中使用，
		//比如移动设备或者基于 applet 的应用程序
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:w3cschool/springdemo/springbeanfactory/w3cschool.xml");
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("w3cschool/springdemo/springbeanfactory/w3cschool.xml");//等于上面的
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		
		XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("w3cschool2.xml")); //直接获取resource文件夹下的文件
		HelloWorld obj2 = (HelloWorld) factory.getBean("helloWorld");
		obj2.getMessage();
		System.out.println("obj2 hashCode:"+obj2.hashCode());
		obj2.setMessage("aa");
		
		HelloWorld obj22 = (HelloWorld) factory.getBean("helloWorld");
		obj22.getMessage();
		System.out.println("obj22 hashCode:"+obj22.hashCode());
		
		HelloWorld obj3 = (HelloWorld) factory.getBean("helloWorld2");
		obj3.getMessage();
		System.out.println("obj3 hashCode:"+obj3.hashCode());
		obj3.setMessage("aa");
		HelloWorld obj33 = (HelloWorld) factory.getBean("helloWorld2");
		obj33.getMessage();
		System.out.println("obj33 hashCode:"+obj33.hashCode());
	}

}