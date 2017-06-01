package w3cschool.springdemo.springbeanfactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import w3cschool.util.UnitTestBase;

//Ҫ����unit������������
@RunWith(BlockJUnit4ClassRunner.class)
public class MainApp extends UnitTestBase {
	// ������һ��Spring�ļ������ڲ���bean��������
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
		//ApplicationContext ���� BeanFactory ���еĹ��ܣ�
		//һ������£������ BeanFactory��ApplicationContext �ᱻ�Ƽ�ʹ�á�BeanFactory ��Ȼ������������Ӧ����ʹ�ã�
		//�����ƶ��豸���߻��� applet ��Ӧ�ó���
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:w3cschool/springdemo/springbeanfactory/w3cschool.xml");
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("w3cschool/springdemo/springbeanfactory/w3cschool.xml");//���������
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		
		XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("w3cschool2.xml")); //ֱ�ӻ�ȡresource�ļ����µ��ļ�
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