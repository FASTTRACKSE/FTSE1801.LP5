package fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="loai_cong_viec")
public class LoaiCongViecNghiaBT {

	@Id
	@Column(name = "ID_CV")
	@NotNull
	private int maCongViec;

	@Column(name = "loai_cong_viec")
	@NotEmpty
	private String loaiCongViec;

	public int getMaCongViec() {
		return maCongViec;
	}

	public void setMaCongViec(int maCongViec) {
		this.maCongViec = maCongViec;
	}

	public String getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(String loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
	}
	
}