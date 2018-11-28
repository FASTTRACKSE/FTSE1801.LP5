package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClass {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");
		HelloWord helloWord = (HelloWord) context.getBean("key");
		helloWord.setMessenge("I'm best");
		helloWord.getMessenge();
		HelloWord helloWord2 = (HelloWord) context.getBean("key");
		helloWord2.setMessenge("I'm L");
		helloWord2.getMessenge();
	}
}
