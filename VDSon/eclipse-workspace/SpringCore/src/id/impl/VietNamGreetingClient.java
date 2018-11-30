package id.impl;

import di.Greeting;
import di.GreetingClient;

public class VietNamGreetingClient implements GreetingClient {
	Greeting greeting;
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
	public void xuatLoiChao() {
		System.err.println(greeting.greeting());
	}
}
