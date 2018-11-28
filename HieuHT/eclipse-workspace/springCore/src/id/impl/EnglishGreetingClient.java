package id.impl;

import di.Greeting;
import di.GreetingClient;

public class EnglishGreetingClient implements GreetingClient{
	Greeting greeting;
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
	@Override
	public void xuatLoiChao() {
		System.err.println(greeting.greeting());
	}
}
