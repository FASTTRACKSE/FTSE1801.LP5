package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainDemo {
	private static ApplicationContext context;
	 public static void main(String[] args) {
		 context = new ClassPathXmlApplicationContext("context.xml");
		 HelloWord hello = (HelloWord) context.getBean("hello");
		 hello.setMess("Hello word");
		 hello.getMess();
		 
		 HelloWord hello1 = (HelloWord) context.getBean("hello");
		 hello1.getMess();
	 }
}
