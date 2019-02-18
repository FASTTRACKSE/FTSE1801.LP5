package fasttrackse.ftse1801.fbms.entity.qlnhiemvu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai")
public class TrangThaiNhiemVu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_trang_thai")
	private int id;

	@Column(name = "trang_thai")
	private String trangThai;

	public TrangThaiNhiemVu() {
	}

	public TrangThaiNhiemVu(int id, String trangThai) {
		this.id = id;
		this.trangThai = trangThai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}
