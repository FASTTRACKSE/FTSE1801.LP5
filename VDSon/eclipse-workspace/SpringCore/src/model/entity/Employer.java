package model.entity;

public class Employer {
	private int id;
	private String name;
	private Address address;

	public Employer(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Employer() {
	}

	public void show() {
		System.out.println(id + " " + name);
		System.out.println(address.toString());
	}
}
