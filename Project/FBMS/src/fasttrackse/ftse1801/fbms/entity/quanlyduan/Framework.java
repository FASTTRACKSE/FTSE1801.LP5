package fasttrackse.ftse1801.fbms.entity.quanlyduan;

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
@Table(name = "framework")
public class Framework implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@NotEmpty
	@Column(name = "ma_framework")
	private String maFramework;
	
	@NotEmpty
	@Column(name = "ten_framework")
	private String tenFramework;

	@Column(name = "is_delete")
	private int isDelete;

	@ManyToMany(fetch = FetchType.EAGER,mappedBy="framework",targetEntity=DuAn.class)
	private Set<DuAn> duAn;


	public String getMaFramework() {
		return maFramework;
	}

	public void setMaFramework(String maFramework) {
		this.maFramework = maFramework;
	}

	public String getTenFramework() {
		return tenFramework;
	}

	public void setTenFramework(String tenFramework) {
		this.tenFramework = tenFramework;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Set<DuAn> getDuAn() {
		return duAn;
	}

	public void setDuAn(Set<DuAn> duAn) {
		this.duAn = duAn;
	}
	
	
}
