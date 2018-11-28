package fasttrackse.ffse1703.fbms.entity.quanlyduan;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "nghiep_vu")
public class DomainTeam1 {
	
	@Id
	@Column(name = "ma_nghiep_vu")
	@NotEmpty(message = "mã nghiệp vụ không được để rỗng !!!")
	private String maNghiepVu;
	
	@Column(name = "ten_nghiep_vu")
	@NotEmpty(message = "tên nghiệp vụ không được để rỗng !!!")
	private String tenNghiepVu;
	
	@Column(name = "is_delete")
	private String is_delete;
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="domain",targetEntity=DuAnTeam1.class)
	private Set<DuAnTeam1> duAn;

	
	public Set<DuAnTeam1> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAnTeam1> duAn) {
		this.duAn = duAn;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	

	public String getMaNghiepVu() {
		return maNghiepVu;
	}

	public void setMaNghiepVu(String maNghiepVu) {
		this.maNghiepVu = maNghiepVu;
	}

	public String getTenNghiepVu() {
		return tenNghiepVu;
	}

	public void setTenNghiepVu(String tenNghiepVu) {
		this.tenNghiepVu = tenNghiepVu;
	}
	

}
