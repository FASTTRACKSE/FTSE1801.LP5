package ftse1801.demo.spring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_cong_viec")
public class LoaiCongViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_loai_cong_viec")
	private int ID;

	@Column(name = "loai_cong_viec")
	private String loaiCongViec;

	public LoaiCongViec() {

	}

	public LoaiCongViec(int iD, String loaiCongViec) {
		ID = iD;
		this.loaiCongViec = loaiCongViec;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(String loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
	}

}
