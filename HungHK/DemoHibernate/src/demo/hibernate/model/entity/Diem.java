package demo.hibernate.model.entity;

import javax.persistence.*;

@Entity
@Table(name="diem")
public class Diem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", unique = true, nullable = false)
	private String id;
	@Column
	private float html;
	@Column
	private float javaCore;
	@Column
	private float javaWeb;
	@OneToOne
	@JoinColumn(name="MASV")
	private SinhVien sinhVien;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getHtml() {
		return html;
	}
	public void setHtml(float html) {
		this.html = html;
	}
	public float getJavaCore() {
		return javaCore;
	}
	public void setJavaCore(float javaCore) {
		this.javaCore = javaCore;
	}
	public float getJavaWeb() {
		return javaWeb;
	}
	public void setJavaWeb(float javaWeb) {
		this.javaWeb = javaWeb;
	}
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	@Override
	public String toString() {
		return this.html+" | "+this.javaCore+" | "+this.javaWeb;

	}
	
}
