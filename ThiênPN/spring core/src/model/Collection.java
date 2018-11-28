package model;

import java.util.Iterator;
import java.util.List;

public class Collection {
	private int id;
	private String name;
	private List<Address> aaa;

	public Collection() {

	}

	public Collection(int id, String name, List<Address> aaa) {
		super();
		this.id = id;
		this.name = name;
		this.aaa = aaa;
	}

	public void display() {
		System.out.println(id + " " + name);
		System.out.println("vsddgdgg");
		for (Address address : aaa) {
			System.out.println(address);
		}

	}

}
