package fasttrackse.ftse1801.fbms.entity.quanlyduan;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@Column(name = "ma_contact")
	@NotEmpty(message = "Mã contact không được để trống !!!")
	private String maContact;
	
	@Column(name = "ten_contact")
	@NotEmpty(message = "Tên contact không được để trống !!!")
	private String tenContact;
	
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

	
	public String getMaContact() {
		return maContact;
	}

	public void setMaContact(String maContact) {
		this.maContact = maContact;
	}

	public String getTenContact() {
		return tenContact;
	}

	public void setTenContact(String tenContact) {
		this.tenContact = tenContact;
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
