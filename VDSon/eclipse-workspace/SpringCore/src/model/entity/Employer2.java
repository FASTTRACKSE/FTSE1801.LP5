package model.entity;

public class Employer2 {
	private int id;
	private String name;
	private Address2 address2;

	public Employer2(int id, String name, Address2 address2) {
		this.id = id;
		this.name = name;
		this.address2 = address2;
	}

	public Employer2() {
	}
	
	public Employer2(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void show() {
		System.out.println(id + " " + name);
		System.out.println(address2);
	}
}
