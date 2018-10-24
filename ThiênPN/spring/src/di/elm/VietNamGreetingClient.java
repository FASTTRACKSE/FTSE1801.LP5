package di.elm;

import di.Greeting;
import di.GreetingClient;

public class VietNamGreetingClient implements GreetingClient {
	private Greeting greeting;

	@Override
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

	@Override
	public void loiChao() {
		System.err.println(greeting.greet());
	}

}
