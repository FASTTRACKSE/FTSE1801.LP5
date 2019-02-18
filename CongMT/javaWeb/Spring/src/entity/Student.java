package entity;

public class Student {
	private String id;
	private String name;
	private String old;
	private String adress;
	private String numberPhone;
	
	
	
	public Student() {
		super();
	}
	
	public Student(String id,String name, String old, String adress, String numberPhone) {
		super();
		this.name = name;
		this.old = old;
		this.adress = adress;
		this.numberPhone = numberPhone;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	
	
}
