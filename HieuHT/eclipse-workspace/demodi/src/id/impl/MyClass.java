package id.impl;

import di.Greeting;
import di.GreetingClient;

public class MyClass {
	public static void main(String[] args) {
		Greeting greeting = new EnglishGreetinglmp();
		System.out.println(greeting.loiChao());
		
		greeting = new VietNamGreetinglmp();
		System.out.println(greeting.loiChao());
		System.out.println("-------");
		
		greeting = new EnglishGreetinglmp();
		GreetingClient greetingClient = new EnglishGreetingClient();
		greetingClient.setLoiChao(greeting);
		greetingClient.xuatLoiChao();
		
		greeting = new VietNamGreetinglmp();
		greetingClient = new VietNamGreetingClient();
		greetingClient.setLoiChao(greeting);
		greetingClient.xuatLoiChao();
	}
}
