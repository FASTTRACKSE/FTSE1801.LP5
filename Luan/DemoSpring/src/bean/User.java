package bean;

public class User {
	private String name;
	private int old;
	
	public User() {
		System.out.println("AaaaaaaaaaA");
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(int old) {
		this.old = old;
	}
	
	public User(String name, int old) {
		this.name = name;
		this.old = old;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	
	public void show() {
		System.out.println(name+" "+old);
	}
	
}
