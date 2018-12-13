package fasttrackse.ftse1801.fbms.entity.quanlyduan;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "khach_hang")
public class KhachHang {
	@Id
	@Column(name = "ma_khach_hang")
	@NotEmpty(message = "Mã khách hàng không được để trống !!!")
	private String maKh;
	
	@Column(name = "ten_khach_hang")
	@NotEmpty(message = "Tên khách hàng không được để trống !!!")
	private String tenKh;
	
	@Column(name = "dia_chi")
	@NotEmpty(message = "Địa chỉ không được để trống !!!")
	private String diaChi;
	
	@Column(name = "so_dien_thoai")
	@NotEmpty(message = "Số điện thoại không được để trống !!!")
	private String soDienThoai;
	
	@Column(name = "email")
	@NotEmpty(message = "Email không được để trống !!!")
	private String email;
	
	@Column(name = "is_delete")
	private int isDelete;

	
	
	public String getMaKh() {
		return maKh;
	}

	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}	
	
}
