package demo.hibernate.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="sinhvien2")
public class SinhVien implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MASV", unique=true, nullable=false)
	private String maSv;
	@Column(name="TEN")
	private String name;
	@Column
	private int age;
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "sinhVien", cascade = CascadeType.ALL)
	private Diem diem;
	
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
	public Diem getDiem() {
		return diem;
	}
	public void setDiem(Diem diem) {
		this.diem = diem;
	}
	@Override
	public String toString() {
		String resp = this.maSv+" | "+this.name+" | "+this.age;
        if(this.diem != null) {
            resp += " | "+this.diem.toString();
        }
 
        return resp;	}
	

}
