package fasttrackse.ftse1801.fbms.entity.quantritailieu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai")
public class TrangThaiTaiLieu implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ma_trang_thai")
	private String maTrangThai;

	@Column(name = "ten_trang_thai")
	private String tenTrangThai;

	@Column(name = "isDelete")
	private Integer isDelete;

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}
