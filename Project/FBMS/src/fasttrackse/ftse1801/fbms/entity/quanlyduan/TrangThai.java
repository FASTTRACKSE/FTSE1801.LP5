package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="trang_thai_du_an")
public class TrangThai {
	@Id
	@Column(name = "ma_trang_thai")
	@NotEmpty(message = "Mã trạng thái không được để trống")
	private String maTrangThai;
	
	@Column(name = "ten_trang_thai")
	@NotEmpty(message = "Tên trạng thái không được để trống")
	private String tenTrangThai;
	
	@Column(name = "is_delete")
	private int isDelete;

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

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	
}
