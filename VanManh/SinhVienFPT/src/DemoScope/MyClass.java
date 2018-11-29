package DemoScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		HelloWork helleWork = (HelloWork) context.getBean("hello");
		helleWork.setMess("Hello");
		helleWork.getMess();
		HelloWork helleWork2 = (HelloWork) context.getBean("hello");
		helleWork2.setMess("xin chào");
		helleWork2.getMess();
	}
}
