package bean;

public class User {
	private int id;
	private String name;
	private Address address;
	
	public User() {
		System.out.println(id+" "+name+" "+address);
	}
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void show() {
		System.err.println(id+" "+name+" "+address);
	}
}
