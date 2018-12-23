package di.impl;

import di1.Greeting;
import di1.GreetingClient;

public class GreetingClientImp1 implements GreetingClient{
	 private Greeting greeting;
	@Override
	public void setGreeting(Greeting greeting) {
		this.greeting=greeting;
	}

	@Override
	public void xuatLoiChao() {
		System.out.println(greeting.greet());
	}

}
