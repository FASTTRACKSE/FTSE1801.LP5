package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name= "vendor")
public class Vendor {
	@Id
	@Column(name = "ma_vendor")
	@NotEmpty(message="Mã nhà cung cấp bắt buộc nhập!")
	@Size(min = 5, max= 10, message = "Mã nhà cung cấp từ 5 đến 10 ký tự.")
	private String idVendor;
	
	@NotEmpty(message="Tên nhà cung cấp bắt buộc nhập!")
	@Size(min = 5,  message = "Tên nhà cung cấp ít nhất 5 kí tự")
	@Column(name="ten_vendor")
	private String nameVendor;
	
	@Column(name="dia_chi")
	@NotEmpty(message="Vui lòng nhập địa chỉ")
	private String address;
	
	@Email
	@NotEmpty(message="Email nhà cung cấp bắt buộc nhập.")
	private String email;

	@Column(name="so_dien_thoai")
	@NotEmpty(message="Số điện thoại bắt buộc nhập")
	private String phone;
	
	@Column(name="is_delete")
	private int isDelete;
	
//	@ManyToMany(targetEntity = DuAn.class, mappedBy = "vendor", fetch = FetchType.EAGER)
//	private List<DuAn> duAn;

	public String getIdVendor() {
		return idVendor;
	}

	public void setIdVendor(String idVendor) {
		this.idVendor = idVendor;
	}

	public String getNameVendor() {
		return nameVendor;
	}

	public void setNameVendor(String nameVendor) {
		this.nameVendor = nameVendor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

//	public List<DuAn> getDuAn() {
//		return duAn;
//	}
//
//	public void setDuAn(List<DuAn> duAn) {
//		this.duAn = duAn;
//	}
	
	
}
