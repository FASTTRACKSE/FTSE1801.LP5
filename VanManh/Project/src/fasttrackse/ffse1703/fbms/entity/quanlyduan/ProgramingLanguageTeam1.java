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
@Table(name = "ngon_ngu")
public class ProgramingLanguageTeam1 {
	@Id
	@NotEmpty(message="Mã ngôn ngữ không được rỗng!")
	@Column(name = "ma_ngon_ngu")
	 String maNn;
	
	@Column(name = "ten_ngon_ngu")
	@NotEmpty(message="Tên ngôn ngữ không được rỗng!")
	 String tenNn;
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="ngonNgu",targetEntity=DuAnTeam1.class)
	private Set<DuAnTeam1> duAn;
	
	@Column(name = "is_delete")
	 int isDelete;

	public Set<DuAnTeam1> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAnTeam1> duAn) {
		this.duAn = duAn;
	}

	public String getMaNn() {
		return maNn;
	}

	public void setMaNn(String maNn) {
		this.maNn = maNn;
	}

	public String getTenNn() {
		return tenNn;
	}

	public void setTenNn(String tenNn) {
		this.tenNn = tenNn;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
}
