package demoHibernate.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quanlysv")
public class SinhVien{
	@Id
	@Column(name="id")
	private int id;
	@Column(name = "Ten")
	private String ten;
	@Column(name ="Tuoi")
	private String tuoi;
	@Column(name = "Diachi")
	private String diachi;
	@Column(name = "Lop")
	private String lop;
	@Column(name ="img")
	private String img;
	
	public SinhVien() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return this.id+"|"+this.ten+"|"+this.tuoi+"|"+this.diachi+"|"+this.lop+"|"+this.img;
	}

}
