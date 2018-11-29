package di2;

public class DoSomeThing {
	void doSomeThing(IHello iHello) {
		System.out.println("troi toi qua");
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
		
		IHello hello11 = new Hello1();
		doSomeThing.doSomeThing(hello11);
		hello11 = new Hello2();
		doSomeThing.doSomeThing(hello11);
	}
}
