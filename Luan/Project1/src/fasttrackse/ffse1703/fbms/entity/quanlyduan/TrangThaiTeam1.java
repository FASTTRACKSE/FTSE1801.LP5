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
@Table(name = "tinh_trang")
public class TrangThaiTeam1 {
	@Id
	@Column(name = "ma_tinh_trang")
	@NotEmpty(message = "mã trạng thái không được để rỗng !!!")
	private String maTrangThai;
	
	@Column(name = "ten_tinh_trang")
	@NotEmpty(message = "tên trạng thái không được để rỗng !!!")
	private String tenTrangThai;
	
	@Column(name = "is_delete")
	private String is_delete;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trangThai",cascade=CascadeType.MERGE)
	private Set<DuAnTeam1> duAn = new HashSet<DuAnTeam1>(0);
	
	
	public Set<DuAnTeam1> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAnTeam1> duAn) {
		this.duAn = duAn;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	

}
