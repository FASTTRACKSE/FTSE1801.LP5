package demo;

import di.Greeting;
import di.GreetingClient;
import id.impl.EnglishGreetingClient;
import id.impl.EnglishGreetinglmp;
import id.impl.VietNamGreetingClient;
import id.impl.VietNamGreetinglmp;

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
