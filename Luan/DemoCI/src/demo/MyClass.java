package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class MyClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("user.xml");
		User user = (User) context.getBean("user");
		user.show();
		
	}
}
