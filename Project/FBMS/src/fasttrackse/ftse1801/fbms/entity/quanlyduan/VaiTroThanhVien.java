package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
<<<<<<< HEAD
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
=======
@Table(name = "vai_tro_thanh_vien")
public class VaiTroThanhVien {
	@Id
	@NotEmpty(message="Mã không được để trống !")
	@Column(name = "ma_vai_tro")
	 String mavt;
	
	@Column(name = "ten_vai_tro")
	@NotEmpty(message="Tên không được để trống !")
	 String tenvt;
	
	@Column(name = "is_delete")
	 int isDelete;

	
	
	public String getMavt() {
		return mavt;
	}

	public void setMavt(String mavt) {
		this.mavt = mavt;
	}

	public String getTenvt() {
		return tenvt;
	}

	public void setTenvt(String tenvt) {
		this.tenvt = tenvt;
>>>>>>> parent of fef500d... update
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
<<<<<<< HEAD
	
	
}
=======
}
>>>>>>> parent of fef500d... update
