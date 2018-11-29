package ftse1801.demo.spring.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="diem")
public class Diem implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	
	private SinhVien sinhVien;
	
	private String monHoc;
	
	private int diem;
	
	
	
	
	public Diem(SinhVien sinhVien, String monHoc, int diem) {
		super();
		this.sinhVien = sinhVien;
		this.monHoc = monHoc;
		this.diem = diem;
	}
	public Diem() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="maSV",referencedColumnName="maSV",nullable=false)
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	@Column(name="monhoc")
	public String getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	@Column(name="diem")
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	
}
