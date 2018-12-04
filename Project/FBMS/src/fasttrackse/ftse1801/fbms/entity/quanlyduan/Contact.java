package fasttrackse.ftse1801.fbms.entity.quanlyduan;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@Column(name = "ma_contact")
	@NotEmpty(message = "mã contact không được để rỗng !!!")
	private String maContact;
	
	@Column(name = "ten_contact")
	@NotEmpty(message = "tên contact không được để rỗng !!!")
	private String tenContact;
	
	@Column(name = "dia_chi")
	@NotEmpty(message = "địa chỉ không được để rỗng !!!")
	private String diachi;
	
	@Column(name = "so_dien_thoai")
	@NotEmpty(message = "số điện thoại không được để rỗng !!!")
	private String sdt;
	
	@Column(name = "email")
	@NotEmpty(message = "email không được để rỗng !!!")
	private String email;
	
	@Column(name = "is_delete")
	private String is_delete;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contact",cascade=CascadeType.MERGE)
	private Set<DuAn> duAn = new HashSet<DuAn>(0);


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


	public String getIs_delete() {
		return is_delete;
	}


	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}


	public Set<DuAn> getDuAn() {
		return duAn;
	}


	public void setDuAn(Set<DuAn> duAn) {
		this.duAn = duAn;
	}
	
	
}
