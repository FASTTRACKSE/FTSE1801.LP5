package inheriting;

public class Employee1 {
	private int id;  
	private String name;  
	private Address address;  
	public Employee1() {}  
	  
	public Employee1(int id, String name) {  
	    super();  
	    this.id = id;  
	    this.name = name;  
	}  
	public Employee1(int id, String name, Address address) {  
	    super();  
	    this.id = id;  
	    this.name = name;  
	    this.address = address;  
	}  
	  
	public void show(){  
	    System.out.println(id+" "+name);  
	    System.out.println(address);  
	}  
}
