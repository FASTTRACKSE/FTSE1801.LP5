package di.impl;

import di1.Greeting;
import di1.GreetingClient;

public class GreetingClientImp2 implements GreetingClient{
	private Greeting greeting;
	@Override
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

	@Override
	public void xuatLoiChao() {
		System.err.println(greeting.greet());
	}

}
