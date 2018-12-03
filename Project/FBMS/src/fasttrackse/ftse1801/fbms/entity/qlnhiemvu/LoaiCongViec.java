package fasttrackse.ftse1801.fbms.entity.qlnhiemvu;

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
	private int id;

	@Column(name = "loai_cong_viec")
	private String loaiCongViec;

	public LoaiCongViec(int id, String loaiCongViec) {
		super();
		this.id = id;
		this.loaiCongViec = loaiCongViec;
	}

	public LoaiCongViec() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(String loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
	}

}
