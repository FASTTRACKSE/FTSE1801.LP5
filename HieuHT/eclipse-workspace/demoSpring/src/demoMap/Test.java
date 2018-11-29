package demoMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
		Question1 q = (Question1) applicationContext.getBean("q");
		q.displayInfo();
	}
}
