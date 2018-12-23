package demo.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sinhvien")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "old")
	private String old;
	@Column(name = "adress")
	private String adress;
	@Column(name = "numberPhone")
	private String numberPhone;
	@Column(name = "img")
	private String img;
//	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
//	private diem diem;

	
	public Student() {
		super();
	}
	public Student(int id, String name, String old, String adress, String numberPhone, String img) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.adress = adress;
		this.numberPhone = numberPhone;
		this.img = img;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

//	public diem getDiem() {
//		return diem;
//	}
//
//	public void setDiem(diem diem) {
//		this.diem = diem;
//	}

//	@Override
//	public String toString() {
//
//		String student = this.id + " | " + this.name + " | " + this.old + " | " + this.adress + " | " + this.numberPhone
//				+ " | " + this.img;
//		if (this.diem != null) {
//			student += "|" + this.diem.toString();
//		}
//		return student;
//	}

}
