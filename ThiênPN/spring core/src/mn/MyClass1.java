package mn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.Greeting;
import di.GreetingClient;
import di.showList;
import di.showListData;

public class MyClass1 {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		Greeting greeting12 =(Greeting) context.getBean("greeting12");
		System.out.println(greeting12.greet());
		GreetingClient greetingClient =(GreetingClient) context.getBean("greetingClient");
		greetingClient.loiChao();
		showList sList =(showList) context.getBean("sList");
		
		showListData data =(showListData) context.getBean("data");
		data.show();
	}
}
