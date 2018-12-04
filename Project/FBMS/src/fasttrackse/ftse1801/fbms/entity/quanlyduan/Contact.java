package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@Column(name = "ma_contact")
	private String maContact;
	
	@Column(name = "ten_contact")
	@NotEmpty(message = "Họ tên không được để trống")
	private String tenContact;

	@Column(name = "dia_chi")
	@NotEmpty(message = "địa chỉ không được để rỗng !!!")
	private String diachi;
	
	@Column(name = "so_dien_thoai")
	@Size(min = 10, max = 11)
	@NotEmpty(message = "số điện thoại không được để rỗng !!!")
	private String sdt;
	
	@Column(name = "email")
	@Email
	@NotEmpty(message = "email không được để rỗng !!!")
	private String email;
	
	@Column(name = "is_delete")
	private String isDelete;

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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}



}
