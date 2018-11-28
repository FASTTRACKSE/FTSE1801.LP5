package mn;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Address;
import model.Collection;
import model.Collection2;
import model.Employee;
import model.User;

public class classDemo {
	private static ApplicationContext context;
  public static void main(String[] args) {
	  context = new ClassPathXmlApplicationContext("context.xml");
	Address aa = (Address)context.getBean("a");
	aa = (Address)context.getBean("a1");
	Employee ee =(Employee) context.getBean("e");
	ee.show();
	Collection collection =(Collection) context.getBean("collec");
	collection.display();
	User user =(User) context.getBean("u1");
	user = (User) context.getBean("u2");
	Collection2 collection2 =(Collection2) context.getBean("collec2");
	collection2.Info();
  }
}
