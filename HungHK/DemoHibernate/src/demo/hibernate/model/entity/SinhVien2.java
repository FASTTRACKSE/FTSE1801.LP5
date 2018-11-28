package demo.hibernate.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sinhvien2")
public class SinhVien2 implements Serializable {
	
	@Id
	@Column(name="MASV")
	private String maSv;
	@Column(name="TEN")
	private String name;
	@Column(name="Age")
	private int age;
	
	public SinhVien2() {
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
	@Override
	public String toString() {
		return this.maSv+" | "+this.name+" | "+this.age;
	}
	
}
