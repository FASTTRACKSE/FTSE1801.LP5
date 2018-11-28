package defaultpackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.Greeting;
import di.GreetingClient;
import di.showList;
import di.showListData;

public class MyClass {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
//		context = new ClassPathXmlApplicationContext("context.xml");
//		Greeting greeting = (Greeting) context.getBean("greeting");
//		System.out.println(greeting.greeting());
//		
//		GreetingClient greetingClient = (GreetingClient) context.getBean("greetingClient");
//		greetingClient.xuatLoiChao();
		context = new ClassPathXmlApplicationContext("context.xml");
		Greeting greeting12 =(Greeting) context.getBean("greeting12");
		System.out.println(greeting12.greeting());
		GreetingClient greetingClient =(GreetingClient) context.getBean("greetingClient");
		greetingClient.xuatLoiChao();
		showList sList =(showList) context.getBean("sList");
		System.out.println(sList.listSV());
		showListData data =(showListData) context.getBean("data");
		data.show();
	}
}
