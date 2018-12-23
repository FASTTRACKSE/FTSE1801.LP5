package demo.di;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	private static ApplicationContext context;
	public static void main(String[] args) {
		context =  new ClassPathXmlApplicationContext("context.xml");
		 
		 
		Employee s=(Employee)context.getBean("s");  
        s.show();  
	}
}
