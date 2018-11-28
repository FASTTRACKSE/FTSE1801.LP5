package fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loai_trang_thai")
public class TrangThaiNghiaBT {

	
	@Id
	@Column(name = "ID_TT")
	@NotNull
	private int maTrangThai;

	@Column(name = "loai_trang_thai")
	@NotEmpty
	private String trangThai;

	public int getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
