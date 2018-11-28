import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.HinhClient;


public class MyClass {
private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		HinhClient hinh = (HinhClient) context.getBean("hinh");
		hinh.hienThi();
	}
}
