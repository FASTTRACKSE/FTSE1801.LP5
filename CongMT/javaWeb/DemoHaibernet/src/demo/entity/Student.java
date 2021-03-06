package demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sinhvien")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	private String id;
	 @Column(name="name")
	private String name;
	 @Column(name="old")
	private String old;
	 @Column(name="adress")
	private String adress;
	 @Column(name="numberPhone")
	private String numberPhone;
	
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
	 @Override
	    public String toString() {
	 
	        return this.id +" | "+this.name +" | "+this.old +" | "+this.adress +" | "+this.numberPhone;
	    }
	
	
}
