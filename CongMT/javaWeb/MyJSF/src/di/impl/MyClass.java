package di.impl;

import di1.Greeting;
import di1.GreetingClient;

public class MyClass {
	public static void main(String[] args) {
		
		Greeting greeting1 = new EnglishGreetingImp();
		System.out.println(greeting1.greet());
		
		greeting1 = new VietNamGreetingImp();
		System.out.println(greeting1.greet());
		
		System.out.println("--------------------------");
		greeting1 = new EnglishGreetingImp();
		GreetingClient greetingClientImp = new GreetingClientImp1();
		greetingClientImp.setGreeting(greeting1);
		greetingClientImp.xuatLoiChao();
		
		greetingClientImp = new GreetingClientImp2();
		greetingClientImp.setGreeting(greeting1);
		greetingClientImp.xuatLoiChao();
		
		greeting1 = new VietNamGreetingImp();
		greetingClientImp.setGreeting(greeting1);
		greetingClientImp.xuatLoiChao();
		
		greetingClientImp = new GreetingClientImp1();
		greetingClientImp.setGreeting(greeting1);
		greetingClientImp.xuatLoiChao();
		
		greetingClientImp = new GreetingClientImp2();
		greetingClientImp.setGreeting(new Greeting() {
			
			@Override
			public String greet() {
				return "Son gay hai voi phu nu";
			}
		});
		greetingClientImp.xuatLoiChao();
		
	}
}
