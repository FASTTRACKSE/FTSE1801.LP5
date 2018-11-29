package demoScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClass {
	public static void main(String[] arge) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld helloA = (HelloWorld) context.getBean("helloWorld");
		
		helloA.setMessage("Phần A");
		helloA.getMessage();
		
		HelloWorld helloB = (HelloWorld) context.getBean("helloWorld");
		helloB.getMessage();
		
	}
}
