package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name="trang_thai_danh_gia")
@Entity
public class TrangThaiDanhGia implements Serializable {
	
	@Id
	@Column(name = "ma_trang_thai")
	private int maTrangThai;
	
	@Column(name = "ten_trang_thai")
	private String tenTrangThai;
	
	@Column(name = "is_delete")
	private int isDelete;

	public TrangThaiDanhGia() {
		super();
	}

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
