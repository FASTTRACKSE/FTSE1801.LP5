package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="vai_tro_thanh_vien")
public class VaiTroThanhVien {
	@Id
	@Column(name = "ma_vai_tro")
	@NotEmpty(message = "Mã vai trò không được để trống")
	private String maVaiTro;
	
	@Column(name="ten_vai_tro")
	@NotEmpty(message = "Tên vai trò không được để trống")
	private String tenVaiTro;
	
	@Column(name = "is_delete")
	private int isDelete;

	
	public String getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public String getTenVaiTro() {
		return tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}