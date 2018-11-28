package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="danh_sach")
public class SinhVien {
	@Id
	@Column(name="MaSV")
	private int maSV;
	@Column(name="HoVaTen")
	private String name;
	@Column(name="Tuoi")
	private String age;
	@Column(name="img")
	private String img;
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return maSV+"--"+name+"--"+ age+"--"+img;
	}
}
