package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="trang_thai")
public class TrangThai {
	@Id
	@Column(name = "ma_trang_thai")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTrangThai;
	
	@NotEmpty
	@Column(name="ten_trang_thai")
	private String tenTrangThai;
	
	@Column(name="isdelete")
	private int isDelete;

	public int getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	
}
