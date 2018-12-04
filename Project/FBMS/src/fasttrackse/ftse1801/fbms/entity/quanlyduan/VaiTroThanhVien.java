package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="vai_tro_thanh_vien")
public class VaiTroThanhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ma_vai_tro")
	private int maVaiTro;
	
	@NotEmpty(message="Nhập tên vai trò")
	@Column(name="ten_vai_tro")
	private String tenVaiTro;
	
	private int isDelete;

	public int getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(int maVaiTro) {
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