import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.PayServiceInjector;

public class MyClass {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		PayServiceInjector payServiceInjector = (PayServiceInjector) context.getBean("pay");
		payServiceInjector.hienThi();
	}
}
