package di;

public class User {
	private String name;
	private int age;
	
	public User() {
	}
	public User(int age) {
		this.age = age;
	}
	public User(String name) {
		this.name = name;
	}
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void show() {
		System.out.println(name + "--" + age);	
	}
	
}
