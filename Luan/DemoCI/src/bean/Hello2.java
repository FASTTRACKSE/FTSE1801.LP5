package bean;

import di.IHello;

public class Hello2 implements IHello{

	@Override
	public void inHello() {
		System.out.println("Hello");
	}

}
