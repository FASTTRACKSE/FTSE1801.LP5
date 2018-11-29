package ftse1801.demo.spring.model.entity;

public class SinhVien {
	private String maSv;
	private String name;
	private int age;
	
	public SinhVien(String maSv, String name, int age) {
		this.maSv = maSv;
		this.name = name;
		this.age = age;
	}
	public SinhVien() {
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
