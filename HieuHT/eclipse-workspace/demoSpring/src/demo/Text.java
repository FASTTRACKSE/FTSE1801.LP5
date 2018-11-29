package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text {
	/* demo constructor */
	// public static void main(String[] args) {
	// ApplicationContext applicationContext = new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	//
	// Employee s = (Employee) applicationContext.getBean("s");
	// s.show();
	// }

	/* demo collection */
	 public static void main(String[] args) {
	 ApplicationContext applicationContext = new
	 ClassPathXmlApplicationContext("applicationContext.xml");
	
	 Question s = (Question) applicationContext.getBean("s");
	 s.displayInfo();
	
	 }
}