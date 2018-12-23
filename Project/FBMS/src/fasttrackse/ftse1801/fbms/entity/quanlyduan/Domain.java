package fasttrackse.ftse1801.fbms.entity.quanlyduan;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
=======
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
>>>>>>> parent of fef500d... update

@Entity
@Table(name = "nghiep_vu")
public class Domain {
<<<<<<< HEAD

	@Id
	@NotEmpty(message = "Mã Nghiệp vụ không được để trống!!")
	@Size(min = 5, max= 10, message = "Mã nghiệp vụ từ 5 đến 10 kí tự")
	@Column(name = "ma_nghiep_vu")
	private String maDomain;

	@NotEmpty(message = "Tên Nghiệp vụ không được để trống!!")
	@Size(min = 5, message = "Tên nghiệp vụ ít nhất 6 kí tự")
	@Column(name = "ten_nghiep_vu")
	private String tenDomain;

	@Column(name = "is_delete")
	private int isDelete;

	public String getMaDomain() {
		return maDomain;
	}

	public void setMaDomain(String maDomain) {
		this.maDomain = maDomain;
	}

	public String getTenDomain() {
		return tenDomain;
	}

	public void setTenDomain(String tenDomain) {
		this.tenDomain = tenDomain;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
=======
	@Id
	@Column(name = "ma_nghiep_vu")
	@NotEmpty(message = "mã nghiệp vụ không được để rỗng !!!")
	private String maNghiepVu;
	
	@Column(name = "ten_nghiep_vu")
	@NotEmpty(message = "tên nghiệp vụ không được để rỗng !!!")
	private String tenNghiepVu;
	
	@Column(name = "is_delete")
	private String is_delete;
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="domain",targetEntity=DuAn.class)
	private Set<DuAn> duAn;

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
>>>>>>> parent of fef500d... update
