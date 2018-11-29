package ftse1801.demo.spring.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ngọc thiên 1801014
 * 
 * @author TGDD
 *
 */
@Entity
@Table(name="sinh_vien")
public class SinhVien implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="maSV")
	private String maSinhVien;
	@Column(name="ten")
	private String tensinhVien;
	@Column(name="pass")
	private String password;
	@Column(name="tuoi")
	private String tuoi;
	@Column(name="img")
	private String img;
	@ManyToOne
	@JoinColumn(name="maSV",nullable=false)
	private Diem diem;

	public SinhVien(String maSinhVien, String tensinhVien, String password,String tuoi,String img, Diem diem) {
		super();
		this.maSinhVien = maSinhVien;
		this.tensinhVien = tensinhVien;
		this.password = password;
		this.tuoi = tuoi;
		this.img = img;
		this.diem = diem;
	}

	public SinhVien() {

	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTensinhVien() {
		return tensinhVien;
	}

	public void setTensinhVien(String tensinhVien) {
		this.tensinhVien = tensinhVien;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
    
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Diem getDiem() {
		return diem;
	}

	public void setDiem(Diem diem) {
		this.diem = diem;
	}

}
