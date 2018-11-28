package bean;

import di.IHello;

public class Hello1 implements IHello{

	@Override
	public void inHello() {
		System.out.println("Xin chào");
	}
	
}
