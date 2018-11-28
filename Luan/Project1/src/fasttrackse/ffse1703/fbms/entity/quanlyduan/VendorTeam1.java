package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "doi_tac")
public class VendorTeam1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty(message="Mã không được để trống !")
	@Column(name = "ma_doi_tac")
	private String mavd;
	
	@Column(name = "ten_doi_tac")
	@NotEmpty(message="Tên không được để trống !")
	 String tenvd;
	
	@Column(name = "dia_chi")
	@NotEmpty(message="Địa chỉ không được để trống !")
	 String diachi;
	
	@Column(name = "so_dien_thoai")
	@NotEmpty(message="Số điện thoại không được để trống !")
	 String sdt;
	
	@Column(name = "email")
	@NotEmpty(message="Email không được để trống !")
	 String email;

	
	@Column(name = "is_delete")
	 int isDelete;
	


	@ManyToMany(fetch = FetchType.EAGER,mappedBy="vendor",targetEntity=DuAnTeam1.class)
	private Set<DuAnTeam1> duAn;



	public Set<DuAnTeam1> getDuAn() {
		return duAn;
	}


	public void setDuAn(Set<DuAnTeam1> duAn) {
		this.duAn = duAn;
	}


	public String getMavd() {
		return mavd;
	}


	public void setMavd(String mavd) {
		this.mavd = mavd;
	}


	public String getTenvd() {
		return tenvd;
	}


	public void setTenvd(String tenvd) {
		this.tenvd = tenvd;
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


	public int getIs_delete() {
		return isDelete;
	}


	public void setIs_delete(int is_delete) {
		this.isDelete = is_delete;
	}
	

}
