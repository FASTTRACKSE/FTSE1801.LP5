package demo;

public class User {
	private String id;
	private String name;
	private String old;
	private String address;
	
	public User(String id, String name, String old, String address) {
		this.id = id;
		this.name = name;
		this.old = old;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
