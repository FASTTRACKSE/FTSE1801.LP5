
public class Employee {
	private int age;
	private String name;
	private Address address;

	public Employee() {
		System.out.println("cmcjhsb");
	}

	public Employee(int age, String name, Address address) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
	}

	void show() {
		System.out.println(name + " " + age);
		System.out.println(address.toString());
	}

}
