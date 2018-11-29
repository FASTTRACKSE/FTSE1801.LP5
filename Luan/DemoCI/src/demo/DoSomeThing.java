package demo;

import bean.Hello1;
import bean.Hello2;
import di.IHello;

public class DoSomeThing {
	void doSomeThing(IHello iHello) {
		System.out.println("Trời tối quá");
		iHello.inHello();
	}
	
	public static void main(String[] args) {
		DoSomeThing doSomeThing = new DoSomeThing();
		doSomeThing.doSomeThing(new IHello() {
			
			@Override
			public void inHello() {
				System.out.println("Di ve");
			}
		});
		
		Hello1 hello1 = new Hello1();
		doSomeThing.doSomeThing(hello1);
		Hello2 hello2 = new Hello2();
		doSomeThing.doSomeThing(hello2);
		
		IHello hello = new Hello1();
		doSomeThing.doSomeThing(hello);
		hello = new Hello2();
		doSomeThing.doSomeThing(hello);
	}
}
