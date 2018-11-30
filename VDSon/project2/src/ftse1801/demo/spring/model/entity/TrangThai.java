package ftse1801.demo.spring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai")
public class TrangThai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_trang_thai")
	private int ID;

	@Column(name = "trang_thai")
	private String trangThai;

	public TrangThai() {
	}

	public TrangThai(int iD, String trangThai) {
		ID = iD;
		this.trangThai = trangThai;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}
