package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class MyClass {
	private static ApplicationContext context;
	public static void main(String[] args) {
//		Greeting greeting;
//		GreetingClient greetingClient;
//		
//		greeting = new VNGreetingIpml();
//		System.out.println(greeting.greet());
//		
//		greetingClient = new EngGreetingClient();
//		greetingClient.setGreeting(greeting);
//		greetingClient.loiChao();
		
//		context = new ClassPathXmlApplicationContext("context.xml");
//		Greeting greeting = (Greeting) context.getBean("greeting");
//		System.out.println(greeting.greet());
//		GreetingClient client = (GreetingClient) context.getBean("client");
//		client.loiChao();
		
		context = new ClassPathXmlApplicationContext("user.xml");
		User user = (User) context.getBean("user");
		user.show();
	}
}
