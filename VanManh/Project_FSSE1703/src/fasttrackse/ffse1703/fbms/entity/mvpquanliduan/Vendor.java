package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name= "qlda_vendor")
public class Vendor {
	@Id
	@Column(name = "id_vendor")
	@NotEmpty(message="MÃ£ nhÃ  cung cáº¥p báº¯t buá»™c nháº­p")
	@Size(min = 5, max= 10, message = "MÃ£ NhÃ  cung cáº¥p tá»« 5 Ä‘áº¿n 10 kÃ­ tá»±")
	private String idVendor;
	
	@NotEmpty(message="TÃªn nhÃ  cung cáº¥p báº¯t buá»™c nháº­p")
	@Size(min = 5,  message = "Tenen nhà cung cấp ít nhất 5 kí tự")
	@Column(name="name_vendor")
	private String nameVendor;
	
	@NotEmpty(message="Vui lÃ²ng nháº­p Ä‘á»‹a chá»‰")
	private String address;
	@Email
	@NotEmpty(message="Email cáº¥p báº¯t buá»™c nháº­p")
	private String email;

	
	@NotEmpty(message="Sá»‘ Ä‘iá»‡n thoáº¡i  báº¯t buá»™c nháº­p")
	private String phone;
	
	private int status;
	
	@ManyToMany(targetEntity = Projects.class, mappedBy = "vendor", fetch = FetchType.EAGER)
	private List<Projects> project;
	

	public List<Projects> getProject() {
		return project;
	}

	public void setProject(List<Projects> project) {
		this.project = project;
	}

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

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}