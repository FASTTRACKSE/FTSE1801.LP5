package di.impl;

import di1.Greeting;
import di1.GreetingClient;

public class EnglishGreetingImp implements Greeting{

	@Override
	public String greet() {
		return "Hello";
	}

}
