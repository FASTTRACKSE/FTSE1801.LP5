package fasttrackse.ftse1801.fbms.entity.quantridanhgia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ky_danh_gia")
@Entity
public class KyDanhGia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_ky_danh_gia")
	private String maKy;

	@Column(name = "ten_ky_danh_gia")
	private String tenKy;

	@Column(name = "isActive")
	private int isActive;

	@Column(name = "is_delete")
	private int isDelete;

	public String getMaKy() {
		return maKy;
	}

	public void setMaKy(String maKy) {
		this.maKy = maKy;
	}

	public String getTenKy() {
		return tenKy;
	}

	public void setTenKy(String tenKy) {
		this.tenKy = tenKy;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}