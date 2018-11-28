package fasttrackse.ffse1703.fbms.entity.quanlyduan;
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
@Table(name = "khach_hang")
public class KhachHangTeam1 {
	@Id
	@Column(name = "ma_khach_hang")
	@NotEmpty(message = "mã khách hàng không được để rỗng !!!")
	private String makh;
	
	@Column(name = "ten_khach_hang")
	@NotEmpty(message = "tên khách hàng không được để rỗng !!!")
	private String tenkh;
	
	@Column(name = "dia_chi")
	@NotEmpty(message = "địa chỉ không được để rỗng !!!")
	private String diachi;
	
	public Set<DuAnTeam1> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAnTeam1> duAn) {
		this.duAn = duAn;
	}

	@Column(name = "so_dien_thoai")
	@NotEmpty(message = "số điện thoại không được để rỗng !!!")
	 String sdt;
	
	@Column(name = "email")
	@NotEmpty(message = "email không được để rỗng !!!")
	 String email;
	
	@Column(name = "is_delete")
	String is_delete;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "khachHang",cascade=CascadeType.MERGE)
	private Set<DuAnTeam1> duAn = new HashSet<DuAnTeam1>(0);
	
	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}

	public KhachHangTeam1() {
		
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
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

}
