	package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "qlda_khach_hang")
public class KhachHang {
	@Id
	@Column(name = "id_customer")
	private String idKhachHang;
	@NotEmpty(message = "Họ tên không được để trống")
	private String fullname;
	@NotEmpty
	@Email	
	private String email;
	@Size(min = 10, max = 11)
	private String phone;
	@NotEmpty(message = "Giới tính không được để trống")
	private String gender;
	@NotEmpty(message ="Địa chỉ không được để trống")
	private String address;
	private int status;



	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}