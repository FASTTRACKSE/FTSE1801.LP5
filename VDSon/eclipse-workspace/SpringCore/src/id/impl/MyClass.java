package id.impl;

import di.Greeting;
import di.GreetingClient;

public class MyClass {
	public static void main(String[] args) {
		Greeting greeting = new EnglishGreetinglmp();
		System.out.println(greeting.greeting());
		
		greeting = new VietNamGreetinglmp();
		System.out.println(greeting.greeting());
		System.out.println("-------");
		
		greeting = new EnglishGreetinglmp();
		GreetingClient greetingClient = new EnglishGreetingClient();
		greetingClient.setGreeting(greeting);
		greetingClient.xuatLoiChao();
		
		greeting = new VietNamGreetinglmp();
		greetingClient = new VietNamGreetingClient();
		greetingClient.setGreeting(greeting);
		greetingClient.xuatLoiChao();
	}
}
